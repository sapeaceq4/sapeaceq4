import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Building> list = new ArrayList<Building>();
		list.add(new GovernmentCompany());
		list.add(new PrivateCompany());
		list.add(new PublicListedCompany());
		list.add(new House());
		
		for(Building b: list) {
			System.out.print(b.toString().split("@")[0] + ": ");
			b.approvalRequired();
		}
	}
}
