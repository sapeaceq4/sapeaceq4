package utilities;

public class NumberUtility {

	public static boolean isPrime(Integer number) {
		int count = 0;
		int num = number;
		for (int i = 2; i < number / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
