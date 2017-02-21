package org.rohit.usecase;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class ValueComparator implements Comparator<Map.Entry<String,Employee>>{

	@Override
	public int compare(Entry<String, Employee> o1, Entry<String, Employee> o2) {
		return o1.getValue().getId().compareTo(o2.getValue().getId());
	}

	
}
