package data.session.exercises;

import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		
		LinkedList<String> linkedList = new LinkedList<>();
		System.out.println("Input names - ");
		for(String name : args) {
			linkedList.add(name);
			System.out.println(name);
		}
		linkedList.remove(2); //Third friend removed
		
		System.out.println("Modified names - ");
		for(String printName : linkedList)
			System.out.println(printName);

	}

}
