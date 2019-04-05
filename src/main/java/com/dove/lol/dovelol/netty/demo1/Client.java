package com.dove.lol.dovelol.netty.demo1;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/12/15 23:18
 */
public class Client {

    private static final String HOST = "127.0.0.1";

    private static final int PORT = 8848;

    private static final int SLEEP_TIME = 5000;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(HOST, PORT);
            new Thread(() -> {
                while (true) {
                    String message = "hello world";
                    System.out.println("客户端发送数据:" + message);
                    try {
                        socket.getOutputStream().write(message.getBytes());

                    } catch (IOException e) {
                        System.out.println("写数据出错！");
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(SLEEP_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
