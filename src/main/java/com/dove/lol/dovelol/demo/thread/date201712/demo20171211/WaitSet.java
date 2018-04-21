package com.dove.lol.dovelol.demo.thread.date201712.demo20171211;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Dovelol
 * @date 2017/12/11 23:24
 */
public class WaitSet {

    private static final Object LOCK = new Object();

    public static void work() {
        synchronized (LOCK) {
            System.out.println("进入锁");
            try {
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("被唤醒后只执行");
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        new Thread(() -> {
//            work();
//        }).start();
//        TimeUnit.SECONDS.sleep(200);
//        synchronized (LOCK) {
//            LOCK.notify();
//        }

        IntStream.rangeClosed(0, 10).forEach(i -> {
            new Thread(String.valueOf(i)) {
                @Override
                public void run() {
                    synchronized (LOCK) {
                        System.out.println(i + "进入wait set");
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(i + "离开wait set");
                    }
                }
            }.start();
        });

        TimeUnit.SECONDS.sleep(5);

        IntStream.rangeClosed(0, 10).forEach(i -> {
            new Thread(String.valueOf(i)) {
                @Override
                public void run() {
                    synchronized (LOCK) {
                        try {
                            TimeUnit.SECONDS.sleep(1);
                            LOCK.notify();
                            System.out.println("要唤醒啦");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        });

//        synchronized (LOCK) {
//            LOCK.notifyAll();
//        }

    }
}
