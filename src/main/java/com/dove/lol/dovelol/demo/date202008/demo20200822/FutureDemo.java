package com.dove.lol.dovelol.demo.date202008.demo20200822;

import com.alibaba.dubbo.common.threadpool.support.fixed.FixedThreadPool;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author Dovelol
 * @date 2020/8/22 23:22
 */
@Slf4j
public class FutureDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture.supplyAsync(() -> {
            log.info("test1 start");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("test1 end");
            return 100;
        },executorService).thenAcceptAsync((temp)-> log.info("{}",temp));

        CompletableFuture.supplyAsync(() -> {
            log.info("test2 start");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("test2 end");
            return 101;
        },executorService).thenAcceptAsync((temp)-> log.info("{}",temp));


        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
