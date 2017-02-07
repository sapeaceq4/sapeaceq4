package com.ace.usecase;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MergeSortTest {

	@Test
	public void testSort() {
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(45);
		list.add(23);
		list.add(56);
		list.add(21);
		System.out.println(list);
		System.out.println(MergeSort.sort(list));
		
	}

}
