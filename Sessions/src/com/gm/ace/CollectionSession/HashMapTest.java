package com.gm.ace.CollectionSession;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapTest {
public static void main(String[] args) {
	
	Map<Integer, String> employeMap = new HashMap<Integer, String>(32);
	
	employeMap.put(1, "Robert");
	employeMap.put(2, "Bob");
	employeMap.put(3, "Linds");
	employeMap.put(4, "Henry");
	
	System.out.println(employeMap.keySet());

	employeMap.remove(4);
	
	for(Map.Entry<Integer, String> entry  : employeMap.entrySet()){
		System.out.println(entry.getKey()  + " : "  + entry.getValue());
	}
	
	//Just for Check
	employeMap = new HashMap<Integer, String>(2,4.0f);
	employeMap.put(1, "Robert");
	employeMap.put(2, "Bob");
	employeMap.put(3, "Linds");
	employeMap.put(4, "Henry");
	
	employeMap.put(5, "Robert");
	employeMap.put(6, "Bob");
	employeMap.put(7, "Linds");
	employeMap.put(8, "Henry");
	
	employeMap = new HashMap<Integer, String>(1, 2f);
	
	employeMap.put(1, "Robert");
	employeMap.put(2, "Bob");
	employeMap.put(3, "Linds");
	employeMap.put(4, "Henry");
	
	employeMap.put(5, "Robert");
	employeMap.put(6, "Bob");
	employeMap.put(7, "Linds");
	employeMap.put(8, "Henry");
	
	Map<Integer, String> map = new LinkedHashMap<Integer, String>();
	map.put(1, "Robert");
	map.put(2, "Bob");
	map.put(3, "Linds");
	map.put(4, "Henry");
	
}
}
