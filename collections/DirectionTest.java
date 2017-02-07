package com.sapient.ace.corejava.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sapient.ace.corejava.collections.Direction;

public class DirectionTest {
	public static void main(String args[]) {
		List<Direction> directionList = new ArrayList<Direction>();
		Direction directionArray[];
		directionArray = Direction.values();
		for (Direction direction : directionArray)
			directionList.add(direction);
		for (Direction direction : directionList)
			System.out.println(direction);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter first direction");
		String input1 = scanner.next();

		System.out.println("Please enter second direction");
		String input2 = scanner.next();

		Direction direction1 = Direction.valueOf(input1.toUpperCase());
		Direction direction2 = Direction.valueOf(input2.toUpperCase());
		// Direction.check(direction1);
		// Direction.check(direction2);
		if (direction1 == direction2) {
			System.out.println("Directions entered are equal");
		} else {
			System.out.println("Directions entered are not equal");
		}
		scanner.close();
	}

}
