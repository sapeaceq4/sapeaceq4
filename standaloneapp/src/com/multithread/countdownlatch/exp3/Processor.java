package com.multithread.countdownlatch.exp3;

import java.util.concurrent.CountDownLatch;

public class Processor {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		args  = new String[3];
		args[0] = "a";
		args[1]= "b";
		args[2] = "c";
		Thread t1 = new Thread(new FoodProcessor(latch, args));
		t1.start();
		try {
			System.out.println("order is received and processed");
			latch.await();
			System.out.println("order is processed successfully");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
