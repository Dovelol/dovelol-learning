package com.dove.lol.dovelol.demo.thread.date201712.demo20171217.request;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2017/12/17 17:20
 */
public class ClientThread extends Thread {

    private final RequestQueue queue;

    private final Random random;

    private final String sendValue;

    public ClientThread(RequestQueue queue,String sendValue) {
        this.queue = queue;
        this.random = new Random(System.currentTimeMillis());
        this.sendValue = sendValue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Client -> request " + sendValue);
            queue.putRequest(new Request(sendValue));
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
