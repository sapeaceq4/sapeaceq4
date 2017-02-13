package com.sapient.ace.usecases;

import java.util.LinkedList;
import java.util.List;

public class UseCase_2_TenProducerTenConsumerUsingWaitNotify {
	public static void main(String[] args) {
		List<Integer> sharedList = new LinkedList<Integer>();

		for (int i=1;i<=10;i++) {
			Thread producer = new Thread(new Producer(sharedList));
			producer.setName("Producer-" + i);
			producer.start();
			Thread consumer = new Thread(new Consumer(sharedList));
			consumer.setName("Consumer-" + i);
			consumer.start();
		}
	}

}
