package com.dove.lol.dovelol.demo.date201901.demo20190121;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Dovelol
 * @date 2019/1/21 22:21
 */
public class SocketServer {

    public static void main(String[] args) {
        start(9876);
    }

    public static void start(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket accept = serverSocket.accept();
                InputStream inputStream = accept.getInputStream();
                OutputStream outputStream = accept.getOutputStream();
                byte[] data = new byte[10];
                int len;
                while ((len = inputStream.read(data)) != -1) {
                    System.out.print(new String(data, 0, len));

                    outputStream.write(data);
                }
                outputStream.close();
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }


}
