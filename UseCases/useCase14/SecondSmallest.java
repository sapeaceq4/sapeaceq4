package data.session.usecases;

public class SecondSmallest {

	public static void main(String[] args) {

		int numbers[] = { 5, 6, 8, 1, 44, 53, 2, 3, 9, 98, 67 };
		int smallest = Integer.MAX_VALUE;
		int second_smallest = Integer.MAX_VALUE;

		for (int n : numbers) {
			if (n < smallest) {
				second_smallest = smallest;
				smallest = n;
			} else if (n < second_smallest && n != smallest) {
				second_smallest = n;
			}
		}

		System.out.println("Smallest : " + smallest);
		System.out.println("Second Smallest : " + second_smallest);
	}
}
