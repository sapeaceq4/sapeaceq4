package com.sapient.ace.corejava.collections;

import java.util.Scanner;

public class CitizenTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter type of citizen");
		String input = scanner.next();

		Citizen citizen = Citizen.valueOf(input.toUpperCase());
		Citizen.check(citizen);
		scanner.close();
	}

}
