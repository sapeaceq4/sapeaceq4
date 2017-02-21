package org.rohit.usecase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SortHashMapByValues {

	public static void main(String[] args) {
		Map<String, Employee> empDetails = new HashMap<String, Employee>();
		empDetails.put("Rohit",new Employee(1, "Rohit"));
		empDetails.put("Rishi",new Employee(5, "Rishi"));
		empDetails.put("Akash",new Employee(2, "Akash"));
		empDetails.put("Puneeta",new Employee(4, "Puneeta"));
		PrintUtility.printMap(empDetails);
		List<Map.Entry<String, Employee>> list = new ArrayList<>(empDetails.entrySet());
		Collections.sort(list, new ValueComparator());
		for(Map.Entry<String, Employee> m : list)
		{
			System.out.println(m.getValue());
		}
	}

}
