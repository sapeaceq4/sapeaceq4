package com.multithread.printoddevennumber;

import java.util.ArrayList;
import java.util.List;

public class MyThread {

	public static void main(String[] args) {
		Thread t1 = new Thread(new EvenNumberThread());
		Thread t2 = new Thread(new OddNumberThread());
		
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		
		List<Integer> l2 = new ArrayList<>();
		l2.add(3);
		l2.add(2);
		l2.add(1);
		
		System.out.println(l1.equals(l2));
		
		
		
		t1.start();
		
		try {
			t1.join();
			Thread.currentThread().sleep(1000);
			
			t2.start();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
