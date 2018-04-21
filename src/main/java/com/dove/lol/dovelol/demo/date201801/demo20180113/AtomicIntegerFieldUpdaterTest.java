package com.dove.lol.dovelol.demo.date201801.demo20180113;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author Dovelol
 * @date 2018/1/13 18:29
 */
public class AtomicIntegerFieldUpdaterTest {

    public static void main(String[] args) {
        AtomicIntegerFieldUpdater<TestMe> updater = AtomicIntegerFieldUpdater.newUpdater(TestMe.class, "i");
        TestMe testMe = new TestMe();
        for (int i = 0; i < 20; i++) {
            new Thread() {
                @Override
                public void run() {
                    final int MAX = 20;
                    for (int i = 0; i < MAX; i++) {
                        int v = updater.incrementAndGet(testMe);
                        System.out.println(Thread.currentThread().getName() + " => " + v);
                    }
                }
            }.start();
        }

    }

    static class TestMe {

        private int i;
    }

}
