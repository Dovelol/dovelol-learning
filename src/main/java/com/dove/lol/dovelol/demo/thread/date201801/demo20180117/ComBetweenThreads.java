package com.dove.lol.dovelol.demo.thread.date201801.demo20180117;

/**
 * @author Dovelol
 * @date 2018/1/17 22:24
 */
public class ComBetweenThreads {

    private static int data = 0;

    private static boolean noUser = true;

    private static final Object MONITOR = new Object();

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    buildData();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    useData();
                }
            }
        }.start();
    }

    private static void buildData() {
        synchronized (MONITOR) {
            while (noUser) {
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            data++;
            System.out.println("P=>" + data);
            noUser = true;
            MONITOR.notify();
        }
    }


    private static void useData() {
        synchronized (MONITOR) {
            while (!noUser) {
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("C=>" + data);
            noUser = false;
            MONITOR.notify();

        }
    }

}
