package com.sapient.ace.concurreny.executors.fixedpool;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Ravdeep Singh on 2/9/2017.
 */


public class SocketServerExecutor {
    private static ExecutorService pool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws IOException {
        final ServerSocket socket = new ServerSocket(9000);

        while (true){
            final Socket s = socket.accept();
            Runnable r = new Runnable() {
                public void run() {
                    try {
                        System.out.printf(" \n Current worker" + Thread.currentThread().getName());
                        doWork(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };

            pool.execute(r);
        }

    }

    private static void doWork(Socket socket) throws IOException {
        byte[] byteArray = new byte[1024];
        InputStream stream = socket.getInputStream();
        int in = stream.read(byteArray);
        System.out.println("\n SocketServerExecutor output " + in + " " + new String(byteArray));

    }
}
