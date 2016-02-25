
import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.text.MaskFormatter;
import java.util.ArrayList; 

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Menu extends JFrame{
	//Refactored
	MenuData data = new MenuData(new ArrayList<Customer>(), 0, null, new CustomerAccount());
	public static void main(String[] args)
	{
		Menu driver = new Menu();
		driver.menuStart();
	}
	
	public void menuStart()
	{
		   /*The menuStart method asks the user if they are a new customer, an existing customer or an admin. It will then start the create customer process
		  if they are a new customer, or will ask them to log in if they are an existing customer or admin.*/
		
			
		
			
			data.f = new JFrame("User Type");
			data.f.setSize(400, 300);
			data.f.setLocation(200, 200);
			data.f.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent we) { System.exit(0); }
			});

			JPanel userTypePanel = new JPanel();
			data.userType = new ButtonGroup();
			JRadioButton radioButton;
			userTypePanel.add(radioButton = new JRadioButton("Existing Customer"));
			radioButton.setActionCommand("Customer");
			data.userType.add(radioButton);
			
			userTypePanel.add(radioButton = new JRadioButton("Administrator"));
			radioButton.setActionCommand("Administrator");
			data.userType.add(radioButton);
			
			userTypePanel.add(radioButton = new JRadioButton("New Customer"));
			radioButton.setActionCommand("New Customer");
			data.userType.add(radioButton);

			JPanel continuePanel = new JPanel();
			data.continueButton = new JButton("Continue");
			continuePanel.add(data.continueButton);

			Container content = data.f.getContentPane();
			content.setLayout(new GridLayout(2, 1));
			content.add(userTypePanel);
			content.add(continuePanel);
