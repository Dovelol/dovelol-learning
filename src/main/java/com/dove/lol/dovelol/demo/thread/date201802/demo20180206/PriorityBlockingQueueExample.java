package com.dove.lol.dovelol.demo.thread.date201802.demo20180206;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Dovelol
 * @date 2018/2/6 22:09
 */
public class PriorityBlockingQueueExample {

    public <T> PriorityBlockingQueue<T> create(int size) {
        return new PriorityBlockingQueue<>(size);
    }

    public <T> PriorityBlockingQueue<T> create(int size, Comparator<T> comparator) {
        return new PriorityBlockingQueue<>(size, comparator);
    }


}
