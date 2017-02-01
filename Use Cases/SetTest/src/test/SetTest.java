package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {

		Random RndNmbr = new Random();
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> sortedSet = new TreeSet<Integer>();

		for (int i = 0; i < 10; i++) {
			set.add(RndNmbr.nextInt(10));
		}

		List<Integer> li = new ArrayList<Integer>(set);

		Collections.sort(li, (o1, o2) -> {
			return o1.compareTo(o2) * -1;
		});

		for (Integer in : li) {
			System.out.println(in);
			sortedSet.add(in);
		}

		for (Integer in : sortedSet) {
			System.out.println(in);
		}

	}
}
