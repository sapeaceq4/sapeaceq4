package useCases.collections.comparatorComparable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeCompareTest {

	public static void main(String[] args) {
		Employee emp1 = new Employee(1, "Dinesh");
		Employee emp2 = new Employee(2, "Deepak");
		Employee emp3 = new Employee(3, "Sumit");
		Employee emp4 = new Employee(4, "Prem");
		Employee emp5 = new Employee(5, "Mukul");
		
		List<Employee> empList = new ArrayList<Employee>();	
		empList.add(emp1);
		empList.add(emp4);
		empList.add(emp3);
		empList.add(emp2);
		empList.add(emp5);
		
		System.out.println("Before sorting");
		for (Iterator iterator = empList.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println("EmpId : "+employee.getId()+" , Name: "+employee.getName());
		}

		empList.sort(null);
		
		System.out.println("\nAfter Natural sorting");
		for (Iterator iterator = empList.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println("EmpId : "+employee.getId()+" , Name: "+employee.getName());
		}
		
		empList.sort(new EmployeeComparatorName());
		
		System.out.println("\nAfter sorting on Name");
		for (Iterator iterator = empList.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println("EmpId : "+employee.getId()+" , Name: "+employee.getName());
		}
	}

}
