package com.dove.lol.dovelol.demo.date201801.demo20180117;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author Dovelol
 * @date 2018/1/17 22:57
 */
public class ConditionExample3 {

    private static final ReentrantLock LOCK = new ReentrantLock();

    private static final Condition PRODUCE_COND = LOCK.newCondition();

    private static final Condition CONSUMER_COND = LOCK.newCondition();

    private static final LinkedList<Long> TIMESTAMP_POOL = new LinkedList<>();

    private static final int MAX_CAPACITY = 100;

    public static void main(String[] args) throws InterruptedException {
        IntStream.range(0, 20).forEach(ConditionExample3::beginProduce);
        IntStream.range(0, 3).forEach(ConditionExample3::beginConsumer);

//        for (; ; ) {
//            TimeUnit.SECONDS.sleep(5);
//            System.out.println("===================");
//            System.out.println("PRODUCE_COND.getWaitQueueLength" + LOCK.getWaitQueueLength(PRODUCE_COND));
//            System.out.println("CONSUMER_COND.getWaitQueueLength" + LOCK.getWaitQueueLength(CONSUMER_COND));
//            System.out.println("PRODUCE_COND.hasWaiters" + LOCK.hasWaiters(PRODUCE_COND));
//            System.out.println("CONSUMER_COND.hasWaiters" + LOCK.hasWaiters(CONSUMER_COND));
//        }
    }


    private static void beginConsumer(int i) {
        new Thread(() -> {
            for (; ; ) {
                consume();
                sleep(3);
            }
        }, "C" + i).start();
    }

    private static void beginProduce(int i) {
        new Thread(() -> {
            for (; ; ) {
                produce();
                sleep(2);
            }
        }, "P" + i).start();
    }

    private static void produce() {
        try {
            LOCK.lock();
            while (TIMESTAMP_POOL.size() >= MAX_CAPACITY) {
                PRODUCE_COND.await();
            }
            System.out.println("PRODUCE_COND.getWaitQueueLength" + LOCK.getWaitQueueLength(PRODUCE_COND));
            Long value = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "-P-" + value);
            TIMESTAMP_POOL.addLast(value);
            CONSUMER_COND.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

    private static void consume() {
        try {
            LOCK.lock();
            while (TIMESTAMP_POOL.isEmpty()) {
                CONSUMER_COND.await();
            }
            Long value = TIMESTAMP_POOL.removeFirst();
            System.out.println(Thread.currentThread().getName() + "-C-" + value);
            PRODUCE_COND.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

    private static void sleep(long sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
