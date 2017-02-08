package com.immutable;

import java.util.HashMap;
import java.util.Iterator;

public final class ImmutableClassExample {

	private final int i;
	private final String a;
	private final HashMap<String, String> hashmap;

	public ImmutableClassExample(int i, String a, HashMap<String, String> hashmap) {
		this.i = i;
		this.a = a;
		HashMap<String, String> tempHashmap = new HashMap<>();
		Iterator<String> itr = hashmap.keySet().iterator(); 
		while(itr.hasNext()){
			String key = itr.next();
			tempHashmap.put(key, hashmap.get(key));
		}
		
		this.hashmap = tempHashmap;
	}

	public int getI() {
		return i;
	}

	public String getA() {
		return a;
	}

	public HashMap<String, String> getHashmap() {
		return (HashMap<String, String>) hashmap.clone();
	}	
}