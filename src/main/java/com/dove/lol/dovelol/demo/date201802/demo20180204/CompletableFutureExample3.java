package com.dove.lol.dovelol.demo.date201802.demo20180204;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/2/4 9:43
 */
public class CompletableFutureExample3 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 100).
//                thenCombine(CompletableFuture.supplyAsync(() -> 500), (r1, r2) -> r1 + r2);
//
//
//        System.out.println(future.get());
        //Thread.currentThread().join();


//        CompletableFuture.supplyAsync(() ->{
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            return "Hello";
//        }).thenAccept(System.out::println);

        CompletableFuture.supplyAsync(() ->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "Hello";
        }).thenRun(System.out::println);


    }

}
