package com.sapient.ace.colcn.comprabl_ratr;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EmployeeCompareTest {
	private static List<Employee> emps = new LinkedList<>();

	public static void main(String[] args) {
		prepareData();
		System.out.println("Display before sorting");
		displayData();
		Collections.sort(emps);
		System.out.println("Display after sorting by Id");
		displayData();
		
		Collections.sort(emps, new CompareEmployeeByName());
		System.out.println("Display after sorting by Name");
		displayData();
	}

	private static void displayData() {
		for(Employee e : emps){
			System.out.print(e + "\t");
		}
		System.out.println();
	}

	private static void prepareData() {
		emps.add(new Employee(2, "Two"));
		emps.add(new Employee(3, "Three"));
		emps.add(new Employee(1, "One"));
		emps.add(new Employee(5, "Five"));
		emps.add(new Employee(6, "Six"));
		emps.add(new Employee(7, "Seven"));
		emps.add(new Employee(4, "Four"));
		emps.add(new Employee(8, "Eight"));
	}

}
