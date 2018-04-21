package com.dove.lol.dovelol.demo.thread;

import java.util.concurrent.TimeUnit;

public class SynchronizedTest {

    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (LOCK){
                    try {
                        TimeUnit.SECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };


        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
    }
}
