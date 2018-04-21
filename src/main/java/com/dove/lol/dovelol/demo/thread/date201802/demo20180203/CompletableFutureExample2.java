package com.dove.lol.dovelol.demo.thread.date201802.demo20180203;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/2/3 22:31
 */
public class CompletableFutureExample2 {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(Object::new).thenAcceptAsync(o -> {
            try {
                System.out.println("Obj=======Start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Obj=======" + o);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).runAfterBoth(CompletableFuture.supplyAsync(() -> "hello").thenAcceptAsync(s -> {
            try {
                System.out.println("String=======Start");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("String=======" + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }), () -> System.out.println("====Finish===="));
    }

}
