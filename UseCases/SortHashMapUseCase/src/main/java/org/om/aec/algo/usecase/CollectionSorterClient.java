package org.om.aec.algo.usecase;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.om.aec.utils.CommonTools;

public class CollectionSorterClient
{
	public static void main(String[] args)
	{
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("A", 1);
		map.put("D", 4);
		map.put("C", 3);
		map.put("B", 2);
		
		//LinkedHashMap<String, Integer> linkedHashMap = sortMapByValues(map);
		//System.out.println(linkedHashMap);
		
		LinkedHashMap<String, Integer> linkedHashMap = CommonTools.sortMapByValues(map, new Comparator<Entry<String, Integer>>() 
		{
			@Override
			public int compare(Entry<String, Integer> entry1,
					Entry<String, Integer> entry2) 
			{
				return entry1.getValue().compareTo(entry2.getValue());
			}
		});
		System.out.println(linkedHashMap);
		
	}
}
