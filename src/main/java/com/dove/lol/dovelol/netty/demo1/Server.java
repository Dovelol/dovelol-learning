package com.dove.lol.dovelol.netty.demo1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Dovelol
 * @date 2018/12/15 22:59
 */
public class Server {

    private ServerSocket serverSocket;

    public Server(final int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("服务端启动成功，端口:" + port);
        } catch (IOException e) {
            System.out.println("服务端启动失败");
        }
    }


    public void start() {
        new Thread(() -> doStart()).start();
    }

    private void doStart() {
        while (true) {
            try {
                Socket client = serverSocket.accept();
                new ClientHandler(client).start();
            } catch (IOException e) {
                System.out.println("服务端异常");
            }
        }


    }


}
