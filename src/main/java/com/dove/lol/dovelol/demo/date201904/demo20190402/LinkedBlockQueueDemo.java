package com.dove.lol.dovelol.demo.date201904.demo20190402;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Dovelol
 * @date 2019/4/5 10:26
 */
public class LinkedBlockQueueDemo {

    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1);
        IntStream.range(0, 8).forEach(i -> {
            try {
                queue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        new Thread(() -> {
            IntStream.range(0, 10).forEach(i -> {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }).start();

        try {
            TimeUnit.SECONDS.sleep(5);
            queue.put(100);
            queue.put(101);
            queue.put(102);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
