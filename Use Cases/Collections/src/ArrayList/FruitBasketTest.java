package ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FruitBasketTest {
	public static void main(String[] args) {
		List<Fruit> fruitBasket = new ArrayList<Fruit>();

		fruitBasket.add(new Fruit("Mango"));
		fruitBasket.add(new Fruit("Pineple"));
		fruitBasket.add(new Fruit("Orange"));
		fruitBasket.add(new Fruit("Grapes"));
		fruitBasket.add(new Fruit("Apple"));

		Collections.sort(fruitBasket);

		for (Fruit fruit : fruitBasket) {
			System.out.println(fruit);
		}

		System.out.println("is Apple Present "
				+ fruitBasket.contains(new Fruit("Pineple")));

		System.out.println("is Apple Present "
				+ fruitBasket.contains("Pineple"));
	}
}
