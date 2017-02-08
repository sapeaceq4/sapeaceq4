package com.multithread;

import java.util.ArrayList;

public class CounterDemo implements Runnable{

	private int counter = 0;
	
	public static void main(String[] args) throws Exception{
		CounterDemo counterDemo = new CounterDemo();
		java.util.List<Thread> threadList = new ArrayList<>();
		
		int noOfThreads = 5;
		for(int i=1;i<=noOfThreads;i++){
			Thread th1 = new Thread(counterDemo);
			threadList.add(th1);
			th1.start();
		}
		
		for (Thread thread : threadList) {
			thread.join();
		}
		
		System.out.println("Expected counter: "+noOfThreads +" Actual Counter "+counterDemo.counter);
	}
	
	@Override
	public void run() {
		System.out.println("Hi "+counter);
		counter++;
		
	}
}
