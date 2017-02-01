package useCases.collections;
public class Fruit implements Comparable<Fruit>{

	String fruitName;

	public Fruit(String name) {
		this.fruitName=name;
	}
	@Override
	public int compareTo(Fruit o) {
		// TODO Auto-generated method stub
		return this.fruitName.compareTo(o.fruitName);
	}
	
	@Override
	public boolean equals(Object obj) {
		Fruit f= (Fruit) obj;
		return(this.fruitName.equals(f.fruitName));
	}
	
	
}
