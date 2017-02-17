package com.sapient.ace.usecases;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class CustomCyclicBarrier {
	
	private int threads;
	private Runnable barrierCommand;

	CustomCyclicBarrier(int count, Runnable barrierCommand) {
		this.threads = count;
		this.barrierCommand = barrierCommand;
	}
	
	CustomCyclicBarrier(int count) {
		this(count, null);
	}
	
	
	public synchronized void await() throws InterruptedException {
		--threads;
		
		if (threads > 0) {
			System.out.println(Thread.currentThread().getName() + " is waiting at barrier.");
			this.wait();
		} else {
			System.out.println("All threads have arrived at barrier. Releasing all...");
			this.notifyAll();
			if (barrierCommand != null) {
				barrierCommand.run();
			}
		}
		
	}
}

class CustomTask implements Runnable { 

	private String taskName;
	CustomCyclicBarrier barrier;
	CustomTask(String taskName, CustomCyclicBarrier barrier) {
		this.taskName = taskName;
		this.barrier = barrier;
	}

	public String getName() {
		return taskName;
	}

	@Override
	public void run() {
		try {
			System.out.println(taskName + " is running");
			Thread.sleep(1000);
			barrier.await();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
};


class FinalTask implements Runnable { 

	private String taskName;
	FinalTask(String taskName) {
		this.taskName = taskName;
	}

	public String getName() {
		return taskName;
	}

	@Override
	public void run() {
		System.out.println(taskName + " is running");
	}
};

public class UseCase_5_CyclicBarrier{
	public static void main(String[] args) throws Exception {
		ExecutorService threadPool= Executors.newFixedThreadPool(3, new ThreadFactory() {
			int count = 0;
			@Override
			public Thread newThread(Runnable r) {
				Thread t = new Thread(r, "Pool-Thread-"+ ++count);
				return t;
			}
		}) ;
		CustomCyclicBarrier barrier = new CustomCyclicBarrier(3, new FinalTask("Final Task"));
		Runnable task=new CustomTask("Task 1", barrier);
		threadPool.execute(task);

		Runnable task2=new CustomTask("Task 2",barrier);
		threadPool.execute(task2);
		
		Runnable task3=new CustomTask("Task 3",barrier);
		threadPool.execute(task3);

		threadPool.shutdown();
	}

}
