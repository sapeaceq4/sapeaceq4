package com;

import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {

		ThreatTest t = new ThreatTest() {
			
			@Override
			public String a() {
				return "test";
			}
		};
		
		String a  = t.a();
		System.out.println("ThreadTest value : - "+a);
		
		Runnable runabble = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("calling run method..");
			}
		};
		
		HashSet hs = new HashSet();
		// add elements to the hash set
		hs.add("B");
		hs.add("A");
		hs.add("D");
		hs.add("E");
		hs.add("C");
		hs.add("F");
		System.out.println(hs);
		
		Set s = new HashSet<>();

	}
}