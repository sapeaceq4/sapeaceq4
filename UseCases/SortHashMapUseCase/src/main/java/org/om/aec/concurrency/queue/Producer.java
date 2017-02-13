package org.om.aec.concurrency.queue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable
{
	private BlockingQueue<Integer> queue;

	public Producer(BlockingQueue<Integer> queue)
	{
		this.queue = queue;
	}

	@Override
	public void run() 
	{
		int i = 0;
		while(true)
		{
			try 
			{
				Thread.sleep(100);
				System.out.println(Thread.currentThread().getName()+"-"+ ++i);
				queue.put(i);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
}