/////////replaces the cod
            chooser();
	}
	/**
	   * This method is extracted from menuStart()
	   * 
	   * Option main Menu
	   * 
	   * Zaid Kurchied
	   */
	public void chooser(){
		
		data.continueButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				String user = data.userType.getSelection().getActionCommand(  );
				
				if(user.equals("New Customer"))
				{
					
					newCustomerChoice();
				}
				
				if(user.equals("Administrator")	)
				{
					adminChoice();
					
				}
				if(user.equals("Customer")	)
				{
					CustomerChoice();
					
				}
			
			}
				});data.f.setVisible(true);
	}
	
	/**
	   * This method is extracted from menuStart()
	   * 
	   * 
	   * 
	   * Zaid Kurchied
	   */
	public void CustomerChoice(){

		boolean loop = true, loop2 = true;
		boolean cont = false;
		boolean found = false;
		Customer customer = null;
	    while(loop)
	    {
	    Object customerID = JOptionPane.showInputDialog(data.f, "Enter Customer ID:");
	    
	    for (Customer aCustomer: data.customerList){
	    	
	    	String existingCustID = aCustomer.getCustomerID();
			if(existingCustID.equals(customerID))//search customer list for matching customer ID
	    	{
	    		found = true;
	    		customer = aCustomer;
	    	}					    	
	    }
	    
	    if(found == false)
	    {
	    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
	    	if (reply == JOptionPane.YES_OPTION) {
	    		loop = true;
	    	}
	    	else if(reply == JOptionPane.NO_OPTION)
	    	{
	    		data.f.dispose();
	    		loop = false;
	    		loop2 = false;
	    		menuStart();
	    	}
	    }
	    else
	    {
	    	loop = false;
	    }
	   
	    }
	    
	    while(loop2)
	    {
	    	Object customerPassword = JOptionPane.showInputDialog(data.f, "Enter Customer Password;");
	    	
	    	   if(!customer.getPassword().equals(customerPassword))//check if custoemr password is correct
			    {
			    	int reply  = JOptionPane.showConfirmDialog(null, null, "Incorrect password. Try again?", JOptionPane.YES_NO_OPTION);
			    	if (reply == JOptionPane.YES_OPTION) {
			    		
			    	}
			    	else if(reply == JOptionPane.NO_OPTION){
			    		data.f.dispose();
			    		loop2 = false;
			    		menuStart();
			    	}
			    }
	    	   else
	    	   {
	    		   loop2 =false;
	    		   cont = true;
	    	   }
	    }
	    	
	    if(cont)
	    {
		data.f.dispose();
	    	loop = false;
	    	customer(customer);				    
	    }	    
	}
	//-----------------------------------------------------------------------------------------------------------------------


	
	/**
	   * This method is extracted from menuStart()
	   * 
	   * 
	   * 
	   * Zaid Kurchied
	   */	
	public void adminChoice(){
		
		boolean loop = true, loop2 = true;
		boolean cont = false;
	    while(loop)
	    {
	    Object adminUsername = JOptionPane.showInputDialog(data.f, "Enter Administrator Username:");

	    if(!adminUsername.equals("admin"))//search admin list for admin with matching admin username
	    {
	    	int reply  = JOptionPane.showConfirmDialog(null, null, "Incorrect Username. Try again?", JOptionPane.YES_NO_OPTION);
	    	if (reply == JOptionPane.YES_OPTION) {
	    		loop = true;
	    	}
	    	else if(reply == JOptionPane.NO_OPTION)
	    	{
	    		data.f1.dispose();
	    		loop = false;
	    		loop2 = false;
	    		menuStart();
	    	}
	    }
	    else
	    {
	    	loop = false;
	    }				    
	    }
	    
	    while(loop2)
	    {
	    	Object adminPassword = JOptionPane.showInputDialog(data.f, "Enter Administrator Password;");
	    	
	    	   if(!adminPassword.equals("admin11"))//search admin list for admin with matching admin password
			    {
			    	int reply  = JOptionPane.showConfirmDialog(null, null, "Incorrect Password. Try again?", JOptionPane.YES_NO_OPTION);
			    	if (reply == JOptionPane.YES_OPTION) {
			    		
			    	}
			    	else if(reply == JOptionPane.NO_OPTION){
			    		data.f1.dispose();
			    		loop2 = false;
			    		menuStart();
			    	}
			    }
	    	   else
	    	   {
	    		   loop2 =false;
	    		   cont = true;
	    	   }
	    }
	    	
	    if(cont)
	    {
		data.f1.dispose();
	    	loop = false;
	    admin();					    
	    }					    
	}
	/**
	   * This method is extracted from menuStart()
	   * 
	   * 
	   * 
	   * Zaid Kurchied
	   */
	public void newCustomerChoice(){
		
		data.f.dispose();		
		data.f1 = new JFrame("Create New Customer");
		data.f1.setSize(400, 300);
		data.f1.setLocation(200, 200);
		data.f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) { System.exit(0); }
		});
			Container content = data.f1.getContentPane();
			content.setLayout(new BorderLayout());
			
			data.firstNameLabel = new JLabel("First Name:", SwingConstants.RIGHT);
			data.surnameLabel = new JLabel("Surname:", SwingConstants.RIGHT);
			data.pPPSLabel = new JLabel("PPS Number:", SwingConstants.RIGHT);
			data.dOBLabel = new JLabel("Date of birth", SwingConstants.RIGHT);
			data.firstNameTextField = new JTextField(20);
			data.surnameTextField = new JTextField(20);
			data.pPSTextField = new JTextField(20);
			data.dOBTextField = new JTextField(20);
			JPanel panel = new JPanel(new GridLayout(6, 2));
			panel.add(data.firstNameLabel);
			panel.add(data.firstNameTextField);
			panel.add(data.surnameLabel);
			panel.add(data.surnameTextField);
			panel.add(data.pPPSLabel);
			panel.add(data.pPSTextField);
			panel.add(data.dOBLabel);
			panel.add(data.dOBTextField);
				
			data.panel2 = new JPanel();
			data.add = new JButton("Add");
			
			 data.add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			
					
		data.PPS = data.pPSTextField.getText();
		data.firstName = data.firstNameTextField.getText();
		data.surname = data.surnameTextField.getText();
		data.DOB = data.dOBTextField.getText();
		data.password = "";
	
		data.CustomerID = "ID"+data.PPS ;
		
		
		data.add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data.f1.dispose();
				boolean loop = true;
				while(loop){
				 data.password = JOptionPane.showInputDialog(data.f, "Enter 7 character Password;");
				 loop = passwordValidation(loop);
				}
				
				
			    ArrayList<CustomerAccount> accounts = new ArrayList<CustomerAccount> ();
						Customer customer = new Customer(data.PPS, data.surname, data.firstName, data.DOB, data.CustomerID, data.password, accounts);
							
					data.customerList.add(customer);
					
						JOptionPane.showMessageDialog(data.f, "CustomerID = " + data.CustomerID +"\n Password = " + data.password  ,"Customer created.",  JOptionPane.INFORMATION_MESSAGE);
						menuStart();
					data.f.dispose();
			}
        
		});	
				}
			});						
			JButton cancel = new JButton("Cancel");					
			cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					data.f1.dispose();
					menuStart();
				}
			});	
			
			data.panel2.add(data.add);
			data.panel2.add(cancel);
			
			content.add(panel, BorderLayout.CENTER);
			content.add(data.panel2, BorderLayout.SOUTH);
	
			data.f1.setVisible(true);	
	}

	
	public void admin()
	{
		dispose();
		
		data.f = new JFrame("Administrator Menu");
		data.f.setSize(400, 400);
		data.f.setLocation(200, 200);
		data.f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) { System.exit(0); }
		});          
		data.f.setVisible(true);
		
		JPanel deleteCustomerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton deleteCustomer = new JButton("Delete Customer");	
		deleteCustomer.setPreferredSize(new Dimension(250, 20));
		deleteCustomerPanel.add(deleteCustomer);
		
		JPanel deleteAccountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton deleteAccount = new JButton("Delete Account");
		deleteAccount.setPreferredSize(new Dimension(250, 20));	
		deleteAccountPanel.add(deleteAccount);
		
		JPanel bankChargesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton bankChargesButton = new JButton("Apply Bank Charges");
		bankChargesButton.setPreferredSize(new Dimension(250, 20));	
		bankChargesPanel.add(bankChargesButton);
		
		JPanel interestPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton interestButton = new JButton("Apply Interest");
		interestPanel.add(interestButton);
		interestButton.setPreferredSize(new Dimension(250, 20));
		
		JPanel editCustomerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton editCustomerButton = new JButton("Edit existing Customer");
		editCustomerPanel.add(editCustomerButton);
		editCustomerButton.setPreferredSize(new Dimension(250, 20));
		
		JPanel navigatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton navigateButton = new JButton("Navigate Customer Collection");
		navigatePanel.add(navigateButton);
		navigateButton.setPreferredSize(new Dimension(250, 20));
		
		JPanel summaryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton summaryButton = new JButton("Display Summary Of All Accounts");
		summaryPanel.add(summaryButton);
		summaryButton.setPreferredSize(new Dimension(250, 20));
		
		JPanel accountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton accountButton = new JButton("Add an Account to a Customer");
		accountPanel.add(accountButton);
		accountButton.setPreferredSize(new Dimension(250, 20));
		
		JPanel returnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton returnButton = new JButton("Exit Admin Menu");
		returnPanel.add(returnButton);

		JLabel label1 = new JLabel("Please select an option");
		
		data.content = data.f.getContentPane();
		data.content.setLayout(new GridLayout(9, 1));
		data.content.add(label1);
		data.content.add(accountPanel);
		data.content.add(bankChargesPanel);
		data.content.add(interestPanel);
		data.content.add(editCustomerPanel);
		data.content.add(navigatePanel);
		data.content.add(summaryPanel);	
		data.content.add(deleteCustomerPanel);
	//	content.add(deleteAccountPanel);
		data.content.add(returnPanel);
		
		
		bankChargesButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				
				boolean loop = true;
				
				boolean found = false;
			
				if(data.customerList.isEmpty())
				{
					JOptionPane.showMessageDialog(data.f, "There are no customers yet!"  ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
					data.f.dispose();
					admin();
					
				}
				else
				{
			    while(loop)
			    {
			    Object customerID = JOptionPane.showInputDialog(data.f, "Customer ID of Customer You Wish to Apply Charges to:");
			    
			    for (Customer aCustomer: data.customerList){
			    	
			    	String ExistingCustID = aCustomer.getCustomerID();
					if(ExistingCustID.equals(customerID))
			    	{
			    		found = true;
			    		data.customer = aCustomer; 
			    		loop = false;
			    	}					    	
			    }
			    
			    if(found == false)
			    {
			    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
			    	if (reply == JOptionPane.YES_OPTION) {
			    		loop = true;
			    	}
			    	else if(reply == JOptionPane.NO_OPTION)
			    	{
			    		data.f.dispose();
			    		loop = false;
			    	
			    		admin();
			    	}
			    }  
			    else
			    {
			    	data.f.dispose();
			    	data.f = new JFrame("Administrator Menu");
					data.f.setSize(400, 300);
					data.f.setLocation(200, 200);
					data.f.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent we) { System.exit(0); }
					});          
					data.f.setVisible(true);
				
				
				    JComboBox<String> box = new JComboBox<String>();
				    for (int i =0; i < data.customer.getAccounts().size(); i++)
				    {
				    	
				    	
				     box.addItem(data.customer.getAccounts().get(i).getNumber());
				    }
					
				    
				    box.getSelectedItem();
				
				    JPanel boxPanel = new JPanel();
					boxPanel.add(box);
					
					JPanel buttonPanel = new JPanel();
					JButton continueButton = new JButton("Apply Charge");
					JButton returnButton = new JButton("Return");
					buttonPanel.add(continueButton);
					buttonPanel.add(returnButton);
					Container content = data.f.getContentPane();
					content.setLayout(new GridLayout(2, 1));
					
					content.add(boxPanel);
					content.add(buttonPanel);
					
			
						if(data.customer.getAccounts().isEmpty())
						{
							JOptionPane.showMessageDialog(data.f, "This customer has no accounts! \n The admin must add acounts to this customer."   ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
							data.f.dispose();
							admin();
						}
						else
						{
						
					for(int i = 0; i < data.customer.getAccounts().size(); i++)
				    {
				    	String custNum = data.customer.getAccounts().get(i).getNumber();
						if(custNum == box.getSelectedItem() )
				    	{
				    		data.acc = data.customer.getAccounts().get(i);
				    	}
				    }
										
					continueButton.addActionListener(new ActionListener(  ) {
						public void actionPerformed(ActionEvent ae) {
							String euro = "\u20ac";
						 	
						accountChecker(euro);	
							
							data.f.dispose();				
						    admin();				
						}
						
                	
				     });
					
					returnButton.addActionListener(new ActionListener(  ) {
						public void actionPerformed(ActionEvent ae) {
							data.f.dispose();		
							menuStart();				
						}
				     });	
					
						}
			    }
			    }
			    }
			    
			    
			    
			}		
	     });
		
		interestButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {

				boolean loop = true;
				
				boolean found = false;
			
				if(data.customerList.isEmpty())
				{
					JOptionPane.showMessageDialog(data.f, "There are no customers yet!"  ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
					data.f.dispose();
					admin();
					
				}
				else
				{
			    while(loop)
			    {
			    Object customerID = JOptionPane.showInputDialog(data.f, "Customer ID of Customer You Wish to Apply Interest to:");
			    
			    for (Customer aCustomer: data.customerList){
			    	//extracting variables
			    	String existingCust = aCustomer.getCustomerID();
					if(existingCust.equals(customerID))
			    	{
			    		found = true;
			    		data.customer = aCustomer; 
			    		loop = false;
			    	}					    	
			    }
			    
			    if(found == false)
			    {
			    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
			    	if (reply == JOptionPane.YES_OPTION) {
			    		loop = true;
			    	}
			    	else if(reply == JOptionPane.NO_OPTION)
			    	{
			    		data.f.dispose();
			    		loop = false;
			    	
			    		admin();
			    	}
			    }  
			    else
			    {
			    	data.f.dispose();
			    	data.f = new JFrame("Administrator Menu");
					data.f.setSize(400, 300);
					data.f.setLocation(200, 200);
					data.f.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent we) { System.exit(0); }
					});          
					data.f.setVisible(true);
				
				
				    JComboBox<String> box = new JComboBox<String>();
				    for (int i =0; i < data.customer.getAccounts().size(); i++)
				    {
				    	
				    	
				     box.addItem(data.customer.getAccounts().get(i).getNumber());
				    }
					
				    
				    box.getSelectedItem();
				
				    JPanel boxPanel = new JPanel();
					
					JLabel label = new JLabel("Select an account to apply interest to:");
					boxPanel.add(label);
					boxPanel.add(box);
					JPanel buttonPanel = new JPanel();
					JButton continueButton = new JButton("Apply Interest");
					JButton returnButton = new JButton("Return");
					buttonPanel.add(continueButton);
					buttonPanel.add(returnButton);
					Container content = data.f.getContentPane();
					content.setLayout(new GridLayout(2, 1));
					
					content.add(boxPanel);
					content.add(buttonPanel);
					
			
						if(data.customer.getAccounts().isEmpty())
						{
							JOptionPane.showMessageDialog(data.f, "This customer has no accounts! \n The admin must add acounts to this customer."   ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
							data.f.dispose();
							admin();
						}
						else
						{
						
					for(int i = 0; i < data.customer.getAccounts().size(); i++)
				    {
						//exracting customer accounts
				    	String custAccount = data.customer.getAccounts().get(i).getNumber();
						if(custAccount == box.getSelectedItem() )
				    	{
				    		data.acc = data.customer.getAccounts().get(i);
				    	}
				    }
										
					continueButton.addActionListener(new ActionListener(  ) {
						public void actionPerformed(ActionEvent ae) {
							String euro = "\u20ac";
						 	double interest = 0;
						 	boolean loop = true;
						 	
						 	while(loop)
						 	{
							String interestString = JOptionPane.showInputDialog(data.f, "Enter interest percentage you wish to apply: \n NOTE: Please enter a numerical value. (with no percentage sign) \n E.g: If you wish to apply 8% interest, enter '8'");//the isNumeric method tests to see if the string entered was numeric. 
							if(isNumeric(interestString))
							{
								
								interest = Double.parseDouble(interestString);
								loop = false;
								
								data.acc.setBalance(data.acc.getBalance() + (data.acc.getBalance() * (interest/100)));
								
								JOptionPane.showMessageDialog(data.f, interest + "% interest applied. \n new balance = " + data.acc.getBalance() + euro ,"Success!",  JOptionPane.INFORMATION_MESSAGE);
							}
								
							
							else
							{
								JOptionPane.showMessageDialog(data.f, "You must enter a numerical value!" ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
							}
							
							
						 	}
							
							data.f.dispose();				
						admin();				
						}		
				     });
					
					returnButton.addActionListener(new ActionListener(  ) {
						public void actionPerformed(ActionEvent ae) {
							data.f.dispose();		
							menuStart();				
						}
				     });	
					
						}
			    }
			    }
			    }
			    
			}	
	     });
		
		editCustomerButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				
				boolean loop = true;
			
				boolean found = false;
			
				if(data.customerList.isEmpty())
				{
					JOptionPane.showMessageDialog(data.f, "There are no customers yet!"  ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
					data.f.dispose();
					admin();
					
				}
				else
				{
				
			    while(loop)
			    {
			    Object customerID = JOptionPane.showInputDialog(data.f, "Enter Customer ID:");
			    
			    for (Customer aCustomer: data.customerList){
			    	//refactored
			    	String existingCustId = aCustomer.getCustomerID();
					if(existingCustId.equals(customerID))
			    	{
			    		found = true;
			    		data.customer = aCustomer;
			    	}					    	
			    }
			    
			    if(found == false)
			    {
			    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
			    	if (reply == JOptionPane.YES_OPTION) {
			    		loop = true;
			    	}
			    	else if(reply == JOptionPane.NO_OPTION)
			    	{
			    		data.f.dispose();
			    		loop = false;
			    	
			    		admin();
			    	}
			    }
			    else
			    {
			    	loop = false;
			    }
			   
			    }
				
				data.f.dispose();
				
				data.f.dispose();
				data.f = new JFrame("Administrator Menu");
				data.f.setSize(400, 300);
				data.f.setLocation(200, 200);
				data.f.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent we) { System.exit(0); }
				});       
				
				data.firstNameLabel = new JLabel("First Name:", SwingConstants.LEFT);
				data.surnameLabel = new JLabel("Surname:", SwingConstants.LEFT);
				data.pPPSLabel = new JLabel("PPS Number:", SwingConstants.LEFT);
				data.dOBLabel = new JLabel("Date of birth", SwingConstants.LEFT);
				data.customerIDLabel = new JLabel("CustomerID:", SwingConstants.LEFT);
				data.passwordLabel = new JLabel("Password:", SwingConstants.LEFT);
				data.firstNameTextField = new JTextField(20);
				data.surnameTextField = new JTextField(20);
				data.pPSTextField = new JTextField(20);
				data.dOBTextField = new JTextField(20);
				data.customerIDTextField = new JTextField(20);
				data.passwordTextField = new JTextField(20);
				
				JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
				JPanel cancelPanel = new JPanel();
				
				textPanel.add(data.firstNameLabel);
				textPanel.add(data.firstNameTextField);
				textPanel.add(data.surnameLabel);
				textPanel.add(data.surnameTextField);
				textPanel.add(data.pPPSLabel);
				textPanel.add(data.pPSTextField);
				textPanel.add(data.dOBLabel);
				textPanel.add(data.dOBTextField);
				textPanel.add(data.customerIDLabel);
				textPanel.add(data.customerIDTextField);
				textPanel.add(data.passwordLabel);
				textPanel.add(data.passwordTextField);

				data.firstNameTextField.setText(data.customer.getFirstName());
				data.surnameTextField.setText(data.customer.getSurname());
				data.pPSTextField.setText(data.customer.getPPS());
				data.dOBTextField.setText(data.customer.getDOB());
				data.customerIDTextField.setText(data.customer.getCustomerID());
				data.passwordTextField.setText(data.customer.getPassword());	
				
				//JLabel label1 = new JLabel("Edit customer details below. The save");
				
			
				JButton saveButton = new JButton("Save");
				JButton cancelButton = new JButton("Exit");
				
				cancelPanel.add(cancelButton, BorderLayout.SOUTH);
				cancelPanel.add(saveButton, BorderLayout.SOUTH);
			//	content.removeAll();
				Container content = data.f.getContentPane();
				content.setLayout(new GridLayout(2, 1));
				content.add(textPanel, BorderLayout.NORTH);
				content.add(cancelPanel, BorderLayout.SOUTH);
				
				data.f.setContentPane(content);
				data.f.setSize(340, 350);
				data.f.setLocation(200, 200);
				data.f.setVisible(true);
				data.f.setResizable(false);
				
				saveButton.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {
					
						data.customer.setFirstName(data.firstNameTextField.getText());
						data.customer.setSurname(data.surnameTextField.getText());
						data.customer.setPPS(data.pPSTextField.getText());
						data.customer.setDOB(data.dOBTextField.getText());
						data.customer.setCustomerID(data.customerIDTextField.getText());
						data.customer.setPassword(data.passwordTextField.getText());		
						
						JOptionPane.showMessageDialog(null, "Changes Saved.");
							}		
					     });
				
				cancelButton.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {
						data.f.dispose();
						
						admin();				
					}		
			     });		
				}}
	     });
		
		summaryButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				data.f.dispose();
				
				
				data.f = new JFrame("Summary of Transactions");
				data.f.setSize(400, 700);
				data.f.setLocation(200, 200);
				data.f.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent we) { System.exit(0); }
				});          
				data.f.setVisible(true);
				
				JLabel label1 = new JLabel("Summary of all transactions: ");
				
				JPanel returnPanel = new JPanel();
				JButton returnButton = new JButton("Return");
				returnPanel.add(returnButton);
				
				JPanel textPanel = new JPanel();
				
				textPanel.setLayout( new BorderLayout() );
				JTextArea textArea = new JTextArea(40, 20);
				textArea.setEditable(false);
				textPanel.add(label1, BorderLayout.NORTH);
				textPanel.add(textArea, BorderLayout.CENTER);
				textPanel.add(returnButton, BorderLayout.SOUTH);
				
				JScrollPane scrollPane = new JScrollPane(textArea);
				textPanel.add(scrollPane);
				
			for (int a = 0; a < data.customerList.size(); a++)//For each customer, for each account, it displays each transaction.
				{
					customerTransaction(textArea, a);				
				}
				
				textPanel.add(textArea);
				data.content.removeAll();
				
				
				Container content = data.f.getContentPane();
				content.setLayout(new GridLayout(1, 1));
			//	content.add(label1);
				content.add(textPanel);
				//content.add(returnPanel);
				
				returnButton.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {
						data.f.dispose();			
					    admin();				
					}		
			     });	
			}

			
	     });
		
		navigateButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				data.f.dispose();
				
				if(data.customerList.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "There are currently no customers to display. ");
					admin();
				}
				else
				{
		
				JButton first, previous, next, last, cancel;
				JPanel gridPanel, buttonPanel, cancelPanel;			
	
				Container content = getContentPane();
				
				content.setLayout(new BorderLayout());
				
				buttonPanel = new JPanel();
				gridPanel = new JPanel(new GridLayout(8, 2));
				cancelPanel = new JPanel();
								
				data.firstNameLabel = new JLabel("First Name:", SwingConstants.LEFT);
				data.surnameLabel = new JLabel("Surname:", SwingConstants.LEFT);
				data.pPPSLabel = new JLabel("PPS Number:", SwingConstants.LEFT);
				data.dOBLabel = new JLabel("Date of birth", SwingConstants.LEFT);
				data.customerIDLabel = new JLabel("CustomerID:", SwingConstants.LEFT);
				data.passwordLabel = new JLabel("Password:", SwingConstants.LEFT);
				data.firstNameTextField = new JTextField(20);
				data.surnameTextField = new JTextField(20);
				data.pPSTextField = new JTextField(20);
				data.dOBTextField = new JTextField(20);
				data.customerIDTextField = new JTextField(20);
				data.passwordTextField = new JTextField(20);
				
				first = new JButton("First");
				previous = new JButton("Previous");
				next = new JButton("Next");
				last = new JButton("Last");
				cancel = new JButton("Cancel");
				
				data.firstNameTextField.setText(data.customerList.get(0).getFirstName());
				data.surnameTextField.setText(data.customerList.get(0).getSurname());
				data.pPSTextField.setText(data.customerList.get(0).getPPS());
				data.dOBTextField.setText(data.customerList.get(0).getDOB());
				data.customerIDTextField.setText(data.customerList.get(0).getCustomerID());
				data.passwordTextField.setText(data.customerList.get(0).getPassword());
				
				data.firstNameTextField.setEditable(false);
				data.surnameTextField.setEditable(false);
				data.pPSTextField.setEditable(false);
				data.dOBTextField.setEditable(false);
				data.customerIDTextField.setEditable(false);
				data.passwordTextField.setEditable(false);
				
				gridPanel.add(data.firstNameLabel);
				gridPanel.add(data.firstNameTextField);
				gridPanel.add(data.surnameLabel);
				gridPanel.add(data.surnameTextField);
				gridPanel.add(data.pPPSLabel);
				gridPanel.add(data.pPSTextField);
				gridPanel.add(data.dOBLabel);
				gridPanel.add(data.dOBTextField);
				gridPanel.add(data.customerIDLabel);
				gridPanel.add(data.customerIDTextField);
				gridPanel.add(data.passwordLabel);
				gridPanel.add(data.passwordTextField);
				
				buttonPanel.add(first);
				buttonPanel.add(previous);
				buttonPanel.add(next);
				buttonPanel.add(last);
				
				cancelPanel.add(cancel);
		
				content.add(gridPanel, BorderLayout.NORTH);
				content.add(buttonPanel, BorderLayout.CENTER);
				content.add(cancelPanel, BorderLayout.AFTER_LAST_LINE);
				first.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {
						data.position = 0;
						data.firstNameTextField.setText(data.customerList.get(0).getFirstName());
						data.surnameTextField.setText(data.customerList.get(0).getSurname());
						data.pPSTextField.setText(data.customerList.get(0).getPPS());
						data.dOBTextField.setText(data.customerList.get(0).getDOB());
						data.customerIDTextField.setText(data.customerList.get(0).getCustomerID());
						data.passwordTextField.setText(data.customerList.get(0).getPassword());				
							}		
					     });
				
				previous.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {
								
						positionChecker();			
							}
                	
					     });
				
				next.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {
					
						if(data.position == data.customerList.size()-1)
						{
							//don't do anything
						}
						else
						{
							data.position = data.position + 1;
							
						data.firstNameTextField.setText(data.customerList.get(data.position).getFirstName());
						data.surnameTextField.setText(data.customerList.get(data.position).getSurname());
						data.pPSTextField.setText(data.customerList.get(data.position).getPPS());
						data.dOBTextField.setText(data.customerList.get(data.position).getDOB());
						data.customerIDTextField.setText(data.customerList.get(data.position).getCustomerID());
						data.passwordTextField.setText(data.customerList.get(data.position).getPassword());
						}		
						
						
												
							}		
					     });
				
				last.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {
					
						data.position = data.customerList.size() - 1;
				
						data.firstNameTextField.setText(data.customerList.get(data.position).getFirstName());
						data.surnameTextField.setText(data.customerList.get(data.position).getSurname());
						data.pPSTextField.setText(data.customerList.get(data.position).getPPS());
						data.dOBTextField.setText(data.customerList.get(data.position).getDOB());
						data.customerIDTextField.setText(data.customerList.get(data.position).getCustomerID());
						data.passwordTextField.setText(data.customerList.get(data.position).getPassword());								
							}		
					     });
				
				cancel.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {				
						dispose();
						admin();
							}		
					     });			
				setContentPane(content);
				setSize(400, 300);
			       setVisible(true);
					}		
			}
		});
		
		accountButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				data.f.dispose();
				
				if(data.customerList.isEmpty())
				{
					JOptionPane.showMessageDialog(data.f, "There are no customers yet!"  ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
					data.f.dispose();
					admin();
				}
				else
				{
				boolean loop = true;
				
				boolean found = false;
			
			    while(loop)
			    {
			    Object customerID = JOptionPane.showInputDialog(data.f, "Customer ID of Customer You Wish to Add an Account to:");
			    
			    for (Customer aCustomer: data.customerList){
			    	//refactored zk
			    	String existingCustID = aCustomer.getCustomerID();
					if(existingCustID.equals(customerID))
			    	{
			    		found = true;
			    		data.customer = aCustomer; 	
			    	}					    	
			    }
			    
			    if(found == false)
			    {
			    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
			    	if (reply == JOptionPane.YES_OPTION) {
			    		loop = true;
			    	}
			    	else if(reply == JOptionPane.NO_OPTION)
			    	{
			    		data.f.dispose();
			    		loop = false;
			    	
			    		admin();
			    	}
			    }
			    else
			    {
			    	loop = false;
			    	//a combo box in an dialog box that asks the admin what type of account they wish to create (deposit/current)
				    String[] choices = { "Current Account", "Deposit Account" };
				    String account = (String) JOptionPane.showInputDialog(null, "Please choose account type",
				        "Account Type", JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]); 
				    
				    accountType(account);
			    
			    }			   
			    }
				}
			}
			
			//account type  refactored zzk

		
	     });		

		deleteCustomer.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				boolean found = true, loop = true;
				
				if(data.customerList.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "There are currently no customers to display. ");
					dispose();
					admin();
				}
				else
				{
					 {
						    Object customerID = JOptionPane.showInputDialog(data.f, "Customer ID of Customer You Wish to Delete:");
						    
						    for (Customer aCustomer: data.customerList){
						    	//REFACTORED ZK
						    	String existingCustID = aCustomer.getCustomerID();
								if(existingCustID.equals(customerID))
						    	{
						    		found = true;
						    		data.customer = aCustomer; 
						    		loop = false;
						    	}					    	
						    }
						    
						    if(found == false)
						    {
						    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
						    	if (reply == JOptionPane.YES_OPTION) {
						    		loop = true;
						    	}
						    	else if(reply == JOptionPane.NO_OPTION)
						    	{
						    		data.f.dispose();
						    		loop = false;
						    		
						    		admin();
						    	}
						    }  
						    else
						    {
						    	accountExist();
						    }
						    
						    
				}}
			}

			
	     });		
		
		
		deleteAccount.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
	boolean found = true, loop = true;
				
				
					 {
						    Object customerID = JOptionPane.showInputDialog(data.f, "Customer ID of Customer from which you wish to delete an account");
						    
						    for (Customer aCustomer: data.customerList){
						    	
						    	String existingCustID = aCustomer.getCustomerID();
								if(existingCustID.equals(customerID))
						    	{
						    		found = true;
						    		data.customer = aCustomer; 
						    		loop = false;
						    	}					    	
						    }
						    
						    if(found == false)
						    {
						    	int reply  = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?", JOptionPane.YES_NO_OPTION);
						    	if (reply == JOptionPane.YES_OPTION) {
						    		loop = true;
						    	}
						    	else if(reply == JOptionPane.NO_OPTION)
						    	{
						    		data.f.dispose();
						    		loop = false;
						    	
						    		admin();
						    	}
						    }  
						    else
						    {
						    	//Here I would make the user select a an account to delete from a combo box. If the account had a balance of 0 then it would be deleted. (I do not have time to do this)
						    }
						    
						    
				}}
			
	     });		
		returnButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				data.f.dispose();
				menuStart();				
			}
	     });		
	}
	
	public void customer(Customer e1)
	{	
		data.f = new JFrame("Customer Menu");
		e1 = data.e;
		data.f.setSize(400, 300);
		data.f.setLocation(200, 200);
		data.f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) { System.exit(0); }
		});          
		data.f.setVisible(true);
		
		if(data.e.getAccounts().size() == 0)
		{
			JOptionPane.showMessageDialog(data.f, "This customer does not have any accounts yet. \n An admin must create an account for this customer \n for them to be able to use customer functionality. " ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
			data.f.dispose();				
			menuStart();
		}
		else
		{
		JPanel buttonPanel = new JPanel();
		JPanel boxPanel = new JPanel();
		JPanel labelPanel = new JPanel();
		
		JLabel label = new JLabel("Select Account:");
		labelPanel.add(label);
		
		JButton returnButton = new JButton("Return");
		buttonPanel.add(returnButton);
		JButton continueButton = new JButton("Continue");
		buttonPanel.add(continueButton);
		
		JComboBox<String> box = new JComboBox<String>();
	    for (int i =0; i < data.e.getAccounts().size(); i++)
	    {
	     box.addItem(data.e.getAccounts().get(i).getNumber());
	    }
		
	    
	   
	    for(int i = 0; i<data.e.getAccounts().size(); i++)
	    {
	    	String accNum = data.e.getAccounts().get(i).getNumber();
			if(accNum == box.getSelectedItem() )
	    	{
	    		data.acc = data.e.getAccounts().get(i);
	    	}
	    }
	    
	    
	    
	
	    
		boxPanel.add(box);
		data.content = data.f.getContentPane();
		data.content.setLayout(new GridLayout(3, 1));
		data.content.add(labelPanel);
		data.content.add(boxPanel);
		data.content.add(buttonPanel);
		
		returnButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
			data.f.dispose();				
			menuStart();				
			}		
	     });
		
		continueButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				
		data.f.dispose();
		
		data.f = new JFrame("Customer Menu");
		data.f.setSize(400, 300);
		data.f.setLocation(200, 200);
		data.f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) { System.exit(0); }
		});          
		data.f.setVisible(true);
		
		JPanel statementPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton statementButton = new JButton("Display Bank Statement");
		statementButton.setPreferredSize(new Dimension(250, 20));
		
		statementPanel.add(statementButton);
		
		JPanel lodgementPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton lodgementButton = new JButton("Lodge money into account");
		lodgementPanel.add(lodgementButton);
		lodgementButton.setPreferredSize(new Dimension(250, 20));
		
		JPanel withdrawalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton withdrawButton = new JButton("Withdraw money from account");
		withdrawalPanel.add(withdrawButton);
		withdrawButton.setPreferredSize(new Dimension(250, 20));
		
		JPanel returnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton returnButton = new JButton("Exit Customer Menu");
		returnPanel.add(returnButton);

		JLabel label1 = new JLabel("Please select an option");
		
		data.content = data.f.getContentPane();
		data.content.setLayout(new GridLayout(5, 1));
		data.content.add(label1);
		data.content.add(statementPanel);
		data.content.add(lodgementPanel);
		data.content.add(withdrawalPanel);
		data.content.add(returnPanel);
		
		statementButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				data.f.dispose();
				data.f = new JFrame("Customer Menu");
				data.f.setSize(400, 600);
				data.f.setLocation(200, 200);
				data.f.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent we) { System.exit(0); }
				});          
				data.f.setVisible(true);
				
				JLabel label1 = new JLabel("Summary of account transactions: ");
				
				JPanel returnPanel = new JPanel();
				JButton returnButton = new JButton("Return");
				returnPanel.add(returnButton);
				
				JPanel textPanel = new JPanel();
				
				textPanel.setLayout( new BorderLayout() );
				JTextArea textArea = new JTextArea(40, 20);
				textArea.setEditable(false);
				textPanel.add(label1, BorderLayout.NORTH);
				textPanel.add(textArea, BorderLayout.CENTER);
				textPanel.add(returnButton, BorderLayout.SOUTH);
				
				JScrollPane scrollPane = new JScrollPane(textArea);
				textPanel.add(scrollPane);
				
				for (int i = 0; i < data.acc.getTransactionList().size(); i ++)
				{
					textArea.append(data.acc.getTransactionList().get(i).toString());
					
				}
				
				textPanel.add(textArea);
				data.content.removeAll();
				
				
				Container content = data.f.getContentPane();
				content.setLayout(new GridLayout(1, 1));
			//	content.add(label1);
				content.add(textPanel);
				//content.add(returnPanel);
				
				returnButton.addActionListener(new ActionListener(  ) {
					public void actionPerformed(ActionEvent ae) {
						data.f.dispose();			
					customer(data.e);				
					}		
			     });										
			}	
	     });
		
		lodgementButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
			boolean loop = true;
			boolean on = true;
			double balance = 0;

			on = UserCheck(on);		
			if(on == true)
					{
				balance = Lodge(balance);
				
			
			String euro = "\u20ac";
			 data.acc.setBalance(data.acc.getBalance() + balance);
			// String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			 Date date = new Date();
			 String date2 = date.toString();
			 String type = "Lodgement";
				double amount = balance;	
				AccountTransaction transaction = new AccountTransaction(date2, type, amount);
				data.acc.getTransactionList().add(transaction);
				
			 JOptionPane.showMessageDialog(data.f, balance + euro + " added do you account!" ,"Lodgement",  JOptionPane.INFORMATION_MESSAGE);
			 JOptionPane.showMessageDialog(data.f, "New balance = " + data.acc.getBalance() + euro ,"Lodgement",  JOptionPane.INFORMATION_MESSAGE);
			}

			}
			
			
			
			//checking  number value for lodgment method

			private double Lodge(double balance) {
				boolean loop;
				String balanceTest = JOptionPane.showInputDialog(data.f, "Enter amount you wish to lodge:");//the isNumeric method tests to see if the string entered was numeric. 
				if(isNumeric(balanceTest))
				{
					
					balance = Double.parseDouble(balanceTest);
					loop = false;
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(data.f, "You must enter a numerical value!" ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
				}
				return balance;
			}

	     });
		
		withdrawButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				boolean loop = true;
				boolean on = true;
				double withdraw = 0;

				on = UserCheck(on);	
				if(on == true)
						{
					withdraw = NumericCheckWithdrawl(withdraw);
					withdraw = withdrawl(withdraw);
				    String euro = "\u20ac";
				    data.acc.setBalance(data.acc.getBalance()-withdraw);
				    Date date = new Date();
				    String date2 = date.toString();	 
				    String type = "Withdraw";
					double amount = withdraw;
					
					AccountTransaction transaction = new AccountTransaction(date2, type, amount);
					data.acc.getTransactionList().add(transaction);	 
					
				 JOptionPane.showMessageDialog(data.f, withdraw + euro + " withdrawn." ,"Withdraw",  JOptionPane.INFORMATION_MESSAGE);
				 JOptionPane.showMessageDialog(data.f, "New balance = " + data.acc.getBalance() + euro ,"Withdraw",  JOptionPane.INFORMATION_MESSAGE);
						}
			}
		
			
			/**
			   * This method is extracted from withdrawlButton 
			   * Checks if data inputed is a number
			   */

			private double NumericCheckWithdrawl(double withdraw) {
				boolean loop;
				String balanceTest = JOptionPane.showInputDialog(data.f, "Enter amount you wish to withdraw (max 500):");//the isNumeric method tests to see if the string entered was numeric. 
				if(isNumeric(balanceTest))
				{
					
					withdraw = Double.parseDouble(balanceTest);
					loop = false;
					
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(data.f, "You must enter a numerical value!" ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
				}
				return withdraw;
			} 
			
			/**
			   * This method is extracted from withdrawlButton 
			   * Validates withdrawl amount
			   */
			
 			private double withdrawl(double withdraw) {
				if(withdraw > 500)
				{
					JOptionPane.showMessageDialog(data.f, "500 is the maximum you can withdraw at a time." ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
					withdraw = 0;
				}
				if(withdraw > data.acc.getBalance())
				{
					JOptionPane.showMessageDialog(data.f, "Insufficient funds." ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
					withdraw = 0;					
				}
				return withdraw;
			}	
	     });
		
		returnButton.addActionListener(new ActionListener(  ) {
			public void actionPerformed(ActionEvent ae) {
				data.f.dispose();		
				menuStart();				
			}
	     });		}		
	     });
	}
	}
	
	/**
	   * This method is extracted from AccountButton
	   * Checks if account type is current or Deposit
	   * method is called in the button
	   * 
	   * 
	   */	
	
	private void accountType(String account) {
		if(account.equals("Current Account"))
		{
			//create current account
			boolean valid = true;
			double balance = 0;
			String number = String.valueOf("C" + (data.customerList.indexOf(data.customer)+1) * 10 + (data.customer.getAccounts().size()+1));//this simple algorithm generates the account number
			ArrayList<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();
			int randomPIN = (int)(Math.random()*9000)+1000;
		       String pin = String.valueOf(randomPIN);
		
		       ATMCard atm = new ATMCard(randomPIN, valid);
			
			CustomerCurrentAccount current = new CustomerCurrentAccount(atm, number, balance, transactionList);
			
			data.customer.getAccounts().add(current);
			JOptionPane.showMessageDialog(data.f, "Account number = " + number +"\n PIN = " + pin  ,"Account created.",  JOptionPane.INFORMATION_MESSAGE);
			
			data.f.dispose();
			admin();
		}
		
		if(account.equals("Deposit Account"))
		{
			//create deposit account
			
			double balance = 0, interest = 0;
			String number = String.valueOf("D" + (data.customerList.indexOf(data.customer)+1) * 10 + (data.customer.getAccounts().size()+1));//this simple algorithm generates the account number
			ArrayList<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();
		    	
			CustomerDepositAccount deposit = new CustomerDepositAccount(interest, number, balance, transactionList);
			
			data.customer.getAccounts().add(deposit);
			JOptionPane.showMessageDialog(data.f, "Account number = " + number ,"Account created.",  JOptionPane.INFORMATION_MESSAGE);
			
			data.f.dispose();
			admin();
		}
	}
	   
	   
	/**
	   * This method is extracted from customerChoice() method
	   * 
	   * Validates password
	   * 
	   * Zaid Kurchied
	   */	
			private boolean passwordValidation(boolean loop) {
				if(data.password.length() != 7)//Making sure password is 7 characters
				    {
				    	JOptionPane.showMessageDialog(null, null, "Password must be 7 charatcers long", JOptionPane.OK_OPTION);
				    }
				 else
				 {
					 loop = false;
				 }
				return loop;
			}
			
			/**
			   * This method is extracted from WithdrawButton and Lodgement Button
			   * Both buttons use this same method 
			   * other code inside the buttons has been removed and used because the code was repeated
			   * Validates password
			   * 
			   * Zaid Kurchied
			   */			
			private boolean UserCheck(boolean on) {
				boolean loop;
				if(data.acc instanceof CustomerCurrentAccount)
				{
					int count = 3;
					int checkPin = ((CustomerCurrentAccount) data.acc).getAtm().getPin();
					loop = true;
					
					while(loop)
					{
						if(count == 0)
						{
							JOptionPane.showMessageDialog(data.f, "Pin entered incorrectly 3 times. ATM card locked."  ,"Pin",  JOptionPane.INFORMATION_MESSAGE);
							((CustomerCurrentAccount) data.acc).getAtm().setValid(false);
							customer(data.e); 
							loop = false;
							on = false;
						}
						
						String Pin = JOptionPane.showInputDialog(data.f, "Enter 4 digit PIN;");
						int i = Integer.parseInt(Pin);
						
					   if(on)
					   {
						if(checkPin == i)
						{
							loop = false;
							JOptionPane.showMessageDialog(data.f, "Pin entry successful" ,  "Pin", JOptionPane.INFORMATION_MESSAGE);
							
						}
						else
						{
							count --;
							JOptionPane.showMessageDialog(data.f, "Incorrect pin. " + count + " attempts remaining."  ,"Pin",  JOptionPane.INFORMATION_MESSAGE);		
						
						}
					
					}
					}    
										
				}
				return on;
			}
			

			/**
			   * This method is extracted from DeleteCustomer button
			   * Checks if  customer exists and deletes the customer
			  
			   * Zaid Kurchied
			   * 
			   */	
			private void accountExist() {
				if(data.customer.getAccounts().size()>0)
				{
					JOptionPane.showMessageDialog(data.f, "This customer has accounts. \n You must delete a customer's accounts before deleting a customer " ,"Oops!",  JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					data.customerList.remove(data.customer);
					JOptionPane.showMessageDialog(data.f, "Customer Deleted " ,"Success.",  JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
			/**
			   * This method is extracted from Previous Button
			   * Zaid Kurchied
			
			   * 
			   */	
			private void positionChecker() {
				if(data.position < 1)
				{
					//don't do anything
				}
				else
				{
					data.position = data.position - 1;
					
				data.firstNameTextField.setText(data.customerList.get(data.position).getFirstName());
				data.surnameTextField.setText(data.customerList.get(data.position).getSurname());
				data.pPSTextField.setText(data.customerList.get(data.position).getPPS());
				data.dOBTextField.setText(data.customerList.get(data.position).getDOB());
				data.customerIDTextField.setText(data.customerList.get(data.position).getCustomerID());
				data.passwordTextField.setText(data.customerList.get(data.position).getPassword());
				}
			}	
			
			
			/**
			   * This method is extracted from continueButton
			   * 
			   * Zaid Kurchied
			   */	
			private void accountChecker(String euro) {
				if(data.acc instanceof CustomerDepositAccount)
				{	
				JOptionPane.showMessageDialog(data.f, "25" + euro + " deposit account fee aplied."  ,"",  JOptionPane.INFORMATION_MESSAGE);
				data.acc.setBalance(data.acc.getBalance()-25);
				JOptionPane.showMessageDialog(data.f, "New balance = " + data.acc.getBalance() ,"Success!",  JOptionPane.INFORMATION_MESSAGE);
				}

				if(data.acc instanceof CustomerCurrentAccount)
				{
				
				JOptionPane.showMessageDialog(data.f, "15" + euro + " current account fee aplied."  ,"",  JOptionPane.INFORMATION_MESSAGE);
				data.acc.setBalance(data.acc.getBalance()-25);
				JOptionPane.showMessageDialog(data.f, "New balance = " + data.acc.getBalance() ,"Success!",  JOptionPane.INFORMATION_MESSAGE);
				}
			}	
			/**
			   * This method is extracted from summaryButton
			   *  Retrieves transactions for each customer
			   * Zaid Kurchied
			   * 
			   * 
			   */	
			private void customerTransaction(JTextArea textArea, int a) {
				for (int b = 0; b < data.customerList.get(a).getAccounts().size(); b ++ )
				{
					data.acc = data.customerList.get(a).getAccounts().get(b);
					for (int c = 0; c < data.customerList.get(a).getAccounts().get(b).getTransactionList().size(); c++)
					{
						
						textArea.append(data.acc.getTransactionList().get(c).toString());
						//Int total = acc.getTransactionList().get(c).getAmount(); //I was going to use this to keep a running total but I couldnt get it  working.
						
					}				
				}
			}
			
	public static boolean isNumeric(String str)  // a method that tests if a string is numeric
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
}


