package org.om.aec.concurrency.exchanger.future;

import java.util.concurrent.Callable;

public class FutureImpl<V> implements IFuture<V>
{
	private Callable<V> callable;
	private V value;
	private int progressPercentage = 0;
	private Throwable throwable;
	private volatile boolean isCompleted;
	public FutureImpl(Callable<V> callable)
	{
		this.callable = callable;
	}
	
	@Override
	public V get() 
	{
		
		if(throwable != null)
			throw new RuntimeException(throwable);
		return value;
	}

	@Override
	public boolean isDone() 
	{
		return isCompleted;
	}

	public void setProgressPercentage(int progressPercentage)
	{
		this.progressPercentage = progressPercentage;
	}
	
	@Override
	public int getProgressPercentage() 
	{
		return progressPercentage;
	}

	@Override
	public void run() 
	{
		try 
		{
			value = callable.call();
			setProgressPercentage(100);
		} 
		catch (Exception e) 
		{
			throwable= e;
		}
		isCompleted = true;
	}
}
