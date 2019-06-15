package com.dove.lol.dovelol.nio.demo1;

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
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

            serverSocketChannel.bind(new InetSocketAddress(port));

            serverSocketChannel.configureBlocking(true);

            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                executor.execute(() -> {
                    serverHandler(socketChannel);
                });
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serverHandler(SocketChannel socketChannel) {
        Socket socket = socketChannel.socket();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try {
            socketChannel.read(byteBuffer);
            System.out.println("request:" + new String(byteBuffer.array()));
            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
            StringBuilder returnStr = new StringBuilder();
            returnStr.append("HTTP/1.1 200 ok\r\n");//增加响应消息行
            returnStr.append("Content-Type:text/html;charset=" + "UTF-8" + "\r\n");//增加响应消息头
            returnStr.append("\r\n");//空行
            returnStr.append("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>返回的网页</title>\n" +
                    "    <style>\n" +
                    "        *{\n" +
                    "            background-color: cadetblue;\n" +
                    "        }\n" +
                    "        #requestInfo{\n" +
                    "            font-size: 35px;\n" +
                    "            font-family: \"Buxton Sketch\",serif;\n" +
                    "            font-weight: bold;\n" +
                    "            color: #001bff;\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <h1>Hello!</h1><br>\n" +
                    "    <h3>I'm come from localhost!</h3>\n" +
                    "    <h3>And this is you request package information：</h3><br>\n" +
                    "    <p id=\"requestInfo\">\n abcdefg"   +
                    "        \n" +
                    "    </p>\n" +
                    "</body>\n" +
                    "</html>");//响应消息体
            String response ="HTTP/1.1 200 ok\r\nContent-Type:application/json;charset=UTF-8\r\n\r\n{\"name\":\"dovelol\"}";
            System.out.println("返回内容：\n" + response);
            writeBuffer.put(response.getBytes());
            writeBuffer.flip();
            socketChannel.write(writeBuffer);
        socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
