package com.ace.generics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TraineeBatchTest {

	public static void main(String[] args) {
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		List<String> list1 = Arrays.asList("Tulika", "Sachin", "Mohit");
		List<String> list2 = Arrays.asList("Tulika1", "Sachin1", "Mohit1");
		List<String> list3 = Arrays.asList("Tulika2", "Sachin2", "Mohit2");
 		map.put(1, list1);
 		map.put(2, list2);
 		map.put(3, list3);

 		Set<Integer> set = map.keySet();
		for(int i : set) {
			System.out.println(map.get(i));
		}
	}
}
