package com.dove.lol.dovelol.utils;

import java.util.concurrent.*;

public class GlobalTheadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(8, 8, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        });

        executor.execute(()->{});

        Future<?> submit = executor.submit(() -> {
        });

        submit.cancel(true);


    }


}
