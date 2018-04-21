package com.dove.lol.dovelol.demo.date201801.demo20180114;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/1/14 15:42
 */
public class CyclicBarrierExample1 {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(100);
                System.out.println("T1 finished.");
                cyclicBarrier.await();
                System.out.println("T1 The other thread finished too.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(20);
                System.out.println("T2 finished.");
                cyclicBarrier.await();
                System.out.println("T2 The other thread finished too.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("T3 finished.");
                cyclicBarrier.await();
                System.out.println("T3 The other thread finished too.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println("w:" + cyclicBarrier.getNumberWaiting());
        System.out.println("p:" + cyclicBarrier.getParties());
        cyclicBarrier.await();
        System.out.println("123");
    }

}
