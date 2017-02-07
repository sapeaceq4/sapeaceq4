package com.study.core.collcsn;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortMapByValue {

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> entryList = new LinkedList<>(map.entrySet());
		Collections.sort(entryList, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Entry<K, V> o1, Entry<K, V> o2) {
				return ((o1.getValue().compareTo(o2.getValue())));
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : entryList) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
}
