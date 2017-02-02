package useCases.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class TestHashSetAndTree {
	public static void main(String[] args) {
		
		Random rn = new Random();
		Set<Integer> randomNumbers = new HashSet<Integer>();
		
		for (int i = 0; i < 15; i++) {
			int rNo = rn.nextInt(10);
			randomNumbers.add(rNo);
		}
		
		System.out.println("Number In set are :");
		
		for (Iterator iterator = randomNumbers.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println("-->"+integer);
		}
		
		Set<Integer> sortedRandomNumbers = new TreeSet<Integer>();
		sortedRandomNumbers.addAll(randomNumbers);
		
		System.out.println("Number In set After Sorting are :");
		for (Iterator iterator = sortedRandomNumbers.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println("-->"+integer);
		}
	}
}
