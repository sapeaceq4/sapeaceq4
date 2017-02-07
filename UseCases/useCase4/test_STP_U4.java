package data.session.usecases;

public class test_STP_U4 {

	public static void main(String[] args) {
		SimpleThreadPool_U4 stp = new SimpleThreadPool_U4(3);
		stp.enqueue(new TestTask1());
		stp.enqueue(new TestTask2());
		stp.enqueue(new TestTask3());
	}

	private static class TestTask1 implements Runnable {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " : A");
			}
		}
	}

	private static class TestTask2 implements Runnable {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " : B");
			}
		}
	}
	
	private static class TestTask3 implements Runnable {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " : C");
			}
		}
	}

}
