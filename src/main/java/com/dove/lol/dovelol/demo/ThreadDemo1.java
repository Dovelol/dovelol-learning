package com.dove.lol.dovelol.demo;

public class ThreadDemo1 {

    private static ThreadDemo1 threadDemo1 = new ThreadDemo1();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread() + ":" + i);
            }
            synchronized (threadDemo1) {
                threadDemo1.notifyAll();
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (threadDemo1) {
                try {
                    threadDemo1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread() + ":" + i);
            }

        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread() + ":" + i);
        }


    }
}
