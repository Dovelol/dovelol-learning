package com.dove.lol.dovelol.demo.thread.date201803.demo20180322;

import java.util.HashMap;

/**
 * @author Dovelol
 * @date 2018/3/22 22:43
 */
public class HashMapInfiniteLoop {

    private static HashMap<Integer, String> map = new HashMap<Integer, String>(2);

    public static void main(String[] args) {
        map.put(5, "C");

        new Thread("Thread1") {
            @Override
            public void run() {
                map.put(7, "B");
                System.out.println(map);
            }
        }.start();
        new Thread("Thread2") {
            @Override
            public void run() {
                map.put(3, "A");
                System.out.println(map);
            }
        }.start();
    }


}
