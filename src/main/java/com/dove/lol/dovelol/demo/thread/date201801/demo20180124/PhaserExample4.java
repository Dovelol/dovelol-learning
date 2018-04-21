package com.dove.lol.dovelol.demo.thread.date201801.demo20180124;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/1/24 21:47
 */
public class PhaserExample4 {

    public static void main(String[] args) throws InterruptedException {
        final Phaser phaser = new Phaser(1);

//        phaser.arriveAndAwaitAdvance();
//
//        System.out.println(phaser.getPhase());
//
//        phaser.arriveAndAwaitAdvance();
//
//        System.out.println(phaser.getPhase());
//
//        phaser.arriveAndAwaitAdvance();
//
//        System.out.println(phaser.getPhase());


//        System.out.println(phaser.getRegisteredParties());
//        phaser.register();
//
//
//        System.out.println(phaser.getRegisteredParties());
//        phaser.register();
//
//
//        System.out.println(phaser.getRegisteredParties());

//        System.out.println(phaser.getArrivedParties());
//        System.out.println(phaser.getUnarrivedParties());
//
//        phaser.bulkRegister(10);
//        System.out.println(phaser.getRegisteredParties());
//        System.out.println(phaser.getArrivedParties());
//        System.out.println(phaser.getUnarrivedParties());
//
//        new Thread(phaser::arriveAndAwaitAdvance).start();
//
//        TimeUnit.SECONDS.sleep(1);
//
//        System.out.println("===========");
//        System.out.println(phaser.getRegisteredParties());
//        System.out.println(phaser.getArrivedParties());
//        System.out.println(phaser.getUnarrivedParties());


        final Phaser phaser2 = new Phaser(2) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                return false;
            }
        };

        new OnAdvanceTask("Dovelol", phaser2).start();
        new OnAdvanceTask("Dovey", phaser2).start();

        TimeUnit.SECONDS.sleep(2);
        System.out.println(phaser2.getArrivedParties());
        System.out.println(phaser2.getUnarrivedParties());

    }

    static class OnAdvanceTask extends Thread {

        private final Phaser phaser;

        public OnAdvanceTask(String name, Phaser phaser) {
            super(name);
            this.phaser = phaser;
        }

        @Override
        public void run() {

            System.out.println(getName() + " I am start and the phase" + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();
            System.out.println(getName() + " I am end.");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (getName().equals("Dovelol")) {
                System.out.println(getName() + " I am start and the phase" + phaser.getPhase());
                phaser.arriveAndAwaitAdvance();
                System.out.println(getName() + " I am end.");
            }
        }
    }

}
