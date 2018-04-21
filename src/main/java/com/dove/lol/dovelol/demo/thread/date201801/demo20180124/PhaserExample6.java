package com.dove.lol.dovelol.demo.thread.date201801.demo20180124;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Dovelol
 * @date 2018/1/24 22:44
 */
public class PhaserExample6 {

    /**
     * awaitAdvance
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        final Phaser phaser = new Phaser(6);

//        new Thread(() -> phaser.awaitAdvance(6)).start();
//
//        TimeUnit.SECONDS.sleep(3);
//
//        System.out.println(phaser.getArrivedParties());

        IntStream.rangeClosed(0, 5).boxed().map(integer -> phaser).forEach(AwaitAdvanceTask::new);

        phaser.awaitAdvance(5);
        System.out.println("========");

    }

    static class AwaitAdvanceTask extends Thread {
        private final Phaser phaser;

        public AwaitAdvanceTask(Phaser phaser) {
            this.phaser = phaser;
            start();
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            phaser.arriveAndAwaitAdvance();

            System.out.println(getName() + " finish work.");
        }
    }


}
