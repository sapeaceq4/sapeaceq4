package data.session.exercises;

import java.util.Comparator;

public class Fruit implements Comparable<Fruit> {

	private String name;

	public Fruit(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Fruit f) {
		if(this.name.equals(f.name))
			return 1;
		else
			return 0;
	}

	public static Comparator<Fruit> FruitNameComparator
	= new Comparator<Fruit>() {

		public int compare(Fruit fruit1, Fruit fruit2) {
			String fruitName1 = fruit1.getName().toUpperCase();
			String fruitName2 = fruit2.getName().toUpperCase();
			//ascending order
			return fruitName1.compareTo(fruitName2);
			//descending order
			//return fruitName2.compareTo(fruitName1);
		}
	};
}
