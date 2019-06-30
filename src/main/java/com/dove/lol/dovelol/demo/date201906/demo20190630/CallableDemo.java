package com.dove.lol.dovelol.demo.date201906.demo20190630;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Dovelol
 * @date 2019/6/30 22:53
 */
public class CallableDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AtomicInteger counter = new AtomicInteger();
        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), r -> new Thread(r, "alternant-" + counter.incrementAndGet()));

        String str = "abc";
        Future<String> future = executorService.submit(() -> {
            System.out.println("123");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "f";
        });

        Future<String> future2 = executorService.submit(() -> {
            System.out.println("123");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },str);

        System.out.println("===========");
        String s = future.get();
        System.out.println(s);
        System.out.println(future2.get());
        System.out.println("end");



    }

}
