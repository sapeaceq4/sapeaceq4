package collections.sort;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BicycleSortingTest {
	public static void main(String[] args) {
		Map<Double, Bicycle> bicycles = new TreeMap<>();
		
		Scanner in = new Scanner(System.in);
		
		Double price = 0.0;
		bicycles.put(price = in.nextDouble(), new Bicycle(price));
		bicycles.put(price = in.nextDouble(), new Bicycle(price));
		bicycles.put(price = in.nextDouble(), new Bicycle(price));
		bicycles.put(price = in.nextDouble(), new Bicycle(price));
		
		System.out.println(bicycles);
	}
}
