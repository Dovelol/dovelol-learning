package com.dove.lol.dovelol.demo.thread.date201801.demo20180130;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Dovelol
 * @date 2018/1/30 23:00
 */
public class CompletionServiceExample1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //futureDefect1();
        futureDefect2();
    }

    /**
     * no callback;
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void futureDefect1() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return 100;
        });

        System.out.println("==========");
        System.out.println(future.get());
    }

    /**
     * no callback;
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void futureDefect2() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        final List<Callable<Integer>> callableList = Arrays.asList(() -> {
            sleep(10);
            System.out.println("the 10 finished.");
            return 10;
        }, () -> {
            sleep(20);
            System.out.println("the 20 finished.");
            return 20;
        }, () -> {
            sleep(30);
            System.out.println("the 30 finished.");
            return 30;
        });

        List<Future<Integer>> futureList = executorService.invokeAll(callableList);

        System.out.println("==========");
        System.out.println(futureList.get(0).get());
        System.out.println(futureList.get(1).get());
        System.out.println(futureList.get(2).get());
    }

    private static void sleep(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
