package collections.search;

public class Employee {
	String id;

	public String getId() {
		return id;
	}
	
	public Employee(String s) {
		id = s;
	}
	
	@Override
	public String toString() {
		return "Employee["+id+"]";
	}
}

class SortById implements java.util.Comparator<Employee> {
	public int compare(Employee o1, Employee o2) {
		return o1.getId().compareTo(o2.getId());
	}
 }