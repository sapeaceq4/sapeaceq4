package com.immutable;

import java.util.HashMap;

public class TestDeepCopyImmutableClass {

	public final native Class<?> getTest();
	
	public static void main(String[] args) {
		
		int id  = 10;
		String name = "Shailendra";
		HashMap<String, String> hashmap =  new HashMap<>();
		hashmap.put("1", "first");
		hashmap.put("2", "two");
		
		ImmutableDeepCopyClassExample finalClass = new ImmutableDeepCopyClassExample(id, name, hashmap);
		
		System.out.println(finalClass.getId());
		System.out.println(finalClass.getName());
		System.out.println(finalClass.getTestMap());
		
		System.out.println(id==finalClass.getId());
		System.out.println(name==finalClass.getName());
		System.out.println(hashmap==finalClass.getTestMap());
		System.out.println(hashmap.equals(finalClass.getTestMap()));
		
		id = 20;
		name = "Sharma";
		hashmap.put("3", "Three");
		
		System.out.println("Modify Id "+finalClass.getId());
		System.out.println("Modify Name "+finalClass.getName());
		System.out.println("Modify Map "+finalClass.getTestMap());
		
		HashMap<String, String> newMap = finalClass.getTestMap();
		newMap.put("4", "four");
		
		System.out.println("Modify actual Map "+finalClass.getTestMap());
	}
}