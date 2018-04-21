package com.dove.lol.dovelol.demo.date201801.demo20180116;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dovelol
 * @date 2018/1/16 22:48
 */
public class ConditionExample1 {

    private static final ReentrantLock LOCK = new ReentrantLock();

    private final static Condition CONDITION = LOCK.newCondition();

    private static int data = 0;

    private static volatile boolean noUse = false;

    private static void buildData() {
        try {
            LOCK.lock();//synchronized key word
            //System.out.println("provider " + noUse);
            while (noUse) {
                CONDITION.await(); //monitor.wait()
            }
            data++;
            Optional.of("P:" + data).ifPresent(System.out::println);
            TimeUnit.SECONDS.sleep(1);
            noUse = true;
            CONDITION.signal();//monitor.notify()
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();//synchronized end
        }
    }

    private static void useData() {
        try {
            LOCK.lock();
            //System.out.println("consumer " + noUse);
            while (!noUse) {
                CONDITION.await();
            }
            Optional.of("C:" + data).ifPresent(System.out::println);
            TimeUnit.SECONDS.sleep(1);
            noUse = false;
            CONDITION.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    buildData();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    useData();
                }
            }
        }.start();
    }

}
