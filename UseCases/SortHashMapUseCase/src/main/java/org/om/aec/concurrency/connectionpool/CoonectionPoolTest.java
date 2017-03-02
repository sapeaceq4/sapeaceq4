package org.om.aec.concurrency.connectionpool;

import org.om.aec.utils.CommonTools;

public class CoonectionPoolTest 
{
	public static void main(String[] args)
	{
		ConnectionPool connectionPool = new ConnectionPool(2);
		
		Thread t1 = new Thread(new Client("C1", connectionPool), "T1");
		Thread t2 = new Thread(new Client("C2", connectionPool), "T2");
		Thread t3 = new Thread(new Client("C3", connectionPool), "T3");
		Thread t4 = new Thread(new Client("C4", connectionPool), "T4");
		Thread t5 = new Thread(new Client("C5", connectionPool), "T5");
		Thread t6 = new Thread(new Client("C6", connectionPool), "T6");
		Thread t7 = new Thread(new Client("C7", connectionPool), "T7");
		Thread t8 = new Thread(new Client("C8", connectionPool), "T8");
		Thread t9 = new Thread(new Client("C9", connectionPool), "T9");
		Thread t10 = new Thread(new Client("C10", connectionPool), "T10");
		

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		
	}
}

class Client implements Runnable
{
	
	private ConnectionPool connectionPool;
	private String name;
	
	Client(String name, ConnectionPool connectionPool)
	{
		this.name = name;
		this.connectionPool = connectionPool;
	}
	
	public void run()
	{
		DBConnection connection = null;
		try 
		{
			connection = connectionPool.getConnection();
			System.out.println(connection +" is taken By-"+Thread.currentThread().getName());
			CommonTools.asleep(1000);
			System.out.println(this+ " ,Taken Connection"+ connection);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println(this+ " ,Close Connection"+ connection);
			connectionPool.closeConnection(connection);
		}
	}

	@Override
	public String toString() {
		return "Client [name=" + name + "]";
	}
}
