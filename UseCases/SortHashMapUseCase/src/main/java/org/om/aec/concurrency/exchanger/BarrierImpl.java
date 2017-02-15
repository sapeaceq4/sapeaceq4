package org.om.aec.concurrency.exchanger;

public class BarrierImpl implements IBarrier
{
	private int parties;
	private Object mutex;
	public int count;
	private Runnable runnable;
	private Gen gen;
	
	public BarrierImpl(int parties, Runnable runnable)
	{
		this.parties = parties;
		this.runnable = runnable;
		mutex = new Object();
		gen = new Gen();
	}
	
	class Gen
	{
		
	}
	
	private void checkBarrier(Gen localGen) throws InterruptedException
	{
		synchronized (mutex)
		{
			while(count < parties)
			{
				if(localGen != gen)
					break;
				mutex.wait();
			}
			
		}
	}
	
	public void await() throws InterruptedException
	{
		synchronized (mutex)
		{
			Gen localGen = gen;
			count++;
			if(count == parties)
			{
				runnable.run();
				mutex.notifyAll();
				count = 0;
				gen = new Gen();
			}
			checkBarrier(localGen);
		}
	}

	@Override
	public void reset() 
	{
		synchronized (mutex)
		{
			gen = new Gen();
			count = 0;
			mutex.notifyAll();
		}
	}
}
