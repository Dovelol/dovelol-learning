package com.dove.lol.dovelol.demo.date202103.demo20210313;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Dovelol
 * @date 2021/3/13 14:29
 */
public class EchoServer {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8088));

        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("监听8088端口");

        while (true){

            selector.select();

            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()){

                System.out.println("selectionKeys有动作");

                SelectionKey selectionKey = iterator.next();

                if(selectionKey.isAcceptable()){
                    ServerSocketChannel ssc =(ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = ssc.accept();
                    if(socketChannel != null){
                        System.out.println("accept new conn: "+ socketChannel.getRemoteAddress());
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector,SelectionKey.OP_READ);
                    }else {
                        System.out.println("没有新连接");
                    }

                }else if(selectionKey.isReadable()){
                    SocketChannel socketChannel =(SocketChannel) selectionKey.channel();
                    ByteBuffer buffer  = ByteBuffer.allocate(1024);
                    int readLength = socketChannel.read(buffer);
                    if(readLength > 0){
                        buffer.flip();
                        byte[] bytes = new byte[buffer.remaining()];
                        buffer.get(bytes);
                        String content = new String(bytes);
                        System.out.println("receive ms: "+content);
                    }
                }
            }


        }


    }

}
