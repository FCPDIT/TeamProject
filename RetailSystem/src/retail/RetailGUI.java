package retail;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class RetailGUI extends JFrame{
	
	private ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	private ArrayList<Invoice> invoices = new ArrayList<Invoice>();
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<Product> products = new ArrayList<Product>();
	private ArrayList<Employee> employees  = new ArrayList<Employee>();

	private JFrame mainJFrame = new JFrame();
	private GridLayout grid = new GridLayout(0, 1, 0, 10);
	private JTabbedPane mainJTabbedPane = new JTabbedPane();
	JScrollPane scrollPane = new JScrollPane();
	
	private JPanel loginJPanel = new JPanel();
	private JTabbedPane custJTabbedPane = new JTabbedPane();
	private JTabbedPane supplyJTabbedPane = new JTabbedPane();
	private JTabbedPane prodJTabbedPane = new JTabbedPane();
	private JTabbedPane invJTabbedPane = new JTabbedPane();
	private JTabbedPane stockJTabbedPane = new JTabbedPane();
	private JTabbedPane accessJTabbedPane = new JTabbedPane();
	private JTabbedPane proflossJTabbedPane = new JTabbedPane();
	
	private JPanel addCustJPanel = new JPanel();
	private JPanel viewCustJPanel = new JPanel();
	private JPanel editCustJPanel = new JPanel();
	
	private JPanel addSupplyJPanel = new JPanel();
	private JPanel viewSupplyJPanel = new JPanel();
	private JPanel editSupplyJPanel = new JPanel();
	
	private JPanel addProductJPanel = new JPanel();
	private JPanel viewProductJPanel = new ViewProductDetailsPanel();
	private JPanel editProductJPanel = new JPanel();
	
	private JPanel createInvJPanel = new CreateANewInoicePanel();
	private JPanel viewInvJPanel = new ViewCustomerInvoicePanel();
	private JPanel editInvJPanel = new JPanel();
	
	private JPanel viewStockJPanel = new JPanel();
	private JPanel editStockJPanel = new JPanel();
	
	private JPanel accessJPanel = new JPanel();
	
	private JPanel proflossJPanel = new JPanel();
	
	private JPanel logoutJPanel = new JPanel();
	
	//login components
	JPanel loginComponentsJPanel = new JPanel();
	private JTextField loginTF = new JTextField();
	private JTextField passwordTF = new JTextField();
	private JButton loginBut = new JButton();
	
	//logout components
	private JButton logoutBut = new JButton();
	
	//Customer Components
	private JLabel custIdJLabel = new JLabel("Enter Customer ID");
	private JTextField custIdJTextField = new JTextField();
	private JLabel custNameJLabel = new JLabel("Enter Customer Name");
	private JTextField custNameJTextField = new JTextField();
	private JLabel custAddressJLabel = new JLabel("Enter Customer Address");
	private JTextField custAddressJTextField = new JTextField();
	private JLabel custEmailJLabel = new JLabel("Enter Customer Email");
	private JTextField custEmailJTextField = new JTextField();
	private JLabel custPhoneJLabel = new JLabel("Enter Customer Phone");
	private JTextField custPhoneJTextField = new JTextField();	
	private JButton custJButton  = new JButton("Create New Customer");
	private JLabel viewCustById = new JLabel("Find Customer By ID: ");
	private JTextField custById = new JTextField();
	private JLabel viewCustByName = new JLabel("Find Customer By Name: ");
	private JTextField custByName = new JTextField();
	private JButton viewCustJButton = new JButton("View Customer");
	private JButton viewAllCustJButton = new JButton("View All Customers");
	private JTextArea custJTextArea = new JTextArea(10,20);
	private JTextField editCustById = new JTextField();
	private JButton findCustById = new JButton("Find Customer");
	private JTextField editCustId = new JTextField();
	private JTextField editCustName = new JTextField();
	private JTextField editCustAddress = new JTextField();
	private JTextField editCustEmail = new JTextField();
	private JTextField editCustPhone = new JTextField();
	private JButton updateCustJButton = new JButton("Update Customer Details");
	private JButton deleteCustJButton = new JButton("Delete Customer");
	
	//Supplier Components
	private JLabel supplierIdJLabel = new JLabel("Supplier ID: ");
	private JTextField supplierIdJTextField = new JTextField();
	private JLabel supplierNameJLabel = new JLabel("Supplier Name: ");
	private JTextField supplierNameJTextField = new JTextField();
	private JLabel supplierAddressJLabel = new JLabel("Supplier Address: ");
	private JTextField supplierAddressJTextField = new JTextField();
	private JLabel supplierEmailJLabel= new JLabel("Supplier Email: ");
	private JTextField supplierEmailJTextField = new JTextField();
	private JLabel supplierPhoneJLabel = new JLabel("Supplier Phone Number: ");
	private JTextField supplierPhoneJTextField = new JTextField();
	private JButton supplierJButton = new JButton("Create New Supplier");
	private JLabel viewSupplyJLabel = new JLabel("Search by Supplier ID: ");
	private JTextField viewSupplyJTextField = new JTextField();
	private JLabel viewSupplyNameJLabel = new JLabel("Search by Supplier Name: ");
	private JTextField viewSupplyNameJTextField = new JTextField();
	private JTextArea supplierJTextArea = new JTextArea(20, 20);
	private JButton viewSupplyJButton = new JButton("View Supplier Details");
	private JButton allSupplyJButton = new JButton("View All Suppliers");
	private JTextField editSupplierJTextField = new JTextField();
	private JButton editSupplierJButton = new JButton("Find Supplier");
	private JTextField editSupplierId = new JTextField();
	private JTextField editSupplierName = new JTextField();
	private JTextField editSupplierAddress = new JTextField();
	private JTextField editSupplierEmail = new JTextField();
	private JTextField editSupplierPhone = new JTextField();
	private JTextField editSupplierDelivery = new JTextField();
	private JButton saveSupplierJButton = new JButton("Update Supplier");
	private JButton deleteSupplierJButton = new JButton("Delete Supplier");
	
	//Edit Invoice Components 
		JPanel findInvoiceComponentsJPanel = new JPanel();
		JPanel editInvoiceComponentsJPanel = new JPanel();
		JPanel editCustomerInvoiceComponentsJPanel = new JPanel();
		JPanel saveInvoiceComponentsJPanel = new JPanel();
		private JTextField editInvoiceJTextField = new JTextField("Invoice Id");
		private JTextArea customerInvoiceJTextArea = new JTextArea(10,20);
		private JTextField allInvoicesTotalJTextField = new JTextField("Total Owed");
		private JButton payAllInvoicesJButton = new JButton("Pay All Invoices");
		private JButton editInvoiceJButton = new JButton("Find Invoice by Id");
		private JTextField editCustomerInvoiceJTextField = new JTextField("Customer Id");
		private JButton editCustomerInvoiceJButton = new JButton("Find Invoice by Customer");
		private JTextField editInvoiceId = new JTextField("Edit Invoice Id:");
		private JTextField editInvoiceEmployee = new JTextField("Edit Invoice Employee");
		private JTextField editInvoiceCustomer = new JTextField("Edit Invoice Customer");
		private JTextField editInvoiceProduct = new JTextField("Edit Product");
		private JTextField editInvoiceQuantity = new JTextField("Edit Product Quantity");
		private JButton payInvoiceJButton = new JButton("Pay Invoice");
		private JButton saveInvoiceJButton = new JButton("Update Invoice");
		private JButton deleteInvoiceJButton = new JButton("Delete Invoice");
		private JTextField editPayStatus = new JTextField("");
	
	public RetailGUI() {
		
		//add some test employees to array list
		employees.add(new Employee(123, "John", 0, 2000.00, 1111));
		employees.add( new Employee(234, "Tim", 1, 1500.00, 3333));
		//add some test customers to array list
		customers.add(new Customer(1, "Sam", "Dublin"));
		customers.add(new Customer(2, "Tom", "Cork"));
		//add some test suppliers to array list
		suppliers.add(new Supplier(1, "Sam", "Dublin","sam@email.com","123456"));
		suppliers.add(new Supplier(2, "Tom", "Cork","tom@email.com","234567"));
		//add some test products to array list
		products.add(new Product("Game of Thrones", "George R.R Martin", "9780553386790", 9.99, 3.75,100,200,15, suppliers.get(0)));
		products.add(new Product("Not a Drill", "Lee Child", "9780553389521", 12.75, 4.95,50,200,10, suppliers.get(1)));
		//add some test invoices to array list
		invoices.add(new Invoice(1, employees.get(0), customers.get(0), products.get(0), 10));
		invoices.add(new Invoice(2, employees.get(1), customers.get(1), products.get(1), 20));

		// TODO Auto-generated constructor stub
		mainJFrame.setTitle("Retail Application");
		mainJFrame.setBounds(0, 0, 800, 600);
		mainJFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainJFrame.setVisible(true);
		mainJFrame.add(mainJTabbedPane);
		
		mainJTabbedPane.add("Login", loginJPanel);
		mainJTabbedPane.add("Customer Management", custJTabbedPane);
		mainJTabbedPane.add("Supplier Management", supplyJTabbedPane);
		mainJTabbedPane.add("Product Management", prodJTabbedPane);
		mainJTabbedPane.add("Invoice Management", invJTabbedPane);
		mainJTabbedPane.add("Order Management", stockJTabbedPane);
		mainJTabbedPane.add("Manage Employee Access", accessJTabbedPane);
		mainJTabbedPane.add("Profit and Loss", proflossJTabbedPane);
		mainJTabbedPane.add("Logout", logoutJPanel);
		
		custJTabbedPane.add("Create New Customer",addCustJPanel);
		custJTabbedPane.add("View Customer Details", viewCustJPanel);
		custJTabbedPane.add("Edit Customer Details", editCustJPanel);
		
		supplyJTabbedPane.add("Create New Supplier",addSupplyJPanel);
		supplyJTabbedPane.add("View Supplier Details", viewSupplyJPanel);
		supplyJTabbedPane.add("Edit Supplier Details", editSupplyJPanel);
		
		prodJTabbedPane.add("Create New Product",addProductJPanel);
		prodJTabbedPane.add("View Product Details", viewProductJPanel);
		prodJTabbedPane.add("Edit Product Details", editProductJPanel);
		
		invJTabbedPane.add("Create New Invoice", createInvJPanel);
		invJTabbedPane.add("View Customer Invoice", viewInvJPanel);
		invJTabbedPane.add("Edit Customer Invoice", editInvJPanel);
		
		stockJTabbedPane.add("View Available Stock", viewStockJPanel);
		stockJTabbedPane.add("Edit Stock", editStockJPanel);
		
		accessJTabbedPane.add("Coming Soon", accessJPanel);
		accessJTabbedPane.setEnabled(false);
		proflossJTabbedPane.add("Coming Soon", proflossJPanel);
		proflossJTabbedPane.setEnabled(false);
		
		addCustJPanel.setLayout(grid);
		viewCustJPanel.setLayout(grid);
		editCustJPanel.setLayout(grid);
		addCustJPanel.add(custIdJLabel);
		addCustJPanel.add(custIdJTextField);
		addCustJPanel.add(custNameJLabel);
		addCustJPanel.add(custNameJTextField);
		addCustJPanel.add(custAddressJLabel);
		addCustJPanel.add(custAddressJTextField);
		addCustJPanel.add(custEmailJLabel);
		addCustJPanel.add(custEmailJTextField);
		addCustJPanel.add(custPhoneJLabel);
		addCustJPanel.add(custPhoneJTextField);
		addCustJPanel.add(custJButton);
		viewCustJPanel.add(viewCustById);
		viewCustJPanel.add(custById);
		viewCustJPanel.add(viewCustByName);
		viewCustJPanel.add(custByName);
		viewCustJPanel.add(viewCustJButton);
		viewCustJPanel.add(viewAllCustJButton);
		viewCustJPanel.add(custJTextArea);
		custJTextArea.setLineWrap(true);
		editCustJPanel.add(editCustById);
		editCustJPanel.add(findCustById);
		editCustJPanel.add(editCustId);
		editCustJPanel.add(editCustName);
		editCustJPanel.add(editCustAddress);
		editCustJPanel.add(editCustEmail);
		editCustJPanel.add(editCustPhone);
		editCustJPanel.add(updateCustJButton);
		editCustJPanel.add(deleteCustJButton);
		
		
		custJButton.addActionListener(new ActionListener(){
			// function to add a new customer
			public void actionPerformed(ActionEvent e){
				Customer customer = new Customer(Integer.parseInt(custIdJTextField.getText()),
						custNameJTextField.getText(),custAddressJTextField.getText(), custEmailJTextField.getText(),
						custPhoneJTextField.getText());
				customers.add(customer);
				JOptionPane.showMessageDialog(null, "New Customer Added");			}
				
		});
		
		viewCustJButton.addActionListener(new ActionListener(){
			// function to view a customer by id or name
			public void actionPerformed(ActionEvent e){
				if(customers.size() >= 1){
					for(Customer customer: customers){
						if(customer.getCustId() == Integer.parseInt(custById.getText()) || customer.getCustName() == custByName.getText()){
							custJTextArea.setText(" Customer Id: "+customer.getCustId()
									+"\n Customer Name: "+customer.getCustName()
									+"\n Customer Address: "+customer.getCustAddress()
									+"\n Customer Email: "+customer.getCustEmail()
									+"\n Customer Phone: "+customer.getCustTelephone());
						}else{
							JOptionPane.showMessageDialog(null, "Customer Not Found.");
						}
					}
				}else{
					JOptionPane.showMessageDialog(null, "No Customers Found");
				}
			}
		});
		
		viewAllCustJButton.addActionListener(new ActionListener(){
			// function to view all customers
			public void actionPerformed(ActionEvent e){
				if(customers.size() >= 1){
					for(Customer customer: customers){
						custJTextArea.setText(" Customer Id: "+customer.getCustId()
									+"\n Customer Name: "+customer.getCustName()
									+"\n Customer Address: "+customer.getCustAddress()
									+"\n Customer Email: "+customer.getCustEmail()
									+"\n Customer Phone: "+customer.getCustTelephone());
					}
				}else{
					JOptionPane.showMessageDialog(null, "No Customers Found");
				}
			}
		});
		
		findCustById.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for(Customer customer: customers){
					if(customer.getCustId() == Integer.parseInt(editCustById.getText())){
						editCustId.setText(Integer.toString(customer.getCustId()));
						editCustName.setText(customer.getCustName());
						editCustAddress.setText(customer.getCustAddress());
						editCustEmail.setText(customer.getCustEmail());
						editCustPhone.setText(customer.getCustTelephone());
					}else{
						JOptionPane.showMessageDialog(null, "Customer Not Found");
					}
				}
			}
		});
		
		updateCustJButton.addActionListener(new ActionListener(){
			//update a specific customer
			public void actionPerformed(ActionEvent e){
				for(Customer customer: customers){
					if(customer.getCustId() == Integer.parseInt(editCustById.getText())){
						customer.setCustId(Integer.parseInt(editCustId.getText()));
						customer.setCustName(editCustName.getText());
						customer.setCustAddress(editCustAddress.getText());
						customer.setCustEmail(editCustEmail.getText());
						customer.setCustTelephone(editCustPhone.getText());
					}else{
						JOptionPane.showMessageDialog(null, "Customer Not Updated.");
					}
				}
			}
		});
		
		deleteCustJButton.addActionListener(new ActionListener(){
			//delete function for customer
			public void actionPerformed(ActionEvent arg){
				for(Customer customer: customers){
					if(customer.getCustId() == Integer.parseInt(editCustById.getText())){
						customers.remove(customer);
					}else{
						JOptionPane.showMessageDialog(null, "Customer Not Deleted");
					}
				}
			}
		});
			
		addSupplyJPanel.setLayout(grid);
		viewSupplyJPanel.setLayout(grid);
		editSupplyJPanel.setLayout(grid);
		addSupplyJPanel.add(supplierIdJLabel);
		addSupplyJPanel.add(supplierIdJTextField);
		addSupplyJPanel.add(supplierNameJLabel);
		addSupplyJPanel.add(supplierNameJTextField);
		addSupplyJPanel.add(supplierAddressJLabel);
		addSupplyJPanel.add(supplierAddressJTextField);
		addSupplyJPanel.add(supplierEmailJLabel);
		addSupplyJPanel.add(supplierEmailJTextField);
		addSupplyJPanel.add(supplierPhoneJLabel);
		addSupplyJPanel.add(supplierPhoneJTextField);
		addSupplyJPanel.add(supplierJButton);
		viewSupplyJPanel.add(viewSupplyJLabel);
		viewSupplyJPanel.add(viewSupplyJTextField);
		viewSupplyJPanel.add(viewSupplyNameJLabel);
		viewSupplyJPanel.add(viewSupplyNameJTextField);
		viewSupplyJPanel.add(viewSupplyJButton);
		viewSupplyJPanel.add(allSupplyJButton);
		viewSupplyJPanel.add(supplierJTextArea);
		supplierJTextArea.setLineWrap(true);
		editSupplyJPanel.add(editSupplierJTextField);
		editSupplyJPanel.add(editSupplierJButton);
		editSupplyJPanel.add(editSupplierId);
		editSupplyJPanel.add(editSupplierName);
		editSupplyJPanel.add(editSupplierAddress);
		editSupplyJPanel.add(editSupplierEmail);
		editSupplyJPanel.add(editSupplierPhone);
		editSupplyJPanel.add(editSupplierDelivery);
		editSupplyJPanel.add(saveSupplierJButton);
		editSupplyJPanel.add(deleteSupplierJButton);

		supplierJButton.addActionListener(new ActionListener(){
			// function to add a new supplier
			public void actionPerformed(ActionEvent e){
				Supplier supplier = new Supplier(Integer.parseInt(supplierIdJTextField.getText()), supplierNameJTextField.getText(), 
						supplierAddressJTextField.getText(), supplierEmailJTextField.getText(), supplierPhoneJTextField.getText());
				suppliers.add(supplier);
				JOptionPane.showMessageDialog(null, "New Supplier Added");
			}
		});
		
		viewSupplyJButton.addActionListener(new ActionListener(){
			// function to view a supplier by id or name
			public void actionPerformed(ActionEvent e){
				if(suppliers.size() >= 1){
					for(Supplier supplier: suppliers){
						if(supplier.getId() == Integer.parseInt(viewSupplyJTextField.getText()) || supplier.getName() == viewSupplyNameJTextField.getText()){
							supplierJTextArea.setText(" Supplier Id: "+supplier.getId()
									+"\n Supplier Name: "+supplier.getName()
									+"\n Supplier Address: "+supplier.getAddress()
									+"\n Supplier Email: "+supplier.getEmail()
									+"\n Supplier Phone: "+supplier.getPhone()
									+"\n Supplier Delivery Time: "+supplier.getDaysToDeliver());
						}else{
							JOptionPane.showMessageDialog(null, "Supplier Not Found.");
						}
					}
				}else{
					JOptionPane.showMessageDialog(null, "No Suppliers Found");
				}
			}
		});
		
		allSupplyJButton.addActionListener(new ActionListener(){
			// view all suppliers
			public void actionPerformed(ActionEvent e){
				if(suppliers.size() >= 1){
					for(Supplier supplier: suppliers){
						supplierJTextArea.setText(" Supplier Id: "+supplier.getId()
								+"\n Supplier Name: "+supplier.getName()
								+"\n Supplier Address: "+supplier.getAddress()
								+"\n Supplier Email: "+supplier.getEmail()
								+"\n Supplier Phone: "+supplier.getPhone()
								+"\n Supplier Delivery Time: "+supplier.getDaysToDeliver());
					}
				}else{
					JOptionPane.showMessageDialog(null, "No Suppliers Found");
				}
			}
		});
		
		editSupplierJButton.addActionListener(new ActionListener(){
			// retrieve and display supplier for editing
			public void actionPerformed(ActionEvent e){
				for(Supplier supplier: suppliers){
					if(supplier.getId() == Integer.parseInt(editSupplierJTextField.getText())){
						editSupplierId.setText(Integer.toString(supplier.getId()));
						editSupplierName.setText(supplier.getName());
						editSupplierAddress.setText(supplier.getAddress());
						editSupplierEmail.setText(supplier.getEmail());
						editSupplierPhone.setText(supplier.getPhone());
						editSupplierDelivery.setText(Integer.toString(supplier.getDaysToDeliver()));
					}else{
						JOptionPane.showMessageDialog(null, "Supplier Not Found");
					}
				}
			}
		});
		
		saveSupplierJButton.addActionListener(new ActionListener(){
			//function to update supplier
			public void actionPerformed(ActionEvent e){
				for(Supplier supplier: suppliers){
					if(supplier.getId() == Integer.parseInt(editSupplierJTextField.getText())){
						supplier.setId(Integer.parseInt(editSupplierId.getText()));
						supplier.setName(editSupplierName.getText());
						supplier.setAddress(editSupplierAddress.getText());
						supplier.setEmail(editSupplierEmail.getText());
						supplier.setPhone(editSupplierPhone.getText());
						supplier.setDaysToDeliver(Integer.parseInt(editSupplierDelivery.getText()));
					}else{
						JOptionPane.showMessageDialog(null, "Supplier Not Updated.");
					}
				}
			}
			
		});	
		
		deleteSupplierJButton.addActionListener(new ActionListener(){
			// function to delete supplier by getting id from the supplier id label
			public void actionPerformed(ActionEvent arg){
				for(Supplier supplier: suppliers){
					if(supplier.getId() == Integer.parseInt(editSupplierJTextField.getText())){
						suppliers.remove(supplier);
					}else{
						JOptionPane.showMessageDialog(null, "Supplier Not Deleted");
					}
				}
			}
		});
		
		//add edit invoice components	
				findInvoiceComponentsJPanel.setLayout(new GridLayout(2,2));
				findInvoiceComponentsJPanel.add(editInvoiceJTextField);
				editInvoiceJTextField.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					editInvoiceJTextField.setText("");
					}
				});
				findInvoiceComponentsJPanel.add(editInvoiceJButton);
				findInvoiceComponentsJPanel.add(editCustomerInvoiceJTextField);
				editCustomerInvoiceJTextField.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					editCustomerInvoiceJTextField.setText("");
					}
				});
				findInvoiceComponentsJPanel.add(editCustomerInvoiceJButton);
				editCustomerInvoiceComponentsJPanel.setLayout(new GridLayout(2,2));
				editCustomerInvoiceComponentsJPanel.add(new JLabel("Total owed on all invoices:"));
				editCustomerInvoiceComponentsJPanel.add(allInvoicesTotalJTextField);
				editCustomerInvoiceComponentsJPanel.add(customerInvoiceJTextArea);
				editCustomerInvoiceComponentsJPanel.add(payAllInvoicesJButton);
				payAllInvoicesJButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						for(Invoice invoice: invoices)
						{
							if(Integer.parseInt(editCustomerInvoiceJTextField.getText().trim()) == invoice.getCustomer().getCustId() ){
								invoice.setPaid(true);
							}
						}
						JOptionPane.showMessageDialog(null, "Paid!");
						editCustomerInvoiceJButton.doClick();		
						}
					});
				customerInvoiceJTextArea.setEditable(false);
				allInvoicesTotalJTextField.setEditable(false);
				editInvoiceComponentsJPanel.setLayout(new GridLayout(3,2));
				editInvoiceComponentsJPanel.add(new JLabel("Enter New Invoice ID"));
				editInvoiceComponentsJPanel.add(editInvoiceId);
				editInvoiceComponentsJPanel.add(new JLabel("Enter New Employee ID"));
				editInvoiceComponentsJPanel.add(editInvoiceEmployee);
				editInvoiceComponentsJPanel.add(new JLabel("Enter New Customer ID"));
				editInvoiceComponentsJPanel.add(editInvoiceCustomer);
				editInvoiceComponentsJPanel.add(new JLabel("Enter New Product ID"));
				editInvoiceComponentsJPanel.add(editInvoiceProduct);
				editInvoiceComponentsJPanel.add(new JLabel("Enter New Quantity"));
				editInvoiceComponentsJPanel.add(editInvoiceQuantity);
				editInvoiceComponentsJPanel.add(editPayStatus);
				editPayStatus.setEditable(false);
				editInvoiceComponentsJPanel.add(payInvoiceJButton);
				payInvoiceJButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						Invoice inv = new Invoice();
						inv.payInvoice(invoices, Integer.parseInt(editInvoiceJTextField.getText().trim()));
						JOptionPane.showMessageDialog(null, "Paid!");
						editInvoiceJButton.doClick();		
						}
					});
				saveInvoiceComponentsJPanel.setLayout(new GridLayout(1,2));
				saveInvoiceComponentsJPanel.add(saveInvoiceJButton);
				saveInvoiceComponentsJPanel.add(deleteInvoiceJButton);
				deleteInvoiceJButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						Invoice inv = new Invoice();
						int index = inv.deleteInvoice(invoices, Integer.parseInt(editInvoiceJTextField.getText().trim()));
						invoices.remove(index);
						JOptionPane.showMessageDialog(null, "Deleted!");
						editInvoiceJTextField.setText(Integer.toString(invoices.get(0).getId()));
						editInvoiceJButton.doClick();
						}
					});
				editInvJPanel.setLayout(new GridLayout(4,2));
				editInvJPanel.add(findInvoiceComponentsJPanel);
				editInvJPanel.add(editInvoiceComponentsJPanel);
				editInvJPanel.add(editCustomerInvoiceComponentsJPanel);
				editInvJPanel.add(saveInvoiceComponentsJPanel);
				editCustomerInvoiceComponentsJPanel.setVisible(false);
				editInvoiceComponentsJPanel.setVisible(false);
				saveInvoiceComponentsJPanel.setVisible(false);
				EditInvoiceButtonHandler eib = new EditInvoiceButtonHandler();
				editInvoiceJButton.addActionListener(eib);
				EditCustomerInvoiceButtonHandler ecib = new EditCustomerInvoiceButtonHandler();
				editCustomerInvoiceJButton.addActionListener(ecib);
				SaveButtonHandler sbh = new SaveButtonHandler();
				saveInvoiceJButton.addActionListener(sbh);
				
						
						
		/*remove comment marks to run login function

				//lock the tabs until login successful
				mainJTabbedPane.setEnabledAt(1, false);
				mainJTabbedPane.setEnabledAt(2, false);
				mainJTabbedPane.setEnabledAt(3, false);
				mainJTabbedPane.setEnabledAt(4, false);
				mainJTabbedPane.setEnabledAt(5, false);
				mainJTabbedPane.setEnabledAt(6, false);
				mainJTabbedPane.setEnabledAt(7, false);
				mainJTabbedPane.setEnabledAt(8, false);
						
		*/			
				
				//add login components
				loginComponentsJPanel.setLayout(new GridLayout(4,4));
				loginComponentsJPanel.add(new JLabel("Enter Employee ID"));
				loginComponentsJPanel.add(loginTF = new JTextField("Employee ID", 10));
				loginComponentsJPanel.add(new JLabel("Enter Employee Password"));
				loginComponentsJPanel.add(passwordTF = new JTextField("Password", 10));
				loginComponentsJPanel.add(loginBut= new JButton("Login"));
				loginJPanel.add(loginComponentsJPanel);
				//add listener for login button
				LoginButtonHandler handler = new LoginButtonHandler();
				loginBut.addActionListener(handler);
				//add listener for save button
						//focus listeners & handlers
						loginTF.addMouseListener(new MouseAdapter() {
							  @Override
							  public void mouseClicked(MouseEvent e) {
								  loginTF.setText("");
							  }
							});
						passwordTF.addMouseListener(new MouseAdapter() {
							  @Override
							  public void mouseClicked(MouseEvent e) {
								  passwordTF.setText("");
							  }
							});	
						
						JPanel logoutComponentsJPanel = new JPanel();
						logoutComponentsJPanel.setLayout(new GridLayout(4,4));
						logoutComponentsJPanel.add(new JLabel("Logout of application: "));
						logoutComponentsJPanel.add(logoutBut= new JButton("Logout"));
						logoutJPanel.add(logoutComponentsJPanel);
						logoutBut.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								// release all tabs - manager
								mainJTabbedPane.setSelectedIndex(0);
								mainJTabbedPane.setEnabledAt(1, false);
								mainJTabbedPane.setEnabledAt(2, false);
								mainJTabbedPane.setEnabledAt(3, false);
								mainJTabbedPane.setEnabledAt(4, false);
								mainJTabbedPane.setEnabledAt(5, false);
								mainJTabbedPane.setEnabledAt(6, false);
								mainJTabbedPane.setEnabledAt(7, false);
								mainJTabbedPane.setEnabledAt(8, false);
								mainJTabbedPane.setEnabledAt(0, true);;
							}
						});
					
						
					}
					//handler for login button
					private class LoginButtonHandler implements ActionListener
					{
					public void actionPerformed( ActionEvent e)
						{//handler starts
						Employee emp = new Employee();
						int id = 0;
						int password = 0;
						try {
							id = Integer.parseInt( loginTF.getText().trim() );
						}
						catch (NumberFormatException nfe){
							loginTF.setText("");
						}
						try{
							password = Integer.parseInt( passwordTF.getText().trim() );
						}
						catch(NumberFormatException nfe){
							passwordTF.setText("");
						}
						int login = emp.verifyLogin(employees, id, password);
						if(login == 1){
							// release all tabs - manager
							mainJTabbedPane.setSelectedIndex(1);
							mainJTabbedPane.setEnabledAt(1, true);
							mainJTabbedPane.setEnabledAt(2, true);
							mainJTabbedPane.setEnabledAt(3, true);
							mainJTabbedPane.setEnabledAt(4, true);
							mainJTabbedPane.setEnabledAt(5, true);
							mainJTabbedPane.setEnabledAt(6, true);
							mainJTabbedPane.setEnabledAt(7, true);
							mainJTabbedPane.setEnabledAt(8, true);
							mainJTabbedPane.setEnabledAt(0, false);
						}
						else if(login == 2){
							// release some tabs - staff SPRINT 2
							
						}
						else if(login == 3){
							//password incorrect
							JOptionPane.showMessageDialog(loginJPanel, "Password doesn't match that Employee ID", "For your information", JOptionPane.INFORMATION_MESSAGE);
						}
						else if(login == 4){
							//no employee id match
							JOptionPane.showMessageDialog(loginJPanel, "Employee ID not found", "For your information", JOptionPane.INFORMATION_MESSAGE);
						}		
						}
					}
					
					//Handler for edit invoice by id button
					private class EditInvoiceButtonHandler implements ActionListener
					{
					public void actionPerformed( ActionEvent e)
						{//handler starts
							ArrayList<String> fields = new ArrayList<String>();
							Invoice inv = new Invoice();
							int id = 0;
							try {
								id = Integer.parseInt( editInvoiceJTextField.getText().trim() );
							}
							catch (NumberFormatException nfe){
								editInvoiceJTextField.setText("");
							}
							int invoiceID = inv.verifyInvoiceID(invoices, id);
							if(invoiceID == 1){
								editInvoiceComponentsJPanel.setVisible(true);
								saveInvoiceComponentsJPanel.setVisible(true);
								fields = inv.returnFields(invoices, id);
								editInvoiceId.setText(fields.get(0));
								editInvoiceEmployee.setText(fields.get(1));
								editInvoiceCustomer.setText(fields.get(2));
								editInvoiceProduct.setText(fields.get(3));
								editInvoiceQuantity.setText(fields.get(4));
								editPayStatus.setText(fields.get(5));
								if(fields.get(5).equals("Unpaid")){
									editPayStatus.setForeground(Color.RED);
								}
							}
							else if(invoiceID == 2){
								//no employee id match
								JOptionPane.showMessageDialog(loginJPanel, "Invoice ID not found", "For your information", JOptionPane.INFORMATION_MESSAGE);
							}

						}	
					}
					
					//Handler for pay invoices by customer button
					private class EditCustomerInvoiceButtonHandler implements ActionListener
					{
					public void actionPerformed( ActionEvent e)
						{//handler starts
							Invoice inv = new Invoice();
							int count = 0;
							String s = "";
							double total = 0;
							String totalString = "";
							int id = 0;
							try {
								id = Integer.parseInt( editCustomerInvoiceJTextField.getText().trim() );
							}
							catch (NumberFormatException nfe){
								editCustomerInvoiceJTextField.setText("");
							}
							int customerID = inv.verifyInvoiceByCustomerID(customers, id);
							if(customerID == 1){
								editCustomerInvoiceComponentsJPanel.setVisible(true);
								for(Invoice invoice: invoices){
									if(id == invoice.getCustomer().getCustId() ){
										if(invoice.isPaid() == false){
											s = "\nProduct Id : " + invoice.getProduct().getProductCode() + "\nQuantity: " + invoice.getQuantity() + "\nTotal: " + invoice.getTotalInvoicePrice();
											customerInvoiceJTextArea.append(s);
											total = total + invoice.getTotalInvoicePrice();
											count++;								
										}
									}
								}
								if(count == 0){
									JOptionPane.showMessageDialog(loginJPanel, "No unpaid invoices for this customer", "For your information", JOptionPane.INFORMATION_MESSAGE);
								}
								else{
									totalString = Double.toString(total);
									allInvoicesTotalJTextField.setText(totalString);
								}						
							}
							else if(customerID == 2){
								//no employee id match
								JOptionPane.showMessageDialog(loginJPanel, "Customer ID not found", "For your information", JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}
					
					//handler for save button
					private class SaveButtonHandler implements ActionListener
					{
					public void actionPerformed( ActionEvent e)
						{
						Invoice inv = new Invoice();
							ArrayList<String> fields = new ArrayList<String>();
							fields.add(new String (editInvoiceId.getText().trim()));
							fields.add(new String (editInvoiceEmployee.getText().trim()));
							fields.add(new String (editInvoiceCustomer.getText().trim()));
							fields.add(new String (editInvoiceProduct.getText().trim()));
							fields.add(new String (editInvoiceQuantity.getText().trim()));
							fields.add(new String (editInvoiceJTextField.getText().trim()));
							inv.updateInvoice(invoices, employees, products, customers, fields);
							editInvoiceJTextField.setText(fields.get(0));
							JOptionPane.showMessageDialog(null, "Updated!");
							editInvoiceJButton.doClick();
							
						}
					}

}
