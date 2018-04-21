package com.dove.lol.dovelol.demo.date201801.demo20180109;


import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Dovelol
 * @date 2018/1/9 22:12
 */
public class AtomicIntegerDetailTest {


    public static void main(String[] args) {
//        AtomicInteger i = new AtomicInteger();
//        System.out.println(i.get());
//        i = new AtomicInteger(10);
//        System.out.println(i.get());
//        i.set(100);
//        System.out.println(i.get());
//        i.lazySet(1000);
//        System.out.println(i.get());
//
//        final AtomicInteger getAndSet = new AtomicInteger(10);
//        int result = getAndSet.getAndAdd(10);
//        System.out.println(result);
//        System.out.println(getAndSet.get());



//        final AtomicInteger getAndSet2 = new AtomicInteger(0);
//        new Thread() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    int v = getAndSet2.addAndGet(1);
//                    System.out.println(v);
//                }
//            }
//        }.start();
//
//        new Thread() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    int v = getAndSet2.addAndGet(1);
//                    System.out.println(v);
//                }
//            }
//        }.start();

        final AtomicInteger i = new AtomicInteger(10);
        i.compareAndSet(12,20);
        System.out.println(i.get());
    }
}
