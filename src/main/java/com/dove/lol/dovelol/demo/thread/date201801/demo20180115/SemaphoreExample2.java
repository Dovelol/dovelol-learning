package com.dove.lol.dovelol.demo.thread.date201801.demo20180115;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/1/15 22:18
 */
public class SemaphoreExample2 {

    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 3; i++) {
            new Thread() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " in");
                    try {
                        semaphore.acquire(1);
                        System.out.println(Thread.currentThread().getName() + " get the semaphore");
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release(1);
                    }
                    System.out.println(Thread.currentThread().getName() + " out");
                }
            }.start();
        }

        while (true) {
            System.out.println("AP "+semaphore.availablePermits());
            System.out.println("QL "+semaphore.getQueueLength());
            TimeUnit.SECONDS.sleep(1);

        }
    }

}
