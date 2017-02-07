package com.sapient.ace.corejava.collections;

import java.util.ArrayList;
import java.util.List;

public class LinkedListExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Rahul");
		list.add("Monu");
		list.add("Ballu");
		list.add("Gaurav");
		list.add("Parveen");

		for (String s : list) {
			System.out.println(s);
		}
		// remove third friend
		list.remove(2);
		System.out.println("Print list after removing");

		for (String s : list) {
			System.out.println(s);
		}

	}

}
