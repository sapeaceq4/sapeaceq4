package useCases.collections.comparatorComparable.Bicycle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BicycleSortingTest {

	public static void main(String[] args) {
		Bicycle bicycleAtlas = new Bicycle(2000);
		Bicycle bicycleHero = new Bicycle(3000);
		Bicycle bicycleHercules = new Bicycle(2500);
		Bicycle bicycleDesi = new Bicycle(1500);

		List<Bicycle> cycles = new ArrayList<Bicycle>();
		cycles.add(bicycleAtlas);
		cycles.add(bicycleHero);
		cycles.add(bicycleHercules);
		cycles.add(bicycleDesi);

		for (Iterator iterator = cycles.iterator(); iterator.hasNext();) {
			Bicycle bicycle = (Bicycle) iterator.next();
			System.out.println("Cycle"+bicycle.getPrice());
		}
		cycles.sort(null);
		System.out.println("After sorting");
		for (Iterator iterator = cycles.iterator(); iterator.hasNext();) {
			Bicycle bicycle = (Bicycle) iterator.next();
			System.out.println("Cycle"+bicycle.getPrice());
		}
	}
}
