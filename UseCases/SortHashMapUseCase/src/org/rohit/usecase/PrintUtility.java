package org.rohit.usecase;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class PrintUtility {
	
	public static <T,V>  void printMap(Map<T, V> map)
	{
		Set<T> keys = map.keySet();
		for(T t : keys)
		{
			System.out.print(t+" : ");
			System.out.println(map.get(t));
		}
		System.out.println("End ----");
	}
	
	public static void printList(List<Employee> values)
	{
		for(Employee name : values)
		{
			System.out.println(name);
		}
		
	}

}
