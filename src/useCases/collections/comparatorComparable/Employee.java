package useCases.collections.comparatorComparable;

public class Employee  implements Comparable<Employee>{
	//id should be positive
	private int id;
	private String name;
	
	public Employee(int id, String name) {
		this.id=id;
		this.name=name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
		return (this.getId()-o.getId());
	}
	
}
