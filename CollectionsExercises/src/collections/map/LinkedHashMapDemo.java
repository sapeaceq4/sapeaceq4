package collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
	public static void main(String[] args) {
		Map<String,String> lhm = new LinkedHashMap<>();
		
		lhm.put("1", "one");
		lhm.put("2", "two");
		lhm.put("3", "three");
		lhm.put("4", "four");
		lhm.put("5", "five");
		
		for(Map.Entry<String, String> entry: lhm.entrySet()){
			System.out.println(entry.getKey()+", "+entry.getValue());
		}
	}
}
