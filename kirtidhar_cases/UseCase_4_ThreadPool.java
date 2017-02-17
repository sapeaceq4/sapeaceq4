package com.sapient.ace.usecases;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ThreadPool {

	private BlockingQueue<Runnable> sharedTaskQueue;

	private boolean poolShutDownInitiated = false;

	public ThreadPool(int count){
		sharedTaskQueue = new LinkedBlockingQueue<Runnable>(count);

		for(int i=1; i<=count; i++){

			WorkerThread worker = new WorkerThread(sharedTaskQueue,this);
			worker.setName("Thread-"+i);
			worker.start();  
		}
	}


	public void  execute(Runnable task) throws Exception{
		if(this.poolShutDownInitiated) {
			throw new Exception("ThreadPool has been shutDown, no further tasks can be submitted");
		}

		this.sharedTaskQueue.put(task);
	}


	public boolean isPoolShutDownInitiated() {
		return poolShutDownInitiated;
	}


	public synchronized void shutdown(){
		this.poolShutDownInitiated = true;
		System.out.println("ThreadPool Shutdown initiated.");
	}

}

class WorkerThread extends Thread {

	private BlockingQueue<Runnable> sharedTaskQueue;
	private ThreadPool threadPool;

	public WorkerThread(BlockingQueue<Runnable> queue,
			ThreadPool threadPool){
		sharedTaskQueue = queue;
		this.threadPool=threadPool;

	}

	public void run() {
		try {
			while (true) {    
				Runnable runnable = sharedTaskQueue.take();
				System.out.println(Thread.currentThread().getName() +" is executing " + ((Task)runnable).getName());
				
				runnable.run();                

				System.out.println(Thread.currentThread().getName() +" has executed task.");

				if(this.threadPool.isPoolShutDownInitiated() &&  this.sharedTaskQueue.size()==0) {
					this.interrupt();

					Thread.sleep(1);  
				}   
			}
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName()+" has been Stopped.");
		}
	}
}

class Task implements Runnable { 

	private String taskName;
	Task(String taskName) {
		this.taskName = taskName;
	}

	public String getName() {
		return taskName;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
};


public class UseCase_4_ThreadPool{
	public static void main(String[] args) throws Exception {
		ThreadPool threadPool=new ThreadPool(2); 
		Runnable task=new Task("Task 1");
		threadPool.execute(task);

		Runnable task2=new Task("Task 2");
		threadPool.execute(task2);

		threadPool.shutdown();
		
		Runnable task3=new Task("Task 3");
		threadPool.execute(task2);

	}

}
