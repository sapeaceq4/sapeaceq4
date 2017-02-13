package org.om.aec.concurrency.queue;

import java.util.concurrent.BlockingQueue;
	
public class Consumer implements Runnable
{
	private BlockingQueue<Integer> queue;

	public Consumer(BlockingQueue<Integer> queue)
	{
		this.queue = queue;
	}

	@Override
	public void run() 
	{
		while(true)
		{
			try 
			{
				System.out.println(Thread.currentThread().getName()+"-"+ queue.take());
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
}