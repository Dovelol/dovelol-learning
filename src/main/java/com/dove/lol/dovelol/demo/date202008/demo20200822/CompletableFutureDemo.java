package com.dove.lol.dovelol.demo.date202008.demo20200822;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author Dovelol
 * @date 2020/8/22 23:31
 */
@Slf4j
public class CompletableFutureDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = executorService.submit(() -> {
            log.info("test1 start");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("test1 end");
            return 100;
        });

        Future<Integer> future2 = executorService.submit(() -> {
            log.info("test2 start");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("test2 end");
            return 100;
        });

        try {
            Integer integer = future1.get();
            Integer integer1 = future2.get();
            log.info("{}",integer);
            log.info("{}",integer1);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
