package com.dove.lol.dovelol.demo.thread.date201801.demo20180114;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Dovelol
 * @date 2018/1/14 19:24
 */
public class ExchangerExample1 {

    public static void main(String[] args) {
        final Exchanger<String> exchanger = new Exchanger<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start.");
                try {
                    String resulte = exchanger.exchange("I am from T-A", 10, TimeUnit.SECONDS);
                    System.out.println(Thread.currentThread().getName() + " Get value from " + resulte);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    System.out.println("Time out");
                }
                System.out.println(Thread.currentThread().getName() + " end.");

            }
        }, "=====A").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start.");
                try {
                    //TimeUnit.SECONDS.sleep(20);
                    String resulte = exchanger.exchange("I am from T-B");
                    System.out.println(Thread.currentThread().getName() + " Get value from " + resulte);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " end.");

            }
        }, "=====B").start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start.");
                try {
                    //TimeUnit.SECONDS.sleep(20);
                    String resulte = exchanger.exchange("I am from T-C");
                    System.out.println(Thread.currentThread().getName() + " Get value from " + resulte);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " end.");

            }
        }, "=====C").start();
    }

}
