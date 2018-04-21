package com.dove.lol.dovelol.demo.date201801.demo20180114;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/1/14 12:54
 */
public class CountDownLatchExample3 {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(2);

        final Thread mainThread = Thread.currentThread();


        new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // latch.countDown();
                mainThread.interrupt();
            }
        }.start();


        latch.await(2000, TimeUnit.MILLISECONDS);
        System.out.println("========");


    }

}
