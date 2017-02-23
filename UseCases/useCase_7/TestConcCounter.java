package ThreadPractice;

public class TestConcCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConcurrentCounter cc = new ConcurrentCounter();
		Thread t1 = new Thread(new IncrementRunnable(cc),"Thread1");
		Thread t2 = new Thread(new IncrementRunnable(cc),"Thread2");
		Thread t3 = new Thread(new IncrementRunnable(cc),"Thread3");
		t1.start();
		t2.start();
		t3.start();
	//	System.out.println(cc.getCount());

	}

	static class IncrementRunnable implements Runnable {
		private ConcurrentCounter cc;

		public IncrementRunnable(ConcurrentCounter cc) {

			this.cc = cc;

		}

		@Override
		public void run() {
			
			
			try {
				//Thread.sleep(1000);
				//System.out.println(Thread.currentThread().getName() + cc.getCount());
				Thread.sleep(1000);
				for(int i = 0;i<10;i++){
				cc.increment();
				System.out.println(Thread.currentThread().getName() + " ------" + cc.getCount());
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
