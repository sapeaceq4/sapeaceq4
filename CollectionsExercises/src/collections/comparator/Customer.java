package collections.comparator;

public class Customer {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public Customer(int id){
		this.id = id;
		this.name = String.valueOf(id);
	}
	
	@Override
	public String toString() {
		return "Customer[id="+id+",name="+name+"]";
	}
}
