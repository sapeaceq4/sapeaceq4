package com.sapient.gm.training.usecase2;

import java.util.LinkedList;

public class Consumer implements Runnable {

	private LinkedList<Employee> employeeData;
	
	public Consumer(LinkedList<Employee> employeeData){
		this.employeeData = new LinkedList<>();
	}
	
	@Override
	public void run(){
		try {
			readEmployee();
			Thread.sleep(1000);
			readEmployee();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void readEmployee() throws InterruptedException{
		while(true){
			synchronized(employeeData){
				while(employeeData.isEmpty()){
					System.out.println("Waiting for employee data...");
					employeeData.wait();
					System.out.println("now receved the employee data");
					System.out.println("Employee data "+employeeData);
				}
			}
			Thread.sleep(1000);
		}
	}
}
