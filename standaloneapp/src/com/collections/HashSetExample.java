package com.collections;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {

	
	public static void main(String[] args) {
		
		HashSet<String> stringHashSet = new HashSet<>();
		
		stringHashSet.add("a");
		stringHashSet.add("A");
		stringHashSet.add("b");
		stringHashSet.add("B");
		stringHashSet.add("B");
		stringHashSet.add(null);
		stringHashSet.add(null);
		
		System.out.println(stringHashSet);
		
		Iterator<String> itr = stringHashSet.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
}
