package collections.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeCompareTest {
	public static void main(String[] args) {

		Employee emp1 = new Employee("1", "e2");
		Employee emp2 = new Employee("2", "e1");

		List<Employee> list = new ArrayList<>();
		list.add(emp1);
		list.add(emp2);

		Collections.sort(list);
		System.out.println(list);

		Collections.sort(list, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		System.out.println(list);
	}
}

class Employee implements Comparable<Employee> {
	private String id;
	private String name;

	public Employee(String string, String string2) {
		id = string;
		name = string2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Employee o) {
		return this.id.compareTo(o.id);
	}

	@Override
	public String toString() {

		return "[" + id + ", " + name + "]";
	}

}