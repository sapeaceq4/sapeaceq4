package com.multithread.practice;

public class A implements Runnable {
	static int i =1;
	public static void main(String[] args) {
		System.out.println("test");
		System.out.println(" "+i++);
		System.out.println(++i);
	}
	
	@Override
	public void run() {
		System.out.println("Thread name: "+Thread.currentThread().getName());
	}

}
