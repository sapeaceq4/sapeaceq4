package com.sapient.ace.usecases;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CustomCountDownLatch {

	private int count;

	CustomCountDownLatch(int count) {
		this.count = count;
	}

	public synchronized void await() throws InterruptedException {
		if (count > 0) {
			this.wait();
		}
	}

	public synchronized void countDown() throws InterruptedException {
		--count;
		if (count == 0) {
			this.notifyAll();
		}
	}
}

class Task1 implements Runnable { 

	private String taskName;
	CustomCountDownLatch countDownLatch;
	Task1(String taskName, CustomCountDownLatch barrier) {
		this.taskName = taskName;
		this.countDownLatch = barrier;
	}

	public String getName() {
		return taskName;
	}

	@Override
	public void run() {
		try {
			System.out.println(taskName + " is running");
			Thread.sleep(1000);

			System.out.println(taskName + " is waiting for Task2 to be finished");
			countDownLatch.await();
			System.out.println(taskName + " is finished");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
};

class Task2 implements Runnable { 

	private String taskName;
	CustomCountDownLatch countDownLatch;

	Task2(String taskName, CustomCountDownLatch barrier) {
		this.taskName = taskName;
		this.countDownLatch = barrier;
	}

	public String getName() {
		return taskName;
	}

	@Override
	public void run() {
		try {
			System.out.println(taskName + " is running");
			Thread.sleep(2000);
			System.out.println(taskName + " is finished");
			countDownLatch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
};

public class UseCase_5_CountDownLatch{
	public static void main(String[] args) throws Exception {
		ExecutorService threadPool= Executors.newFixedThreadPool(3) ;
		CustomCountDownLatch barrier = new CustomCountDownLatch(1);
		Runnable task=new Task1("Task 1", barrier);
		threadPool.execute(task);

		Runnable task2=new Task2("Task 2",barrier);
		threadPool.execute(task2);

		threadPool.shutdown();
	}

}
