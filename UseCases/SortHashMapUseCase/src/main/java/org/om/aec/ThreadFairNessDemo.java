package org.om.aec;

import java.util.ArrayList;
import java.util.List;

public class ThreadFairNessDemo 
{
	private Object mutex = new Object();
	List<Thread> threads = new ArrayList<Thread>();
	private final String[] THREAD_NAMES = {"A", "B", "C"};
	private int index = 0;
	class Task implements Runnable
	{
		@Override
		public void run()
		{
			synchronized (mutex) 
			{
				while(!Thread.currentThread().getName().equals(THREAD_NAMES[0]))
				{
					try 
					{
						mutex.wait();
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args)
	{
		
	}
}
