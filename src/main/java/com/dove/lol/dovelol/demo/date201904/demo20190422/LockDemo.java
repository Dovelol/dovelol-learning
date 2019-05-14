package com.dove.lol.dovelol.demo.date201904.demo20190422;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dovelol
 * @date 2019/4/22 8:55
 */
public class LockDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
    }


}
