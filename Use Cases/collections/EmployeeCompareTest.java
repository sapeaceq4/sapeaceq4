package com.ace.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeCompareTest {

	public static void main(String[] args) {
		List<Employee> emp = new ArrayList<>();
		emp.add(new Employee(6,"Tulika"));
		emp.add(new Employee(1,"Srishti"));
		emp.add(new Employee(3,"Sachin"));
		emp.add(new Employee(2,"Alka"));
		emp.add(new Employee(4,"Lucky"));
		emp.add(new Employee(5,"Seema"));
		
		Collections.sort(emp);
		System.out.println("Sorted by employee id - ");
		for(Employee employee : emp)
			System.out.println(employee.getName());
		
		Collections.sort(emp, Employee.EmployeeNameComparator);
		System.out.println("Sorted by employee name - ");
		for(Employee employee : emp)
			System.out.println(employee.getName());
	}
	
}