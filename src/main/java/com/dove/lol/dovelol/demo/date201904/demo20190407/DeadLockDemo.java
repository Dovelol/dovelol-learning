package com.dove.lol.dovelol.demo.date201904.demo20190407;

import java.util.concurrent.*;

/**
 * @author Dovelol
 * @date 2019/4/7 12:39
 */
public class DeadLockDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> sQueue = new SynchronousQueue<>();


        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        executor.execute(() -> {
            try {
                boolean offer = sQueue.offer(1);
                System.out.println(offer);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("abc");
        });


        executor.execute(() -> {
            try {
                Integer value = sQueue.take();
                System.out.println(value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.awaitTermination(100, TimeUnit.SECONDS);
        executor.shutdown();


        Thread thread = new Thread();
        thread.start();
        thread.join();
    }

}
