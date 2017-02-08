package com.multithread.blockingque;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

	private BlockingQueue<String> queue;
	
	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		int i =10;
		while(i<20){
			queue.add(""+i);
			i++;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}