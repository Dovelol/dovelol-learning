package com.dove.lol.dovelol.demo.thread.date201801.demo20180129;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/1/29 22:39
 */
public class ExecutorServiceSample5 {

    public static void main(String[] args) {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        executorService.getQueue().add(() -> System.out.println("I am add directly into the queue"));

        executorService.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}
