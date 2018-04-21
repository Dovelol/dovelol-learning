package com.dove.lol.dovelol.demo.date201712.demo20171223;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author Dovelol
 * @date 2017/12/23 8:07
 */
public class MessageHandler {

    private static final Random random = new Random(System.currentTimeMillis());

    private final ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    public void request(Message message) {

        executor.execute(() -> {
            String value = message.getValue();
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
                System.out.println("The message will be handle by " + Thread.currentThread().getName() + " " + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
//        new Thread(() -> {
//            String value = message.getValue();
//            try {
//                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
//                System.out.println("The message will be handle by " + Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
    }


    public void shutdown() {
        executor.shutdown();
    }

}
