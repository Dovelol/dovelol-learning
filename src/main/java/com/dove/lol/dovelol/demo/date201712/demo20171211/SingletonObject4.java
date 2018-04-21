package com.dove.lol.dovelol.demo.date201712.demo20171211;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Dovelol
 * @date 2017/12/11 21:49
 */
public class SingletonObject4 {

    private static SingletonObject4 instance;

    private SingletonObject4() {

    }

    public static SingletonObject4 getInstance() {
        if (instance == null) {
            synchronized (SingletonObject4.class) {
                if (instance == null) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new SingletonObject4();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).forEach(i ->
                new Thread(() ->
                        System.out.println(SingletonObject4.getInstance().toString())
                ).start()
        );
    }
}
