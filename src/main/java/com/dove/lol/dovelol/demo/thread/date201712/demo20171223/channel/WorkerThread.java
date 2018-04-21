package com.dove.lol.dovelol.demo.thread.date201712.demo20171223.channel;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2017/12/23 11:06
 */
public class WorkerThread extends Thread {

    private final Channel channel;

    private static final Random random = new Random(System.currentTimeMillis());

    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true) {
            channel.take().execute();
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
