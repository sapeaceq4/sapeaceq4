package com.sapient.ace.colcn.set;

import java.util.Comparator;

public class SortIntegerInDecendingOrder implements Comparator<Integer> {

	@Override
	public int compare(Integer newObj, Integer OldObj) {
		return OldObj.compareTo(newObj);
	}

}
