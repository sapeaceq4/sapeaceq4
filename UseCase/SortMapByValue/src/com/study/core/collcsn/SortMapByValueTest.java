package com.study.core.collcsn;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortMapByValueTest {

	public static void main(String[] args) {
		Map<Integer, Integer> intMap = prepareIntData();
		
		System.out.println("Sorted traditionaly ...");
		Map<Integer, Integer> sortedMap = SortMapByValue.sortByValue(intMap);

		Set<Entry<Integer, Integer>> entrySet = sortedMap.entrySet();
		for (Entry<Integer, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}

		System.out.println("sorted from Lembda expression...");

		Map<Integer, Integer> sortedMapFromLembda = SortMapByValuesUsingLembda.sortByValue(intMap);

		Set<Entry<Integer, Integer>> entrySetFromLembda = sortedMapFromLembda.entrySet();
		entrySetFromLembda.forEach((e) -> System.out.println(e.getKey() + ", " + e.getValue()));
	}

	private static Map<Integer, Integer> prepareIntData() {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 5);
		map.put(2, 4);
		map.put(3, 7);
		map.put(4, 3);
		map.put(5, 9);
		return map;
	}

}
