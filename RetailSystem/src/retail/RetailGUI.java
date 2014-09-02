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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultRowSorter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.ScrollPaneConstants;
import javax.swing.SortOrder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

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
	private ArrayList<OrderProduct> orderProducts1 = new ArrayList<OrderProduct>();
	private ArrayList<OrderProduct> orderProducts2 = new ArrayList<OrderProduct>();
	private ArrayList<OrderProduct> orderProducts3 = new ArrayList<OrderProduct>();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/dd");
	
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
	private JPanel graphJPanel = new JPanel();
	
	//login components
	private JPanel loginComponentsJPanel = new JPanel();
	private JTextField loginTF = new JTextField();
	private JPasswordField passwordTF = new JPasswordField();
	private JButton loginBut = new JButton();
	
	//logout components
	private JPanel logoutComponentsJPanel = new JPanel();
	private JPanel logoutJPanel = new JPanel();
	private JButton logoutBut = new JButton();
	
	private DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
	
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
	private JComboBox<String> custIdCombo = new JComboBox<String>();
	private JButton viewCustJButton = new JButton("View By ID");
	private JLabel viewCustByName = new JLabel("Find Customer By Name");
	private JComboBox<String> custNameCombo = new JComboBox<String>();
	private JButton viewCustNameJButton = new JButton("View By Name");
	private JButton viewAllCustJButton = new JButton("View All Customers");
	private JTextArea custJTextArea = new JTextArea(10, 65);
	private JLabel editFindCustIdJLabel = new JLabel("Enter Customer ID");
	private JComboBox<String> editCustIdCombo = new JComboBox<String>();
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
	private JLabel supplierIdJLabel = new JLabel("Supplier ID");
	private JTextField supplierIdJTextField = new JTextField();
	private JLabel supplierNameJLabel = new JLabel("Supplier Name");
	private JTextField supplierNameJTextField = new JTextField();
	private JLabel supplierAddressJLabel = new JLabel("Supplier Address");
	private JTextField supplierAddressJTextField = new JTextField();
	private JLabel supplierEmailJLabel= new JLabel("Supplier Email");
	private JTextField supplierEmailJTextField = new JTextField();
	private JLabel supplierPhoneJLabel = new JLabel("Supplier Phone Number");
	private JTextField supplierPhoneJTextField = new JTextField();
	private JButton supplierJButton = new JButton("Create New Supplier");
	private JLabel viewSupplyJLabel = new JLabel("Search by Supplier ID");
	private JComboBox<String> suppIdCombo = new JComboBox<String>();
	private JButton viewSupplyJButton = new JButton("View Supplier By ID");
	private JLabel viewSupplyNameJLabel = new JLabel("Search by Supplier Name: ");
	private JComboBox<String> suppNameCombo = new JComboBox<String>();
	private JTextArea supplierJTextArea = new JTextArea(10, 65);
	private JButton viewSupplyNameJButton = new JButton("View Supplier By Name");
	private JButton allSupplyJButton = new JButton("View All Suppliers");
	private JLabel editFindSuppIdJLabel = new JLabel("Enter Supplier ID");
	private JComboBox<String> editSuppIdCombo = new JComboBox<String>();
	private JButton editSupplierJButton = new JButton("Find Supplier");
	private JLabel editSuppNameJLabel = new JLabel("Supplier Name");
	private JLabel editSuppAddressJLabel = new JLabel("Supplier Address");
	private JLabel editSuppEmailJLabel = new JLabel("Supplier Email");
	private JLabel editSuppPhoneJLabel = new JLabel("Supplier Telephone");
	private JLabel editDeliveryJLabel = new JLabel("Edit Delivery Period");
	private JTextField editSupplierName = new JTextField();
	private JTextField editSupplierAddress = new JTextField();
	private JTextField editSupplierEmail = new JTextField();
	private JTextField editSupplierPhone = new JTextField();
	private JTextField editSupplierDelivery = new JTextField();
	private JButton saveSupplierJButton = new JButton("Update Supplier");
	private JButton deleteSupplierJButton = new JButton("Delete Supplier");
	
	//Employee Components
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
	private JComboBox<String> empIdCombo = new JComboBox<String>();
	private JButton viewEmpIdButton = new JButton("Search Employees");
	private JLabel viewEmpName = new JLabel("View By Name");
	private JComboBox<String> empNameCombo = new JComboBox<String>();
	private JButton viewEmpNameButton = new JButton("Search Employees");
	private JLabel viewEmpAll = new JLabel("View All Employees");
	private JButton viewEmpAllButton = new JButton("View All");
	private JTextArea empJTextArea = new JTextArea(10, 65);
	private JLabel editFindById = new JLabel("Enter Employee ID ");
	private JComboBox<String> viewEmpIdCombo = new JComboBox<String>();
	private JButton editById = new JButton("Find Employee Details");
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
	private JPanel viewProductDetailsPanel= new JPanel();
	private JPanel viewProductDetails= new JPanel();
	private ButtonGroup priceRange = new ButtonGroup();
	private ButtonGroup quantity = new ButtonGroup();
	
	// TODO  Set Image Icons
//	ImageIcon productIcon = new ImageIcon("C:/Users/James/Desktop/testA.png");
//	ImageIcon invoiceIcon = new ImageIcon("C:/Users/James/Desktop/Invoice.png");
			
			
			
	// TODO Product Combo Box
	private Vector<String> existingProductId = new Vector<>();
	private DefaultComboBoxModel<String> listOfProductId = new DefaultComboBoxModel<>(existingProductId);
	private JComboBox<String> comboBoxProductId;
	
	private Vector<String> existingProductTitle = new Vector<>();
	private DefaultComboBoxModel<String> listofProductTitle = new DefaultComboBoxModel<>(existingProductTitle);
	private JComboBox<String> comboBoxProductTitle;
	
	private Vector<String> existingProductAuthor = new Vector<>();
	private DefaultComboBoxModel<String> listOfProductAuthor = new DefaultComboBoxModel<>(existingProductAuthor);
	private JComboBox<String> comboBoxProductAuthor;
	
	private Vector<String> existingEditProdId = new Vector<>();
	private DefaultComboBoxModel<String> listToEditProdIds = new DefaultComboBoxModel<>(existingEditProdId);
	private JComboBox<String> comboBoxEditProdId;
	
	
	//Edit Invoice Components 
	private JPanel findInvoiceComponentsJPanel = new JPanel();
	private JPanel editInvoiceComponentsJPanel = new JPanel();
	private JPanel editCustomerInvoiceComponentsJPanel = new JPanel();
	private JPanel saveInvoiceComponentsJPanel = new JPanel();
	private JPanel editInvoiceProductsComponentsJPanel = new JPanel();
	private Vector<String> editExistingInvoiceNums = new Vector<>();
	private DefaultComboBoxModel<String> editListOfInvoices = new DefaultComboBoxModel<>(editExistingInvoiceNums); //create the combo box
	private JComboBox<String> editComboBoxInvoice;
	private Vector<String> editExistingCustomerInvoiceNums = new Vector<>();
	private DefaultComboBoxModel<String> editCustomerListOfInvoices = new DefaultComboBoxModel<>(editExistingCustomerInvoiceNums); //create the combo box
	private JComboBox<String> editComboBoxCustomerInvoice;
	private JTextArea customerInvoiceJTextArea = new JTextArea(10,20);
	private JTextArea productInvoiceJTextArea = new JTextArea();
	private JTextField allInvoicesTotalJTextField = new JTextField("Total Owed");
	private JButton payAllInvoicesJButton = new JButton("Pay All Invoices");
	private JButton editInvoiceJButton = new JButton("Find Invoice by Id");
	private JButton editCustomerInvoiceJButton = new JButton("Find Invoice by Customer");
	private JTextField editInvoiceId = new JTextField("Edit Invoice Id:");
	private JTextField editInvoiceEmployee = new JTextField("Edit Invoice Employee");
	private JTextField editInvoiceCustomer = new JTextField("Edit Invoice Customer");
	private JButton payInvoiceJButton = new JButton("Pay Invoice");
	private JButton saveInvoiceJButton = new JButton("Update Invoice");
	private JButton deleteInvoiceJButton = new JButton("Delete Invoice");
	private JTextField editPayStatus = new JTextField("");	
	private JTextField editInvoiceAmount = new JTextField("Edit Invoice Amount");

	private JButton lineChartJButton = new JButton("Income and Expenditure");

		
	//===========================================
	//TODO Marc: View Customer Invoice Panel and Components
		
	//Panel
	private JPanel viewCustomerPanel = new JPanel();
	
	//Components
	private JTextArea textarea;
	private JTextField invTextField2;
	private JTextField custIdTextField;
	private Invoice invoice = new Invoice();
	
	//Combo Box for invoice ID on View Customer Invoice Panel
	private Vector<String> existingInvoiceNums = new Vector<>();
	private DefaultComboBoxModel<String> listOfInvoices = new DefaultComboBoxModel<>(existingInvoiceNums); //create the combo box
	private JComboBox<String> comboBoxInvoice;
	//====
	private Vector<String> existingCustomerId = new Vector<>();
	private DefaultComboBoxModel<String> listOfCustomers = new DefaultComboBoxModel<>(existingCustomerId); //create the combo box
	private JComboBox<String> comboBoxCustomer;
	
	//TODO Marc: Combo
	//Combo Box for Employee ID, Customer ID, Product ID on Create new Invoice Panel
	private Vector<String> empIdVector = new Vector<>();
	private DefaultComboBoxModel<String> listOfEmpIds = new DefaultComboBoxModel<>(empIdVector); //create the combo box
	private JComboBox<String> empIDComboBox;
	private Vector<String> cusIdVector = new Vector<>();
	private DefaultComboBoxModel<String> listOfCusIds = new DefaultComboBoxModel<>(cusIdVector); //create the combo box
	private JComboBox<String> cusIDComboBox;
	private Vector<String> prodIdVector = new Vector<>();
	private DefaultComboBoxModel<String> listOfProdIds = new DefaultComboBoxModel<>(prodIdVector); //create the combo box
	private JComboBox<String> prodIDComboBox;
	
	//=========Marc: Components for higher and lower Pie Chart==========
	private ArrayList<String> productCodes;
	private int[] countsHigher; //needed in main
	private int[] countsLower;  //needed in main
	private JButton highestSellingButton; 
	private JButton lowsetsellingButton;
	private int topNum = 5;
	
	//End
	//==========================================
	
	///============Components for Pie Chart ============================
		private DefaultPieDataset pieDataset = new DefaultPieDataset();
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
	private JTextField invTextF;// = new JTextField(10);
	private JTextField employTextF = new JTextField(10);
	private JTextField custTextF = new JTextField(10);
	private JTextField prodTextF = new JTextField(10);
	private JTextField quantityTextF;// = new JTextField(10);
	
	//4 Buttons for left Panel
	/*private JButton singleBtn = new JButton("Single Invoice");
	private JButton multiBtn = new JButton("Multiple Invoice");*/
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
	private JComboBox<String> createOrderSupplierIdComboBox;
	private JComboBox<String> createOrderProductIdComboBox;
	private JTextField createOrderSupplierIdTextField = new JTextField();
	private JTextField createOrderProductIdTextField = new JTextField();
	private JTextField createOrderQuantityTextField = new JTextField();
	private JButton createOrderAddProductButton =  new JButton("Add Product to Order");
	private JButton createOrderConfirmOrderButton = new JButton("Confirm Order");
	private JTextArea createOrderScrollPaneTextArea = new JTextArea();
	//=====
	//viewOrder Panel components
	private Vector<String> existingOrderIds = new Vector<>();
	private DefaultComboBoxModel<String> listOfOrders = new DefaultComboBoxModel<>(existingOrderIds); //create the combo box
	private JComboBox<String> viewOrderOrderIdComboBox;
	private Vector<String> existingSupplierIds = new Vector<>();
	private DefaultComboBoxModel<String> listOfSuppliers = new DefaultComboBoxModel<>(existingSupplierIds); //create the combo box
	private JComboBox<String> viewOrderSupplierIdComboBox;
	private Vector<String> existingTitles = new Vector<>();
	private DefaultComboBoxModel<String> listOfTitles = new DefaultComboBoxModel<>(existingTitles); //create the combo box
	private JComboBox<String> viewOrderTitleComboBox;
	private Vector<String> existingAuthors = new Vector<>();
	private DefaultComboBoxModel<String> listOfAuthors = new DefaultComboBoxModel<>(existingAuthors); //create the combo box
	private JComboBox<String> viewOrderAuthorComboBox;
	private JButton viewOrderViewAllOrdersButton = new JButton("View All");
	private JButton viewOrderViewReceivedButton = new JButton("View Received Orders");
	private JButton viewOrderViewUnreceivedButton = new JButton("View Unreceived Order");
	private JLabel viewOrderOrderIdLabel = new JLabel("Order ID: ");
	private JButton viewOrderOrderIdButton = new JButton("Find order with this ID");	
	private JLabel viewOrderSupplierIdLabel = new JLabel("Supplier ID: ");
	private JButton viewOrderSupplierIdButton = new JButton("Find order with this Supplier");
	private JLabel viewOrderTitleLabel = new JLabel("Title: ");
	private JButton viewOrderTitleButton = new JButton("Find order containing a product with this title");	
	private JLabel viewOrderAuthorLabel = new JLabel("Author: ");
	private JButton viewOrderAuthorButton = new JButton("Find order containing a product by this author");	
	private JTextArea viewOrderTextArea;
	//Edit Order Components
	private JPanel findOrderComponentsJPanel = new JPanel();
	private JPanel editOrderComponentsJPanel = new JPanel();
	private JPanel editSupplierOrderComponentsJPanel = new JPanel();
	private JPanel saveOrderComponentsJPanel = new JPanel();
	private JPanel editOrderProductsComponentsJPanel = new JPanel();
	private JComboBox<String> editOrderOrderIdComboBox;
	private JTextArea supplierOrderJTextArea = new JTextArea(10,20);
	private JTextArea productOrderJTextArea = new JTextArea();
	private JTextField allOrdersTotalJTextField = new JTextField("Total Owed");
	private JButton receiveAllOrdersJButton = new JButton("Receive All Orders");
	private JButton editOrderJButton = new JButton("Find Order by Id");
	private JComboBox<String> editOrderSupplierIdComboBox;
	private JButton editSupplierOrderJButton = new JButton("Find Order by Supplier");
	private JTextField editOrderId = new JTextField("Edit Order Id:");
	private JTextField editOrderSupplier = new JTextField("Edit Order Customer");
	private JButton receiveOrderJButton = new JButton("Receive Order");
	private JButton saveOrderJButton = new JButton("Update Order");
	private JButton deleteOrderJButton = new JButton("Delete Order");
	private JTextField editOrderReceivedStatus = new JTextField("");	
	private JTextField editOrderAmount = new JTextField("Edit Order Amount");
	
	//P&L JTable Tab
	private JPanel pLComponentsJPanel = new JPanel();
	private static final int ROW_HEIGHT = 20;
	private static final String[] TABLE_COLUMNS = {"Date", "Credit", "Debit"};
	private DefaultTableModel tableModel = new DefaultTableModel(TABLE_COLUMNS, 0);
	private JTable pLJTable = new JTable(tableModel);
	JScrollPane pLJScrollPane = new JScrollPane(pLJTable);
	private JTextField pLTotal = new JTextField();
	private Vector<String> months = new Vector<>();
	private DefaultComboBoxModel<String> listOfMonths = new DefaultComboBoxModel<>(months); //create the combo box
	private JComboBox<String> comboBoxPL;
	private JButton pLViewButton = new JButton("View");
	
	//=========================================================================
	Dimension d = new Dimension(230, 30);
	
	public RetailGUI() {
		//TODO Jump to Constructor
		createInvoices();
	
		
		//Line Chart data sets
		gc.insets = new Insets(10,5,5,10);
		Invoice inv = new Invoice();
		Order ord = new Order();
		Employee emp = new Employee();
		line_chart_dataset.addValue(inv.getMonthlySales(0,invoices), "income", "Jan");
        line_chart_dataset.addValue(inv.getMonthlySales(1,invoices), "income", "Feb");
        line_chart_dataset.addValue(inv.getMonthlySales(2,invoices), "income", "Mar");
        line_chart_dataset.addValue(inv.getMonthlySales(3,invoices), "income", "Apr");
        line_chart_dataset.addValue(inv.getMonthlySales(4,invoices), "income", "May");
        line_chart_dataset.addValue(inv.getMonthlySales(5,invoices), "income", "Jun");
        line_chart_dataset.addValue(inv.getMonthlySales(6,invoices), "income", "Jul");
        line_chart_dataset.addValue(inv.getMonthlySales(7,invoices), "income", "Aug");
        line_chart_dataset.addValue(inv.getMonthlySales(8,invoices), "income", "Sept");
        line_chart_dataset.addValue(inv.getMonthlySales(9,invoices), "income", "Oct");
        line_chart_dataset.addValue(inv.getMonthlySales(10,invoices), "income", "Nov");
        line_chart_dataset.addValue(inv.getMonthlySales(11,invoices), "income", "Dec");
        
        line_chart_dataset.addValue(emp.monthlySalary(employees) + ord.orderTotalByMonth(orders, 0), "expenditure", "Jan");
        line_chart_dataset.addValue(emp.monthlySalary(employees) + ord.orderTotalByMonth(orders, 1), "expenditure", "Feb");
        line_chart_dataset.addValue(emp.monthlySalary(employees) + ord.orderTotalByMonth(orders, 2), "expenditure", "Mar");
        line_chart_dataset.addValue(emp.monthlySalary(employees) + ord.orderTotalByMonth(orders, 3), "expenditure", "Apr");
        line_chart_dataset.addValue(emp.monthlySalary(employees) + ord.orderTotalByMonth(orders, 4), "expenditure", "May");
        line_chart_dataset.addValue(emp.monthlySalary(employees) + ord.orderTotalByMonth(orders, 5), "expenditure", "Jun");
        line_chart_dataset.addValue(emp.monthlySalary(employees) + ord.orderTotalByMonth(orders, 6), "expenditure", "Jul");
        line_chart_dataset.addValue(emp.monthlySalary(employees) + ord.orderTotalByMonth(orders, 7), "expenditure", "Aug");
        line_chart_dataset.addValue(emp.monthlySalary(employees) + ord.orderTotalByMonth(orders, 8), "expenditure", "Sept");
        line_chart_dataset.addValue(emp.monthlySalary(employees) + ord.orderTotalByMonth(orders, 9), "expenditure", "Oct");
        line_chart_dataset.addValue(emp.monthlySalary(employees) + ord.orderTotalByMonth(orders, 10), "expenditure", "Nov");
        line_chart_dataset.addValue(emp.monthlySalary(employees) + ord.orderTotalByMonth(orders, 11), "expenditure", "Dec");
				
		//add login components
		loginJPanel.setLayout(new GridBagLayout());
		GridBagConstraints loginGC = new GridBagConstraints();
		loginGC.insets = new Insets(5,5,5,5);
		loginComponentsJPanel.setLayout(new GridBagLayout());
		loginGC.gridx = 0;
		loginGC.gridy = 0;
		loginComponentsJPanel.add(new JLabel("Enter Employee ID"), loginGC);
		loginGC.gridx = 0;
		loginGC.gridy = 1;
		loginComponentsJPanel.add(loginTF = new JTextField("Employee ID"), loginGC);
		loginTF.setPreferredSize(d);
		loginGC.gridx = 0;
		loginGC.gridy = 2;
		loginComponentsJPanel.add(new JLabel("Enter Employee Password"), loginGC);
		loginGC.gridx = 0;
		loginGC.gridy = 3;
		loginComponentsJPanel.add(passwordTF = new JPasswordField("Password"), loginGC);
		passwordTF.setPreferredSize(d);
		loginGC.gridx = 0;
		loginGC.gridy = 4;
		loginComponentsJPanel.add(loginBut= new JButton("Login"), loginGC);
		loginBut.setPreferredSize(d);
		loginJPanel.add(loginComponentsJPanel, loginGC);
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
		
		logoutComponentsJPanel.setLayout(new GridBagLayout());
		loginGC.gridx = 0;
		loginGC.gridy = 0;
		logoutComponentsJPanel.add(new JLabel("Logout of application: "), loginGC);
		loginGC.gridx = 0;
		loginGC.gridy = 1;
		logoutComponentsJPanel.add(logoutBut= new JButton("Logout"), loginGC);
		logoutBut.setPreferredSize(d);
		logoutComponentsJPanel.setVisible(false);
		loginJPanel.add(logoutComponentsJPanel, loginGC);
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
				logoutComponentsJPanel.setVisible(false);
				loginComponentsJPanel.setVisible(true);
			}
		});
		
		mainJFrame.setTitle("Retail Application");
		//mainJFrame.setBounds(0, 0, 800, 600);
		mainJFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainJFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainJFrame.setVisible(true);
		mainJFrame.add(mainJTabbedPane);
		
		mainJTabbedPane.add("Login/Logout", loginJPanel);
		mainJTabbedPane.add("Customer Management", custJTabbedPane);
		mainJTabbedPane.add("Supplier Management", supplyJTabbedPane);
