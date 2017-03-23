package classes;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		Map map = new HashMap<String, Integer>();
		map.put("a", 6);
		map.put("b", 5);
		map.put("c", 4);
		map.put("d", 3);
		map.put("e", 2);
		map.put("f", 1);

		System.out.println(SortHashMapByValues.SortMapByValues(map));
		System.out.println(SortHashMapByValues.SortMapByKeys(map));
	}

}
