package com.ace.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CitizenTest {

	public static void main(String[] args) {
		List<Citizens> citList = new ArrayList<Citizens>();
		for(Citizens c : Citizens.values()) {
			citList.add(c);
		}
		
		System.out.println("Various Citizens are -");
		for(Citizens d : citList) {
			System.out.println(d);
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter what type of citizen you are");
		String s1 = sc.nextLine();
		
		Citizens cit1 = Enum.valueOf(Citizens.class, s1.toUpperCase());
		
		switch(cit1)
		 {
		 case  CHILD: System.out.println("The age range is between 0 to 18"); break;
		 case ADULT : System.out.println("The age range is between 18 to 60"); break;
		 case SENIOR_CITIZEN : System.out.println("The age range is above 65"); break;
		 default: System.out.println("Sorry Citizen type not found");
		 }
		
	}
}
