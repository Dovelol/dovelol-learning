package com.dove.lol.dovelol.demo.date201903.demo20190324;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dovelol
 * @date 2019/3/24 22:21
 */
public class TestDemo {

    public static void main(String[] args) {
        long i = foo();
        System.out.println(i);


        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();
    }

    static long foo() {
        long i = 0;
        while (i < 1_000_000_000) {
            i++;
        }
        return i;
    }


}
