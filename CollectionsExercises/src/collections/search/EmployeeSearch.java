package collections.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeSearch {
	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();
		
		emps.add(new Employee("1"));
		emps.add(new Employee("3"));
		emps.add(new Employee("2"));
		emps.add(new Employee("-1"));
		emps.add(new Employee("5"));
		System.out.println(emps);
		
		System.out.println(Collections.binarySearch(emps, new Employee("1"), new SortById()));
	}
}
