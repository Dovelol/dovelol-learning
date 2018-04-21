package com.dove.lol.dovelol.demo.date201801.demo20180125;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Dovelol
 * @date 2018/1/27 10:43
 */
public class ThreadPoolExecutorLongTimeTask {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(10, 20, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1),
                r -> {
                    Thread thread = new Thread(r);
                    return thread;
                }, new ThreadPoolExecutor.AbortPolicy());


        IntStream.range(0, 10).boxed().forEach(integer -> {
            executorService.submit(() -> {
                while (true) {

                }
            });
        });


        executorService.shutdown();

        executorService.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("==============start the sequence working================");




    }


}
