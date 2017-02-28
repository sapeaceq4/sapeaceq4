package collections.map;

import java.util.Map;
import java.util.WeakHashMap;


public class WeakHashMapDemo {
	public static void main(String[] args) throws InterruptedException {
		Map<String,String> whm = new WeakHashMap<>();
		
		whm.put("1", "one");
		whm.put(new String("2"), "two");
		whm.put(new String("3"), "three");
		whm.put("4", "four");
		System.out.println(whm.size());
		System.out.println(whm);
		
		System.gc();
		Thread.sleep(3000);
		System.out.println(whm.size());
		System.out.println(whm);
	}
}
