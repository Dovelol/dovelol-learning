package com.dove.lol.dovelol.demo.thread;

import java.util.concurrent.TimeUnit;

public class ThreadCloseForce {


    public static void main(String[] args) {
        ThreadService service = new ThreadService();
        long currentTime = System.currentTimeMillis();
        service.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread());
        service.shutdown(15_000);
        System.out.println(System.currentTimeMillis() - currentTime);

    }

}
