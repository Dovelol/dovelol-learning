package com.dove.lol.dovelol.demo.date201801.demo20180128;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @author Dovelol
 * @date 2018/1/28 21:11
 */
public class ExecutorServiceSample2 {

    public static void main(String[] args) throws InterruptedException {
        //testAbortPolicy();
        //testCallerRunsPolicy();
        testDiscardOldestPolicy();
    }

    private static void testAbortPolicy() throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1),
                r -> {
                    Thread thread = new Thread(r);
                    return thread;
                }, new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 3; i++) {
            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        TimeUnit.SECONDS.sleep(1);


        executorService.execute(() -> System.out.println("=============="));

    }


    private static void testDiscardPolicy() throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1),
                r -> {
                    Thread thread = new Thread(r);
                    return thread;
                }, new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0; i < 3; i++) {
            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        TimeUnit.SECONDS.sleep(1);


        executorService.execute(() -> System.out.println("=============="));

        System.out.println("done");

    }


    private static void testCallerRunsPolicy() throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1),
                r -> {
                    Thread thread = new Thread(r);
                    return thread;
                }, new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 3; i++) {
            executorService.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        TimeUnit.SECONDS.sleep(1);


        executorService.execute(() -> {
            System.out.println("==============");
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println("done");
    }


    private static void testDiscardOldestPolicy() throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1),
                r -> {
                    Thread thread = new Thread(r);
                    return thread;
                }, new ThreadPoolExecutor.DiscardOldestPolicy());

        IntStream.range(0, 3).boxed().forEach(integer -> {
            executorService.execute(() -> {
                try {
                    System.out.println("execute:" + integer);
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        TimeUnit.SECONDS.sleep(1);


        executorService.execute(() -> {
            System.out.println("==============");
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println("done");
    }

}
