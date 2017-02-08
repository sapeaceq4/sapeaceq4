package com.multithread.consumproduce;

import java.util.LinkedList;

public class Consumer implements Runnable{

	private LinkedList<Integer> list;
	
	public Consumer(LinkedList<Integer> list) {
		this.list=list;
	}
	
	@Override
	public void run() {
		try {
			consumeData();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void consumeData() throws InterruptedException{
		while(true){
			synchronized (list) {
				while(list.isEmpty()){
					System.out.println("Wting for producer to put some data");
					list.wait();
					System.out.println("receve the notification from producer that data has been added");
				}
				int data = list.removeFirst();
				
				System.out.println("Consume data "+data);
			}
			Thread.sleep(1000);
		}
	}
}
