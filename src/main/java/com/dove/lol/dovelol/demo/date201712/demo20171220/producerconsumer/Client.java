package com.dove.lol.dovelol.demo.date201712.demo20171220.producerconsumer;

import java.util.stream.IntStream;

/**
 * @author Dovelol
 * @date 2017/12/20 22:08
 */
public class Client {
    public static void main(String[] args) {
        final MessageQueue messageQueue = new MessageQueue();
        IntStream.rangeClosed(1, 20).forEach((i) -> {
            new ProducerThread(messageQueue, i).start();
        });
        IntStream.rangeClosed(1, 50).forEach((i) -> {
            new ConsumerThread(messageQueue, i).start();
        });
    }
}
