package com.dove.lol.dovelol.demo.date201803.demo20180303;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/3/3 10:05
 */
public class DelayQueueExample {

    public static <T extends Delayed> DelayQueue<T> create() {
        return new DelayQueue<>();
    }





}
