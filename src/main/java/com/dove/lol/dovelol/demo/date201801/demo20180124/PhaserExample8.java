package com.dove.lol.dovelol.demo.date201801.demo20180124;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/1/24 23:10
 */
public class PhaserExample8 {

    public static void main(String[] args) throws InterruptedException {
        final Phaser phaser = new Phaser(3);

        new Thread(phaser::arriveAndAwaitAdvance).start();

        TimeUnit.SECONDS.sleep(3);

        System.out.println(phaser.isTerminated());

        phaser.forceTermination();

        System.out.println(phaser.isTerminated());

    }

}
