
public class CheckingAccount extends BankAccount {
	private Dollar insufficientFundsFee;
	
	public void processCheck(Check checkToProcess) {
		System.out.println("CheckingAccount#processCheck");
		System.out.println("Check with amount "+checkToProcess.getAmount()+ " is processed.");
	}
	
}
