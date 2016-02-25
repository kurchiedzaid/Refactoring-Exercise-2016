import java.awt.Container;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * This  class is extracted from Menu
 * 
 * To hold GUI labels and Customers references which are used by the Menu.java class
 * 
 * Zaid Kurchied
 */

public class MenuData {
	public ArrayList<Customer> customerList;
	public int position;
	public String password;
	public Customer customer;
	public CustomerAccount acc;
	public JFrame f;
	public JFrame f1;
	public JLabel firstNameLabel;
	public JLabel surnameLabel;
	public JLabel pPPSLabel;
	public JLabel dOBLabel;
	public JTextField firstNameTextField;
	public JTextField surnameTextField;
	public JTextField pPSTextField;
	public JTextField dOBTextField;
	public JLabel customerIDLabel;
	public JLabel passwordLabel;
	public JTextField customerIDTextField;
	public JTextField passwordTextField;
	public Container content;
	public Customer e;
	public JButton continueButton;
	public JPanel panel2;
	public JButton add;
	public String PPS;
	public String firstName;
	public String surname;
	public String DOB;
	public String CustomerID;
	public ButtonGroup userType;

	public MenuData(ArrayList<Customer> customerList, int position,
			Customer customer, CustomerAccount acc) {
		this.customerList = customerList;
		this.position = position;
		this.customer = customer;
		this.acc = acc;
	}
}