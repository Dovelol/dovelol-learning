package com.dove.lol.dovelol.demo;

import java.util.concurrent.TimeUnit;

public class BankWindowRunnable implements Runnable {

    private static final int MAX_NUMBER = 1000;

    private int CURRENT_NUMBER = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (CURRENT_NUMBER > MAX_NUMBER) {
                    break;
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "当前号码是：" + CURRENT_NUMBER++);
            }

        }
    }


}
