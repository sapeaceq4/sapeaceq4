import java.util.ArrayList;
import java.util.List;

public class FinancialInstrumentsTest {
	public static void main(String[] args) {
		
		List<FinancialInstrument> list = new ArrayList<>();
		
		list.add(new ZeroCouponBond());
		list.add(new VanillaStock());
		list.add(new PreferredStock());
		list.add(new InterestBearingBond());
		
		double sum =0;
		for(FinancialInstrument inst: list){
			if(inst instanceof Bond && inst != null)
					sum += ((Bond) inst).calculateInterest();
		}
		System.out.println("Total interest is: "+sum);
	}
}
