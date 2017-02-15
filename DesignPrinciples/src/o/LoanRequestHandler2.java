package o;

public class LoanRequestHandler2 {
		private int balance;
		
		public void approveLoan(LoanValidator2 validator) {
			if(validator.isValid(balance))
				System.out.println("loan approved...");
			else 
				System.out.println("sorry...");
		}
}
