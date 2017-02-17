import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class Sorting {
public static void main(String[] args) {
	
	Map<String,String> hashmap= new HashMap<String, String>();
	hashmap.put("1", "Zen");
	hashmap.put("2", "Tia");
	hashmap.put("3", "Anu");
	hashmap.put("4", "Neha");
	hashmap.put("5", "Neha");
	
	Set<Entry<String, String>> set=hashmap.entrySet();
	List<Entry<String,String>> arraylist=new ArrayList<Entry<String,String>>(set);
	
	Collections.sort(arraylist, new Comparator<Map.Entry<String,String>>() {

		@Override
		public int compare(Entry<String, String> o1, Entry<String, String> o2) {
			
			return o1.getValue().compareTo(o2.getValue());
			
		}

		
	});
	
	System.out.println("Sorted Map is ");
	
	for(Entry<String,String> e : arraylist)
	{
		System.out.println("Key " + e.getKey() + " Value " + e.getValue());
	}
}
}
