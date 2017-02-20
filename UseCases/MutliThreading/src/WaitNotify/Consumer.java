package WaitNotify;

import java.util.List;

public class Consumer extends Thread {
	private List<Integer> list;
	private int maxSize;

	public Consumer(List<Integer> list, int maxSize, String name) {
		super(name);
		this.list = list;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("cons outside sync");
			synchronized (list) {
				while (list.isEmpty()) {
					System.out.println("List is empty," + "Consumer thread is waiting"
							+ " for producer thread to put something in queue");
					try {
						list.wait();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				System.out.println("Consuming value : " + list.remove(0));
				list.notifyAll();
			}
		}
	}
}
