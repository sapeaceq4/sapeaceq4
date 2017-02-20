package com.sapient.ACE.Socket;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ServerSide {

	static Executor pool= Executors.newFixedThreadPool(5);
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket socket = new ServerSocket(9000);
		
		while(true){
			
			final Socket s= socket.accept();
			
			Runnable r= new Runnable() {
				
				@Override
				public void run() {

					try {
						doWork(s);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			};
			pool.execute(r);
		}
		
	}
	static void doWork(Socket s) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Executing ");
		BufferedInputStream b= new BufferedInputStream(s.getInputStream());
		System.out.println(b.read());
	}
	
}
