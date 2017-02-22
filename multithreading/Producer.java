package com.sapient.ace.multithreading;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	private final BlockingQueue<Integer> sharedQueue;

	public Producer(BlockingQueue<Integer> queue) {
		this.sharedQueue = queue;
	}

	@Override
	public void run() {
		Random random = new Random();
		while (true) {
			int i = random.nextInt(10);
			try {
				sharedQueue.put(i);
				System.out.println("Produced: " + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
