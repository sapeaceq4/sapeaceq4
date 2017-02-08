package com.multithread.blockingque;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private BlockingQueue<String> queue;
	
	public Consumer(BlockingQueue<String> queue){
		this.queue= queue;
	}
	
	@Override
	public void run(){
		try {
			while(true){
				System.out.println(queue.take());
			}
		} catch (InterruptedException e) {
		}
	}
}
