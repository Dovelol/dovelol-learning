package com.dove.lol.dovelol.demo.thread.date201712.demo20171217.future;

/**
 * @author Dovelol
 * @date 2017/12/17 12:04
 */
public interface Future<T> {

    T get() throws InterruptedException;
}
