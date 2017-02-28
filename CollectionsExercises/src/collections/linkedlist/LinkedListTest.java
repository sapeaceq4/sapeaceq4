package collections.linkedlist;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LinkedListTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<String> friends = new LinkedList<>();
		
		int i=1;
		do {
			System.out.println("Enter the name of friend "
					+ i
					+ " of 5: ");
			friends.add(in.nextLine());
			i++;
		}while(i<6);
		
		friends.remove(2);
		
		
		System.out.println("Friends are: ");
		for(String friend: friends)
			System.out.println(friend);
	}
}
