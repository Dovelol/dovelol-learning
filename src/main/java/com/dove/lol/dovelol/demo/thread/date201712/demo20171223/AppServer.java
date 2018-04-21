package com.dove.lol.dovelol.demo.thread.date201712.demo20171223;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Dovelol
 * @date 2017/12/23 9:00
 */
public class AppServer extends Thread {

    private int port;

    private static final int DEFAULT_PORT = 1223;

    private volatile boolean start = true;

    private List<ClientHandler> clientHandlers = new ArrayList<>();

    private final ExecutorService executor = Executors.newFixedThreadPool(10);

    private ServerSocket serverSocket;

    public AppServer() {
        this(DEFAULT_PORT);
    }

    public AppServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            while (start) {
                Socket client = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(client);
                executor.execute(clientHandler);
                this.clientHandlers.add(clientHandler);
                System.out.println(this.clientHandlers.size());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            this.dispose();
        }
    }

    private void dispose() {
        this.clientHandlers.stream().forEach(ClientHandler::stop);
        this.executor.shutdown();
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() throws IOException {
        this.serverSocket.close();
        this.start = false;
        this.interrupt();
    }
}
