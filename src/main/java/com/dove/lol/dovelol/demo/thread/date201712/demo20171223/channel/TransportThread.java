package com.dove.lol.dovelol.demo.thread.date201712.demo20171223.channel;


import com.dove.lol.dovelol.demo.thread.date201712.demo20171223.channel.Request;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Dovelol
 * @date 2017/12/23 11:28
 */
public class TransportThread extends Thread {

    private final Channel channel;

    private static final Random random = new Random(System.currentTimeMillis());

    private static final AtomicInteger counter = new AtomicInteger(0);

    public TransportThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }


    @Override
    public void run() {
        for (int i = 0; true; i++) {
            Request request = new Request(getName(), counter.getAndIncrement());
            this.channel.put(request);
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
