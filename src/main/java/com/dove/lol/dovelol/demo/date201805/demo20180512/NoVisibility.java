package com.dove.lol.dovelol.demo.date201805.demo20180512;

import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/5/12 21:52
 */
public class NoVisibility {

    private static boolean ready;

    private static int number;

    private static class ReaderThread extends Thread {

        @Override
        public void run() {
            while (!ready) {
                //int i = 0;
                //System.out.println(1);
                //Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(NoVisibility.ready);
        new ReaderThread().start();
        TimeUnit.MILLISECONDS.sleep(500);
        number = 22;
        ready = true;
    }


}
