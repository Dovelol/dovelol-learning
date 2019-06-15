package com.dove.lol.dovelol.nio.demo2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Dovelol
 * @date 2019/6/15 20:15
 */
public class ServerDemo {

    private AtomicLong counter = new AtomicLong();

    private Executor executor = new ThreadPoolExecutor(
            Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors(), 60,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>(), r -> new Thread(r, "exec-" + counter.incrementAndGet()));

    private Selector selector = null;

    private ServerSocketChannel serverSocketChannel = null;

    public static void main(String[] args) {
        ServerDemo serverDemo = new ServerDemo();
        serverDemo.server(8081);
    }

    public void server(int port) {
        try {
            serverSocketChannel = ServerSocketChannel.open();

            serverSocketChannel.configureBlocking(false);

            selector = Selector.open();

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


            serverSocketChannel.bind(new InetSocketAddress(port));


            while (true) {
                //SocketChannel socketChannel = serverSocketChannel.accept();

                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    iter.remove();
                    PollerDemo pollerDemo = new PollerDemo(key);
                    executor.execute(pollerDemo);
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
