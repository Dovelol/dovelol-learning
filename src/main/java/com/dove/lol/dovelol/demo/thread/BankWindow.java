package com.dove.lol.dovelol.demo.thread;

public class BankWindow extends Thread {

    private String windowName;

    public BankWindow(String windowName) {
        this.windowName = windowName;
    }

    private static final int MAX_NUMBER = 10000000;

    private static int CURRENT_NUMBER = 1;

    @Override
    public void run() {

        while (CURRENT_NUMBER <= MAX_NUMBER) {
            System.out.println("窗口：" + windowName + "当前的号码是：" + CURRENT_NUMBER);
            CURRENT_NUMBER = CURRENT_NUMBER + 1;
        }

    }
}