//		mainJTabbedPane.addTab("Product Management", productIcon, prodJTabbedPane);		// This code was used when testing image icons 
//		mainJTabbedPane.addTab("Invoice Management",invoiceIcon, invJTabbedPane);		// Needs more work do not delete
		mainJTabbedPane.addTab("Product Management", prodJTabbedPane);
		mainJTabbedPane.addTab("Invoice Management", invJTabbedPane);
		
		mainJTabbedPane.add("Order Management", orderJTabbedPane);
		mainJTabbedPane.add("Manage Employee Access", accessJTabbedPane);
		mainJTabbedPane.add("Profit and Loss", proflossJTabbedPane);
		
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
		
		proflossJTabbedPane.add("Profit and Loss Table", proflossJPanel);
		proflossJTabbedPane.add("Graph Information", graphJPanel);
		
		/*remove comment marks to run login function

		//lock the tabs until login successful
		mainJTabbedPane.setEnabledAt(1, false);
		mainJTabbedPane.setEnabledAt(2, false);
		mainJTabbedPane.setEnabledAt(3, false);
		mainJTabbedPane.setEnabledAt(4, false);
		mainJTabbedPane.setEnabledAt(5, false);
		mainJTabbedPane.setEnabledAt(6, false);
		mainJTabbedPane.setEnabledAt(7, false);
						
		*/	
		
		employeeJPanel.setLayout(new GridBagLayout());
		this.empIDPopulate(empIdCombo);
		this.empNamePopulate();
		this.empIDPopulate(viewEmpIdCombo);
		gc.gridx = 0;
		gc.gridy = 1;
		employeeId.setMinimumSize(d);
		employeeId.setPreferredSize(d);
		employeeJPanel.add(employeeId, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		employeeIdField.setMinimumSize(d);
		employeeIdField.setPreferredSize(d);
		employeeJPanel.add(employeeIdField, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		employeeName.setMinimumSize(d);
		employeeName.setPreferredSize(d);
		employeeJPanel.add(employeeName, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		employeeNameField.setMinimumSize(d);
		employeeNameField.setPreferredSize(d);
		employeeJPanel.add(employeeNameField, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		employeeAcess.setMinimumSize(d);
		employeeAcess.setPreferredSize(d);
		employeeJPanel.add(employeeAcess, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		employeeAcessField.setMinimumSize(d);
		employeeAcessField.setPreferredSize(d);
		employeeJPanel.add(employeeAcessField, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		employeeSalary.setMinimumSize(d);
		employeeSalary.setPreferredSize(d);
		employeeJPanel.add(employeeSalary, gc);
		gc.gridx = 0;
		gc.gridy = 8;
		employeeSalaryField.setMinimumSize(d);
		employeeSalaryField.setPreferredSize(d);
		employeeJPanel.add(employeeSalaryField, gc);
		gc.gridx = 0;
		gc.gridy = 9;
		employeePassword.setMinimumSize(d);
		employeePassword.setPreferredSize(d);
		employeeJPanel.add(employeePassword, gc);
		gc.gridx = 0;
		gc.gridy = 10;
		employeePassField.setMinimumSize(d);
		employeePassField.setPreferredSize(d);
		employeeJPanel.add(employeePassField, gc);
		gc.gridx = 0;
		gc.gridy = 11;
		employeeJButton.setMinimumSize(d);
		employeeJButton.setPreferredSize(d);
		employeeJPanel.add(employeeJButton, gc);
		viewEmployeeJPanel.setLayout(new GridBagLayout());
		gc.gridx = 0;
		gc.gridy = 1;
		JScrollPane empScrollPane = new JScrollPane(empJTextArea);
		viewEmployeeJPanel.add(empScrollPane, gc);	
		editEmployeeJPanel.setLayout(new GridBagLayout());
		gc.gridx = 0;
		gc.gridy = 2;
		viewEmpId.setMinimumSize(d);
		viewEmpId.setPreferredSize(d);
		viewEmployeeJPanel.add(viewEmpId, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		empIdCombo.setMinimumSize(d);
		empIdCombo.setPreferredSize(d);
		empIdCombo.setSelectedIndex(0);
		viewEmployeeJPanel.add(empIdCombo, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		viewEmpIdButton.setMinimumSize(d);
		viewEmpIdButton.setPreferredSize(d);
		viewEmployeeJPanel.add(viewEmpIdButton, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		viewEmpName.setMinimumSize(d);
		viewEmpName.setPreferredSize(d);
		viewEmployeeJPanel.add(viewEmpName, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		empNameCombo.setMinimumSize(d);
		empNameCombo.setPreferredSize(d);
		empNameCombo.setSelectedIndex(0);
		viewEmployeeJPanel.add(empNameCombo, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		viewEmpNameButton.setMinimumSize(d);
		viewEmpNameButton.setPreferredSize(d);
		viewEmployeeJPanel.add(viewEmpNameButton, gc);
		gc.gridx = 0;
		gc.gridy = 8;
		viewEmpAll.setMinimumSize(d);
		viewEmpAll.setPreferredSize(d);
		viewEmployeeJPanel.add(viewEmpAll, gc);
		gc.gridx = 0;
		gc.gridy = 9;
		viewEmpAllButton.setMinimumSize(d);
		viewEmpAllButton.setPreferredSize(d);
		viewEmployeeJPanel.add(viewEmpAllButton, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		editFindById.setMinimumSize(d);
		editFindById.setPreferredSize(d);
		editEmployeeJPanel.add(editFindById, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		viewEmpIdCombo.setMinimumSize(d);
		viewEmpIdCombo.setPreferredSize(d);
		viewEmpIdCombo.setSelectedIndex(0);
		editEmployeeJPanel.add(viewEmpIdCombo, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		editById.setMinimumSize(d);
		editById.setPreferredSize(d);
		editEmployeeJPanel.add(editById, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		editEmpName.setMinimumSize(d);
		editEmpName.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpName, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		editEmpNameField.setMinimumSize(d);
		editEmpNameField.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpNameField, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		editEmpAccess.setMinimumSize(d);
		editEmpAccess.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpAccess, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		editEmpAccessField.setMinimumSize(d);
		editEmpAccessField.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpAccessField, gc);
		gc.gridx = 0;
		gc.gridy = 8;
		editEmpSalary.setMinimumSize(d);
		editEmpSalary.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpSalary, gc);
		gc.gridx = 0;
		gc.gridy = 9;
		editEmpSalaryField.setMinimumSize(d);
		editEmpSalaryField.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpSalaryField, gc);
		gc.gridx = 0;
		gc.gridy = 10;
		editEmpPassword.setMinimumSize(d);
		editEmpPassword.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpPassword, gc);
		gc.gridx = 0;
		gc.gridy = 11;
		editEmpPasswordField.setMinimumSize(d);
		editEmpPasswordField.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpPasswordField, gc);
		gc.gridx = 0;
		gc.gridy = 12;
		updateEmployee.setMinimumSize(d);
		updateEmployee.setPreferredSize(d);
		editEmployeeJPanel.add(updateEmployee, gc);
		gc.gridx = 0;
		gc.gridy = 13;
		deleteEmployee.setMinimumSize(d);
		deleteEmployee.setPreferredSize(d);
		editEmployeeJPanel.add(deleteEmployee, gc);

		
		employeeJButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Employee employee = new Employee(Integer.parseInt(employeeIdField.getText()),employeeNameField.getText(), Integer.parseInt(employeeAcessField.getText()), Double.parseDouble(employeeSalaryField.getText()), Integer.parseInt(employeePassField.getText()));
				employees.add(employee);
				empIdCombo.addItem(employeeIdField.getText());
				empNameCombo.addItem(employeeNameField.getText());
				viewEmpIdCombo.addItem(employeeIdField.getText());
				JOptionPane.showMessageDialog(null, "Employee Successfully Created");
			}

		});
		
		viewEmpIdButton.addActionListener(new ActionListener(){
			// function to view a customer by id or name
			public void actionPerformed(ActionEvent e){
			if(employees.size() >= 1){
					try{
						for(Employee employee: employees){
							if(employee.getEmployeeId()== Integer.parseInt(empIdCombo.getSelectedItem().toString())){
								empJTextArea.setText("Employee ID: "+employee.getEmployeeId()
										+"\n Name: " +employee.getEmployeeName() 
										+"\n Access Level: " +employee.getAccess()
										+"\n Password: " +employee.getPassword()
										+"\n Salary: " +employee.getSalary());
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
				if(employees.size() >= 1){
					for(Employee employee: employees){
						if(employee.getEmployeeName().equalsIgnoreCase(empNameCombo.getSelectedItem().toString())){
							empJTextArea.setText("Employee ID: "+employee.getEmployeeId()
						+"\n Name: " +employee.getEmployeeName() 
						+"\n Access Level: " +employee.getAccess()
						+"\n Password: " +employee.getPassword()
						+"\n Salary: " +employee.getSalary());
						}
				}
				}else{
					JOptionPane.showMessageDialog(null, "No Employees Found");
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
							+"\n Name: " +employee.getEmployeeName() 
							+"\n Access Level: " +employee.getAccess()
							+"\n Password: " +employee.getPassword()
							+"\n Salary: " +employee.getSalary()+"\n");
						}
					}else{
						JOptionPane.showMessageDialog(null, "No Employees Found");
					}
			}
		});
		
		editById.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					for(Employee employee: employees){
						if(employee.getEmployeeId()== Integer.parseInt(viewEmpIdCombo.getSelectedItem().toString())){
							editEmpNameField.setText(employee.getEmployeeName());
							editEmpAccessField.setText(Integer.toString(employee.getAccess()));
							editEmpSalaryField.setText(Double.toString(employee.getSalary()));
							editEmpPasswordField.setText(Integer.toString(employee.getPassword()));
						}
					}
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Employee Id should be a number.");
				}
			}
		});
		
		updateEmployee.addActionListener(new ActionListener(){
			//update a specific customer
			public void actionPerformed(ActionEvent e){
				try{
					for(Employee employee: employees){
						if(employee.getEmployeeId() == Integer.parseInt(viewEmpIdCombo.getSelectedItem().toString())){
							employee.setEmployeeName(editEmpNameField.getText());
							employee.setAccess(Integer.parseInt(editEmpAccessField.getText()));
							employee.setSalary(Double.parseDouble(editEmpSalaryField.getText()));
							employee.setPassword(Integer.parseInt(editEmpPasswordField.getText()));
							JOptionPane.showMessageDialog(null, "Employee Updated");
						}
					}
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Employee Id should be a number.");
				}
			}
		});
		
		deleteEmployee.addActionListener(new ActionListener(){
			//delete function for employee
			public void actionPerformed(ActionEvent arg){
				try{
					for(Employee employee: employees){
						if(employee.getEmployeeId() == Integer.parseInt(viewEmpIdCombo.getSelectedItem().toString())){
							empIdCombo.removeItem(viewEmpIdCombo.getSelectedItem());
							empNameCombo.removeItem(viewEmpIdCombo.getSelectedItem());
							viewEmpIdCombo.removeItem(viewEmpIdCombo.getSelectedItem());
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
		this.custIdPopulate(custIdCombo);
		this.custNamePopulate(custNameCombo);
		this.custIdPopulate(editCustIdCombo);
		gc.gridx = 0;
		gc.gridy = 1;
		custIdJLabel.setMinimumSize(d);
		custIdJLabel.setPreferredSize(d);
		addCustJPanel.add(custIdJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		custIdJTextField.setMinimumSize(d);
		custIdJTextField.setPreferredSize(d);
		addCustJPanel.add(custIdJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		custNameJLabel.setMinimumSize(d);
		custNameJLabel.setPreferredSize(d);
		addCustJPanel.add(custNameJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		custNameJTextField.setMinimumSize(d);
		custNameJTextField.setPreferredSize(d);
		addCustJPanel.add(custNameJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		custAddressJLabel.setMinimumSize(d);
		custAddressJLabel.setPreferredSize(d);
		addCustJPanel.add(custAddressJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		custAddressJTextField.setMinimumSize(d);
		custAddressJTextField.setPreferredSize(d);
		addCustJPanel.add(custAddressJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		custEmailJLabel.setMinimumSize(d);
		custEmailJLabel.setPreferredSize(d);
		addCustJPanel.add(custEmailJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 8;
		custEmailJTextField.setMinimumSize(d);
		custEmailJTextField.setPreferredSize(d);
		addCustJPanel.add(custEmailJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 9;
		custPhoneJLabel.setMinimumSize(d);
		custPhoneJLabel.setPreferredSize(d);
		addCustJPanel.add(custPhoneJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 10;
		custPhoneJTextField.setMinimumSize(d);
		custPhoneJTextField.setPreferredSize(d);
		addCustJPanel.add(custPhoneJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 11;
		custJButton.setMinimumSize(d);
		custJButton.setPreferredSize(d);
		addCustJPanel.add(custJButton, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		JScrollPane custScrollPane = new JScrollPane(custJTextArea);
		viewCustJPanel.add(custScrollPane, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		viewCustById.setMinimumSize(d);
		viewCustById.setPreferredSize(d);
		viewCustJPanel.add(viewCustById, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		custIdCombo.setMinimumSize(d);
		custIdCombo.setPreferredSize(d);
		custIdCombo.setSelectedIndex(0);
		viewCustJPanel.add(custIdCombo, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		viewCustJButton.setMinimumSize(d);
		viewCustJButton.setPreferredSize(d);
		viewCustJPanel.add(viewCustJButton, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		viewCustByName.setMinimumSize(d);
		viewCustByName.setPreferredSize(d);
		viewCustJPanel.add(viewCustByName, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		custNameCombo.setMinimumSize(d);
		custNameCombo.setPreferredSize(d);
		custNameCombo.setSelectedIndex(0);
		viewCustJPanel.add(custNameCombo, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		viewCustNameJButton.setMinimumSize(d);
		viewCustNameJButton.setPreferredSize(d);
		viewCustJPanel.add(viewCustNameJButton, gc);
		gc.gridx = 0;
		gc.gridy = 8;
		viewAllCustJButton.setMinimumSize(d);
		viewAllCustJButton.setPreferredSize(d);
		viewCustJPanel.add(viewAllCustJButton, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		editFindCustIdJLabel.setMinimumSize(d);
		editFindCustIdJLabel.setPreferredSize(d);
		editCustJPanel.add(editFindCustIdJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		editCustIdCombo.setMinimumSize(d);
		editCustIdCombo.setPreferredSize(d);
		editCustIdCombo.setSelectedItem(0);
		editCustJPanel.add(editCustIdCombo, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		findCustById.setMinimumSize(d);
		findCustById.setPreferredSize(d);
		editCustJPanel.add(findCustById, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		editCustNameJLabel.setMinimumSize(d);
		editCustNameJLabel.setPreferredSize(d);
		editCustJPanel.add(editCustNameJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		editCustName.setMinimumSize(d);
		editCustName.setPreferredSize(d);
		editCustJPanel.add(editCustName, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		editCustAddressJLabel.setMinimumSize(d);
		editCustAddressJLabel.setPreferredSize(d);
		editCustJPanel.add(editCustAddressJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		editCustAddress.setMinimumSize(d);
		editCustAddress.setPreferredSize(d);
		editCustJPanel.add(editCustAddress, gc);
		gc.gridx = 0;
		gc.gridy = 8;
		editCustEmailJLabel.setMinimumSize(d);
		editCustEmailJLabel.setPreferredSize(d);
		editCustJPanel.add(editCustEmailJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 9;
		editCustEmail.setMinimumSize(d);
		editCustEmail.setPreferredSize(d);
		editCustJPanel.add(editCustEmail, gc);
		gc.gridx = 0;
		gc.gridy = 10;
		editCustPhoneJLabel.setMinimumSize(d);
		editCustPhoneJLabel.setPreferredSize(d);
		editCustJPanel.add(editCustPhoneJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 11;
		editCustPhone.setMinimumSize(d);
		editCustPhone.setPreferredSize(d);
		editCustJPanel.add(editCustPhone, gc);
		gc.gridx = 0;
		gc.gridy = 12;
		updateCustJButton.setMinimumSize(d);
		updateCustJButton.setPreferredSize(d);
		editCustJPanel.add(updateCustJButton, gc);
		gc.gridx = 0;
		gc.gridy = 13;
		deleteCustJButton.setMinimumSize(d);
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
					custIdCombo.addItem(Integer.toString(customer.getCustId()));
					custNameCombo.addItem(customer.getCustName());
					editCustIdCombo.addItem(Integer.toString(customer.getCustId()));
					JOptionPane.showMessageDialog(null, "New Customer Added");
					editCustomerListOfInvoices.addElement(custIdJTextField.getText());
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
						if(customer.getCustId() == Integer.parseInt(custIdCombo.getSelectedItem().toString())){
							custJTextArea.setText(" Customer Id: "+customer.getCustId()
									+"\n Name: "+customer.getCustName()
									+"\n Address: "+customer.getCustAddress()
									+"\n Email: "+customer.getCustEmail()
									+"\n Phone: "+customer.getCustTelephone());
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
		
		viewCustNameJButton.addActionListener(new ActionListener(){
			// function to view a customer by id or name
			public void actionPerformed(ActionEvent e){
			if(customers.size() >= 1){
						for(Customer customer: customers){
						if(customer.getCustName() == custNameCombo.getSelectedItem()){
							custJTextArea.setText(" Customer Id: "+customer.getCustId()
									+"\n Name: "+customer.getCustName()
									+"\n Address: "+customer.getCustAddress()
									+"\n Email: "+customer.getCustEmail()
									+"\n Phone: "+customer.getCustTelephone());
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
				custJTextArea.setText(null);
					if(customers.size() >= 1){
						for(Customer customer: customers){
							
							custJTextArea.append("\n Customer Id: "+customer.getCustId()
										+"\n Name: "+customer.getCustName()
										+"\n Address: "+customer.getCustAddress()
										+"\n Email: "+customer.getCustEmail()
										+"\n Phone: "+customer.getCustTelephone()
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
						if(customer.getCustId() == Integer.parseInt(editCustIdCombo.getSelectedItem().toString())){
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
						if(customer.getCustId() == Integer.parseInt(editCustIdCombo.getSelectedItem().toString())){
							customer.setCustName(editCustName.getText());
							customer.setCustAddress(editCustAddress.getText());
							customer.setCustEmail(editCustEmail.getText());
							customer.setCustTelephone(editCustPhone.getText());
							JOptionPane.showMessageDialog(null, "Customer Updated.");
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
						if(customer.getCustId() == Integer.parseInt(editCustIdCombo.getSelectedItem().toString())){
							custIdCombo.removeItem(editCustIdCombo.getSelectedItem());
							custNameCombo.removeItem(editCustIdCombo.getSelectedItem());
							editCustIdCombo.removeItem(editCustIdCombo.getSelectedItem());
							customers.remove(customer);
							JOptionPane.showMessageDialog(null, "Customer Deleted");
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
		this.suppIdPopulate(suppIdCombo);
		this.suppNamePopulate(suppNameCombo);
		this.suppIdPopulate(editSuppIdCombo);
		gc.gridx = 0;
		gc.gridy = 1;
		supplierIdJLabel.setMinimumSize(d);
		supplierIdJLabel.setPreferredSize(d);
		addSupplyJPanel.add(supplierIdJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		supplierIdJTextField.setMinimumSize(d);
		supplierIdJTextField.setPreferredSize(d);
		addSupplyJPanel.add(supplierIdJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		supplierNameJLabel.setMinimumSize(d);
		supplierNameJLabel.setPreferredSize(d);
		addSupplyJPanel.add(supplierNameJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		supplierNameJTextField.setMinimumSize(d);
		supplierNameJTextField.setPreferredSize(d);
		addSupplyJPanel.add(supplierNameJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		supplierAddressJLabel.setMinimumSize(d);
		supplierAddressJLabel.setPreferredSize(d);
		addSupplyJPanel.add(supplierAddressJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		supplierAddressJTextField.setMinimumSize(d);
		supplierAddressJTextField.setPreferredSize(d);
		addSupplyJPanel.add(supplierAddressJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		supplierEmailJLabel.setMinimumSize(d);
		supplierEmailJLabel.setPreferredSize(d);
		addSupplyJPanel.add(supplierEmailJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 8;
		supplierEmailJTextField.setMinimumSize(d);
		supplierEmailJTextField.setPreferredSize(d);
		addSupplyJPanel.add(supplierEmailJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 9;
		supplierPhoneJLabel.setMinimumSize(d);
		supplierPhoneJLabel.setPreferredSize(d);
		addSupplyJPanel.add(supplierPhoneJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 10;
		supplierPhoneJTextField.setMinimumSize(d);
		supplierPhoneJTextField.setPreferredSize(d);
		addSupplyJPanel.add(supplierPhoneJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 11;
		supplierJButton.setMinimumSize(d);
		supplierJButton.setPreferredSize(d);
		addSupplyJPanel.add(supplierJButton, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		JScrollPane suppJScrollPane = new JScrollPane(supplierJTextArea);
		viewSupplyJPanel.add(suppJScrollPane, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		viewSupplyJLabel.setMinimumSize(d);
		viewSupplyJLabel.setPreferredSize(d);
		viewSupplyJPanel.add(viewSupplyJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		suppIdCombo.setMinimumSize(d);
		suppIdCombo.setPreferredSize(d);
		suppIdCombo.setSelectedIndex(0);
		viewSupplyJPanel.add(suppIdCombo, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		viewSupplyJButton.setMinimumSize(d);
		viewSupplyJButton.setPreferredSize(d);
		viewSupplyJPanel.add(viewSupplyJButton, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		viewSupplyNameJLabel.setMinimumSize(d);
		viewSupplyNameJLabel.setPreferredSize(d);
		viewSupplyJPanel.add(viewSupplyNameJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		suppNameCombo.setMinimumSize(d);
		suppNameCombo.setPreferredSize(d);
		suppNameCombo.setSelectedIndex(0);
		viewSupplyJPanel.add(suppNameCombo, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		viewSupplyNameJButton.setMinimumSize(d);
		viewSupplyNameJButton.setPreferredSize(d);
		viewSupplyJPanel.add(viewSupplyNameJButton, gc);
		gc.gridx = 0;
		gc.gridy = 8;
		allSupplyJButton.setMinimumSize(d);
		allSupplyJButton.setPreferredSize(d);
		viewSupplyJPanel.add(allSupplyJButton, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		editFindSuppIdJLabel.setMinimumSize(d);
		editFindSuppIdJLabel.setPreferredSize(d);
		editSupplyJPanel.add(editFindSuppIdJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		editSuppIdCombo.setMinimumSize(d);
		editSuppIdCombo.setPreferredSize(d);
		editSuppIdCombo.setSelectedIndex(0);
		editSupplyJPanel.add(editSuppIdCombo, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		editSupplierJButton.setMinimumSize(d);
		editSupplierJButton.setPreferredSize(d);
		editSupplyJPanel.add(editSupplierJButton, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		editSuppNameJLabel.setMinimumSize(d);
		editSuppNameJLabel.setPreferredSize(d);
		editSupplyJPanel.add(editSuppNameJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		editSupplierName.setMinimumSize(d);
		editSupplierName.setPreferredSize(d);
		editSupplyJPanel.add(editSupplierName, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		editSuppAddressJLabel.setMinimumSize(d);
		editSuppAddressJLabel.setPreferredSize(d);
		editSupplyJPanel.add(editSuppAddressJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		editSupplierAddress.setMinimumSize(d);
		editSupplierAddress.setPreferredSize(d);
		editSupplyJPanel.add(editSupplierAddress, gc);
		gc.gridx = 0;
		gc.gridy = 8;
		editSuppEmailJLabel.setMinimumSize(d);
		editSuppEmailJLabel.setPreferredSize(d);
		editSupplyJPanel.add(editSuppEmailJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 9;
		editSupplierEmail.setMinimumSize(d);
		editSupplierEmail.setPreferredSize(d);
		editSupplyJPanel.add(editSupplierEmail, gc);
		gc.gridx = 0;
		gc.gridy = 10;
		editSuppPhoneJLabel.setMinimumSize(d);
		editSuppPhoneJLabel.setPreferredSize(d);
		editSupplyJPanel.add(editSuppPhoneJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 11;
		editSupplierPhone.setMinimumSize(d);
		editSupplierPhone.setPreferredSize(d);
		editSupplyJPanel.add(editSupplierPhone, gc);
		gc.gridx = 0;
		gc.gridy = 12;
		editDeliveryJLabel.setMinimumSize(d);
		editDeliveryJLabel.setPreferredSize(d);
		editSupplyJPanel.add(editDeliveryJLabel, gc);
		gc.gridx = 0;
		gc.gridy = 13;
		editSupplierDelivery.setMinimumSize(d);
		editSupplierDelivery.setPreferredSize(d);
		editSupplyJPanel.add(editSupplierDelivery, gc);
		gc.gridx = 0;
		gc.gridy = 14;
		saveSupplierJButton.setMinimumSize(d);
		saveSupplierJButton.setPreferredSize(d);
		editSupplyJPanel.add(saveSupplierJButton, gc);
		gc.gridx = 0;
		gc.gridy = 15;
		deleteSupplierJButton.setPreferredSize(d);
		deleteSupplierJButton.setMinimumSize(d);
		editSupplyJPanel.add(deleteSupplierJButton, gc);

		supplierJButton.addActionListener(new ActionListener(){
			// function to add a new supplier
			public void actionPerformed(ActionEvent e){
				try{	
					Supplier supplier = new Supplier(Integer.parseInt(supplierIdJTextField.getText()), supplierNameJTextField.getText(), 
							supplierAddressJTextField.getText(), supplierEmailJTextField.getText(), supplierPhoneJTextField.getText());
					suppliers.add(supplier);
					JOptionPane.showMessageDialog(null, "New Supplier Added");
					suppIdCombo.addItem(supplierIdJTextField.getText());
					suppNameCombo.addItem(supplierNameJTextField.getText());
					editSuppIdCombo.addItem(supplierIdJTextField.getText());
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
							if(supplier.getId() == Integer.parseInt(suppIdCombo.getSelectedItem().toString())){
								supplierJTextArea.setText(" Supplier Id: "+supplier.getId()
										+"\n Name: "+supplier.getName()
										+"\n Address: "+supplier.getAddress()
										+"\n Email: "+supplier.getEmail()
										+"\n Phone: "+supplier.getPhone()
										+"\n Delivery Time: "+supplier.getDaysToDeliver());
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
		
		viewSupplyNameJButton.addActionListener(new ActionListener(){
			// function to view a supplier by id or name
			public void actionPerformed(ActionEvent e){
				if(suppliers.size() >= 1){
					for(Supplier supplier: suppliers){
						if(supplier.getName() == suppNameCombo.getSelectedItem()){
							supplierJTextArea.setText(" Supplier Id: "+supplier.getId()
									+"\n Name: "+supplier.getName()
									+"\n Address: "+supplier.getAddress()
									+"\n Email: "+supplier.getEmail()
									+"\n Phone: "+supplier.getPhone()
									+"\n Delivery Time: "+supplier.getDaysToDeliver());
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
				supplierJTextArea.setText(null);
					if(suppliers.size() >= 1){
						for(Supplier supplier: suppliers){
							supplierJTextArea.append("\n Supplier Id: "+supplier.getId()
									+"\n Name: "+supplier.getName()
									+"\n Address: "+supplier.getAddress()
									+"\n Email: "+supplier.getEmail()
									+"\n Phone: "+supplier.getPhone()
									+"\n Delivery Time: "+supplier.getDaysToDeliver()+"\n");
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
						if(supplier.getId() == Integer.parseInt(editSuppIdCombo.getSelectedItem().toString())){
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
						if(supplier.getId() == Integer.parseInt(editSuppIdCombo.getSelectedItem().toString())){
							supplier.setName(editSupplierName.getText());
							supplier.setAddress(editSupplierAddress.getText());
							supplier.setEmail(editSupplierEmail.getText());
							supplier.setPhone(editSupplierPhone.getText());
							supplier.setDaysToDeliver(Integer.parseInt(editSupplierDelivery.getText()));
							JOptionPane.showMessageDialog(null, "Supplier Updated");
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
						if(supplier.getId() == Integer.parseInt(editSuppIdCombo.getSelectedItem().toString())){
							suppIdCombo.removeItem(editSuppIdCombo.getSelectedItem());
							suppNameCombo.removeItem(editSuppIdCombo.getSelectedItem());
							editSuppIdCombo.removeItem(editSuppIdCombo.getSelectedItem());
							suppliers.remove(supplier);
							JOptionPane.showMessageDialog(null, "Supplier Deleted");
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
		//enterProdCodeJTextField.setPreferredSize(d);
		//editProductJPanel.add(enterProdCodeJTextField, gc);
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
		fillComboBox();
		findInvoiceComponentsJPanel.setLayout(new GridBagLayout());
		gc.gridx = 0;
		gc.gridy = 1;
		editComboBoxInvoice = new JComboBox<String>(editListOfInvoices); //Combo box rather than Text Field
		editListOfInvoices.setSelectedItem(editExistingInvoiceNums.get(0));
		findInvoiceComponentsJPanel.add(editComboBoxInvoice, gc);
		editComboBoxInvoice.setPreferredSize(d);
		gc.gridx = 0;
		gc.gridy = 2;
		editInvoiceJButton.setPreferredSize(d);
		findInvoiceComponentsJPanel.add(editInvoiceJButton, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		editComboBoxCustomerInvoice = new JComboBox<String>(editCustomerListOfInvoices); //Combo box rather than Text Field
		editCustomerListOfInvoices.setSelectedItem(editExistingCustomerInvoiceNums.get(0));
		findInvoiceComponentsJPanel.add(editComboBoxCustomerInvoice, gc);
		editComboBoxCustomerInvoice.setPreferredSize(d);
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
				String s = (String)editComboBoxCustomerInvoice.getSelectedItem();
				int id = Integer.parseInt( s );
				for(Invoice invoice: invoices){
					if(id == invoice.getCustomer().getCustId() ){
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
				String s = (String)editComboBoxInvoice.getSelectedItem();
				int id = Integer.parseInt( s );
				for(Invoice invoice: invoices){
					if(invoice.getId() == id){
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
				String s = (String)editComboBoxInvoice.getSelectedItem();
				int comboIndex = (int)editComboBoxInvoice.getSelectedIndex();
				int id = Integer.parseInt( s );
				for(Invoice invoice: invoices){
					if(invoice.getId() == id){
						index = invoices.indexOf(invoice);
					}
				}
				invoices.remove(index);
				JOptionPane.showMessageDialog(null, "Deleted!");
				editComboBoxInvoice.removeItemAt(comboIndex);
				editCustomerInvoiceComponentsJPanel.setVisible(false);
				editInvoiceComponentsJPanel.setVisible(false);
				saveInvoiceComponentsJPanel.setVisible(false);
				editInvoiceProductsComponentsJPanel.setVisible(false);
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
		createOrderSupplierIdComboBox = new JComboBox<String>(listOfSuppliers);
		listOfSuppliers.setSelectedItem("Select");
		createOrderSupplierIdComboBox.setPreferredSize(d);
		createNewOrderLeftPanel.add(createOrderSupplierIdComboBox,orderGC);
		//=====
		orderGC.gridx = 0;
		orderGC.gridy = 2;
		createNewOrderLeftPanel.add(createOrderProductCodeLabel,orderGC);
		orderGC.gridx = 1;
		orderGC.gridy = 2;
		createOrderProductIdComboBox = new JComboBox<String> (listOfProductId);
		listOfProductId.setSelectedItem("Select");
		createOrderProductIdComboBox.setPreferredSize(d);
		createNewOrderLeftPanel.add(createOrderProductIdComboBox,orderGC);
		//=====
		orderGC.gridx = 0;
		orderGC.gridy = 3;
		createNewOrderLeftPanel.add(createOrderQuantityLabel,orderGC);
		orderGC.gridx = 1;
		orderGC.gridy = 3;
		createOrderQuantityTextField.setPreferredSize(d);
		createNewOrderLeftPanel.add(createOrderQuantityTextField,orderGC);
		//=====
		orderGC.gridx = 1;
		orderGC.gridy = 4;
		createOrderAddProductButton.setPreferredSize(d);
		createNewOrderLeftPanel.add(createOrderAddProductButton,orderGC);
		orderGC.gridx = 1;
		orderGC.gridy = 5;
		orderGC.weighty = 10;
		createOrderConfirmOrderButton.setPreferredSize(d);
		createNewOrderLeftPanel.add(createOrderConfirmOrderButton,orderGC);
		JButton resetOrderPanelButton = new JButton("Reset Fields");
		gc.gridx = 1;
		gc.gridy = 6;
		resetOrderPanelButton.setPreferredSize(d);
		createNewOrderLeftPanel.add(resetOrderPanelButton,gc);
		resetOrderPanelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				createOrderOrderIdTextField.setText("");
				createOrderSupplierIdTextField.setText("");
				createOrderProductIdTextField.setText("");
				createOrderQuantityTextField.setText("");
				createOrderOrderIdTextField.setEnabled(true);
				createOrderSupplierIdTextField.setEnabled(true);
				createOrderScrollPaneTextArea.setText("");
				createOrderScrollPaneTextArea.setCaretPosition(0);
				listOfSuppliers.setSelectedItem("Select");
        		listOfOrders.setSelectedItem("Select");
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
				String supplierId = (String) createOrderSupplierIdComboBox.getSelectedItem();
				String productCode = createOrderProductIdTextField.getText();
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
				String supplierIdString = (String) createOrderSupplierIdComboBox.getSelectedItem();
				String productCodeString = createOrderProductIdTextField.getText();
				String quantityString = createOrderQuantityTextField.getText();

				if((orderIdString.trim().equals("")||orderIdString.matches(".*\\D.*"))
					||	(supplierIdString.trim().equals("")||supplierIdString.matches(".*\\D.*"))
					||	(productCodeString.trim().equals(""))
					||	(quantityString.trim().equals("")||quantityString.matches(".*\\D.*"))){
					JOptionPane.showMessageDialog (null, "Please ensure all text fields have been filled", "Missing Info", JOptionPane.WARNING_MESSAGE);
				}
				else{
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
						if(productExists){
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
								createOrderProductIdTextField.setText("");
								createOrderQuantityTextField.setText("");
								createOrderScrollPaneTextArea.setText("");
								createOrderScrollPaneTextArea.setCaretPosition(0);
								
								listOfProductId.setSelectedItem("Select");
								listOfSuppliers.setSelectedItem("Select");
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
		//get the arrayList of existing order and supplier IDs for the comboBoxes
		for(int i=0; i<orders.size(); i++){
			existingOrderIds.add(Integer.toString(orders.get(i).getOrderUniqueId()));
        }
        for(int i = 0; i< suppliers.size(); i++){
    	   	existingSupplierIds.add(Integer.toString(suppliers.get(i).getId()));
        }
        for(int i = 0; i< products.size(); i++){
    	   	existingTitles.add((products.get(i).getTitle()));
        }
        for(int i = 0; i< products.size(); i++){
    	   	existingAuthors.add((products.get(i).getAuthor()));
        }
		Dimension d2 = new Dimension(300, 30);
		Dimension size1 = getPreferredSize();
		size1.width = 500;
		viewOrderJPanel.setPreferredSize(size1);
		//====
		viewOrderLeftJPanel.setLayout(new GridBagLayout());
		viewOrderRightJPanel.setLayout(new GridBagLayout());
		viewOrderJPanel.setLayout(new GridBagLayout());
		GridBagConstraints viewOrderGC = new GridBagConstraints();
		viewOrderGC.insets = new Insets(5,5,5,5);
		//====
		viewOrderGC.gridx = 0;
		viewOrderGC.gridy = 1;
		viewOrderViewAllOrdersButton.setMinimumSize(d);
		viewOrderViewAllOrdersButton.setPreferredSize(d);
		viewOrderLeftJPanel.add(viewOrderViewAllOrdersButton, viewOrderGC);
		viewOrderViewAllOrdersButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewOrderTextArea.setText(Order.viewAllOrders(orders));	
				viewOrderTextArea.setCaretPosition(0);
			}
		});
		//====
		viewOrderGC.gridx = 0;
		viewOrderGC.gridy = 2;
		viewOrderViewReceivedButton.setPreferredSize(d);
		viewOrderViewReceivedButton.setMinimumSize(d);
		viewOrderLeftJPanel.add(viewOrderViewReceivedButton, viewOrderGC);
		viewOrderViewReceivedButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewOrderTextArea.setText(Order.viewReceivedOrders(orders));	
				viewOrderTextArea.setCaretPosition(0);	
			}
		});
		//====
		viewOrderGC.gridx = 0;
		viewOrderGC.gridy = 3;
		viewOrderViewUnreceivedButton.setPreferredSize(d);
		viewOrderViewUnreceivedButton.setMinimumSize(d);
		viewOrderLeftJPanel.add(viewOrderViewUnreceivedButton, viewOrderGC);
		viewOrderViewUnreceivedButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewOrderTextArea.setText(Order.viewUnreceivedOrders(orders));		
				viewOrderTextArea.setCaretPosition(0);
			}
		});
		//====
		viewOrderGC.gridx = 1;
		viewOrderGC.gridy = 1;
		viewOrderLeftJPanel.add(viewOrderOrderIdLabel, viewOrderGC);
		//TODO comboBox order
		viewOrderOrderIdComboBox = new JComboBox<>(listOfOrders);
		viewOrderOrderIdComboBox.setPreferredSize(d);
		viewOrderOrderIdComboBox.setMinimumSize(d);
		listOfOrders.setSelectedItem("Select");
		viewOrderGC.gridx = 2;
		viewOrderGC.gridy = 1;
		viewOrderLeftJPanel.add(viewOrderOrderIdComboBox, viewOrderGC);
		viewOrderGC.gridx = 3;
		viewOrderGC.gridy = 1;
		viewOrderOrderIdButton.setPreferredSize(d2);
		viewOrderOrderIdButton.setMinimumSize(d2);
		viewOrderLeftJPanel.add(viewOrderOrderIdButton, viewOrderGC);
		viewOrderOrderIdButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = (String) viewOrderOrderIdComboBox.getSelectedItem();
				if(input.trim().equals("") || input.matches(".*\\D.*")){
					viewOrderTextArea.setText("Please enter a valid number");
					listOfOrders.setSelectedItem("Select");
					listOfSuppliers.setSelectedItem("Select");
				}else{
					int num = Integer.parseInt(input);
					viewOrderTextArea.setText(Order.viewByOrderId(orders, num)); 	
					viewOrderTextArea.setCaretPosition(0);
					listOfOrders.setSelectedItem("Select");
					listOfSuppliers.setSelectedItem("Select");
				}
			}
		});
		//====
		viewOrderGC.gridx = 1;
		viewOrderGC.gridy = 2;
		viewOrderLeftJPanel.add(viewOrderSupplierIdLabel,viewOrderGC);
		viewOrderSupplierIdComboBox = new JComboBox<>(listOfSuppliers);
		viewOrderSupplierIdComboBox.setPreferredSize(d);
		viewOrderSupplierIdComboBox.setMinimumSize(d);
		listOfSuppliers.setSelectedItem("Select");
		viewOrderGC.gridx = 2;
		viewOrderGC.gridy = 2;
		viewOrderLeftJPanel.add(viewOrderSupplierIdComboBox, viewOrderGC);
		viewOrderGC.gridx = 3;
		viewOrderGC.gridy = 2;
		viewOrderSupplierIdButton.setPreferredSize(d2);
		viewOrderSupplierIdButton.setMinimumSize(d2);
		viewOrderLeftJPanel.add(viewOrderSupplierIdButton,viewOrderGC);
		viewOrderSupplierIdButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = (String) viewOrderSupplierIdComboBox.getSelectedItem();
				if(input.trim().equals("") || input.matches(".*\\D.*")){ 
					viewOrderTextArea.setText("Please enter a valid number");
					listOfOrders.setSelectedItem("Select");
					listOfSuppliers.setSelectedItem("Select");
				}else{
					int num = Integer.parseInt(input);
					viewOrderTextArea.setText(Order.viewOrderBySupplier(orders, num));		
					viewOrderTextArea.setCaretPosition(0);
					listOfOrders.setSelectedItem("Select");
					listOfSuppliers.setSelectedItem("Select");

				}
			}
		});
		//====
		viewOrderGC.gridx = 1;
		viewOrderGC.gridy = 3;
		viewOrderLeftJPanel.add(viewOrderTitleLabel, viewOrderGC);
		viewOrderTitleComboBox = new JComboBox<>(listOfTitles);
		viewOrderTitleComboBox.setPreferredSize(d);
		viewOrderTitleComboBox.setMinimumSize(d);
		listOfTitles.setSelectedItem("Select");
		viewOrderGC.gridx = 2;
		viewOrderGC.gridy = 3;
		viewOrderLeftJPanel.add(viewOrderTitleComboBox, viewOrderGC);
		viewOrderGC.gridx = 3;
		viewOrderGC.gridy = 3;
		viewOrderTitleButton.setPreferredSize(d2);
		viewOrderTitleButton.setMinimumSize(d2);
		viewOrderLeftJPanel.add(viewOrderTitleButton, viewOrderGC);
		viewOrderTitleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = (String) viewOrderTitleComboBox.getSelectedItem();
				if(input.trim().equals("")){ 
					viewOrderTextArea.setText("Please enter a title");
					listOfTitles.setSelectedItem("Select");
					listOfOrders.setSelectedItem("Select");
				}else{
					viewOrderTextArea.setText(Order.viewOrderByTitle(orders, input));		
					viewOrderTextArea.setCaretPosition(0);
					listOfTitles.setSelectedItem("Select");
					listOfOrders.setSelectedItem("Select");
				}
			}
		});
		//====
		viewOrderGC.gridx = 1;
		viewOrderGC.gridy = 4;
		viewOrderLeftJPanel.add(viewOrderAuthorLabel, viewOrderGC);
		viewOrderAuthorComboBox = new JComboBox<>(listOfAuthors);
		viewOrderAuthorComboBox.setPreferredSize(d);
		viewOrderAuthorComboBox.setMinimumSize(d);
		listOfAuthors.setSelectedItem("Select");
		viewOrderGC.gridx = 2;
		viewOrderGC.gridy = 4;
		viewOrderLeftJPanel.add(viewOrderAuthorComboBox, viewOrderGC);
		viewOrderGC.gridx = 3;
		viewOrderGC.gridy = 4;
		viewOrderAuthorButton.setPreferredSize(d2);
		viewOrderAuthorButton.setMinimumSize(d2);
		viewOrderLeftJPanel.add(viewOrderAuthorButton,viewOrderGC);
		viewOrderAuthorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = (String) viewOrderAuthorComboBox.getSelectedItem();
				if(input.trim().equals("")){ 
					viewOrderTextArea.setText("Please enter an author's name");
					listOfAuthors.setSelectedItem("Select");
					listOfOrders.setSelectedItem("Select");
				}else{
					viewOrderTextArea.setText(Order.viewOrderByAuthor(orders, input));		
					viewOrderTextArea.setCaretPosition(0);
					listOfAuthors.setSelectedItem("Select");
					listOfOrders.setSelectedItem("Select");
				}
			}
		});
		//====
		viewOrderTextArea = new JTextArea(20, 50); //height - width
		viewOrderTextArea.setEditable(false);
		JScrollPane viewOrderScrollPane = new JScrollPane(viewOrderTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        viewOrderGC.gridwidth = GridBagConstraints.REMAINDER;
        viewOrderGC.fill = GridBagConstraints.BOTH;
        viewOrderGC.weightx = 1.0;
        viewOrderGC.weighty = 1.0;
        viewOrderGC.gridx = 0;
        viewOrderGC.gridy = 0;
        viewOrderRightJPanel.add(viewOrderScrollPane, viewOrderGC);
        viewOrderGC.gridx = 0;
        viewOrderGC.gridy = 1;
        viewOrderJPanel.add(viewOrderLeftJPanel, viewOrderGC);
        viewOrderGC.gridx = 0;
        viewOrderGC.gridy = 0;
        viewOrderJPanel.add(viewOrderRightJPanel, viewOrderGC);
		//=========================================================================================
        //add edit order components	
        findOrderComponentsJPanel.setLayout(new GridBagLayout());
        gc.gridx = 0;
        gc.gridy = 1;
        editOrderOrderIdComboBox = new JComboBox<String> (listOfOrders);
        editOrderOrderIdComboBox.setPreferredSize(d);
        listOfOrders.setSelectedItem("Select");
        findOrderComponentsJPanel.add(editOrderOrderIdComboBox, gc);
        gc.gridx = 0;
        gc.gridy = 2;
        editOrderJButton.setPreferredSize(d);
        findOrderComponentsJPanel.add(editOrderJButton, gc);
        gc.gridx = 0;
        gc.gridy = 3;
        editOrderSupplierIdComboBox = new JComboBox<String> (listOfSuppliers);
        editOrderSupplierIdComboBox.setPreferredSize(d);
        editOrderSupplierIdComboBox.setSelectedItem("Select");
        findOrderComponentsJPanel.add(editOrderSupplierIdComboBox, gc);
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
        editSupplierOrderComponentsJPanel.add(receiveAllOrdersJButton);

        receiveAllOrdersJButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		String s = (String) editOrderSupplierIdComboBox.getSelectedItem();
        		for(Order order: orders){
        			if(Integer.parseInt(s.trim()) == order.getSupplierUniqueId() ){
        				order.setReceived();
        			}
        		}
        		JOptionPane.showMessageDialog(null, "Received!");
        		editSupplierOrderJButton.doClick();
        		listOfSuppliers.setSelectedItem("Select");
        		listOfOrders.setSelectedItem("Select");
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
        editOrderComponentsJPanel.add(editOrderReceivedStatus);
        editOrderReceivedStatus.setEditable(false);
        editOrderComponentsJPanel.add(receiveOrderJButton);
        receiveOrderJButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		String s = (String) editOrderOrderIdComboBox.getSelectedItem();
        		for(Order order: orders){
        			if(Integer.parseInt(s.trim()) == order.getOrderUniqueId()){
        				order.setReceived();
        				break;
        			}
        		}
        		JOptionPane.showMessageDialog(null, "Received!");
        		editOrderReceivedStatus.setForeground(Color.BLACK);
        		editOrderJButton.doClick();	
        		listOfSuppliers.setSelectedItem("Select");
        		listOfOrders.setSelectedItem("Select");
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
        		String s = (String) editOrderOrderIdComboBox.getSelectedItem();
        		for(Order order: orders){
        			if(order.getOrderUniqueId() == Integer.parseInt(s.trim())){
        				index = orders.indexOf(order);
        			}
        		}
        		orders.remove(index);
        		JOptionPane.showMessageDialog(null, "Deleted!");
        		editSupplierOrderComponentsJPanel.setVisible(false);
        		editOrderComponentsJPanel.setVisible(false);
        		saveOrderComponentsJPanel.setVisible(false);
        		listOfSuppliers.setSelectedItem("Select");
        		listOfOrders.setSelectedItem("Select");
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
		comboBoxInvoice.setPreferredSize(d);
		listOfInvoices.setSelectedItem("select"); //setting the combo box to the first invoice number
		gc.gridx = 1;
		gc.gridy = 1;
		viewCustomerPanel.add(comboBoxInvoice,gc);
		JButton invButton = new JButton("Invoice ID");	//button
		gc.gridx = 2;
		gc.gridy = 1;
		invButton.setPreferredSize(d);
		viewCustomerPanel.add(invButton,gc);
		//Action listener For Button to view Invoice by Id
		invButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = (String)comboBoxInvoice.getSelectedItem();
				if(input.trim().equals("") || input.matches(".*\\D.*")){ //regEx
					textarea.setText("Please enter a valid number");
					textarea.setCaretPosition(0);
					listOfCustomers.setSelectedItem("select");
					listOfInvoices.setSelectedItem("select");
				}else{
					int num = Integer.parseInt(input);
					textarea.setText(invoice.viewInvoiceById(num, invoices)); //viewInvoiceById() is in the Invoice Class
					textarea.setCaretPosition(0);
					listOfCustomers.setSelectedItem("select");
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
		comboBoxCustomer.setPreferredSize(d);
		listOfCustomers.setSelectedItem("select");
		gc.gridx = 1;
		gc.gridy = 2;
		viewCustomerPanel.add(comboBoxCustomer,gc);
		JButton custIdButton = new JButton("Customer ID");
		gc.gridx = 2;
		gc.gridy = 2;
		custIdButton.setPreferredSize(d);
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
					listOfCustomers.setSelectedItem("select");
					listOfInvoices.setSelectedItem("select");
				}else{
					int num = Integer.parseInt(input);
					textarea.setText(invoice.viewInvoiceByCustomer(num, invoices));	//viewInvoiceByCustomer() is in the Invoice class
					textarea.setCaretPosition(0);
					listOfInvoices.setSelectedItem("select");
				
				}
			}
		});
		
		//Button x3: 	View All/ View Paid/ View UnPaid
		//1. View all Button
		JButton viewAllBtn = new JButton("View All");
		gc.gridx = 2;
		gc.gridy = 3;
		viewAllBtn.setPreferredSize(d);
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
		viewPaidBtn.setPreferredSize(d);
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
		gc.gridx = 3;
		gc.gridy = 2;
		viewUnpaidBtn.setPreferredSize(d);
		viewCustomerPanel.add(viewUnpaidBtn,gc);
		viewUnpaidBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textarea.setText(invoice.viewUnPaidInvoice(invoices));	//viewUnPaidInvoice() is in the invoice class
				textarea.setCaretPosition(0);
			}
		});
		
		
		//4. Reset Panel Btn
		JButton resetPanelBtn = new JButton("Clear Panel");
		gc.gridx = 3;
		gc.gridy = 3;
		resetPanelBtn.setPreferredSize(d);
		viewCustomerPanel.add(resetPanelBtn,gc);
		resetPanelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textarea.setText("");
				listOfCustomers.setSelectedItem("select");
				listOfInvoices.setSelectedItem("select");
				
			}
		});
		
		
		//========================== Pie Chart View Paid Vs. Unpaid Invoices ========================
		JButton invoicesPieChart = new JButton(" Paid Vs. Unpaid Invoices");
		gc.gridx =1;
		gc.gridy= 3;
		viewCustomerPanel.add(invoicesPieChart,gc);
		invoicesPieChart.setPreferredSize(new Dimension(200,30));
		invoicesPieChart.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e){
				//int paid = invoice.viewUnPaidInvoice(invoices);
				int count=0;
				int paid = invoice.countPaidInvoices(count, invoices);
				int unpaid = (invoices.size()-paid);
				//invoice.countPaidInvoices(, invoices);
				//pieDataset.setValue("Paid", invoice.countPaidInvoices(buttonHeight, invoices));
				pieDataset.setValue("Paid",paid);
				pieDataset.setValue("UnPaid",unpaid);
				//pieDataset.setValue("Three", new Integer(30));
				//pieDataset.setValue("Four", new Integer(40));
				
				JFreeChart chart = ChartFactory.createPieChart3D("Invoice Review", pieDataset, true,true,true);
				//PiePlot3D p=(PiePlot3D)chart.getPlot();
			//	ChartPanel chPanel = new ChartPanel(chart);
			//	chPanel.setPreferredSize(new Dimension(785, 440));
			//	chPanel.setMouseWheelEnabled(true);
			//	viewCustomerPanel.add(chPanel);
				ChartFrame frame = new ChartFrame("Pie Chart", chart);
				frame.setVisible(true);
				frame.setSize(450,500);
			}
			
		});
		
		//===============================================================================================
		
		
		
	
		//==============================================
		//TODO Marc: Create Invoice Functionality
		
		//================================
		//Left Panel Components
		//================================
		leftPanel.setLayout(new GridBagLayout());
		
		//Get the info to fill the list of details for each dropdown
		for(int i=0;i<employees.size();i++){
			empIdVector.add(Integer.toString(employees.get(i).getEmployeeId()));
		}
		for(int i=0;i<customers.size();i++){
			cusIdVector.add(Integer.toString(customers.get(i).getCustId()));
		}
		for(int i=0;i<products.size();i++){
			prodIdVector.add(products.get(i).getProductCode());
		}
		
		//GridBagConstraints gc = new GridBagConstraints();
		createInvJPanel.add(createNewInvoicePanel);
		gc.insets = new Insets(80,5,5,5);
		//=====
		gc.gridx = 0;
		gc.gridy = 0;
		leftPanel.add(invIdLbl,gc);
		invTextF = new JTextField();
		gc.gridx = 1;
		gc.gridy = 0;
		invTextF.setPreferredSize(d);
		leftPanel.add(invTextF,gc);
		//=====
		gc.insets = new Insets(5,5,5,5);
		gc.gridx = 0;
		gc.gridy = 1;
		leftPanel.add(employLbl,gc);
		empIDComboBox = new JComboBox<String>(listOfEmpIds);
		empIDComboBox.setPreferredSize(d);
		listOfEmpIds.setSelectedItem("select");
		gc.gridx = 1;
		gc.gridy = 1;
		leftPanel.add(empIDComboBox,gc);
		
		//=====
		gc.gridx = 0;
		gc.gridy = 2;
		leftPanel.add(custId,gc);
			//Add Combo here
		cusIDComboBox = new JComboBox<String>(listOfCusIds);
		cusIDComboBox.setPreferredSize(d);
		listOfCusIds.setSelectedItem("select");
		gc.gridx = 1;
		gc.gridy = 2;
		leftPanel.add(cusIDComboBox,gc);
		//=====
		gc.gridx = 0;
		gc.gridy = 3;
		leftPanel.add(prodId,gc);
			//Add combo here
		prodIDComboBox = new JComboBox<String>(listOfProdIds);
		prodIDComboBox.setPreferredSize(d);
		listOfProdIds.setSelectedItem("select");
		gc.gridx = 1;
		gc.gridy = 3;
		leftPanel.add(prodIDComboBox,gc);
		//=====
		gc.gridx = 0;
		gc.gridy = 4;
		leftPanel.add(quantitylbl,gc);
		gc.gridx = 1;
		gc.gridy = 4;
		quantityTextF = new JTextField();
		quantityTextF.setPreferredSize(d);
		leftPanel.add(quantityTextF,gc);
		//=====
		gc.gridx = 1;
		gc.gridy = 5;
		addMoreBtn.setPreferredSize(d); //width/height
		leftPanel.add(addMoreBtn,gc);
		//AddMoreBtn Event Listener
		addMoreBtn.addActionListener(new ActionListener() {
			//TODO Add more products to Invoice
			@Override
			public void actionPerformed(ActionEvent e) {
				String prodId =(String)prodIDComboBox.getSelectedItem();;
				String quan = quantityTextF.getText();
				if(prodId.equals("select")|| (quan.trim().equals("") || quan.matches(".*\\D.*"))){
					JOptionPane.showMessageDialog (null, "Please ensure all text fields have been filled", "Missing Info", JOptionPane.WARNING_MESSAGE);
				}else{
					//disable the other text fileds
					invTextF.setEnabled(false);
					empIDComboBox.setEnabled(false);
					cusIDComboBox.setEnabled(false);
					
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
		finishBtn.setPreferredSize(d);
		leftPanel.add(finishBtn,gc);
		//finishBtn eventListener
		finishBtn.addActionListener(new ActionListener() {
			//TODO Finish creating Invoice
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println(addMoreArrayList.size());
				String invoiceIdStr = invTextF.getText();
				String employeeIdStr = (String)empIDComboBox.getSelectedItem();
				String customerIdStr = (String)cusIDComboBox.getSelectedItem();
				String productIdStr = (String)prodIDComboBox.getSelectedItem();
				String quantityStr = quantityTextF.getText();
				
				//Make sure all text fields are filled with RELAVENT content
				if((invoiceIdStr.trim().equals("")||invoiceIdStr.matches(".*\\D.*"))
					||	(employeeIdStr.equals("select"))
					||	(customerIdStr.equals("select"))
					||	(productIdStr.trim().equals(""))
					||	(quantityStr.equals("select")))
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
									//existingInvoiceNums.add(invoiceIdStr);
									
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
									editListOfInvoices.addElement(inputFromTestField);
									String inputFromCusId = custTextF.getText();
									listOfCustomers.addElement(inputFromCusId);
									//input.setText("");
									//reset the text Boxes to Null
									invTextF.setText("");
									listOfEmpIds.setSelectedItem("select");
									listOfCusIds.setSelectedItem("select");
									listOfProdIds.setSelectedItem("select");
									quantityTextF.setText("");
									textAreaMarc.setText(outputMessage);
									textAreaMarc.setCaretPosition(0);
									invTextF.setEnabled(true);
									empIDComboBox.setEnabled(true);
									cusIDComboBox.setEnabled(true);
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
		resetBtn.setPreferredSize(d); //width/height
		leftPanel.add(resetBtn,gc);
		resetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				invTextF.setText("");
				listOfEmpIds.setSelectedItem("select");
				listOfCusIds.setSelectedItem("select");
				listOfProdIds.setSelectedItem("select");
				quantityTextF.setText("");
				textAreaMarc.setText("");
				invTextF.setEnabled(true);
				empIDComboBox.setEnabled(true);
				cusIDComboBox.setEnabled(true);
				addMoreArrayList = new ArrayList<InvoiceProduct>();
				
			}
		});
	
		
		
		//================================
		//Right Panel : textAreaMarc and Pane
		//================================
		
		textAreaMarc = new JTextArea(19,20); //height - width
		textAreaMarc.setEditable(false);
		JScrollPane scrollPane3 = new JScrollPane(textAreaMarc,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       /* gc.gridwidth = GridBagConstraints.REMAINDER;
        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 1.0;
        gc.weighty = 1.0;
        gc.gridy = 4;*/
		rightPanel.setBorder(new EmptyBorder(80, 10, 10, 10));
        rightPanel.add(scrollPane3, gc);
		
		
		//Main Panel Add
        createNewInvoicePanel.add(leftPanel);
        createNewInvoicePanel.add(rightPanel);
		
		//End of Marc Functionality
		//==============================================
		
		// TODO Product Details
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
        
        // For Loop used to Populate Combo Box of ProductCode/ID
        for(int i=0;i<products.size();i++){
			 existingProductId.add((products.get(i).getProductCode()));
       }
      
		// First Label and controls:	View Product by ID 
		JLabel productIdlbl = new JLabel("Enter Product ID: "); //Label
		productGC.gridx = 0;
		productGC.gridy = 1;
		viewProductDetails.add(productIdlbl,productGC);
		comboBoxProductId = new JComboBox<>(listOfProductId);
		comboBoxProductId.setEditable(true);
		comboBoxProductId.setPreferredSize(d);
		comboBoxProductId.setMinimumSize(d);
		//viewProductIdTextField = new JTextField(10); //Text Field
		productGC.gridx = 1;
		productGC.gridy = 1;
		viewProductDetails.add(comboBoxProductId,productGC);
		//viewProductDetails.add(viewProductIdTextField,productGC);
		JButton productButton = new JButton("Search Product ID");	//button
		productGC.gridx = 2;
		productGC.gridy = 1;
		viewProductDetails.add(productButton,productGC);
		productButton.setPreferredSize(d);
		productButton.setMinimumSize(d);
		//Action listener For Button to view Product by Id
		productButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = (String)comboBoxProductId.getSelectedItem();
				
				//String input = viewProductIdTextField.getText();
				// This method could be enhanced by adding in a check 
				//to ensure 9 digits have been entered to match an ISBN number.
				if(input.trim().equals("")){ 
					//textarea.setText("Please enter a valid ID");	
					JOptionPane.showMessageDialog(null, "Please Enter a Value in the ID Field");
					//viewProductIdTextField.setText("");
					//productTitleTextField.setText("");
				}else{
				
					productTextArea.setText(product.viewProductById(input, products)); //viewInvoiceById() is in the Invoice Class
					productTextArea.setCaretPosition(0);
					//viewProductIdTextField.setText("");
					//productTitleTextField.setText("");
					//productAuthorTextField.setText("");
					productTextArea.setCaretPosition(0);
				}
			}
		});
		
		// For Loop to populate combo box of Title.
		 for(int i=0;i<products.size();i++){
			 existingProductTitle.add((products.get(i).getTitle()));
       }
		
		//Second Label and controls: 	View Product by Title
		JLabel productTitlelbl = new JLabel("Product Title: ");
		productGC.gridx = 0;
		productGC.gridy = 2;
		viewProductDetails.add(productTitlelbl,productGC);
		comboBoxProductTitle = new JComboBox<>(listofProductTitle);
		comboBoxProductTitle.setEditable(true);
		comboBoxProductTitle.setPreferredSize(d);
		comboBoxProductTitle.setMinimumSize(d);
		//productTitleTextField = new JTextField(10);
		productGC.gridx = 1;
		productGC.gridy = 2;
		viewProductDetails.add(comboBoxProductTitle,productGC);
		JButton productTitleButton = new JButton("Search Product Title");
		productGC.gridx = 2;
		productGC.gridy = 2;
		viewProductDetails.add(productTitleButton,productGC);
		productTitleButton.setPreferredSize(d);
		productTitleButton.setMinimumSize(d);
		productTitleButton.addActionListener(new ActionListener() {
			//Action listener For Button to view product by Title
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = (String)comboBoxProductTitle.getSelectedItem();
				//String input = productTitleTextField.getText();
				
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
		
		// For Loop to populate ComboBox of Author.
				 for(int i=0;i<products.size();i++){
					 existingProductAuthor.add((products.get(i).getAuthor()));
		       }
		
		
		//Third Label and controls: 	View Product by Author
		JLabel productAuthorlbl = new JLabel("Product Author: ");
		productGC.gridx = 0;
		productGC.gridy = 3;
		viewProductDetails.add(productAuthorlbl,productGC);
		comboBoxProductAuthor = new JComboBox<>(listOfProductAuthor);
		comboBoxProductAuthor.setEditable(true);
		comboBoxProductAuthor.setPreferredSize(d);
		comboBoxProductAuthor.setMinimumSize(d);
		productAuthorTextField = new JTextField(10);
		productGC.gridx = 1;
		productGC.gridy = 3;
		viewProductDetails.add(comboBoxProductAuthor,productGC);
		JButton productAuthorBtn = new JButton("Search Author");
		productGC.gridx = 2;
		productGC.gridy = 3;
		viewProductDetails.add(productAuthorBtn,productGC);
		productAuthorBtn.setPreferredSize(d);
		productAuthorBtn.setMinimumSize(d);
		productAuthorBtn.addActionListener(new ActionListener() {
			
			//Action listener For Button to view product by Title
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = ((String)comboBoxProductAuthor.getSelectedItem()).toLowerCase();
				//String input = (productAuthorTextField.getText()).toLowerCase();	// Convert input text to lower case. 
																					//All names in array should be stored in lower case.
				
				if(input.trim().equals("")){ 	// If no text is entered
					
					JOptionPane.showMessageDialog(null, "Please Enter a Value in the Author Field");
					productAuthorTextField.setText("");
					
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
		viewAllProductsBtn.setPreferredSize(d);
		viewAllProductsBtn.setMinimumSize(d);
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
		viewAllBelowMinReorder.setPreferredSize(d);
		viewAllBelowMinReorder.setMinimumSize(d);
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
		viewAllAboveMaxReorder.setPreferredSize(d);
		viewAllAboveMaxReorder.setMinimumSize(d);
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
		JButton searchByRetail = new JButton ("Search by retail price");
		productGC.gridx = 0;
		productGC.gridy = 4;
		viewProductDetails.add(searchByRetail,productGC);
		searchByRetail.setPreferredSize(d);
		searchByRetail.setMinimumSize(d);
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
		
		JButton costGraph = new JButton ("Stock by cost price graph");
		costGraph.setPreferredSize(d);
		costGraph.setMinimumSize(d);
		productGC.gridx = 0;
		productGC.gridy = 6;
		viewProductDetails.add(costGraph,productGC);
		
		costGraph.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				DefaultCategoryDataset costData = new DefaultCategoryDataset();
				costData.setValue(product.quantityByCost(0.01, 1.99, products), "Price", "under 2");
				costData.setValue(product.quantityByCost(2.00, 3.00, products), "Price", "2 to 3");
				costData.setValue(product.quantityByCost(3.01, 5.00, products), "Price", "3 to 5");
				costData.setValue(product.quantityByCost(5.01, 200.99, products), "Price", "over 5");
			
				JFreeChart costChart = ChartFactory.createBarChart("Cost price chart", "Price range", "Stock quantity", costData, PlotOrientation.VERTICAL, false, true, false);
				CategoryPlot p = costChart.getCategoryPlot();
				p.setRangeGridlinePaint(Color.BLACK);
				ChartFrame retailGraphFrame = new ChartFrame("stock value chart",costChart);
				retailGraphFrame.setVisible(true);
				retailGraphFrame.setSize(450, 350);
			}
		});
		
		JButton salesGraph = new JButton ("Sales and 3 month prediction graph");
		productGC.gridx = 1;
		productGC.gridy = 6;
		viewProductDetails.add(salesGraph,productGC);
		
		
		
		salesGraph.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				DefaultCategoryDataset salesData = new DefaultCategoryDataset();
				salesData.setValue(invoice.graphSales(3, invoices), "Month", "April");
				salesData.setValue(invoice.graphSales(4, invoices), "Month", "May");
				salesData.setValue(invoice.graphSales(5, invoices), "Month", "June");
				salesData.setValue(invoice.graphSales(6, invoices), "Month", "July");
				salesData.setValue(invoice.graphSales(7, invoices), "Month", "August");
				salesData.setValue(invoice.graphSales(8, invoices), "Month", "September");
				salesData.setValue(invoice.graphSales(9, invoices), "Month", "October");
				salesData.setValue(invoice.graphSales(10,invoices), "Month", "November");
				salesData.setValue(invoice.graphSales(11, invoices), "Month", "December");
				JFreeChart salesChart = ChartFactory.createBarChart("Sales and prediction Chart", "Week", "Sales value", salesData, PlotOrientation.VERTICAL, false, true, false);
				CategoryPlot p = salesChart.getCategoryPlot();
				p.setRangeGridlinePaint(Color.BLACK);
				ChartFrame salesGraphFrame = new ChartFrame("Sales and predictions", salesChart);
				salesGraphFrame.setVisible(true);
				salesGraphFrame.setSize(450, 350);
			}
		});
		

		//Button 8: to search stock by quantity range
		JButton searchByQuantity = new JButton ("Search by current stock quantity");
		productGC.gridx = 0;
		productGC.gridy = 5;
		viewProductDetails.add(searchByQuantity,productGC);
		searchByQuantity.setPreferredSize(d);
		searchByQuantity.setMinimumSize(d);
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

		// to edit product	
		
		 // For Loop used to Populate Combo Box of ProductCode/ID
        for(int i=0;i<products.size();i++){
			 existingEditProdId.add((products.get(i).getProductCode()));
       }
		comboBoxEditProdId = new JComboBox<>(listToEditProdIds);
		comboBoxEditProdId.setEditable(true);
		comboBoxEditProdId.setPreferredSize(d);
		comboBoxEditProdId.setMinimumSize(d);
		productGC.gridx = 0;
		productGC.gridy = 2;
		editProductJPanel.add(comboBoxEditProdId,productGC);
		
		editDetailsJButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				for(Product product: products){
					if(product.getProductCode().equals(comboBoxEditProdId.getSelectedItem())){
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
		
		//Profit & Loss Account Panel
		proflossJPanel.setLayout(new GridBagLayout());
		pLComponentsJPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5,5,5,5);
		pLJTable.setRowHeight(ROW_HEIGHT);
		pLJTable.setEnabled(false);
		pLJTable.setAutoCreateRowSorter(true);	
		DefaultRowSorter sorter = ((DefaultRowSorter)pLJTable.getRowSorter());
		ArrayList list = new ArrayList();
		list.add( new RowSorter.SortKey(0, SortOrder.ASCENDING) );
		sorter.setSortKeys(list);
		sorter.sort();	
		pLComponentsJPanel.add(pLJScrollPane, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		pLComponentsJPanel.add(new JLabel("Total: "), gbc);
		pLTotal.setPreferredSize(d);
		gbc.gridx = 0;
		gbc.gridy = 2;
		pLComponentsJPanel.add(pLTotal, gbc);
		pLTotal.setText("0.00");
		pLTotal.setEditable(false);
		gbc.gridx = 0;
		gbc.gridy = 3;
		fillPLComboBox();
		comboBoxPL = new JComboBox<String>(listOfMonths); //Combo box rather than Text Field
		listOfMonths.setSelectedItem(months.get(0));
		comboBoxPL.setPreferredSize(d);
		pLComponentsJPanel.add(comboBoxPL, gbc);
		pLViewButton.setPreferredSize(d);
		gbc.gridx = 0;
		gbc.gridy = 4;
		pLComponentsJPanel.add(pLViewButton, gbc);
        viewTableButtonHandler vtbh = new viewTableButtonHandler();
        pLViewButton.addActionListener(vtbh);
        proflossJPanel.add(pLComponentsJPanel, gbc);
        
        lineChartJButton.setPreferredSize(d);
		gbc.gridx = 0;
		gbc.gridy = 5;
		pLComponentsJPanel.add(lineChartJButton, gbc);
		
		lineChartJButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					JFreeChart lineChart = ChartFactory.createLineChart("Income and Expenditure","Month","Value",line_chart_dataset,PlotOrientation.VERTICAL,true,true,false);
					ChartFrame frame = new ChartFrame("Income and Expenditure", lineChart);
					frame.setBounds(0, 0, 600, 600);
					frame.setVisible(true);
				}catch (Exception i){
		             System.out.println(i);
		         }
			}
		});
	
		//Graph Information Panel
		graphJPanel.setLayout(new GridBagLayout());
		GridBagConstraints graphgc = new GridBagConstraints();
		graphgc.insets = new Insets(5,5,5,5);
		//========================== Pie Chart Highest lowest Selling ===============================
				//TODO high low
				highestSellingButton = new JButton("Highest Selling");
				graphgc.gridx = 1;
				graphgc.gridy = 1;
				highestSellingButton.setPreferredSize(d);
				graphJPanel.add(highestSellingButton,graphgc);
				/*try{
					highestSellingButton.setIcon(new ImageIcon("C:\\Users\\marc\\Desktop\\GitHubRepo\\TeamProject\\RetailSystem\\src\\images\\top.png"));
					
					}catch(Exception ex){
						System.out.println("not working");
					}*/
				highestSellingButton.addActionListener(new ActionListener() {
					
					@SuppressWarnings("rawtypes")
					@Override
					public void actionPerformed(ActionEvent ex) {
						productCodes = findProductCodes();
						countsHigher = new int[productCodes.size()];

						// count occuernces of each product in the invoices
						for (Invoice v : invoices) {
							for(InvoiceProduct inp : v.getInvoiceProducts()){
							for(int i=0;i<productCodes.size();i++){
								if (inp.getProduct().getProductCode().equals(productCodes.get(i)))
									{
										countsHigher[i]+=inp.getQuantity();
									}
								}
							}
						}
						
						//Filling the hash map
						HashMap<String, Integer> hmap = new HashMap<String, Integer>();
						for(int i = 0;i<countsHigher.length;i++){
							hmap.put(productCodes.get(i) + "\n" + products.get(i).getTitle(), countsHigher[i]);
						}
						
						//Sorting the HashMap
						Map<String, Integer> map = sortByValues(hmap, true);
						//System.out.println("After sorting: ");
						Set set2 = map.entrySet();
						Iterator iterator2 = set2.iterator();
						int counter = 0;
						int [] popularValue = new int [topNum];
						String [] popular = new String [topNum];
						while (iterator2.hasNext() && counter < topNum) {
							Map.Entry me2 = (Map.Entry) iterator2.next();
							//System.out.print(me2.getKey() + " : ");
							popularValue[counter] = (int) me2.getValue();
							popular[counter] =  (String) me2.getKey();
							counter++;
						}
						
						//Fill the data
						String first = popular[0];
						String second = popular[1];
						String third = popular[2];
						String fourth = popular[3];
						String fifth = popular[4];
						
						int fir = popularValue[0];
						int sec = popularValue[1];
						int thir = popularValue[2];
						int fou = popularValue[3];
						int fift = popularValue[4];
		 				
						DefaultPieDataset pieDataset = new DefaultPieDataset();
						pieDataset.setValue(first, fir);
						pieDataset.setValue(second, sec);
						pieDataset.setValue(third, thir);
						pieDataset.setValue(fourth, fou);
						pieDataset.setValue(fifth, fift);
						
						JFreeChart chart = ChartFactory.createPieChart3D("Top 5 Highest Selling", pieDataset, true, true, true); //3D pie chart
						//PiePlot3D p = (PiePlot3D)chart.getPlot();
						ChartFrame frame = new ChartFrame("Pie Chart", chart);
						frame.setVisible(true);
						//frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
						frame.setSize(850, 600);
					}
				});
				
				lowsetsellingButton = new JButton("Lowest selling");
				graphgc.gridx = 2;
				graphgc.gridy = 1;
				lowsetsellingButton.setPreferredSize(d);
				graphJPanel.add(lowsetsellingButton,graphgc);
				lowsetsellingButton.addActionListener(new ActionListener() {
					
					@SuppressWarnings("rawtypes")
					@Override
					public void actionPerformed(ActionEvent ex) {

						productCodes = findProductCodes();
						countsLower = new int[productCodes.size()];
						
						// count occuernces of each product in the invoices
						for (Invoice v : invoices) {
							for(InvoiceProduct inp : v.getInvoiceProducts()){
							for(int i=0;i<productCodes.size();i++){
								if (inp.getProduct().getProductCode().equals(productCodes.get(i)))
									{
									countsLower[i]+=inp.getQuantity();
									}
								}
							}
						}
						
						//Filling the hash map
						HashMap<String, Integer> hmap = new HashMap<String, Integer>();
						for(int i = 0;i<countsLower.length;i++){
							hmap.put(productCodes.get(i) + "\n" + products.get(i).getTitle(), countsLower[i]);
						}
						
						//Sorting the HashMap
						Map<String, Integer> map = sortByValues(hmap, false);
						//System.out.println("After sorting: ");
						Set set2 = map.entrySet();
						Iterator iterator2 = set2.iterator();
						int counter = 0;
						int [] popularValue = new int [topNum];
						String [] popular = new String [topNum];
						while (iterator2.hasNext() && counter < topNum) {
							Map.Entry me2 = (Map.Entry) iterator2.next();
							//System.out.print(me2.getKey() + " : ");
							popularValue[counter] = (int) me2.getValue();
							popular[counter] =  (String) me2.getKey();
							counter++;
						}
						
						//Fill the data
						String first = popular[0];
						String second = popular[1];
						String third = popular[2];
						String fourth = popular[3];
						String fifth = popular[4];
						
						int fir = popularValue[0];
						int sec = popularValue[1];
						int thir = popularValue[2];
						int fou = popularValue[3];
						int fift = popularValue[4];
		 				
						DefaultPieDataset pieDataset = new DefaultPieDataset();
						pieDataset.setValue(first, fir);
						pieDataset.setValue(second, sec);
						pieDataset.setValue(third, thir);
						pieDataset.setValue(fourth, fou);
						pieDataset.setValue(fifth, fift);
						
						JFreeChart chart = ChartFactory.createPieChart3D("Top 5 Lowest Selling", pieDataset, true, true, true); //3D pie chart
						//PiePlot3D p = (PiePlot3D)chart.getPlot();
						ChartFrame frame = new ChartFrame("Pie Chart", chart);
						frame.setVisible(true);
						//frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
						frame.setSize(850, 600);
					}
				});
				
				//===========================================================================================
		
		
		} //END OF CONSTRUCTOR
	//TODO - end of constructor
	
	public void createInvoices(){
		//add some test employees to array list
				employees.add(new Employee(123, "John", 0, 200000.00, 1111));
				employees.add( new Employee(234, "Tim", 1, 150000.00, 3333));
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
				invoiceProducts1.add(new InvoiceProduct(products.get(0), 1));
				invoiceProducts1.add(new InvoiceProduct(products.get(1), 2));
				invoiceProducts1.add(new InvoiceProduct(products.get(2), 3));
				invoiceProducts1.add(new InvoiceProduct(products.get(3), 31));
				invoiceProducts1.add(new InvoiceProduct(products.get(4), 6));
				invoiceProducts2.add(new InvoiceProduct(products.get(5), 89));
				invoiceProducts2.add(new InvoiceProduct(products.get(6), 45));
				invoiceProducts2.add(new InvoiceProduct(products.get(7), 33));
				invoiceProducts2.add(new InvoiceProduct(products.get(8),45));
				invoiceProducts1.add(new InvoiceProduct(products.get(9), 7));
				invoiceProducts1.add(new InvoiceProduct(products.get(10), 22));
				invoiceProducts1.add(new InvoiceProduct(products.get(11), 13));
				invoiceProducts3.add(new InvoiceProduct(products.get(12), 18));
				invoiceProducts3.add(new InvoiceProduct(products.get(13), 21));
				invoiceProducts3.add(new InvoiceProduct(products.get(14), 24));
				invoiceProducts3.add(new InvoiceProduct(products.get(15), 7));
				invoiceProducts3.add(new InvoiceProduct(products.get(16), 8));
				invoiceProducts1.add(new InvoiceProduct(products.get(17), 8));
				invoiceProducts1.add(new InvoiceProduct(products.get(18), 100));
				invoiceProducts1.add(new InvoiceProduct(products.get(19), 101));
				invoiceProducts1.add(new InvoiceProduct(products.get(20), 102));
				
				//add some test invoices to array list

				//add some test orders to array list
				orders.add(new Order(1, 1, new OrderProduct(products.get(0), 10)));
				orders.add(new Order(2, 2, new OrderProduct(products.get(1), 15)));
				
				//Create a bunch of OrderProducts for the orders
				orderProducts1.add(new OrderProduct(products.get(0), 5));
				orderProducts1.add(new OrderProduct(products.get(1), 7));
				orderProducts1.add(new OrderProduct(products.get(3), 14));
				orderProducts1.add(new OrderProduct(products.get(5), 2));
				orderProducts1.add(new OrderProduct(products.get(1), 55));
				orderProducts1.add(new OrderProduct(products.get(4), 8));
				orderProducts1.add(new OrderProduct(products.get(7), 1));
				orderProducts2.add(new OrderProduct(products.get(4), 20));
				orderProducts2.add(new OrderProduct(products.get(3), 6));
				orderProducts2.add(new OrderProduct(products.get(6), 15));
				orderProducts2.add(new OrderProduct(products.get(6), 10));
				orderProducts2.add(new OrderProduct(products.get(2), 25));
				orderProducts2.add(new OrderProduct(products.get(4), 2));
				orderProducts2.add(new OrderProduct(products.get(6), 2));
				orderProducts3.add(new OrderProduct(products.get(3), 15));
				orderProducts3.add(new OrderProduct(products.get(1), 65));
				orderProducts3.add(new OrderProduct(products.get(7), 3));
				orderProducts3.add(new OrderProduct(products.get(2), 4));
				orderProducts3.add(new OrderProduct(products.get(6), 8));
				orderProducts3.add(new OrderProduct(products.get(1), 2));
				orderProducts3.add(new OrderProduct(products.get(3), 6));
				orderProducts3.add(new OrderProduct(products.get(0), 5));
				//Create a bunch of orders as dummy data
				orders.add(new Order(3, 1, orderProducts1));
				orders.add(new Order(4, 2, orderProducts1));
				orders.add(new Order(5, 3, orderProducts2));
				orders.add(new Order(6, 4, orderProducts3));
				orders.add(new Order(7, 5, orderProducts1));
				orders.add(new Order(8, 5, orderProducts2));
				orders.add(new Order(9, 6, orderProducts1));
				orders.add(new Order(10, 8, orderProducts3));
		
		invoices.add(new Invoice(1001, employees.get(0), customers.get(0), invoiceProducts1, 1, true));
		invoices.add(new Invoice(1002, employees.get(1), customers.get(1), invoiceProducts2, 1, true));
		invoices.add(new Invoice(1003, employees.get(0), customers.get(2), invoiceProducts3, 1, false));
		invoices.add(new Invoice(1004, employees.get(1), customers.get(3), invoiceProducts3, 10, true));
		invoices.add(new Invoice(1005, employees.get(0), customers.get(4), invoiceProducts2, 10, false));
		invoices.add(new Invoice(1006, employees.get(1), customers.get(5), invoiceProducts1, 10, true));
		invoices.add(new Invoice(1007, employees.get(0), customers.get(1), invoiceProducts1, 10, false));
		invoices.add(new Invoice(1008, employees.get(1), customers.get(2), invoiceProducts1, 2, false));
		invoices.add(new Invoice(1009, employees.get(0), customers.get(3), invoiceProducts2, 2, false));
		invoices.add(new Invoice(1010, employees.get(1), customers.get(4), invoiceProducts1, 2, true));
		invoices.add(new Invoice(1011, employees.get(0), customers.get(5), invoiceProducts2, 3, true));
		invoices.add(new Invoice(1012, employees.get(1), customers.get(1), invoiceProducts3, 3, false));
		invoices.add(new Invoice(1013, employees.get(0), customers.get(0), invoiceProducts3, 3, false));
		invoices.add(new Invoice(1014, employees.get(1), customers.get(1), invoiceProducts3, 4, true));
		invoices.add(new Invoice(1015, employees.get(0), customers.get(2), invoiceProducts2, 4, false));
		invoices.add(new Invoice(1016, employees.get(1), customers.get(0), invoiceProducts2, 4, false));
		invoices.add(new Invoice(1017, employees.get(0), customers.get(0), invoiceProducts2, 15, true));
		invoices.add(new Invoice(1018, employees.get(1), customers.get(3), invoiceProducts1, 15, false));
		invoices.add(new Invoice(1019, employees.get(0), customers.get(3), invoiceProducts1, 15, false));
		invoices.add(new Invoice(1020, employees.get(1), customers.get(4), invoiceProducts2, 8, true));
		invoices.add(new Invoice(1021, employees.get(0), customers.get(5), invoiceProducts3, 8, true));
		invoices.add(new Invoice(1022, employees.get(1), customers.get(1), invoiceProducts1, 8, false));
		invoices.add(new Invoice(1023, employees.get(0), customers.get(2), invoiceProducts1, 22, true));
		invoices.add(new Invoice(1024, employees.get(1), customers.get(3), invoiceProducts3, 20, false));
		invoices.add(new Invoice(1025, employees.get(0), customers.get(4), invoiceProducts3, 19, false));
		invoices.add(new Invoice(1026, employees.get(0), customers.get(5), invoiceProducts3, 30, true));
		invoices.add(new Invoice(1027, employees.get(0), customers.get(0), invoiceProducts3, 44, false));
		invoices.add(new Invoice(1028, employees.get(1), customers.get(0), invoiceProducts3, 66, false));
		invoices.add(new Invoice(1029, employees.get(0), customers.get(2), invoiceProducts2, 27, false));
		invoices.add(new Invoice(1030, employees.get(0), customers.get(2), invoiceProducts2, 25, true));
		invoices.add(new Invoice(1031, employees.get(1), customers.get(2), invoiceProducts2, 16, true));
		invoices.add(new Invoice(1032, employees.get(1), customers.get(2), invoiceProducts2, 13, false));
		invoices.add(new Invoice(1033, employees.get(0), customers.get(1), invoiceProducts2, 22, false));
		invoices.add(new Invoice(1034, employees.get(1), customers.get(3), invoiceProducts2, 33, true));
		invoices.add(new Invoice(1035, employees.get(0), customers.get(4), invoiceProducts2, 41, false));
		invoices.add(new Invoice(1036, employees.get(0), customers.get(5), invoiceProducts3, 39, false));
		invoices.add(new Invoice(1037, employees.get(0), customers.get(3), invoiceProducts3, 48, true));
		invoices.add(new Invoice(1038, employees.get(1), customers.get(1), invoiceProducts3, 50, false));
		invoices.add(new Invoice(1039, employees.get(0), customers.get(2), invoiceProducts1, 55, false));
		invoices.add(new Invoice(1040, employees.get(1), customers.get(0), invoiceProducts3, 60, true));
		invoices.add(new Invoice(1041, employees.get(1), customers.get(0), invoiceProducts1, 69, false));
		invoices.add(new Invoice(1042, employees.get(0), customers.get(1), invoiceProducts3, 71, false));
		invoices.add(new Invoice(1043, employees.get(1), customers.get(1), invoiceProducts2, 63, true));
		invoices.add(new Invoice(1044, employees.get(0), customers.get(1), invoiceProducts2, 34, true));
		invoices.add(new Invoice(1045, employees.get(0), customers.get(2), invoiceProducts2, 31, false));
		invoices.add(new Invoice(1046, employees.get(1), customers.get(2), invoiceProducts2, 66, false));
		invoices.add(new Invoice(1047, employees.get(0), customers.get(2), invoiceProducts2, 67, false));
		invoices.add(new Invoice(1048, employees.get(1), customers.get(4), invoiceProducts2, 52, false));
		invoices.add(new Invoice(1049, employees.get(1), customers.get(4), invoiceProducts2, 41, false));
		invoices.add(new Invoice(1050, employees.get(0), customers.get(5), invoiceProducts3, 46, true));
		
		orders.add(new Order(1001, 1, orderProducts1, 100));
		orders.add(new Order(1002, 2, orderProducts2, 100));
		orders.add(new Order(1003, 3, orderProducts3, 100));
		orders.add(new Order(1004, 4, orderProducts3, 10));
		orders.add(new Order(1005, 5, orderProducts3, 10));
		orders.add(new Order(1006, 6, orderProducts1, 10));
		orders.add(new Order(1007, 2, orderProducts1, 10));
		orders.add(new Order(1008, 3, orderProducts1, 2));
		orders.add(new Order(1009, 4, orderProducts2, 2));
		orders.add(new Order(1010, 5, orderProducts1, 222));
		orders.add(new Order(1011, 6, orderProducts2, 3));
		orders.add(new Order(1012, 2, orderProducts3, 365));
		orders.add(new Order(1013, 1, orderProducts3, 3));
		orders.add(new Order(1014, 2, orderProducts3, 4));
		orders.add(new Order(1015, 3, orderProducts2, 4));
		orders.add(new Order(1016, 1, orderProducts2, 4));
		orders.add(new Order(1017, 1, orderProducts2, 15));
		orders.add(new Order(1018, 4, orderProducts1, 15));
		orders.add(new Order(1019, 4, orderProducts1, 15));
		orders.add(new Order(1020, 5, orderProducts2, 8));
		orders.add(new Order(1021, 6, orderProducts3, 80));
		orders.add(new Order(1022, 2, orderProducts1, 8));
		orders.add(new Order(1023, 3, orderProducts1, 22));
		orders.add(new Order(1024, 4, orderProducts3, 200));
		orders.add(new Order(1025, 5, orderProducts3, 19));
		orders.add(new Order(1026, 6, orderProducts3, 30));
		orders.add(new Order(1027, 1, orderProducts3, 440));
		orders.add(new Order(1028, 1, orderProducts3, 66));
		orders.add(new Order(1029, 3, orderProducts2, 27));
		orders.add(new Order(1030, 3, orderProducts2, 25));
		orders.add(new Order(1031, 3, orderProducts2, 160));
		
		
		
	}
	
	public void fillComboBox(){
		//get comboBox contents
		for(Invoice invoice: invoices){
			editExistingInvoiceNums.add(Integer.toString(invoice.getId()));
		}
		for(Customer customer: customers){
			editExistingCustomerInvoiceNums.add(Integer.toString(customer.getCustId()));
		}
	}
	
	//fill profit and loss combo box
	public void fillPLComboBox(){
		months.add("Please Select");
		months.add("Current Month");
		months.add("Last Month");
		months.add("Last 3 Months");
		months.add("View All");
	}

	

	//Handler for edit invoice by id button
	private class EditInvoiceButtonHandler implements ActionListener{
		public void actionPerformed( ActionEvent e){//handler starts
			int id = 0;
			String s = (String)editComboBoxInvoice.getSelectedItem();
			id = Integer.parseInt( s );
			productInvoiceJTextArea.setText("Product Details\n");
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
						
		//Handler for receive orders by supplier button
		private class editSupplierOrderButtonHandler implements ActionListener{
			public void actionPerformed( ActionEvent e){//handler starts
					int count = 0, count1 = 0;;
					String s = "";
					double total = 0;
					String totalString = "";
					int id = 0, supplierID = 1;
					try {
						id = Integer.parseInt( editOrderSupplierIdComboBox.getSelectedItem().toString().trim() );
					}
					catch (NumberFormatException nfe){
						listOfOrders.setSelectedItem("Select");;
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
						supplierOrderJTextArea.setText("Unreceived Orders: ");
						for(Order order: orders){
							if(id == order.getSupplierUniqueId() ){
								if(!order.isReceived()){
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
							JOptionPane.showMessageDialog(loginJPanel, "No unreceived orders for this supplierer", "For your information", JOptionPane.INFORMATION_MESSAGE);
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
					loginComponentsJPanel.setVisible(false);
					logoutComponentsJPanel.setVisible(true);
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
					invJTabbedPane.setEnabledAt(2, false);
					orderJTabbedPane.setEnabledAt(2, false);
					supplyJTabbedPane.setEnabledAt(2, false);
					prodJTabbedPane.setEnabledAt(2, false);
					custJTabbedPane.setEnabledAt(2, false);	
					loginComponentsJPanel.setVisible(false);
					logoutComponentsJPanel.setVisible(true);
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
				int currentId = Integer.parseInt(editOrderOrderIdComboBox.getSelectedItem().toString().trim());
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
					listOfOrders.setSelectedItem(listOfOrders.getIndexOf(Integer.toString(currentId)));
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
					id = Integer.parseInt( editOrderOrderIdComboBox.getSelectedItem().toString().trim() );
				}
				catch (NumberFormatException nfe){
					listOfOrders.setSelectedItem("Select");;
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
							if(!order.isReceived()){
								editOrderReceivedStatus.setText("Unreceived");
								editOrderReceivedStatus.setForeground(Color.RED);
							}
							if(order.isReceived()){
								editOrderReceivedStatus.setText("Received");
								editOrderReceivedStatus.setForeground(Color.BLACK);
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
					String s = (String)editComboBoxCustomerInvoice.getSelectedItem();
					int id = Integer.parseInt( s );
					double total = 0;
					String totalString = "";
					int customerID = 1;
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
											"\nDate: " + sdf.format(invoice.getInvoiceDate())+ "\nTotal: " + 
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
						editInvoiceProductsComponentsJPanel.setVisible(false);
					}
				}
			}
						
		//handler for save button
		private class SaveButtonHandler implements ActionListener{
			public void actionPerformed( ActionEvent e){
				int invId = 0;						
				int empId = 0;
				int custId = 0;
				int comboIndex = (int)editComboBoxInvoice.getSelectedIndex();
				String s = (String)editComboBoxInvoice.getSelectedItem();
				int currentId = Integer.parseInt( s );
				int count1 = 0, count2 = 0;
				Employee emp = employees.get(0);
				Customer cust = customers.get(0);
				try{
					invId = Integer.parseInt(editInvoiceId.getText().trim());
					empId = Integer.parseInt(editInvoiceEmployee.getText().trim());
					custId = Integer.parseInt(editInvoiceCustomer.getText().trim());
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
				if (count1 != 0 && count2 != 0){
					for(Invoice invoice: invoices){
						if(currentId == invoice.getId()){
							invoice.setId(invId);
							invoice.setEmployee(emp);
							invoice.setCustomer(cust);
						}
					}
					JOptionPane.showMessageDialog(null, "Updated!");
					editComboBoxInvoice.removeAllItems();
					fillComboBox();
					editComboBoxInvoice.setSelectedItem(editExistingInvoiceNums.get(comboIndex));
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
		
		//Method to sort the hash map
		@SuppressWarnings({ "rawtypes", "unchecked" })
		private static HashMap<String, Integer> sortByValues(HashMap<String, Integer> map, boolean reverse) {
			List list = new LinkedList(map.entrySet());
			// Defined Custom Comparator here
			Collections.sort(list, new Comparator() {
				public int compare(Object o1, Object o2) {
					return ((Comparable) ((Map.Entry) (o1)).getValue())
							.compareTo(((Map.Entry) (o2)).getValue());
				}
			});
			if (reverse)
				Collections.reverse(list);
			// Here I am copying the sorted list in HashMap
			// using LinkedHashMap to preserve the insertion order
			HashMap sortedHashMap = new LinkedHashMap();
			for (Iterator it = list.iterator(); it.hasNext();) {
				Map.Entry entry = (Map.Entry) it.next();
				sortedHashMap.put(entry.getKey(), entry.getValue());
			}
			return sortedHashMap;
		}
		
		//TODO Method to get all the product codes from the ArrayList
		public ArrayList<String> findProductCodes(){
			ArrayList<String> returnCodeNames = new ArrayList<String>();
			
			for(Product p: products){
				returnCodeNames.add(p.getProductCode());
			}
			
			return returnCodeNames;
			
		}
		//dropdown functions
		public void empIDPopulate(JComboBox<String> combo){
			combo.addItem("Select");
			for(Employee employee: employees){
				String str = Integer.toString(employee.getEmployeeId());
				combo.addItem(str);
			}
		}
		public void empNamePopulate(){
			empNameCombo.addItem("Select");
			for(Employee employee: employees){
				String str = employee.getEmployeeName();
				empNameCombo.addItem(str);
			}
		}
		public void custIdPopulate(JComboBox<String> combo){
			combo.addItem("Select");
			for(Customer customer: customers){
				String str = Integer.toString(customer.getCustId());
				combo.addItem(str);
			}
		}
		public void custNamePopulate(JComboBox<String> combo){
			combo.addItem("Select");
			for(Customer customer: customers){
				String str = customer.getCustName();
				combo.addItem(str);
			}
		}
		public void suppIdPopulate(JComboBox<String> combo){
			combo.addItem("Select");
			for(Supplier supplier: suppliers){
				String str = Integer.toString(supplier.getId());
				combo.addItem(str);
			}
		}
		public void suppNamePopulate(JComboBox<String> combo){
			combo.addItem("Select");
			for(Supplier supplier: suppliers){
				String str = supplier.getName();
				combo.addItem(str);
			}
		}
		
		//handler for Profit and Loss table button
		//TODO Method to get fill table
		private class viewTableButtonHandler implements ActionListener{
			@SuppressWarnings("unchecked")
			public void actionPerformed( ActionEvent e){
				Collections.sort(invoices);
				Collections.sort(orders);
				String s = (String)comboBoxPL.getSelectedItem();
				double orderTotal = 0;
				double invoiceTotal = 0;
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				int currentMonth = cal.get(Calendar.MONTH);
				int currentYear = cal.get(Calendar.YEAR);
				int lastMonth = currentMonth - 1;
				int threeMonths = currentMonth - 2;
				//view all months
				if(s.equals("View All")){
					deleteRows();
					for(Invoice invoice:invoices){
						if(invoice.isPaid()){
							tableModel.addRow(new String[]{sdf.format(invoice.getInvoiceDate()), new String(String.format("%.2f", invoice.getTotalInvoicePrice())), ""});
							invoiceTotal = invoiceTotal + invoice.getTotalInvoicePrice();
						}
					}
					for(Order order:orders){
						tableModel.addRow(new String[]{sdf.format(order.getOrderDate()), "", new String(String.format("%.2f", order.getTotalOrderPrice())) });
						orderTotal = orderTotal + order.getTotalOrderPrice();
					}
					double runningTotal = invoiceTotal - orderTotal;
					String result = String.format("%.2f", runningTotal);
					pLTotal.setText(result);
				}
				//view last 3 months
				if(s.equals("Last 3 Months")){
					deleteRows();
					for(Invoice invoice:invoices){
						if(invoice.isPaid()){
							if(invoice.getInvoiceDate().getMonth() >= threeMonths && invoice.getInvoiceDate().getYear() +1900 == currentYear){
								tableModel.addRow(new String[]{sdf.format(invoice.getInvoiceDate()), new String(String.format("%.2f", invoice.getTotalInvoicePrice())), ""});
								invoiceTotal = invoiceTotal + invoice.getTotalInvoicePrice();
							}
						}
					}
					for(Order order:orders){
						if(order.getOrderDate().getMonth() >= threeMonths && order.getOrderDate().getYear() +1900 == currentYear){
							tableModel.addRow(new String[]{sdf.format(order.getOrderDate()), "", new String(String.format("%.2f", order.getTotalOrderPrice() ))});
							orderTotal = orderTotal + order.getTotalOrderPrice();
						}
					}
					double runningTotal = invoiceTotal - orderTotal;
					String result = String.format("%.2f", runningTotal);
					pLTotal.setText(result);
				}
				//view last month
				if(s.equals("Last Month")){
					deleteRows();
					int i =0;
					int rows = 0;
					for(i=0;i<tableModel.getRowCount();i++){
						tableModel.removeRow(rows);
					}
					for(Invoice invoice:invoices){
						if(invoice.isPaid()){
							if(invoice.getInvoiceDate().getMonth() == lastMonth && invoice.getInvoiceDate().getYear() +1900 == currentYear){
								tableModel.addRow(new String[]{sdf.format(invoice.getInvoiceDate()), new String(String.format("%.2f", invoice.getTotalInvoicePrice())), ""});
								invoiceTotal = invoiceTotal + invoice.getTotalInvoicePrice();
							}
						}
					}
					for(Order order:orders){
						if(order.getOrderDate().getMonth() == lastMonth && order.getOrderDate().getYear() +1900 == currentYear){
							tableModel.addRow(new String[]{sdf.format(order.getOrderDate()), "", new String(String.format("%.2f", order.getTotalOrderPrice()))});
							orderTotal = orderTotal + order.getTotalOrderPrice();
						}
					}
					double runningTotal = invoiceTotal - orderTotal;
					String result = String.format("%.2f", runningTotal);
					pLTotal.setText(result);
				}
				//view current month
				if(s.equals("Current Month")){
					deleteRows();
					int i =0;
					int rows = 0;
					for(i=0;i<tableModel.getRowCount();i++){
						tableModel.removeRow(rows);
					}
					for(Invoice invoice:invoices){
						if(invoice.isPaid()){
							if(invoice.getInvoiceDate().getMonth() == currentMonth && invoice.getInvoiceDate().getYear() +1900 == currentYear){
								tableModel.addRow(new String[]{sdf.format(invoice.getInvoiceDate()), new String(String.format("%.2f", invoice.getTotalInvoicePrice())), ""});
								invoiceTotal = invoiceTotal + invoice.getTotalInvoicePrice();
							}
						}
					}
					for(Order order:orders){
						if(order.getOrderDate().getMonth() == currentMonth && order.getOrderDate().getYear() +1900 == currentYear){
							tableModel.addRow(new String[]{sdf.format(order.getOrderDate()), "", new String(String.format("%.2f", order.getTotalOrderPrice()))});
							orderTotal = orderTotal + order.getTotalOrderPrice();
						}
					}
					double runningTotal = invoiceTotal - orderTotal;
					String result = String.format("%.2f", runningTotal);
					pLTotal.setText(result);
				}
			}
			public void deleteRows(){
				if (tableModel.getRowCount() > 0) {
				    for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
				    	tableModel.removeRow(i);
				    }
				}
			}
		}

}//End class
