package com.dove.lol.dovelol.demo.date201712.demo20171220.producerconsumer;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Dovelol
 * @date 2017/12/20 21:58
 */
public class ProducerThread extends Thread {

    private final MessageQueue messageQueue;

    private static final Random random = new Random(System.currentTimeMillis());

    private static final AtomicInteger counter = new AtomicInteger(0);

    public ProducerThread(MessageQueue messageQueue, int sqe) {
        super("PRODUCER-" + sqe);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = new Message("Message-" + counter.getAndIncrement());
                messageQueue.put(message);
                System.out.println(Thread.currentThread().getName() + " put message " + message.getData());
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
