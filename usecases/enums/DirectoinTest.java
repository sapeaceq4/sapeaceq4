package com.sapient.usecases.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DirectoinTest {

	public static void main(String[] args) {
		List<Directions> dirList = new ArrayList<Directions>();
		dirList.add(Directions.NORTH);
		dirList.add(Directions.SOUTH);
		dirList.add(Directions.EAST);
		dirList.add(Directions.WEST);
		
		System.out.println("Printing Directions -");
		for(Directions d : dirList) {
			System.out.println(d);
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter 2 directions");
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		
		Enum<Directions> dir1 = Enum.valueOf(Directions.class, s1.toUpperCase());
		Enum<Directions> dir2 = Enum.valueOf(Directions.class, s2.toUpperCase());
		
		if(dir1==dir2) {
			System.out.println("Directions are equal");
		} else {
			System.out.println("Directions are not equal");
		}
		
	}
}
