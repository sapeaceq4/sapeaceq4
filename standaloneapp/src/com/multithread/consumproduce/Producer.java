package com.multithread.consumproduce;

import java.util.LinkedList;

public class Producer implements Runnable {

	private LinkedList<Integer> list;
	
	public Producer(LinkedList<Integer> list) {
		this.list = list;
	}
	
	
	@Override
	public void run() {
		try {
			produceData();
			
			Thread.sleep(1000);
			
			produceData();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void produceData() throws InterruptedException{
		for(int data=0;data<3;data++){
			synchronized (list) {
				list.add(data);
				list.notify();
				
				System.out.println("produced "+data);
			}
		}
	}
}