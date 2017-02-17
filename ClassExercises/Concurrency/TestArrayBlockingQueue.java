package Concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestArrayBlockingQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(5);
		
		Thread t = new Thread(new Consumer(arrayBlockingQueue));
		t.start();
		
		Thread t2 = new Thread(new Producer(arrayBlockingQueue));
		t2.start();

	}

}
