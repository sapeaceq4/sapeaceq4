package useCases.threadpool;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue<T> {

	private List<T> listElements = new LinkedList<>();
	private  int size ;

	public BlockingQueue(int size) {
		this.size = size;
	}


	public void enQueue(T element) throws InterruptedException{
		synchronized (listElements) {
			while(listElements.size()==getSize()){
				listElements.wait();
			}
		}
		synchronized (listElements) {
			listElements.add(element);
			listElements.notifyAll();
		}

	}

	public T deQueue() throws InterruptedException{
		T getElement;
		synchronized (listElements) {
			while(listElements.size()==0){
				listElements.wait();
			}
		}
		synchronized (listElements) {
			getElement = listElements.remove(0);
			listElements.notifyAll();
		}
		return getElement;
	}

	public int getSize() {
		return size;
	}


}
