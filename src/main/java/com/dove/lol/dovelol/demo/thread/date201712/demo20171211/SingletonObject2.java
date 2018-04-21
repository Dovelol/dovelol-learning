package com.dove.lol.dovelol.demo.thread.date201712.demo20171211;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Dovelol
 * @date 2017/12/11 21:43
 */
public class SingletonObject2 {

    private static SingletonObject2 instance;

    private SingletonObject2() {

    }

    public static SingletonObject2 getInstance() {
        if (instance == null) {
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new SingletonObject2();
        }
        return instance;
    }


    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).forEach(i ->
                new Thread(() ->
                        System.out.println(SingletonObject2.getInstance())
                ).start()
        );
    }
}
