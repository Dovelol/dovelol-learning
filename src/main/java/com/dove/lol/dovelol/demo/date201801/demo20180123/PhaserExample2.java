package com.dove.lol.dovelol.demo.date201801.demo20180123;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Dovelol
 * @date 2018/1/23 22:56
 */
public class PhaserExample2 {

    public static void main(String[] args) {
        final Phaser phaser = new Phaser(5);
        System.out.println(new Random().nextInt(5));
        for (int i = 1; i < 6; i++) {
            new Athletes(i, phaser).start();
        }


    }

    static class Athletes extends Thread {

        private final int no;

        private final Phaser phaser;

        public Athletes(int no, Phaser phaser) {
            this.no = no;
            this.phaser = phaser;
        }

        @Override
        public void run() {
            try {
                System.out.println(no + ":start running.");
                TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                System.out.println(no + ":end running.");
                System.out.println("getPhase()=>" + phaser.getPhase());

                phaser.arriveAndAwaitAdvance();

                System.out.println(no + ":start bicycle.");
                TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                System.out.println(no + ":end bicycle.");
                System.out.println("getPhase()=>" + phaser.getPhase());

                phaser.arriveAndAwaitAdvance();

                System.out.println(no + ":start long jump.");
                TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                System.out.println(no + ":end long jump.");
                System.out.println("getPhase()=>" + phaser.getPhase());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
