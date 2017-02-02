package com.gm.ace.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.ArrayDeque;

public class ComparatorClass {
	public static void main(String[] args) {
		TestComparator t1 = new TestComparator(4);
		TestComparator t2 = new TestComparator(3);
		TestComparator t3 = new TestComparator(6);

		SortedSet<TestComparator> set = new TreeSet<TestComparator>(
				new TestComparator(6));
		set.add(t1);
		set.add(t2);
		set.add(t3);

		set.forEach(test -> {
			System.out.println(test.getId());
		});

		System.out.println("---------------");
		TestComparator2 t11 = new TestComparator2(17);
		TestComparator2 t22 = new TestComparator2(13);
		TestComparator2 t33 = new TestComparator2(6);
		// TestComparator2 t44 = new TestComparator2(8);

		SortedSet<TestComparator2> set2 = new TreeSet<TestComparator2>();
		set2.add(t11);
		set2.add(t22);
		set2.add(t33);

		set2.forEach(test -> {
			System.out.println(test.getId());
		});
		
		System.out.println("---------------");
		Set<TestComparator2> s = new HashSet<TestComparator2>();
		s.add(t11);
		s.add(t22);
		s.add(t33);
		
	
		Collections.synchronizedList(Arrays.asList(s));
		
		s.forEach(test -> {
			System.out.println(test.getId());
		});
		
		ArrayDeque<Integer> ad = new ArrayDeque<Integer>();

	}
}

class TestComparator implements Comparator<TestComparator> {
	Object o;
	private int id;

	public TestComparator(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compare(TestComparator o1, TestComparator o2) {
		if (o1.id >= o2.id) {
			return 1;
		} else {
			return 0;
		}
	}
}

class TestComparator2 implements Comparable<Object> {

	private int id;

	public TestComparator2(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		TestComparator2 comparator2 = (TestComparator2) obj;
		return (this.id == comparator2.id);
	}

	@Override
	public int hashCode() {
		return this.getId();
	}

	@Override
	public int compareTo(Object o) {
		TestComparator2 test = (TestComparator2) o;
		return test.id - this.id;
	}

}
