package com.dove.lol.dovelol.demo.date201803.demo20180303;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/3/3 9:36
 */
public class SynchronousQueueExample {

    public static  <T> SynchronousQueue<T> create() {
        return new SynchronousQueue<>();
    }
}
