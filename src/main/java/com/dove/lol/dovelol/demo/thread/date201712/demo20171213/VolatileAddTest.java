package com.dove.lol.dovelol.demo.thread.date201712.demo20171213;

import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2017/12/13 23:03
 */
public class VolatileAddTest {

    private static volatile int init_value = 0;

    private static final int MAX_VALUE = 50;

    public static void main(String[] args) {
        new Thread(() -> {
            while (init_value < MAX_VALUE) {
                System.out.println("Thread-1:" + ++init_value);
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-1").start();

        new Thread(() -> {
            while (init_value < MAX_VALUE) {
                System.out.println("Thread-2:" + ++init_value);
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-2").start();
    }

}
