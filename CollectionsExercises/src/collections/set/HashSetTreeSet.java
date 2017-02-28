package collections.set;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HashSetTreeSet {
	public static void main(String[] args) {
		Random rand = new Random();
		
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<15;i++) {
			set.add(rand.nextInt(10));
		}
		System.out.println(set);
		
		Arrays.sort(set.toArray(Integer[] a), new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
			
		});
	}
}
