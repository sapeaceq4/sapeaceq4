package com.sapient.ace.producerconsuemt.blockingq;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerconsumerTest {

	public static void main(String[] args) {
		BlockingQueue<Integer> sharedQ = new LinkedBlockingQueue<>();
		
		Thread producerThread = new Thread(new Producer(sharedQ));
		Thread consumerThread = new Thread(new Consumer(sharedQ));
		
		producerThread.start();
		consumerThread.start();

	}

}
