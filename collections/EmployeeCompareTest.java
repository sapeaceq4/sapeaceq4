package com.sapient.ace.corejava.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sapient.ace.corejava.collections.Employee;

public class EmployeeCompareTest implements Comparator<Employee> {

	public static void main(String[] args) {
		Employee emp1 = new Employee("Rahul", 002, "Electrical");
		Employee emp2 = new Employee("Mohit", 001, "IT");
		Employee emp3 = new Employee("Parveen", 003, "Police");

		List<Employee> empList = new ArrayList<Employee>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);

		System.out.println("Print before sorting");
		for (Employee e : empList) {
			e.printEmployee();
		}
		// sort in natural order
		Collections.sort(empList);
		System.out.println("Print after sorting");
		for (Employee e : empList) {
			e.printEmployee();
		}

		// Sort by name using comparator
		Collections.sort(empList, new EmployeeCompareTest());
		System.out.println("Print after sortingusing comparator  ");
		for (Employee e : empList) {
			e.printEmployee();
		}
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getEmpName().compareTo(o2.getEmpName());
	}

}
