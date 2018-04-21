package com.dove.lol.dovelol.demo.thread.date201801.demo20180124;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Dovelol
 * @date 2018/1/24 22:58
 */
public class PhaserExample7 {

    public static void main(String[] args) throws InterruptedException {
//        final Phaser phaser = new Phaser(3);
//
//        Thread thread = new Thread(phaser::arriveAndAwaitAdvance);
//
//        thread.start();
//
//        System.out.println("============");
//
//
//        TimeUnit.SECONDS.sleep(10);
//
//        thread.interrupt();
//
//        System.out.println("====thread.interrupt====");

//        final Phaser phaser = new Phaser(3);
//
//        Thread thread = new Thread(){
//            @Override
//            public void run() {
//                try {
//                    phaser.awaitAdvanceInterruptibly(1);
//                    System.out.println("11111111");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        thread.start();
//
//        System.out.println("============");
//
//
//        TimeUnit.SECONDS.sleep(10);
//
//        thread.interrupt();
//
//        System.out.println("====thread.interrupt====");


        final Phaser phaser = new Phaser(3);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    phaser.awaitAdvanceInterruptibly(0, 10, TimeUnit.SECONDS);
                    System.out.println("11111111");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();



    }

}
