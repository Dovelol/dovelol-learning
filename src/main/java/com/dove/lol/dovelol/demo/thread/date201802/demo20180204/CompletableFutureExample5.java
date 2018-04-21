package com.dove.lol.dovelol.demo.thread.date201802.demo20180204;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/2/4 11:59
 */
public class CompletableFutureExample5 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //getNow();
        //complete();
        //join();
        //ompleteExceptionally();
        //obtrudeException();
        CompletableFuture<String> future = errorHandle();
        future.whenComplete((v, t) -> {
            System.out.println(v);
        });
        Thread.currentThread().join();
    }

    private static void complete() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            sleep(5);
            return "HELLO";
        });
        sleep(1);
        boolean finish = future.complete("WORLD");
        System.out.println(finish);
        System.out.println(future.get());
    }

    private static void getNow() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            sleep(5);
            return "HELLO";
        });
        String result = future.getNow("WORLD");
        System.out.println(result);
        System.out.println(future.get());
    }

    private static void join() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            sleep(5);
            return "HELLO";
        });
        String result = future.join();
        System.out.println(result);

    }

    private static void completeExceptionally() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            sleep(5);
            return "HELLO";
        });
        sleep(6);
        boolean result = future.completeExceptionally(new RuntimeException());
        System.out.println(result);
        System.out.println(future.get());
    }

    private static void obtrudeException() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            sleep(5);
            return "HELLO";
        });
        future.obtrudeException(new RuntimeException("I am error"));
        System.out.println(future.get());
    }

    private static CompletableFuture<String> errorHandle() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            sleep(5);
            System.out.println("start");
            return "HELLO";
        });
        CompletableFuture<Void> future2 = future1.thenApply(s -> {
            Integer.parseInt(s);
            sleep(6);
            System.out.println("======keep moving======");
            return s + " WORLD";
        }).exceptionally(Throwable::getMessage).thenAccept(System.out::println);
        return future1;
    }

    private static void sleep(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
