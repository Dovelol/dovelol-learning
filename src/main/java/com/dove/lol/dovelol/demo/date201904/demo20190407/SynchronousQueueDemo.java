package com.dove.lol.dovelol.demo.date201904.demo20190407;

import java.sql.Time;
import java.util.concurrent.*;

/**
 * @author Dovelol
 * @date 2019/4/7 11:09
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> sQueue = new SynchronousQueue<>();


        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        executor.execute(() -> {
            try {
                Integer value = sQueue.take();
                System.out.println(value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread.sleep(100);

        executor.execute(() -> {
//            for (int i = 0; i < 10; i++) {
//                try {
//                    System.out.println(i + "======"+sQueue.offer(i));
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
            System.out.println(sQueue.offer(1));
        });

//
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }



//        try {
//            Integer value = sQueue.take();
//            System.out.println(value);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }


}
