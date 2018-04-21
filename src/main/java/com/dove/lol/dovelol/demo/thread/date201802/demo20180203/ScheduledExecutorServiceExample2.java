package com.dove.lol.dovelol.demo.thread.date201802.demo20180203;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/1/31 22:34
 */
public class ScheduledExecutorServiceExample2 {

    public static void main(String[] args) throws InterruptedException {
        //testScheduleWithFixedDelay();
        //test1();
        test2();
    }

    private static void testScheduleWithFixedDelay() {
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(2);
        executor.scheduleWithFixedDelay(() -> System.out.println("===" + System.currentTimeMillis()), 1, 2, TimeUnit.SECONDS);

    }

    private static void test1() throws InterruptedException {
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(2);
        executor.setContinueExistingPeriodicTasksAfterShutdownPolicy(true);
        System.out.println(executor.getContinueExistingPeriodicTasksAfterShutdownPolicy());
        ScheduledFuture<?> future = executor.schedule(() -> System.out.println("I will be invoked!"), 2, TimeUnit.SECONDS);
        System.out.println(future.cancel(true));

        ScheduledFuture<?> iAmRunning = executor.scheduleAtFixedRate(() -> {
            System.out.println("i am running" + System.currentTimeMillis());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, 2, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(1200);
        System.out.println();
        executor.shutdown();
    }

    private static void test2() throws InterruptedException {
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(2);
        executor.setExecuteExistingDelayedTasksAfterShutdownPolicy(true);
        System.out.println(executor.getExecuteExistingDelayedTasksAfterShutdownPolicy());
        ScheduledFuture<?> future = executor.schedule(() -> System.out.println("I will be invoked!"), 2, TimeUnit.SECONDS);
        System.out.println(future.cancel(true));

        ScheduledFuture<?> iAmRunning = executor.scheduleAtFixedRate(() -> {
            System.out.println("i am running" + System.currentTimeMillis());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, 2, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(1200);
        System.out.println();
        executor.shutdown();
    }

}
