package com.dove.lol.dovelol.demo.date201903.demo20190321;

import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2019/3/21 22:27
 */
public class SynchronizedDemo {

    final Object object = new Object();

    public static void main(String[] args) {
        SynchronizedDemo demo1 = new SynchronizedDemo();
        new Thread(demo1::test).start();
        new Thread(demo1::test2).start();
    }

    public void test() {
        System.out.println("进入test方法");
        synchronized (SynchronizedDemo.class) {
            System.out.println("进入test同步代码块");
            try {
                TimeUnit.SECONDS.sleep(10);
                synchronized (object){
                    System.out.println("进入test-1同步代码块");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void test2() {
        System.out.println("进入test2方法");
        synchronized (object) {
            System.out.println("进入test2同步代码块");
            try {
                TimeUnit.SECONDS.sleep(10);
                synchronized (SynchronizedDemo.class) {
                    System.out.println("进入test2-1同步代码块");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
