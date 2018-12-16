package com.dove.lol.dovelol.demo.date201809.demo20180924;

/**
 * @author Dovelol
 * @date 2018/9/24 11:09
 */
public class ThreadSample {

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }



}
