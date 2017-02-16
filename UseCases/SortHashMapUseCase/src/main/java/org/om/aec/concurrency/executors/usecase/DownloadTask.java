package org.om.aec.concurrency.executors.usecase;

import java.util.concurrent.Callable;

public abstract class DownloadTask implements Callable<DownloadEvent>
{
	protected int taskId;
	public DownloadTask(int taskId)
	{
		this.taskId = taskId;
	}
	
	public int getId() 
	{
		return taskId;
	}
	
	@Override
	public DownloadEvent call() throws Exception 
	{
		return start();
	}
	
	protected abstract DownloadEvent start();
}
