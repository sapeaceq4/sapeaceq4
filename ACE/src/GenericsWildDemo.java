import java.util.ArrayList;
import java.util.List;

public class GenericsWildDemo {
	public static void main(String[] args) {
		List<? super Integer> list = new ArrayList<Integer>();
		list.add(3);
		
		//System.out.println(list.get(0).getClass().getName());
		
		System.out.println(list);
		
	}
}
