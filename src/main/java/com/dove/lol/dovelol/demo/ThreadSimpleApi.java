package com.dove.lol.dovelol.demo;

import ch.qos.logback.core.util.TimeUtil;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class ThreadSimpleApi {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Optional.of("Hello").ifPresent(System.out::println);
            try {
                Optional.of(Thread.currentThread()).ifPresent(System.out::println);
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t.start();
        Optional.of(t.getName()).ifPresent(System.out::println);
        Optional.of(t.getId()).ifPresent(System.out::println);
        Optional.of(t.getPriority()).ifPresent(System.out::println);



    }
}
