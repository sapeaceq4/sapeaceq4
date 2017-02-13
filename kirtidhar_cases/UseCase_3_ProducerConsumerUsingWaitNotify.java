package com.sapient.ace.usecases;

import java.util.LinkedList;
import java.util.List;

public class UseCase_3_ProducerConsumerUsingWaitNotify {
	public static void main(String[] args) {
		List<Integer> sharedList = new LinkedList<Integer>();
		Thread producer1 = new Thread(new Producer(sharedList));
		producer1.setName("Producer-1");
		producer1.start();
		Thread consumer1 = new Thread(new Consumer(sharedList));
		consumer1.setName("Consumer-1");
		consumer1.start();
	}

}
