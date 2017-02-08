package com.multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locktest {

	private final Lock lock = new ReentrantLock();
	private int value  =1;
	
	public int increment(){
		lock.lock();
		try {
			return ++value;
		} finally{
			lock.unlock();	
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Locktest().increment());
	}
}
