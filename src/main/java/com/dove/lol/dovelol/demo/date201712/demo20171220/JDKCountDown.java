package com.dove.lol.dovelol.demo.date201712.demo20171220;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Dovelol
 * @date 2017/12/20 22:29
 */
public class JDKCountDown {

    private static final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);
        System.out.println("准备多线程处理任务");
        IntStream.rangeClosed(1, 10).forEach(i -> {
            new Thread(() -> {
                System.out.println(i + " is workng.");
                try {
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }, String.valueOf(i)).start();
        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("多线程任务全部结束，准备第二阶段任务");
        System.out.println("....");
        System.out.println("FINISH");

    }
}
