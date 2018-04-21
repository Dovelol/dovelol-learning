package com.dove.lol.dovelol.demo.date201801.demo20180114;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author Dovelol
 * @date 2018/1/14 11:44
 */
public class CountDownLatchExample1 {

    private static Random random = new Random(System.currentTimeMillis());

    private static ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws InterruptedException {
        int[] data = query();

        CountDownLatch latch = new CountDownLatch(data.length);
        for (int i = 0; i < data.length; i++) {
            executor.submit(new SimpleRunnable(data, i, latch));
        }
        TimeUnit.SECONDS.sleep(2);
        System.out.println(latch.getCount());
        latch.await();
        executor.shutdown();
        //executor.awaitTermination(1, TimeUnit.HOURS);
        System.out.println("over");

    }

    static class SimpleRunnable implements Runnable {

        private final int[] data;

        private final int index;

        private final CountDownLatch latch;

        public SimpleRunnable(int[] data, int index, CountDownLatch latch) {
            this.data = data;
            this.index = index;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int value = data[index];
            if (value % 2 == 0) {
                data[index] = value * 2;
            } else {
                data[index] = value * 10;
            }
            System.out.println(Thread.currentThread().getName() + " finished.");
            latch.countDown();
        }
    }

    private static int[] query() {
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    }


}
