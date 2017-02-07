package com.study.core.collcsn;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortMapByValuesUsingLembda {

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> entryList = new LinkedList<>(map.entrySet());
		entryList.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : entryList) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
}
