package org.om.aec.concurrency.executors;

import java.util.concurrent.Callable;

import org.om.aec.concurrency.exchanger.future.IFuture;

public interface IThreadPool 
{
	public <T> IFuture<T> submit(Callable<T> runnable);
	public void shutDown();
	
}
