package org.rohit.mergesort;

import java.util.ArrayList;

public class MergeSortExample {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(5);
		list.add(2);
		list.add(9);
		list.add(3);
		list.add(8);
		list.add(4);
		list.add(10);
		list.add(6);
		list.add(7);
		list.add(11);
		list.add(12);
		MergeSort<Integer> m = new MergeSort<>(list);
		printList(list);
		list = m.sort(list);
		printList(list);
		///////////
		ArrayList<Employee> data = new ArrayList<Employee>();
		data.add(new Employee(1,"rohit"));
		data.add(new Employee(5,"tuleek"));
		data.add(new Employee(9,"rishi"));
		data.add(new Employee(10,"akash"));
		data.add(new Employee(2,"sashi"));
		data.add(new Employee(3,"akam"));
		data.add(new Employee(7,"r"));
		MergeSort<Employee> emp = new MergeSort<>(data);
		printList(data);
		data = emp.sort(data);
		printList(data);
		
		
		
		
		
	}
	public static <E>  void printList(ArrayList<E> list)
	{
		for(E e : list)
		{
			System.out.println(e+" ");
		}
		System.out.println();
	}
}
