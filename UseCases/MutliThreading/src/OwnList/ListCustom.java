package OwnList;

public class ListCustom<T> {

	private T[] ar;
	private int limit;
	private int count = 0;

	public ListCustom(int limit) {
		this.limit = limit;
		ar = (T[]) new Object[1000];
	}

	public synchronized void put(T item) throws Exception {
		while (this.count == this.limit) {
			wait();
		}
		if (this.count == 0) {
			notifyAll();
		}
		// System.out.println("Inside put---"+count);
		this.ar[count] = item;
		count = count + 1;
	}

	public synchronized T get() throws Exception {
		while (this.count == 0) {
			wait();
		}
		if (this.count == this.limit) {
			notifyAll();
		}
		count = count - 1;
//		System.out.println("Inside get---" + count);
		return this.ar[count];
	}

}