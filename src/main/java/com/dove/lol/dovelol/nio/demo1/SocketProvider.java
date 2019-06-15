package com.dove.lol.dovelol.nio.demo1;

import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Dovelol
 * @date 2019/6/15 20:25
 */
public class SocketProvider {

    private static final LinkedBlockingQueue<SocketChannel> QUEUE = new LinkedBlockingQueue<>();


    public static void offer(SocketChannel socketChannel) {

        QUEUE.offer(socketChannel);

    }


}
