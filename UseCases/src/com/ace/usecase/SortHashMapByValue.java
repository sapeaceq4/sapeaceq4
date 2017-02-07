package com.ace.usecase;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
/**
 * Sort hash map by valuesWrite program to find largest and second largest element in an unsorted array
 * @author asi233
 *
 */
public class SortHashMapByValue {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("first", "A");
		map.put("second","B");
		map.put("third", "C");
		map.put("fourth", "D");
		map.put("fifth", "E");
		System.out.println(map);
		
		Map<String, String> sortedMap = SortHasmapbyvalue(map, true);
		System.out.println("sortedMap: " + sortedMap);
		
 	}

	/**
	 * 
	 * @param map
	 * SortOrder for ascending and descending 
	 * @param sortOrder
	 */
	private static Map<String, String> SortHasmapbyvalue(Map<String, String> map, boolean sortOrder) {
			List<Entry<String, String>> list = new LinkedList<Entry<String, String>>(map.entrySet());
			list.sort(new Comparator<Entry<String, String>>() {

				@Override
				public int compare(Entry<String, String> o1,
						Entry<String, String> o2) {
					if(sortOrder){
						return o1.getValue().compareTo(o2.getValue());
					}else {
						return o2.getValue().compareTo(o1.getValue());
					}
				}
			});
			System.out.println(list);
			Map<String, String> sortedMap = new LinkedHashMap<String, String>();
			for(Entry<String, String> entry :  list){
				sortedMap.put(entry.getKey(), entry.getValue());
			}
			System.out.println(sortedMap);
			return sortedMap;
	}
}
