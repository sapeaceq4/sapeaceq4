package com.multithread;

public class GreetingRunnableTest {

	public static void main(String[] args) {
		
		Runnable runnable = new GreetingRunnable(false, "hello");
		System.out.println(Thread.currentThread().getName()+" Thread Hello is starting..");
		Thread t1 = new Thread(runnable);
		t1.start();
		System.out.println(Thread.currentThread().getName()+" Thread Hello started...");
		
		t1.interrupt();
		Runnable runnable1 = new GreetingRunnable(true, "Dear");
		System.out.println(Thread.currentThread().getName()+" Thread Dear is starting..");
		Thread t2 = new Thread(runnable1);
		t2.start();
		System.out.println(Thread.currentThread().getName()+" Thread Dear has been started..");
		
		
		Thread test = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Currently Running...");
				
			}
		});{
			test.start();
			System.out.println("Code executed before join...");
		}
		
		try {
			test.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}