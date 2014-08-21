package retail;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class RetailGUI extends JFrame{
	
	private ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	private ArrayList<Invoice> invoices = new ArrayList<Invoice>();
	private ArrayList<Order> orders = new ArrayList<Order>();
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<Product> products = new ArrayList<Product>();
	private ArrayList<Employee> employees  = new ArrayList<Employee>();

	public ArrayList<Order> getOrders(){
		return this.orders;
	}
	
	public void addOrders(Order order){
		orders.add(order);
	}
	
	private JFrame mainJFrame = new JFrame();
	private GridLayout grid = new GridLayout(0, 1, 0, 10);
	private JTabbedPane mainJTabbedPane = new JTabbedPane();
	JScrollPane scrollPane = new JScrollPane();
	
	private JPanel loginJPanel = new JPanel();
	private JTabbedPane custJTabbedPane = new JTabbedPane();
	private JTabbedPane supplyJTabbedPane = new JTabbedPane();
	private JTabbedPane prodJTabbedPane = new JTabbedPane();
	private JTabbedPane invJTabbedPane = new JTabbedPane();
	private JTabbedPane orderJTabbedPane = new JTabbedPane();
	private JTabbedPane accessJTabbedPane = new JTabbedPane();
	private JTabbedPane proflossJTabbedPane = new JTabbedPane();
	
	private JPanel custJPanel = new JPanel();
	private JPanel addCustJPanel = new JPanel();
	private JPanel viewCustJPanel = new JPanel();
	private JPanel custTextJPanel = new JPanel();
	private JPanel editCustJPanel = new JPanel();
	
	private JPanel suppJPanel = new JPanel();
	private JPanel addSupplyJPanel = new JPanel();
	private JPanel viewSupplyJPanel = new JPanel();
	private JPanel suppTextJPanel = new JPanel();
	private JPanel editSupplyJPanel = new JPanel();
	
	private JPanel addProductJPanel = new JPanel();
	//private JPanel viewProductJPanel = new ViewProductDetailsPanel();
	private JPanel viewProductDetailsJPanel = new JPanel();
	private JPanel editProductJPanel = new JPanel();
	private JPanel searchByRetailJPanel = new JPanel();
	private JPanel viewProductByQuantityJPanel = new JPanel();
	private JPanel AddRemoveStockJPanel = new JPanel();
	
	//private JPanel createInvJPanel = new CreateANewInvoicePanel();
	private JPanel createInvJPanel = new JPanel();
	private JPanel viewInvJPanel = new JPanel();	//ViewCustomerInvoicePanel();
	private JPanel editInvJPanel = new JPanel();
	
	private JPanel createOrderPanel = new JPanel();
	//private JPanel viewOrderJPanel = new ViewOrderPanel();
	
	private JPanel accessJPanel = new JPanel();
	
	private JPanel proflossJPanel = new JPanel();
	
	
	//login components
	private JPanel loginComponentsJPanel = new JPanel();
	private JTextField loginTF = new JTextField();
	private JTextField passwordTF = new JTextField();
	private JButton loginBut = new JButton();
	
	//logout components
	private JPanel logoutComponentsJPanel = new JPanel();
	private JPanel logoutJPanel = new JPanel();
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
	private JTextArea custJTextArea = new JTextArea(10, 65);
	private JLabel editFindCustIdJLabel = new JLabel("Enter Customer Number");
	private JTextField editCustById = new JTextField();
	private JButton findCustById = new JButton("Find Customer");
	private JLabel editCustIdJLabel = new JLabel("Customer ID");
	private JLabel editCustNameJLabel = new JLabel("Customer Name");
	private JLabel editCustAddressJLabel = new JLabel("Customer Address");
	private JLabel editCustEmailJLabel = new JLabel("Customer Email");
	private JLabel editCustPhoneJLabel = new JLabel("Customer Telephone");
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
	private JTextArea supplierJTextArea = new JTextArea(10, 65);
	private JButton viewSupplyJButton = new JButton("View Supplier Details");
	private JButton allSupplyJButton = new JButton("View All Suppliers");
	private JLabel editFindSuppIdJLabel = new JLabel("Enter Supplier Number");
	private JTextField editSupplierJTextField = new JTextField();
	private JButton editSupplierJButton = new JButton("Find Supplier");
	private JLabel editSuppIdJLabel = new JLabel("Supplier ID");
	private JLabel editSuppNameJLabel = new JLabel("Supplier Name");
	private JLabel editSuppAddressJLabel = new JLabel("Supplier Address");
	private JLabel editSuppEmailJLabel = new JLabel("Supplier Email");
	private JLabel editSuppPhoneJLabel = new JLabel("Supplier Telephone");
	private JLabel editDeliveryJLabel = new JLabel("Edit Delivery Period");
	private JTextField editSupplierId = new JTextField();
	private JTextField editSupplierName = new JTextField();
	private JTextField editSupplierAddress = new JTextField();
	private JTextField editSupplierEmail = new JTextField();
	private JTextField editSupplierPhone = new JTextField();
	private JTextField editSupplierDelivery = new JTextField();
	private JButton saveSupplierJButton = new JButton("Update Supplier");
	private JButton deleteSupplierJButton = new JButton("Delete Supplier");
	
	//Product Components
	private JLabel prodTitle = new JLabel("Book Title");
	private JTextField titleJTextField = new JTextField();
	private JLabel prodAuthor = new JLabel("Author");
	private JTextField authorJTextField = new JTextField();
	private JLabel prodCode = new JLabel("Book Code");
	private JTextField codeJTextField = new JTextField();
	private JLabel prodRetail = new JLabel("Retail Price");
	private JTextField retailJTextField = new JTextField();
	private JLabel prodCost = new JLabel("Cost Price");
	private JTextField costJTextField = new JTextField();
	private JLabel prodTotalStock = new JLabel("Total Stock");
	private JTextField tStockJTextField = new JTextField();
	private JLabel prodMaxStock = new JLabel("Maximum Stock");
	private JTextField maxJTextField = new JTextField();
	private JLabel prodMinStock = new JLabel("Minimum Stock");
	private JTextField minJTextField = new JTextField();
	private JLabel prodSupplierId = new JLabel("Supplier Id");
	private JTextField prodSupplierIdJTextField = new JTextField();
	private JButton productJButton = new JButton("Create New Product");
	
	private JRadioButton under5Radio = new JRadioButton("under 4.99");
	private JRadioButton fiveTo10Radio = new JRadioButton("5 - 9.99");
	private JRadioButton tenTo20Radio = new JRadioButton("10 - 20");
	private JRadioButton over20Radio = new JRadioButton("20 plus");
	private JLabel searchByRetail = new JLabel("Search by retail price range");
	private JButton searchByRetailButton = new JButton("Search");
	private JButton searchByQuantityButton = new JButton("Search");
	private JTextArea priceTextArea = new JTextArea(20, 60);
	private JTextArea quantityTextArea = new JTextArea(20,60);
	private JLabel searchByQuantity = new JLabel("Search by stock quantity");
	private JRadioButton under50Radio = new JRadioButton("under 50");
	private JRadioButton fiftyTo100Radio = new JRadioButton("50 - 100");
	private JRadioButton hundredTo200Radio = new JRadioButton("100 - 200");
	private JRadioButton over200Radio = new JRadioButton("200 plus");
	
	
	// View Product Components
	private Product product = new Product();
	private JTextArea productTextArea;
	private JTextField productIdTextField;
	private JTextField productTitleTextField;
	private JTextField productAuthorTextField;
	private JTextField viewProductIdTextField;
	//private JTextField invTextField;
	private JPanel viewProductDetailsPanel= new JPanel();
	private JPanel viewProductDetails= new JPanel();
	private int buttonWidth = 155;
	private int buttonHeight = 20;
	
	
	
	//Edit Invoice Components 
	private JPanel findInvoiceComponentsJPanel = new JPanel();
	private JPanel editInvoiceComponentsJPanel = new JPanel();
	private JPanel editCustomerInvoiceComponentsJPanel = new JPanel();
	private JPanel saveInvoiceComponentsJPanel = new JPanel();
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
	private JButton payInvoiceJButton = new JButton("Pay Invoice");
	private JButton saveInvoiceJButton = new JButton("Update Invoice");
	private JButton deleteInvoiceJButton = new JButton("Delete Invoice");
	private JTextField editPayStatus = new JTextField("");	
	private JTextField editInvoiceAmount = new JTextField("Edit Invoice Amount");

		
	//===========================================
	//View Customer Invoice Panel and Components
		
	//Panel
	private JPanel viewCustomerPanel = new JPanel();
	
	//Components
	private JTextArea textarea;
	private JTextField invTextField2;
	private JTextField custIdTextField;
	private Invoice invoice = new Invoice();
	//==========================================
	
	//=========================================
			//Marc: Create a new Invoice Panel
				
				//Panel
				private JPanel createNewInvoicePanel = new JPanel();
				
			//Components
				//variables
				//private Invoice invoice = new Invoice();
				private ArrayList<InvoiceProduct> addMoreArrayList = new ArrayList<InvoiceProduct>();
				private String message = "";
				private String outputMessage="";
				//Panels
				private JTextArea textAreaMarc = new JTextArea();
				private JPanel leftPanel = new JPanel();
				private JPanel rightPanel = new JPanel();
				
				//Labels for left panel
				private JLabel invIdLbl = new JLabel("Invoice Id: ");
				private JLabel employLbl = new JLabel("Employee ID: ");
				private JLabel custId = new JLabel("Customer ID: ");
				private JLabel prodId = new JLabel("Product ID: ");
				private JLabel quantitylbl = new JLabel("Quantity: ");
				
				//JText Fields for left panel
				private JTextField invTextF = new JTextField(10);
				private JTextField employTextF = new JTextField(10);
				private JTextField custTextF = new JTextField(10);
				private JTextField prodTextF = new JTextField(10);
				private JTextField quantityTextF = new JTextField(10);
				
				//4 Buttons for left Panel
				/*private JButton singleBtn = new JButton("Single Invoice");
				private JButton multiBtn = new JButton("Multipe Invoice");*/
				private JButton addMoreBtn = new JButton("Add More");
				private JButton finishBtn = new JButton("Finished");
				private JButton resetBtn = new JButton("Reset");
			//End Of Marc: Create a new Invoice Panel
			//=========================================
	
	
	//==================================
	//createNewOrder Panel components
	Order baseOrder;
	//Panels
	private JPanel createNewOrderLeftPanel = new JPanel();
	private JPanel createNewOrderRightPanel = new JPanel();
	//Labels
	private JLabel orderIdLabel = new JLabel("Order ID: ");
	private JLabel supplierIdLabel = new JLabel("Supplier ID: ");
	private JLabel productCodeLabel = new JLabel("Product ID: ");
	private JLabel quantityLabel = new JLabel("Quantity: ");
	//JTextFields
	private JTextField orderIdTextField = new JTextField(10);
	private JTextField supplierIdTextField = new JTextField(10);
	private JTextField productCodeTextField = new JTextField(10);
	private JTextField quantityTextField = new JTextField(10);
	//JButtons
	private JButton addProductButton =  new JButton("Add Product to Order");
	private JButton confirmOrderButton = new JButton("Confirm Order");
	//JTextArea
	private JTextArea textArea = new JTextArea();
	//=========================================================================
	
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
		products.add(new Product("Game of Thrones", "George R.R Martin", "1", 9.99, 3.75,100,200,15, suppliers.get(0)));
		products.add(new Product("Not a Drill", "Lee Child", "2", 12.75, 4.95,221,200,10, suppliers.get(1)));
		products.add(new Product("Harry Potter", "j.k rowling", "3", 11.99, 2.95,9,100,10,suppliers.get(0)));
		//add some test invoices to array list
		invoices.add(new Invoice(1, employees.get(0), customers.get(0), products.get(0), 10));
		invoices.add(new Invoice(2, employees.get(1), customers.get(1), products.get(1), 20));
		
		
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
		
		logoutComponentsJPanel.setLayout(new GridLayout(4,4));
		logoutComponentsJPanel.add(new JLabel("Logout of application: "));
		logoutComponentsJPanel.add(logoutBut= new JButton("Logout"));
		logoutJPanel.add(logoutComponentsJPanel);
		logoutBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				// release all tabs - manager
				loginTF.setText("");
				passwordTF.setText("");
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
		mainJTabbedPane.add("Order Management", orderJTabbedPane);
		mainJTabbedPane.add("Manage Employee Access", accessJTabbedPane);
		mainJTabbedPane.add("Profit and Loss", proflossJTabbedPane);
		mainJTabbedPane.add("Logout", logoutJPanel);
		
		custJTabbedPane.add("Create New Customer",addCustJPanel);
		custJTabbedPane.add("View Customer Details", custJPanel);
		custJPanel.setLayout(grid);
		custJPanel.add(viewCustJPanel);
		custJPanel.add(custTextJPanel);
		custJTabbedPane.add("Edit Customer Details", editCustJPanel);
		
		supplyJTabbedPane.add("Create New Supplier",addSupplyJPanel);
		supplyJTabbedPane.add("View Supplier Details", suppJPanel);
		suppJPanel.setLayout(grid);
		suppJPanel.add(viewSupplyJPanel);
		suppJPanel.add(suppTextJPanel);
		supplyJTabbedPane.add("Edit Supplier Details", editSupplyJPanel);
		
		prodJTabbedPane.add("Create New Product",addProductJPanel);
		prodJTabbedPane.add("View Product Details", viewProductDetailsPanel);
		prodJTabbedPane.add("Edit Product Details", editProductJPanel);
		prodJTabbedPane.add("Search by retail price", searchByRetailJPanel);
		prodJTabbedPane.add("Search by quantity", viewProductByQuantityJPanel);
		prodJTabbedPane.add("Add/remove stock", AddRemoveStockJPanel);
		
		
		invJTabbedPane.add("Create New Invoice", createInvJPanel);
		invJTabbedPane.add("View Customer Invoice", viewInvJPanel);
		invJTabbedPane.add("Edit Customer Invoice", editInvJPanel);
		
		orderJTabbedPane.add("Create New Order", createOrderPanel);
		//orderJTabbedPane.add("View Orders", viewOrderJPanel);
		
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
		JScrollPane custScrollPane = new JScrollPane(custJTextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		custTextJPanel.add(custScrollPane);
		custJTextArea.setLineWrap(true);
		editCustJPanel.add(editFindCustIdJLabel);
		editCustJPanel.add(editCustById);
		editCustJPanel.add(findCustById);
		editCustJPanel.add(editCustIdJLabel);
		editCustJPanel.add(editCustId);
		editCustJPanel.add(editCustNameJLabel);
		editCustJPanel.add(editCustName);
		editCustJPanel.add(editCustAddressJLabel);
		editCustJPanel.add(editCustAddress);
		editCustJPanel.add(editCustEmailJLabel);
		editCustJPanel.add(editCustEmail);
		editCustJPanel.add(editCustPhoneJLabel);
		editCustJPanel.add(editCustPhone);
		editCustJPanel.add(updateCustJButton);
		editCustJPanel.add(deleteCustJButton);
		
		
		custJButton.addActionListener(new ActionListener(){
			// function to add a new customer
			public void actionPerformed(ActionEvent e){
				try{
					Customer customer = new Customer(Integer.parseInt(custIdJTextField.getText()),
						custNameJTextField.getText(),custAddressJTextField.getText(), custEmailJTextField.getText(),
						custPhoneJTextField.getText());
					customers.add(customer);
					JOptionPane.showMessageDialog(null, "New Customer Added");			
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Customer Id should be a number.");
				}
			}	
		});
		
		viewCustJButton.addActionListener(new ActionListener(){
			// function to view a customer by id or name
			public void actionPerformed(ActionEvent e){
			if(customers.size() >= 1){
					try{
						for(Customer customer: customers){
						if(customer.getCustId() == Integer.parseInt(custById.getText()) || customer.getCustName() == custByName.getText()){
							custJTextArea.setText(" Customer Id: "+customer.getCustId()
									+"\n Customer Name: "+customer.getCustName()
									+"\n Customer Address: "+customer.getCustAddress()
									+"\n Customer Email: "+customer.getCustEmail()
									+"\n Customer Phone: "+customer.getCustTelephone());
							}
						}
					}catch(NumberFormatException nfe){
						JOptionPane.showMessageDialog(null, "Customer Id should be a number.");
					}
				}else{
					JOptionPane.showMessageDialog(null, "No Customers Found");
				}
			}
		});
		
		viewAllCustJButton.addActionListener(new ActionListener(){
			// function to view all customers
			public void actionPerformed(ActionEvent e){
				custJTextArea.setText(null);
				try{
					if(customers.size() >= 1){
						for(Customer customer: customers){
							
							custJTextArea.append(" Customer Id: "+customer.getCustId()
										+"\n Customer Name: "+customer.getCustName()
										+"\n Customer Address: "+customer.getCustAddress()
										+"\n Customer Email: "+customer.getCustEmail()
										+"\n Customer Phone: "+customer.getCustTelephone()
										+"\n");
						}
					}else{
						JOptionPane.showMessageDialog(null, "No Customers Found");
					}
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Customer Id should be a number.");
				}
			}
		});
		
		findCustById.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					for(Customer customer: customers){
						if(customer.getCustId() == Integer.parseInt(editCustById.getText())){
							editCustId.setText(Integer.toString(customer.getCustId()));
							editCustName.setText(customer.getCustName());
							editCustAddress.setText(customer.getCustAddress());
							editCustEmail.setText(customer.getCustEmail());
							editCustPhone.setText(customer.getCustTelephone());
						}
					}
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Customer Id should be a number.");
				}
			}
		});
		
		updateCustJButton.addActionListener(new ActionListener(){
			//update a specific customer
			public void actionPerformed(ActionEvent e){
				try{
					for(Customer customer: customers){
						if(customer.getCustId() == Integer.parseInt(editCustById.getText())){
							customer.setCustId(Integer.parseInt(editCustId.getText()));
							customer.setCustName(editCustName.getText());
							customer.setCustAddress(editCustAddress.getText());
							customer.setCustEmail(editCustEmail.getText());
							customer.setCustTelephone(editCustPhone.getText());
						}
					}
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Customer Id should be a number.");
				}
			}
		});
		
		deleteCustJButton.addActionListener(new ActionListener(){
			//delete function for customer
			public void actionPerformed(ActionEvent arg){
				try{
					for(Customer customer: customers){
						if(customer.getCustId() == Integer.parseInt(editCustById.getText())){
							customers.remove(customer);
						}
					}
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Customer Id should be a number.");
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
		JScrollPane suppJScrollPane = new JScrollPane(supplierJTextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		suppTextJPanel.add(suppJScrollPane);
		supplierJTextArea.setLineWrap(true);
		editSupplyJPanel.add(editFindSuppIdJLabel);
		editSupplyJPanel.add(editSupplierJTextField);
		editSupplyJPanel.add(editSupplierJButton);
		editSupplyJPanel.add(editSuppIdJLabel);
		editSupplyJPanel.add(editSupplierId);
		editSupplyJPanel.add(editSuppNameJLabel);
		editSupplyJPanel.add(editSupplierName);
		editSupplyJPanel.add(editSuppAddressJLabel);
		editSupplyJPanel.add(editSupplierAddress);
		editSupplyJPanel.add(editSuppEmailJLabel);
		editSupplyJPanel.add(editSupplierEmail);
		editSupplyJPanel.add(editSuppPhoneJLabel);
		editSupplyJPanel.add(editSupplierPhone);
		editSupplyJPanel.add(editDeliveryJLabel);
		editSupplyJPanel.add(editSupplierDelivery);
		editSupplyJPanel.add(saveSupplierJButton);
		editSupplyJPanel.add(deleteSupplierJButton);

		supplierJButton.addActionListener(new ActionListener(){
			// function to add a new supplier
			public void actionPerformed(ActionEvent e){
				try{	
					Supplier supplier = new Supplier(Integer.parseInt(supplierIdJTextField.getText()), supplierNameJTextField.getText(), 
							supplierAddressJTextField.getText(), supplierEmailJTextField.getText(), supplierPhoneJTextField.getText());
					suppliers.add(supplier);
					JOptionPane.showMessageDialog(null, "New Supplier Added");
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Id should be a number.");
				}
			}
		});
		
		viewSupplyJButton.addActionListener(new ActionListener(){
			// function to view a supplier by id or name
			public void actionPerformed(ActionEvent e){
				try{
					if(suppliers.size() >= 1){
						for(Supplier supplier: suppliers){
							if(supplier.getId() == Integer.parseInt(viewSupplyJTextField.getText()) || supplier.getName() == viewSupplyNameJTextField.getText()){
								supplierJTextArea.setText(" Supplier Id: "+supplier.getId()
										+"\n Supplier Name: "+supplier.getName()
										+"\n Supplier Address: "+supplier.getAddress()
										+"\n Supplier Email: "+supplier.getEmail()
										+"\n Supplier Phone: "+supplier.getPhone()
										+"\n Supplier Delivery Time: "+supplier.getDaysToDeliver());
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, "No Suppliers Found");
					}
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Id should be a number.");
				}
			}
		});
		
		allSupplyJButton.addActionListener(new ActionListener(){
			// view all suppliers
			public void actionPerformed(ActionEvent e){
				supplierJTextArea.setText(null);
				try{
					if(suppliers.size() >= 1){
						for(Supplier supplier: suppliers){
							supplierJTextArea.append(" Supplier Id: "+supplier.getId()
									+"\n Supplier Name: "+supplier.getName()
									+"\n Supplier Address: "+supplier.getAddress()
									+"\n Supplier Email: "+supplier.getEmail()
									+"\n Supplier Phone: "+supplier.getPhone()
									+"\n Supplier Delivery Time: "+supplier.getDaysToDeliver());
						}
					}else{
						JOptionPane.showMessageDialog(null, "No Suppliers Found");
					}
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Id should be a number.");
				}
			}
		});
		
		editSupplierJButton.addActionListener(new ActionListener(){
			// retrieve and display supplier for editing
			public void actionPerformed(ActionEvent e){
				try{
					for(Supplier supplier: suppliers){
						if(supplier.getId() == Integer.parseInt(editSupplierJTextField.getText())){
							editSupplierId.setText(Integer.toString(supplier.getId()));
							editSupplierName.setText(supplier.getName());
							editSupplierAddress.setText(supplier.getAddress());
							editSupplierEmail.setText(supplier.getEmail());
							editSupplierPhone.setText(supplier.getPhone());
							editSupplierDelivery.setText(Integer.toString(supplier.getDaysToDeliver()));
						}
					}
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Id should be a number.");
				}
			}
		});
		
		saveSupplierJButton.addActionListener(new ActionListener(){
			//function to update supplier
			public void actionPerformed(ActionEvent e){
				try{
					for(Supplier supplier: suppliers){
						if(supplier.getId() == Integer.parseInt(editSupplierJTextField.getText())){
							supplier.setId(Integer.parseInt(editSupplierId.getText()));
							supplier.setName(editSupplierName.getText());
							supplier.setAddress(editSupplierAddress.getText());
							supplier.setEmail(editSupplierEmail.getText());
							supplier.setPhone(editSupplierPhone.getText());
							supplier.setDaysToDeliver(Integer.parseInt(editSupplierDelivery.getText()));
						}
					}
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Id should be a number.");
				}
			}
			
		});	
		
		deleteSupplierJButton.addActionListener(new ActionListener(){
			// function to delete supplier by getting id from the supplier id label
			public void actionPerformed(ActionEvent arg){
				try{
					for(Supplier supplier: suppliers){
						if(supplier.getId() == Integer.parseInt(editSupplierJTextField.getText())){
							suppliers.remove(supplier);
						}
					}
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Id should be a number.");
				}
			}
		});
		
		/*
		 * Start of Product Creation 
		 */
		addProductJPanel.setLayout(grid);
		addProductJPanel.add(prodTitle);
		addProductJPanel.add(titleJTextField);
		addProductJPanel.add(prodAuthor);
		addProductJPanel.add(authorJTextField);
		addProductJPanel.add(prodCode);
		addProductJPanel.add(codeJTextField);
		addProductJPanel.add(prodRetail);
		addProductJPanel.add(retailJTextField);
		addProductJPanel.add(prodCost);
		addProductJPanel.add(costJTextField);
		addProductJPanel.add(prodTotalStock);
		addProductJPanel.add(tStockJTextField);
		addProductJPanel.add(prodMaxStock);
		addProductJPanel.add(maxJTextField);
		addProductJPanel.add(prodMinStock);
		addProductJPanel.add(minJTextField);
		addProductJPanel.add(prodSupplierId);
		addProductJPanel.add(prodSupplierIdJTextField);
		addProductJPanel.add(productJButton);
		
		searchByRetailJPanel.add(searchByRetail);
		searchByRetailJPanel.add(under5Radio);
		searchByRetailJPanel.add(fiveTo10Radio);
		searchByRetailJPanel.add(tenTo20Radio);
		searchByRetailJPanel.add(over20Radio);
		searchByRetailJPanel.add(searchByRetailButton);
		searchByRetailJPanel.add(priceTextArea);
		
		ButtonGroup priceRange = new ButtonGroup();
		priceRange.add(under5Radio);
		priceRange.add(fiveTo10Radio);
		priceRange.add(tenTo20Radio);
		priceRange.add(over20Radio);
		
		
		viewProductByQuantityJPanel.add(searchByQuantity);
		viewProductByQuantityJPanel.add(under50Radio);
		viewProductByQuantityJPanel.add(fiftyTo100Radio);
		viewProductByQuantityJPanel.add(hundredTo200Radio);
		viewProductByQuantityJPanel.add(over200Radio);
		viewProductByQuantityJPanel.add(searchByQuantityButton);
		viewProductByQuantityJPanel.add(quantityTextArea);
		
		
		ButtonGroup quantity = new ButtonGroup();
		quantity.add(under50Radio);
		quantity.add(fiftyTo100Radio);
		quantity.add(hundredTo200Radio);
		quantity.add(over200Radio);
		
		productJButton.addActionListener(new ActionListener(){
			//function to create a product
			public void actionPerformed(ActionEvent e){
				try{
					if(suppliers.size() >= 1){
						for(Supplier supplier: suppliers){
							if(supplier.getId() ==Integer.parseInt(prodSupplierIdJTextField.getText())){
								Product product = new Product(titleJTextField.getText(),authorJTextField.getText().toLowerCase(),
										codeJTextField.getText(),Double.parseDouble(retailJTextField.getText()),
										Double.parseDouble(costJTextField.getText()), Integer.parseInt(tStockJTextField.getText()),
										Integer.parseInt(maxJTextField.getText()), Integer.parseInt(minJTextField.getText()),supplier
										);
								products.add(product);
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, "Suppliers List is Empty");
					}
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Id should be a number.");
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
		JScrollPane customerInvoiceJScrollPane = new JScrollPane(customerInvoiceJTextArea);
		customerInvoiceJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		editCustomerInvoiceComponentsJPanel.add(customerInvoiceJScrollPane);
		editCustomerInvoiceComponentsJPanel.add(payAllInvoicesJButton);
		payAllInvoicesJButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for(Invoice invoice: invoices){
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
		editInvoiceComponentsJPanel.setLayout(new GridLayout(5,2));
		editInvoiceComponentsJPanel.add(new JLabel("Enter New Invoice ID"));
		editInvoiceComponentsJPanel.add(editInvoiceId);
		editInvoiceComponentsJPanel.add(new JLabel("Enter New Employee ID"));
		editInvoiceComponentsJPanel.add(editInvoiceEmployee);
		editInvoiceComponentsJPanel.add(new JLabel("Enter New Customer ID"));
		editInvoiceComponentsJPanel.add(editInvoiceCustomer);
		//editInvoiceComponentsJPanel.add(new JLabel("Enter New Product ID"));
		//editInvoiceComponentsJPanel.add(editInvoiceProduct);
		//editInvoiceComponentsJPanel.add(new JLabel("Enter New Quantity"));
		//editInvoiceComponentsJPanel.add(editInvoiceQuantity);
		editInvoiceComponentsJPanel.add(new JLabel("Total"));
		editInvoiceComponentsJPanel.add(editInvoiceAmount);
		editInvoiceComponentsJPanel.add(editPayStatus);
		editPayStatus.setEditable(false);
		editInvoiceComponentsJPanel.add(payInvoiceJButton);
		payInvoiceJButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for(Invoice invoice: invoices){
					if(invoice.getId() == Integer.parseInt(editInvoiceJTextField.getText().trim())){
						invoice.setPaid(true);
					}
				}
				JOptionPane.showMessageDialog(null, "Paid!");
				editPayStatus.setForeground(Color.BLACK);
				editInvoiceJButton.doClick();		
			}
		});
		saveInvoiceComponentsJPanel.setLayout(new GridLayout(1,2));
		saveInvoiceComponentsJPanel.add(saveInvoiceJButton);
		saveInvoiceComponentsJPanel.add(deleteInvoiceJButton);
		deleteInvoiceJButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int index=0;
				for(Invoice invoice: invoices){
					if(invoice.getId() == Integer.parseInt(editInvoiceJTextField.getText().trim())){
						index = invoices.indexOf(invoice);
					}
				}
				invoices.remove(index);
				JOptionPane.showMessageDialog(null, "Deleted!");
				editCustomerInvoiceComponentsJPanel.setVisible(false);
				editInvoiceComponentsJPanel.setVisible(false);
				saveInvoiceComponentsJPanel.setVisible(false);
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
		
		//====================================================================================
		//set up order panels
		Dimension size = getPreferredSize();
		size.width = 500;
		setPreferredSize(size);
		createOrderPanel.setBorder(BorderFactory.createTitledBorder("Order details"));
		//Left Panel Components
		createNewOrderLeftPanel.setLayout(new GridBagLayout());
		GridBagConstraints orderGC = new GridBagConstraints();
		orderGC.insets = new Insets(5,5,5,5);
		//=====
		orderGC.gridx = 0;
		orderGC.gridy = 0;
		createNewOrderLeftPanel.add(orderIdLabel,orderGC);
		orderGC.gridx = 1;
		orderGC.gridy = 0;
		createNewOrderLeftPanel.add(orderIdTextField,orderGC);
		//=====
		orderGC.gridx = 0;
		orderGC.gridy = 1;
		createNewOrderLeftPanel.add(supplierIdLabel,orderGC);
		orderGC.gridx = 1;
		orderGC.gridy = 1;
		createNewOrderLeftPanel.add(supplierIdTextField,orderGC);
		//=====
		orderGC.gridx = 0;
		orderGC.gridy = 2;
		createNewOrderLeftPanel.add(productCodeLabel,orderGC);
		orderGC.gridx = 1;
		orderGC.gridy = 2;
		createNewOrderLeftPanel.add(productCodeTextField,orderGC);
		//=====
		orderGC.gridx = 0;
		orderGC.gridy = 3;
		createNewOrderLeftPanel.add(quantityLabel,orderGC);
		orderGC.gridx = 1;
		orderGC.gridy = 3;
		createNewOrderLeftPanel.add(quantityTextField,orderGC);
		//=====
		orderGC.gridx = 0;
		orderGC.gridy = 4;
		createNewOrderLeftPanel.add(addProductButton,orderGC);
		orderGC.gridx = 1;
		orderGC.gridy = 4;
		orderGC.weighty = 10;
		createNewOrderLeftPanel.add(confirmOrderButton,orderGC);
		//TextPane
		textArea = new JTextArea(20,20); //height - width
		textArea.setEditable(false);
		JScrollPane orderScrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        orderGC.gridwidth = GridBagConstraints.REMAINDER;
        orderGC.fill = GridBagConstraints.BOTH;
        orderGC.weightx = 1.0;
        orderGC.weighty = 1.0;
        orderGC.gridx = 3;
        createNewOrderRightPanel.add(orderScrollPane, orderGC);
		//Right Panel
		//Main Panel Add
		createOrderPanel.add(createNewOrderLeftPanel);
		createOrderPanel.add(createNewOrderRightPanel);
		//if clicked, we try to add the product to the order if it is being made, add it to a new one if it isn't and throw up an error if it already has been made.
		addProductButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String orderIdString = orderIdTextField.getText();
				String productCodeString = productCodeTextField.getText();
				String supplierIdString = supplierIdTextField.getText();
				String quantityString = quantityTextField.getText();
				Product product = null;
				Supplier supplier = null;
				boolean alreadyExists = false;
				
				if((orderIdString.trim().equals("") || (orderIdString.trim().equals(".*\\D.*")) || 
						(productCodeString.trim().equals("") || (productCodeString.trim().equals(".*\\D.*")) ||
								(supplierIdString.trim().equals("") || (supplierIdString.trim().equals(".*\\D.*")) ||
										(quantityString.trim().equals("") || (quantityString.trim().equals(".*\\D.*"))))))){
					JOptionPane.showMessageDialog(null, "Please ensure all text fields have been filled!");
				}
				else{
					//check for a product with the inputed ID
					for(Product product1: products){
						if(product1.getProductCode().equals(productCodeString)){
							product = product1;
							break;
						}
					}
					//check for a supplier with the inputed ID
					for(Supplier supplier1: suppliers){
						if(supplier1.getId() == (Integer.parseInt(supplierIdString))){
							supplier = supplier1;
							break;
						}
					}
					//check for an order with the inputed ID
					for(Order order1: orders){
						if(order1.getOrderUniqueId() == (Integer.parseInt(orderIdString))){
							alreadyExists = true;
							break;
						}
					}
					
					if(product == null){
						JOptionPane.showMessageDialog(null, "Supplier with that ID does not exist!");
					}
					else if(supplier == (null)){
						JOptionPane.showMessageDialog(null, "Supplier with that ID does not exist!");
					}
					else if(alreadyExists){
						JOptionPane.showMessageDialog(null, "Order with that ID already exists!");
					}
					else{
						if(baseOrder == (null)){
							baseOrder = new Order((Integer.parseInt(orderIdString)), (Integer.parseInt(supplierIdString)), new OrderProduct(product, (Integer.parseInt(quantityString))));
						}
						else{
							baseOrder.addToProductList(new OrderProduct(product, (Integer.parseInt(quantityString))));
							textArea.setText(new Order().printOrderDetails(baseOrder));
						}
					}
				}
			}
		});
		confirmOrderButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(baseOrder == null){
					JOptionPane.showMessageDialog(null, "Order contains no products, please add some products before trying to confirm!");
				}
				else{
					orders.add(baseOrder);				
				}
			}
		});
		//createNewOrderComponents added.
		//=========================================================================================
	
		//===============================
		//vIWcUSTOMERiNVOICE fUNCTIONALITY
		GridBagConstraints gc = new GridBagConstraints();
		gc.insets = new Insets(5, 5, 5, 5);
		viewInvJPanel.add(viewCustomerPanel);
		viewCustomerPanel.setLayout(new GridBagLayout());
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
		textarea = new JTextArea(20,50); //height - width
		textarea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textarea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        viewCustomerPanel.add(scrollPane, c);
		
		// First Label and controls:	View Invoice by ID 
		JLabel invIdlbl = new JLabel("Invoice ID: "); //Label
		gc.gridx = 0;
		gc.gridy = 1;
		viewCustomerPanel.add(invIdlbl,gc);
		invTextField2 = new JTextField(10); //Text Field
		gc.gridx = 1;
		gc.gridy = 1;
		viewCustomerPanel.add(invTextField2,gc);
		JButton invButton = new JButton("Invoice ID");	//button
		gc.gridx = 2;
		gc.gridy = 1;
		invButton.setPreferredSize(new Dimension(120, 30));
		viewCustomerPanel.add(invButton,gc);
		//Action listener For Button to view Invoice by Id
		invButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = invTextField2.getText();
				if(input.trim().equals("") || input.matches(".*\\D.*")){ //regEx
					textarea.setText("Please enter a valid number");
					textarea.setCaretPosition(0);
					invTextField2.setText("");
					custIdTextField.setText("");
				}else{
					int num = Integer.parseInt(input);
					textarea.setText(invoice.viewInvoiceById(num, invoices)); //viewInvoiceById() is in the Invoice Class
					textarea.setCaretPosition(0);
					invTextField2.setText("");
					custIdTextField.setText("");
				}
			}
		});
		
		//Second Label and controls: 	View Customer by ID
		JLabel custIdlbl = new JLabel("Customer ID: ");
		gc.gridx = 0;
		gc.gridy = 2;
		viewCustomerPanel.add(custIdlbl,gc);
		custIdTextField = new JTextField(10);
		gc.gridx = 1;
		gc.gridy = 2;
		viewCustomerPanel.add(custIdTextField,gc);
		JButton custIdButton = new JButton("Customer ID");
		gc.gridx = 2;
		gc.gridy = 2;
		custIdButton.setPreferredSize(new Dimension(120, 30));
		viewCustomerPanel.add(custIdButton,gc);
		custIdButton.addActionListener(new ActionListener() {
			//Action listener For Button to view Customer by Id
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = custIdTextField.getText();
				if(input.trim().equals("") || input.matches(".*\\D.*")){ //regEx
					textarea.setText("Please enter a valid number");
					textarea.setCaretPosition(0);
					custIdTextField.setText("");
					invTextField2.setText("");
				}else{
					int num = Integer.parseInt(input);
					textarea.setText(invoice.viewInvoiceByCustomer(num, invoices));	//viewInvoiceByCustomer() is in the Invoice class
					textarea.setCaretPosition(0);
					custIdTextField.setText("");
					invTextField2.setText("");
				}
			}
		});
		
		//Button x3: 	View All/ View Paid/ View UnPaid
		//1. View all Button
		JButton viewAllBtn = new JButton("View All");
		gc.gridx = 2;
		gc.gridy = 3;
		viewAllBtn.setPreferredSize(new Dimension(120, 30));
		viewCustomerPanel.add(viewAllBtn,gc);
		viewAllBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textarea.setText(invoice.viewAllInvoices(invoices));	//viewAllInvoices() is in the Invoice Class
				textarea.setCaretPosition(0);
			}
		});
		
		//2. Paid Button
		JButton viewPaidBtn = new JButton("View Paid");
		gc.gridx = 3;
		gc.gridy = 1;
		viewPaidBtn.setPreferredSize(new Dimension(120, 30));
		viewCustomerPanel.add(viewPaidBtn,gc);
		viewPaidBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textarea.setText(invoice.viewPaidInvoice(invoices));	//viewPaidInvoice() is in the invoice class
				textarea.setCaretPosition(0);
				
			}
		});
		
		//3. UnPaid Button
		JButton viewUnpaidBtn = new JButton("View Unpaid");
		viewUnpaidBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textarea.setText(invoice.viewUnPaidInvoice(invoices));	//viewUnPaidInvoice() is in the invoice class
				textarea.setCaretPosition(0);
			}
		});
		gc.gridx = 3;
		gc.gridy = 2;
		viewUnpaidBtn.setPreferredSize(new Dimension(120, 30));
		viewCustomerPanel.add(viewUnpaidBtn,gc);
		
		//4. Reset Panel Btn
		JButton resetPanelBtn = new JButton("Clear Panel");
		gc.gridx = 3;
		gc.gridy = 3;
		resetPanelBtn.setPreferredSize(new Dimension(120, 30));
		viewCustomerPanel.add(resetPanelBtn,gc);
		resetPanelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textarea.setText("");
				invTextField2.setText("");
				custIdTextField.setText("");
				
			}
		});
	
		//==============================================
		//Marc: Create Invoice Functionality
		//Objects below for testing purposes only!!!
		employees.add(new Employee(1, "marc", 1, 50.00, 1234));
		customers.add(new Customer(2, "Paddy Power", "Dublin"));
		products.add(new Product("y", "y", "a", 60.00, 30.00, 30,40, 4, new Supplier(3, "m", "m")));
		products.add(new Product("y", "y", "s", 60.00, 30.00, 30,40, 4, new Supplier(3, "m", "m")));
		//================================
		//Left Panel Components
		//================================
		leftPanel.setLayout(new GridBagLayout());
		//GridBagConstraints gc = new GridBagConstraints();
		createInvJPanel.add(createNewInvoicePanel);
		gc.insets = new Insets(5,5,5,5);
		//=====
		gc.gridx = 0;
		gc.gridy = 0;
		leftPanel.add(invIdLbl,gc);
		gc.gridx = 1;
		gc.gridy = 0;
		leftPanel.add(invTextF,gc);
		//=====
		gc.gridx = 0;
		gc.gridy = 1;
		leftPanel.add(employLbl,gc);
		gc.gridx = 1;
		gc.gridy = 1;
		leftPanel.add(employTextF,gc);
		//=====
		gc.gridx = 0;
		gc.gridy = 2;
		leftPanel.add(custId,gc);
		gc.gridx = 1;
		gc.gridy = 2;
		leftPanel.add(custTextF,gc);
		//=====
		gc.gridx = 0;
		gc.gridy = 3;
		leftPanel.add(prodId,gc);
		gc.gridx = 1;
		gc.gridy = 3;
		leftPanel.add(prodTextF,gc);
		//=====
		gc.gridx = 0;
		gc.gridy = 4;
		leftPanel.add(quantitylbl,gc);
		gc.gridx = 1;
		gc.gridy = 4;
		leftPanel.add(quantityTextF,gc);
		//=====
		gc.gridx = 1;
		gc.gridy = 5;
		addMoreBtn.setPreferredSize(new Dimension(120, 30)); //width/height
		leftPanel.add(addMoreBtn,gc);
