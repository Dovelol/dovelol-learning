package com.dove.lol.dovelol.demo.thread.date201801.demo20180111;

import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/1/11 22:03
 */
public class AtomicIntegerDetailsTest2 {

    private static final CompareAndSetLock LOCK = new CompareAndSetLock();

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        doSomething2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (GetLockException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }

    }

    private static void doSomething() throws InterruptedException {
        synchronized (AtomicIntegerDetailsTest2.class) {
            System.out.println(Thread.currentThread().getName() + " get the lock.");
            TimeUnit.SECONDS.sleep(500);

        }
    }

    private static void doSomething2() throws InterruptedException, GetLockException {
        try {
            LOCK.tryLock();
            System.out.println(Thread.currentThread().getName() + " get the lock.");
            TimeUnit.SECONDS.sleep(500);

        } finally {
            LOCK.unlock();
        }

    }

}
