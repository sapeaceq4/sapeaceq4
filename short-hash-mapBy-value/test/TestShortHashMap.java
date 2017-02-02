import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import p1.ShortHashMap;


public class TestShortHashMap {
	@Test
	public void TestShotHashMapByValue () {
		Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("j", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);
        
     


        Map<String, Integer> resultKey = ShortHashMap.shotHashMapByValue(unsortMap);
   
        assertTrue(!unsortMap.toString().equals(resultKey.toString()));
	}

}
