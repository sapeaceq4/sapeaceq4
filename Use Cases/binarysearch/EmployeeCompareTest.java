package com.ace.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeCompareTest {

	public static void main(String[] args) {
		List<Employee> emp = new ArrayList<>();
		Employee e = new Employee(1,"Tulika");
		emp.add(e);
		emp.add(new Employee(6,"Srishti"));
		emp.add(new Employee(3,"Sachin"));
		emp.add(new Employee(2,"Alka"));
		emp.add(new Employee(4,"Lucky"));
		emp.add(new Employee(5,"Seema"));
		
		Collections.sort(emp);
		System.out.println("Searching for Tulika based on sorting by id - ");
		System.out.println(Collections.binarySearch(emp, e));
		
		Collections.sort(emp, Employee.EmployeeNameComparator);
		System.out.println("Searching for Tulika based on sorting by name - ");
		System.out.println(Collections.binarySearch(emp, e, Employee.EmployeeNameComparator));
	}
	
}