package com.sorting;

import java.util.ArrayList;
import java.util.List;

public class TestSorting {

	public static void main(String[] args) {
		try {
			List<Employee> list =  getEmployeeList();
			System.out.println(list+" size "+list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static List<Employee> getEmployeeList() throws Exception{
		List<Employee> list = new ArrayList<>();
		for(int i=0;i<10;i++){
			Employee emp = new Employee();
			emp.setAge(20+i);
			emp.setName("A"+i);
			emp.setCompanyName("Comp"+i);
			emp.setSalary(new Long(50000+i));
			list.add(emp);
		}
		return list;
	}	
}