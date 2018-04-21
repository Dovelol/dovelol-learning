package com.dove.lol.dovelol.demo.date201712.demo20171217.future;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * @author Dovelol
 * @date 2017/12/17 12:16
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {
        FutureTask<String> task = new FutureTask<String>() {
            @Override
            public String call() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "dovelol";
            }
        };
        FutureService futureService = new FutureService();
        Future<String> future = futureService.submit(task,System.out::println);
        System.out.println("=============");
        System.out.println("do other things.");

        TimeUnit.SECONDS.sleep(1);
        System.out.println("=============");
        //System.out.println(future.get());

        Consumer<String> consumer = System.out::println;


    }

}
