package org.om.aec.concurrency.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerAndConsumer
{
	public static void main(String[] args) 
	{
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1);
		Thread t1 = new Thread(new Producer(queue), "Producer");
		Thread t2 = new Thread(new Consumer(queue), "Consumer");
		t1.start();
		t2.start();
	}
}



