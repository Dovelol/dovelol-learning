package com.dove.lol.dovelol.demo.thread.date201712.demo20171216.observer2;

import java.util.Arrays;

/**
 * @author Dovelol
 * @date 2017/12/16 11:04
 */
public class ThreadLifeCycleClient {

    public static void main(String[] args) {
        new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList("1", "2"));
    }

}
