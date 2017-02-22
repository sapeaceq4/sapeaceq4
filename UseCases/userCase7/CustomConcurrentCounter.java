package data.session.usecases.usecase7;

public class CustomConcurrentCounter {

	private static int counter;
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable());
		Thread t2 = new Thread(new MyRunnable());
		t1.start();
		t2.start();
	}
	
	private static class MyRunnable implements Runnable {

		static synchronized void incrementAndGet() {
			counter = counter + 1;
		}

		@Override
		public void run() {
			for(int i=0; i<5; i++) {
				incrementAndGet();
				System.out.println("Thread "+Thread.currentThread().getId()+ " count :" +counter);
			}
		}

	}
}
