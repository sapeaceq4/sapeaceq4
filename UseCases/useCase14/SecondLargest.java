package data.session.usecases;

public class SecondLargest {

	public static void main(String[] args) {

		int numbers[] = { 5, 6, 8, 1, 44, 53, 2, 3, 9, 98, 67 };
		int highest = 0;
		int second_highest = 0;

		for (int n : numbers) {
			if (n > highest) {
				second_highest = highest;
				highest = n;
			} else if (n > second_highest && n != highest) {
				second_highest = n;
			}
		}

		System.out.println("Highest : " + highest);
		System.out.println("Second Highest : " + second_highest);
	}
}
