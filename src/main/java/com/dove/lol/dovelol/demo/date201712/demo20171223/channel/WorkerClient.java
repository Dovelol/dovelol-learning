package com.dove.lol.dovelol.demo.date201712.demo20171223.channel;


/**
 * @author Dovelol
 * @date 2017/12/23 11:37
 */
public class WorkerClient {

    public static void main(String[] args) throws InterruptedException {
        final Channel channel = new Channel(5);
        channel.startWorker();
        new TransportThread("dove1", channel).start();
        new TransportThread("dove2", channel).start();
        new TransportThread("dove3", channel).start();
        new TransportThread("dove4", channel).start();
        new TransportThread("dove5", channel).start();

    }
}
