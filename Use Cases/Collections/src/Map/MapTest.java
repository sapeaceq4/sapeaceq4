package Map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {

		Map<Integer, String> empMap = new HashMap<Integer, String>();

		empMap.put(1, "akash");
		empMap.put(2, "alok");
		empMap.put(3, "animesh");
		empMap.put(4, "amanjot");

		for (Integer empId : empMap.keySet()) {
			System.out.println(empId);
		}

		empMap.remove(4);

		for (Integer empId : empMap.keySet()) {
			System.out.println(empMap.get(empId));
		}
	}

}
