package com.multithread.blockingque;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {

	public static void main(String[] args) {
		System.out.println("arguments "+args);
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);
		
		Producer p = new Producer(queue);
		Consumer c = new Consumer(queue);
		
		new Thread(p).start();
		System.out.println("Producer started!");
		new Thread(c).start();
		System.out.println("Consumer Started!");
		
		/*try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}
}
