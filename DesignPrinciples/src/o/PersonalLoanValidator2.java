package o;

public class PersonalLoanValidator2 implements LoanValidator2 {
	public boolean isValid(int balance) {
		if(balance >= 1000)
			return true;
		return false;
	}
}
