package com.dove.lol.dovelol.demo.date201712.demo20171220.producerconsumer;

import java.util.LinkedList;

/**
 * @author Dovelol
 * @date 2017/12/20 21:50
 */
public class MessageQueue {

    private final LinkedList<Message> queue;

    private static final int DEFAULT_MAX_LIMIT = 100;

    private final int limit;

    public MessageQueue() {
        this(DEFAULT_MAX_LIMIT);
    }

    public MessageQueue(final int limit) {
        this.queue = new LinkedList<>();
        this.limit = limit;
    }

    public void put(final Message message) throws InterruptedException {
        synchronized (queue) {
            while (queue.size() >= limit) {
                queue.wait();
            }
            queue.addLast(message);
            queue.notifyAll();
        }
    }


    public Message take() throws InterruptedException {
        synchronized (queue) {
            while (queue.isEmpty()) {
                queue.wait();
            }
            Message message = queue.removeFirst();
            queue.notifyAll();
            return message;
        }
    }

    public int getMaxLimit() {
        return limit;
    }

    public int getMessageSize() {
        synchronized (queue) {
            return queue.size();
        }
    }
}
