package com.dove.lol.dovelol.demo.thread.date201801.demo20180115;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/1/15 22:58
 */
public class SemaphoreExample4 {

    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(2);


        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    semaphore.drainPermits();
                    System.out.println(semaphore.availablePermits());
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphore.release(5);
            }
        };
        t1.start();

        TimeUnit.SECONDS.sleep(1);

        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }
        };
        t2.start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println(semaphore.hasQueuedThreads());
        System.out.println(semaphore.getQueueLength());
    }
}
