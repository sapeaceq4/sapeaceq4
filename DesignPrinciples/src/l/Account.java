package l;

public abstract class Account {
	protected int balance;
	protected int period;
	
	public Account(int bal,int per) {
		this.balance = bal;
		this.period = per;
	}
	
	public abstract boolean closeAccount ();
}
