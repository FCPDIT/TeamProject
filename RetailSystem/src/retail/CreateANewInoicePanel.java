package retail;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateANewInoicePanel extends JPanel {

	// variables
	private JLabel invoiceIdLabel, employeeIdLabel, customerIdLabel,
			productCodeLabel, quantityLabel, resultLabel;
	private JTextField invTextField, emplTextField, custTextField,
			prodCodeTextField, quantityTextField;
	private JButton createInvBtn;

	// 3 Arraylists used for testing purpose only!! will be Deleted!!
	private ArrayList<Employee> employees = new ArrayList<>();
	private ArrayList<Customer> customers = new ArrayList<>();
	private ArrayList<Product> products = new ArrayList<>();
	private ArrayList<Invoice> invoices = new ArrayList<>();
	private Invoice invoice = new Invoice();

	public CreateANewInoicePanel() {
		// Setting the size
		Dimension size = getPreferredSize();
		size.width = 200;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Create a new Invoice"));

		// Tell Java that we are using GridBoxLayout in the Panel
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.insets = new Insets(5, 5, 5, 5);

		// Add Componoents to the Panel
		invoiceIdLabel = new JLabel("Invoice ID: ");
		gc.gridx = 0;
		gc.gridy = 0;
		add(invoiceIdLabel, gc);
		invTextField = new JTextField(10);
		gc.gridx = 1;
		gc.gridy = 0;
		add(invTextField, gc);
		// ====
		employeeIdLabel = new JLabel("Employee ID: ");
		gc.gridx = 0;
		gc.gridy = 1;
		add(employeeIdLabel, gc);
		emplTextField = new JTextField(10);
		gc.gridx = 1;
		gc.gridy = 1;
		add(emplTextField, gc);
		// ====
		customerIdLabel = new JLabel("Customer ID: ");
		gc.gridx = 0;
		gc.gridy = 2;
		add(customerIdLabel, gc);
		custTextField = new JTextField(10);
		gc.gridx = 1;
		gc.gridy = 2;
		add(custTextField, gc);
		// ====
		productCodeLabel = new JLabel("Product Code: ");
		gc.gridx = 0;
		gc.gridy = 3;
		add(productCodeLabel, gc);
		prodCodeTextField = new JTextField(10);
		gc.gridx = 1;
		gc.gridy = 3;
		add(prodCodeTextField, gc);
		// ====
		quantityLabel = new JLabel("Quantity: ");
		gc.gridx = 0;
		gc.gridy = 4;
		add(quantityLabel, gc);
		quantityTextField = new JTextField(10);
		gc.gridx = 1;
		gc.gridy = 4;
		add(quantityTextField, gc);
		// ====
		createInvBtn = new JButton("Create Invoice");
		gc.gridx = 1;
		gc.gridy = 5;
		add(createInvBtn, gc);
		createInvBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int invoiceId = Integer.parseInt(invTextField.getText());
				int emplyId = Integer.parseInt(emplTextField.getText());
				int custId = Integer.parseInt(custTextField.getText());
				String prodCode = prodCodeTextField.getText();
				int quantity = Integer.parseInt(quantityTextField.getText());

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
						//Add the newely created Invoice to the list
							invoices.add(inv);
							System.out.println(invoices.size());
						//Set Label to Confirmation
							resultLabel.setText("Thank you for the order");
						// reset the textboxes to empty
							invTextField.setText("");
							emplTextField.setText("");
							custTextField.setText("");
							prodCodeTextField.setText("");
							quantityTextField.setText("");
							}else{
								resultLabel.setText("Invoice Number is not Unique");
							}
						} else {
							resultLabel.setText("No Product Record exist with that Input");
						}
					} else {
						resultLabel.setText("No Customer Record exist with that Input");
					}
				} else {
					resultLabel.setText("No Employee Record exist with that Input");
				}

			}
		});
		//Result label to display message to user
		resultLabel = new JLabel("");
		gc.gridx = 0;
		gc.gridy = 6;
		add(resultLabel, gc);

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
