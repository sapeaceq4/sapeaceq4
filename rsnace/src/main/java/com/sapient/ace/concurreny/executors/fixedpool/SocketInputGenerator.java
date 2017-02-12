package com.sapient.ace.concurreny.executors.fixedpool;

import java.io.*;
import java.net.*;
import java.util.Date;

/**
 * Created by Ravdeep Singh on 12-02-2017.
 */

public class SocketInputGenerator implements Runnable {

    private String testServerName;
    private int port;

    public SocketInputGenerator(String testServerName, int port) {
        this.testServerName = testServerName;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            Socket socket = openSocket(testServerName, port);
            writeToAndReadFromSocket(socket, "Ping request at " + new Date(System.currentTimeMillis()));
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Socket openSocket(String server, int port) throws Exception {
        Socket socket;
        try {
            InetAddress inteAddress = InetAddress.getByName(server);
            SocketAddress socketAddress = new InetSocketAddress(inteAddress, port);
            socket = new Socket();
            int timeoutInMs = 10 * 1000;   // 10 seconds
            socket.connect(socketAddress, timeoutInMs);
            return socket;
        } catch (SocketTimeoutException ste) {
            System.err.println("Timed out waiting for the socket.");
            ste.printStackTrace();
            throw ste;
        }
    }

    private String writeToAndReadFromSocket(Socket socket, String writeTo) throws Exception {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write(writeTo);
            bufferedWriter.flush();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                sb.append(str + "\n");
            }

            // close the reader, and return the results as a String
            bufferedReader.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
