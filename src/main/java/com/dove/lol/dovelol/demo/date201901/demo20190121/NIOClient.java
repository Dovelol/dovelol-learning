package com.dove.lol.dovelol.demo.date201901.demo20190121;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Dovelol
 * @date 2019/1/21 23:37
 */
public class NIOClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream out = socket.getOutputStream();
        String s = "hello world";
        out.write(s.getBytes());
        out.close();
    }
}
