package o;

public class BusinessLoanValidator2 implements LoanValidator2 {
	public boolean isValid(int balance) {
		if(balance >= 3000)
			return true;
		return false;
	}
}
