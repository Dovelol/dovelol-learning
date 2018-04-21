package com.dove.lol.dovelol.demo.date201801.demo20180130;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Dovelol
 * @date 2018/1/30 23:00
 */
public class CompletionServiceExample2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        final List<Callable<Integer>> callableList = Arrays.asList(() -> {
            sleep(20);
            System.out.println("the 20 finished.");
            return 20;
        }, () -> {
            sleep(30);
            System.out.println("the 30 finished.");
            return 30;
        }, () -> {
            sleep(10);
            System.out.println("the 10 finished.");
            return 10;
        });

        ExecutorCompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);

        List<Future<Integer>> futures = new ArrayList<>();

        callableList.stream().forEach(callable->{
            futures.add(completionService.submit(callable));
        });

        Future<Integer> future = null;
        while ((future = completionService.take()) != null){
            System.out.println(future.get());
        }
    }


    private static void sleep(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
