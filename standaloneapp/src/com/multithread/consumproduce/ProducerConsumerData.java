package com.multithread.consumproduce;

import java.util.LinkedList;

public class ProducerConsumerData {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		
		Producer producer = new Producer(list);
		Consumer consumer = new Consumer(list);
		
		Thread pThread = new Thread(producer);
		Thread cThread = new Thread(consumer);
		
		System.out.println("ffffffffffffffffffff");
		
		pThread.start();
		cThread.start();
	}
}