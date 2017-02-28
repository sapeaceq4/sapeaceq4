package collections.arraylist;

import java.util.Scanner;


public class FruitBasketTest {

	public static void main(String[] args) {
		FruitBasket basket = new FruitBasket();
		
		Scanner in = new Scanner(System.in);
		
		basket.add(in.nextLine());
		basket.add(in.nextLine());
		basket.add(in.nextLine());
		basket.add(in.nextLine());
		basket.add(in.nextLine());
		System.out.println(basket);
		
		basket.sort();
		System.out.println("Sorted basket is: "+basket);
		
		System.out.println("Enter fruit name to search for: ");
		basket.search(in.nextLine());
		System.out.println("Enter fruit name to search for: ");
		basket.search(in.nextLine());
		System.out.println("Enter fruit name to search for: ");
		basket.search(in.nextLine());
		
		
		
	}
}
