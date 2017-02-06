package data.session.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeCompareTest {

	public static void main(String[] args) {
		List<Employee> emp = new ArrayList<>();
		emp.add(new Employee(4,"Tim"));
		emp.add(new Employee(2,"Anna"));
		emp.add(new Employee(1,"Kate"));
		emp.add(new Employee(3,"John"));
		emp.add(new Employee(5,"Ben"));
		emp.add(new Employee(6,"Lisa"));
		
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
