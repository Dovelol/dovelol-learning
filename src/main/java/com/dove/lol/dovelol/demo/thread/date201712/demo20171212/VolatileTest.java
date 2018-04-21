package com.dove.lol.dovelol.demo.thread.date201712.demo20171212;

import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2017/12/12 22:32
 */
public class VolatileTest {

    private static volatile int INIT_VALUE = 0;

    private static final int MAX_LIMIT = 5;

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (localValue < MAX_LIMIT) {
                if (localValue != INIT_VALUE) {
                    System.out.printf("The value updated to [%d] \n", INIT_VALUE);
                    localValue = INIT_VALUE;
                }
            }

        }, "Read").start();

        new Thread("Write") {
            @Override
            public void run() {
                int localValue = INIT_VALUE;
                while (localValue < MAX_LIMIT) {
                    System.out.printf("Update the value to [%d] \n", ++localValue);
                    INIT_VALUE = localValue;
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }

}
