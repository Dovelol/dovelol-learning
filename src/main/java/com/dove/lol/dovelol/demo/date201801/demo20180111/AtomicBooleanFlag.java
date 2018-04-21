package com.dove.lol.dovelol.demo.date201801.demo20180111;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Dovelol
 * @date 2018/1/11 23:03
 */
public class AtomicBooleanFlag {

    private static final AtomicBoolean flag = new AtomicBoolean(true);

    private static boolean flag1 = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                while (flag1) {
                    int i = 5;
                    i = i * 10;
                    test(i);
                    //System.out.println("I an working.");
                }
            }
        }.start();

        TimeUnit.SECONDS.sleep(5);

        new Thread() {
            @Override
            public void run() {
                flag1 = false;
            }
        }.start();
    }

    public static synchronized void test(int i){
        i = 10;
    }

}
