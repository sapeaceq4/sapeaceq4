package com.sapient.ace.usecases;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Ravdeep Singh on 2/9/2017.
 */
public class Server {
    private static Executor pool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws IOException {
        final ServerSocket socket = new ServerSocket(9000);

        while (true){
            final Socket s = socket.accept();
            Runnable r = new Runnable() {
                public void run() {
                    try {
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
        byte []btyteArry = new byte[1024];
        InputStream stream = socket.getInputStream();
        int in = stream.read(btyteArry);
        System.out.println("Server output "+ in +" "+new String (btyteArry));

    }
}
