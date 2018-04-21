package com.dove.lol.dovelol.demo.date201801.demo20180115;

import java.util.concurrent.Exchanger;

/**
 * @author Dovelol
 * @date 2018/1/14 20:31
 */
public class ExchangerExample2 {

    public static void main(String[] args) {
        final Exchanger<Object> exchanger = new Exchanger<>();

        new Thread() {
            @Override
            public void run() {
                Object obj = new Object();
                System.out.println("A will send the object " + obj);
                try {
                    Object o = exchanger.exchange(obj);
                    System.out.println("A recieved the object " + o);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                Object obj = new Object();
                System.out.println("B will send the object " + obj);
                try {
                    Object o = exchanger.exchange(obj);
                    System.out.println("B recieved the object " + o);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

}
