package com.dove.lol.dovelol.demo.thread.date201803.demo20180303;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @author Dovelol
 * @date 2018/3/3 18:29
 */
public class LinkedTransferQueueExample {

    public static <T> LinkedTransferQueue<T> create() {
        return new LinkedTransferQueue<>();
    }
}
