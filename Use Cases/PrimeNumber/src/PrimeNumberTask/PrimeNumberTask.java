package PrimeNumberTask;

import java.util.Set;
import utilities.NumberUtility;

public class PrimeNumberTask implements Runnable {

	private Set set;
	private Integer num;
	private static Object lock = new Object();

	public PrimeNumberTask(Set set, Integer number) {
		this.set = set;
		num = number;
	}

	@Override
	public void run() {
		if (NumberUtility.isPrime(num)) {
			synchronized (lock) {
				set.add(num);
			}
		}
	}

}