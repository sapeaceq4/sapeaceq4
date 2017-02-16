package org.om.aec.concurrency.exchanger.usecase;

import org.om.aec.concurrency.exchanger.ILatch;
import org.om.aec.concurrency.exchanger.LatchImpl;
import org.om.aec.utils.CommonTools;


public class PopulationCounterManager 
{
	private volatile long totalPopulation;

	private final ILatch latch;
	
	public PopulationCounterManager(ILatch latch)
	{
		this.latch = latch;
	}
	
	public long getTotalPopulation()
	{
		return totalPopulation;
	}
	
	Runnable runnable1 = new Runnable() 
	{
		
		@Override
		public void run() 
		{
			totalPopulation += 10;
			CommonTools.asleep(1000);
			latch.countDown();
		}
	};
	
	Runnable runnable2 = new Runnable() 
	{
		@Override
		public void run() 
		{
			totalPopulation += 50;
			CommonTools.asleep(2000);
			latch.countDown();
		}
	};
	
	private void init()
	{
		new Thread(runnable1, "T1").start();
		new Thread(runnable2, "T2").start();
	}
	public static void main(String[] args) throws InterruptedException 
	{
		ILatch latche = new LatchImpl(2);
		PopulationCounterManager populationCounterManager = new PopulationCounterManager(latche);
		System.out.println("Population counting start...");
		populationCounterManager.init();
		latche.await();
		System.out.println("Total population="+populationCounterManager.getTotalPopulation());
		
	}
}
