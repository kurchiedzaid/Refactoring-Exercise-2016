import java.util.ArrayList; 

public class Customer {

	CustomerData data = new CustomerData("", "", "", "", "", "", new ArrayList<CustomerAccount> ());

	//Blank constructor
	public Customer()
	{
		this.data.PPS = "";
		this.data.surname = "";
		this.data.firstName = "";
		this.data.DOB = "";
		this.data.customerID = "";
		this.data.password = "";
		this.data.accounts = null;
	}
	
	//Constructor with details
	public Customer(String PPS, String surname, String firstName, String DOB, String customerID, String password, ArrayList<CustomerAccount> accounts)
	{
		this.data.PPS = PPS;
		this.data.surname = surname;
		this.data.firstName = firstName;
		this.data.DOB = DOB;
		this.data.customerID = customerID;
		this.data.password = password;;
		this.data.accounts = accounts;
	}
	
	//Accessor methods
	public String getPPS()
	{
		return this.data.PPS;
	}
	
	public String getSurname()
	{
		return this.data.surname;
	}
	
	public String getFirstName()
	{
		return this.data.firstName;
	}
	
	public String getDOB()
	{
		return this.data.DOB;
	}
	
	public String getCustomerID()
	{
		return this.data.customerID;
	}
	
	public String getPassword()
	{
		return this.data.password;
	}
	
	public ArrayList<CustomerAccount> getAccounts()
	{
		return this.data.accounts;
	}
	
	//mutator methods
	public void setPPS(String PPS)
	{
		this.data.PPS = PPS;
	}
	
	public void setSurname(String surname)
	{
		this.data.surname = surname;
	}
	
	public void setFirstName(String firstName)
	{
		this.data.firstName = firstName;
	}
	
	public void setDOB(String DOB)
	{
		this.data.DOB = DOB;
	}
	


	
	public void setCustomerID(String customerID)
	{
		this.data.customerID = customerID;
	}
	
	public void setPassword(String password)
	{
		this.data.password = password;
	}
	
	public void setAccounts(ArrayList<CustomerAccount> accounts)
	{
		this.data.accounts = accounts;
	}
	
	public String toString()
	{
		return "PPS number = " + this.data.PPS + "\n"
				+ "Surname = " + this.data.surname + "\n"
				+ "First Name = " + this.data.firstName + "\n"
				+ "Date of Birth = " + this.data.DOB + "\n"
				+ "Customer ID = " + this.data.customerID;
			
	}
	
}
