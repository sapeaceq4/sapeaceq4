package org.om.aec.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CommonTools 
{
	private CommonTools(){}
	
	public static void printArray(int[] input)
	{
		for (int value : input) 
		{
			System.out.println(value);
		}
	}
	
	public static void asleep(long millis)
	{
		try 
		{
			Thread.sleep(millis);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static <K,V> LinkedHashMap<K, V> sortMapByValues(Map<K,V> map,
			Comparator<Entry<K, V>> comparator)
	{
		List<Entry<K, V>> entries = new ArrayList<Entry<K, V>>(map.entrySet());
		Collections.sort(entries, comparator);
		LinkedHashMap<K, V> linkedHashMap = new LinkedHashMap<K, V>();
		for (Entry<K, V> entry : entries) 
		{
			linkedHashMap.put(entry.getKey(), entry.getValue());
		}
		return linkedHashMap;
	}
	
	public static <K,V> LinkedHashMap<K, V> sortMapByValues(Map<K,V> map)
	{
		List<Entry<K, V>> entries = new ArrayList<Entry<K, V>>(map.entrySet());
		Collections.sort(entries, new Comparator<Entry<K, V>>() 
		{
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public int compare(Entry<K, V> entry1, Entry<K, V> entry2) 
			{
				if(entry1.getValue() instanceof Comparable && entry2.getValue() instanceof Comparable)
				{
					Comparable comparable1 = (Comparable)entry1.getValue();
					Comparable comparable2 = (Comparable)entry2.getValue();
					return comparable1.compareTo(comparable2);
				}
				else
				{
					throw new RuntimeException("value must be a comparable type");
				}
			}
		});
		
		LinkedHashMap<K, V> linkedHashMap = new LinkedHashMap<K, V>();
		for (Entry<K, V> entry : entries) {
			linkedHashMap.put(entry.getKey(), entry.getValue());
		}
		
		return linkedHashMap;
	}
}
