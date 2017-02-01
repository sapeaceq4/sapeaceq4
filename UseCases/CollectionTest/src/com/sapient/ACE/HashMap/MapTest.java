package com.sapient.ACE.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {

		Map<Integer,String> hashMap= new HashMap<Integer,String>();
		hashMap.put(1,"Aman");
		hashMap.put(2,"Akash");
		hashMap.put(3,"Nav");
		hashMap.put(4,"Am");
		hashMap.put(5,"Ak");
		Set<Integer> s= hashMap.keySet();
		for(Integer i: s){
			System.out.println(i+hashMap.get(i));
		}
		
		hashMap.remove(4);
		for(Integer i: s){
			System.out.println(i+hashMap.get(i));
		}
	}

}
