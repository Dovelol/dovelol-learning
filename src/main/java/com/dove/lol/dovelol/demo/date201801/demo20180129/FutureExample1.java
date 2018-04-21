package com.dove.lol.dovelol.demo.date201801.demo20180129;


import java.util.concurrent.*;

/**
 * @author Dovelol
 * @date 2018/1/29 22:44
 */
public class FutureExample1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
       // testGet();
        testGetWithTimeOut();
    }

    private static void testGet() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        Future<Integer> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });

        System.out.println("==== i will be printed quickly=====");
        Thread callerThread = Thread.currentThread();
        new Thread(() -> {

            try {
                TimeUnit.MILLISECONDS.sleep(3);
                callerThread.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Integer integer = future.get();

        System.out.println(integer);

        System.out.println("end");
    }

    private static void testGetWithTimeOut() throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        Future<Integer> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });

        System.out.println("==== i will be printed quickly=====");

        Integer integer = future.get(5, TimeUnit.SECONDS);

        System.out.println(integer);

        System.out.println("end");
    }

}
