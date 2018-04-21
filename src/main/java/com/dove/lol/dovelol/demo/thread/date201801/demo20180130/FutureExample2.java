package com.dove.lol.dovelol.demo.thread.date201801.demo20180130;

import java.util.concurrent.*;

/**
 * @author Dovelol
 * @date 2018/1/30 22:23
 */
public class FutureExample2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //testIsDone();
        //testCancel();
        testCancel2();
    }

    /**
     * Completion may be due to normal termination, an exception, or
     * cancellation -- in all of these cases, this method will return {@code true}.
     */
    private static void testIsDone() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> future = executorService.submit(() -> {

          TimeUnit.SECONDS.sleep(10);

            return 10;
        });
        Integer result = future.get();
        System.out.println(result + " is done " + future.isDone());

    }

    private static void testCancel() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> future = executorService.submit(() -> {

            return 10;
        });
        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean result = future.cancel(true);
        System.out.println(result);
    }

    private static void testCancel2() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> future = executorService.submit(() -> {

            TimeUnit.SECONDS.sleep(10);
            System.out.println("============");

            System.out.println("111111");
            return 10;
        });
        TimeUnit.MILLISECONDS.sleep(20);
        System.out.println(future.cancel(true));
        System.out.println(future.isDone());
        System.out.println(future.isCancelled());
    }

    private static void inter(){
        ExecutorService executorService = Executors.newCachedThreadPool();

       executorService.submit(() -> {
           try {
               TimeUnit.SECONDS.sleep(10);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       });
    }

}
