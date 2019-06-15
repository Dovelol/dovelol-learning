package com.dove.lol.dovelol.nio.demo2;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;

/**
 * @author Dovelol
 * @date 2019/6/15 21:35
 */
public class PollerDemo implements Runnable {

    private static final String CHARSET = "UTF-8";

    private SelectionKey key;

    public PollerDemo(SelectionKey key) {
        this.key = key;
    }

    @Override
    public void run() {
        if (key.isAcceptable()) {
            acceptHttpRequest();
        } else if (key.isReadable()) {
            returnHttpPackage(turnStringToHttpPackage(readHttpRequest()));
        }
    }

    private void acceptHttpRequest() {
        SocketChannel socketChannel = null;
        try {
            socketChannel = ((ServerSocketChannel) key.channel()).accept();
            socketChannel.configureBlocking(false);
        } catch (IOException e) {
            System.out.println("accept错误！");
            e.printStackTrace();
        }
        try {
            socketChannel.finishConnect();
        } catch (IOException e) {
            System.out.println("完成连接失败！");
            e.printStackTrace();
        }
        Selector selector = key.selector();
        try {
            socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
        } catch (ClosedChannelException e) {
            System.out.println("handler中注册selector失败！");
            e.printStackTrace();
        }
    }


    private String readHttpRequest() {
        String httpStr = "";
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
        byteBuffer.clear();
        int num;
        try {
            if ((num = channel.read(byteBuffer)) != -1) {
                byteBuffer.flip();
                httpStr = Charset.forName("UTF-8").newDecoder().decode(byteBuffer).toString();
            }
        } catch (IOException e) {
            System.out.println("服务器读取错误！");
            e.printStackTrace();
        }

        return httpStr;
    }

    private String turnStringToHttpPackage(String httpPackageStr) {

        return httpPackageStr;
    }

    private void returnHttpPackage(String httpPackageStr) {
        System.out.println(httpPackageStr);
        StringBuilder returnStr = new StringBuilder();
        returnStr.append("HTTP/1.1 200 ok\r\n");//增加响应消息行
        returnStr.append("Content-Type:text/html;charset=" + CHARSET + "\r\n");//增加响应消息头
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
                "    <p id=\"requestInfo\">\n" +
                httpPackageStr +     //返回请求头信息！
                "        \n" +
                "    </p>\n" +
                "</body>\n" +
                "</html>");//响应消息体

        System.out.println("返回内容：\n" + returnStr.toString());

        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.clear();
        try {
            buffer.put(returnStr.toString().getBytes(CHARSET));
        } catch (UnsupportedEncodingException e) {
            System.out.println("返回内容字节转换失败！");
            e.printStackTrace();
        }
        try {
            buffer.flip();
            channel.write(buffer);
        } catch (IOException e) {
            System.out.println("报文返回失败！");
            e.printStackTrace();
        }
        try {
            channel.close();
        } catch (IOException e) {
            System.out.println("channel关闭错误！");
            e.printStackTrace();
        }
    }

}
