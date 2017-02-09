package org.om.aec;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server 
{
	private ExecutorService  executorService; 
	
	public Server()
	{
		executorService = Executors.newFixedThreadPool(5);
	}
	
	public void process(Socket socket)
	{
		try 
		{
			InputStream inputStream = socket.getInputStream();
			byte[] data = new byte[100];
			inputStream.read(data);
			for (byte b : data) {
				System.out.println(b);
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void startServer()
	{
		ServerSocket server = null;
		try 
		{
			server = new ServerSocket(9000);
			while(true)
			{
				final Socket socket = server.accept();
				executorService.submit(new Runnable() {
					
					public void run() 
					{
						process(socket);
					}
				});
				
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(server != null)
					server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) 
	{
		Server server = new Server();
		server.startServer();
	}
}
