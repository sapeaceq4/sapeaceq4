package useCases.collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {

		Map<Integer,String> hashMap= new HashMap<Integer,String>();
		hashMap.put(1,"Dinesh");
		hashMap.put(2,"Sumit");
		hashMap.put(3,"Sitanshu");
		hashMap.put(4,"Mukul");
		hashMap.put(5,"Zubin");
		Set<Integer> s= hashMap.keySet();
		for(Integer i: s){
			System.out.println(i+hashMap.get(i));
		}
		
		hashMap.remove(4);
		for(Integer i: s){
			System.out.println(i+" : "+hashMap.get(i));
		}
	}

}
