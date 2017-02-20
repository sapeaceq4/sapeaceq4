package WaitNotify;

import java.util.List;
import java.util.Random;

class Producer extends Thread {
	private List<Integer> list;
	private int maxSize;

	public Producer(List<Integer> list, int maxSize, String name) {
		super(name);
		this.list = list;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("pro outside sync");
			synchronized (list) {
				while (list.size() == maxSize) {
					try {
						System.out.println("List is full, " + "Producer thread waiting for "
								+ "consumer to take something from queue");
						list.wait();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				Random random = new Random();
				int i = random.nextInt();
				System.out.println("Producing value : " + i);
				list.add(i);
				list.notifyAll();
			}
		}
	}
}
