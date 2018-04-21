package com.dove.lol.dovelol.demo.date201801.demo20180131;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author Dovelol
 * @date 2018/1/31 22:34
 */
public class ScheduledExecutorServiceExample1 {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(2);
        ScheduledFuture<?> future = executor.schedule(() -> System.out.println("I will be invoked!"), 2, TimeUnit.SECONDS);
        System.out.println(future.cancel(true));

        ScheduledFuture<?> iAmRunning = executor.scheduleAtFixedRate(() ->{
            System.out.println("i am running" + System.currentTimeMillis());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, 2, TimeUnit.SECONDS);

    }

}
