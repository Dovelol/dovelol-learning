package com.dove.lol.dovelol.demo.date202104.demo20210410;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dovelol
 * @date 2021/4/10 12:08
 */
public class AqsDemo {

    private static ReentrantLock lock = new ReentrantLock(false);

    public static void main(String[] args) {
        lock.lock();
        //lock.tryLock();
        try {
            System.out.println("lock");
        }finally {
            lock.unlock();
        }
    }
}
