package org.om.aec.concurrency.executors;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;

public class ThreadPool implements IThreadPool
{
	private Set<Worker> workers;
	private ThreadFactory threadFactory;
	private BlockingQueue<Runnable> tasks;
	private int poolSize;
	
	public ThreadPool(ThreadFactory threadFactory, int poolSize)
	{
		this.threadFactory = threadFactory;
		this.poolSize = poolSize;
		this.tasks = new LinkedBlockingQueue<Runnable>();
		this.workers = new HashSet<Worker>();
	}
	
	class Worker implements Runnable
	{
		private Thread thread;

		Worker()
		{
			thread = threadFactory.newThread(this);
		}

		@Override
		public void run()
		{
			try 
			{
				Runnable runnable;
				while((runnable = tasks.take()) != null && !thread.isInterrupted())
				{
					runnable.run();
				}
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		public void start()
		{
			thread.start();
		}

		public void stop() 
		{
			thread.interrupt();
		}
	}
	
	public void submit(Runnable runnable)
	{
		tasks.add(runnable);
		if(workers.size() < poolSize)
		{
			Worker worker = new Worker();
			workers.add(worker);
			worker.start();
		}
	}

	@Override
	public void shutDown() 
	{
		for(Worker worker : workers)
		{
			worker.stop();
		}
	}
}
