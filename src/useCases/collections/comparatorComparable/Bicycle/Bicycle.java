package useCases.collections.comparatorComparable.Bicycle;

public class Bicycle implements Comparable<Bicycle> {
	private int price;
	
	public Bicycle(int price) {
		this.price=price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int compareTo(Bicycle o) {
		return this.getPrice()-o.getPrice();
	}

	
}
