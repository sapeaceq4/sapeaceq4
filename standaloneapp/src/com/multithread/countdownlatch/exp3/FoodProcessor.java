package com.multithread.countdownlatch.exp3;

import java.util.concurrent.CountDownLatch;

public class FoodProcessor implements Runnable{

	private CountDownLatch latch;
	private String[] items;
	
	public FoodProcessor(CountDownLatch latch,String[] items) {
		this.latch = latch;
		this.items = items;
	}
	@Override
	public void run(){
		for(int i=0;i<items.length;i++){
			try {
				System.out.println("Before - Count Down Latch Count "+latch.getCount());
				Thread.sleep(2000);
				System.out.println("item "+items[i]+" Prepared");
				latch.countDown();
				System.out.println("After - Count Down Latch Count "+latch.getCount());
				System.out.println("-------------");
			} catch (Exception e) {

			}
		}
	}
}
