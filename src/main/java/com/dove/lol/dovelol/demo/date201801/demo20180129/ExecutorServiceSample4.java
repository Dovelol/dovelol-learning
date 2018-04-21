package com.dove.lol.dovelol.demo.date201801.demo20180129;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * @author Dovelol
 * @date 2018/1/29 21:49
 */
public class ExecutorServiceSample4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        //testInvokeAny();
        //testInvokeAnyTimeOut();
        //testInvokeAll();
        //testInvokeAllTimeOut();
        //testSubmitRunnable();
        testSubmitRunnableWithResult();
    }

    private static void testInvokeAny() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Callable<Integer>> callableList = IntStream.range(0, 5).boxed().map(integer -> (Callable<Integer>) () -> {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(20));
            System.out.println(Thread.currentThread().getName() + " :" + integer);
            return integer;
        }).collect(Collectors.toList());

        Integer value = executorService.invokeAny(callableList);
        System.out.println("=============finish==============");
        System.out.println(value);

    }

    private static void testInvokeAnyTimeOut() throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Callable<Integer>> callableList = IntStream.range(0, 5).boxed().map(integer -> (Callable<Integer>) () -> {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(20));
            System.out.println(Thread.currentThread().getName() + " :" + integer);
            return integer;
        }).collect(Collectors.toList());

        Integer value = executorService.invokeAny(callableList, 3, TimeUnit.SECONDS);
        System.out.println("=============finish==============");
        System.out.println(value);
    }

    private static void testInvokeAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Callable<Integer>> callableList = IntStream.range(0, 5).boxed().map(integer -> (Callable<Integer>) () -> {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(20));
            System.out.println(Thread.currentThread().getName() + " :" + integer);
            return integer;
        }).collect(Collectors.toList());

        List<Future<Integer>> value = executorService.invokeAll(callableList);
        System.out.println("=============finish==============");
        value.stream().map(future -> {
            try {
                return future.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).forEach(System.out::println);

    }

    private static void testInvokeAllTimeOut() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Callable<Integer>> callableList = IntStream.range(0, 5).boxed().map(integer -> (Callable<Integer>) () -> {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(20));
            System.out.println(Thread.currentThread().getName() + " :" + integer);
            return integer;
        }).collect(Collectors.toList());

        List<Future<Integer>> value = executorService.invokeAll(callableList, 5, TimeUnit.SECONDS);
        System.out.println("=============finish==============");
        value.stream().map(future -> {
            try {
                return future.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).forEach(System.out::println);

    }

    private static void testSubmitRunnable() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<?> future = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Object NULL = future.get();
        System.out.println("R:" + NULL);
    }

    private static void testSubmitRunnableWithResult() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        String resulte = "DONE";
        Future<String> future = executorService.submit((Callable<String>) () -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                return resulte;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Object NULL = future.get();
        System.out.println("R:" + NULL);
    }
}
