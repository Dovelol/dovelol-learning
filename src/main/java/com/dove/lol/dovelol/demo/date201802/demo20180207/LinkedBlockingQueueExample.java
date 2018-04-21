package com.dove.lol.dovelol.demo.date201802.demo20180207;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Dovelol
 * @date 2018/2/7 22:01
 */
public class LinkedBlockingQueueExample {

    public <T> LinkedBlockingQueue<T> create() {
        return new LinkedBlockingQueue<>();
    }


    public <T> LinkedBlockingQueue<T> create(int size) {
        return new LinkedBlockingQueue<>(size);
    }

}