//AddMoreBtn Event Listener
		addMoreBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String prodId = prodTextF.getText();
				String quan = quantityTextF.getText();
				if(prodId.trim().equals("")|| (quan.trim().equals("") || quan.matches(".*\\D.*"))){
					JOptionPane.showMessageDialog (null, "Please ensure all text fields have been filled", "Missing Info", JOptionPane.WARNING_MESSAGE);
				}else{
					//disable the other text fileds
					invTextF.setEnabled(false);
					employTextF.setEnabled(false);
					custTextF.setEnabled(false);
					
					//Add to 'addMoreArrayList'
					Product p = invoice.returnProductObject(prodId, products);
					int quantity = Integer.parseInt(quan);
					if(p!=null){
						InvoiceProduct invProd = new InvoiceProduct(p, quantity);
						addMoreArrayList.add(invProd);
						
						for(InvoiceProduct prod : addMoreArrayList){
						message += "Product No: " + prod.getProduct().getProductCode() +"\nQuantity: " + prod.getQuantity() + "\n\n";
						}
						textAreaMarc.setText(message);
						textAreaMarc.setCaretPosition(0);
						message = "";
					}else{
						JOptionPane.showMessageDialog (null, "No Product Record exist with that Input", "Product Info", JOptionPane.WARNING_MESSAGE);
					}
					//Set text boxes to 0
					//prodTextF.setText("");
					//quantityTextF.setText("");
					
				}
				
				
			}
		});
