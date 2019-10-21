package com.dove.lol.dovelol.demo.date201910.demo20191021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Dovelol
 * @date 2019/10/21 22:40
 */
public class CompletableFutureDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        final List<Callable<Integer>> callableList = Arrays.asList(() -> {
            sleep(20);
            System.out.println("the 20 finished.");
            int i = 1/0;
            return 20;
        }, () -> {
            sleep(30);
            System.out.println("the 30 finished.");
            return 30;
        }, () -> {
            sleep(10);
            System.out.println("the 10 finished.");
            return 10;
        });

        ExecutorCompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);

        List<Future<Integer>> futures = new ArrayList<>();

        callableList.stream().forEach(callable->{
            futures.add(completionService.submit(callable));
        });

//        Future<Integer> future = null;
//        while ((future = completionService.take()) != null){
//            System.out.println(future.get());
//        }


        for(Future<Integer> future : futures){
            Future<Integer> take = completionService.take();
            try{
                Integer result = take.get();
                System.out.println("获取到结果："+result);
            }catch (Exception e){
                System.out.println("发生异常");
            }

        }


//        while ((future = completionService.poll(5,TimeUnit.SECONDS)) != null){
//            System.out.println(future.get());
//        }
        System.out.println("finish");
    }



    private static void sleep(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
