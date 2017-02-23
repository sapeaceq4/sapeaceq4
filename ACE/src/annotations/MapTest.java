package annotations;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer,String> ();
		map.put(1,"Abar");
		map.put(3,"Bbar");
		map.put(2,"cbar");
		map.put(4,"Dbar");
		
		for(Integer i: map.keySet()){
			System.out.println(i+ ": "+map.get(i));
		}
		
		map.remove(4);
		
		for(Integer i: map.keySet()){
			System.out.println(i+ ": "+map.get(i));
		}
		
		
	}
}
