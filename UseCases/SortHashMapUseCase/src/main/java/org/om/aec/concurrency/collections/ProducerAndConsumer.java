package org.om.aec.concurrency.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerAndConsumer
{
	public static void main(String[] args) 
	{
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1);
		Thread t1 = new Thread(new Producer(queue), "ProducerThread");
		Thread t2 = new Thread(new Consumer(queue), "ConsumerThread");
		t1.start();
		t2.start();
	}
}

class Producer implements Runnable
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
				System.out.println("Produce-"+ ++i);
				queue.put(i);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable
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
				System.out.println("Consumed-"+ queue.take());
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
}

