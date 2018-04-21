package com.dove.lol.dovelol.demo.thread.date201801.demo20180113;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author Dovelol
 * @date 2018/1/13 13:08
 */
public class AtomicStampedReferenceTest {

    private static final AtomicStampedReference<Integer> ATOMIC = new AtomicStampedReference<Integer>(100, 0);

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    boolean b = ATOMIC.compareAndSet(100, 101, ATOMIC.getStamp(), ATOMIC.getStamp() + 1);
                    System.out.println(b);
                    b = ATOMIC.compareAndSet(101, 100, ATOMIC.getStamp(), ATOMIC.getStamp() + 1);
                    System.out.println(b);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread() {
            @Override
            public void run() {
                try {
                    int stamp = ATOMIC.getStamp();
                    System.out.println("before sleep stamp: " + stamp);
                    TimeUnit.SECONDS.sleep(2);

                    boolean b = ATOMIC.compareAndSet(100, 101, stamp, stamp + 1);
                    System.out.println(b);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();

    }

}
