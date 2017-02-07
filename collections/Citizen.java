package com.sapient.ace.corejava.collections;

public enum Citizen {
	CHILD, ADULT, SENIOR_CITIZEN;

	public static void check(Citizen citizen) {
		switch (citizen) {
		case CHILD:
			System.out.println("The age range is between 0 to 18");
			break;
		case ADULT:
			System.out.println("South foundThe age range is between 18 to 60");
			break;
		case SENIOR_CITIZEN:
			System.out.println("The age range is above 65");
			break;

		}
	}
}
