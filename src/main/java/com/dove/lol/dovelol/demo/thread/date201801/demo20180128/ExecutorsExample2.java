package com.dove.lol.dovelol.demo.thread.date201801.demo20180128;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * @author Dovelol
 * @date 2018/1/28 18:12
 */
public class ExecutorsExample2 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newWorkStealingPool();


        List<Callable<String>> callableList = IntStream.range(0, 20).boxed().map(integer -> (
                Callable<String>) () -> {
            System.out.println("Thread " + Thread.currentThread().getName());
            sleep(2);
            return "Task-" + integer;
        }).collect(toList());

        executorService.invokeAll(callableList).stream().map(future -> {
            try {
                return future.get();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }).forEach(System.out::println);
        Optional.of(Runtime.getRuntime().availableProcessors()).ifPresent(System.out::println);

    }

    private static void sleep(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
