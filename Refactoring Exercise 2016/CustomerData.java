import java.util.ArrayList;

/**
 * This  class is extracted from Customer
 * 
 * To hold customer details
 * 
 * Zaid Kurchied
 */
public class CustomerData {
	public String PPS;
	public String surname;
	public String firstName;
	public String DOB;
	public String customerID;
	public String password;
	public ArrayList<CustomerAccount> accounts;

	public CustomerData(String pPS, String surname, String firstName,
			String dOB, String customerID, String password,
			ArrayList<CustomerAccount> accounts) {
		PPS = pPS;
		this.surname = surname;
		this.firstName = firstName;
		DOB = dOB;
		this.customerID = customerID;
		this.password = password;
		this.accounts = accounts;
	}
}