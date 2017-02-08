package com.multithread.executorframework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Runnable runnableThead = new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+" is running..");
				
			}
		};
		
		Callable<String> callableThread = new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				return "Good Bye!!";
			}
		};
		
		ScheduledExecutorService schedulePool = Executors.newScheduledThreadPool(4);
		schedulePool.scheduleWithFixedDelay(runnableThead, 1, 1, TimeUnit.SECONDS);
		ScheduledFuture<String> sf = schedulePool.schedule(callableThread, 6, TimeUnit.SECONDS);
		String value = sf.get();
		System.out.println("callable retunr value is "+value);
		schedulePool.shutdown();
		System.out.println("Is ScheduledThreadPool shutting down? "+schedulePool.isShutdown());
		
	}
}
