package data.session.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class RandomTest {

	public static void main(String[] args) {
		Random random = new Random();
		Set<Integer> uniqueNoSet = new HashSet<>();
		for(int i=0;i<15;i++)
		{
			uniqueNoSet.add(random.nextInt(10));
		}
		System.out.println("Stored elements..");
		for(Integer number : uniqueNoSet) {
			System.out.println(number);
		}
		sortHashSetElements(uniqueNoSet);
		preSortedSet(uniqueNoSet);
		

	}
	
	public static void preSortedSet(Set<Integer> setOfNos) {
		Set<Integer> preSortedSet = new TreeSet<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		preSortedSet.addAll(setOfNos);
		System.out.println("Pre-Sorted elements(desc order)..");
		for(Integer number : preSortedSet) {
			System.out.println(number);
		}
	}
	
	public static void sortHashSetElements(Set<Integer> setOfNos) {
		System.out.println("Sorted elements(desc order)..");
		List<Integer> sortedSet = new ArrayList<>(setOfNos);
		Collections.sort(sortedSet, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		for(Integer sorted : sortedSet)
			System.out.println(sorted);
	}

}
