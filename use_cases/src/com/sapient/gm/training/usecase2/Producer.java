package com.sapient.gm.training.usecase2;

import java.util.LinkedList;

public class Producer implements Runnable {

	private LinkedList<Employee> employeeData;

	public Producer(LinkedList<Employee> employeeData) {
		this.employeeData = new LinkedList<>();
	}

	@Override
	public void run() {
		try {
			fillEmployeeDetails();
			Thread.sleep(1000);
			fillEmployeeDetails();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void fillEmployeeDetails() throws InterruptedException {
		for(int i=0;i<10;i++){
			Employee emp = new Employee();
			emp.setName("A"+i);
			emp.setAge(1);
			emp.setSalary(new Long(i+50000));
			synchronized (employeeData) {
				System.out.println("Start filling data...");
				employeeData.add(emp);
				employeeData.notify();
			}
			//System.out.println(employeeData);
			
		}
	}

}