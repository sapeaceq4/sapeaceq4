package com.sapient.ace.concurrency.executors.fixedpool;

/**
 * Created by Ravdeep Singh on 12-02-2017.
 */

public class SocketClient {
    public static void main(String[] args) {

        String testServerName = "localhost";
        int port = 9000;
        SocketInputGenerator inputGenerator = new SocketInputGenerator(testServerName, port);
        Thread clients[] = new Thread[20];
        for (int i = 0; i < 20; i++) {
            clients[i] = new Thread(inputGenerator, "Client-" + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clients[i].start();
        }

    }


}
