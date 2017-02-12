package com.prac.concurrent;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	
	private static ExecutorService es= Executors.newFixedThreadPool(10);
	
	
	public Server(){
		
	}
	

	public static void main(String[] args) throws IOException {
		ServerSocket socket = new ServerSocket(9000);
		while(true){
			final Socket s = socket.accept();
			Runnable r = new Runnable() {
				
				@Override
				public void run() {
					try {
						doWork(s);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				
			};
			
			es.execute(r);
			
		}
		
	}
	
	static void doWork(Socket s) throws IOException {
		int num = s.getInputStream().read();
		System.out.println(num);
	}

}
