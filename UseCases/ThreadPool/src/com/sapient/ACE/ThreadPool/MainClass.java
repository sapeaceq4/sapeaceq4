package com.sapient.ACE.ThreadPool;

public class MainClass {

	public static void main(String[] args) {
		MyThreadPool myThreadPool= new MyThreadPool(10);
		myThreadPool.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Aman");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("jot");
			}
		});
		myThreadPool.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Singh");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Singh");
			}
		});
		myThreadPool.shutdown();
	}
}
