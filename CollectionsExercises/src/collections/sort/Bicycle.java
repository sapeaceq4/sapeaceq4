package collections.sort;

public class Bicycle {
	private Double price;

	Bicycle(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "bicycle with price="+price;
	}
}
