package org.om.aec;


public class AecMain 
{
	public void displayAccountDetails(long accountId)
	{
	}
	
	public static void main(String[] args) 
	{
		
	}
}

@FunctionalInterface
interface AccountService
{
	Account getAccount(long accountId);
}

class Account
{
	
}