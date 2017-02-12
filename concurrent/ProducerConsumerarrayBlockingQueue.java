package com.prac.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class ProducerConsumerarrayBlockingQueue {

	public static void main(String[] args) {
		BlockingQueue<Integer> bq =new ArrayBlockingQueue<>(5);
		Thread p=new Thread(new Producer(bq));
		Thread c=new Thread(new Consumer(bq));
		p.start();
		c.start();
		
		
	}

}

class Producer implements Runnable{
	BlockingQueue<Integer> bq;
	Producer(BlockingQueue<Integer> bq){
		this.bq=bq;
		
	}
	@Override
	public void run() {
		try {
			bq.put(100);
			System.out.println("Added");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

class Consumer implements Runnable{
	BlockingQueue<Integer> bq;
	Consumer(BlockingQueue<Integer> bq){
		this.bq=bq;
		
	}
	@Override
	public void run() {
		try {
			System.out.println("Removed"+ bq.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
