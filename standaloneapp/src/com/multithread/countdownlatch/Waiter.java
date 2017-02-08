package com.multithread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Waiter implements Runnable {

	CountDownLatch latch = null;
	
	public Waiter(CountDownLatch latch){
		this.latch = latch;
	}
	
	@Override
	public void run(){
		try {
			latch.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Released!!");
	}
}
