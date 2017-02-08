package com.immutable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class ImmutableDeepCopyClassExample {

	private final int id;

	private final String name;

	private final HashMap<String, String> testMap;

	public ImmutableDeepCopyClassExample(int id, String name, HashMap<String, String> tMap) {
		this.id = id;
		this.name = name;
		HashMap<String, String> hashMap = new HashMap<>();
		Set<String> keySet = tMap.keySet();
		Iterator<String> itr = keySet.iterator();
		while (itr.hasNext()) {
			String key = itr.next();
			hashMap.put(key, tMap.get(key));
		}
		this.testMap = hashMap;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public HashMap<String, String> getTestMap() {
		return (HashMap<String, String>) testMap.clone();
	}

}