package org.om.aec.concurrency.executors;

import java.util.concurrent.Executors;

public class ThreadPoolTest 
{
	public static void main(String[] args)
	{
		IThreadPool threadPool = new ThreadPool(Executors.defaultThreadFactory(), 1);
		threadPool.submit(new Task());
		threadPool.submit(new Task());
		//threadPool.shutDown();
	}
}

class Task implements Runnable
{
	public Task()
	{
		
	}
	@Override
	public void run() 
	{
		System.out.println("Run");
	}
}
