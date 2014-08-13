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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ViewCustomerInvoicePanel extends JPanel{

	//Variables
	private Invoice invoice = new Invoice();
	private JTextArea textarea;
	private ArrayList<Invoice> invoices = new ArrayList<Invoice>();
	private JTextField invTextField;
	private JTextField custIdTextField;
	
	//Constructor
	public ViewCustomerInvoicePanel() {
		//Create an arraylist of 3 invoice objects to tst the GUI
		Invoice inv1 = new Invoice(1, new Employee(1,"marc",1,100.00,1234), new Customer(1,"Penguin","Galway"), new Product("a", "b", "d", 50.00, 20.00, 10, 20, 2, new Supplier(1,"f","g")),10);
		Invoice inv2 = new Invoice(2, new Employee(2,"john",2,110.00,4567), new Customer(1,"Rudds","Galway"), new Product("x", "x", "x", 55.00, 25.00, 20, 30, 3, new Supplier(2,"h","h")),12);
		Invoice inv3 = new Invoice(3, new Employee(3,"mary",3,130.00,3987), new Customer(3,"Dennys","Cork"), new Product("y", "y", "y", 60.00, 30.00, 30, 40, 4, new Supplier(3,"m","m")),14);
		invoices.add(inv1);
		invoices.add(inv2);
		invoices.add(inv3);
		
		//Setting the size of the panel
		Dimension size = getPreferredSize();
		size.width = 200;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Invoice details"));
		
		// Tell Java that we are using GridBoxLayout in the Panel
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.insets = new Insets(5,5,5,5); //sets the padding around each component
		
		/**
		 * Add All the Components
		 * 	TextArea x1
		 *  Label x2
		 *  TextField x2
		 *  Button x5
		 *  
		 */
		//1. TextArea
		textarea = new JTextArea(10,20); //height - width
		textarea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textarea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
		
		// First Label and controls:	View Invoice by ID 
		JLabel invIdlbl = new JLabel("Invoice ID: "); //Label
		gc.gridx = 0;
		gc.gridy = 1;
		add(invIdlbl,gc);
		invTextField = new JTextField(10); //Text Field
		gc.gridx = 1;
		gc.gridy = 1;
		add(invTextField,gc);
		JButton invButton = new JButton("Invoice ID");	//button
		gc.gridx = 2;
		gc.gridy = 1;
		add(invButton,gc);
		//Action listener For Button to view Invoice by Id
		invButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = invTextField.getText();
				if(input.trim().equals("") || input.matches(".*\\D.*")){ //regEx
					textarea.setText("Please enter a valid number");
					invTextField.setText("");
					custIdTextField.setText("");
				}else{
					int num = Integer.parseInt(input);
					textarea.setText(invoice.viewInvoiceById(num, invoices)); //viewInvoiceById() is in the Invoice Class
					invTextField.setText("");
					custIdTextField.setText("");
				}
			}
		});
		
		//Second Label and controls: 	View Customer by ID
		JLabel custIdlbl = new JLabel("Customer ID: ");
		gc.gridx = 0;
		gc.gridy = 2;
		add(custIdlbl,gc);
		custIdTextField = new JTextField(10);
		gc.gridx = 1;
		gc.gridy = 2;
		add(custIdTextField,gc);
		JButton custIdButton = new JButton("Customer ID");
		gc.gridx = 2;
		gc.gridy = 2;
		add(custIdButton,gc);
		custIdButton.addActionListener(new ActionListener() {
			//Action listener For Button to view Customer by Id
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = custIdTextField.getText();
				if(input.trim().equals("") || input.matches(".*\\D.*")){ //regEx
					textarea.setText("Please enter a valid number");
					custIdTextField.setText("");
					invTextField.setText("");
				}else{
					int num = Integer.parseInt(input);
					textarea.setText(invoice.viewInvoiceByCustomer(num, invoices));	//viewInvoiceByCustomer() is in the Invoice class
					custIdTextField.setText("");
					invTextField.setText("");
				}
			}
		});
		
		//Button x3: 	View All/ View Paid/ View UnPaid
		//1. View all Button
		JButton viewAllBtn = new JButton("View All");
		gc.gridx = 0;
		gc.gridy = 3;
		add(viewAllBtn,gc);
		viewAllBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textarea.setText(invoice.viewAllInvoices(invoices));	//viewAllInvoices() is in the Invoice Class
			}
		});
		
		//2. Paid Button
		JButton viewPaidBtn = new JButton("View Paid");
		gc.gridx = 1;
		gc.gridy = 3;
		add(viewPaidBtn,gc);
		viewPaidBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textarea.setText(invoice.viewPaidInvoice(invoices));	//viewPaidInvoice() is in the invoice class
				
			}
		});
		
		//3. UnPaid Button
		JButton viewUnpaidBtn = new JButton("View Unpaid");
		viewUnpaidBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textarea.setText(invoice.viewUnPaidInvoice(invoices));	//viewUnPaidInvoice() is in the invoice class
			}
		});
		gc.gridx = 2;
		gc.gridy = 3;
		add(viewUnpaidBtn,gc);
		
	} //End of Constructor
	
} //End of Class
