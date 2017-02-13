package org.om.aec;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable
{
	private Socket socket;

	public Client(Socket socket)
	{
		this.socket = socket;
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException 
	{  
		Client client = new Client(new Socket("localhost",9000));
		Thread thread = new Thread(client);
		thread.start();
	}

	@Override
	public void run() 
	{
		int value = 0;
		while(true)
		{
			try
			{
				DataOutputStream dout = new DataOutputStream(socket.getOutputStream());  
				dout.writeUTF("Hello Server"+ value++); 
				//dout.close();
			}catch(Exception e){System.out.println(e);} 
 
			asleep(1000);
		}
	} 
	
	private void asleep(long millis)
	{
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}  
