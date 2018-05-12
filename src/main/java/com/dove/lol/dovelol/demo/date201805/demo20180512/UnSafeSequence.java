package com.dove.lol.dovelol.demo.date201805.demo20180512;

import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/5/12 15:50
 */
public class UnSafeSequence {

    private int value;

    public synchronized int getNext() {
        return value++;
    }

    public static void main(String[] args) throws InterruptedException {
        UnSafeSequence unSafeSequence = new UnSafeSequence();
        for (int i = 0 ; i < 100; i++){
            new Thread(()->{
                for (int j = 0; j < 100; j++){
                    unSafeSequence.getNext();
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(1);
        System.out.println(unSafeSequence.value);
    }

}
