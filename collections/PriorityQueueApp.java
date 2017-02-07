package com.sapient.ace.corejava.collections;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriorityQueueApp {

	public static void main(String[] args) {

		// PriorityQueue with Comparator
		Queue<Customer> customerPriorityQueue = new PriorityQueue<>(5, new IdComparator());
		addDataToQueue(customerPriorityQueue);

		pollDataFromQueue(customerPriorityQueue);

	}

	// utility method to add random data to Queue
	private static void addDataToQueue(Queue<Customer> customerPriorityQueue) {
		Random rand = new Random();
		for (int i = 0; i < 5; i++) {
			int id = rand.nextInt(100);
			customerPriorityQueue.add(new Customer(id, "Mohit " + id));
		}
	}

	// utility method to poll data from queue
	private static void pollDataFromQueue(Queue<Customer> customerPriorityQueue) {
		while (true) {
			Customer cust = customerPriorityQueue.poll();
			if (cust == null)
				break;
			System.out.println("Processing Customer with ID=" + cust.getId());
		}
	}

}

class IdComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer c1, Customer c2) {
		return (int) (c1.getId() - c2.getId());
	}
}
