package com.dove.lol.dovelol.demo.thread.date201712.demo20171217.request;

import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2017/12/17 17:32
 */
public class SuspensionClient {

    public static void main(String[] args) throws InterruptedException {
        final RequestQueue queue = new RequestQueue();

        ClientThread c = new ClientThread(queue, "dovelol");
        c.setName("client");
        c.start();

        ServerThread s = new ServerThread(queue);
        s.start();
        s.setName("server");
        TimeUnit.SECONDS.sleep(10);
        s.close();
    }

}
