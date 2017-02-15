package org.om.aec.concurrency.executors.usecase;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DownloadManager
{
	private ExecutorCompletionService<DownloadEvent> completionService;
	private BlockingQueue<DownloadEvent> queues;
	
	public DownloadManager(BlockingQueue<DownloadEvent> queues)
	{
		this.queues = queues;
		this.completionService = 
				new ExecutorCompletionService<DownloadEvent>(Executors.newFixedThreadPool(2));
	}
	
	void putOnDownLoad(DownloadTask downloadTask)
	{ 
		putInitialDownloadEvent(downloadTask);
		completionService.submit(downloadTask);
	}

	private void putInitialDownloadEvent(DownloadTask downloadTask) {
		try 
		{
			queues.put(new DownloadEvent(downloadTask.getId(), false, "Download task submitted"));
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void init()
	{
		new Thread(new TaskCompletionWatcher(), "TaskCompletionWatcherThread").start();
		new Thread(new TaskStatusPrinter(), "TaskStatusPrinterThread").start();
	}
	
	
	class TaskStatusPrinter implements Runnable
	{	
		@Override
		public void run() 
		{
			while(true)
			{
				try 
				{
					DownloadEvent downloadEvent = queues.take();
					System.out.println(downloadEvent);
				} 
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	class TaskCompletionWatcher implements Runnable
	{
		@Override
		public void run() 
		{
			while(true)
			{
				try 
				{
					Future<DownloadEvent> future = completionService.take();
					queues.add(future.get());
				} 
				catch (ExecutionException | InterruptedException e) 
				{
					e.printStackTrace();
				} 
			}
		}
	}
}

