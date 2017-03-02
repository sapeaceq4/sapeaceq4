package org.om.aec.concurrency.connectionpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool 
{
	private int noOfConnection;
	private int usedConnection = 0;
	public Object mutex = new Object();
	
	private BlockingQueue<DBConnection> usedConnectionBlockingQueue;
	private BlockingQueue<DBConnection> availableConnectionBlockingQueue;
	
	private int connectionId;
	
	public ConnectionPool(int noOfConnection)
	{
		this.noOfConnection = noOfConnection;
		usedConnectionBlockingQueue = new ArrayBlockingQueue<DBConnection>(noOfConnection);
		availableConnectionBlockingQueue = new ArrayBlockingQueue<DBConnection>(noOfConnection);
	}
	
	public void closeConnection(DBConnection connection)
	{
		synchronized (mutex) 
		{
			if(usedConnectionBlockingQueue.contains(connection))
			{
				usedConnectionBlockingQueue.remove(connection);
				availableConnectionBlockingQueue.add(connection);
				if(usedConnection >= noOfConnection)
				{
					mutex.notifyAll();
				}
				usedConnection--;
				
				System.out.println("Used Connections:"+ usedConnectionBlockingQueue.size()
						+ " ,Available Coonections:"+ availableConnectionBlockingQueue.size());
			}
			else
			{
				System.out.println("Provided Conenction not taken from this pool.");
			}
		}
	}
	
	public DBConnection getConnection() throws InterruptedException
	{
		synchronized (mutex) 
		{
			while(usedConnection >= noOfConnection)
			{
				mutex.wait();
			}
			if(availableConnectionBlockingQueue.size() == 0)
			{
				usedConnection++;
				DBConnection connection = new DBConnection(++connectionId);
				usedConnectionBlockingQueue.add(connection);
				return connection;
			}
			else
			{
				usedConnection++;
				DBConnection connection = availableConnectionBlockingQueue.take();
				usedConnectionBlockingQueue.add(connection);
				return connection;
			}
		}
	}
}
