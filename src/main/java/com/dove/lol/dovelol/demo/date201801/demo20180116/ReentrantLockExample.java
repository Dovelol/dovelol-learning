package com.dove.lol.dovelol.demo.date201801.demo20180116;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dovelol
 * @date 2018/1/16 21:39
 */
public class ReentrantLockExample {

    private static final ReentrantLock LOCK = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
//        IntStream.range(0,2).forEach(i->{
//            new Thread(){
//                @Override
//                public void run() {
//                    needLockBySync();
//                }
//            }.start();
//        });


        Thread thread1 = new Thread(() -> needLock());
        thread1.start();

        TimeUnit.SECONDS.sleep(1);

        Thread thread2 = new Thread(() -> needLock());
        thread2.start();

        TimeUnit.SECONDS.sleep(1);
        Optional.of(LOCK.getQueueLength()).ifPresent(System.out::println);
        Optional.of(LOCK.hasQueuedThread(thread2)).ifPresent(System.out::println);
        Optional.of(LOCK.hasQueuedThreads()).ifPresent(System.out::println);

    }

    private static void testUnInterruptibly() {
        try {
            LOCK.lock();
            Optional.of("The thread-" + Thread.currentThread().getName() + " get lock.").ifPresent(System.out::println);
            //TimeUnit.SECONDS.sleep(10);
            while (true) {

            }
        } finally {
            LOCK.unlock();
        }
    }

    private static void needLock() {
        try {
            LOCK.lock();
            Optional.of(LOCK.getHoldCount()).ifPresent(System.out::println);
            Optional.of("The thread-" + Thread.currentThread().getName() + " get lock.").ifPresent(System.out::println);
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

    private static void needLockBySync() {
        synchronized (ReentrantLockExample.class) {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
