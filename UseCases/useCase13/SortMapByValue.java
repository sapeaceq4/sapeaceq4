package data.session.usecases;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
//UseCase13
public class SortMapByValue {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("a", 10);
		map.put("b", 30);
		map.put("c", 50);
		map.put("d", 40);
		map.put("e", 20);
		System.out.println("Original map: " + map);

		Map<String, Integer> sortedMap = sortByValue(map);
		System.out.println("Sorted map: " + sortedMap);
	}

	public static Map<String, Integer> sortByValue(
			Map<String, Integer> unsortedMap) {
		Map<String, Integer> sortedMap = new TreeMap<>(new ValueComparator(
				unsortedMap));
		sortedMap.putAll(unsortedMap);
		return sortedMap;
	}

}

class ValueComparator implements Comparator<Object> {
	Map<String, Integer> map;

	public ValueComparator(Map<String, Integer> map) {
		this.map = map;
	}

	public int compare(Object keyA, Object keyB) {
		Integer valueA = map.get(keyA);
		Integer valueB = map.get(keyB);
		return valueA.compareTo(valueB);
	}
}
