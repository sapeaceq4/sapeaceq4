package CompareTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EmployeeCompareTest {

	public static void main(String[] args) {
		List<Employee> li = new ArrayList<Employee>();
		li.add(new Employee(6, "aman"));
		li.add(new Employee(5, "abhi"));
		li.add(new Employee(4, "alok"));
		li.add(new Employee(3, "tashi"));
		li.add(new Employee(2, "gaurav"));
		li.add(new Employee(1, "akash"));

		Collections.sort(li);

		for (Employee e : li) {
			System.out.println(e);
		}

		Collections.sort(li, new EmployeeNameComparator());

		for (Employee e : li) {
			System.out.println(e);
		}

	}
}
