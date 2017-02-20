package OwnList;

import java.util.List;
import java.util.Random;

class Producer extends Thread {
	private ListCustom<Integer> list;

	public Producer(ListCustom<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		for(int i=0;i<50;i++){
			try {
			
				list.put(i);
				System.out.println("Put----- "+i);
				Thread.sleep(10);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
