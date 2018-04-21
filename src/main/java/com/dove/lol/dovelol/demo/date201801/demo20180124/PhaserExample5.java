package com.dove.lol.dovelol.demo.date201801.demo20180124;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/1/24 22:28
 */
public class PhaserExample5 {

    private static final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
//        final Phaser phaser = new Phaser(3);
//        new Thread(phaser::arrive).start();
//
//        TimeUnit.SECONDS.sleep(4);


        final Phaser phaser = new Phaser(5);
        for (int i = 0; i < 4; i++) {
            new ArriveTask(phaser, i).start();
        }

        phaser.arriveAndAwaitAdvance();

        System.out.println("over.");


    }


    static class ArriveTask extends Thread {
        private final Phaser phaser;

        public ArriveTask(Phaser phaser, int no) {
            super(String.valueOf(no));
            this.phaser = phaser;
        }

        @Override
        public void run() {
            System.out.println(getName() + " start working.");
            sleepSeconds();
            System.out.println(getName() + " the phase one is running.");
            phaser.arrive();

            sleepSeconds();

            System.out.println(getName() + " keep to do other thing.");


        }
    }

    private static void sleepSeconds() {
        try {
            TimeUnit.SECONDS.sleep(random.nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
