package com.dove.lol.dovelol.demo.thread.date201712.demo20171223;

import java.io.*;
import java.net.Socket;

/**
 * @author Dovelol
 * @date 2017/12/23 9:18
 */
public class ClientHandler implements Runnable {

    private final Socket socket;

    private volatile boolean running = true;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
             PrintWriter printWriter = new PrintWriter(outputStream)) {
            while (running) {
                String message = br.readLine();
                if (message == null) {
                    break;
                }
                System.out.println("Come from client >" + message);
                printWriter.write("echo " + message + "\n");
                printWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.stop();
        }
    }

    public void stop() {
        if (!running) {
            return;
        }
        this.running = false;
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
