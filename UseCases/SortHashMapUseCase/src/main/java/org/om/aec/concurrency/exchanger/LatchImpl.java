package org.om.aec.concurrency.exchanger;



public class LatchImpl implements ILatch
{
	private int count;
	private final Object mutex;
	
	public LatchImpl(int count)
	{
		if(count <=0)
			throw new IllegalArgumentException("Count value must be greater than zero");
		this.count = count;
		this.mutex = new Object();
	}
	
	@Override
	public void countDown()
	{
		synchronized (mutex) 
		{
			if(--count == 0)
				mutex.notifyAll();
		}
	}

	@Override
	public void await() throws InterruptedException
	{
		synchronized (mutex) 
		{
			while(count > 0)
			{
				mutex.wait();
			}
		}
	}
}
