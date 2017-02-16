package org.om.aec.concurrency.usecase;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HitCounterClient 
{
	public static void main(String[] args) throws InterruptedException, ExecutionException 
	{
		HitCounterHandler counterHandler = new HitCounterHandler();

		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		threadPool.submit(new Client(counterHandler));
		threadPool.submit(new Client(counterHandler));
		threadPool.submit(new Client(counterHandler));

		threadPool.shutdown();

	}
}

class Client implements Runnable
{
	private HitCounterHandler hitCounterHandler;
	
	Client(HitCounterHandler hitCounterHandler)
	{
		this.hitCounterHandler = hitCounterHandler;
	}
	
	@Override
	public void run() 
	{
		System.out.println(hitCounterHandler.hit());
	}
}
