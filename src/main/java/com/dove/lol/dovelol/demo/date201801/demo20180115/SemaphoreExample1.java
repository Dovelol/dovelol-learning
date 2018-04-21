package com.dove.lol.dovelol.demo.date201801.demo20180115;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/1/15 21:55
 */
public class SemaphoreExample1 {

    public static void main(String[] args) {

        final SemaphoreLock lock = new SemaphoreLock();
        for (int i = 0; i < 2; i++) {

            new Thread() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + " is Running");
                        lock.lock();
                        System.out.println(Thread.currentThread().getName() + " get the semaphore");
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                    System.out.println(Thread.currentThread().getName() + " released the semaphore");
                }
            }.start();
        }


    }

    static class SemaphoreLock {
        private final Semaphore semaphore = new Semaphore(2);

        public void lock() throws InterruptedException {
            semaphore.acquire();
        }

        public void unlock() {
            semaphore.release();
        }
    }

}
