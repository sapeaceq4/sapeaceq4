package OwnList;


import java.util.List;

public class Consumer extends Thread {
	private ListCustom<Integer> list;

	public Consumer(ListCustom<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		
		for(int i=0;i<50;i++){
			try {
//				Thread.sleep(2000);
				System.out.println("get---- "+list.get());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
