package com.sapient.ace.multithreading;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private final BlockingQueue<Integer> sharedQueue;

	public Consumer(BlockingQueue<Integer> queue) {
		this.sharedQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Consumed: " + sharedQueue.take());
			} catch (InterruptedException ex) {
				System.out.println(ex.getMessage());
			}

		}

	}
}
