package com.sapient.ace.usecases;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class BlockingProducer implements Runnable {

	private BlockingQueue<Integer> sharedQueue;

	public BlockingProducer(BlockingQueue<Integer> sharedList) {
		this.sharedQueue = sharedList;
	}

	@Override
	public void run() {
		int count = 0;
		while (true) {
			synchronized(sharedQueue) {
				try {
					System.out.println("Producer:" + ++count);
					sharedQueue.put(count);
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class BlockingConsumer implements Runnable {

	private BlockingQueue<Integer> sharedList;

	public BlockingConsumer(BlockingQueue<Integer> sharedList) {
		this.sharedList = sharedList;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Consumer:"+sharedList.take());
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}

public class ProducerConsumerUsingBlockingQueue {
	public static void main(String[] args) {
		BlockingQueue<Integer> sharedList = new ArrayBlockingQueue<Integer>(5);
		new Thread(new BlockingProducer(sharedList)).start();
		new Thread(new BlockingConsumer(sharedList)).start();
	}
}
