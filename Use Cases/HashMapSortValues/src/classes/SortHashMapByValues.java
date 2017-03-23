package classes;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class SortHashMapByValues {

	public static Set SortMapByValues(final Map map) {
		// comparator for sortByValue
		Comparator<Entry<String, Integer>> sortByValue = (o1, o2) -> o1
				.getValue().compareTo(o2.getValue());
		Set set = new TreeSet<Entry<String, Integer>>(sortByValue);
		map.entrySet().forEach(set::add);
		return set;
	}

	public static Set SortMapByKeys(final Map map) {
		// comparator for sortByValue
		Comparator<Entry<String, Integer>> sortByKey = (o1, o2) -> o1.getKey()
				.compareTo(o2.getKey());
		Set set = new TreeSet<Entry<String, Integer>>(sortByKey);
		map.entrySet().forEach(set::add);
		return set;
	}
}
