package com.dove.lol.dovelol.demo.date201801.demo20180114;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/1/14 12:30
 */
public class CountDownLatchExample2 {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);

        new Thread() {
            @Override
            public void run() {
                System.out.println("Do some initial working.");
                try {
                    TimeUnit.SECONDS.sleep(1);
                    latch.await();
                    System.out.println("Do other working...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println("asyn prepare for some data");
                try {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("data prepare for done.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            }
        }.start();


        new Thread() {
            @Override
            public void run() {

                try {
                    latch.await();
                    System.out.println("release");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        //Thread.currentThread().join();

    }

}
