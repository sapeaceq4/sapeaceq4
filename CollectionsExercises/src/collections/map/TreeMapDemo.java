package collections.map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
	public static void main(String[] args) {
		Map<String,String> tm = new TreeMap<>();
		
		tm.put("1", "one");
		tm.put("2", "two");
		tm.put("4", "four");
		tm.put("3", "three");
		tm.put("5", "five");
		
		for(Map.Entry<String, String> entry: tm.entrySet()){
			System.out.println(entry.getKey()+", "+entry.getValue());
		}
	}
}
