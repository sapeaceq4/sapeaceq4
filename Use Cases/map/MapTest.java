package com.ace.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
	
	private static Map<Integer, String> employeeMap = new HashMap<Integer, String>();;

	public static void main(String[] args) {
		employeeMap.put(1, "Tulika");
		employeeMap.put(2, "Srishti");
		employeeMap.put(3, "Alka");
		employeeMap.put(4, "Sachin");
		employeeMap.put(5, "Lucky");
		employeeMap.put(5, "Seema");
		
		displayEmployeeId(employeeMap);
		deleteId(employeeMap);

	}
	
	public static void displayEmployeeId(Map<Integer,String> employeeMap) {
		Set<Integer> keys = employeeMap.keySet();
		System.out.println("Employee Id's are -");
		for(Integer id : keys) {
			System.out.println(id);
		}
	}
	
	public static void deleteId(Map<Integer,String> employeeData) {
		if(employeeData.containsKey(4))
			employeeData.remove(4);
		Set<Integer> keys = employeeData.keySet();
		System.out.println("Employee's Ids after deleting id 4 are -");
		for(Integer id : keys) {
			System.out.println(id);
		}
	}

}
