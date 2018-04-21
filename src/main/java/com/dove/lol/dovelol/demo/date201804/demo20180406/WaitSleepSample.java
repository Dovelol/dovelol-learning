package com.dove.lol.dovelol.demo.date201804.demo20180406;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/4/6 11:27
 */
public class WaitSleepSample {

    private static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                synchronized (LOCK) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ": before wait");
                        LOCK.wait();
                        System.out.println(Thread.currentThread().getName() + ": after wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, i + "").start();
            TimeUnit.MILLISECONDS.sleep(500);
        }

        TimeUnit.SECONDS.sleep(5);
        for (int i = 0; i < 4; i++) {
            synchronized (LOCK) {
                LOCK.notify();
            }

        }

    }
}
