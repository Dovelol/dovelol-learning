package com.dove.lol.dovelol.demo.thread;

public class BankWindowTest {

    private static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
//        BankWindow bankWindow1 = new BankWindow("1号窗口");
//        bankWindow1.start();
//        BankWindow bankWindow2 = new BankWindow("2号窗口");
//        bankWindow2.start();
//        BankWindow bankWindow3 = new BankWindow("3号窗口");
//        bankWindow3.start();

        final BankWindowRunnable bankWindowRunnable = new BankWindowRunnable();
        final Runnable runnable = () -> {
            int CURRENT_NUMBER = 1;
            while (CURRENT_NUMBER <= MAX_NUMBER) {
                System.out.println(Thread.currentThread() + "当前号码是：" + CURRENT_NUMBER++);
            }
        };
        final Runnable runnable1 = new Runnable() {
            int CURRENT_NUMBER = 1;

            @Override
            public void run() {
                while (CURRENT_NUMBER <= MAX_NUMBER) {
                    System.out.println(Thread.currentThread() + "当前号码是：" + CURRENT_NUMBER++);
                }
            }
        };

        Thread thread1 = new Thread(bankWindowRunnable, "1号窗口");
        Thread thread2 = new Thread(bankWindowRunnable, "2号窗口");
        Thread thread3 = new Thread(bankWindowRunnable, "3号窗口");
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
