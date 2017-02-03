package com.sapient.gm.training.usecase2;

import java.util.LinkedList;

public class ProdConsumTest {

	public static void main(String[] args) {
		LinkedList<Employee> employeeList = new LinkedList<>();
		
		Runnable producer = new Producer(employeeList);
		System.out.println("employeeList "+employeeList);
		Runnable consumer = new Consumer(employeeList);
		try {
			Thread t1 = new Thread(producer);
			Thread t2 = new Thread(consumer);
			t1.start();
			t2.start();
			t1.join();
		} catch (InterruptedException e) {
				e.printStackTrace();
		}

	}
}
