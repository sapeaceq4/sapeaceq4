package OwnList;

public class ProducerConsumerMain {

	public static void main(String[] args) {
		ListCustom<Integer> lc= new ListCustom<Integer>(5);
		Producer pc= new Producer(lc);
		pc.start();
		
		Consumer cc= new Consumer(lc);
		
		cc.start();
		try {
			pc.join();
			cc.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Done");
		
	}
}