//End of AddMoreBtnEventListener		
		//=====
		gc.gridx = 1;
		gc.gridy = 6;
		finishBtn.setPreferredSize(new Dimension(120, 30));
		leftPanel.add(finishBtn,gc);
//finishBtn eventListener
		finishBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println(addMoreArrayList.size());
				String invoiceIdStr = invTextF.getText();
				String employeeIdStr = employTextF.getText();
				String customerIdStr = custTextF.getText();
				String productIdStr = prodTextF.getText();
				String quantityStr = quantityTextF.getText();
				
				//Make sure all text fields are filled with RELAVENT content
				if((invoiceIdStr.trim().equals("")||invoiceIdStr.matches(".*\\D.*"))
					||	(employeeIdStr.trim().equals("")||employeeIdStr.matches(".*\\D.*"))
					||	(customerIdStr.trim().equals("")||customerIdStr.matches(".*\\D.*"))
					||	(productIdStr.trim().equals(""))
					||	(quantityStr.trim().equals("")||quantityStr.matches(".*\\D.*")))
				{
					JOptionPane.showMessageDialog (null, "Please ensure all text fields have been filled", "Missing Info", JOptionPane.WARNING_MESSAGE);
				}else{
					int invoiceId = Integer.parseInt(invoiceIdStr);
					int employeeId = Integer.parseInt(employeeIdStr);
					int customerid = Integer.parseInt(customerIdStr);
					int quantity = Integer.parseInt(quantityStr);
				
					
				//Now need employee object, customer object and product object
					Employee employeeObj = invoice.returnEmployeeObject(employeeId,employees);
					Customer customerObj = invoice.returnCustomerObject(customerid, customers);
				//create an arryalist of Invoice product which is required for Invoice Constructor
					Product productObject = invoice.returnProductObject(productIdStr, products);
					ArrayList<InvoiceProduct> prods = new ArrayList<InvoiceProduct>();
					InvoiceProduct invProd = new InvoiceProduct(productObject, quantity);
					prods.add(invProd);
					
				//Before the Invoice is created I need to run checks
						if(employeeObj!=null){
							if(customerObj != null){
								if(productObject != null){
									if(invoiceNumberUnique(invoiceId,invoices)){
										
										//All checks passed, create Invoice
										if(addMoreArrayList.size()<1){
										Invoice singleInvoiceComplete = new Invoice(invoiceId, employeeObj, customerObj, prods);
										invoices.add(singleInvoiceComplete);
										/*System.out.println(invoices.size());*/
										outputMessage += "Thank you for you order"+
																"\nInvoice No: " + invoiceIdStr +
																"\nEmployees No: "+ employeeIdStr +
																"\nCustomer No: " + customerIdStr+
																"\nProduct Code: " + productIdStr+
																"\nNo. of items: " + quantityStr;
																//+"\nArraySize: " + addMoreArrayList.size();
										}else{
											Invoice multipleInvoice = new Invoice(invoiceId,employeeObj,customerObj,addMoreArrayList);
											invoices.add(multipleInvoice);
											//System.out.println(invoices.size());
											outputMessage += "Thank you for you order"+
													"\nInvoice No: " + invoiceIdStr +
													"\nEmployees No: "+ employeeIdStr +
													"\nCustomer No: " + customerIdStr+
													"\nList Of Products Ordered:" +
													"\n------------------------";
											for(Invoice v : invoices){
												if(v.getId()==invoiceId){
													for(InvoiceProduct p : v.getInvoiceProducts()){
													outputMessage+= "\nProduct Code: " + p.getProduct().getProductCode() +
															"\nNo. of items: " + p.getQuantity() + "\n";
													}
												}
											}
											//outputMessage+="\nArraySize: " + addMoreArrayList.size(); for testing
										}
										//reset the text Boxes to Null
										invTextF.setText("");
										employTextF.setText("");
										custTextF.setText("");
										prodTextF.setText("");
										quantityTextF.setText("");
										textAreaMarc.setText(outputMessage);
										textAreaMarc.setCaretPosition(0);
										invTextF.setEnabled(true);
										employTextF.setEnabled(true);
										custTextF.setEnabled(true);
										outputMessage = "";
										message = "";
										addMoreArrayList = new ArrayList<InvoiceProduct>();
										
									}else{
										JOptionPane.showMessageDialog (null, "Invoice Number is not Unique", "Invoice Info", JOptionPane.WARNING_MESSAGE);
									}
								}else{
									JOptionPane.showMessageDialog (null, "No Product Record exist with that Input", "Product Info", JOptionPane.WARNING_MESSAGE);
								}
							}else{
								JOptionPane.showMessageDialog (null, "No Customer Record exist with that Input", "Customer Info", JOptionPane.WARNING_MESSAGE);
							}
						}else{
							JOptionPane.showMessageDialog (null, "No Employee Record exist with that Input", "Employee Info", JOptionPane.WARNING_MESSAGE);
						}
				}
				
			}
		});
		
		//=====
		gc.gridx = 1;
		gc.gridy = 7;
		resetBtn.setPreferredSize(new Dimension(120, 30)); //width/height
		leftPanel.add(resetBtn,gc);
		resetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				invTextF.setText("");
				employTextF.setText("");
				custTextF.setText("");
				prodTextF.setText("");
				quantityTextF.setText("");
				textAreaMarc.setText("");
				invTextF.setEnabled(true);
				employTextF.setEnabled(true);
				custTextF.setEnabled(true);
				addMoreArrayList = new ArrayList<InvoiceProduct>();
				
			}
		});
	
		
		
		//================================
		//Right Panel : textAreaMarc and Pane
		//================================
		textAreaMarc = new JTextArea(15,20); //height - width
		textAreaMarc.setEditable(false);
		JScrollPane scrollPane3 = new JScrollPane(textAreaMarc,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 1.0;
        gc.weighty = 1.0;
        gc.gridx = 3;
        rightPanel.add(scrollPane3, gc);
		
		
		//Main Panel Add
        createNewInvoicePanel.add(leftPanel);
        createNewInvoicePanel.add(rightPanel);
		
		//End of Marc Functionality
		//==============================================
		
		
		//======================== Start View Product Details ===========
		
		viewProductDetailsPanel.add(viewProductDetails);
		viewProductDetails.setLayout(new GridBagLayout());
		GridBagConstraints productGC = new GridBagConstraints();
		productGC.insets = new Insets(5,5,5,5); //sets the padding around each component
		

		//1. TextArea
		productTextArea = new JTextArea(20,20); //height - width
		productTextArea.setEditable(false);
		
		JScrollPane scrollPane1 = new JScrollPane(productTextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		productTextArea.setCaretPosition(0);
		c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        viewProductDetails.add(scrollPane1, c);
		
		// First Label and controls:	View Product by ID 
		JLabel productIdlbl = new JLabel("Enter Product ID: "); //Label
		productGC.gridx = 0;
		productGC.gridy = 1;
		viewProductDetails.add(productIdlbl,productGC);
		viewProductIdTextField = new JTextField(10); //Text Field
		productGC.gridx = 1;
		productGC.gridy = 1;
		viewProductDetails.add(viewProductIdTextField,productGC);
		JButton productButton = new JButton("Search Product ID");	//button
		productGC.gridx = 2;
		productGC.gridy = 1;
		viewProductDetails.add(productButton,productGC);
		productButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
		//Action listener For Button to view Product by Id
		productButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = viewProductIdTextField.getText();
				// This method could be enhanced by adding in a check 
				//to ensure 9 digits have been entered to match an ISBN number.
				if(input.trim().equals("")){ 
					//textarea.setText("Please enter a valid ID");	
					JOptionPane.showMessageDialog(null, "Please Enter a Value in the ID Field");
					viewProductIdTextField.setText("");
					productTitleTextField.setText("");
				}else{
				
					productTextArea.setText(product.viewProductById(input, products)); //viewInvoiceById() is in the Invoice Class
					productTextArea.setCaretPosition(0);
					viewProductIdTextField.setText("");
					productTitleTextField.setText("");
					productAuthorTextField.setText("");
					productTextArea.setCaretPosition(0);
				}
			}
		});
		
		//Second Label and controls: 	View Product by Title
		JLabel productTitlelbl = new JLabel("Product Title: ");
		productGC.gridx = 0;
		productGC.gridy = 2;
		viewProductDetails.add(productTitlelbl,productGC);
		productTitleTextField = new JTextField(10);
		productGC.gridx = 1;
		productGC.gridy = 2;
		viewProductDetails.add(productTitleTextField,productGC);
		JButton productTitleButton = new JButton("Search Product Title");
		productGC.gridx = 2;
		productGC.gridy = 2;
		viewProductDetails.add(productTitleButton,productGC);
		productTitleButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
		productTitleButton.addActionListener(new ActionListener() {
			//Action listener For Button to view product by Title
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = productTitleTextField.getText();
				
				if(input.trim().equals("")){ 
					//textarea.setText("Please enter a valid Title");
					JOptionPane.showMessageDialog(null, "Please Enter a Value in the Title Field");
					productTitleTextField.setText("");
					
				}else{
					
					productTextArea.setText(product.viewProductByTitle(input, products));	//viewInvoiceByCustomer() is in the Invoice class
					productTextArea.setCaretPosition(0);
					productTitleTextField.setText("");
					viewProductIdTextField.setText("");
					productAuthorTextField.setText("");
					
					
				}
			}
		});
		
		
		//Third Label and controls: 	View Product by Author
		JLabel productAuthorlbl = new JLabel("Product Author: ");
		productGC.gridx = 0;
		productGC.gridy = 3;
		viewProductDetails.add(productAuthorlbl,productGC);
		productAuthorTextField = new JTextField(10);
		productGC.gridx = 1;
		productGC.gridy = 3;
		viewProductDetails.add(productAuthorTextField,productGC);
		JButton productAuthorBtn = new JButton("Search Author");
		productGC.gridx = 2;
		productGC.gridy = 3;
		viewProductDetails.add(productAuthorBtn,productGC);
		productAuthorBtn.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
		productAuthorBtn.addActionListener(new ActionListener() {
			//Action listener For Button to view product by Title
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = (productAuthorTextField.getText()).toLowerCase();	// Convert input text to lower case. 
																					//All names in array should be stored in lower case.
				
				if(input.trim().equals("")){ 	// If no text is entered
					//textarea.setText("Please enter text in Author Field");
					JOptionPane.showMessageDialog(null, "Please Enter a Value in the Author Field");
					productAuthorTextField.setText("");
					//invTextField.setText("");
				}else{							// Take in String and Search for it.
					productTextArea.setText(product.viewProductByAuthor(input, products));	
					productTextArea.setCaretPosition(0);
					productAuthorTextField.setText("");
					viewProductIdTextField.setText("");
					productTitleTextField.setText("");
				}
			}
		});

		//Button 4: 	View All
		//1. View all Button
		JButton viewAllProductsBtn = new JButton(" View All Products ");
		productGC.gridx = 4;
		productGC.gridy = 1;
		viewProductDetails.add(viewAllProductsBtn,productGC);
		viewAllProductsBtn.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
		viewAllProductsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productTextArea.setText(product.viewAllProductDetails(products));	//viewAllProducts() is in the Product Class
				productTextArea.setCaretPosition(0);
				viewProductIdTextField.setText("");
				productTitleTextField.setText("");
				productAuthorTextField.setText("");
			}
		});
		
		
		// Button 5: View All Current Stock below Min Reorder Level
				
		JButton viewAllBelowMinReorder = new JButton(" View All Low Stock ");
		productGC.gridx = 4;
		productGC.gridy = 2;
		viewProductDetails.add(viewAllBelowMinReorder,productGC);
		viewAllBelowMinReorder.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
		viewAllBelowMinReorder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productTextArea.setText(product.viewProductByMinStock(products));
				viewProductIdTextField.setText("");
				productTitleTextField.setText("");
				productAuthorTextField.setText("");
			}
		});
				
				
		// Button 6: View all Current Stock above Max level (Over Stock)	
		JButton viewAllAboveMaxReorder = new JButton(" View All Over Stock ");
		productGC.gridx = 4;
		productGC.gridy = 3;
		viewProductDetails.add(viewAllAboveMaxReorder,productGC);
		viewAllAboveMaxReorder.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
		viewAllAboveMaxReorder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				productTextArea.setText(product.viewProductByOverStock(products));
				viewProductIdTextField.setText("");
				productTitleTextField.setText("");
				productAuthorTextField.setText("");
			}
		});
		
		//=======================  End
		
		} //END OF CONSTRUCTOR

	//handler for login button
			private class LoginButtonHandler implements ActionListener{
				public void actionPerformed( ActionEvent e){//handler starts
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
			private class EditInvoiceButtonHandler implements ActionListener{
				public void actionPerformed( ActionEvent e){//handler starts
					int id = 0;
					try {
						id = Integer.parseInt( editInvoiceJTextField.getText().trim() );
					}
					catch (NumberFormatException nfe){
						editInvoiceJTextField.setText("");
					}
					int invoiceID = verifyInvoiceID(id);
					if(invoiceID == 1){
						for(Invoice invoice: invoices){
							if(id == invoice.getId()){
								editCustomerInvoiceComponentsJPanel.setVisible(false);
								editInvoiceComponentsJPanel.setVisible(true);
								saveInvoiceComponentsJPanel.setVisible(true);
								editInvoiceId.setText(Integer.toString(id));
								editInvoiceEmployee.setText(Integer.toString(invoice.getEmployee().getEmployeeId()));
								editInvoiceCustomer.setText(Integer.toString(invoice.getCustomer().getCustId()));
								//editInvoiceProduct.setText(invoice.getProduct().getProductCode());
								//editInvoiceQuantity.setText(Integer.toString(invoice.getQuantity()));
								editInvoiceAmount.setText(Double.toString(invoice.getTotalInvoicePrice()));
								if(invoice.isPaid() == false){
									editPayStatus.setText("Unpaid");
									editPayStatus.setForeground(Color.RED);
								}
								if(invoice.isPaid()){
									editPayStatus.setText("Paid");
									editPayStatus.setForeground(Color.BLACK);
								}
							}
						}	
					}
					else if(invoiceID == 2){
						//no invoice id match
						JOptionPane.showMessageDialog(loginJPanel, "Invoice ID not found", "For your information", JOptionPane.INFORMATION_MESSAGE);
						editCustomerInvoiceComponentsJPanel.setVisible(false);
						editInvoiceComponentsJPanel.setVisible(false);
						saveInvoiceComponentsJPanel.setVisible(false);
					}
				}
				public int verifyInvoiceID(int id) {
			    	int count = 0;
			    	int validID = 0;
					for(Invoice invoice: invoices){
						if(id == invoice.getId()){
							count++;
							validID = 1;
						}
					}	
					if(count == 0){
						validID = 2;
					}
					return validID;
				}
			}
							
			//Handler for pay invoices by customer button
			private class EditCustomerInvoiceButtonHandler implements ActionListener{
				public void actionPerformed( ActionEvent e){//handler starts
						int count = 0, count1 = 0;;
						String s = "";
						double total = 0;
						String totalString = "";
						int id = 0, customerID = 1;
						try {
							id = Integer.parseInt( editCustomerInvoiceJTextField.getText().trim() );
						}
						catch (NumberFormatException nfe){
							editCustomerInvoiceJTextField.setText("");
						}
						for(Customer customer: customers){
							if(id == customer.getCustId()){
								count1++;
								customerID = 1;
							}
						}	
						if(count1 == 0){
							customerID = 2;
						}
						if(customerID == 1){
							editCustomerInvoiceComponentsJPanel.setVisible(true);
							editInvoiceComponentsJPanel.setVisible(false);
							saveInvoiceComponentsJPanel.setVisible(false);
							customerInvoiceJTextArea.setText("Unpaid Invoices: ");
							for(Invoice invoice: invoices){
								if(id == invoice.getCustomer().getCustId() ){
									if(invoice.isPaid() == false){
										s = "\nInvoice Id : " + invoice.getId() + 
												"\nDate: " + invoice.getInvoiceDate()+ "\nTotal: " + 
												invoice.getTotalInvoicePrice() + "\n";
										customerInvoiceJTextArea.append(s);
										total = total + invoice.getTotalInvoicePrice();
										count++;								
									}
								}
							}
							if(count == 0){
								JOptionPane.showMessageDialog(loginJPanel, "No unpaid invoices for this customer", "For your information", JOptionPane.INFORMATION_MESSAGE);
								editCustomerInvoiceComponentsJPanel.setVisible(false);
							}
							else{
								totalString = Double.toString(total);
								allInvoicesTotalJTextField.setText(totalString);
							}						
						}
						else if(customerID == 2){
							//no customer id match
							JOptionPane.showMessageDialog(loginJPanel, "Customer ID not found", "For your information", JOptionPane.INFORMATION_MESSAGE);
							editCustomerInvoiceComponentsJPanel.setVisible(false);
							editInvoiceComponentsJPanel.setVisible(false);
							saveInvoiceComponentsJPanel.setVisible(false);
						}
					}
				}
							
			//handler for save button
			private class SaveButtonHandler implements ActionListener{
				public void actionPerformed( ActionEvent e){
					int invId = 0;						
					int empId = 0;
					int custId = 0;
					//String productId = editInvoiceProduct.getText().trim();
					//int qty = 0;
					int currentId = Integer.parseInt(editInvoiceJTextField.getText().trim());
					int count1 = 0, count2 = 0, count3 = 0;
					Employee emp = employees.get(0);
					Customer cust = customers.get(0);
					//Product prod = products.get(0);
					try{
						invId = Integer.parseInt(editInvoiceId.getText().trim());
						empId = Integer.parseInt(editInvoiceEmployee.getText().trim());
						custId = Integer.parseInt(editInvoiceCustomer.getText().trim());
						//qty = Integer.parseInt(editInvoiceQuantity.getText().trim());
					}
					catch(NumberFormatException nfe){
						invalidId();
					}						
					for(Employee employee: employees){
						if(empId == employee.getEmployeeId()){
							emp = employee;
							count1++;
						}
					}						
					for(Customer customer: customers){
						if(custId == customer.getCustId()){
							cust = customer;
							count2++;
						}
					}						
				/*	for(Product product: products){
						if(productId.equals(product.getProductCode())){
							prod = product;
							count3++;						
						}
					}
					*/					
					if (count1 != 0 && count2 != 0 && count3 != 0){
						for(Invoice invoice: invoices){
							if(currentId == invoice.getId()){
								invoice.setId(invId);
								invoice.setEmployee(emp);
								invoice.setCustomer(cust);
							//	invoice.setProduct(prod);
							//	invoice.setQuantity(qty);
							}
						}
						editInvoiceJTextField.setText(Integer.toString(currentId));
						JOptionPane.showMessageDialog(null, "Updated!");
						editInvoiceJButton.doClick();
					}
					else if(count1 == 0){
						JOptionPane.showMessageDialog(null, "Invalid Employee Id!");
						editInvoiceJButton.doClick();
					}
					else if(count2 == 0){
						JOptionPane.showMessageDialog(null, "Invalid Customer Id!");
						editInvoiceJButton.doClick();
					}
					/*else if(count3 == 0){
						JOptionPane.showMessageDialog(null, "Invalid Product Id!");
						editInvoiceJButton.doClick();
					}	*/
				}
				public void invalidId(){
					JOptionPane.showMessageDialog(null, "Id must be a numerical value!");
					editInvoiceJButton.doClick();
				}
			}// End handler for save button
			
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

	}//End class
