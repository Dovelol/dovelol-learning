package com.dove.lol.dovelol.demo.date202004.demo20200422;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Dovelol
 * @date 2020/4/23 0:01
 */
public class AtomicIntegerDemo {

    public static void main(String[] args) {
        AtomicInteger requestId = new AtomicInteger(2147483647);
        System.out.println(requestId);
        int i = requestId.getAndIncrement();
        System.out.println(i);

        i = requestId.getAndIncrement();
        System.out.println(i);

        i = requestId.getAndIncrement();
        System.out.println(i);
    }

}
