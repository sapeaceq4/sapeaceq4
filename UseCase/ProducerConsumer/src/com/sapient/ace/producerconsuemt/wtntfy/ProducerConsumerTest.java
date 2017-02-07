package com.sapient.ace.producerconsuemt.wtntfy;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerTest {

	public static void main(String[] args) {
		Queue<Integer> buffer = new LinkedList<>();
        int maxSize = 10;
        
        Thread producer = new Thread(new Producer(buffer, maxSize));
        Thread consumer = new Thread(new Consumer(buffer));
        
        producer.start();
        consumer.start();

	}

}
