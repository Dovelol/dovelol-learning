package com.dove.lol.dovelol.demo.thread.date201801.demo20180124;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/1/23 22:56
 */
public class PhaserExample3 {

    public static void main(String[] args) {
        final Phaser phaser = new Phaser(5);
        System.out.println(new Random().nextInt(5));
        for (int i = 1; i < 5; i++) {
            new Athletes(i, phaser).start();
        }
        new InjuredAthletes(5, phaser).start();

    }

    static class InjuredAthletes extends Thread {
        private final int no;

        private final Phaser phaser;

        public InjuredAthletes(int no, Phaser phaser) {
            this.no = no;
            this.phaser = phaser;
        }

        @Override
        public void run() {
            try {
                sport(phaser, no + ":start running.", no + ":end running.", "getPhase()=>" + phaser.getPhase());

                sport(phaser, no + ":start bicycle.", no + ":end bicycle.", "getPhase()=>" + phaser.getPhase());

                System.out.println("oh shit.");
                phaser.arriveAndDeregister();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
                sport(phaser, no + ":start running.", no + ":end running.", "getPhase()=>" + phaser.getPhase());

                sport(phaser, no + ":start bicycle.", no + ":end bicycle.", "getPhase()=>" + phaser.getPhase());

                sport(phaser, no + ":start long jump.", no + ":end long jump.", "getPhase()=>" + phaser.getPhase());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static void sport(Phaser phaser, String x, String x2, String x3) throws InterruptedException {
        System.out.println(x);
        TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        System.out.println(x2);
        System.out.println(x3);

        phaser.arriveAndAwaitAdvance();
    }

}
