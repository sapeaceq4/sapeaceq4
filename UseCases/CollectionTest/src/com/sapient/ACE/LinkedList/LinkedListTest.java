package com.sapient.ACE.LinkedList;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> ls= new LinkedList<String>();
		ls.add("Aman");
		ls.add("Akash");
		ls.add("Jatin");
		ls.add("Singh");
		ls.add("Ankur");
		ls.remove("Akash");
		for(String s:ls){
			System.out.println(s);
		}
	}

}
