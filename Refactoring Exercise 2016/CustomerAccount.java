

import java.util.ArrayList; 

public class CustomerAccount  {
   
	CustomerAccountData data = new CustomerAccountData(new ArrayList<AccountTransaction>());

	//Blank Constructor
	public CustomerAccount()
	{
		this.data.number = "";
		this.data.balance = 0;
		this.data.transactionList = null;
	}
	
	//Constructor with Details
	public CustomerAccount(String number, double balance, ArrayList<AccountTransaction> transactionList)
	{
		this.data.number = number;
		this.data.balance = balance;
		this.data.transactionList = transactionList;
	}
	
	//Accessor methods
	
	public String getNumber()
	{
		return this.data.number;
	}
	
	

	
	public double getBalance()
	{
		return this.data.balance;
	}
	
	public ArrayList getTransactionList()
	{
		return this.data.transactionList;
	}

	//Mutator methods
	public void setNumber(String number)
	{
		this.data.number = number;
	}
	
	public void setBalance(double balance)
	{
		this.data.balance = balance;
	}
	
	public void setTransactionList(ArrayList transactionList)
	{
		this.data.transactionList = transactionList;
	}
	
	
	
}
