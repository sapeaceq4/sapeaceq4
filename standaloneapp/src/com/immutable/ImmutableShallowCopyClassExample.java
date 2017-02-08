package com.immutable;

import java.util.HashMap;

public final class ImmutableShallowCopyClassExample {

	private final int id;

	private final String name;

	private final HashMap<String, String> testMap;

	public ImmutableShallowCopyClassExample(int id, String name, HashMap<String, String> tMap) {
		this.id = id;
		this.name = name;
		this.testMap = tMap;
		/*HashMap<String, String> hashMap = new HashMap<>();
		Set<String> keySet = tMap.keySet();
		Iterator<String> itr = keySet.iterator();
		while (itr.hasNext()) {
			String key = itr.next();
			hashMap.put(key, tMap.get(key));
		}
		this.testMap = hashMap;*/
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