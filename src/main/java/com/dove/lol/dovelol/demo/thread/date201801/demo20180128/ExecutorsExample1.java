package com.dove.lol.dovelol.demo.thread.date201801.demo20180128;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Dovelol
 * @date 2018/1/28 14:54
 */
public class ExecutorsExample1 {

    public static void main(String[] args) throws InterruptedException {

        // useCacheThreadPool();
        useFixThreadPool();
    }

    private static void useSingleThreadPool(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
    }


    private static void useFixThreadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println(((ThreadPoolExecutor) executorService).getActiveCount());
        System.out.println(((ThreadPoolExecutor) executorService).getMaximumPoolSize());

        IntStream.range(0, 100).boxed().forEach(integer -> {
            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "[" + integer + "]");
            });
        });
        TimeUnit.SECONDS.sleep(1);
        System.out.println(((ThreadPoolExecutor) executorService).getActiveCount());

    }

    private static void useCacheThreadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println(((ThreadPoolExecutor) executorService).getActiveCount());
        System.out.println(((ThreadPoolExecutor) executorService).getMaximumPoolSize());
        executorService.execute(() -> {
            System.out.println("123");
        });
        System.out.println(((ThreadPoolExecutor) executorService).getActiveCount());

        IntStream.range(0, 100).boxed().forEach(integer -> {
            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "[" + integer + "]");
            });
        });
        TimeUnit.SECONDS.sleep(1);
        System.out.println(((ThreadPoolExecutor) executorService).getActiveCount());
    }


}
