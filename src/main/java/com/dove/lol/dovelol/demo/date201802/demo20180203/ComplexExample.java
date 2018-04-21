package com.dove.lol.dovelol.demo.date201802.demo20180203;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * @author Dovelol
 * @date 2018/2/3 10:38
 */
public class ComplexExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ExecutorService service = Executors.newFixedThreadPool(5);

        List<Runnable> tasks = IntStream.range(0, 5).boxed().map(ComplexExample::toTask).collect(toList());

        List<Future<?>> futureList = new ArrayList<>();

        final CompletionService completionService = new ExecutorCompletionService(service);

        tasks.forEach((Runnable r) -> {
            futureList.add(service.submit(r));
        });


        System.out.println(futureList.get(4).get());
        System.out.println(futureList.get(3).get());
        System.out.println(futureList.get(2).get());
        System.out.println(futureList.get(1).get());
        System.out.println(futureList.get(0).get());
    }

    private static Runnable toTask(int i) {
        return () -> {
            try {
                System.out.printf("The Task [%d] will be executed.\n", i);
                TimeUnit.SECONDS.sleep(i * 5 + 10);
                System.out.printf("The Task [%d] will be done.\n", i);
            } catch (InterruptedException e) {
                System.out.printf("The Task [%d] will be interrupted.\n", i);
            }
        };
    }

}
