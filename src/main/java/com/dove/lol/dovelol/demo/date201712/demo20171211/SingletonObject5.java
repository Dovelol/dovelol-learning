package com.dove.lol.dovelol.demo.date201712.demo20171211;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Dovelol
 * @date 2017/12/11 22:09
 */
public class SingletonObject5 {

    private static volatile SingletonObject5 instance;

    private SingletonObject5() {

    }

    public static SingletonObject5 getInstance() {
        if (instance == null) {
            synchronized (SingletonObject5.class) {
                if (instance == null) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new SingletonObject5();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).forEach(i ->
                new Thread(() ->
                        System.out.println(SingletonObject5.getInstance())
                ).start()
        );
    }

}
