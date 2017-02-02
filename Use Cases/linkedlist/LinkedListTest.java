package com.ace.linkedlist;

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListTest {

	public static void main(String[] args) {

		LinkedList<String> linkedList = new LinkedList<>();
		System.out.println("Enter names of your 5 friends - ");
		
		for (int i = 0; i<5; i++) {
		Scanner scanner = new Scanner(System.in);
		linkedList.add(scanner.nextLine());
		}
		
		System.out.println("Names of your friends are -");
		for (String name : linkedList) {
			System.out.println(name);
		}
		System.out.println("Removing third name -");
		
		linkedList.remove(2); // remove name of third friend

		System.out.println("Modified names - ");
		for (String printName : linkedList)
			System.out.println(printName);

	}

}