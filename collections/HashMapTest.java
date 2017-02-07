package com.sapient.ace.corejava.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(001, "Steve");
		map.put(002, "Rob");
		map.put(003, "Peter");
		map.put(004, "Mark");
		map.put(005, "John");
		map.put(006, "Tom");

		for (Integer i : map.keySet()) {
			System.out.println(map.get(i));
		}

		map.remove(004);
		System.out.println("After removing");
		for (Integer i : map.keySet()) {
			System.out.println(map.get(i));
		}

	}

}
