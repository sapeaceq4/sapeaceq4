import java.util.HashMap;
import java.util.Map;

public class GenericsNestedDemo {
	public static void main(String[] args) {
		Map<String,Map<String,String>> map = new HashMap<>();
		
		System.out.println(map);
		
	}
}
