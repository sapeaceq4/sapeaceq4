package org.rohit.usecase;

public class Employee implements Comparable<Employee> {
	
	private Integer id;
	private String name;
	
	public Employee(Integer id, String name) {
		this.id = id;
		this.name= name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// Need hashCode() and equals() in case you need to use this class as key
	
	@Override
	public int hashCode() {
		return id.hashCode()+name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Employee))
			return false;
		Employee emp = (Employee)obj;
		return this.id.equals(emp.getId()) & this.name.equals(emp.getName());   

	}
//----------------------------------------------------------------------------
	@Override
	public int compareTo(Employee o) {
		return this.id.compareTo(o.getId());
	}
	
	@Override
	public String toString() {
		return "Employee id - "+this.id+" : name - "+this.name ;
	}
	
}
