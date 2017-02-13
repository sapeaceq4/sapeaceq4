package com.sapient.ace.usecases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


class MyComparator implements Comparator<Map.Entry<String, Integer>> {

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		if (o1.getValue() > o2.getValue()) {
			return 1;
		} else 		if (o1.getValue() < o2.getValue()) {
			return -1;
		}
		return 0;
	}
}

public class UseCase_13_SortHashMapByValues {

	private Map<String, Integer> sortMap(Map<String, Integer> unsortedMap) {

		List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String,Integer>>(unsortedMap.entrySet());
		Collections.sort(entries, new MyComparator());

		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : entries) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;

	}

	public static void main(String[] args) {
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("Ram", 5);
		hashMap.put("Shyam", 3);
		hashMap.put("Peter", 1);

		System.out.println("Unsorted Map:" + hashMap);
		
		UseCase_13_SortHashMapByValues obj = new UseCase_13_SortHashMapByValues();

		System.out.println("Sorted Map:" + obj.sortMap(hashMap));
	}

}
