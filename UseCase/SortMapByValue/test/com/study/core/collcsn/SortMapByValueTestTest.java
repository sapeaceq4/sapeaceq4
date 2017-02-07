package com.study.core.collcsn;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortMapByValueTestTest {
	private Map<Integer, Integer> map;

	@Before
	public void setUp() throws Exception {
		map = new HashMap<>();
		map.put(1, 5);
		map.put(2, 4);
		map.put(3, 7);
		map.put(4, 3);
		map.put(5, 9);
	}

	@Test
	public void testSortByValue() {
		Map<Integer, Integer> sortByValue = SortMapByValue.sortByValue(map);
		helper(sortByValue);
	}

	private void helper(Map<Integer, Integer> sortByValue) {
		Assert.assertTrue(map.size() == 5);
		Integer previous = null;
		for(Map.Entry<Integer, Integer> entry : sortByValue.entrySet()){
			Assert.assertNotNull(entry.getValue());
			if(previous != null){
				Assert.assertTrue(entry.getValue() >= previous);
			}
			previous = entry.getValue();
		}
	}

	@Test
	public void testSortByValueUsingLembda() {
		Map<Integer, Integer> sortByValue = SortMapByValuesUsingLembda.sortByValue(map);
		helper(sortByValue);
	}

}
