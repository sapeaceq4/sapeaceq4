
public class BankAccount {
	protected String owner;
	protected Dollar balance = new Dollar("0");
	
	protected void deposit(Dollar amount) {
		balance.add(amount);
	}
	protected void withdrawal(Dollar amount) {
		balance.subtract(amount);
	}
}
