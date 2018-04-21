package com.dove.lol.dovelol.demo.thread.date201802.demo20180204;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/2/4 10:34
 */
public class CompletableFutureExample4 {

    public static void main(String[] args) throws InterruptedException {
        //thenAcceptBoth();
        //acceptEither();
        //runAfterBoth();
        //runAfterEither();
        //combine();
        compose();
        Thread.currentThread().join();
    }

    private static void compose() {
        CompletableFuture.supplyAsync(() -> {
            System.out.println("start the thenCompose");
            sleep(5);
            System.out.println("end the thenCompose");
            return "thenCompose";
        }).thenComposeAsync(s -> CompletableFuture.supplyAsync(() -> {
            System.out.println("start the thenCompose2");
            sleep(2);
            System.out.println("end the thenCompose2");
            return s.length();
        })).thenAccept(System.out::println);
    }

    private static void thenAcceptBoth() {
        CompletableFuture.supplyAsync(() -> {
            System.out.println("start the supplyAsync");
            sleep(5);
            System.out.println("end the supplyAsync");
            return "thenAcceptBoth";
        }).thenAcceptBoth(CompletableFuture.supplyAsync(() -> {
            System.out.println("start the thenAcceptBoth");
            sleep(5);
            System.out.println("end the thenAcceptBoth");
            return 100;
        }), (s, i) -> {
            System.out.println(s + "--" + i);
        });
    }

    private static void acceptEither() {
        CompletableFuture.supplyAsync(() -> {
            System.out.println("start the supplyAsync");
            sleep(5);
            System.out.println("end the supplyAsync");
            return "acceptEither-1";
        }).acceptEither(CompletableFuture.supplyAsync(() -> {
            System.out.println("start the acceptEither");
            sleep(2);
            System.out.println("end the acceptEither");
            return "acceptEither-2";
        }), System.out::println);
    }

    private static void runAfterBoth() {
        CompletableFuture.supplyAsync(() -> {
            System.out.println("start the runAfterBoth");
            sleep(5);
            System.out.println("end the runAfterBoth");
            return "runAfterBoth-1";
        }).runAfterBothAsync(CompletableFuture.supplyAsync(() -> {
            System.out.println("start the acceptEither");
            sleep(2);
            System.out.println("end the acceptEither");
            return "acceptEither-2";
        }), () -> System.out.println("Done"));
    }

    private static void runAfterEither() {
        CompletableFuture.supplyAsync(() -> {
            System.out.println("start the runAfterEither-1 ");
            sleep(5);
            System.out.println("end the runAfterEither-1");
            return "runAfterEither-1";
        }).runAfterEither(CompletableFuture.supplyAsync(() -> {
            System.out.println("start the runAfterEither-2");
            sleep(2);
            System.out.println("end the runAfterEither-2");
            return "runAfterEither-2";
        }), () -> System.out.println("Done"));
    }

    private static void combine() {
        CompletableFuture.supplyAsync(() -> {
            System.out.println("start the runAfterEither-1 ");
            sleep(5);
            System.out.println("end the runAfterEither-1");
            return 1000;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println("start the runAfterEither-2");
            sleep(2);
            System.out.println("end the runAfterEither-2");
            return 2000;
        }), (s, i) -> s > i).whenComplete((v, t) -> System.out.println(v));
    }

    private static void sleep(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
