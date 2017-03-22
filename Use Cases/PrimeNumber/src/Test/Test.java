package Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import PrimeNumberTask.PrimeNumberTask;

public class Test {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(20);
		int n = 0;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 2; i <= 99; i++) {
			service.submit(new PrimeNumberTask(set, i));
		}
		System.out.println(set);
		service.shutdown();
	}
}