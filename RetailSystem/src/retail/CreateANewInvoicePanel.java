package retail;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateANewInvoicePanel extends JPanel {

	// variables
	private JLabel invoiceIdLabel, employeeIdLabel, customerIdLabel,
			productCodeLabel, quantityLabel;//, resultLabel; may not need this label, neater with JOptionPanes
	private JTextField invTextField, emplTextField, custTextField,
			prodCodeTextField, quantityTextField;
	private JButton createInvBtn;

	// 3 Arraylists used for testing purpose only!! will be Deleted!!
	private ArrayList<Employee> employees = new ArrayList<>();
	private ArrayList<Customer> customers = new ArrayList<>();
	private ArrayList<Product> products = new ArrayList<>();
	private ArrayList<Invoice> invoices = new ArrayList<>();
	private Invoice invoice = new Invoice();

	public CreateANewInvoicePanel() {
		// Setting the size
		Dimension size = getPreferredSize();
		size.width = 200;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Create a new Invoice"));

		// Tell Java that we are using GridBoxLayout in the Panel
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.insets = new Insets(5, 5, 5, 5);

		// Add Components to the Panel
		invoiceIdLabel = new JLabel("Invoice ID: ");
		gc.gridx = 0;
		gc.gridy = 0;
		add(invoiceIdLabel, gc);
		invTextField = new JTextField(10);
		gc.gridx = 1;
		gc.gridy = 0;
		Font bigFont = invTextField.getFont().deriveFont(Font.PLAIN, 20f); //used to se the height of the textBox!!
		invTextField.setFont(bigFont);
		add(invTextField, gc);
		// ====
		employeeIdLabel = new JLabel("Employee ID: ");
		gc.gridx = 0;
		gc.gridy = 1;
		add(employeeIdLabel, gc);
		emplTextField = new JTextField(10);
		gc.gridx = 1;
		gc.gridy = 1;
		emplTextField.setFont(bigFont);
		add(emplTextField, gc);
		// ====
		customerIdLabel = new JLabel("Customer ID: ");
		gc.gridx = 0;
		gc.gridy = 2;
		add(customerIdLabel, gc);
		custTextField = new JTextField(10);
		gc.gridx = 1;
		gc.gridy = 2;
		custTextField.setFont(bigFont);
		add(custTextField, gc);
		// ====
		productCodeLabel = new JLabel("Product Code: ");
		gc.gridx = 0;
		gc.gridy = 3;
		add(productCodeLabel, gc);
		prodCodeTextField = new JTextField(10);
		gc.gridx = 1;
		gc.gridy = 3;
		prodCodeTextField.setFont(bigFont);
		add(prodCodeTextField, gc);
		// ====
		quantityLabel = new JLabel("Quantity: ");
		gc.gridx = 0;
		gc.gridy = 4;
		add(quantityLabel, gc);
		quantityTextField = new JTextField(10);
		gc.gridx = 1;
		gc.gridy = 4;
		quantityTextField.setFont(bigFont);
		add(quantityTextField, gc);
		// ====
		createInvBtn = new JButton("Create Invoice");
		gc.gridx = 1;
		gc.gridy = 5;
		add(createInvBtn, gc);
		createInvBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String invoiceIdString = invTextField.getText();
				String emplyIdString = emplTextField.getText();
				String custIdString = custTextField.getText();
				String prodCode = prodCodeTextField.getText();
				String quantityString = quantityTextField.getText();
				
				//check to see if any of the input boxes have been left empty or wrong input
				if((invoiceIdString.trim().equals("") || invoiceIdString.matches(".*\\D.*"))|| 
						(emplyIdString.trim().equals("") || emplyIdString.matches(".*\\D.*")) || 
						(custIdString.trim().equals("") || custIdString.matches(".*\\D.*"))||
						prodCode.trim().equals("")||
						(quantityString.trim().equals("") || quantityString.matches(".*\\D.*")))
				{
					//resultLabel.setText("Please ensure all text fields have been filled");
					JOptionPane.showMessageDialog (null, "Please ensure all text fields have been filled", "Missing Info", JOptionPane.WARNING_MESSAGE);
				}else{
					int invoiceId = Integer.parseInt(invoiceIdString);
					int emplyId = Integer.parseInt(emplyIdString);
					int custId = Integer.parseInt(custIdString);
					int quantity = Integer.parseInt(quantityString);

					// Fill arraylist with test info. Will be deleted also!!!!!!
					employees.add(new Employee(1, "marc", 1, 50.00, 1234));
					customers.add(new Customer(2, "Paddy Power", "Dublin"));
					products.add(new Product("y", "y", "code", 60.00, 30.00, 30,40, 4, new Supplier(3, "m", "m")));

					//Objects needed to create the invoice Object
					Employee emplInput = invoice.returnEmployeeObject(emplyId,employees);
					Customer cusInput = invoice.returnCustomerObject(custId,customers);
					Product prodInput = invoice.returnProductObject(prodCode, products);

					
					
					
					// create a new Invoice with checks. Need to be finished!!
					if (emplInput != null) {				
						if (cusInput != null) {
							if (prodInput != null) {
								if(invoiceNumberUnique(invoiceId,invoices)){ 
							//create a new Invoice Object with input
								Invoice inv = new Invoice(invoiceId, emplInput, cusInput, prodInput, quantity);
							//Add the newly created Invoice to the list
								invoices.add(inv);
								//System.out.println(invoices.size()); //delete this, used for testing only!!
							//Set Label to Confirmation
								//resultLabel.setText("Thank you for the order"); useful link for jOptionPane
								JOptionPane.showMessageDialog (null, "Thank you for the order", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
							// reset the textboxes to empty
								invTextField.setText("");
								emplTextField.setText("");
								custTextField.setText("");
								prodCodeTextField.setText("");
								quantityTextField.setText("");
								}else{
									
									JOptionPane.showMessageDialog (null, "Invoice Number is not Unique", "Invoice Info", JOptionPane.WARNING_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog (null, "No Product Record exist with that Input", "Product Info", JOptionPane.WARNING_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog (null, "No Customer Record exist with that Input", "Customer Info", JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog (null, "No Employee Record exist with that Input", "Employee Info", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		//Result label to display message to user. Possibly not needed!!
		/*resultLabel = new JLabel("");
		gc.gridx = 0;
		gc.gridy = 6;
		add(resultLabel, gc);*/
	}
	
	//Method to check to see if invoice number is unique
	public boolean invoiceNumberUnique(int id, ArrayList<Invoice> invoices){
		int count = 0;
		for(Invoice i : invoices){
			if(i.getId()==id){
				count++;
			}
		}
		if(count>=1)
			return false;
		else 
			return true;
		
	}

}
