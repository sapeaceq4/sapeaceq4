package collections.comparablecomparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class EmployeeArrayArrayListTest {
	public static void main(String[] args) {

		IdComparator idComparator = new IdComparator();
		AgeComparator ageComparator = new AgeComparator() ;
		
		// 1. array
		Employee[] arr = new Employee[5];
		
		for(int i=0;i<arr.length;i++)
			arr[i] = new Employee();
		
		Arrays.sort(arr, idComparator );
		System.out.println("sorted by id: ");
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}

		Arrays.sort(arr,ageComparator  );
		System.out.println("sorted by age: ");
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}

		//2. arraylist
		List<Employee> list = new ArrayList<>();
		list.add(new Employee());
		list.add(new Employee());
		list.add(new Employee());
		list.add(new Employee());
		list.add(new Employee());
		
		
		Collections.sort(list, idComparator);
		
		System.out.println("using Iterator:");
		Iterator itr = list.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
		
		Collections.sort(list, ageComparator );
		System.out.println("using ListIterator: ");
		ListIterator<Employee> listItr = list.listIterator();
		while(listItr.hasNext())
			System.out.println(listItr.next());
	}
}
