package com.dove.lol.dovelol.demo.thread.date201801.demo20180115;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Dovelol
 * @date 2018/1/15 21:47
 */
public class ExchangerExample3 {

    public static void main(String[] args) {
        final Exchanger<Integer> exchanger = new Exchanger<>();

        new Thread() {
            @Override
            public void run() {
                AtomicReference<Integer> value = new AtomicReference<>(1);
                try {
                    while (true) {
                        value.set(exchanger.exchange(value.get()));
                        System.out.println("Thread A has Value :" + value.get());
                        TimeUnit.SECONDS.sleep(3);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                AtomicReference<Integer> value = new AtomicReference<>(2);
                try {
                    while (true) {
                        value.set(exchanger.exchange(value.get()));
                        System.out.println("Thread B has Value :" + value.get());
                        TimeUnit.SECONDS.sleep(2);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


}
