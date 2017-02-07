package com.sapient.usecases.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class EmployeeCompareUsingArrays {

	public static void main(String[] args) {
		
		Employee[] empArray = new Employee[6];
		empArray[0] = new Employee(6,"Tulika", 26);
		empArray[1] = new Employee(1,"Srishti", 27);
		empArray[2] = new Employee(3,"Sachin", 32);
		empArray[3] = new Employee(2,"Alka", 29);
		empArray[4] = new Employee(4,"Lucky", 28);
		empArray[5] = new Employee(5,"Seema", 31);
		
		Arrays.sort(empArray);
		
		System.out.println("Sorted by employee id - ");
		for(Employee employee : empArray)
			System.out.println(employee.getName());
		
		Arrays.sort(empArray, new EmployeeAgeComparator());
		
		System.out.println("Sorted by employee Age - ");
		for(Employee employee : empArray)
			System.out.println(employee.getName());
		
		List<Employee> emp = Arrays.asList(empArray);
		
		Collections.sort(emp);
		System.out.println("Sorted by employee id - ");
		Iterator<Employee> itr = emp.iterator();
		while(itr.hasNext()) {
			Employee e = itr.next();
			System.out.println(e.getName());
		}
	
}
}

class EmployeeAgeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		Integer empAge1 = e1.getAge();
		Integer empAge2 = e2.getAge();
		return empAge1.compareTo(empAge2);
	}

}
