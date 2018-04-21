package com.dove.lol.dovelol.demo.thread.date201712.demo20171223;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2017/12/23 8:51
 */
public class CounterIncrement extends Thread {

    private volatile boolean terminated = false;

    private int counter = 0;

    private final Random random = new Random(System.currentTimeMillis());

    @Override
    public void run() {
        try {
            while (!terminated) {
                System.out.println(Thread.currentThread().getName() + " " + counter++);
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.clean();
        }
    }

    private void clean() {
        System.out.println("do some clean work." + counter);
    }


    public void close() {
        this.terminated = true;
        this.interrupt();
    }
}
