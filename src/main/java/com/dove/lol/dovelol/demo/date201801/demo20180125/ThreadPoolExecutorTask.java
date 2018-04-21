package com.dove.lol.dovelol.demo.date201801.demo20180125;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Dovelol
 * @date 2018/1/27 10:17
 */
public class ThreadPoolExecutorTask {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(10, 20, 30,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), r -> {
            Thread t = new Thread(r);
            return t;
        }, new ThreadPoolExecutor.AbortPolicy());

        IntStream.range(0, 20).boxed().forEach(integer -> executorService.submit(() -> {


                System.out.println(Thread.currentThread().getName() + "[" + integer + "] finish done.");

        }));

        TimeUnit.SECONDS.sleep(1);

        List<Runnable> runnables = null;
        try {
            runnables = executorService.shutdownNow();

        } catch (Exception e) {

            e.printStackTrace();
        }
        System.out.println(runnables);
        System.out.println(runnables.size());
    }


}
