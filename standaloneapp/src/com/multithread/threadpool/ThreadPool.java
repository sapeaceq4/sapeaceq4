package com.multithread.threadpool;

public class ThreadPool {

	public ThreadPool(int capacity){
		for(int i=0;i<capacity;i++){
			Thread thread = new Thread("Thread"+i){
				@Override
				public void run() {
					while(true){
						Runnable task = new MyTask();
						task.run();
					}
				}
			};
			thread.start();
		}
	}
}
