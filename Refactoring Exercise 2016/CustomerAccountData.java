import java.util.ArrayList;

/**
 * This  class is extracted from CustomerAccount
 * 
 * To hold customerAccount details
 * 
 * Zaid Kurchied
 */
public class CustomerAccountData {
	public String number;
	public double balance;
	public ArrayList<AccountTransaction> transactionList;

	public CustomerAccountData(ArrayList<AccountTransaction> transactionList) {
		this.transactionList = transactionList;
	}
}