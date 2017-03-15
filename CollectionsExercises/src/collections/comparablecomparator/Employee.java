package collections.comparablecomparator;

import java.util.Comparator;
import java.util.Random;

public class Employee {
	String id;
	int age;
	public String getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	
	Employee() {
		id = Integer.toString(new Random().nextInt(50000));
		age = new Random().nextInt(100);
		age = age<0 ? -age : age;
	}
	
	@Override
	public String toString() {
		return "Employee[id="+id+",age="+age+"]";
	}
}

class IdComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getId().compareTo(o2.getId());
	}
}

class AgeComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		return Integer.valueOf(o1.getAge()).compareTo(o2.getAge());
	}
}