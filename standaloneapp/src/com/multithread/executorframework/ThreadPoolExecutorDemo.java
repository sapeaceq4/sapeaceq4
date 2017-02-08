package com.multithread.executorframework;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorDemo {

	// Fixed Thread Pool Demo.
	// Fixed Thread pool is the thread pool in which no of worker thread are
	// predefined.
	// If task are less then the pool size,(Suppose that maximum pool size is 3
	// and submitted to the pool is 2),
	// number of worker thread will be less than the maximum pool size.
	// In the below example, only two worker threads will be instantiated
	// while maximum pool size is 3.

	public static void main(String[] args){
		Executor fixedThreadPool = Executors.newFixedThreadPool(3);
		for(int i=1;i<=8;i++){
			HelloTask hTask = new HelloTask("task"+i);
			fixedThreadPool.execute(hTask);
		}
	}
}

class HelloTask implements Runnable {

	private String name;

	public HelloTask(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(
				"I am hello task and the name is: " + this.name + " executed by " + Thread.currentThread().getName());

	}
}
