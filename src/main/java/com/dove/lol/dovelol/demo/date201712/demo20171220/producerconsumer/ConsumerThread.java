package com.dove.lol.dovelol.demo.date201712.demo20171220.producerconsumer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2017/12/20 22:05
 */
public class ConsumerThread extends Thread {

    private final MessageQueue messageQueue;

    private static final Random random = new Random(System.currentTimeMillis());

    public ConsumerThread(MessageQueue messageQueue, final int sql) {
        super("CONSUMER-" + sql);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = messageQueue.take();
                System.out.println(Thread.currentThread().getName() + " take handler message " + message.getData());
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
