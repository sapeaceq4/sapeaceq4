package org.om.aec.concurrency.executors;

public interface IThreadPool 
{
	public void submit(Runnable runnable);
	public void shutDown();
	
}
