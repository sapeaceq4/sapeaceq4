package ThreadPractice;

import java.util.ArrayList;

public class CustomBlockingQueue {
	
	int initialSize;
	Object obj = null;
	ArrayList<Object> objArray = new ArrayList<Object>();
	int index = 0;

	public CustomBlockingQueue(int initialSize) {
		this.initialSize = initialSize;	
		
		// TODO Auto-generated constructor stub
	}
	
	public void put(Object o) throws InterruptedException{
		synchronized(this){
			if(objArray.size() < initialSize) {
				objArray.add(o);
				System.out.println("Added.." +o);
			}
			else{
				System.out.println("Array is full");
				this.wait();
				objArray.add(o);
				System.out.println("Added.." +o);

			}
		}
	}
	
	public Object take(){
		synchronized(this){
			try {
				Thread.sleep(1200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		obj = objArray.remove(0);
		//System.out.println(obj);
		//objArray.remove(0);
		this.notify();
		}
		return obj;	
	}

}
