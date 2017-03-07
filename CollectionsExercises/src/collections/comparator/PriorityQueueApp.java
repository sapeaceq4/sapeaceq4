package collections.comparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;


public class PriorityQueueApp {
	public static void main(String[] args) {
		IdComparator<Customer> comp = new IdComparator<>();
		Queue<Customer> q = new PriorityQueue<>(comp);
		
		q.offer(new Customer(RandomGenerator.getRandInt()));
		q.offer(new Customer(RandomGenerator.getRandInt()));
		q.offer(new Customer(RandomGenerator.getRandInt()));
		q.offer(new Customer(RandomGenerator.getRandInt()));
		
		System.out.println(q);
	}
}

class IdComparator<Customer> implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
		return Integer.valueOf(((collections.comparator.Customer) o1).getId()).compareTo(((collections.comparator.Customer) o2).getId());
	}
	
}
class RandomGenerator {
	public static int getRandInt() {
		Random r = new Random();
			return r.nextInt();
	}
}
