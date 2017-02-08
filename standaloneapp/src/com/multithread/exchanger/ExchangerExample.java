package com.multithread.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerExample {

	Exchanger<String> exchanger = new Exchanger<>();
	
	
	private class Producer implements Runnable{
		private String queue;
		
		public void run(){
			try {
				queue = exchanger.exchange("Ready Queue");
				System.out.println(Thread.currentThread().getName()+" nos has "+queue);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private class Consumer implements Runnable  {
		private String queue;
		
		public void run(){
			try {
				queue = exchanger.exchange("Empty Queue");
				System.out.println(Thread.currentThread().getName()+" nos has "+queue);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	private void start(){
		new Thread(new Producer(),"producer").start();
		new Thread(new Consumer(),"consumer").start();
	}
	
	public static void main(String[] args) {
		new ExchangerExample().start();
	}
}

