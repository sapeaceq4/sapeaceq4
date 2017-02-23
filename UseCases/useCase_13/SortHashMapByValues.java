package sorting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortHashMapByValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer,Integer> unsortedMap = new HashMap<Integer,Integer>();
				
		unsortedMap.put(1, 5);
		unsortedMap.put(2, 1);
		unsortedMap.put(3, 8);
		
		Map<Integer,Integer> sortedMap = new TreeMap<Integer,Integer>(new MyComparator(unsortedMap));
		sortedMap.putAll(unsortedMap);
		
		System.out.println(sortedMap);
		
		
		
		

	}
	
	static class MyComparator implements Comparator{
		private Map<Integer, Integer> map;

		MyComparator(Map<Integer, Integer> map) {
			this.map = map;	
		}

		public int compare(Object keyA, Object keyB) {
			Integer value1 = (Integer) map.get(keyA);
			Integer value2 = (Integer) map.get(keyB);
			return value1.compareTo(value2);
		}
	}

}
