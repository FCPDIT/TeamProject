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
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class RetailGUI extends JFrame{
	
	private ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	private ArrayList<Invoice> invoices = new ArrayList<Invoice>();
	private ArrayList<Order> orders = new ArrayList<Order>();
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<Product> products = new ArrayList<Product>();
	private ArrayList<Employee> employees  = new ArrayList<Employee>();
	private ArrayList<InvoiceProduct> invoiceProducts1 = new ArrayList<InvoiceProduct>();
	private ArrayList<InvoiceProduct> invoiceProducts2 = new ArrayList<InvoiceProduct>();
	private ArrayList<InvoiceProduct> invoiceProducts3 = new ArrayList<InvoiceProduct>();
	
	public ArrayList<Order> getOrders(){
		return this.orders;
	}
	
	public void addOrders(Order order){
		orders.add(order);
	}
	
	private JFrame mainJFrame = new JFrame();
	private GridBagConstraints gc = new GridBagConstraints();
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
	
	private JPanel addCustJPanel = new JPanel();
	private JPanel viewCustJPanel = new JPanel();
	private JPanel editCustJPanel = new JPanel();
	
	private JPanel addSupplyJPanel = new JPanel();
	private JPanel viewSupplyJPanel = new JPanel();
	private JPanel editSupplyJPanel = new JPanel();
	
	private JPanel addProductJPanel = new JPanel();
	private JPanel editProductJPanel = new JPanel();
	
	private JPanel createInvJPanel = new JPanel();
	private JPanel viewInvJPanel = new JPanel();
	private JPanel editInvJPanel = new JPanel();
	
	private JPanel createOrderPanel = new JPanel();
	private JPanel viewOrderJPanel = new JPanel();
	private JPanel viewOrderLeftJPanel = new JPanel();
	private JPanel viewOrderRightJPanel = new JPanel();
	private JPanel editOrderJPanel = new JPanel();
	
	private JPanel employeeJPanel = new JPanel();
	private JPanel viewEmployeeJPanel = new JPanel();
	private JPanel editEmployeeJPanel = new JPanel();
	
	private JPanel proflossJPanel = new JPanel();
	
	//login components
	private JPanel loginComponentsJPanel = new JPanel();
	private JTextField loginTF = new JTextField();
	private JPasswordField passwordTF = new JPasswordField();
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
	
	//Employee Components
	//TODO
	private JLabel employeeId = new JLabel("Employee ID ");
	private JTextField employeeIdField = new JTextField();
	private JLabel  employeeName = new JLabel("Employee Name ");
	private JTextField employeeNameField = new JTextField();
	private JLabel employeeAcess = new JLabel("Access Level ");
	private JTextField employeeAcessField = new JTextField();
	private JLabel employeeSalary = new JLabel("Employee Salary");
	private JTextField employeeSalaryField = new JTextField();
	private JLabel employeePassword = new JLabel("Employee Password");
	private JTextField employeePassField = new JTextField();
	private JButton employeeJButton = new JButton("Create New Employee");
	private JLabel viewEmpId = new JLabel("View By ID");
	private JTextField viewEmpIdField = new JTextField();
	private JButton viewEmpIdButton = new JButton("Search Employees");
	private JLabel viewEmpName = new JLabel("View By Name");
	private JTextField viewEmpNameField = new JTextField();
	private JButton viewEmpNameButton = new JButton("Search Employees");
	private JLabel viewEmpAll = new JLabel("View All Employees");
	private JButton viewEmpAllButton = new JButton("View All");
	private JTextArea empJTextArea = new JTextArea(10, 65);
	
	private JLabel editFindById = new JLabel("Enter Employee ID ");
	private JTextField editFindByIdField = new JTextField();
	private JButton editById = new JButton("Find Employee Details");
	private JLabel editEmpId = new JLabel("Employee Id");
	private JTextField editEmpIdField = new JTextField();
	private JLabel editEmpName = new JLabel("Employee Name");
	private JTextField editEmpNameField = new JTextField();
	private JLabel editEmpAccess = new JLabel("Employee Access Level");
	private JTextField editEmpAccessField = new JTextField();
	private JLabel editEmpSalary = new JLabel("Employee Salary");
	private JTextField editEmpSalaryField = new JTextField();
	private JLabel editEmpPassword = new JLabel("Employee Password");
	private JTextField editEmpPasswordField = new JTextField();
	private JButton updateEmployee = new JButton("Update Employee");
	private JButton deleteEmployee = new JButton("Delete Employee");
	
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
	private JRadioButton under50Radio = new JRadioButton("under 50");
	private JRadioButton fiftyTo100Radio = new JRadioButton("50 - 100");
	private JRadioButton hundredTo200Radio = new JRadioButton("100 - 200");
	private JRadioButton over200Radio = new JRadioButton("200 plus");
	
	//edit product components
	private JLabel editDetails = new JLabel ("Product code");
	private JTextField enterProdCodeJTextField = new JTextField();
	private JButton editDetailsJButton = new JButton("Select product to edit");
	private JLabel editProdTitle = new JLabel("Book Title");
	private JTextField editTitleJTextField = new JTextField();
	private JLabel editProdAuthor = new JLabel("Author");
	private JTextField editAuthorJTextField = new JTextField();
	private JLabel editProdCode = new JLabel("Book Code");
	private JTextField editCodeJTextField = new JTextField();
	private JLabel editProdRetail = new JLabel("Retail Price");
	private JTextField editRetailJTextField = new JTextField();
	private JLabel editProdCost = new JLabel("Cost Price");
	private JTextField editCostJTextField = new JTextField();
	private JLabel editProdTotalStock = new JLabel("Total Stock");
	private JTextField editStockJTextField = new JTextField();
	private JLabel editProdMaxStock = new JLabel("Maximum Stock");
	private JTextField editMaxJTextField = new JTextField();
	private JLabel editProdMinStock = new JLabel("Minimum Stock");
	private JTextField editMinJTextField = new JTextField();
	private JLabel editProdSupplierId = new JLabel("Supplier Id");
	private JTextField editProdSupplierIdJTextField = new JTextField();
	private JButton updateProductJButton = new JButton("Update details");
	private JButton deleteStockLineJButton = new JButton("Delete stock line");
	
	// View Product Components
	private Product product = new Product();
	private JTextArea productTextArea;
	private JTextField productTitleTextField;
	private JTextField productAuthorTextField;
	private JTextField viewProductIdTextField;
	//private JTextField invTextField;
	private JPanel viewProductDetailsPanel= new JPanel();
	private JPanel viewProductDetails= new JPanel();
	private int buttonWidth = 155;
	private int buttonHeight = 20;
	private ButtonGroup priceRange = new ButtonGroup();
	private ButtonGroup quantity = new ButtonGroup();
	
	//Edit Invoice Components 
	private JPanel findInvoiceComponentsJPanel = new JPanel();
	private JPanel editInvoiceComponentsJPanel = new JPanel();
	private JPanel editCustomerInvoiceComponentsJPanel = new JPanel();
	private JPanel saveInvoiceComponentsJPanel = new JPanel();
	private JPanel editInvoiceProductsComponentsJPanel = new JPanel();
	private JTextField editInvoiceJTextField = new JTextField("Invoice Id");
	private JTextArea customerInvoiceJTextArea = new JTextArea(10,20);
	private JTextArea productInvoiceJTextArea = new JTextArea();
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
	
	private Vector<String> existingInvoiceNums = new Vector<>();
	private DefaultComboBoxModel<String> listOfInvoices = new DefaultComboBoxModel<>(existingInvoiceNums); //create the combo box
	private JComboBox<String> comboBoxInvoice;
	
	private Vector<String> existingCustomerId = new Vector<>();
	private DefaultComboBoxModel<String> listOfCustomers = new DefaultComboBoxModel<>(existingCustomerId); //create the combo box
	private JComboBox<String> comboBoxCustomer;
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
	ArrayList<OrderProduct> addMoreProducts = new ArrayList<OrderProduct>();
	String result = "";
	private JPanel createNewOrderLeftPanel = new JPanel();
	private JPanel createNewOrderRightPanel = new JPanel();
	private JLabel createOrderOrderIdLabel = new JLabel("Order ID: ");
	private JLabel createOrderSupplierIdLabel = new JLabel("Supplier ID: ");
	private JLabel createOrderProductCodeLabel = new JLabel("Product ID: ");
	private JLabel createOrderQuantityLabel = new JLabel("Quantity: ");
	private JTextField createOrderOrderIdTextField = new JTextField();
	private JTextField createOrderSupplierIdTextField = new JTextField();
	private JTextField createOrderProductCodeTextField = new JTextField();
	private JTextField createOrderQuantityTextField = new JTextField();
	private JButton createOrderAddProductButton =  new JButton("Add Product to Order");
	private JButton createOrderConfirmOrderButton = new JButton("Confirm Order");
	private JTextArea createOrderScrollPaneTextArea = new JTextArea();
	//=====
	//viewOrder Panel components
	private JButton viewOrderViewAllOrdersButton = new JButton("View All");
	private JButton viewOrderViewDeliveredButton = new JButton("View Delivered Orders");
	private JButton viewOrderViewUndeliveredButton = new JButton("View Undelivered Order");
	private JLabel viewOrderOrderIdLabel = new JLabel("Order ID: ");
	private JButton viewOrderOrderIdButton = new JButton("Find order with this ID");	
	private JLabel viewOrderSupplierIdLabel = new JLabel("Supplier ID: ");
	private JButton viewOrderSupplierIdButton = new JButton("Find order with this Supplier");
	private JLabel viewOrderTitleLabel = new JLabel("Title: ");
	private JButton viewOrderTitleButton = new JButton("Find order containing a product with this title");	
	private JLabel viewOrderAuthorLabel = new JLabel("Author: ");
	private JButton viewOrderAuthorButton = new JButton("Find order containing a product by this author");	
	private JTextArea viewOrderTextArea;
	private JTextField viewOrderOrderIdTextField = new JTextField();
	private JTextField viewOrderSupplierIdTextField = new JTextField();
	private JTextField viewOrderTitleTextField = new JTextField();
	private JTextField viewOrderAuthorTextField = new JTextField();
	//Edit Order Components
	private JPanel findOrderComponentsJPanel = new JPanel();
	private JPanel editOrderComponentsJPanel = new JPanel();
	private JPanel editSupplierOrderComponentsJPanel = new JPanel();
	private JPanel saveOrderComponentsJPanel = new JPanel();
	private JPanel editOrderProductsComponentsJPanel = new JPanel();
	private JTextField editOrderJTextField = new JTextField("Order Id");
	private JTextArea supplierOrderJTextArea = new JTextArea(10,20);
	private JTextArea productOrderJTextArea = new JTextArea();
	private JTextField allOrdersTotalJTextField = new JTextField("Total Owed");
	private JButton deliverAllOrdersJButton = new JButton("Deliver All Orders");
	private JButton editOrderJButton = new JButton("Find Order by Id");
	private JTextField editSupplierOrderJTextField = new JTextField("Supplier Id");
	private JButton editSupplierOrderJButton = new JButton("Find Order by Supplier");
	private JTextField editOrderId = new JTextField("Edit Order Id:");
	private JTextField editOrderSupplier = new JTextField("Edit Order Customer");
	private JButton deliverOrderJButton = new JButton("Deliver Order");
	private JButton saveOrderJButton = new JButton("Update Order");
	private JButton deleteOrderJButton = new JButton("Delete Order");
	private JTextField editOrderDeliveredStatus = new JTextField("");	
	private JTextField editOrderAmount = new JTextField("Edit Order Amount");
	//=========================================================================
	Dimension d = new Dimension(230, 30);
	
	public RetailGUI() {
		//TODO Jump to Constructor
		//add some test employees to array list
		employees.add(new Employee(123, "John", 0, 2000.00, 1111));
		employees.add( new Employee(234, "Tim", 1, 1500.00, 3333));
		//add some test customers to array list
		customers.add(new Customer(1, "Sam", "Dublin"));
		customers.add(new Customer(2, "Tom", "Cork"));
		customers.add(new Customer(3, "Mary", "Kildare"));
		customers.add(new Customer(4, "Trish", "Dublin"));
		customers.add(new Customer(5, "Chris", "Cork"));
		customers.add(new Customer(6, "Billy", "Waterford"));
		//add some test suppliers to array list
		suppliers.add(new Supplier(1, "Smiths", "Dublin","sam@email.com","123456"));
		suppliers.add(new Supplier(2, "Thompsons", "Cork","tom@email.com","234567"));
		suppliers.add(new Supplier(3, "Randome", "Dublin", "randome@email.com", "789654"));
		suppliers.add(new Supplier(4, "Sealion", "Limerick", "sealion@email.com", "987654" ));
		suppliers.add(new Supplier(5, "Salmon", "Athlone", "salmon@email.com", "258963"));
		suppliers.add(new Supplier(6, "Beales", "Dublin", "beales@email.com", "369852"));
		suppliers.add(new Supplier(7, "Buzzco", "Cork", "buzzco@email.com", "147852"));
		suppliers.add(new Supplier(8, "Vantage", "Waterford", "vantage@email.com", "255856"));
	
		
		//add some test products to array list
		//(String title, String author, String productCode,double retailPrice, double costPrice, int currentStock, int maxStock, int minStock, Supplier supplier)
		products.add(new Product("Game of Thrones", "George R.R Martin", "0001", 9.99, 3.75,100,200,15, suppliers.get(0)));
		products.add(new Product("Not a Drill", "Lee Child", "0002", 12.75, 4.95,221,200,10, suppliers.get(1)));
		products.add(new Product("Harry Potter", "j.k rowling", "0003", 11.99, 2.95,9,100,10,suppliers.get(2)));
		products.add(new Product("Tara Road", "Maeve Binchy", "0004", 11.99, 2.04,20,30,10,suppliers.get(1)));
		products.add(new Product("Echoes", "Maeve Binchy", "0005", 14.99, 1.96,20,30,10,suppliers.get(3)));
		products.add(new Product("The Glass Lake", "Maeve Binchy", "0006", 16.99, 2.98,20,30,10,suppliers.get(7)));
		products.add(new Product("Heart and Soul", "Maeve Binchy", "0007", 17.99, 2.97,20,30,10,suppliers.get(3)));
		products.add(new Product("Light a Penny Candle", "Maeve Binchy", "0008", 11.99, 3.05,20,30,10,suppliers.get(2)));
		products.add(new Product("Die Trying", "Lee Child", "0009", 10.99, 2.54,15,20,5,suppliers.get(2)));
		products.add(new Product("The Enemy", "Lee Child", "0010", 11.99, 2.95,15,20,5,suppliers.get(2)));
		products.add(new Product("One Shot", "Lee Child", "0011", 12.99, 2.83,15,20,5,suppliers.get(0)));
		products.add(new Product("61 Hours", "Lee Child", "0012", 14.99, 2.78,15,20,5,suppliers.get(3)));
		products.add(new Product("The Book Thief", "Khaled Hosseini", "0013", 8.99, 3.17,9,30,10,suppliers.get(4)));
		products.add(new Product("The Hunger Games", "Suzanne Collins", "0014", 8.99, 1.97,30,25,10,suppliers.get(4)));
		products.add(new Product("The Help", "Kathryn Stockett", "0015", 10.99, 2.51,10,20,10,suppliers.get(4)));
		products.add(new Product("Life of Pi", "Yann Martel", "0016", 9.99, 2.12,10,10,10,suppliers.get(0)));
		products.add(new Product("Catching Fire (The Hunger Games #2)", "Suzanne Collins", "0017", 10.99, 1.95,9,100,10,suppliers.get(3)));
		products.add(new Product("The Girl with the Dragon Tatto", "Steig Larsson", "0018", 9.99, 1.98,15,20,10,suppliers.get(3)));
		products.add(new Product("Water for Elephants", "Sara Gruen", "0019", 11.99, 3.02,15,20,10,suppliers.get(0)));
		products.add(new Product("The Da Vinci Code", "Dan Brown", "0020", 7.99, 1.93,15,20,10,suppliers.get(4)));
		products.add(new Product("The Curious Incident of the Dog in the Night-Time", "Mark Haddon", "0021", 7.99, 1.92,15,20,10,suppliers.get(4)));
		//Add ArrayList of InvoiceProduct for Invoice Constructor
		invoiceProducts1.add(new InvoiceProduct(products.get(0), 5));
		invoiceProducts2.add(new InvoiceProduct(products.get(1), 10));
		invoiceProducts2.add(new InvoiceProduct(products.get(2), 8));
		invoiceProducts3.add(new InvoiceProduct(products.get(4), 20));
		invoiceProducts3.add(new InvoiceProduct(products.get(6), 10));
		invoiceProducts3.add(new InvoiceProduct(products.get(10), 15));
		invoiceProducts3.add(new InvoiceProduct(products.get(20), 5));
		//add some test invoices to array list
		invoices.add(new Invoice(1, employees.get(0), customers.get(0), invoiceProducts1));
		invoices.add(new Invoice(2, employees.get(1), customers.get(1), invoiceProducts2));
		invoices.add(new Invoice(3, employees.get(1), customers.get(2), invoiceProducts2));
		createInvoices();
		//add some test orders to array list
		orders.add(new Order(1, 1, new OrderProduct(products.get(0), 10)));
		orders.add(new Order(2, 2, new OrderProduct(products.get(1), 15)));
		
		
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
		loginComponentsJPanel.add(passwordTF = new JPasswordField("Password", 10));
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
		//mainJFrame.setBounds(0, 0, 800, 600);
		mainJFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		custJTabbedPane.add("View Customer Details", viewCustJPanel);
		custJTabbedPane.add("Edit Customer Details", editCustJPanel);
		
		supplyJTabbedPane.add("Create New Supplier",addSupplyJPanel);
		supplyJTabbedPane.add("View Supplier Details", viewSupplyJPanel);
		supplyJTabbedPane.add("Edit Supplier Details", editSupplyJPanel);
		
		prodJTabbedPane.add("Create New Product",addProductJPanel);
		prodJTabbedPane.add("View Product Details", viewProductDetailsPanel);
		prodJTabbedPane.add("Edit Product Details", editProductJPanel);	
		
		invJTabbedPane.add("Create New Invoice", createInvJPanel);
		invJTabbedPane.add("View Customer Invoice", viewInvJPanel);
		invJTabbedPane.add("Edit Customer Invoice", editInvJPanel);
		
		orderJTabbedPane.add("Create New Order", createOrderPanel);
		orderJTabbedPane.add("View Orders", viewOrderJPanel);
		orderJTabbedPane.add("Edit Orders", editOrderJPanel);
		
		accessJTabbedPane.add("Create Employee", employeeJPanel);
		accessJTabbedPane.add("View Employee", viewEmployeeJPanel);
		accessJTabbedPane.add("Edit Employee", editEmployeeJPanel);
		
		proflossJTabbedPane.add("Coming Soon", proflossJPanel);
		proflossJTabbedPane.setEnabled(false);	
		
		employeeJPanel.setLayout(new GridBagLayout());
		gc.gridx = 0;
		gc.gridy = 1;
		employeeId.setPreferredSize(d);
		employeeJPanel.add(employeeId, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		employeeIdField.setPreferredSize(d);
		employeeJPanel.add(employeeIdField, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		employeeName.setPreferredSize(d);
		employeeJPanel.add(employeeName, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		employeeNameField.setPreferredSize(d);
		employeeJPanel.add(employeeNameField, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		employeeAcess.setPreferredSize(d);
		employeeJPanel.add(employeeAcess, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		employeeAcessField.setPreferredSize(d);
		employeeJPanel.add(employeeAcessField, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		employeeSalary.setPreferredSize(d);
		employeeJPanel.add(employeeSalary, gc);
		gc.gridx = 0;
		gc.gridy = 8;
		employeeSalaryField.setPreferredSize(d);
		employeeJPanel.add(employeeSalaryField, gc);
		gc.gridx = 0;
		gc.gridy = 9;
		employeePassword.setPreferredSize(d);
		employeeJPanel.add(employeePassword, gc);
		gc.gridx = 0;
		gc.gridy = 10;
		employeePassField.setPreferredSize(d);
		employeeJPanel.add(employeePassField, gc);
		gc.gridx = 0;
		gc.gridy = 11;
		employeeJButton.setPreferredSize(d);
		employeeJPanel.add(employeeJButton, gc);
		viewEmployeeJPanel.setLayout(new GridBagLayout());
		gc.gridx = 0;
		gc.gridy = 1;
		viewEmpId.setPreferredSize(d);
		viewEmployeeJPanel.add(viewEmpId, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		viewEmpIdField.setPreferredSize(d);
		viewEmployeeJPanel.add(viewEmpIdField, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		viewEmpIdButton.setPreferredSize(d);
		viewEmployeeJPanel.add(viewEmpIdButton, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		viewEmpName.setPreferredSize(d);
		viewEmployeeJPanel.add(viewEmpName, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		viewEmpNameField.setPreferredSize(d);
		viewEmployeeJPanel.add(viewEmpNameField, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		viewEmpNameButton.setPreferredSize(d);
		viewEmployeeJPanel.add(viewEmpNameButton, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		viewEmpAll.setPreferredSize(d);
		viewEmployeeJPanel.add(viewEmpAll, gc);
		gc.gridx = 0;
		gc.gridy = 8;
		viewEmpAllButton.setPreferredSize(d);
		viewEmployeeJPanel.add(viewEmpAllButton, gc);
		gc.gridx = 0;
		gc.gridy = 9;
		JScrollPane empScrollPane = new JScrollPane(empJTextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		viewEmployeeJPanel.add(empScrollPane, gc);
		
		editEmployeeJPanel.setLayout(new GridBagLayout());
		gc.gridx = 0;
		gc.gridy = 1;
		editFindById.setPreferredSize(d);
		editEmployeeJPanel.add(editFindById, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		editFindByIdField.setPreferredSize(d);
		editEmployeeJPanel.add(editFindByIdField, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		editById.setPreferredSize(d);
		editEmployeeJPanel.add(editById, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		editEmpId.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpId, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		editEmpIdField.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpIdField, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		editEmpName.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpName, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		editEmpNameField.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpNameField, gc);
		gc.gridx = 0;
		gc.gridy = 8;
		editEmpAccess.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpAccess, gc);
		gc.gridx = 0;
		gc.gridy = 9;
		editEmpAccessField.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpAccessField, gc);
		gc.gridx = 0;
		gc.gridy = 10;
		editEmpSalary.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpSalary, gc);
		gc.gridx = 0;
		gc.gridy = 11;
		editEmpSalaryField.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpSalaryField, gc);
		gc.gridx = 0;
		gc.gridy = 12;
		editEmpPassword.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpPassword, gc);
		gc.gridx = 0;
		gc.gridy = 13;
		editEmpPasswordField.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpPasswordField, gc);
		gc.gridx = 0;
		gc.gridy = 14;
		updateEmployee.setPreferredSize(d);
		editEmployeeJPanel.add(updateEmployee, gc);
		gc.gridx = 0;
		gc.gridy = 15;
		deleteEmployee.setPreferredSize(d);
		editEmployeeJPanel.add(deleteEmployee, gc);

		
		employeeJButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Employee employee = new Employee(Integer.parseInt(employeeIdField.getText()),employeeNameField.getText(), Integer.parseInt(employeeAcessField.getText()), Double.parseDouble(employeeSalaryField.getText()), Integer.parseInt(employeePassField.getText()));
				employees.add(employee);
			}

		});
		
		viewEmpIdButton.addActionListener(new ActionListener(){
			// function to view a customer by id or name
			public void actionPerformed(ActionEvent e){
			if(employees.size() >= 1){
					try{
						for(Employee employee: employees){
						if(employee.getEmployeeId() == Integer.parseInt(viewEmpIdField.getText())){
							empJTextArea.setText("Employee ID: "+employee.getEmployeeId()
									+"\n Employee Name: " +employee.getEmployeeName() 
									+"\n Employee Access Level: " +employee.getAccess()
									+"\n Employee Password: " +employee.getPassword()
									+"\n Employee Salary: " +employee.getSalary());
							}
						}
					}catch(NumberFormatException nfe){
						JOptionPane.showMessageDialog(null, "Employee Id should be a number.");
					}
				}else{
					JOptionPane.showMessageDialog(null, "No Employees Found");
				}
			}
		});
		
		viewEmpNameButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				// view by employee name
				for(Employee employee: employees){
					if(employee.getEmployeeName().equalsIgnoreCase(viewEmpNameField.getText())){
						empJTextArea.setText("Employee ID: "+employee.getEmployeeId()
					+"\n Employee Name: " +employee.getEmployeeName() 
					+"\n Employee Access Level: " +employee.getAccess()
					+"\n Employee Password: " +employee.getPassword()
					+"\n Employee Salary: " +employee.getSalary());
					}
				}
			}

		});
		
		viewEmpAllButton.addActionListener(new ActionListener(){
			// function to view all employees
			public void actionPerformed(ActionEvent e){
				empJTextArea.setText(null);
					if(employees.size() >= 1){
						for(Employee employee: employees){
							empJTextArea.append("\n Employee ID: "+employee.getEmployeeId()
							+"\n Employee Name: " +employee.getEmployeeName() 
							+"\n Employee Access Level: " +employee.getAccess()
							+"\n Employee Password: " +employee.getPassword()
							+"\n Employee Salary: " +employee.getSalary()+"\n");
						}
					}else{
						JOptionPane.showMessageDialog(null, "No Customers Found");
					}
			}
		});
		
		editById.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					for(Employee employee: employees){
						if(employee.getEmployeeId() == Integer.parseInt(editFindByIdField.getText())){
							editEmpIdField.setText(Integer.toString(employee.getEmployeeId()));
							editEmpNameField.setText(employee.getEmployeeName());
							editEmpAccessField.setText(Integer.toString(employee.getAccess()));
							editEmpSalaryField.setText(Double.toString(employee.getSalary()));
							editEmpPasswordField.setText(Integer.toString(employee.getPassword()));
						}
					}
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Customer Id should be a number.");
				}
			}
		});
		
		updateEmployee.addActionListener(new ActionListener(){
			//update a specific customer
			public void actionPerformed(ActionEvent e){
				try{
					for(Employee employee: employees){
						if(employee.getEmployeeId() == Integer.parseInt(editFindByIdField.getText())){
							employee.setEmployeeId(Integer.parseInt(editEmpIdField.getText()));
							employee.setEmployeeName(editEmpNameField.getText());
							employee.setAccess(Integer.parseInt(editEmpAccessField.getText()));
							employee.setSalary(Double.parseDouble(editEmpSalaryField.getText()));
							employee.setPassword(Integer.parseInt(editEmpPasswordField.getText()));
							JOptionPane.showMessageDialog(null, "Employee Updated");
						}
					}
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Customer Id should be a number.");
				}
			}
		});
		
		deleteEmployee.addActionListener(new ActionListener(){
			//delete function for employee
			public void actionPerformed(ActionEvent arg){
				try{
					for(Employee employee: employees){
						if(employee.getEmployeeId() == Integer.parseInt(editFindByIdField.getText())){
							employees.remove(employee);
							JOptionPane.showMessageDialog(null, "Employee Deleted");
						}
					}
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Employee Id should be a number.");
				}
			}
		});
		
		addCustJPanel.setLayout(new GridBagLayout());
		viewCustJPanel.setLayout(new GridBagLayout());
		editCustJPanel.setLayout(new GridBagLayout());
		gc.gridx = 0;
		gc.gridy = 1;
		custIdJLabel.setPreferredSize(d);
		addCustJPanel.add(custIdJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		custIdJTextField.setPreferredSize(d);
		addCustJPanel.add(custIdJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		addCustJPanel.add(custNameJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		custNameJTextField.setPreferredSize(d);
		addCustJPanel.add(custNameJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		custAddressJLabel.setPreferredSize(d);
		addCustJPanel.add(custAddressJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		custAddressJTextField.setPreferredSize(d);
		addCustJPanel.add(custAddressJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		custEmailJLabel.setPreferredSize(d);
		addCustJPanel.add(custEmailJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 8;
		custEmailJTextField.setPreferredSize(d);
		addCustJPanel.add(custEmailJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 9;
		custPhoneJLabel.setPreferredSize(d);
		addCustJPanel.add(custPhoneJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 10;
		custPhoneJTextField.setPreferredSize(d);
		addCustJPanel.add(custPhoneJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 11;
		custJButton.setPreferredSize(d);
		addCustJPanel.add(custJButton, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		viewCustById.setPreferredSize(d);
		viewCustJPanel.add(viewCustById, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		custById.setPreferredSize(d);
		viewCustJPanel.add(custById, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		viewCustByName.setPreferredSize(d);
		viewCustJPanel.add(viewCustByName, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		custByName.setPreferredSize(d);
		viewCustJPanel.add(custByName, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		viewCustJButton.setPreferredSize(d);
		viewCustJPanel.add(viewCustJButton, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		viewAllCustJButton.setPreferredSize(d);
		viewCustJPanel.add(viewAllCustJButton, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		JScrollPane custScrollPane = new JScrollPane(custJTextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		viewCustJPanel.add(custScrollPane, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		editFindCustIdJLabel.setPreferredSize(d);
		editCustJPanel.add(editFindCustIdJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		editCustById.setPreferredSize(d);
		editCustJPanel.add(editCustById, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		findCustById.setPreferredSize(d);
		editCustJPanel.add(findCustById, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		editCustIdJLabel.setPreferredSize(d);
		editCustJPanel.add(editCustIdJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		editCustId.setPreferredSize(d);
		editCustJPanel.add(editCustId, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		editCustNameJLabel.setPreferredSize(d);
		editCustJPanel.add(editCustNameJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		editCustName.setPreferredSize(d);
		editCustJPanel.add(editCustName, gc);
		gc.gridx = 0;
		gc.gridy = 8;
		editCustAddressJLabel.setPreferredSize(d);
		editCustJPanel.add(editCustAddressJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 9;
		editCustAddress.setPreferredSize(d);
		editCustJPanel.add(editCustAddress, gc);
		gc.gridx = 0;
		gc.gridy = 10;
		editCustEmailJLabel.setPreferredSize(d);
		editCustJPanel.add(editCustEmailJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 11;
		editCustEmail.setPreferredSize(d);
		editCustJPanel.add(editCustEmail, gc);
		gc.gridx = 0;
		gc.gridy = 12;
		editCustPhoneJLabel.setPreferredSize(d);
		editCustJPanel.add(editCustPhoneJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 13;
		editCustPhone.setPreferredSize(d);
		editCustJPanel.add(editCustPhone, gc);
		gc.gridx = 0;
		gc.gridy = 14;
		updateCustJButton.setPreferredSize(d);
		editCustJPanel.add(updateCustJButton, gc);
		gc.gridx = 0;
		gc.gridy = 15;
		deleteCustJButton.setPreferredSize(d);
		editCustJPanel.add(deleteCustJButton, gc);
		
		
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
					if(customers.size() >= 1){
						for(Customer customer: customers){
							
							custJTextArea.append("\n Customer Id: "+customer.getCustId()
										+"\n Customer Name: "+customer.getCustName()
										+"\n Customer Address: "+customer.getCustAddress()
										+"\n Customer Email: "+customer.getCustEmail()
										+"\n Customer Phone: "+customer.getCustTelephone()
										+"\n");
						}
					}else{
						JOptionPane.showMessageDialog(null, "No Customers Found");
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
			
		addSupplyJPanel.setLayout(new GridBagLayout());
		viewSupplyJPanel.setLayout(new GridBagLayout());
		editSupplyJPanel.setLayout(new GridBagLayout());
		
		gc.gridx = 0;
		gc.gridy = 1;
		supplierIdJLabel.setPreferredSize(d);
		addSupplyJPanel.add(supplierIdJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		supplierIdJTextField.setPreferredSize(d);
		addSupplyJPanel.add(supplierIdJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		supplierNameJLabel.setPreferredSize(d);
		addSupplyJPanel.add(supplierNameJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		supplierNameJTextField.setPreferredSize(d);
		addSupplyJPanel.add(supplierNameJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		supplierAddressJLabel.setPreferredSize(d);
		addSupplyJPanel.add(supplierAddressJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		supplierAddressJTextField.setPreferredSize(d);
		addSupplyJPanel.add(supplierAddressJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		supplierEmailJLabel.setPreferredSize(d);
		addSupplyJPanel.add(supplierEmailJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 8;
		supplierEmailJTextField.setPreferredSize(d);
		addSupplyJPanel.add(supplierEmailJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 9;
		supplierPhoneJLabel.setPreferredSize(d);
		addSupplyJPanel.add(supplierPhoneJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 10;
		supplierPhoneJTextField.setPreferredSize(d);
		addSupplyJPanel.add(supplierPhoneJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 11;
		supplierJButton.setPreferredSize(d);
		addSupplyJPanel.add(supplierJButton, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		viewSupplyJLabel.setPreferredSize(d);
		viewSupplyJPanel.add(viewSupplyJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		viewSupplyJTextField.setPreferredSize(d);
		viewSupplyJPanel.add(viewSupplyJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		viewSupplyNameJLabel.setPreferredSize(d);
		viewSupplyJPanel.add(viewSupplyNameJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		viewSupplyNameJTextField.setPreferredSize(d);
		viewSupplyJPanel.add(viewSupplyNameJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		viewSupplyJButton.setPreferredSize(d);
		viewSupplyJPanel.add(viewSupplyJButton, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		allSupplyJButton.setPreferredSize(d);
		viewSupplyJPanel.add(allSupplyJButton, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		JScrollPane suppJScrollPane = new JScrollPane(supplierJTextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		viewSupplyJPanel.add(suppJScrollPane, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		editFindSuppIdJLabel.setPreferredSize(d);
		editSupplyJPanel.add(editFindSuppIdJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		editSupplierJTextField.setPreferredSize(d);
		editSupplyJPanel.add(editSupplierJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		editSupplierJButton.setPreferredSize(d);
		editSupplyJPanel.add(editSupplierJButton, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		editSuppIdJLabel.setPreferredSize(d);
		editSupplyJPanel.add(editSuppIdJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		editSupplierId.setPreferredSize(d);
		editSupplyJPanel.add(editSupplierId, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		editSuppNameJLabel.setPreferredSize(d);
		editSupplyJPanel.add(editSuppNameJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		editSupplierName.setPreferredSize(d);
		editSupplyJPanel.add(editSupplierName, gc);
		gc.gridx = 0;
		gc.gridy = 8;
		editSuppAddressJLabel.setPreferredSize(d);
		editSupplyJPanel.add(editSuppAddressJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 9;
		editSupplierAddress.setPreferredSize(d);
		editSupplyJPanel.add(editSupplierAddress, gc);
		gc.gridx = 0;
		gc.gridy = 10;
		editSuppEmailJLabel.setPreferredSize(d);
		editSupplyJPanel.add(editSuppEmailJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 11;
		editSupplierEmail.setPreferredSize(d);
		editSupplyJPanel.add(editSupplierEmail, gc);
		gc.gridx = 0;
		gc.gridy = 12;
		editSuppPhoneJLabel.setPreferredSize(d);
		editSupplyJPanel.add(editSuppPhoneJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 13;
		editSupplierPhone.setPreferredSize(d);
		editSupplyJPanel.add(editSupplierPhone, gc);
		gc.gridx = 0;
		gc.gridy = 14;
		editDeliveryJLabel.setPreferredSize(d);
		editSupplyJPanel.add(editDeliveryJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 15;
		editSupplierDelivery.setPreferredSize(d);
		editSupplyJPanel.add(editSupplierDelivery, gc);
		gc.gridx = 0;
		gc.gridy = 16;
		saveSupplierJButton.setPreferredSize(d);
		editSupplyJPanel.add(saveSupplierJButton, gc);
		gc.gridx = 0;
		gc.gridy = 17;
		deleteSupplierJButton.setPreferredSize(d);
		editSupplyJPanel.add(deleteSupplierJButton, gc);

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
					if(suppliers.size() >= 1){
						for(Supplier supplier: suppliers){
							supplierJTextArea.append("\n Supplier Id: "+supplier.getId()
									+"\n Supplier Name: "+supplier.getName()
									+"\n Supplier Address: "+supplier.getAddress()
									+"\n Supplier Email: "+supplier.getEmail()
									+"\n Supplier Phone: "+supplier.getPhone()
									+"\n Supplier Delivery Time: "+supplier.getDaysToDeliver()+"\n");
						}
					}else{
						JOptionPane.showMessageDialog(null, "No Suppliers Found");
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
		addProductJPanel.setLayout(new GridBagLayout());
		gc.gridx = 0;
		gc.gridy = 1;
		prodTitle.setPreferredSize(d);
		addProductJPanel.add(prodTitle, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		titleJTextField.setPreferredSize(d);
		addProductJPanel.add(titleJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		prodAuthor.setPreferredSize(d);
		addProductJPanel.add(prodAuthor, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		authorJTextField.setPreferredSize(d);
		addProductJPanel.add(authorJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		prodCode.setPreferredSize(d);
		addProductJPanel.add(prodCode, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		codeJTextField.setPreferredSize(d);
		addProductJPanel.add(codeJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		prodRetail.setPreferredSize(d);
		addProductJPanel.add(prodRetail, gc);
		gc.gridx = 0;
		gc.gridy = 8;
		retailJTextField.setPreferredSize(d);
		addProductJPanel.add(retailJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 9;
		prodCost.setPreferredSize(d);
		addProductJPanel.add(prodCost, gc);
		gc.gridx = 0;
		gc.gridy = 10;
		costJTextField.setPreferredSize(d);
		addProductJPanel.add(costJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 11;
		prodTotalStock.setPreferredSize(d);
		addProductJPanel.add(prodTotalStock, gc);
		gc.gridx = 0;
		gc.gridy = 12;
		tStockJTextField.setPreferredSize(d);
		addProductJPanel.add(tStockJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 13;
		prodMaxStock.setPreferredSize(d);
		addProductJPanel.add(prodMaxStock, gc);
		gc.gridx = 0;
		gc.gridy = 14;
		maxJTextField.setPreferredSize(d);
		addProductJPanel.add(maxJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 15;
		prodMinStock.setPreferredSize(d);
		addProductJPanel.add(prodMinStock, gc);
		gc.gridx = 0;
		gc.gridy = 16;
		minJTextField.setPreferredSize(d);
		addProductJPanel.add(minJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 17;
		prodSupplierId.setPreferredSize(d);
		addProductJPanel.add(prodSupplierId, gc);
		gc.gridx = 0;
		gc.gridy = 18;
		prodSupplierIdJTextField.setPreferredSize(d);
		addProductJPanel.add(prodSupplierIdJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 19;
		productJButton.setPreferredSize(d);
		addProductJPanel.add(productJButton, gc);
		
		priceRange.add(under5Radio);
		priceRange.add(fiveTo10Radio);
		priceRange.add(tenTo20Radio);
		priceRange.add(over20Radio);
		
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
		
		editProductJPanel.setLayout(new GridBagLayout());
		gc.gridx = 0;
		gc.gridy = 1;
		editDetails.setPreferredSize(d);
		editProductJPanel.add(editDetails, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		enterProdCodeJTextField.setPreferredSize(d);
		editProductJPanel.add(enterProdCodeJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		editDetailsJButton.setPreferredSize(d);
		editProductJPanel.add(editDetailsJButton, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		editProdTitle.setPreferredSize(d);
		editProductJPanel.add(editProdTitle, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		editTitleJTextField.setPreferredSize(d);
		editProductJPanel.add(editTitleJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		editProdAuthor.setPreferredSize(d);
		editProductJPanel.add(editProdAuthor, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		editAuthorJTextField.setPreferredSize(d);
		editProductJPanel.add(editAuthorJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 8;
		editProdCode.setPreferredSize(d);
		editProductJPanel.add(editProdCode, gc);
		gc.gridx = 0;
		gc.gridy = 9;
		editCodeJTextField.setPreferredSize(d);
		editProductJPanel.add(editCodeJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 10;
		editProdRetail.setPreferredSize(d);
		editProductJPanel.add(editProdRetail, gc);
		gc.gridx = 0;
		gc.gridy = 11;
		editRetailJTextField.setPreferredSize(d);
		editProductJPanel.add(editRetailJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 12;
		editProdCost.setPreferredSize(d);
		editProductJPanel.add(editProdCost, gc);
		gc.gridx = 0;
		gc.gridy = 13;
		editCostJTextField.setPreferredSize(d);
		editProductJPanel.add(editCostJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 14;
		editProdTotalStock.setPreferredSize(d);
		editProductJPanel.add(editProdTotalStock, gc);
		gc.gridx = 0;
		gc.gridy = 15;
		editStockJTextField.setPreferredSize(d);
		editProductJPanel.add(editStockJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 16;
		editProdMaxStock.setPreferredSize(d);
		editProductJPanel.add(editProdMaxStock, gc);
		gc.gridx = 0;
		gc.gridy = 17;
		editMaxJTextField.setPreferredSize(d);
		editProductJPanel.add(editMaxJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 18;
		editProdMinStock.setPreferredSize(d);
		editProductJPanel.add(editProdMinStock, gc);
		gc.gridx = 0;
		gc.gridy = 19;
		editMinJTextField.setPreferredSize(d);
		editProductJPanel.add(editMinJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 20;
		editProdSupplierId.setPreferredSize(d);
		editProductJPanel.add(editProdSupplierId, gc);
		gc.gridx = 0;
		gc.gridy = 21;
		editProdSupplierIdJTextField.setPreferredSize(d);
		editProductJPanel.add(editProdSupplierIdJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 22;
		updateProductJButton.setPreferredSize(d);
		editProductJPanel.add(updateProductJButton, gc);
		gc.gridx = 0;
		gc.gridy = 23;
		deleteStockLineJButton.setPreferredSize(d);
		editProductJPanel.add(deleteStockLineJButton, gc);
		
		
		//add edit invoice components	
		findInvoiceComponentsJPanel.setLayout(new GridBagLayout());
		gc.gridx = 0;
		gc.gridy = 1;
		editInvoiceJTextField.setPreferredSize(d);
		findInvoiceComponentsJPanel.add(editInvoiceJTextField, gc);
		editInvoiceJTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			editInvoiceJTextField.setText("");
			}
		});
		gc.gridx = 0;
		gc.gridy = 2;
		editInvoiceJButton.setPreferredSize(d);
		findInvoiceComponentsJPanel.add(editInvoiceJButton, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		editCustomerInvoiceJTextField.setPreferredSize(d);
		findInvoiceComponentsJPanel.add(editCustomerInvoiceJTextField, gc);
		editCustomerInvoiceJTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			editCustomerInvoiceJTextField.setText("");
			}
		});
		gc.gridx = 0;
		gc.gridy = 4;
		editCustomerInvoiceJButton.setPreferredSize(d);
		findInvoiceComponentsJPanel.add(editCustomerInvoiceJButton, gc);
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
		JScrollPane invoiceProductsJScrollPane = new JScrollPane(productInvoiceJTextArea);
		invoiceProductsJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		editInvoiceProductsComponentsJPanel.add(invoiceProductsJScrollPane);
		editInvoiceProductsComponentsJPanel.setLayout(new GridLayout(1,2));
		productInvoiceJTextArea.setEditable(false);
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
		editInvJPanel.setLayout(new GridLayout(5,3));
		editInvJPanel.add(findInvoiceComponentsJPanel);
		editInvJPanel.add(editInvoiceComponentsJPanel);
		editInvJPanel.add(editInvoiceProductsComponentsJPanel);
		editInvJPanel.add(saveInvoiceComponentsJPanel);
		editInvJPanel.add(editCustomerInvoiceComponentsJPanel);
		editInvoiceProductsComponentsJPanel.setVisible(false);
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
		createNewOrderLeftPanel.add(createOrderOrderIdLabel,orderGC);
		orderGC.gridx = 1;
		orderGC.gridy = 0;
		createOrderOrderIdTextField.setPreferredSize(d);
		createNewOrderLeftPanel.add(createOrderOrderIdTextField,orderGC);
		//=====
		orderGC.gridx = 0;
		orderGC.gridy = 1;
		createNewOrderLeftPanel.add(createOrderSupplierIdLabel,orderGC);
		orderGC.gridx = 1;
		orderGC.gridy = 1;
		createOrderSupplierIdTextField.setPreferredSize(d);
		createNewOrderLeftPanel.add(createOrderSupplierIdTextField,orderGC);
		//=====
		orderGC.gridx = 0;
		orderGC.gridy = 2;
		createNewOrderLeftPanel.add(createOrderProductCodeLabel,orderGC);
		orderGC.gridx = 1;
		orderGC.gridy = 2;
		createOrderProductCodeTextField.setPreferredSize(d);
		createNewOrderLeftPanel.add(createOrderProductCodeTextField,orderGC);
		//=====
		orderGC.gridx = 0;
		orderGC.gridy = 3;
		createNewOrderLeftPanel.add(createOrderQuantityLabel,orderGC);
		orderGC.gridx = 1;
		orderGC.gridy = 3;
		createOrderQuantityTextField.setPreferredSize(d);
		createNewOrderLeftPanel.add(createOrderQuantityTextField,orderGC);
		//=====
		orderGC.gridx = 0;
		orderGC.gridy = 4;
		createOrderAddProductButton.setPreferredSize(d);
		createNewOrderLeftPanel.add(createOrderAddProductButton,orderGC);
		orderGC.gridx = 1;
		orderGC.gridy = 4;
		orderGC.weighty = 10;
		createOrderConfirmOrderButton.setPreferredSize(d);
		createNewOrderLeftPanel.add(createOrderConfirmOrderButton,orderGC);
		JButton resetOrderPanelButton = new JButton("Reset Fields");
		gc.gridx = 1;
		gc.gridy = 5;
		resetOrderPanelButton.setPreferredSize(d);
		createNewOrderLeftPanel.add(resetOrderPanelButton,gc);
		resetOrderPanelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				createOrderOrderIdTextField.setText("");
				createOrderSupplierIdTextField.setText("");
				createOrderProductCodeTextField.setText("");
				createOrderQuantityTextField.setText("");
				createOrderOrderIdTextField.setEnabled(true);
				createOrderSupplierIdTextField.setEnabled(true);
				createOrderScrollPaneTextArea.setText("");
				createOrderScrollPaneTextArea.setCaretPosition(0);
				
			}
		});
		//TextPane
		createOrderScrollPaneTextArea = new JTextArea(20,20); //height - width
		createOrderScrollPaneTextArea.setEditable(false);
		JScrollPane orderScrollPane = new JScrollPane(createOrderScrollPaneTextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
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
		createOrderAddProductButton.addActionListener(new ActionListener() {
			//TODO Create Order, add product to order
			@Override
			public void actionPerformed(ActionEvent e) {
				String orderId = createOrderOrderIdTextField.getText();
				String supplierId = createOrderSupplierIdTextField.getText();
				String productCode = createOrderProductCodeTextField.getText();
				String quantity = createOrderQuantityTextField.getText();
				if((orderId.trim().equals("") || orderId.matches(".*\\D.*")) ||
						(supplierId.trim().equals("") || supplierId.matches(".*\\D.*")) ||
							(productCode.trim().equals("") || productCode.matches(".*\\D.*")) ||
								(quantity.trim().equals("") || quantity.matches(".*\\D.*"))){
									JOptionPane.showMessageDialog (null, "Please ensure all text fields have been filled", "Missing Info", JOptionPane.WARNING_MESSAGE);
				}else{
					//disable the other text fields
					createOrderOrderIdTextField.setEnabled(false);
					createOrderSupplierIdTextField.setEnabled(false);
					
					//Add to 'addMoreArrayList'
					Product p = invoice.returnProductObject(productCode, products);
					int quantity1 = Integer.parseInt(quantity);
					if(p!=null){
						OrderProduct orderProduct = new OrderProduct(p, quantity1);
						addMoreProducts.add(orderProduct);
						
						for(OrderProduct prod : addMoreProducts){
						result += "Product No: " + prod.getProduct().getProductCode() +"\nQuantity: " + prod.getQuantity() + "\n\n";
						}
						createOrderScrollPaneTextArea.setText(result);
						createOrderScrollPaneTextArea.setCaretPosition(0);
						result = "";
					}
					else{
						JOptionPane.showMessageDialog (null, "No Product Record exist with that Input", "Product Info", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		createOrderConfirmOrderButton.addActionListener(new ActionListener() {
			//TODO Create Order Finish Order
			@Override
			public void actionPerformed(ActionEvent e) {
				String orderIdString = createOrderOrderIdTextField.getText();
				String supplierIdString = createOrderSupplierIdTextField.getText();
				String productCodeString = createOrderProductCodeTextField.getText();
				String quantityString = createOrderQuantityTextField.getText();

				if((orderIdString.trim().equals("")||orderIdString.matches(".*\\D.*"))
					||	(supplierIdString.trim().equals("")||supplierIdString.matches(".*\\D.*"))
					||	(productCodeString.trim().equals(""))
					||	(quantityString.trim().equals("")||quantityString.matches(".*\\D.*"))){
					JOptionPane.showMessageDialog (null, "Please ensure all text fields have been filled", "Missing Info", JOptionPane.WARNING_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog (null, "In the else loop", "Missing Info", JOptionPane.WARNING_MESSAGE);
					int orderId = Integer.parseInt(orderIdString);
					int supplierId = Integer.parseInt(supplierIdString);
					int productCode = Integer.parseInt(productCodeString);
					int quantity = Integer.parseInt(quantityString);	
					//Now need to check that supplier and product exist
					boolean supplierExists = false;
					for(Supplier supp: suppliers){
						if(supp.getId() == supplierId){
							supplierExists = true;
							break;
						}
					}
					boolean productExists = false;
					for(Product prod: products){
						if(Integer.parseInt(prod.getProductCode()) == productCode){
							productExists = true;
							break;
						}
					}
					//create an arrayList of Order products which is required for Order Constructor
					Product productObject = invoice.returnProductObject(productCodeString, products);
					ArrayList<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
					OrderProduct orderProd = new OrderProduct(productObject, quantity);
					orderProducts.add(orderProd);
					
					if(supplierExists){
						JOptionPane.showMessageDialog (null, "in supplier", "Missing Info", JOptionPane.WARNING_MESSAGE);
						if(productExists){
							JOptionPane.showMessageDialog (null, "in order", "Missing Info", JOptionPane.WARNING_MESSAGE);
							if(orderNumberUnique(orderId, orders)){
								
								//All checks passed, create Invoice
								if(addMoreProducts.size()<1){
								Order singleOrderComplete = new Order(orderId, supplierId, orderProducts);
								orders.add(singleOrderComplete);
								}else{
									Order multipleOrder = new Order(orderId, supplierId, orderProducts);
									orders.add(multipleOrder);
								}
								JOptionPane.showMessageDialog(null, "Order complete!");
								createOrderOrderIdTextField.setEnabled(true);
								createOrderSupplierIdTextField.setEnabled(true);
								createOrderOrderIdTextField.setText("");
								createOrderSupplierIdTextField.setText("");
								createOrderProductCodeTextField.setText("");
								createOrderQuantityTextField.setText("");
								createOrderScrollPaneTextArea.setText("");
								createOrderScrollPaneTextArea.setCaretPosition(0);
								addMoreProducts = new ArrayList<OrderProduct>();
							}else{
								JOptionPane.showMessageDialog (null, "Order Number is not Unique", "Order Info", JOptionPane.WARNING_MESSAGE);
								}
							}else{
								JOptionPane.showMessageDialog (null, "No Product Record exists with that ID", "Product Info", JOptionPane.WARNING_MESSAGE);
								}
							}else{
								JOptionPane.showMessageDialog (null, "No Supplier Record exists with that ID", "Customer Info", JOptionPane.WARNING_MESSAGE);
							}
						}
					}
				}
			);
		//createNewOrderComponents added.
		//viewOrder components: 
		Dimension d2 = new Dimension(300, 30);
		Dimension size1 = getPreferredSize();
		size1.width = 500;
		viewOrderJPanel.setPreferredSize(size1);
		viewOrderJPanel.setBorder(BorderFactory.createTitledBorder("Order details"));
		//====
		viewOrderLeftJPanel.setLayout(new GridBagLayout());
		viewOrderRightJPanel.setLayout(new GridBagLayout());
		viewOrderJPanel.setLayout(new GridLayout(1, 1));
		GridBagConstraints viewOrderGC = new GridBagConstraints();
		viewOrderGC.insets = new Insets(5,5,5,5);
		//====
		viewOrderGC.gridx = 0;
		viewOrderGC.gridy = 1;
		viewOrderViewAllOrdersButton.setPreferredSize(d);
		viewOrderLeftJPanel.add(viewOrderViewAllOrdersButton, viewOrderGC);
		viewOrderViewAllOrdersButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewOrderTextArea.setText(Order.viewAllOrders(orders));	
			}
		});
		//====
		viewOrderGC.gridx = 0;
		viewOrderGC.gridy = 2;
		viewOrderViewDeliveredButton.setPreferredSize(d);
		viewOrderLeftJPanel.add(viewOrderViewDeliveredButton, viewOrderGC);
		viewOrderViewDeliveredButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewOrderTextArea.setText(Order.viewDeliveredOrders(orders));	
			}
		});
		//====
		viewOrderGC.gridx = 0;
		viewOrderGC.gridy = 3;
		viewOrderViewUndeliveredButton.setPreferredSize(d);
		viewOrderLeftJPanel.add(viewOrderViewUndeliveredButton, viewOrderGC);
		viewOrderViewUndeliveredButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewOrderTextArea.setText(Order.viewUndeliveredOrders(orders));	
			}
		});
		//====
		viewOrderGC.gridx = 1;
		viewOrderGC.gridy = 1;
		viewOrderLeftJPanel.add(viewOrderOrderIdLabel, viewOrderGC);
		viewOrderGC.gridx = 2;
		viewOrderGC.gridy = 1;
		viewOrderOrderIdTextField.setPreferredSize(d);
		viewOrderLeftJPanel.add(viewOrderOrderIdTextField, viewOrderGC);
		viewOrderGC.gridx = 3;
		viewOrderGC.gridy = 1;
		viewOrderOrderIdButton.setPreferredSize(d2);
		viewOrderLeftJPanel.add(viewOrderOrderIdButton, viewOrderGC);
		viewOrderOrderIdButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = viewOrderOrderIdTextField.getText();
				if(input.trim().equals("") || input.matches(".*\\D.*")){
					viewOrderTextArea.setText("Please enter a valid number");
					viewOrderOrderIdTextField.setText("");
					viewOrderSupplierIdTextField.setText("");
				}else{
					int num = Integer.parseInt(input);
					viewOrderTextArea.setText(Order.viewByOrderId(orders, num)); 
					viewOrderOrderIdTextField.setText("");
					viewOrderSupplierIdTextField.setText("");
				}
			}
		});
		//====
		viewOrderGC.gridx = 1;
		viewOrderGC.gridy = 2;
		viewOrderLeftJPanel.add(viewOrderSupplierIdLabel,viewOrderGC);
		viewOrderGC.gridx = 2;
		viewOrderGC.gridy = 2;
		viewOrderSupplierIdTextField.setPreferredSize(d);
		viewOrderLeftJPanel.add(viewOrderSupplierIdTextField,viewOrderGC);
		viewOrderGC.gridx = 3;
		viewOrderGC.gridy = 2;
		viewOrderSupplierIdButton.setPreferredSize(d2);
		viewOrderLeftJPanel.add(viewOrderSupplierIdButton,viewOrderGC);
		viewOrderSupplierIdButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = viewOrderSupplierIdTextField.getText();
				if(input.trim().equals("") || input.matches(".*\\D.*")){ 
					viewOrderTextArea.setText("Please enter a valid number");
					viewOrderSupplierIdTextField.setText("");
					viewOrderOrderIdTextField.setText("");
				}else{
					int num = Integer.parseInt(input);
					viewOrderTextArea.setText(Order.viewOrderBySupplier(orders, num));	
					viewOrderSupplierIdTextField.setText("");
					viewOrderOrderIdTextField.setText("");
				}
			}
		});
		//====
		viewOrderGC.gridx = 1;
		viewOrderGC.gridy = 3;
		viewOrderLeftJPanel.add(viewOrderTitleLabel, viewOrderGC);
		viewOrderGC.gridx = 2;
		viewOrderGC.gridy = 3;
		viewOrderTitleTextField.setPreferredSize(d);
		viewOrderLeftJPanel.add(viewOrderTitleTextField, viewOrderGC);
		viewOrderGC.gridx = 3;
		viewOrderGC.gridy = 3;
		viewOrderTitleButton.setPreferredSize(d2);
		viewOrderLeftJPanel.add(viewOrderTitleButton, viewOrderGC);
		viewOrderTitleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = viewOrderTitleTextField.getText();
				if(input.trim().equals("")){ 
					viewOrderTextArea.setText("Please enter a title");
					viewOrderTitleTextField.setText("");
					viewOrderOrderIdTextField.setText("");
				}else{
					viewOrderTextArea.setText(Order.viewOrderByTitle(orders, input));	
					viewOrderTitleTextField.setText("");
					viewOrderOrderIdTextField.setText("");
				}
			}
		});
		//====
		viewOrderGC.gridx = 1;
		viewOrderGC.gridy = 4;
		viewOrderLeftJPanel.add(viewOrderAuthorLabel,viewOrderGC);
		viewOrderGC.gridx = 2;
		viewOrderGC.gridy = 4;
		viewOrderAuthorTextField.setPreferredSize(d);
		viewOrderLeftJPanel.add(viewOrderAuthorTextField,viewOrderGC);
		viewOrderGC.gridx = 3;
		viewOrderGC.gridy = 4;
		viewOrderAuthorButton.setPreferredSize(d2);
		viewOrderLeftJPanel.add(viewOrderAuthorButton,viewOrderGC);
		viewOrderAuthorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = viewOrderAuthorTextField.getText();
				if(input.trim().equals("")){ 
					viewOrderTextArea.setText("Please enter an author's name");
					viewOrderAuthorTextField.setText("");
					viewOrderOrderIdTextField.setText("");
				}else{
					viewOrderTextArea.setText(Order.viewOrderByAuthor(orders, input));	
					viewOrderAuthorTextField.setText("");
					viewOrderOrderIdTextField.setText("");
				}
			}
		});
		//====
		viewOrderTextArea = new JTextArea(20, 20); //height - width
		viewOrderTextArea.setEditable(false);
		JScrollPane viewOrderScrollPane = new JScrollPane(viewOrderTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        viewOrderGC.gridwidth = GridBagConstraints.REMAINDER;
        viewOrderGC.fill = GridBagConstraints.BOTH;
        viewOrderGC.weightx = 1.0;
        viewOrderGC.weighty = 1.0;
        viewOrderGC.gridx = 0;
        viewOrderGC.gridy = 0;
        viewOrderRightJPanel.add(viewOrderScrollPane, viewOrderGC);
        viewOrderJPanel.add(viewOrderLeftJPanel, viewOrderGC);
        viewOrderGC.gridx = 1;
        viewOrderGC.gridy = 0;
        viewOrderJPanel.add(viewOrderRightJPanel);
		//=========================================================================================
        //add edit order components	
        findOrderComponentsJPanel.setLayout(new GridBagLayout());
        gc.gridx = 0;
        gc.gridy = 1;
        editOrderJTextField.setPreferredSize(d);
        findOrderComponentsJPanel.add(editOrderJTextField, gc);
        editOrderJTextField.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	editOrderJTextField.setText("");
        	}
        });
        gc.gridx = 0;
        gc.gridy = 2;
        editOrderJButton.setPreferredSize(d);
        findOrderComponentsJPanel.add(editOrderJButton, gc);
        gc.gridx = 0;
        gc.gridy = 3;
        editSupplierOrderJTextField.setPreferredSize(d);
        findOrderComponentsJPanel.add(editSupplierOrderJTextField, gc);
        editSupplierOrderJTextField.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	editSupplierOrderJTextField.setText("");
        	}
        });
        gc.gridx = 0;
        gc.gridy = 4;
        editSupplierOrderJButton.setPreferredSize(d);
        findOrderComponentsJPanel.add(editSupplierOrderJButton, gc);
        editSupplierOrderComponentsJPanel.setLayout(new GridLayout(2,2));
        editSupplierOrderComponentsJPanel.add(new JLabel("Total owed on all orders:"));
        editSupplierOrderComponentsJPanel.add(allOrdersTotalJTextField);
        JScrollPane supplierOrderJScrollPane = new JScrollPane(supplierOrderJTextArea);
        supplierOrderJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        editSupplierOrderComponentsJPanel.add(supplierOrderJScrollPane);
        editSupplierOrderComponentsJPanel.add(deliverAllOrdersJButton);

        deliverAllOrdersJButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		for(Order order: orders){
        			if(Integer.parseInt(editSupplierOrderJTextField.getText().trim()) == order.getSupplierUniqueId() ){
        				order.setDelivered();
        			}
        		}
        		JOptionPane.showMessageDialog(null, "Delivered!");
        		editSupplierOrderJButton.doClick();		
        		}
        });
        supplierOrderJTextArea.setEditable(false);
        allOrdersTotalJTextField.setEditable(false);
        editOrderComponentsJPanel.setLayout(new GridLayout(4,2));
        editOrderComponentsJPanel.add(new JLabel("Enter New order ID"));
        editOrderComponentsJPanel.add(editOrderId);
        editOrderComponentsJPanel.add(new JLabel("Enter New supplier ID"));
        editOrderComponentsJPanel.add(editOrderSupplier);
        editOrderComponentsJPanel.add(new JLabel("Total"));
        editOrderComponentsJPanel.add(editOrderAmount);
        editOrderComponentsJPanel.add(editOrderDeliveredStatus);
        editOrderDeliveredStatus.setEditable(false);
        editOrderComponentsJPanel.add(deliverOrderJButton);
        deliverOrderJButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		for(Order order: orders){
        			if(order.getOrderUniqueId() == Integer.parseInt(editOrderJTextField.getText().trim())){
        				order.setDelivered();
        			}
        		}
        		JOptionPane.showMessageDialog(null, "Delivered!");
        		editOrderDeliveredStatus.setForeground(Color.BLACK);
        		editOrderJButton.doClick();		
        	}
        });
        JScrollPane orderProductsJScrollPane = new JScrollPane(productOrderJTextArea);
        orderProductsJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        editOrderProductsComponentsJPanel.add(orderProductsJScrollPane);
        editOrderProductsComponentsJPanel.setLayout(new GridLayout(1,2));
        productOrderJTextArea.setEditable(false);
        saveOrderComponentsJPanel.setLayout(new GridLayout(1,2));
        saveOrderComponentsJPanel.add(saveOrderJButton);
        saveOrderComponentsJPanel.add(deleteOrderJButton);
        deleteOrderJButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		int index=0;
        		for(Order order: orders){
        			if(order.getOrderUniqueId() == Integer.parseInt(editOrderJTextField.getText().trim())){
        				index = orders.indexOf(order);
        			}
        		}
        		orders.remove(index);
        		JOptionPane.showMessageDialog(null, "Deleted!");
        		editSupplierOrderComponentsJPanel.setVisible(false);
        		editOrderComponentsJPanel.setVisible(false);
        		saveOrderComponentsJPanel.setVisible(false);
        	}
        });
        editOrderJPanel.setLayout(new GridLayout(5,3));
        editOrderJPanel.add(findOrderComponentsJPanel);
        editOrderJPanel.add(editOrderComponentsJPanel);
        editOrderJPanel.add(editOrderProductsComponentsJPanel);
        editOrderJPanel.add(saveOrderComponentsJPanel);
        editOrderJPanel.add(editSupplierOrderComponentsJPanel);
        editOrderProductsComponentsJPanel.setVisible(false);
        editSupplierOrderComponentsJPanel.setVisible(false);
        editOrderComponentsJPanel.setVisible(false);
        saveOrderComponentsJPanel.setVisible(false);
        editOrderButtonHandler eob = new editOrderButtonHandler();
        editOrderJButton.addActionListener(eob);
        editSupplierOrderButtonHandler esob = new editSupplierOrderButtonHandler();
        editSupplierOrderJButton.addActionListener(esob);
        saveOrderButtonHandler sobh = new saveOrderButtonHandler();
        saveOrderJButton.addActionListener(sobh);
	
		//===============================
		//vIWcUSTOMERiNVOICE fUNCTIONALITY - Marc
        //Hardcoding info TODO: Marc
        for(int i=0;i<invoices.size();i++){
			 existingInvoiceNums.add(Integer.toString(invoices.get(i).getId()));
        }
        for(int i = 0;i<customers.size();i++){
        existingCustomerId.add(Integer.toString(customers.get(i).getCustId()));
        }
    
        
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
		comboBoxInvoice = new JComboBox<String>(listOfInvoices); //Combo box rather than Text Field
		comboBoxInvoice.setPreferredSize(new Dimension(60, 20));
		listOfInvoices.setSelectedItem(existingInvoiceNums.get(0)); //setting the combo box to the first invoice number
		gc.gridx = 1;
		gc.gridy = 1;
		viewCustomerPanel.add(comboBoxInvoice,gc);
		JButton invButton = new JButton("Invoice ID");	//button
		gc.gridx = 2;
		gc.gridy = 1;
		invButton.setPreferredSize(new Dimension(120, 30));
		viewCustomerPanel.add(invButton,gc);
		//Action listener For Button to view Invoice by Id
		invButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = (String)comboBoxInvoice.getSelectedItem();
				if(input.trim().equals("") || input.matches(".*\\D.*")){ //regEx
					textarea.setText("Please enter a valid number");
					textarea.setCaretPosition(0);
					invTextField2.setText("");
					custIdTextField.setText("");
				}else{
					int num = Integer.parseInt(input);
					textarea.setText(invoice.viewInvoiceById(num, invoices)); //viewInvoiceById() is in the Invoice Class
					textarea.setCaretPosition(0);
					//invTextField2.setText("");
					//custIdTextField.setText("");
				}
			}
		});
		
		//Second Label and controls: 	View Customer by ID
		JLabel custIdlbl = new JLabel("Customer ID: ");
		gc.gridx = 0;
		gc.gridy = 2;
		viewCustomerPanel.add(custIdlbl,gc);
		comboBoxCustomer =  new JComboBox<String>(listOfCustomers); //combo box here
		comboBoxCustomer.setPreferredSize(new Dimension(60, 20));
		listOfCustomers.setSelectedItem(existingCustomerId.get(0));
		gc.gridx = 1;
		gc.gridy = 2;
		viewCustomerPanel.add(comboBoxCustomer,gc);
		JButton custIdButton = new JButton("Customer ID");
		gc.gridx = 2;
		gc.gridy = 2;
		custIdButton.setPreferredSize(new Dimension(120, 30));
		viewCustomerPanel.add(custIdButton,gc);
		custIdButton.addActionListener(new ActionListener() {
			//Action listener For Button to view Customer by Id
			@Override
			public void actionPerformed(ActionEvent e) {
				//String input = (String)comboBoxInvoice.getSelectedItem();
				String input = (String)comboBoxCustomer.getSelectedItem();
				if(input.trim().equals("") || input.matches(".*\\D.*")){ //regEx
					textarea.setText("Please enter a valid number");
					textarea.setCaretPosition(0);
					custIdTextField.setText("");
					invTextField2.setText("");
				}else{
					int num = Integer.parseInt(input);
					textarea.setText(invoice.viewInvoiceByCustomer(num, invoices));	//viewInvoiceByCustomer() is in the Invoice class
					textarea.setCaretPosition(0);
					//custIdTextField.setText("");
					//invTextField2.setText("");
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
		//products.add(new Product("y", "y", "a", 60.00, 30.00, 30,40, 4, new Supplier(3, "m", "m")));
		//products.add(new Product("y", "y", "s", 60.00, 30.00, 30,40, 4, new Supplier(3, "m", "m")));
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
			//TODO Add more products to Invoice
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
			//TODO Finish creating Invoice
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
									String inputFromTestField = invTextF.getText();
									listOfInvoices.addElement(inputFromTestField);
									String inputFromCusId = custTextF.getText();
									listOfCustomers.addElement(inputFromCusId);
									//input.setText("");
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
				//String input = (productAuthorTextField.getText());																	//All names in array should be stored in lower case.
				
				if(input.trim().equals("")){ 	// If no text is entered
					//textarea.setText("Please enter text in Author Field");
					JOptionPane.showMessageDialog(null, "Please Enter a Value in the Author Field");
					productAuthorTextField.setText("");
					//invTextField.setText("");
				}else{							// Take in String and Search for it.
					productTextArea.setText(product.viewProductByAuthor(input, products));	
					productTextArea.setCaretPosition(0);		// This sets the position of the scroll bar to the top of the page.
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
		
		
		// Button 7: search all stock by retail price range
		JButton searchByRetail = new JButton ("Search by retail");
		productGC.gridx = 0;
		productGC.gridy = 4;
		viewProductDetails.add(searchByRetail,productGC);
		searchByRetail.setPreferredSize(new Dimension(155,20));
		productGC.gridx = 1;
		productGC.gridy = 4;
		viewProductDetails.add(under5Radio,productGC);
		productGC.gridx = 2;
		productGC.gridy = 4;
		viewProductDetails.add(fiveTo10Radio,productGC);
		productGC.gridx = 3;
		productGC.gridy = 4;
		viewProductDetails.add(tenTo20Radio,productGC);
		productGC.gridx = 4;
		productGC.gridy = 4;
		viewProductDetails.add(over20Radio,productGC);

		searchByRetail.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (under5Radio.isSelected()) {
				productTextArea.setText(product.viewProductbyRetailPrice(0.01, 4.99, products));
				priceRange.clearSelection();
				}
				if (fiveTo10Radio.isSelected()){
				productTextArea.setText(product.viewProductbyRetailPrice(5,10, products));
				priceRange.clearSelection();
				}
				if (tenTo20Radio.isSelected()){
				productTextArea.setText(product.viewProductbyRetailPrice(10.01, 20, products));
				priceRange.clearSelection();
				}
				if (over20Radio.isSelected()){
				productTextArea.setText(product.viewProductbyRetailPrice(20.01, 100, products));
				priceRange.clearSelection();
				}
			}
		});

		//Button 8: to search stock by quantity range
		JButton searchByQuantity = new JButton ("Search by quantity");
		productGC.gridx = 0;
		productGC.gridy = 5;
		viewProductDetails.add(searchByQuantity,productGC);
		searchByQuantity.setPreferredSize(new Dimension(155,20));
		productGC.gridx = 1;
		productGC.gridy = 5;
		viewProductDetails.add(under50Radio,productGC);
		productGC.gridx = 2;
		productGC.gridy = 5;
		viewProductDetails.add(fiftyTo100Radio,productGC);
		productGC.gridx = 3;
		productGC.gridy = 5;
		viewProductDetails.add(hundredTo200Radio,productGC);
		productGC.gridx = 4;
		productGC.gridy = 5;
		viewProductDetails.add(over200Radio,productGC);

		searchByQuantity.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (under50Radio.isSelected()) {
					productTextArea.setText(product.viewProductbyQuantity(1, 50, products));
					quantity.clearSelection();
					}
					if (fiftyTo100Radio.isSelected()){
					productTextArea.setText(product.viewProductbyQuantity(51,100, products));
					quantity.clearSelection();
					}
					if (hundredTo200Radio.isSelected()){
					productTextArea.setText(product.viewProductbyQuantity(101, 200, products));
					quantity.clearSelection();
					}
					if (over200Radio.isSelected()){
					productTextArea.setText(product.viewProductbyQuantity(200, 500, products));
					quantity.clearSelection();
				}
			}
		});

		editDetailsJButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for(Product product: products){
					if(product.getProductCode().equals(enterProdCodeJTextField.getText())){
					editCodeJTextField.setText(product.getProductCode());
					editAuthorJTextField.setText(product.getAuthor());
					editTitleJTextField.setText(product.getTitle());
					editRetailJTextField.setText(Double.toString(product.getRetailPrice()));
					editCostJTextField.setText(Double.toString(product.getCostPrice()));
					editStockJTextField.setText(Integer.toString(product.getCurrentStock()));
					editMaxJTextField.setText(Integer.toString(product.getMaxStock()));
					editMinJTextField.setText(Integer.toString(product.getMinStock()));
					editProdSupplierIdJTextField.setText(Integer.toString(product.getSupplier().getId()));
					}
				}
			}
		});

		// to update product details
		updateProductJButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				for (Product product: products){
					if(product.getProductCode().equals(enterProdCodeJTextField.getText())){
						product.setProductCode(editCodeJTextField.getText());
						product.setAuthor(editAuthorJTextField.getText());
						product.setTitle(editTitleJTextField.getText());
						product.setRetailPrice(Double.parseDouble(editRetailJTextField.getText()));
						product.setCostPrice(Double.parseDouble(editCostJTextField.getText()));
						product.setCurrentStock(Integer.parseInt(editStockJTextField.getText()));
						product.setMaxStock(Integer.parseInt(editMaxJTextField.getText()));
						product.setMinStock(Integer.parseInt(editMaxJTextField.getText()));
						
						for (Supplier supplier:suppliers){
							if (supplier.getId() == Integer.parseInt (editProdSupplierIdJTextField.getText())){
							product.setSupplier(supplier);
							}
						}
					
						JOptionPane.showMessageDialog(null, "Product updated");

					}
				}
			}
		});

		// to delete stockline from system
		deleteStockLineJButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String code = enterProdCodeJTextField.getText();
				product.removeStockById(code,products);
				JOptionPane.showMessageDialog(null, "Stockline deleted");

			}
		});
		//=======================  End
		//createInvoices();
	
		} //END OF CONSTRUCTOR
	//TODO - end of constructor
	
	public void createInvoices(){
		invoices.add(new Invoice(1001, employees.get(0), customers.get(0), invoiceProducts1, 1));
		invoices.add(new Invoice(1002, employees.get(1), customers.get(1), invoiceProducts2, 1));
		invoices.add(new Invoice(1003, employees.get(0), customers.get(2), invoiceProducts3, 1));
		invoices.add(new Invoice(1004, employees.get(1), customers.get(3), invoiceProducts3, 10));
		invoices.add(new Invoice(1005, employees.get(0), customers.get(4), invoiceProducts2, 10));
		invoices.add(new Invoice(1006, employees.get(1), customers.get(5), invoiceProducts1, 10));
		invoices.add(new Invoice(1007, employees.get(0), customers.get(1), invoiceProducts1, 10));
		invoices.add(new Invoice(1008, employees.get(1), customers.get(2), invoiceProducts1, 2));
		invoices.add(new Invoice(1009, employees.get(0), customers.get(3), invoiceProducts2, 2));
		invoices.add(new Invoice(1010, employees.get(1), customers.get(4), invoiceProducts1, 2));
		invoices.add(new Invoice(1011, employees.get(0), customers.get(5), invoiceProducts2, 3));
		invoices.add(new Invoice(1012, employees.get(1), customers.get(1), invoiceProducts3, 3));
		invoices.add(new Invoice(1013, employees.get(0), customers.get(0), invoiceProducts3, 3));
		invoices.add(new Invoice(1014, employees.get(1), customers.get(1), invoiceProducts3, 4));
		invoices.add(new Invoice(1015, employees.get(0), customers.get(2), invoiceProducts2, 4));
		invoices.add(new Invoice(1016, employees.get(1), customers.get(0), invoiceProducts2, 4));
		invoices.add(new Invoice(1017, employees.get(0), customers.get(0), invoiceProducts2, 15));
		invoices.add(new Invoice(1018, employees.get(1), customers.get(3), invoiceProducts1, 15));
		invoices.add(new Invoice(1019, employees.get(0), customers.get(3), invoiceProducts1, 15));
		invoices.add(new Invoice(1020, employees.get(1), customers.get(4), invoiceProducts2, 8));
		invoices.add(new Invoice(1021, employees.get(0), customers.get(5), invoiceProducts3, 8));
		invoices.add(new Invoice(1022, employees.get(1), customers.get(1), invoiceProducts1, 8));
		invoices.add(new Invoice(1023, employees.get(0), customers.get(2), invoiceProducts1, 22));
		invoices.add(new Invoice(1024, employees.get(1), customers.get(3), invoiceProducts3, 20));
		invoices.add(new Invoice(1025, employees.get(0), customers.get(4), invoiceProducts3, 19));
		invoices.add(new Invoice(1026, employees.get(0), customers.get(5), invoiceProducts3, 30));
		invoices.add(new Invoice(1027, employees.get(0), customers.get(0), invoiceProducts3, 44));
		invoices.add(new Invoice(1028, employees.get(1), customers.get(0), invoiceProducts3, 66));
		invoices.add(new Invoice(1029, employees.get(0), customers.get(2), invoiceProducts2, 27));
		invoices.add(new Invoice(1030, employees.get(0), customers.get(2), invoiceProducts2, 25));
		invoices.add(new Invoice(1031, employees.get(1), customers.get(2), invoiceProducts2, 16));
		invoices.add(new Invoice(1032, employees.get(1), customers.get(2), invoiceProducts2, 13));
		invoices.add(new Invoice(1033, employees.get(0), customers.get(1), invoiceProducts2, 22));
		invoices.add(new Invoice(1034, employees.get(1), customers.get(3), invoiceProducts2, 33));
		invoices.add(new Invoice(1035, employees.get(0), customers.get(4), invoiceProducts2, 41));
		invoices.add(new Invoice(1036, employees.get(0), customers.get(5), invoiceProducts3, 39));
		invoices.add(new Invoice(1037, employees.get(0), customers.get(3), invoiceProducts3, 48));
		invoices.add(new Invoice(1038, employees.get(1), customers.get(1), invoiceProducts3, 50));
		invoices.add(new Invoice(1039, employees.get(0), customers.get(2), invoiceProducts1, 55));
		invoices.add(new Invoice(1040, employees.get(1), customers.get(0), invoiceProducts3, 60));
		invoices.add(new Invoice(1041, employees.get(1), customers.get(0), invoiceProducts1, 69));
		invoices.add(new Invoice(1042, employees.get(0), customers.get(1), invoiceProducts3, 71));
		invoices.add(new Invoice(1043, employees.get(1), customers.get(1), invoiceProducts2, 63));
		invoices.add(new Invoice(1044, employees.get(0), customers.get(1), invoiceProducts2, 34));
		invoices.add(new Invoice(1045, employees.get(0), customers.get(2), invoiceProducts2, 31));
		invoices.add(new Invoice(1046, employees.get(1), customers.get(2), invoiceProducts2, 66));
		invoices.add(new Invoice(1047, employees.get(0), customers.get(2), invoiceProducts2, 67));
		invoices.add(new Invoice(1048, employees.get(1), customers.get(4), invoiceProducts2, 52));
		invoices.add(new Invoice(1049, employees.get(1), customers.get(4), invoiceProducts2, 41));
		invoices.add(new Invoice(1050, employees.get(0), customers.get(5), invoiceProducts3, 46));
		
	}

	

		//Handler for edit invoice by id button
		private class EditInvoiceButtonHandler implements ActionListener{
			public void actionPerformed( ActionEvent e){//handler starts
				int id = 0;
				String s = "";
				productInvoiceJTextArea.setText("Product Details\n");
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
							editInvoiceProductsComponentsJPanel.setVisible(true);
							editInvoiceId.setText(Integer.toString(id));
							editInvoiceEmployee.setText(Integer.toString(invoice.getEmployee().getEmployeeId()));
							editInvoiceCustomer.setText(Integer.toString(invoice.getCustomer().getCustId()));
							for(InvoiceProduct ip: invoice.getInvoiceProducts()){
										s = "\nProduct Title: " + ip.getProduct().getTitle() + 
												"     ||    Quantity: " + Integer.toString(ip.getQuantity());
										productInvoiceJTextArea.append(s);								
								}	
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
					editInvoiceProductsComponentsJPanel.setVisible(false);
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
						
		//Handler for deliver orders by supplier button
		private class editSupplierOrderButtonHandler implements ActionListener{
			public void actionPerformed( ActionEvent e){//handler starts
					int count = 0, count1 = 0;;
					String s = "";
					double total = 0;
					String totalString = "";
					int id = 0, supplierID = 1;
					try {
						id = Integer.parseInt( editSupplierOrderJTextField.getText().trim() );
					}
					catch (NumberFormatException nfe){
						editSupplierOrderJTextField.setText("");
					}
					for(Supplier supplier: suppliers){
						if(id == supplier.getId()){
							count1++;
							supplierID = 1;
						}
					}	
					if(count1 == 0){
						supplierID = 2;
					}
					if(supplierID == 1){
						editSupplierOrderComponentsJPanel.setVisible(true);
						editOrderComponentsJPanel.setVisible(false);
						saveOrderComponentsJPanel.setVisible(false);
						editOrderProductsComponentsJPanel.setVisible(false);
						supplierOrderJTextArea.setText("Undelivered Orders: ");
						for(Order order: orders){
							if(id == order.getSupplierUniqueId() ){
								if(!order.isDelivered()){
									s = "\nOrder Id : " + order.getOrderUniqueId() + 
											"\nTotal: " + 
											order.calculateOrderWorth() + "\n";
									supplierOrderJTextArea.append(s);
									total = total + order.calculateOrderWorth();
									count++;								
								}
							}
						}
						if(count == 0){
							JOptionPane.showMessageDialog(loginJPanel, "No undelivered orders for this supplierer", "For your information", JOptionPane.INFORMATION_MESSAGE);
							editSupplierOrderComponentsJPanel.setVisible(false);
						}
						else{
							totalString = Double.toString(total);
							allOrdersTotalJTextField.setText(totalString);
						}						
					}
					else if(supplierID == 2){
						//no supplier id match
						JOptionPane.showMessageDialog(loginJPanel, "Supplier ID not found", "For your information", JOptionPane.INFORMATION_MESSAGE);
						editSupplierOrderComponentsJPanel.setVisible(false);
						editOrderComponentsJPanel.setVisible(false);
						saveOrderComponentsJPanel.setVisible(false);
					}
				}
			}
		
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
					password = Integer.parseInt( new String(passwordTF.getPassword()) );
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
					// release some tabs - staff 
					mainJTabbedPane.setSelectedIndex(1);
					mainJTabbedPane.setEnabledAt(1, true);
					mainJTabbedPane.setEnabledAt(2, true);
					mainJTabbedPane.setEnabledAt(3, true);
					mainJTabbedPane.setEnabledAt(4, true);
					mainJTabbedPane.setEnabledAt(5, true);
					mainJTabbedPane.setEnabledAt(6, false);
					mainJTabbedPane.setEnabledAt(7, false);
					mainJTabbedPane.setEnabledAt(8, true);
					mainJTabbedPane.setEnabledAt(0, false);
					invJTabbedPane.setEnabledAt(2, false);
					supplyJTabbedPane.setEnabledAt(2, false);
					prodJTabbedPane.setEnabledAt(2, false);
					custJTabbedPane.setEnabledAt(2, false);						
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
						
		//handler for save button
		private class saveOrderButtonHandler implements ActionListener{
			public void actionPerformed( ActionEvent e){
				int orderId = 0;						
				int supplierId = 0;
				int currentId = Integer.parseInt(editOrderJTextField.getText().trim());
				int count = 0;
				Supplier supp = suppliers.get(0);
				try{
					orderId = Integer.parseInt(editOrderId.getText().trim());
					supplierId = Integer.parseInt(editOrderSupplier.getText().trim());
				}
				catch(NumberFormatException nfe){
					invalidId();
				}											
				for(Supplier supplier: suppliers){
					if(supplierId == supplier.getId()){
						supp = supplier;
						count++;
					}
				}											
				if (count != 0){
					for(Order order: orders){
						if(currentId == order.getOrderUniqueId()){
							order.setOrderUniqueId(orderId);
							order.setSupplierUniqueId(supplierId);
						}
					}
					editInvoiceJTextField.setText(Integer.toString(currentId));
					JOptionPane.showMessageDialog(null, "Updated!");
					editInvoiceJButton.doClick();
				}
				else if(count == 0){
					JOptionPane.showMessageDialog(null, "Invalid Supplier Id!");
					editInvoiceJButton.doClick();
				}
			}
			public void invalidId(){
				JOptionPane.showMessageDialog(null, "Id must be a numerical value!");
				editInvoiceJButton.doClick();
			}
		}// End handler for save button
		
		public boolean orderNumberUnique(int id, ArrayList<Order> orders){
			int count = 0;
			for(Order i : orders){
				if(i.getOrderUniqueId() == id){
					count++;
				}
			}
			if(count>=1)
				return false;
			else 
				return true;
			
		}
		private class editOrderButtonHandler implements ActionListener{
			public void actionPerformed( ActionEvent e){//handler starts
				productOrderJTextArea.setText("");
				int id = 0;
				String s = "";
				productInvoiceJTextArea.setText("Product Details\n");
				try {
					id = Integer.parseInt( editOrderJTextField.getText().trim() );
				}
				catch (NumberFormatException nfe){
					editOrderJTextField.setText("");
				}
				int orderId = verifyOrderID(id);
				if(orderId == 1){
					for(Order order: orders){
						if(id == order.getOrderUniqueId()){
							editSupplierOrderComponentsJPanel.setVisible(false);
							editOrderComponentsJPanel.setVisible(true);
							saveOrderComponentsJPanel.setVisible(true);
							editOrderProductsComponentsJPanel.setVisible(true);
							editOrderId.setText(Integer.toString(id));
							editOrderSupplier.setText(Integer.toString(order.getSupplierUniqueId()));
							for(OrderProduct op: order.getListOfOrderProducts()){
										s = "\nProduct Title: " + op.getProduct().getTitle() + 
										"     ||    Quantity: " + Integer.toString(op.getQuantity());
										productOrderJTextArea.append(s);								
								}	
							editOrderAmount.setText(Double.toString(order.calculateOrderWorth()));
							if(!order.isDelivered()){
								editOrderDeliveredStatus.setText("Undelivered");
								editOrderDeliveredStatus.setForeground(Color.RED);
							}
							if(order.isDelivered()){
								editOrderDeliveredStatus.setText("Delivered");
								editOrderDeliveredStatus.setForeground(Color.BLACK);
							}
						}
					}	
				}
				else if(orderId == 2){
					//no order id match
					JOptionPane.showMessageDialog(loginJPanel, "Order ID not found", "For your information", JOptionPane.INFORMATION_MESSAGE);
					editSupplierOrderComponentsJPanel.setVisible(false);
					editOrderComponentsJPanel.setVisible(false);
					saveOrderComponentsJPanel.setVisible(false);
					editOrderProductsComponentsJPanel.setVisible(false);
				}
			}
			public int verifyOrderID(int id) {
		    	int count = 0;
		    	int validID = 0;
				for(Order order: orders){
					if(id == order.getOrderUniqueId()){
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
						editInvoiceProductsComponentsJPanel.setVisible(false);
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
