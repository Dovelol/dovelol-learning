package com.dove.lol.dovelol.demo.thread.date201712.demo20171223;

import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2017/12/23 8:57
 */
public class CounterTest {


    public static void main(String[] args) {
        CounterIncrement counterIncrement = new CounterIncrement();
        counterIncrement.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counterIncrement.close();

    }
}
