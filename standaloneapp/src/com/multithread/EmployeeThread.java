package com.multithread;

public class EmployeeThread extends Thread{

	
	@Override
	public void run() {
		System.out.println("thread start");
		//super.run();
	}

	public void run(String str) {
		System.out.println("thread start with params..");
		super.run();
	}
	
	public static void main(String[] args) {
		
		EmployeeThread t1 = new EmployeeThread();
		t1.start();
		//t1.run();
	}
}
