package collections.set;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class HashSetTreeSet {
	public static void main(String[] args) {
		Random rand = new Random();

		Set<Float> set = new HashSet<>();
		for (int i = 0; i < 15; i++) {
			set.add(10 * rand.nextFloat());
		}
		System.out.println(set);

		List<Float> list = new ArrayList<Float>(set);
		Collections.sort(list, Collections.reverseOrder());
		set = new LinkedHashSet<Float>(list);
		System.out.println(set);
		
		set = new TreeSet<>(set);
		System.out.println(set);
		
	}
}
