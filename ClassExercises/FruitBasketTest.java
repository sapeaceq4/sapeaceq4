package data.session.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FruitBasketTest {

	public static void main(String[] args) {
		List<Fruit> fruitList = new ArrayList<>();
		for(int i=0; i<args.length;i++) {
			Fruit f = new Fruit(args[i]);
			fruitList.add(f);	
		}
		
		System.out.println("Input Fruits are -");
		for(Fruit fr : fruitList) {
			System.out.println(fr.getName());
		}
		Collections.sort(fruitList,Fruit.FruitNameComparator);
		System.out.println("Sorted Fruits are -");
		for(Fruit fr : fruitList) {
			System.out.println(fr.getName());
		}
	}

}
