package com.dove.lol.dovelol.demo.thread.date201802.demo20180203;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * @author Dovelol
 * @date 2018/2/3 21:30
 */
public class CompletableFutureExample1 {

    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//        Future<?> future = executorService.submit(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        while (!future.isDone()) {
//
//        }
//        System.out.println("DONE");

//        CompletableFuture.runAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, Executors.newFixedThreadPool(10)).whenComplete((aVoid, throwable) -> {
//            System.out.println("Done");
//        });

//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//        List<Callable<Integer>> tasks = IntStream.range(0, 10).boxed().map(i ->
//                (Callable<Integer>) () -> get()
//        ).collect(toList());
//
//        executorService.invokeAll(tasks).stream().map(future -> {
//            try {
//                return future.get();
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }).parallel().forEach(CompletableFutureExample1::display);

        IntStream.range(0, 10).boxed().
                forEach(i -> CompletableFuture.supplyAsync(CompletableFutureExample1::get1).thenAccept(CompletableFutureExample1::display)
                        .whenComplete((v, t) -> System.out.println(i + "DONE")));
        Thread.currentThread().join();
    }

    private static void display(int data) {
        int value = ThreadLocalRandom.current().nextInt(20);

        System.out.println(Thread.currentThread().getName() + " display will be sleep " + value);
        try {
            TimeUnit.SECONDS.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " display execute done. " + value);
    }


    private static int get1() {
        int value = ThreadLocalRandom.current().nextInt(20);

        System.out.println(Thread.currentThread().getName() + " get will be sleep " + value);
        try {
            TimeUnit.SECONDS.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " get execute done. " + value);
        return value;
    }

}
