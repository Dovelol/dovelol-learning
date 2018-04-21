package com.dove.lol.dovelol.demo.thread.date201801.demo20180128;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Dovelol
 * @date 2018/1/28 21:48
 */
public class ExecutorServiceSample3 {

    public static void main(String[] args) throws InterruptedException {
        //test();
        //testAllowCoreThreadTimeOut();
        //testRemove();
        testPrestartCoreThread();
    }

    private static void test() throws InterruptedException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        System.out.println(executorService.getActiveCount());
        executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        TimeUnit.MILLISECONDS.sleep(20);
        System.out.println(executorService.getActiveCount());


    }

    private static void testAllowCoreThreadTimeOut() {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        executorService.setKeepAliveTime(10, TimeUnit.SECONDS);
        executorService.allowCoreThreadTimeOut(true);
        IntStream.range(0, 5).boxed().forEach(integer -> {
            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

    }


    private static void testRemove() throws InterruptedException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        executorService.setKeepAliveTime(10, TimeUnit.SECONDS);
        executorService.allowCoreThreadTimeOut(true);
        IntStream.range(0, 2).boxed().forEach(integer -> {
            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("=========i am finished.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        TimeUnit.MILLISECONDS.sleep(20);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("I will never be executed!");
            }
        };
        executorService.execute(runnable);
        TimeUnit.MILLISECONDS.sleep(20);
        executorService.remove(runnable);

    }


    private static void testPrestartCoreThread(){
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println(executorService.getActiveCount());
        executorService.prestartCoreThread();
        System.out.println(executorService.getActiveCount());
        executorService.prestartCoreThread();
        System.out.println(executorService.getActiveCount());
        executorService.prestartCoreThread();
        System.out.println(executorService.getActiveCount());
        executorService.prestartCoreThread();
        System.out.println(executorService.getActiveCount());


    }

}
