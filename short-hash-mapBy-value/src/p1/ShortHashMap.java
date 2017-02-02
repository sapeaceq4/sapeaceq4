package p1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ShortHashMap {
	
	public static  <K, V extends Comparable<? super V>> Map<K, V> shotHashMapByValue (Map<K, V> map) {
		
		Map<K, V> result = new LinkedHashMap<>();
		
		Stream<Map.Entry<K, V>> mapInStream =  map.entrySet().stream();
		mapInStream.sorted(Map.Entry.comparingByValue()).forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
		return result ;
	}
	
	public static void main(String[] args) {
		
		
	}

}
