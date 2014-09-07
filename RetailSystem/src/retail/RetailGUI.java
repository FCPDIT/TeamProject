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
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
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
	
	private JFrame mainJFrame;
	private GridBagConstraints gc = new GridBagConstraints();
	private JTabbedPane mainJTabbedPane;
	JScrollPane scrollPane;
	
	private JPanel loginJPanel;
	private JTabbedPane custJTabbedPane;
	private JTabbedPane supplyJTabbedPane;
	private JTabbedPane prodJTabbedPane;
	private JTabbedPane invJTabbedPane;
	private JTabbedPane orderJTabbedPane;
	private JTabbedPane accessJTabbedPane; 
	private JTabbedPane proflossJTabbedPane;
	
	private JPanel addCustJPanel;
	private JPanel viewCustJPanel;
	private JPanel editCustJPanel;
	
	private JPanel addSupplyJPanel;
	private JPanel viewSupplyJPanel;
	private JPanel editSupplyJPanel;
	
	private JPanel addProductJPanel;
	private JPanel editProductJPanel;
	
	private JPanel createInvJPanel;
	private JPanel viewInvJPanel;
	private JPanel editInvJPanel;
	
	private JPanel createOrderPanel;
	private JPanel viewOrderJPanel;
	private JPanel editOrderJPanel;
	
	private JPanel employeeJPanel;
	private JPanel viewEmployeeJPanel;
	private JPanel editEmployeeJPanel;
	
	private JPanel proflossJPanel;
	private JPanel graphJPanel;
	
	//login components
	private JPanel loginComponentsJPanel;
	private JTextField loginTF;
	private JPasswordField passwordTF;
	private JButton loginBut;
	
	//logout components
	private JPanel logoutComponentsJPanel;
	private JButton logoutBut;
	
	private DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
	
	//Customer Components
	private JLabel custIdJLabel;
	private JTextField custIdJTextField;
	private JLabel custNameJLabel;
	private JTextField custNameJTextField;
	private JLabel custAddressJLabel;
	private JTextField custAddressJTextField;
	private JLabel custEmailJLabel;
	private JTextField custEmailJTextField;
	private JLabel custPhoneJLabel;
	private JTextField custPhoneJTextField;	
	private JButton custJButton;
	private JButton viewCustJButton;
	private JButton viewCustNameJButton;
	private JButton viewAllCustJButton;
	private JButton findCustById;
	private JButton updateCustJButton;
	private JButton deleteCustJButton;
	private JLabel viewCustById;
	private JComboBox<String> custIdCombo;
	private JLabel viewCustByName;
	private JComboBox<String> custNameCombo;
	private JTextArea custJTextArea;
	private JComboBox<String> editCustIdCombo;
	private JLabel editCustNameJLabel;
	private JLabel editCustAddressJLabel;
	private JLabel editCustEmailJLabel;
	private JLabel editCustPhoneJLabel;
	private JTextField editCustName;
	private JTextField editCustAddress;
	private JTextField editCustEmail;
	private JTextField editCustPhone;
	
	//Supplier Components
	private JLabel supplierIdJLabel;
	private JTextField supplierIdJTextField;
	private JLabel supplierNameJLabel;
	private JTextField supplierNameJTextField;
	private JLabel supplierAddressJLabel;
	private JTextField supplierAddressJTextField;
	private JLabel supplierEmailJLabel;
	private JTextField supplierEmailJTextField;
	private JLabel supplierPhoneJLabel;
	private JTextField supplierPhoneJTextField;
	private JButton supplierJButton;
	private JLabel viewSupplyJLabel;
	private JComboBox<String> suppIdCombo;
	private JButton viewSupplyJButton;
	private JLabel viewSupplyNameJLabel;
	private JComboBox<String> suppNameCombo; 
	private JTextArea supplierJTextArea;
	private JButton viewSupplyNameJButton;
	private JButton allSupplyJButton;
	private JComboBox<String> editSuppIdCombo; 
	private JButton editSupplierJButton;
	private JLabel editSuppNameJLabel;
	private JLabel editSuppAddressJLabel;
	private JLabel editSuppEmailJLabel;
	private JLabel editSuppPhoneJLabel;
	private JLabel editDeliveryJLabel;
	private JTextField editSupplierName;
	private JTextField editSupplierAddress;
	private JTextField editSupplierEmail;
	private JTextField editSupplierPhone;
	private JTextField editSupplierDelivery;
	private JButton saveSupplierJButton;
	private JButton deleteSupplierJButton;
	
	//Employee Components
	private JLabel employeeId;
	private JTextField employeeIdField;
	private JLabel  employeeName; 
	private JTextField employeeNameField;
	private JLabel employeeAcess; 
	private JComboBox<Integer> employeeAcessField;
	private JLabel employeeSalary; 
	private JTextField employeeSalaryField;
	private JLabel employeePassword;
	private JTextField employeePassField;
	private JButton employeeJButton;
	private JLabel viewEmpId;
	private JComboBox<String> empIdCombo;
	private JButton viewEmpIdButton;
	private JLabel viewEmpName;
	private JComboBox<String> empNameCombo;
	private JButton viewEmpNameButton;
	private JLabel viewEmpAll;
	private JButton viewEmpAllButton;
	private JTextArea empJTextArea;
	private JComboBox<String> viewEmpIdCombo;
	private JButton editById;
	private JLabel editEmpName;
	private JTextField editEmpNameField;
	private JLabel editEmpAccess;
	private JTextField editEmpAccessField;
	private JLabel editEmpSalary;
	private JTextField editEmpSalaryField;
	private JLabel editEmpPassword;
	private JTextField editEmpPasswordField;
	private JButton updateEmployee;
	private JButton deleteEmployee;
	
	//Product Components
	private JLabel prodTitle;
	private JTextField titleJTextField;
	private JLabel prodAuthor;
	private JTextField authorJTextField;
	private JLabel prodCode;
	private JTextField codeJTextField;
	private JLabel prodRetail;
	private JTextField retailJTextField;
	private JLabel prodCost;
	private JTextField costJTextField;
	private JLabel prodTotalStock;
	private JTextField tStockJTextField;
	private JLabel prodMaxStock;
	private JTextField maxJTextField;
	private JLabel prodMinStock;
	private JTextField minJTextField;
	private JLabel prodSupplierId;
	private JTextField prodSupplierIdJTextField;
	private JButton productJButton;
	
	private JRadioButton under5Radio;
	private JRadioButton fiveTo10Radio;
	private JRadioButton tenTo20Radio;
	private JRadioButton over20Radio;
	private JRadioButton under50Radio;
	private JRadioButton fiftyTo100Radio;
	private JRadioButton hundredTo200Radio;
	private JRadioButton over200Radio;
	
	//edit product components
	private JLabel editProdTitle;
	private JTextField editTitleJTextField;
	private JLabel editProdAuthor;
	private JTextField editAuthorJTextField;
	private JLabel editProdCode;
	private JTextField editCodeJTextField;
	private JLabel editProdRetail;
	private JTextField editRetailJTextField;
	private JLabel editProdCost;
	private JTextField editCostJTextField;
	private JLabel editProdTotalStock;
	private JTextField editStockJTextField;
	private JLabel editProdMaxStock;
	private JTextField editMaxJTextField;
	private JLabel editProdMinStock;
	private JTextField editMinJTextField;
	private JLabel editProdSupplierId;
	private JTextField editProdSupplierIdJTextField;
	private JButton editDetailsJButton;
	private JButton updateProductJButton;
	private JButton deleteStockLineJButton;
	
	// View Product Components
	private Product product;
	private JTextArea productTextArea;
	private JPanel viewProductDetailsPanel;
	private JPanel viewProductDetails;
	private ButtonGroup priceRange;
	private ButtonGroup quantity;
	
	ImageIcon productIcon = new ImageIcon("src\\images\\Product.png");
	ImageIcon invoiceIcon = new ImageIcon("src\\images\\Sales.png");
	ImageIcon loginIcon = new ImageIcon("src\\images\\Login.png");	
	ImageIcon profitAndLossIcon = new ImageIcon("src\\images\\PL.png");
	ImageIcon employeeIcon = new ImageIcon("src\\images\\employee.png");
	ImageIcon customerIcon = new ImageIcon("src\\images\\Customer.png");
	ImageIcon supplierIcon = new ImageIcon("src\\images\\Supplier.png");
	ImageIcon orderIcon = new ImageIcon("src\\images\\Order.png");
	
	private JComboBox<String> comboBoxProductId;
	
	private Vector<String> existingProductTitle;
	private DefaultComboBoxModel<String> listofProductTitle;
	private JComboBox<String> comboBoxProductTitle;
	
	private Vector<String> existingProductAuthor;
	private DefaultComboBoxModel<String> listOfProductAuthor;
	private JComboBox<String> comboBoxProductAuthor;
	
	private Vector<String> existingEditProdId;
	private DefaultComboBoxModel<String> listToEditProdIds;
	private JComboBox<String> comboBoxEditProdId;
	
	//Edit Invoice Components 
	private JPanel findInvoiceComponentsJPanel;
	private JPanel editInvoiceComponentsJPanel;
	private JPanel editCustomerInvoiceComponentsJPanel;
	private JPanel editInvoiceProductsComponentsJPanel;
	private JPanel editInvoiceByCustComponents;
	private Vector<String> editExistingInvoiceNums;
	private DefaultComboBoxModel<String> editListOfInvoices;
	private JComboBox<String> editComboBoxInvoice;
	private JComboBox<String> editCustIdComboInv;
	private JTextArea customerInvoiceJTextArea;
	private JTextArea productInvoiceJTextArea;
	private JTextField allInvoicesTotalJTextField;
	private JButton payAllInvoicesJButton;
	private JButton editInvoiceJButton;
	private JButton editCustomerInvoiceJButton;
	private JTextField editInvoiceEmployee;
	private JTextField editInvoiceCustomer;
	private JButton payInvoiceJButton;
	private JTextField editPayStatus;	
	private JTextField editInvoiceAmount;
	private JButton lineChartJButton;
		
	//Marc: View Customer Invoice Panel and Components
	private JPanel viewCustomerPanel;
	
	//Components
	private JTextArea textarea;
	private Invoice invoice = new Invoice();
	
	//Combo Box for invoice ID on View Customer Invoice Panel
	private Vector<String> existingInvoiceNums;
	private DefaultComboBoxModel<String> listOfInvoices;
	private JComboBox<String> comboBoxInvoice;
	
	private Vector<String> existingCustomerId;
	private DefaultComboBoxModel<String> listOfCustomers;
	private JComboBox<String> comboBoxCustomer;
	
	//Combo Box for Employee ID, Customer ID, Product ID on Create new Invoice Panel
	private Vector<String> empIdVector;
	private DefaultComboBoxModel<String> listOfEmpIds;
	private JComboBox<String> empIDComboBox;
	private Vector<String> cusIdVector;
	private DefaultComboBoxModel<String> listOfCusIds;
	private JComboBox<String> cusIDComboBox;
	private Vector<String> prodIdVector;
	private DefaultComboBoxModel<String> listOfProdIds;
	private JComboBox<String> prodIDComboBox;
	
	//Marc: Components for higher and lower Pie Chart
	private ArrayList<String> productCodes;
	private int[] countsHigher;
	private int[] countsLower;
	private JButton highestSellingButton; 
	private JButton lowsetsellingButton;
	private int topNum = 5;

	//Components for Pie Chart
	private DefaultPieDataset pieDataset = new DefaultPieDataset();
		
	//Marc: Create a new Invoice Panel
	private JPanel createNewInvoicePanel;
	private ArrayList<InvoiceProduct> addMoreArrayList;
	private String message = "";
	private String outputMessage="";
	private String orderOutputMessage = "";
	private JTextArea textAreaMarc;
	private JPanel leftPanel;
	private JPanel rightPanel;
	
	//Labels for left panel
	private JLabel invIdLbl;
	private JLabel employLbl;
	private JLabel custId;
	private JLabel prodId;
	private JLabel quantitylbl;
	
	//JText Fields for left panel
	private JTextField invTextF;
	private JTextField quantityTextF;
	
	//4 Buttons for left Panel
	private JButton addMoreBtn;
	private JButton finishBtn;
	private JButton resetBtn;
	
	//createNewOrder Panel components
	Order baseOrder;
	ArrayList<OrderProduct> addMoreProducts;
	String result = "";
	private JPanel createNewOrderLeftPanel;
	private JPanel createNewOrderRightPanel;
	private JLabel createOrderOrderIdLabel;
	private JLabel createOrderSupplierIdLabel;
	private JLabel createOrderProductCodeLabel;
	private JLabel createOrderQuantityLabel;
	private JTextField createOrderOrderIdTextField;
	private JComboBox<String> createOrderSupplierIdComboBox;
	private JComboBox<String> createOrderProductIdComboBox;
	private JTextField createOrderSupplierIdTextField;
	private JTextField createOrderProductIdTextField;
	private JTextField createOrderQuantityTextField;
	private JButton createOrderAddProductButton;
	private JButton createOrderConfirmOrderButton;
	private JTextArea createOrderScrollPaneTextArea;
	
	//viewOrder Panel components
	private JPanel viewSupplierPanel;
	private Vector<String> existingOrderIds;
	private DefaultComboBoxModel<String> listOfOrders;
	private JComboBox<String> viewOrderOrderIdComboBox;
	private Vector<String> existingSupplierIds;
	private DefaultComboBoxModel<String> listOfSuppliers;
	private JComboBox<String> viewOrderSupplierIdComboBox;
	private Vector<String> existingTitles;
	private DefaultComboBoxModel<String> listOfTitles;
	private JComboBox<String> viewOrderTitleComboBox;
	private JComboBox<String> viewOrderAuthorComboBox;
	private JButton viewOrderViewAllOrdersButton;
	private JButton viewOrderViewReceivedButton;
	private JButton viewOrderViewUnreceivedButton;
	private JButton viewOrderClearPanelButton;
	private JLabel viewOrderOrderIdLabel;
	private JButton viewOrderOrderIdButton;
	private JButton viewOrderSupplierIdButton;
	private JButton viewOrderTitleButton;
	private JButton viewOrderAuthorButton;
	private JLabel viewOrderSupplierIdLabel;
	private JLabel viewOrderTitleLabel;
	private JLabel viewOrderAuthorLabel;
		
	private JTextArea viewOrderTextArea;
	//Edit Order Components
	private JPanel findOrderComponentsJPanel;
	private JPanel editOrderComponentsJPanel;
	private JPanel editSupplierOrderComponentsJPanel;
	private JPanel saveOrderComponentsJPanel;
	private JPanel editOrderProductsComponentsJPanel;
	private JPanel editOrderBySupplierComponentsJPanel;
	private JComboBox<String> editOrderOrderIdComboBox;
	private JTextArea supplierOrderJTextArea;
	private JTextArea productOrderJTextArea;
	private JTextField allOrdersTotalJTextField;
	private JComboBox<String> editOrderSupplierIdComboBox;
	private JButton receiveAllOrdersJButton;
	private JButton editOrderJButton;
	private JButton editOrderSupplierJButton;
	private JButton receiveOrderJButton;
	private JButton saveOrderJButton;
	private JButton deleteOrderJButton;
	private JTextField editOrderId;
	private JTextField editOrderSupplier;
	private JTextField editOrderReceivedStatus;
	private JTextField editOrderAmount;
	
	//P&L JTable Tab
	private JPanel pLComponentsJPanel;
	private static final int ROW_HEIGHT = 20;
	private static final String[] TABLE_COLUMNS = {"Date", "Credit", "Debit"};
	private DefaultTableModel tableModel = new DefaultTableModel(TABLE_COLUMNS, 0);
	private JTable pLJTable;
	JScrollPane pLJScrollPane;
	private JTextField pLTotal;
	private Vector<String> months;
	private DefaultComboBoxModel<String> listOfMonths;
	private JComboBox<String> comboBoxPL;
	private JButton pLViewButton;
	
	Dimension d = new Dimension(230, 30);
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public RetailGUI() {
		//TODO Jump to Constructor
		createInvoices();
		setDesign();
		initialize();

		gc.insets = new Insets(10,5,5,10);
		
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
		
		mainJTabbedPane.addTab("Login/Logout ",loginIcon, loginJPanel);
		mainJTabbedPane.addTab("Sales ",invoiceIcon, invJTabbedPane);
		mainJTabbedPane.addTab("Orders ",orderIcon, orderJTabbedPane);
		mainJTabbedPane.addTab("Product Management ", productIcon, prodJTabbedPane);
		mainJTabbedPane.addTab("Customer Management ",customerIcon, custJTabbedPane);
		mainJTabbedPane.addTab("Supplier Management ",supplierIcon, supplyJTabbedPane);
		mainJTabbedPane.addTab("Employee Management",employeeIcon, accessJTabbedPane);
		mainJTabbedPane.addTab("Profit and Loss ",profitAndLossIcon, proflossJTabbedPane);
		
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
		invJTabbedPane.add("View Invoices", viewInvJPanel);
		invJTabbedPane.add("Pay Invoices", editInvJPanel);
		
		orderJTabbedPane.add("Create New Order", createOrderPanel);
		orderJTabbedPane.add("View Orders", viewOrderJPanel);
		orderJTabbedPane.add("Receive Orders", editOrderJPanel);
		
		accessJTabbedPane.add("Create Employee", employeeJPanel);
		accessJTabbedPane.add("View Employee", viewEmployeeJPanel);
		accessJTabbedPane.add("Edit Employee", editEmployeeJPanel);
		
		proflossJTabbedPane.add("Profit and Loss Table", proflossJPanel);
		proflossJTabbedPane.add("Graph Information", graphJPanel);
		
		//lock the tabs until login successful
		mainJTabbedPane.setEnabledAt(1, false);
		mainJTabbedPane.setEnabledAt(2, false);
		mainJTabbedPane.setEnabledAt(3, false);
		mainJTabbedPane.setEnabledAt(4, false);
		mainJTabbedPane.setEnabledAt(5, false);
		mainJTabbedPane.setEnabledAt(6, false);
		mainJTabbedPane.setEnabledAt(7, false);
									
		
		employeeJPanel.setLayout(new GridBagLayout());
		this.empIDPopulate(empIdCombo);
		this.empNamePopulate(empNameCombo);
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
		employeeAcessField.addItem(0);
		employeeAcessField.addItem(1);
		employeeAcessField.setSelectedItem(0);
		employeeAcessField.setEditable(false);
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
		empJTextArea.setEditable(false);
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
		viewEmpIdCombo.setMinimumSize(d);
		viewEmpIdCombo.setPreferredSize(d);
		viewEmpIdCombo.setSelectedIndex(0);
		editEmployeeJPanel.add(viewEmpIdCombo, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		editById.setMinimumSize(d);
		editById.setPreferredSize(d);
		editEmployeeJPanel.add(editById, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		editEmpName.setMinimumSize(d);
		editEmpName.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpName, gc);
		gc.gridx = 1;
		gc.gridy = 2;
		editEmpNameField.setMinimumSize(d);
		editEmpNameField.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpNameField, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		editEmpAccess.setMinimumSize(d);
		editEmpAccess.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpAccess, gc);
		gc.gridx = 1;
		gc.gridy = 3;
		editEmpAccessField.setMinimumSize(d);
		editEmpAccessField.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpAccessField, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		editEmpSalary.setMinimumSize(d);
		editEmpSalary.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpSalary, gc);
		gc.gridx = 1;
		gc.gridy = 4;
		editEmpSalaryField.setMinimumSize(d);
		editEmpSalaryField.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpSalaryField, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		editEmpPassword.setMinimumSize(d);
		editEmpPassword.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpPassword, gc);
		gc.gridx = 1;
		gc.gridy = 5;
		editEmpPasswordField.setMinimumSize(d);
		editEmpPasswordField.setPreferredSize(d);
		editEmployeeJPanel.add(editEmpPasswordField, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		updateEmployee.setMinimumSize(d);
		updateEmployee.setPreferredSize(d);
		editEmployeeJPanel.add(updateEmployee, gc);
		gc.gridx = 1;
		gc.gridy = 6;
		deleteEmployee.setMinimumSize(d);
		deleteEmployee.setPreferredSize(d);
		editEmployeeJPanel.add(deleteEmployee, gc);
		
		employeeJButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					if(checkEmployeeDuplicate(employees, Integer.parseInt(employeeIdField.getText())) == true){
						Employee employee = new Employee(Integer.parseInt(employeeIdField.getText()),employeeNameField.getText(), Integer.parseInt(employeeAcessField.getSelectedItem().toString()), Double.parseDouble(employeeSalaryField.getText()), Integer.parseInt(employeePassField.getText()));
						employees.add(employee);
						empIdCombo.addItem(employeeIdField.getText());
						empNameCombo.addItem(employeeNameField.getText());
						viewEmpIdCombo.addItem(employeeIdField.getText());
						JOptionPane.showMessageDialog(null, "Employee Successfully Created");
						listOfEmpIds.addElement(employeeIdField.getText());
						//Reset fields
						employeeIdField.setText("");
						employeeNameField.setText("");
						employeeAcessField.setSelectedIndex(0);
						employeeSalaryField.setText("");
						employeePassField.setText("");
					}else{
						JOptionPane.showMessageDialog(null, "Employee Already Exists");
					}
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Please Complete All Fields");
				}
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
								empIdCombo.setSelectedIndex(0);
								break;
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
					if(empNameCombo.getSelectedIndex() != 0){
						for(Employee employee: employees){
							if(employee.getEmployeeName().equalsIgnoreCase(empNameCombo.getSelectedItem().toString())){
								empJTextArea.setText("Employee ID: "+employee.getEmployeeId()
							+"\n Name: " +employee.getEmployeeName() 
							+"\n Access Level: " +employee.getAccess()
							+"\n Password: " +employee.getPassword()
							+"\n Salary: " +employee.getSalary());
							empNameCombo.setSelectedIndex(0);
							break;
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, "Please Select a Valid Employee.");
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
							empJTextArea.setCaretPosition(0);
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
					JOptionPane.showMessageDialog(null, "Please Select a Valid Employee.");
				}
			}
		});
		
		updateEmployee.addActionListener(new ActionListener(){
			//update a specific customer
			public void actionPerformed(ActionEvent e){
				if(viewEmpIdCombo.getSelectedIndex() != 0){
					if(editEmpNameField.getText().isEmpty() || editEmpAccessField.getText().isEmpty() || 
							editEmpSalaryField.getText().isEmpty() || editEmpPasswordField.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Please Complete All Fields");	
					}else{
						for(Employee employee: employees){
							if(employee.getEmployeeId() == Integer.parseInt(viewEmpIdCombo.getSelectedItem().toString())){
								employee.setEmployeeName(editEmpNameField.getText());
								employee.setAccess(Integer.parseInt(editEmpAccessField.getText()));
								employee.setSalary(Double.parseDouble(editEmpSalaryField.getText()));
								employee.setPassword(Integer.parseInt(editEmpPasswordField.getText()));
								JOptionPane.showMessageDialog(null, "Employee Updated");
								viewEmpIdCombo.setSelectedIndex(0);
								editEmpNameField.setText("");
								editEmpAccessField.setText("");
								editEmpSalaryField.setText("");
								editEmpPasswordField.setText("");
								return;
							}
						}
					}
				}else{
					JOptionPane.showMessageDialog(null, "Please Select a Valid Employee.");
				}
			}
		});
		
		deleteEmployee.addActionListener(new ActionListener(){
			//delete function for employee
			public void actionPerformed(ActionEvent arg){
				if(viewEmpIdCombo.getSelectedIndex() != 0){
					for(Employee employee: employees){
						if(employee.getEmployeeId() == Integer.parseInt(viewEmpIdCombo.getSelectedItem().toString())){
							listOfEmpIds.removeElement(viewEmpIdCombo.getSelectedItem().toString());
							empIdCombo.removeItem(viewEmpIdCombo.getSelectedItem());
							empNameCombo.removeItem(viewEmpIdCombo.getSelectedItem());
							viewEmpIdCombo.removeItem(viewEmpIdCombo.getSelectedItem());
							employees.remove(employee);
							JOptionPane.showMessageDialog(null, "Employee Deleted");
							viewEmpIdCombo.setSelectedIndex(0);
							editEmpNameField.setText("");
							editEmpAccessField.setText("");
							editEmpSalaryField.setText("");
							editEmpPasswordField.setText("");
							return;
						}
					}
				}else{
					JOptionPane.showMessageDialog(null, "Please Select a Valid Employee.");
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
		custJTextArea.setEditable(false);
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
		editCustIdCombo.setMinimumSize(d);
		editCustIdCombo.setPreferredSize(d);
		editCustIdCombo.setSelectedItem(0);
		editCustJPanel.add(editCustIdCombo, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		findCustById.setMinimumSize(d);
		findCustById.setPreferredSize(d);
		editCustJPanel.add(findCustById, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		editCustNameJLabel.setMinimumSize(d);
		editCustNameJLabel.setPreferredSize(d);
		editCustJPanel.add(editCustNameJLabel, gc);
		gc.gridx = 1;
		gc.gridy = 2;
		editCustName.setMinimumSize(d);
		editCustName.setPreferredSize(d);
		editCustJPanel.add(editCustName, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		editCustAddressJLabel.setMinimumSize(d);
		editCustAddressJLabel.setPreferredSize(d);
		editCustJPanel.add(editCustAddressJLabel, gc);
		gc.gridx = 1;
		gc.gridy = 3;
		editCustAddress.setMinimumSize(d);
		editCustAddress.setPreferredSize(d);
		editCustJPanel.add(editCustAddress, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		editCustEmailJLabel.setMinimumSize(d);
		editCustEmailJLabel.setPreferredSize(d);
		editCustJPanel.add(editCustEmailJLabel, gc);
		gc.gridx = 1;
		gc.gridy = 4;
		editCustEmail.setMinimumSize(d);
		editCustEmail.setPreferredSize(d);
		editCustJPanel.add(editCustEmail, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		editCustPhoneJLabel.setMinimumSize(d);
		editCustPhoneJLabel.setPreferredSize(d);
		editCustJPanel.add(editCustPhoneJLabel, gc);
		gc.gridx = 1;
		gc.gridy = 5;
		editCustPhone.setMinimumSize(d);
		editCustPhone.setPreferredSize(d);
		editCustJPanel.add(editCustPhone, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		updateCustJButton.setMinimumSize(d);
		updateCustJButton.setPreferredSize(d);
		editCustJPanel.add(updateCustJButton, gc);
		gc.gridx = 1;
		gc.gridy = 6;
		deleteCustJButton.setMinimumSize(d);
		deleteCustJButton.setPreferredSize(d);
		editCustJPanel.add(deleteCustJButton, gc);
		
		
		custJButton.addActionListener(new ActionListener(){
			// function to add a new customer
			public void actionPerformed(ActionEvent e){
				try{
					if(checkCustomerDuplicate(customers, Integer.parseInt(custIdJTextField.getText())) == true){
						if(custNameJTextField.getText().isEmpty() || custAddressJTextField.getText().isEmpty()){
							JOptionPane.showMessageDialog(null, "Required Fields: \n Customer Id \n Customer Name \n Customer Address");	
						}else{
								Customer customer = new Customer(Integer.parseInt(custIdJTextField.getText()),
									custNameJTextField.getText(),custAddressJTextField.getText(), custEmailJTextField.getText(),
									Integer.parseInt(custPhoneJTextField.getText()));
								customers.add(customer);
								custIdCombo.addItem(Integer.toString(customer.getCustId()));
								custNameCombo.addItem(customer.getCustName());
								editCustIdCombo.addItem(Integer.toString(customer.getCustId()));
								JOptionPane.showMessageDialog(null, "New Customer Added");
								listOfCustomers.addElement(custIdJTextField.getText());
								listOfCusIds.addElement(custIdJTextField.getText());
								custIdJTextField.setText("");
								custNameJTextField.setText("");
								custAddressJTextField.setText("");
								custEmailJTextField.setText("");
								custPhoneJTextField.setText("");
								editCustIdComboInv.addItem(Integer.toString(customer.getCustId()));
							
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Customer Already Exists");
					}
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
							custIdCombo.setSelectedIndex(0);
							break;
							}
						}
					}catch(NumberFormatException nfe){
						JOptionPane.showMessageDialog(null, "Please Select a Valid Customer.");
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
				if(custNameCombo.getSelectedIndex() != 0){
					for(Customer customer: customers){
						if(customer.getCustName() == custNameCombo.getSelectedItem()){
							custJTextArea.setText(" Customer Id: "+customer.getCustId()
									+"\n Name: "+customer.getCustName()
									+"\n Address: "+customer.getCustAddress()
									+"\n Email: "+customer.getCustEmail()
									+"\n Phone: "+customer.getCustTelephone());
							custNameCombo.setSelectedIndex(0);
							break;
							}
						}
				}else{
					JOptionPane.showMessageDialog(null, "Please Select a Valid Customer");
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
							custJTextArea.setCaretPosition(0);
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
							editCustPhone.setText(Integer.toString(customer.getCustTelephone()));
						}
					}
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Please Select a Valid Customer.");
				}
			}
		});
		
		updateCustJButton.addActionListener(new ActionListener(){
			//update a specific customer
			public void actionPerformed(ActionEvent e){
				if(editCustIdCombo.getSelectedIndex() != 0){
					if(editCustName.getText().isEmpty() || editCustAddress.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Required Fields: \n Customer Name \n Customer Address");	
					}else{
						for(Customer customer: customers){
							if(customer.getCustId() == Integer.parseInt(editCustIdCombo.getSelectedItem().toString())){
								customer.setCustName(editCustName.getText());
								customer.setCustAddress(editCustAddress.getText());
								customer.setCustEmail(editCustEmail.getText());
								customer.setCustTelephone(Integer.parseInt(editCustPhone.getText()));
								JOptionPane.showMessageDialog(null, "Customer Updated.");
								editCustIdCombo.setSelectedIndex(0);
								editCustName.setText("");
								editCustAddress.setText("");
								editCustEmail.setText("");
								editCustPhone.setText("");
								return;
							}
						}
					}
				}else{
					JOptionPane.showMessageDialog(null, "Please Select a Valid Customer.");
				}
			}
		});
		
		deleteCustJButton.addActionListener(new ActionListener(){
			//delete function for customer
			public void actionPerformed(ActionEvent arg){
				if(editCustIdCombo.getSelectedIndex()!= 0){
					for(Customer customer: customers){
						if(customer.getCustId() == Integer.parseInt(editCustIdCombo.getSelectedItem().toString())){
							listOfCustomers.removeElement(editCustIdCombo.getSelectedItem().toString());
							listOfCusIds.removeElement(editCustIdCombo.getSelectedItem().toString());
							custIdCombo.removeItem(editCustIdCombo.getSelectedItem());
							custNameCombo.removeItem(editCustIdCombo.getSelectedItem());
							editCustIdCombo.removeItem(editCustIdCombo.getSelectedItem());
							customers.remove(customer);
							JOptionPane.showMessageDialog(null, "Customer Deleted");
							editCustIdCombo.setSelectedIndex(0);
							editCustName.setText("");
							editCustAddress.setText("");
							editCustEmail.setText("");
							editCustPhone.setText("");
							return;
						}
					}
				}else{
					JOptionPane.showMessageDialog(null, "Please Select a Valid Customer.");
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
		supplierJTextArea.setEditable(false);
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
		editSuppIdCombo.setMinimumSize(d);
		editSuppIdCombo.setPreferredSize(d);
		editSuppIdCombo.setSelectedIndex(0);
		editSupplyJPanel.add(editSuppIdCombo, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		editSupplierJButton.setMinimumSize(d);
		editSupplierJButton.setPreferredSize(d);
		editSupplyJPanel.add(editSupplierJButton, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		editSuppNameJLabel.setMinimumSize(d);
		editSuppNameJLabel.setPreferredSize(d);
		editSupplyJPanel.add(editSuppNameJLabel, gc);
		gc.gridx = 1;
		gc.gridy = 2;
		editSupplierName.setMinimumSize(d);
		editSupplierName.setPreferredSize(d);
		editSupplyJPanel.add(editSupplierName, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		editSuppAddressJLabel.setMinimumSize(d);
		editSuppAddressJLabel.setPreferredSize(d);
		editSupplyJPanel.add(editSuppAddressJLabel, gc);
		gc.gridx = 1;
		gc.gridy = 3;
		editSupplierAddress.setMinimumSize(d);
		editSupplierAddress.setPreferredSize(d);
		editSupplyJPanel.add(editSupplierAddress, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		editSuppEmailJLabel.setMinimumSize(d);
		editSuppEmailJLabel.setPreferredSize(d);
		editSupplyJPanel.add(editSuppEmailJLabel, gc);
		gc.gridx = 1;
		gc.gridy = 4;
		editSupplierEmail.setMinimumSize(d);
		editSupplierEmail.setPreferredSize(d);
		editSupplyJPanel.add(editSupplierEmail, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		editSuppPhoneJLabel.setMinimumSize(d);
		editSuppPhoneJLabel.setPreferredSize(d);
		editSupplyJPanel.add(editSuppPhoneJLabel, gc);
		gc.gridx = 1;
		gc.gridy = 5;
		editSupplierPhone.setMinimumSize(d);
		editSupplierPhone.setPreferredSize(d);
		editSupplyJPanel.add(editSupplierPhone, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		editDeliveryJLabel.setMinimumSize(d);
		editDeliveryJLabel.setPreferredSize(d);
		editSupplyJPanel.add(editDeliveryJLabel, gc);
		gc.gridx = 1;
		gc.gridy = 6;
		editSupplierDelivery.setMinimumSize(d);
		editSupplierDelivery.setPreferredSize(d);
		editSupplyJPanel.add(editSupplierDelivery, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		saveSupplierJButton.setMinimumSize(d);
		saveSupplierJButton.setPreferredSize(d);
		editSupplyJPanel.add(saveSupplierJButton, gc);
		gc.gridx = 1;
		gc.gridy = 7;
		deleteSupplierJButton.setPreferredSize(d);
		deleteSupplierJButton.setMinimumSize(d);
		editSupplyJPanel.add(deleteSupplierJButton, gc);

		supplierJButton.addActionListener(new ActionListener(){
			// function to add a new supplier
			public void actionPerformed(ActionEvent e){
				try{	
					if(checkSupplierDuplicate(suppliers, Integer.parseInt(supplierIdJTextField.getText())) == true){
						if(supplierNameJTextField.getText().isEmpty() || supplierAddressJTextField.getText().isEmpty()){
							JOptionPane.showMessageDialog(null, "Required Fields: \n Supplier Id \n Supplier Name \n Supplier Address");	
						}else{
							Supplier supplier = new Supplier(Integer.parseInt(supplierIdJTextField.getText()), supplierNameJTextField.getText(), 
									supplierAddressJTextField.getText(), supplierEmailJTextField.getText(), Integer.parseInt(supplierPhoneJTextField.getText()));
							suppliers.add(supplier);
							JOptionPane.showMessageDialog(null, "New Supplier Added");
							suppIdCombo.addItem(supplierIdJTextField.getText());
							suppNameCombo.addItem(supplierNameJTextField.getText());
							editSuppIdCombo.addItem(supplierIdJTextField.getText());
							supplierIdJTextField.setText("");
							supplierNameJTextField.setText("");
							supplierAddressJTextField.setText("");
							supplierEmailJTextField.setText("");
							supplierPhoneJTextField.setText("");
							listOfSuppliers.addElement(supplierIdJTextField.getText());
						}
					}else{
						JOptionPane.showMessageDialog(null, "Supplier Already Exists");
					}
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
								suppIdCombo.setSelectedIndex(0);
								break;
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, "No Suppliers Found");
					}
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Please Select a Valid Supplier.");
				}
			}
		});
		
		viewSupplyNameJButton.addActionListener(new ActionListener(){
			// function to view a supplier by id or name
			public void actionPerformed(ActionEvent e){
				if(suppliers.size() >= 1){
					if(suppNameCombo.getSelectedIndex() != 0){
						for(Supplier supplier: suppliers){
							if(supplier.getName() == suppNameCombo.getSelectedItem()){
								supplierJTextArea.setText(" Supplier Id: "+supplier.getId()
										+"\n Name: "+supplier.getName()
										+"\n Address: "+supplier.getAddress()
										+"\n Email: "+supplier.getEmail()
										+"\n Phone: "+supplier.getPhone()
										+"\n Delivery Time: "+supplier.getDaysToDeliver());
								suppNameCombo.setSelectedIndex(0);
								break;
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, "Please Select a Valid Supplier");
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
							supplierJTextArea.setCaretPosition(0);
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
							editSupplierPhone.setText(Integer.toString(supplier.getPhone()));
							editSupplierDelivery.setText(Integer.toString(supplier.getDaysToDeliver()));
						}
					}
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Please Select a Valid Supplier.");
				}
			}
		});
		
		saveSupplierJButton.addActionListener(new ActionListener(){
			//function to update supplier
			public void actionPerformed(ActionEvent e){
				if(editSuppIdCombo.getSelectedIndex() != 0){
					if(editSupplierName.getText().isEmpty() || editSupplierAddress.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Required Fields: \n Supplier Name \n Supplier Address");	
					}else{
						for(Supplier supplier: suppliers){
							if(supplier.getId() == Integer.parseInt(editSuppIdCombo.getSelectedItem().toString())){
								supplier.setName(editSupplierName.getText());
								supplier.setAddress(editSupplierAddress.getText());
								supplier.setEmail(editSupplierEmail.getText());
								supplier.setPhone(Integer.parseInt(editSupplierPhone.getText()));
								supplier.setDaysToDeliver(Integer.parseInt(editSupplierDelivery.getText()));
								JOptionPane.showMessageDialog(null, "Supplier Updated");
								editSuppIdCombo.setSelectedIndex(0);
								editSupplierName.setText("");
								editSupplierAddress.setText("");
								editSupplierEmail.setText("");
								editSupplierPhone.setText("");
								editSupplierDelivery.setText("");
								return;
							}
						}
					}
				}else{
					JOptionPane.showMessageDialog(null, "Please Select a Valid Supplier.");
				}
			}
			
		});	
		
		deleteSupplierJButton.addActionListener(new ActionListener(){
			// function to delete supplier by getting id from the supplier id label
			public void actionPerformed(ActionEvent arg){
				if(editSuppIdCombo.getSelectedIndex() != 0){
					for(Supplier supplier: suppliers){
						if(supplier.getId() == Integer.parseInt(editSuppIdCombo.getSelectedItem().toString())){
							listOfSuppliers.removeElement(editSuppIdCombo.getSelectedItem().toString());
							suppIdCombo.removeItem(editSuppIdCombo.getSelectedItem());
							suppNameCombo.removeItem(editSuppIdCombo.getSelectedItem());
							editSuppIdCombo.removeItem(editSuppIdCombo.getSelectedItem());
							suppliers.remove(supplier);
							JOptionPane.showMessageDialog(null, "Supplier Deleted");
							editSuppIdCombo.setSelectedIndex(0);
							editSupplierName.setText("");
							editSupplierAddress.setText("");
							editSupplierEmail.setText("");
							editSupplierPhone.setText("");
							editSupplierDelivery.setText("");
							return;
						}
					}
				}else{
					JOptionPane.showMessageDialog(null, "Please Select a Valid Supplier.");
				}
			}
		});
		
		// Start of Product Creation 
		addProductJPanel.setLayout(new GridBagLayout());
		gc.gridx = 0;
		gc.gridy = 1;
		prodCode.setPreferredSize(d);
		addProductJPanel.add(prodCode, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		codeJTextField.setPreferredSize(d);
		addProductJPanel.add(codeJTextField, gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		prodTitle.setPreferredSize(d);
		addProductJPanel.add(prodTitle, gc);
		gc.gridx = 1;
		gc.gridy = 4;
		titleJTextField.setPreferredSize(d);
		addProductJPanel.add(titleJTextField, gc);
		
		gc.gridx = 0;
		gc.gridy = 5;
		prodAuthor.setPreferredSize(d);
		addProductJPanel.add(prodAuthor, gc);
		gc.gridx = 1;
		gc.gridy = 5;
		authorJTextField.setPreferredSize(d);
		addProductJPanel.add(authorJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 7;
		prodRetail.setPreferredSize(d);
		addProductJPanel.add(prodRetail, gc);
		gc.gridx = 1;
		gc.gridy = 7;
		retailJTextField.setPreferredSize(d);
		retailJTextField.setMinimumSize(d);
		addProductJPanel.add(retailJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 9;
		prodCost.setPreferredSize(d);
		addProductJPanel.add(prodCost, gc);
		gc.gridx = 1;
		gc.gridy = 9;
		costJTextField.setPreferredSize(d);
		costJTextField.setMinimumSize(d);
		addProductJPanel.add(costJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 11;
		prodTotalStock.setPreferredSize(d);
		addProductJPanel.add(prodTotalStock, gc);
		gc.gridx = 1;
		gc.gridy = 11;
		tStockJTextField.setPreferredSize(d);
		tStockJTextField.setMinimumSize(d);
		addProductJPanel.add(tStockJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 13;
		prodMaxStock.setPreferredSize(d);
		addProductJPanel.add(prodMaxStock, gc);
		gc.gridx = 1;
		gc.gridy = 13;
		maxJTextField.setPreferredSize(d);
		maxJTextField.setMinimumSize(d);
		addProductJPanel.add(maxJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 15;
		prodMinStock.setPreferredSize(d);
		addProductJPanel.add(prodMinStock, gc);
		gc.gridx = 1;
		gc.gridy = 15;
		minJTextField.setPreferredSize(d);
		minJTextField.setMinimumSize(d);
		addProductJPanel.add(minJTextField, gc);
		gc.gridx = 0;
		gc.gridy = 17;
		prodSupplierId.setPreferredSize(d);
		addProductJPanel.add(prodSupplierId, gc);
		gc.gridx = 1;
		gc.gridy = 17;
		prodSupplierIdJTextField.setPreferredSize(d);
		prodSupplierIdJTextField.setMinimumSize(d);
		addProductJPanel.add(prodSupplierIdJTextField, gc);
		gc.gridx = 1;
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
					if(suppliers.size() >= 1 ){
						for(Supplier supplier: suppliers){
							if(supplier.getId() == Integer.parseInt(prodSupplierIdJTextField.getText())){
									Product product = new Product(titleJTextField.getText(),authorJTextField.getText().toLowerCase(),
											codeJTextField.getText(),Double.parseDouble(retailJTextField.getText()),
											Double.parseDouble(costJTextField.getText()), Integer.parseInt(tStockJTextField.getText()),
											Integer.parseInt(maxJTextField.getText()), Integer.parseInt(minJTextField.getText()),supplier
											);
									products.add(product);
									JOptionPane.showMessageDialog(null, "New Product Added");
									
									listOfProdIds.addElement(codeJTextField.getText());
									listOfProductAuthor.addElement(authorJTextField.getText());
									listofProductTitle.addElement(titleJTextField.getText());
									Collections.sort(existingProductAuthor, String.CASE_INSENSITIVE_ORDER); // Sort Each list after adding to new element.
									Collections.sort(existingProductTitle, String.CASE_INSENSITIVE_ORDER);

							}
						}
						
					}else{
						JOptionPane.showMessageDialog(null, "Suppliers List is Empty");
					}
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Please Complete All Fields");
				}
				
				titleJTextField.setText("");
				prodSupplierIdJTextField.setText("");
				authorJTextField.setText("");
				codeJTextField.setText("");
				retailJTextField.setText("");
				costJTextField.setText("");
				tStockJTextField.setText("");
				maxJTextField.setText("");
				minJTextField.setText("");

			}
		});
		
		editProductJPanel.setLayout(new GridBagLayout());
	
		
		comboBoxEditProdId = new JComboBox<>(listOfProdIds);
		listToEditProdIds.setSelectedItem("Select");
		comboBoxEditProdId.setEditable(true);
		comboBoxEditProdId.setPreferredSize(d);
		comboBoxEditProdId.setMinimumSize(d);
		gc.gridx = 0;
		gc.gridy = 1;
		editProductJPanel.add(comboBoxEditProdId,gc);
				
		gc.gridx = 1;
		gc.gridy = 1;
		editDetailsJButton.setPreferredSize(d);
		editDetailsJButton.setMinimumSize(d);
		editProductJPanel.add(editDetailsJButton, gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		editProdCode.setPreferredSize(d);
		editProductJPanel.add(editProdCode, gc);
		
		
		gc.gridx = 1;
		gc.gridy = 4;
		editCodeJTextField.setEditable(false);
		editCodeJTextField.setPreferredSize(d);
		editCodeJTextField.setMinimumSize(d);
		editProductJPanel.add(editCodeJTextField, gc);
		
		gc.gridx = 0;
		gc.gridy = 5;
		editProdTitle.setPreferredSize(d);
		editProductJPanel.add(editProdTitle, gc);
		
		gc.gridx = 1;
		gc.gridy = 5;
		editTitleJTextField.setEditable(false);
		editTitleJTextField.setPreferredSize(d);
		editTitleJTextField.setMinimumSize(d);
		editProductJPanel.add(editTitleJTextField, gc);
		
		gc.gridx = 0;
		gc.gridy = 7;
		editProdAuthor.setPreferredSize(d);
		editProductJPanel.add(editProdAuthor, gc);
		
		gc.gridx = 1;
		gc.gridy = 7;
		editAuthorJTextField.setEditable(false);
		editAuthorJTextField.setPreferredSize(d);
		editAuthorJTextField.setMinimumSize(d);
		editProductJPanel.add(editAuthorJTextField, gc);
		
		gc.gridx = 0;
		gc.gridy = 11;
		editProdRetail.setPreferredSize(d);
		editProductJPanel.add(editProdRetail, gc);
		
		gc.gridx = 1;
		gc.gridy = 11;
		editRetailJTextField.setPreferredSize(d);
		editRetailJTextField.setMinimumSize(d);
		editProductJPanel.add(editRetailJTextField, gc);
		
		gc.gridx = 0;
		gc.gridy = 13;
		editProdCost.setPreferredSize(d);
		editProductJPanel.add(editProdCost, gc);
		
		gc.gridx = 1;
		gc.gridy = 13;
		editCostJTextField.setPreferredSize(d);
		editCostJTextField.setMinimumSize(d);
		editProductJPanel.add(editCostJTextField, gc);
		
		gc.gridx = 0;
		gc.gridy = 15;
		editProdTotalStock.setPreferredSize(d);
		editProductJPanel.add(editProdTotalStock, gc);
		
		gc.gridx = 1;
		gc.gridy = 15;
		editStockJTextField.setPreferredSize(d);
		editStockJTextField.setMinimumSize(d);
		editProductJPanel.add(editStockJTextField, gc);
		
		gc.gridx = 0;
		gc.gridy = 17;
		editProdMaxStock.setPreferredSize(d);
		editProductJPanel.add(editProdMaxStock, gc);
		
		gc.gridx = 1;
		gc.gridy = 17;
		editMaxJTextField.setPreferredSize(d);
		editMaxJTextField.setMinimumSize(d);
		editProductJPanel.add(editMaxJTextField, gc);
		
		gc.gridx = 0;
		gc.gridy = 19;
		editProdMinStock.setPreferredSize(d);
		editProductJPanel.add(editProdMinStock, gc);
		
		gc.gridx = 1;
		gc.gridy = 19;
		editMinJTextField.setPreferredSize(d);
		editMinJTextField.setMinimumSize(d);
		editProductJPanel.add(editMinJTextField, gc);
		
		gc.gridx = 0;
		gc.gridy = 21;
		editProdSupplierId.setPreferredSize(d);
		editProductJPanel.add(editProdSupplierId, gc);
		
		gc.gridx = 1;
		gc.gridy = 21;
		editProdSupplierIdJTextField.setPreferredSize(d);
		editProdSupplierIdJTextField.setMinimumSize(d);
		editProductJPanel.add(editProdSupplierIdJTextField, gc);
		
		gc.gridx = 0;
		gc.gridy = 22;
		updateProductJButton.setPreferredSize(d);
		editProductJPanel.add(updateProductJButton, gc);
		
		gc.gridx = 1;
		gc.gridy = 22;
		deleteStockLineJButton.setPreferredSize(d);
		editProductJPanel.add(deleteStockLineJButton, gc);
		
		
		//add edit invoice components
			fillComboBox();		
			this.custIdPopulate(editCustIdComboInv);
			//find by invoice id & customer id components
			findInvoiceComponentsJPanel.setLayout(new GridBagLayout());
			gc.gridx = 0;
			gc.gridy = 1;
			editComboBoxInvoice = new JComboBox<String>(editListOfInvoices);
			editListOfInvoices.setSelectedItem(editExistingInvoiceNums.get(0));
			findInvoiceComponentsJPanel.add(editComboBoxInvoice, gc);
			editComboBoxInvoice.setPreferredSize(d);
			editComboBoxInvoice.setMinimumSize(d);
			gc.gridx = 1;
			gc.gridy = 1;
			editInvoiceJButton.setPreferredSize(d);
			editInvoiceJButton.setMinimumSize(d);
			findInvoiceComponentsJPanel.add(editInvoiceJButton, gc);
			gc.gridx = 0;
			gc.gridy = 2;
			editCustIdComboInv.setSelectedItem(0);
			findInvoiceComponentsJPanel.add(editCustIdComboInv, gc);
			editCustIdComboInv.setPreferredSize(d);
			editCustIdComboInv.setMinimumSize(d);
			gc.gridx = 1;
			gc.gridy = 2;
			editCustomerInvoiceJButton.setPreferredSize(d);
			editCustomerInvoiceJButton.setMinimumSize(d);
			findInvoiceComponentsJPanel.add(editCustomerInvoiceJButton, gc);
			
			//edit by invoice id components
			editInvoiceComponentsJPanel.setLayout(new GridBagLayout());
			gc.gridx = 0;
			gc.gridy = 0;
			editInvoiceComponentsJPanel.add(new JLabel("Employee ID"), gc);
			gc.gridx = 1;
			gc.gridy = 0;
			editInvoiceComponentsJPanel.add(editInvoiceEmployee, gc);
			editInvoiceEmployee.setEditable(false);
			editInvoiceEmployee.setPreferredSize(d);
			editInvoiceEmployee.setMinimumSize(d);
			gc.gridx = 0;
			gc.gridy = 1;
			editInvoiceComponentsJPanel.add(new JLabel("Customer ID"), gc);
			gc.gridx = 1;
			gc.gridy = 1;
			editInvoiceComponentsJPanel.add(editInvoiceCustomer, gc);
			editInvoiceCustomer.setEditable(false);
			editInvoiceCustomer.setPreferredSize(d);
			editInvoiceCustomer.setMinimumSize(d);
			gc.gridx = 0;
			gc.gridy = 2;
			editInvoiceComponentsJPanel.add(new JLabel("Total"), gc);
			gc.gridx = 1;
			gc.gridy = 2;
			editInvoiceComponentsJPanel.add(editInvoiceAmount, gc);
			editInvoiceAmount.setEditable(false);
			editInvoiceAmount.setPreferredSize(d);
			editInvoiceAmount.setMinimumSize(d);
			gc.gridx = 0;
			gc.gridy = 3;
			editInvoiceComponentsJPanel.add(editPayStatus, gc);
			editPayStatus.setPreferredSize(d);
			editPayStatus.setMinimumSize(d);
			editPayStatus.setEditable(false);
			gc.gridx = 1;
			gc.gridy = 3;
			editInvoiceComponentsJPanel.add(payInvoiceJButton, gc);
			payInvoiceJButton.setPreferredSize(d);
			payInvoiceJButton.setMinimumSize(d);
			payInvoiceJButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					String s = (String)editComboBoxInvoice.getSelectedItem();
					int id = Integer.parseInt( s );
					for(Invoice invoice: invoices){
						if(invoice.getId() == id){
							if(invoice.isPaid()){
								JOptionPane.showMessageDialog(null, "Already Paid!");
								editListOfInvoices.setSelectedItem(editExistingInvoiceNums.get(0));
							}
							else{
								invoice.setPaid(true);
								JOptionPane.showMessageDialog(null, "Paid!");
								editListOfInvoices.setSelectedItem(editExistingInvoiceNums.get(0));
							}
						}
					}
					editPayStatus.setForeground(Color.BLACK);
					editInvoiceJButton.doClick();		
				}
			});
	
			//show in jscrollpane product details
			gc.gridx = 0;
			gc.gridy = 0;
			JScrollPane invoiceProductsJScrollPane = new JScrollPane(productInvoiceJTextArea);
			invoiceProductsJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			invoiceProductsJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);			
			editInvoiceProductsComponentsJPanel.add(invoiceProductsJScrollPane);
			editInvoiceProductsComponentsJPanel.setLayout(new GridLayout(1,2));
			productInvoiceJTextArea.setEditable(false);
				
			//edit by customer components
			editCustomerInvoiceComponentsJPanel.setLayout(new GridBagLayout());
			gc.gridx = 0;
			gc.gridy = 0;
			JScrollPane customerInvoiceJScrollPane = new JScrollPane(customerInvoiceJTextArea);
			customerInvoiceJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			editCustomerInvoiceComponentsJPanel.add(customerInvoiceJScrollPane, gc);
			editInvoiceByCustComponents.setLayout(new GridBagLayout());
			gc.gridx = 0;
			gc.gridy = 0;
			editInvoiceByCustComponents.add(new JLabel("Total owed on all invoices:"), gc);
			gc.gridx = 0;
			gc.gridy = 1;
			editInvoiceByCustComponents.add(allInvoicesTotalJTextField, gc);
			allInvoicesTotalJTextField.setPreferredSize(d);
			allInvoicesTotalJTextField.setMinimumSize(d);
			gc.gridx = 0;
			gc.gridy = 2;
			editInvoiceByCustComponents.add(payAllInvoicesJButton, gc);
			payAllInvoicesJButton.setPreferredSize(d);
			payAllInvoicesJButton.setMinimumSize(d);
			gc.gridx = 1;
			gc.gridy = 0;
			editCustomerInvoiceComponentsJPanel.add(editInvoiceByCustComponents, gc);	
			payAllInvoicesJButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					String s = (String)editCustIdComboInv.getSelectedItem();
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
				
			//whole panel
			editInvJPanel.setLayout(new GridBagLayout());
			gc.gridx = 0;
			gc.gridy = 0;
			editInvJPanel.add(findInvoiceComponentsJPanel, gc);
			gc.gridx = 0;
			gc.gridy = 1;
			editInvJPanel.add(editInvoiceComponentsJPanel, gc);
			gc.gridx = 0;
			gc.gridy = 2;
			editInvJPanel.add(editInvoiceProductsComponentsJPanel, gc);
			gc.gridx = 0;
			gc.gridy = 1;
			editInvJPanel.add(editCustomerInvoiceComponentsJPanel, gc);
			editInvoiceProductsComponentsJPanel.setVisible(false);
			editCustomerInvoiceComponentsJPanel.setVisible(false);
			editInvoiceComponentsJPanel.setVisible(false);
			EditInvoiceButtonHandler eib = new EditInvoiceButtonHandler();
			editInvoiceJButton.addActionListener(eib);
			EditCustomerInvoiceButtonHandler ecib = new EditCustomerInvoiceButtonHandler();
			editCustomerInvoiceJButton.addActionListener(ecib);
		
		//set up order panels
		Dimension size = getPreferredSize();
		size.width = 500;
		setPreferredSize(size);
		//Left Panel Components
		createNewOrderLeftPanel.setLayout(new GridBagLayout());
		GridBagConstraints orderGC = new GridBagConstraints();
		orderGC.insets = new Insets(5,5,5,5);
		
		orderGC.gridx = 0;
		orderGC.gridy = 0;
		createNewOrderLeftPanel.add(createOrderOrderIdLabel,orderGC);
		orderGC.gridx = 1;
		orderGC.gridy = 0;
		createOrderOrderIdTextField.setPreferredSize(d);
		createNewOrderLeftPanel.add(createOrderOrderIdTextField,orderGC);
		
		orderGC.gridx = 0;
		orderGC.gridy = 1;
		createNewOrderLeftPanel.add(createOrderSupplierIdLabel,orderGC);
		orderGC.gridx = 1;
		orderGC.gridy = 1;
		createOrderSupplierIdComboBox = new JComboBox<String>(listOfSuppliers);
		listOfSuppliers.setSelectedItem("Select");
		createOrderSupplierIdComboBox.setPreferredSize(d);
		createNewOrderLeftPanel.add(createOrderSupplierIdComboBox,orderGC);
		
		orderGC.gridx = 0;
		orderGC.gridy = 2;
		createNewOrderLeftPanel.add(createOrderProductCodeLabel,orderGC);
		orderGC.gridx = 1;
		orderGC.gridy = 2;
		createOrderProductIdComboBox = new JComboBox<String> (listOfProdIds);
		listOfProdIds.setSelectedItem("Select");
		createOrderProductIdComboBox.setPreferredSize(d);
		createNewOrderLeftPanel.add(createOrderProductIdComboBox,orderGC);
		
		orderGC.gridx = 0;
		orderGC.gridy = 3;
		createNewOrderLeftPanel.add(createOrderQuantityLabel,orderGC);
		orderGC.gridx = 1;
		orderGC.gridy = 3;
		createOrderQuantityTextField.setPreferredSize(d);
		createNewOrderLeftPanel.add(createOrderQuantityTextField,orderGC);
		
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
				createOrderSupplierIdComboBox.setEnabled(true);
				createOrderScrollPaneTextArea.setText("");
				createOrderScrollPaneTextArea.setCaretPosition(0);
				listOfSuppliers.setSelectedItem("Select");
        		listOfOrders.setSelectedItem("Select");
        		listOfProdIds.setSelectedItem("Select");
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
        createNewOrderRightPanel.setBorder(new EmptyBorder(80, 10, 10, 10));
		//Main Panel Add
		createOrderPanel.add(createNewOrderLeftPanel);
		createOrderPanel.add(createNewOrderRightPanel);
		//if clicked, we try to add the product to the order if it is being made, add it to a new one if it isn't and throw up an error if it already has been made.
		createOrderAddProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String orderId = createOrderOrderIdTextField.getText();
				String supplierId = (String) createOrderSupplierIdComboBox.getSelectedItem();
				String productCode = (String) createOrderProductIdComboBox.getSelectedItem();
				String quantity = createOrderQuantityTextField.getText();
				if((orderId.trim().equals("") || orderId.matches(".*\\D.*")) ||
						(supplierId.trim().equals("") || supplierId.matches(".*\\D.*")) ||
							(productCode.trim().equals("") || productCode.matches(".*\\D.*")) ||
								(quantity.trim().equals("") || quantity.matches(".*\\D.*"))){
									JOptionPane.showMessageDialog (null, "Please ensure all text fields have been filled", "Missing Info", JOptionPane.WARNING_MESSAGE);
				}else if(!orderNumberUnique(Integer.parseInt(orderId), orders)){
					JOptionPane.showMessageDialog (null, "Order Number is not Unique", "Order Info", JOptionPane.WARNING_MESSAGE);
				}
				else{
					//disable the other text fields
					createOrderOrderIdTextField.setEnabled(false);
					createOrderSupplierIdComboBox.setEnabled(false);
					
					//Add to 'addMoreArrayList'
					Product p = invoice.returnProductObject(productCode, products);
					int quantity1 = Integer.parseInt(quantity);
					if(p!=null){
						OrderProduct orderProduct = new OrderProduct(p, quantity1);
						addMoreProducts.add(orderProduct);
						
						for(OrderProduct prod : addMoreProducts){
						result += "PRODUCT NO: " + prod.getProduct().getProductCode() +"\nQUANITIY: " + prod.getQuantity() + "\n\n";
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
			public void actionPerformed(ActionEvent e) {
				String orderIdString = createOrderOrderIdTextField.getText();
				String supplierIdString = (String) createOrderSupplierIdComboBox.getSelectedItem();
				String productCodeString = (String) createOrderProductIdComboBox.getSelectedItem();
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
									orderOutputMessage+="ORDER COMPLETE"+
														"\n- - - - - - - - - -"+
														"\nORDER NO: " + orderIdString
														+"\nSUPPLIER NO: " + supplierIdString
														+"\nPRODUCT NO:  " + productCodeString +
														"\nNO. OF ITEMS: " + quantityString;
									
								}else{
									Order multipleOrder = new Order(orderId, supplierId, addMoreProducts);
									orders.add(multipleOrder);
									orderOutputMessage+="ORDER COMPLETE"+
											"\n- - - - - - - - - -"+
											"\nORDER NO: " + orderIdString
											+"\nSUPPLIER NO: " + supplierIdString
											+"\nPRODUCT NO:  " + productCodeString +
											"\nNO. OF ITEMS: " + quantityString + "\n";
									for(Order o : orders){
										if(o.getOrderUniqueId()==orderId){
											for(OrderProduct p : o.getListOfOrderProducts()){
												orderOutputMessage+= "\nPRODUCT CODE: " + p.getProduct().getProductCode() +
													"\nNO. OF ITEMS: " + p.getQuantity() + "\n";
											}
										}
									}
								}
								createOrderScrollPaneTextArea.setText(orderOutputMessage);
								createOrderScrollPaneTextArea.setCaretPosition(0);
								orderOutputMessage = "";
								result="";
								createOrderOrderIdTextField.setEnabled(true);
								createOrderSupplierIdComboBox.setEnabled(true);
								String newOrderIdFromTextField = createOrderOrderIdTextField.getText();
								listOfOrders.addElement(newOrderIdFromTextField);
								
								createOrderOrderIdTextField.setText("");
								createOrderQuantityTextField.setText("");
								listOfProdIds.setSelectedItem("Select");
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
        
		Dimension d2 = new Dimension(300, 30);
		Dimension size1 = getPreferredSize();
		size1.width = 500;
		viewOrderJPanel.setPreferredSize(size1);
		
		GridBagConstraints viewOrderGC = new GridBagConstraints();
		viewOrderGC.insets = new Insets(5, 5, 5, 5);
		viewOrderJPanel.add(viewSupplierPanel);
		viewSupplierPanel.setBorder(new EmptyBorder(80, 10, 10, 10));
		viewSupplierPanel.setLayout(new GridBagLayout());
		viewOrderGC.insets = new Insets(5,5,5,5); 

		//1. TextArea inside scroll pane added first
		viewOrderTextArea = new JTextArea(20,50); //height - width
		viewOrderTextArea.setEditable(false);
		JScrollPane viewOrderScrollPane = new JScrollPane(viewOrderTextArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		GridBagConstraints vOGC = new GridBagConstraints();
		vOGC.gridwidth = GridBagConstraints.REMAINDER;
		vOGC.fill = GridBagConstraints.BOTH;
		vOGC.weightx = 1.0;
		vOGC.weighty = 1.0;
		viewSupplierPanel.add(viewOrderScrollPane, vOGC);

		
		//First row: view all button, orderID label, orderID combo box and orderID button
		viewOrderGC.gridx = 0;
		viewOrderGC.gridy = 1;
		viewOrderViewAllOrdersButton.setMinimumSize(d);
		viewOrderViewAllOrdersButton.setPreferredSize(d);
		viewSupplierPanel.add(viewOrderViewAllOrdersButton, viewOrderGC);
		viewOrderViewAllOrdersButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewOrderTextArea.setText(Order.viewAllOrders(orders));	
				viewOrderTextArea.setCaretPosition(0);
			}
		});
		viewOrderGC.gridx = 1;
		viewOrderGC.gridy = 1;
		viewSupplierPanel.add(viewOrderOrderIdLabel, viewOrderGC);
		viewOrderOrderIdComboBox = new JComboBox<>(listOfOrders);
		viewOrderOrderIdComboBox.setPreferredSize(d);
		viewOrderOrderIdComboBox.setMinimumSize(d);
		listOfOrders.setSelectedItem("Select");
		viewOrderGC.gridx = 2;
		viewOrderGC.gridy = 1;
		viewSupplierPanel.add(viewOrderOrderIdComboBox, viewOrderGC);
		viewOrderGC.gridx = 3;
		viewOrderGC.gridy = 1;
		viewOrderOrderIdButton.setPreferredSize(d2);
		viewOrderOrderIdButton.setMinimumSize(d2);
		viewSupplierPanel.add(viewOrderOrderIdButton, viewOrderGC);
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
					listOfSuppliers.setSelectedItem("Select");
				}
			}
		});

		
		//Second row: view received, supplierID label, supplierID combo box and supplierId button
		viewOrderGC.gridx = 0;
		viewOrderGC.gridy = 2;
		viewOrderViewReceivedButton.setPreferredSize(d);
		viewOrderViewReceivedButton.setMinimumSize(d);
		viewSupplierPanel.add(viewOrderViewReceivedButton, viewOrderGC);
		viewOrderViewReceivedButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewOrderTextArea.setText(Order.viewReceivedOrders(orders));	
				viewOrderTextArea.setCaretPosition(0);	
			}
		});

		viewOrderGC.gridx = 1;
		viewOrderGC.gridy = 2;
		viewSupplierPanel.add(viewOrderSupplierIdLabel,viewOrderGC);
		viewOrderGC.gridx = 2;
		viewOrderGC.gridy = 2;
		viewOrderSupplierIdComboBox = new JComboBox<>(listOfSuppliers);
		viewOrderSupplierIdComboBox.setPreferredSize(d);
		viewOrderSupplierIdComboBox.setMinimumSize(d);
		listOfSuppliers.setSelectedItem("Select");
		viewSupplierPanel.add(viewOrderSupplierIdComboBox, viewOrderGC);
		viewOrderGC.gridx = 3;
		viewOrderGC.gridy = 2;
		viewOrderSupplierIdButton.setPreferredSize(d2);
		viewOrderSupplierIdButton.setMinimumSize(d2);
		viewSupplierPanel.add(viewOrderSupplierIdButton,viewOrderGC);
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

				}
			}
		});

		
		//Third row: unreceived button, title label, title combo box, title button
		viewOrderGC.gridx = 0;
		viewOrderGC.gridy = 3;
		viewOrderViewUnreceivedButton.setPreferredSize(d);
		viewOrderViewUnreceivedButton.setMinimumSize(d);
		viewSupplierPanel.add(viewOrderViewUnreceivedButton, viewOrderGC);
		viewOrderViewUnreceivedButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewOrderTextArea.setText(Order.viewUnreceivedOrders(orders));		
				viewOrderTextArea.setCaretPosition(0);
			}
		});
		viewOrderGC.gridx = 1;
		viewOrderGC.gridy = 3;
		viewSupplierPanel.add(viewOrderTitleLabel, viewOrderGC);
		viewOrderGC.gridx = 2;
		viewOrderGC.gridy = 3;
		viewOrderTitleComboBox = new JComboBox<>(listOfTitles);
		viewOrderTitleComboBox.setPreferredSize(d);
		viewOrderTitleComboBox.setMinimumSize(d);
		listOfTitles.setSelectedItem("Select");
		viewSupplierPanel.add(viewOrderTitleComboBox, viewOrderGC);
		viewOrderGC.gridx = 3;
		viewOrderGC.gridy = 3;
		viewOrderTitleButton.setPreferredSize(d2);
		viewOrderTitleButton.setMinimumSize(d2);
		viewSupplierPanel.add(viewOrderTitleButton, viewOrderGC);
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

		
		//Fourth row: clear panel button, author label, author combo box, author button
		viewOrderGC.gridx = 0;
		viewOrderGC.gridy = 4;
		viewOrderClearPanelButton.setPreferredSize(d);
		viewOrderClearPanelButton.setMinimumSize(d);
		viewSupplierPanel.add(viewOrderClearPanelButton, viewOrderGC);
		viewOrderClearPanelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewOrderTextArea.setText("");		
				viewOrderTextArea.setCaretPosition(0);
				listOfOrders.setSelectedItem("Select");
				//listOfSupplierIds.setSelectedItem("Select");
				listOfTitles.setSelectedItem("Select");
				listOfProductAuthor.setSelectedItem("Select");
			}
		});
		viewOrderGC.gridx = 1;
		viewOrderGC.gridy = 4;
		viewSupplierPanel.add(viewOrderAuthorLabel, viewOrderGC);
		viewOrderGC.gridx = 2;
		viewOrderGC.gridy = 4;
		viewOrderAuthorComboBox = new JComboBox<>(listOfProductAuthor);
		viewOrderAuthorComboBox.setPreferredSize(d);
		viewOrderAuthorComboBox.setMinimumSize(d);
		listOfProductAuthor.setSelectedItem("Select");
		viewSupplierPanel.add(viewOrderAuthorComboBox, viewOrderGC);
		viewOrderGC.gridx = 3;
		viewOrderGC.gridy = 4;
		viewOrderAuthorButton.setPreferredSize(d2);
		viewOrderAuthorButton.setMinimumSize(d2);
		viewSupplierPanel.add(viewOrderAuthorButton,viewOrderGC);
		viewOrderAuthorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = (String) viewOrderAuthorComboBox.getSelectedItem();
				if(input.trim().equals("")){ 
					viewOrderTextArea.setText("Please enter an author's name");
					listOfProductAuthor.setSelectedItem("Select");
					listOfOrders.setSelectedItem("Select");
				}else{
					viewOrderTextArea.setText(Order.viewOrderByAuthor(orders, input));		
					viewOrderTextArea.setCaretPosition(0);
					listOfProductAuthor.setSelectedItem("Select");
					listOfOrders.setSelectedItem("Select");
				}
			}
		});
        //add edit order components	
        findOrderComponentsJPanel.setLayout(new GridBagLayout());
        gc.gridx = 0;
        gc.gridy = 1;
        editOrderOrderIdComboBox = new JComboBox<String> (listOfOrders);
        editOrderOrderIdComboBox.setPreferredSize(d);
        editOrderOrderIdComboBox.setMinimumSize(d);
        listOfOrders.setSelectedItem("Select");
        findOrderComponentsJPanel.add(editOrderOrderIdComboBox, gc);
        gc.gridx = 1;
        gc.gridy = 1;
        editOrderJButton.setPreferredSize(d);
        editOrderOrderIdComboBox.setMinimumSize(d);
        findOrderComponentsJPanel.add(editOrderJButton, gc);
        gc.gridx = 0;
        gc.gridy = 2;
        editOrderSupplierIdComboBox = new JComboBox<String> (listOfSuppliers);
        editOrderSupplierIdComboBox.setSelectedItem("Select");
        findOrderComponentsJPanel.add(editOrderSupplierIdComboBox, gc);
        editOrderSupplierIdComboBox.setPreferredSize(d);
        editOrderSupplierIdComboBox.setMinimumSize(d);
        gc.gridx = 1;
        gc.gridy = 2;
        editOrderSupplierJButton.setPreferredSize(d);
        editOrderSupplierJButton.setMinimumSize(d);
        findOrderComponentsJPanel.add(editOrderSupplierJButton, gc);
        
        //edit by order ID components
        editOrderComponentsJPanel.setLayout(new GridBagLayout());
        gc.gridx = 0;
        gc.gridy = 0;
        editOrderComponentsJPanel.add(new JLabel("Order ID"), gc);
        gc.gridx = 1;
        gc.gridy = 0;
        editOrderComponentsJPanel.add(editOrderId, gc);
        editOrderId.setEditable(false);
        editOrderId.setPreferredSize(d);
        editOrderId.setMinimumSize(d);
        gc.gridx = 0;
        gc.gridy = 1;
        editOrderComponentsJPanel.add(new JLabel("Supplier ID"), gc);
        gc.gridx = 1;
        gc.gridy = 1;
        editOrderComponentsJPanel.add(editOrderSupplier, gc);
        editOrderSupplier.setEditable(false);
        editOrderSupplier.setPreferredSize(d);
        editOrderSupplier.setMinimumSize(d);
        gc.gridx = 0;
        gc.gridy = 2;
        editOrderComponentsJPanel.add(new JLabel("Total"), gc);
        gc.gridx = 1;
        gc.gridy = 2;
        editOrderComponentsJPanel.add(editOrderAmount, gc);
        editOrderAmount.setPreferredSize(d);
        editOrderAmount.setMinimumSize(d);
        gc.gridx = 0;
        gc.gridy = 3;
        editOrderComponentsJPanel.add(editOrderReceivedStatus, gc);
        editOrderReceivedStatus.setPreferredSize(d);
        editOrderReceivedStatus.setMinimumSize(d);
        editOrderReceivedStatus.setEditable(false);
        gc.gridx = 1;
        gc.gridy = 3;
        editOrderComponentsJPanel.add(receiveOrderJButton, gc);
        receiveOrderJButton.setPreferredSize(d);
        receiveOrderJButton.setMinimumSize(d);
        receiveOrderJButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		String s = (String) editOrderOrderIdComboBox.getSelectedItem();
        		int comboId = Integer.parseInt(s.trim());
        		for(Order order: orders){
        			if(order.getOrderUniqueId() == comboId){
        				if(order.isReceived() == true){
        					editOrderJButton.doClick();	
        					listOfOrders.setSelectedItem("Select");
        					break;
        				}
        				else{
        					order.setReceived();
        	        		editOrderReceivedStatus.setForeground(Color.BLACK);
        	        		editOrderJButton.doClick();	
        	        		listOfOrders.setSelectedItem("Select");
        					break;
        				}
        			}
        		}
        	}
        });
        //show order details in scrollPane
        gc.gridx = 0;
        gc.gridy = 0;
        JScrollPane orderProductsJScrollPane = new JScrollPane(productOrderJTextArea);
        orderProductsJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        orderProductsJScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);	
        editOrderProductsComponentsJPanel.add(orderProductsJScrollPane, gc);
        editOrderProductsComponentsJPanel.setLayout(new GridLayout(1,2));
        productOrderJTextArea.setEditable(false);
        saveOrderComponentsJPanel.setLayout(new GridBagLayout());
        gc.gridx = 0;
        gc.gridy = 0;
        saveOrderComponentsJPanel.add(saveOrderJButton, gc);
        saveOrderJButton.setPreferredSize(d);
        saveOrderJButton.setMinimumSize(d);
        gc.gridx = 1;
        gc.gridy = 0;
        saveOrderComponentsJPanel.add(deleteOrderJButton, gc);
        deleteOrderJButton.setPreferredSize(d);
        deleteOrderJButton.setMinimumSize(d);
        deleteOrderJButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		int index = 0;
        		String s = (String) editOrderOrderIdComboBox.getSelectedItem();
        		int comboId = Integer.parseInt(s.trim());
        		for(Order order: orders){
        			if(order.getOrderUniqueId() == comboId){
        				index = orders.indexOf(order);
        			}
        		}
        		orders.remove(index);
        		JOptionPane.showMessageDialog(null, "Deleted!");
        		editOrderOrderIdComboBox.removeItemAt(comboId);
        		editSupplierOrderComponentsJPanel.setVisible(false);
        		editOrderComponentsJPanel.setVisible(false);
        		saveOrderComponentsJPanel.setVisible(false);
        		editOrderProductsComponentsJPanel.setVisible(false);
        		listOfSuppliers.setSelectedItem("Select");
        		listOfOrders.setSelectedItem("Select");
        	}
        });
        //edit by supplier
        editSupplierOrderComponentsJPanel.setLayout(new GridBagLayout());
        gc.gridx = 0;
        gc.gridy = 0;
        JScrollPane supplierOrderJScrollPane = new JScrollPane(supplierOrderJTextArea);
        supplierOrderJScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        editSupplierOrderComponentsJPanel.add(supplierOrderJScrollPane, gc);
        editOrderBySupplierComponentsJPanel.setLayout(new GridBagLayout());
        gc.gridx = 0;
        gc.gridy = 0;
        editOrderBySupplierComponentsJPanel.add(new JLabel("Total owed on all orders:"), gc);
        gc.gridx = 0;
        gc.gridy = 1;
        editOrderBySupplierComponentsJPanel.add(allOrdersTotalJTextField, gc);
        allOrdersTotalJTextField.setPreferredSize(d);
        allOrdersTotalJTextField.setMinimumSize(d);
        gc.gridx = 0;
        gc.gridy = 2;
        editOrderBySupplierComponentsJPanel.add(receiveAllOrdersJButton, gc);
        receiveAllOrdersJButton.setPreferredSize(d);
        receiveAllOrdersJButton.setMinimumSize(d);
        gc.gridx = 1;
        gc.gridy = 0;
        editSupplierOrderComponentsJPanel.add(editOrderBySupplierComponentsJPanel, gc);
        
        receiveAllOrdersJButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		String s = (String) editOrderSupplierIdComboBox.getSelectedItem();
        		int comboId = Integer.parseInt(s.trim());
        		boolean findUnreceived = false;
        		for(Order orderCheck: orders)
        		{
        			if(orderCheck.getSupplierUniqueId() == comboId){
        				if(orderCheck.isReceived() == false){
        					findUnreceived = true;
                			break;
        				}
        			}
        		}
        		
        		if(findUnreceived){
        			for(Order order: orders){
            			if(order.getSupplierUniqueId() == comboId ){
            				order.setReceived();
            			}
            		}
            		JOptionPane.showMessageDialog(null, "Received!");
            		editOrderSupplierJButton.doClick();
            		supplierOrderJTextArea.setText("");
            		supplierOrderJTextArea.setCaretPosition(0);
            		listOfOrders.setSelectedItem("Select");
            		listOfSuppliers.setSelectedItem("Select");
					editSupplierOrderComponentsJPanel.setVisible(false);
					editOrderComponentsJPanel.setVisible(false);
					saveOrderComponentsJPanel.setVisible(false);
					editOrderProductsComponentsJPanel.setVisible(false);
            		
            	}
        		else{
        			JOptionPane.showMessageDialog(null, "All orders from this supplier already received!");
        		}
        	}	
        });
        editOrderJPanel.setLayout(new GridBagLayout());
        gc.gridx = 0;
        gc.gridy = 0;
        editOrderJPanel.add(findOrderComponentsJPanel, gc);
        gc.gridx = 0;
        gc.gridy = 1;
        editOrderJPanel.add(editOrderComponentsJPanel, gc);
        gc.gridx = 0;
        gc.gridy = 2;
        editOrderJPanel.add(editOrderProductsComponentsJPanel, gc);
        gc.gridx = 0;
        gc.gridy = 3;
        //editOrderJPanel.add(saveOrderComponentsJPanel, gc);
        gc.gridx = 0;
        gc.gridy = 1;
        editOrderJPanel.add(editSupplierOrderComponentsJPanel, gc);
        editOrderProductsComponentsJPanel.setVisible(false);
        editSupplierOrderComponentsJPanel.setVisible(false);
        editOrderComponentsJPanel.setVisible(false);
        saveOrderComponentsJPanel.setVisible(false);
        editOrderButtonHandler eob = new editOrderButtonHandler();
        editOrderJButton.addActionListener(eob);
        editSupplierOrderButtonHandler esob = new editSupplierOrderButtonHandler();
        editOrderSupplierJButton.addActionListener(esob);
        saveOrderButtonHandler sobh = new saveOrderButtonHandler();
        saveOrderJButton.addActionListener(sobh);
	
		//ViewCustomerInvoice Functionality - Marc
        //Hardcoding info 
        for(int i=0;i<invoices.size();i++){
			 existingInvoiceNums.add(Integer.toString(invoices.get(i).getId()));
        }
        for(int i = 0;i<customers.size();i++){
        existingCustomerId.add(Integer.toString(customers.get(i).getCustId()));
        }
    
        
		GridBagConstraints gc = new GridBagConstraints();
		gc.insets = new Insets(5, 5, 5, 5);
		viewInvJPanel.add(viewCustomerPanel);
		viewCustomerPanel.setBorder(new EmptyBorder(80, 10, 10, 10));
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
					editListOfInvoices.setSelectedItem("select");
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
				editListOfInvoices.setSelectedItem("select");
				
			}
		});
		
		//Left Panel Components
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
		gc.gridx = 0;
		gc.gridy = 0;
		leftPanel.add(invIdLbl,gc);
		invTextF = new JTextField();
		gc.gridx = 1;
		gc.gridy = 0;
		invTextF.setPreferredSize(d);
		leftPanel.add(invTextF,gc);
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
		
		gc.gridx = 0;
		gc.gridy = 3;
		leftPanel.add(prodId,gc);
			//Add combo here
		prodIDComboBox = new JComboBox<String>(listOfProdIds);
		prodIDComboBox.setPreferredSize(d);
		listOfProdIds.setSelectedItem("Select");
		gc.gridx = 1;
		gc.gridy = 3;
		leftPanel.add(prodIDComboBox,gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		leftPanel.add(quantitylbl,gc);
		gc.gridx = 1;
		gc.gridy = 4;
		quantityTextF = new JTextField();
		quantityTextF.setPreferredSize(d);
		leftPanel.add(quantityTextF,gc);
		
		gc.gridx = 1;
		gc.gridy = 5;
		addMoreBtn.setPreferredSize(d); //width/height
		leftPanel.add(addMoreBtn,gc);
		//AddMoreBtn Event Listener
		addMoreBtn.addActionListener(new ActionListener() {
			// Add more products to Invoice
			public void actionPerformed(ActionEvent e) {
				String prodId =(String)prodIDComboBox.getSelectedItem();;
				String quan = quantityTextF.getText();
				String invoiceIdStr = invTextF.getText();
				int invoiceId = Integer.parseInt(invoiceIdStr);
				if(prodId.equals("select")|| (quan.trim().equals("") || quan.matches(".*\\D.*"))){
					JOptionPane.showMessageDialog (null, "There is an error in your input", "Missing Info", JOptionPane.WARNING_MESSAGE);
				}else{
					if(invoiceNumberUnique(invoiceId,invoices)){
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
						message += "PRODUCT NO: " + prod.getProduct().getProductCode() +"\nQUANTITY: " + prod.getQuantity() + "\n\n";
						}
						textAreaMarc.setText(message);
						textAreaMarc.setCaretPosition(0);
						message = "";
						
					}
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
		
		gc.gridx = 1;
		gc.gridy = 6;
		finishBtn.setPreferredSize(d);
		leftPanel.add(finishBtn,gc);
		//finishBtn eventListener
		finishBtn.addActionListener(new ActionListener() {
			//Finish creating Invoice
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
					||	(quantityStr.equals("select") || quantityStr.matches(".*\\D.*")))
				{
					JOptionPane.showMessageDialog (null, "There is an error in your input", "Missing Info", JOptionPane.WARNING_MESSAGE);
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
									outputMessage += "INVOICE CREATED "
												   + "\n- - - - - - - - - - - - - - "+
															"\nINVOICE NO: 	" + invoiceIdStr +
															"\n- - - - - - - - - - - - - - "+
															"\nEMPLOYEE NO:        "+ employeeIdStr +
															"\nCUSTOMER NO:       " + customerIdStr+
															"\nPRODUCT CODE:    " + productIdStr+
															"\nNO. OF ITEMS:           " + quantityStr;
															//+"\nArraySize: " + addMoreArrayList.size();
									//existingInvoiceNums.add(invoiceIdStr);
									
									}else{
										Invoice multipleInvoice = new Invoice(invoiceId,employeeObj,customerObj,addMoreArrayList);
										invoices.add(multipleInvoice);
										//System.out.println(invoices.size());
										outputMessage +=  "INVOICE CREATED "
												   + "\n- - - - - - - - - - - - - - "+
												"\nINVOICE NO: " + invoiceIdStr +
												"\n- - - - - - - - - - - - - - "+
												"\nEMPLOYEES NO: "+ employeeIdStr +
												"\nCUSTOMER NO: " + customerIdStr+
												"\nLIST OF PRODUCT ORDERED:" +
												"\n- - - - - - - - - - - - - - ";
										for(Invoice v : invoices){
											if(v.getId()==invoiceId){
												for(InvoiceProduct p : v.getInvoiceProducts()){
												outputMessage+= "\nPRODUCT CODE: " + p.getProduct().getProductCode() +
														"\nNO OF ITEMS: " + p.getQuantity() + "\n";
												}
											}
										}
									//outputMessage+="\nArraySize: " + addMoreArrayList.size(); for testing
									}
									String inputFromTestField = invTextF.getText();
									listOfInvoices.addElement(inputFromTestField);
									editListOfInvoices.addElement(inputFromTestField);
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
									//editListOfInvoices.setSelectedItem("select");
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
	
		//Right Panel : textAreaMarc and Pane
		
		textAreaMarc = new JTextArea(19,20);
		textAreaMarc.setEditable(false);
		JScrollPane scrollPane3 = new JScrollPane(textAreaMarc,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		rightPanel.setBorder(new EmptyBorder(80, 10, 10, 10));
        rightPanel.add(scrollPane3, gc);
		
		//Main Panel Add
        createNewInvoicePanel.add(leftPanel);
        createNewInvoicePanel.add(rightPanel);
		//End of Marc Functionality
		
		//Product Details
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
		JLabel productIdlbl = new JLabel("Enter Product ID: ");
		productGC.gridx = 0;
		productGC.gridy = 1;
		viewProductDetails.add(productIdlbl,productGC);
		comboBoxProductId = new JComboBox<>(listOfProdIds);
		comboBoxProductId.setEditable(true);
		comboBoxProductId.setPreferredSize(d);
		comboBoxProductId.setMinimumSize(d);
		productGC.gridx = 1;
		productGC.gridy = 1;
		viewProductDetails.add(comboBoxProductId,productGC);
		JButton productButton = new JButton("Search Product ID");
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
				if(input.trim().equals("Select")){ 
					
					productTextArea.setText("");
					productTextArea.setCaretPosition(0);
					listofProductTitle.setSelectedItem("Select");
					listOfProductAuthor.setSelectedItem("Select");
					JOptionPane.showMessageDialog(null, "Please Select Product ID From Drop Down Menu");
		
				}else{
				
					productTextArea.setText(product.viewProductById(input, products)); //viewInvoiceById() is in the Invoice Class
					productTextArea.setCaretPosition(0);
					listOfProdIds.setSelectedItem("Select");
					listofProductTitle.setSelectedItem("Select");
					listOfProductAuthor.setSelectedItem("Select");
					priceRange.clearSelection();
					quantity.clearSelection();
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
		comboBoxProductTitle.setSelectedItem("Select");
		Collections.sort(existingProductTitle, String.CASE_INSENSITIVE_ORDER);
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
				
				if(input.trim().equals("Select")){ 
					productTextArea.setText("");
					productTextArea.setCaretPosition(0);
					listOfProdIds.setSelectedItem("Select");
					listOfProductAuthor.setSelectedItem("Select");
					JOptionPane.showMessageDialog(null, "Please Select Product Title From Drop Down Menu");
					
				}else{
					
					productTextArea.setText(product.viewProductByTitle(input, products));	//viewInvoiceByCustomer() is in the Invoice class
					productTextArea.setCaretPosition(0);
					listOfProdIds.setSelectedItem("Select");
					listofProductTitle.setSelectedItem("Select");
					listOfProductAuthor.setSelectedItem("Select");
					priceRange.clearSelection();
					quantity.clearSelection();
					
					
				}
			}
		});
		
		// For Loop to populate ComboBox of Author.
				 for(int i=0;i<products.size();i++){
					 existingProductAuthor.add((products.get(i).getAuthor()));
		       }
				 
		HashSet productsHashSet = new HashSet();
	 	productsHashSet.addAll(existingProductAuthor);
		existingProductAuthor.clear();					
		existingProductAuthor.addAll(productsHashSet);
		Collections.sort(existingProductAuthor, String.CASE_INSENSITIVE_ORDER);
		
		//Third Label and controls: 	View Product by Author
		JLabel productAuthorlbl = new JLabel("Product Author: ");
		productGC.gridx = 0;
		productGC.gridy = 3;
		viewProductDetails.add(productAuthorlbl,productGC);
		comboBoxProductAuthor = new JComboBox<>(listOfProductAuthor);
		comboBoxProductAuthor.setEditable(true);
		comboBoxProductAuthor.setPreferredSize(d);
		comboBoxProductAuthor.setMinimumSize(d);
		comboBoxProductAuthor.setSelectedItem("Select");
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
			
			//Action listener For Button to view product by Author
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = ((String)comboBoxProductAuthor.getSelectedItem()).toLowerCase();
				//String input = (productAuthorTextField.getText()).toLowerCase();	// Convert input text to lower case. 
																					//All names in array should be stored in lower case.
				
				if(input.trim().equals("select")){ 	// If no value is selected
					productTextArea.setText("");
					productTextArea.setCaretPosition(0);
					listOfProdIds.setSelectedItem("Select");
					listofProductTitle.setSelectedItem("Select");					
					JOptionPane.showMessageDialog(null, "Please Select Product Author From Drop Down Menu");
					
					
				}else{							// Take in String and Search for it.
					productTextArea.setText(product.viewProductByAuthor(input, products));	
					productTextArea.setCaretPosition(0);		// This sets the position of the scroll bar to the top of the page.
					listOfProdIds.setSelectedItem("Select");
					listofProductTitle.setSelectedItem("Select");
					listOfProductAuthor.setSelectedItem("Select");
					priceRange.clearSelection();
					quantity.clearSelection();
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
				listOfProdIds.setSelectedItem("Select");
				listofProductTitle.setSelectedItem("Select");
				listOfProductAuthor.setSelectedItem("Select");
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
				productTextArea.setCaretPosition(0);
				listOfProdIds.setSelectedItem("Select");
				listofProductTitle.setSelectedItem("Select");
				listOfProductAuthor.setSelectedItem("Select");
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
				productTextArea.setCaretPosition(0);
				listOfProdIds.setSelectedItem("Select");
				listofProductTitle.setSelectedItem("Select");
				listOfProductAuthor.setSelectedItem("Select");
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
				productTextArea.setCaretPosition(0);
				quantity.clearSelection();
				}
				if (fiveTo10Radio.isSelected()){
				productTextArea.setText(product.viewProductbyRetailPrice(5,10, products));
				productTextArea.setCaretPosition(0);
				quantity.clearSelection();
				}
				if (tenTo20Radio.isSelected()){
				productTextArea.setText(product.viewProductbyRetailPrice(10.01, 20, products));
				productTextArea.setCaretPosition(0);
				quantity.clearSelection();
				}
				if (over20Radio.isSelected()){
				productTextArea.setText(product.viewProductbyRetailPrice(20.01, 100, products));
				productTextArea.setCaretPosition(0);
				quantity.clearSelection();
				}
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
					productTextArea.setCaretPosition(0);
					priceRange.clearSelection();
					}
					if (fiftyTo100Radio.isSelected()){
					productTextArea.setText(product.viewProductbyQuantity(51,100, products));
					productTextArea.setCaretPosition(0);
					priceRange.clearSelection();
					}
					if (hundredTo200Radio.isSelected()){
					productTextArea.setText(product.viewProductbyQuantity(101, 200, products));	
					productTextArea.setCaretPosition(0);
					priceRange.clearSelection();
					}
					if (over200Radio.isSelected()){
					productTextArea.setText(product.viewProductbyQuantity(200, 500, products));
					productTextArea.setCaretPosition(0);
					priceRange.clearSelection();
				}
			}
		});

		// to edit product	
		
		 // For Loop used to Populate Combo Box of ProductCode/ID
        for(int i=0;i<products.size();i++){
			 existingEditProdId.add((products.get(i).getProductCode()));
       }
		
		
		editDetailsJButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				for(Product product: products){				
					if(product.getProductCode().equals(comboBoxEditProdId.getSelectedItem())){
					editCodeJTextField.setText(product.getProductCode());
					editCodeJTextField.setBackground(Color.LIGHT_GRAY);
					editAuthorJTextField.setText(product.getAuthor());
					editAuthorJTextField.setBackground(Color.LIGHT_GRAY);
					editTitleJTextField.setText(product.getTitle());
					editTitleJTextField.setBackground(Color.LIGHT_GRAY);
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
				try{
				for (Product product: products){
					if(product.getProductCode().equals(comboBoxEditProdId.getSelectedItem())){
						product.setAuthor(editAuthorJTextField.getText());
						product.setTitle(editTitleJTextField.getText());
						product.setRetailPrice(Double.parseDouble(editRetailJTextField.getText()));
						product.setCostPrice(Double.parseDouble(editCostJTextField.getText()));
						product.setCurrentStock(Integer.parseInt(editStockJTextField.getText()));
						product.setMaxStock(Integer.parseInt(editMaxJTextField.getText()));
						product.setMinStock(Integer.parseInt(editMinJTextField.getText()));
						
						for (Supplier supplier:suppliers){
							if (supplier.getId() == Integer.parseInt (editProdSupplierIdJTextField.getText())){
							product.setSupplier(supplier);
							}
						}
					
						JOptionPane.showMessageDialog(null, "Product updated");
						listOfProdIds.setSelectedItem("select");
						editAuthorJTextField.setText("");
						editTitleJTextField.setText("");
						editRetailJTextField.setText("");
						editCostJTextField.setText("");
						editStockJTextField.setText("");
						editMaxJTextField.setText("");
						editMinJTextField.setText("");
						editCodeJTextField.setText("");
						editProdSupplierIdJTextField.setText("");
					}
				}
				}
						
						catch(NumberFormatException nfe){
							JOptionPane.showMessageDialog(null, "Please enter a digit in field required");
						}
					}
				
			
		});

		// to delete stockline from system
		deleteStockLineJButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int warning = JOptionPane.YES_NO_OPTION;
				int result = JOptionPane.showConfirmDialog(null, "Delete this stockline?", "warning!", warning);
				if (result == 0){
				String code = editCodeJTextField.getText();
				Product proReturned = product.removeStockById(code,products);
				JOptionPane.showMessageDialog(null, "Stockline deleted");
				listOfProdIds.removeElement(proReturned.getProductCode());
				listofProductTitle.removeElement(proReturned.getTitle());
				listOfProdIds.setSelectedItem("select");
				editAuthorJTextField.setText("");
				editTitleJTextField.setText("");
				editRetailJTextField.setText("");
				editCostJTextField.setText("");
				editStockJTextField.setText("");
				editMaxJTextField.setText("");
				editMinJTextField.setText("");
				editCodeJTextField.setText("");
				editProdSupplierIdJTextField.setText("");
			}
			}
		});
		
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
		pLJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
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
	
		//Graph Information Panel
		graphJPanel.setLayout(new GridBagLayout());
		GridBagConstraints graphgc = new GridBagConstraints();
		graphgc.insets = new Insets(5,5,5,5);
		// Pie Chart Highest lowest Selling
				//high low
				highestSellingButton = new JButton();
				graphgc.gridx = 1;
				graphgc.gridy = 1;
				graphJPanel.add(highestSellingButton,graphgc);
				highestSellingButton.setIcon(new ImageIcon("src\\images\\top.png"));
				highestSellingButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent ex) {
						productCodes = findProductCodes();
						countsHigher = new int[productCodes.size()];

						// count occurrence of each product in the invoices
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
				
				lowsetsellingButton = new JButton();
				graphgc.gridx = 2;
				graphgc.gridy = 1;
				graphJPanel.add(lowsetsellingButton,graphgc);
				lowsetsellingButton.setIcon(new ImageIcon("src\\images\\bottom.png"));
				lowsetsellingButton.addActionListener(new ActionListener() {
					
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
			    graphgc.gridx = 0;
				graphgc.gridy = 2;
				graphJPanel.add(lineChartJButton, graphgc);
				lineChartJButton.setIcon(new ImageIcon("src\\images\\income.png"));
				lineChartJButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						try{
							populateIEGraph();
							JFreeChart lineChart = ChartFactory.createLineChart("Income and Expenditure","Month","Value",line_chart_dataset,PlotOrientation.VERTICAL,true,true,false);
							ChartFrame frame = new ChartFrame("Income and Expenditure", lineChart);
							frame.setBounds(0, 0, 600, 600);
							frame.setVisible(true);
							frame.setSize(850, 600);
						}catch (Exception i){
				             //System.out.println(i);
				         }
					}
				});
				
				
				JButton costGraph = new JButton ();
				graphgc.gridx = 0;
				graphgc.gridy = 1;
				graphJPanel.add(costGraph,graphgc);
				costGraph.setIcon(new ImageIcon("src\\images\\stock.png"));
				costGraph.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						DefaultCategoryDataset costData = new DefaultCategoryDataset();
						costData.setValue(product.quantityByCost(0.01, 1.99, products), "Price", "under 2 Euro");
						costData.setValue(product.quantityByCost(2.00, 3.00, products), "Price", "2 to 3 Euro");
						costData.setValue(product.quantityByCost(3.01, 5.00, products), "Price", "3 to 5 Euro");
						costData.setValue(product.quantityByCost(5.01, 200.99, products), "Price", "over 5 Euro");
					
						JFreeChart costChart = ChartFactory.createBarChart("Stock by Cost Price Chart", "Cost Price Range", "Stock Quantity", costData, PlotOrientation.VERTICAL, false, true, false);
						CategoryPlot p = costChart.getCategoryPlot();
						p.setRangeGridlinePaint(Color.BLACK);
						ChartFrame retailGraphFrame = new ChartFrame("Stock by Cost Chart",costChart);
						retailGraphFrame.setVisible(true);
						retailGraphFrame.setSize(850, 600);
					}
				});
				
				JButton salesGraph = new JButton ();
				graphgc.gridx = 1;
				graphgc.gridy = 2;
				graphJPanel.add(salesGraph,graphgc);
				salesGraph.setIcon(new ImageIcon("src\\images\\prediction.png"));
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
						JFreeChart salesChart = ChartFactory.createBarChart("Sales and Prediction Chart", "Month", "Sales value", salesData, PlotOrientation.VERTICAL, false, true, false);
						CategoryPlot p = salesChart.getCategoryPlot();
						p.setRangeGridlinePaint(Color.BLACK);
						ChartFrame salesGraphFrame = new ChartFrame("Sales and predictions", salesChart);
						salesGraphFrame.setVisible(true);
						salesGraphFrame.setSize(850, 600);
					}
				});
		
				//Pie Chart View Paid Vs. Unpaid Invoices
				JButton invoicesPieChart = new JButton();
				graphgc.gridx =2;
				graphgc.gridy= 2;
				graphJPanel.add(invoicesPieChart,graphgc);
				invoicesPieChart.setIcon(new ImageIcon("src\\images\\paid.png"));
				invoicesPieChart.addActionListener(new ActionListener(){
				
					public void actionPerformed(ActionEvent e){
						
						int count=0;
						int paid = invoice.countPaidInvoices(count, invoices);
						int unpaid = (invoices.size()-paid);
						pieDataset.setValue("Paid",paid);
						pieDataset.setValue("UnPaid",unpaid);
						
						JFreeChart chart = ChartFactory.createPieChart3D("Invoice Review", pieDataset, true,true,true);
						ChartFrame frame = new ChartFrame("Pie Chart", chart);
						frame.setVisible(true);
						frame.setSize(850, 600);
					}
				});
		}
	// - end of constructor
	
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
				suppliers.add(new Supplier(1, "Smiths", "Dublin","sam@email.com",123456));
				suppliers.add(new Supplier(2, "Thompsons", "Cork","tom@email.com",234567));
				suppliers.add(new Supplier(3, "Randome", "Dublin", "randome@email.com", 789654));
				suppliers.add(new Supplier(4, "Sealion", "Limerick", "sealion@email.com", 987654 ));
				suppliers.add(new Supplier(5, "Salmon", "Athlone", "salmon@email.com", 258963));
				suppliers.add(new Supplier(6, "Beales", "Dublin", "beales@email.com", 369852));
				suppliers.add(new Supplier(7, "Buzzco", "Cork", "buzzco@email.com", 147852));
				suppliers.add(new Supplier(8, "Vantage", "Waterford", "vantage@email.com", 255856));
			
				
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
				products.add(new Product("The Girl with the Dragon Tattoo", "Steig Larsson", "0018", 9.99, 1.98,15,20,10,suppliers.get(3)));
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
		editExistingInvoiceNums.add("Select");
		for(Invoice invoice: invoices){
			editExistingInvoiceNums.add(Integer.toString(invoice.getId()));
		}
	}
	
	//fill profit and loss combo box
	public void fillPLComboBox(){
		months.add("Select");
		months.add("Current Month");
		months.add("Last Month");
		months.add("Last 3 Months");
		months.add("View All");
	}

	

	private class EditInvoiceButtonHandler implements ActionListener{
		public void actionPerformed( ActionEvent e){//handler starts
			int id = 0;
			editCustIdComboInv.setSelectedIndex(0);
			String s = (String)editComboBoxInvoice.getSelectedItem();
			if(s.equals("Select") || s.equals("select")){
				id = 0;
			}
			else{
				id = Integer.parseInt( s );
			}
			productInvoiceJTextArea.setText("Product Details\n");
			int invoiceID = verifyInvoiceID(id);
			if(invoiceID == 1){
				for(Invoice invoice: invoices){
					if(id == invoice.getId()){
						editCustomerInvoiceComponentsJPanel.setVisible(false);
						editInvoiceComponentsJPanel.setVisible(true);
						editInvoiceProductsComponentsJPanel.setVisible(true);
						editInvoiceEmployee.setText(Integer.toString(invoice.getEmployee().getEmployeeId()));
						editInvoiceCustomer.setText(Integer.toString(invoice.getCustomer().getCustId()));
						for(InvoiceProduct ip: invoice.getInvoiceProducts()){
							s = "\nId: " + ip.getProduct().getProductCode() + ", Title: " + ip.getProduct().getTitle() + 
									", Quantity: " + Integer.toString(ip.getQuantity());
							productInvoiceJTextArea.append(s);								
							}	
						editInvoiceAmount.setText( new String(String.format("%.2f", invoice.getTotalInvoicePrice())));
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
				//JOptionPane.showMessageDialog(loginJPanel, "Invoice ID not found", "For your information", JOptionPane.INFORMATION_MESSAGE);
				editCustomerInvoiceComponentsJPanel.setVisible(false);
				editInvoiceComponentsJPanel.setVisible(false);
				editInvoiceProductsComponentsJPanel.setVisible(false);
				editListOfInvoices.setSelectedItem(editExistingInvoiceNums.get(0));
			}
			productInvoiceJTextArea.setCaretPosition(0);
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
					productOrderJTextArea.setText("");
					allOrdersTotalJTextField.setEditable(false);
					double total = 0;
					int id = 0;
					boolean dontShow = false;
					String s = (String) editOrderSupplierIdComboBox.getSelectedItem();
					boolean foundUnreceived = false;
					if(!s.equals("Select")){
						id = Integer.parseInt( s );
						for(Order order: orders){
							if(id == order.getSupplierUniqueId()){
								if(!order.isReceived()){
									foundUnreceived = true;
									break;
								}
							}
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Please choose a supplier ID number.");
						dontShow = true;
					}
					
					if(foundUnreceived){
						editSupplierOrderComponentsJPanel.setVisible(true);
						editOrderComponentsJPanel.setVisible(false);
						saveOrderComponentsJPanel.setVisible(false);
						editOrderProductsComponentsJPanel.setVisible(false);
						supplierOrderJTextArea.setText("Unreceived Orders: \n");
						for(Order order: orders){
							if(id == order.getSupplierUniqueId() ){
								if(order.isReceived() == false){
									s = "\nOrder Id : " + order.getOrderUniqueId() + 
											"\nDate: " + sdf.format(order.getOrderDate()) + "\nTotal: ";
									supplierOrderJTextArea.append(s);
									supplierOrderJTextArea.append(new String(String.format("%.2f", order.calculateOrderWorth())));
									total = total + order.calculateOrderWorth();
									
									supplierOrderJTextArea.append("\n - - - - - - - - - - - \n");
								}
							}
						}
						allOrdersTotalJTextField.setText(new String(String.format("%.2f", total)));
						
					}
					else if (!foundUnreceived){
						JOptionPane.showMessageDialog(loginJPanel, "No unreceived orders for this supplier", "For your information", JOptionPane.INFORMATION_MESSAGE);
						editSupplierOrderComponentsJPanel.setVisible(false);
						editOrderComponentsJPanel.setVisible(false);
						saveOrderComponentsJPanel.setVisible(false);
						editOrderProductsComponentsJPanel.setVisible(false);
					}
					else if(dontShow){
						editSupplierOrderComponentsJPanel.setVisible(false);
						editOrderComponentsJPanel.setVisible(false);
						saveOrderComponentsJPanel.setVisible(false);
						editOrderProductsComponentsJPanel.setVisible(false);
					}
					supplierOrderJTextArea.setCaretPosition(0);
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
					invJTabbedPane.setEnabledAt(2, true);
					orderJTabbedPane.setEnabledAt(2, true);
					supplyJTabbedPane.setEnabledAt(2, true);
					prodJTabbedPane.setEnabledAt(2, true);
					custJTabbedPane.setEnabledAt(2, true);	
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
					invJTabbedPane.setSelectedIndex(0);
					orderJTabbedPane.setSelectedIndex(0);
					supplyJTabbedPane.setSelectedIndex(0);
					prodJTabbedPane.setSelectedIndex(0);
					custJTabbedPane.setSelectedIndex(0);
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
				editOrderSupplierIdComboBox.setSelectedItem("Select");
				productOrderJTextArea.setText("");
				editOrderAmount.setEditable(false);
				int id = 0;
				String s = (String) listOfOrders.getSelectedItem();
				if(!s.equals("Select")){
					id = Integer.parseInt(s);
					for(Order order: orders){
						if(id == order.getOrderUniqueId()){
							if(order.isReceived()){
								JOptionPane.showMessageDialog(null, "Order has been received! ");
								editSupplierOrderComponentsJPanel.setVisible(false);
								editOrderComponentsJPanel.setVisible(false);
								saveOrderComponentsJPanel.setVisible(false);
								editOrderProductsComponentsJPanel.setVisible(false);
							}
							else{
								editSupplierOrderComponentsJPanel.setVisible(false);
								editOrderComponentsJPanel.setVisible(true);
								saveOrderComponentsJPanel.setVisible(true);
								editOrderProductsComponentsJPanel.setVisible(true);
								productOrderJTextArea.setText("Order details: \n");
								editOrderId.setText(Integer.toString(id));
								editOrderSupplier.setText(Integer.toString(order.getSupplierUniqueId()));
								productOrderJTextArea.setText("Order ID: " + editOrderId.getText() + "\nSupplier ID: " + editOrderSupplier.getText());
								for(OrderProduct op: order.getListOfOrderProducts()){
											s = "\nProduct ID: " + op.getProduct().getProductCode() + ", Title: " + op.getProduct().getTitle() + 
											", Quantity: " + Integer.toString(op.getQuantity());
											productOrderJTextArea.append(s);								
									}	
								editOrderAmount.setText(new String(String.format("%.2f", order.calculateOrderWorth())));
							}
							
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
				else{
					JOptionPane.showMessageDialog(null, "Please choose an order ID number.");
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
					int count = 0, count1 = 0;
					int id = 0;
					int customerID = 1;
					editListOfInvoices.setSelectedItem(editExistingInvoiceNums.get(0));
					String s = (String)editCustIdComboInv.getSelectedItem();
					if(s.equals("Select")){
						customerID = 2;
					}
					else{
						id = Integer.parseInt( s );
					}							
					double total = 0;
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
						editInvoiceProductsComponentsJPanel.setVisible(false);
						customerInvoiceJTextArea.setText("Unpaid Invoices:");
						for(Invoice invoice: invoices){
							if(id == invoice.getCustomer().getCustId() ){
								if(invoice.isPaid() == false){
									s = "\n\nInvoice Id : " + invoice.getId() + 
											"\nDate: " + sdf.format(invoice.getInvoiceDate())+ "\nTotal: ";
									customerInvoiceJTextArea.append(s);
									customerInvoiceJTextArea.append(new String(String.format("%.2f", invoice.getTotalInvoicePrice())));
									total = total + invoice.getTotalInvoicePrice();
									count++;								
								}
							}
						}
						if(count == 0){
							JOptionPane.showMessageDialog(loginJPanel, "No unpaid invoices for this customer", "For your information", JOptionPane.INFORMATION_MESSAGE);
							editCustomerInvoiceComponentsJPanel.setVisible(false);
							editCustIdComboInv.setSelectedIndex(0);
						}
						else{
							allInvoicesTotalJTextField.setText( new String(String.format("%.2f", total)));
						}						
					}
					else if(customerID == 2){
						//no customer id match
						JOptionPane.showMessageDialog(loginJPanel, "Customer ID not found", "For your information", JOptionPane.INFORMATION_MESSAGE);
						editCustomerInvoiceComponentsJPanel.setVisible(false);
						editInvoiceComponentsJPanel.setVisible(false);
						editInvoiceProductsComponentsJPanel.setVisible(false);
						editCustIdComboInv.setSelectedIndex(0);
					}
					customerInvoiceJTextArea.setCaretPosition(0);
				}
			}
						
		//handler for save invoice button
		
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
		
		// Method to get all the product codes from the ArrayList
		public ArrayList<String> findProductCodes(){
			ArrayList<String> returnCodeNames = new ArrayList<String>();
			
			for(Product p: products){
				returnCodeNames.add(p.getProductCode());
			}
			
			return returnCodeNames;
			
		}
		public boolean checkCustomerDuplicate(ArrayList<Customer> customers, int id){
			boolean passed = true;
			for(Customer customer: customers){
				if(customer.getCustId() == id){
					 passed = false;
				}
			}
			return passed;
		}
		public boolean checkSupplierDuplicate(ArrayList<Supplier> suppliers, int id){
			boolean passed = true;
			for(Supplier supplier: suppliers){
				if(supplier.getId() == id){
					 passed = false;
				}
			}
			return passed;
		}
		public boolean checkEmployeeDuplicate(ArrayList<Employee> employees, int id){
			boolean passed = true;
			for(Employee employee: employees){
				if(employee.getEmployeeId() == id){
					 passed = false;
				}
			}
			return passed;
		}
		//dropdown functions
		public void empIDPopulate(JComboBox<String> combo){
			combo.addItem("Select");
			for(Employee employee: employees){
				String str = Integer.toString(employee.getEmployeeId());
				combo.addItem(str);
			}
		}
		public void empNamePopulate(JComboBox<String> combo){
			empNameCombo.addItem("Select");
			for(Employee employee: employees){
				String str = employee.getEmployeeName();
				combo.addItem(str);
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
		
		public void populateIEGraph(){
			Invoice inv = new Invoice();
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
	        
	        line_chart_dataset.addValue(emp.monthlySalary(employees) + calculateOrderValue(orders, 0), "expenditure", "Jan");
	        line_chart_dataset.addValue(emp.monthlySalary(employees) + calculateOrderValue(orders, 1), "expenditure", "Feb");
	        line_chart_dataset.addValue(emp.monthlySalary(employees) + calculateOrderValue(orders, 2), "expenditure", "Mar");
	        line_chart_dataset.addValue(emp.monthlySalary(employees) + calculateOrderValue(orders, 3), "expenditure", "Apr");
	        line_chart_dataset.addValue(emp.monthlySalary(employees) + calculateOrderValue(orders, 4), "expenditure", "May");
	        line_chart_dataset.addValue(emp.monthlySalary(employees) + calculateOrderValue(orders, 5), "expenditure", "Jun");
	        line_chart_dataset.addValue(emp.monthlySalary(employees) + calculateOrderValue(orders, 6), "expenditure", "Jul");
	        line_chart_dataset.addValue(emp.monthlySalary(employees) + calculateOrderValue(orders, 7), "expenditure", "Aug");
	        line_chart_dataset.addValue(emp.monthlySalary(employees) + calculateOrderValue(orders, 8), "expenditure", "Sept");
	        line_chart_dataset.addValue(emp.monthlySalary(employees) + calculateOrderValue(orders, 9), "expenditure", "Oct");
	        line_chart_dataset.addValue(emp.monthlySalary(employees) + calculateOrderValue(orders, 10), "expenditure", "Nov");
	        line_chart_dataset.addValue(emp.monthlySalary(employees) + calculateOrderValue(orders, 11), "expenditure", "Dec");
		}		
		
		//handler for Profit and Loss table button
		//Method to get fill table
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
				if(s.equals("Select")){
					deleteRows();
					tableModel.addRow(new String[]{"", "", ""});
					pLTotal.setText("0.00");
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
		
		//Method for setting the Nimbus feel and look
		public final static void setDesign() {
			try{
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			}catch(Exception e){
				System.out.println("Prob with setDesign()");
			}
			
		}
		
		
		//MEthod to initialize Panes etc
		public void initialize(){
			
			//Main Frame
			mainJFrame = new JFrame();
			mainJTabbedPane = new JTabbedPane();
			scrollPane = new JScrollPane();
			loginJPanel = new JPanel();
			custJTabbedPane = new JTabbedPane();
			supplyJTabbedPane = new JTabbedPane();
			prodJTabbedPane = new JTabbedPane();
			invJTabbedPane = new JTabbedPane();
			orderJTabbedPane = new JTabbedPane();
			accessJTabbedPane = new JTabbedPane();
			proflossJTabbedPane = new JTabbedPane();
			
			//Main Panels
			addCustJPanel = new JPanel();
			viewCustJPanel = new JPanel();
			editCustJPanel = new JPanel();
			
			addSupplyJPanel = new JPanel();
			viewSupplyJPanel = new JPanel();
			editSupplyJPanel = new JPanel();
			addProductJPanel = new JPanel();
			editProductJPanel = new JPanel();
			createInvJPanel = new JPanel();
			viewInvJPanel = new JPanel();
			editInvJPanel = new JPanel();
			createOrderPanel = new JPanel();
			viewOrderJPanel = new JPanel();
			editOrderJPanel = new JPanel();
			employeeJPanel = new JPanel();
			viewEmployeeJPanel = new JPanel();
			editEmployeeJPanel = new JPanel();
			proflossJPanel = new JPanel();
			graphJPanel = new JPanel();
			
			//login components
			loginComponentsJPanel = new JPanel();
			loginTF = new JTextField();
			passwordTF = new JPasswordField();
			loginBut = new JButton();
			
			//logout components
			logoutComponentsJPanel = new JPanel();
			logoutBut = new JButton();
			
			addMoreBtn = new JButton("Add Product To Invoice");
			finishBtn = new JButton("Confirm Invoice");
			resetBtn = new JButton("Reset Fields");
			payAllInvoicesJButton = new JButton("Pay All Invoices");
			editInvoiceJButton = new JButton("Pay Invoice by Id");
			editCustomerInvoiceJButton = new JButton("Pay Invoices by Customer");
			payInvoiceJButton = new JButton("Pay Invoice");
			payInvoiceJButton = new JButton("Pay Invoice");
			createOrderAddProductButton =  new JButton("Add Product to Order");
			createOrderConfirmOrderButton = new JButton("Confirm Order");
			viewOrderViewAllOrdersButton = new JButton("View All");
			viewOrderViewReceivedButton = new JButton("View Received Orders");
			viewOrderViewUnreceivedButton = new JButton("View Unreceived Order");
			viewOrderClearPanelButton = new JButton("Clear Panel");
			//Order
			createOrderOrderIdTextField = new JTextField();
			createOrderSupplierIdTextField = new JTextField();
			createOrderProductIdTextField = new JTextField();
			createOrderQuantityTextField = new JTextField();
			createOrderScrollPaneTextArea = new JTextArea();
			viewOrderOrderIdLabel = new JLabel("Order ID: ");
			viewOrderOrderIdButton = new JButton("Search ID");
			viewOrderSupplierIdButton = new JButton("Search for Supplier");
			viewOrderTitleButton = new JButton("Search for Title");
			viewOrderAuthorButton = new JButton("Search for Author");
			receiveAllOrdersJButton = new JButton("Receive All Orders");
			editOrderJButton = new JButton("Find Order by Id");
			editOrderSupplierJButton = new JButton("Find Order by Supplier");
			receiveOrderJButton = new JButton("Receive Order");
			saveOrderJButton = new JButton("Update Order");
			deleteOrderJButton = new JButton("Delete Order");
			editDetailsJButton = new JButton("Select product to edit");
			updateProductJButton = new JButton("Update details");
			deleteStockLineJButton = new JButton("Delete stock line");
			lineChartJButton = new JButton();
			pLViewButton = new JButton("View");
			productJButton = new JButton("Create New Product");
			custJButton  = new JButton("Create New Customer");
			viewCustJButton = new JButton("View By ID");
			viewCustNameJButton = new JButton("View By Name");
			viewAllCustJButton = new JButton("View All Customers");
			findCustById = new JButton("Find Customer");
			updateCustJButton = new JButton("Update Customer Details");
			deleteCustJButton = new JButton("Delete Customer");
			//Customer Components
			custIdJLabel = new JLabel("Enter Customer ID");
			custIdJTextField = new JTextField();
			custNameJLabel = new JLabel("Enter Customer Name");
			custNameJTextField = new JTextField();
			custAddressJLabel = new JLabel("Enter Customer Address");
			custAddressJTextField = new JTextField();
			custEmailJLabel = new JLabel("Enter Customer Email");
			custEmailJTextField = new JTextField();
			custPhoneJLabel = new JLabel("Enter Customer Phone");
			custPhoneJTextField = new JTextField();	
			custJTextArea = new JTextArea(10, 65);
			editCustIdCombo = new JComboBox<String>();
			editCustNameJLabel = new JLabel(" Customer Name");
			editCustAddressJLabel = new JLabel(" Customer Address");
			editCustEmailJLabel = new JLabel(" Customer Email");
			editCustPhoneJLabel = new JLabel(" Customer Telephone");
			editCustName = new JTextField();
			editCustAddress = new JTextField();
			editCustEmail = new JTextField();
			editCustPhone = new JTextField();
			viewCustById = new JLabel(" Find Customer By ID: ");
			custIdCombo = new JComboBox<String>();
			viewCustByName = new JLabel(" Find Customer By Name");
			custNameCombo = new JComboBox<String>();
			
			//Supplier Components
			supplierIdJLabel = new JLabel("Supplier ID");
			supplierIdJTextField = new JTextField();
			supplierNameJLabel = new JLabel("Supplier Name");
			supplierNameJTextField = new JTextField();
			supplierAddressJLabel = new JLabel("Supplier Address");
			supplierAddressJTextField = new JTextField();
			supplierEmailJLabel= new JLabel("Supplier Email");
			supplierEmailJTextField = new JTextField();
			supplierPhoneJLabel = new JLabel(" Supplier Phone Number");
			supplierPhoneJTextField = new JTextField();
			supplierJButton = new JButton("Create New Supplier");
			viewSupplyJLabel = new JLabel(" Search by Supplier ID");
			suppIdCombo = new JComboBox<String>();
			viewSupplyJButton = new JButton(" View Supplier By ID");
			viewSupplyNameJLabel = new JLabel(" Search by Supplier Name: ");
			suppNameCombo = new JComboBox<String>();
			supplierJTextArea = new JTextArea(10, 65);
			viewSupplyNameJButton = new JButton("View Supplier By Name");
			allSupplyJButton = new JButton("View All Suppliers");
			editSuppIdCombo = new JComboBox<String>();
			editSupplierJButton = new JButton("Find Supplier");
			editSuppNameJLabel = new JLabel(" Supplier Name");
			editSuppAddressJLabel = new JLabel(" Supplier Address");
			editSuppEmailJLabel = new JLabel(" Supplier Email");
			editSuppPhoneJLabel = new JLabel(" Supplier Telephone");
			editDeliveryJLabel = new JLabel(" Edit Delivery Period");
			editSupplierName = new JTextField();
			editSupplierAddress = new JTextField();
			editSupplierEmail = new JTextField();
			editSupplierPhone = new JTextField();
			editSupplierDelivery = new JTextField();
			saveSupplierJButton = new JButton("Update Supplier");
			deleteSupplierJButton = new JButton("Delete Supplier");
			//Employee Components
			employeeId = new JLabel("Employee ID ");
			employeeIdField = new JTextField();
			employeeName = new JLabel("Employee Name ");
			employeeNameField = new JTextField();
			employeeAcess = new JLabel("Access Level ");
			employeeAcessField = new JComboBox<Integer>();
			employeeSalary = new JLabel("Employee Salary");
			employeeSalaryField = new JTextField();
			employeePassword = new JLabel("Employee Password");
			employeePassField = new JTextField();
			employeeJButton = new JButton("Create New Employee");
			viewEmpId = new JLabel("View By ID");
			empIdCombo = new JComboBox<String>();
			viewEmpIdButton = new JButton("Search Employees");
			viewEmpName = new JLabel("View By Name");
			empNameCombo = new JComboBox<String>();
			viewEmpNameButton = new JButton("Search Employees");
			viewEmpAll = new JLabel("View All Employees");
			viewEmpAllButton = new JButton("View All");
			empJTextArea = new JTextArea(10, 65);
			viewEmpIdCombo = new JComboBox<String>();
			editById = new JButton("Find Employee Details");
			editEmpName = new JLabel(" Employee Name");
			editEmpNameField = new JTextField();
			editEmpAccess = new JLabel(" Employee Access Level");
			editEmpAccessField = new JTextField();
			editEmpSalary = new JLabel(" Employee Salary");
			editEmpSalaryField = new JTextField();
			editEmpPassword = new JLabel(" Employee Password");
			editEmpPasswordField = new JTextField();
			updateEmployee = new JButton("Update Employee");
			deleteEmployee = new JButton("Delete Employee");
			
			//Product Components
			prodTitle = new JLabel("Book Title");
			titleJTextField = new JTextField();
			prodAuthor = new JLabel("Author");
			authorJTextField = new JTextField();
			prodCode = new JLabel("Product ID ");
			codeJTextField = new JTextField();
			prodRetail = new JLabel("Retail Price");
			retailJTextField = new JTextField();
			prodCost = new JLabel("Cost Price");
			costJTextField = new JTextField();
			prodTotalStock = new JLabel("Current Stock");
			tStockJTextField = new JTextField();
			prodMaxStock = new JLabel("Maximum Stock");
			maxJTextField = new JTextField();
			prodMinStock = new JLabel("Minimum Stock");
			minJTextField = new JTextField();
			prodSupplierId = new JLabel("Supplier Id");
			prodSupplierIdJTextField = new JTextField();
			productJButton = new JButton("Create New Product");
			
			under5Radio = new JRadioButton("under 4.99");
			fiveTo10Radio = new JRadioButton("5 - 9.99");
			tenTo20Radio = new JRadioButton("10 - 20");
			over20Radio = new JRadioButton("20 plus");
			under50Radio = new JRadioButton("under 50");
			fiftyTo100Radio = new JRadioButton("50 - 100");
			hundredTo200Radio = new JRadioButton("100 - 200");
			over200Radio = new JRadioButton("200 plus");

			//edit product components
			editProdTitle = new JLabel("Book Title");
			editTitleJTextField = new JTextField();
			editProdAuthor = new JLabel("Author");
			editAuthorJTextField = new JTextField();
			editProdCode = new JLabel("Product ID");
			editCodeJTextField = new JTextField();
			editProdRetail = new JLabel("Retail Price");
			editRetailJTextField = new JTextField();
			editProdCost = new JLabel("Cost Price");
			editCostJTextField = new JTextField();
			editProdTotalStock = new JLabel("Current Stock");
			editStockJTextField = new JTextField();
			editProdMaxStock = new JLabel("Maximum Stock");
			editMaxJTextField = new JTextField();
			editProdMinStock = new JLabel("Minimum Stock");
			editMinJTextField = new JTextField();
			editProdSupplierId = new JLabel("Supplier Id");
			editProdSupplierIdJTextField = new JTextField();
			
			// View Product Components
			product = new Product();
			viewProductDetailsPanel= new JPanel();
			viewProductDetails= new JPanel();
			priceRange = new ButtonGroup();
			quantity = new ButtonGroup();
			
			existingProductTitle = new Vector<>();
			listofProductTitle = new DefaultComboBoxModel<>(existingProductTitle);
			
			existingProductAuthor = new Vector<>();
			listOfProductAuthor = new DefaultComboBoxModel<>(existingProductAuthor);
			
			existingEditProdId = new Vector<>();
			listToEditProdIds = new DefaultComboBoxModel<>(existingEditProdId);

			//Edit Invoice Components 
			findInvoiceComponentsJPanel = new JPanel();
			editInvoiceComponentsJPanel = new JPanel();
			editCustomerInvoiceComponentsJPanel = new JPanel();
			editInvoiceProductsComponentsJPanel = new JPanel();
			editInvoiceByCustComponents = new JPanel();
			editExistingInvoiceNums = new Vector<>();
			editListOfInvoices = new DefaultComboBoxModel<>(editExistingInvoiceNums); //create the combo box
			editCustIdComboInv = new JComboBox<String>();
			customerInvoiceJTextArea = new JTextArea(10,20);
			productInvoiceJTextArea = new JTextArea(10,40);
			allInvoicesTotalJTextField = new JTextField("Total Owed");
			editOrderId = new JTextField("Edit Order Id:");
			editOrderSupplier = new JTextField("Edit Order Customer");
			editOrderReceivedStatus = new JTextField("");	
			editOrderAmount = new JTextField("Edit Order Amount");
			editInvoiceEmployee = new JTextField("Edit Invoice Employee");
			editInvoiceCustomer = new JTextField("Edit Invoice Customer");
			editPayStatus = new JTextField("");	
			editInvoiceAmount = new JTextField("Edit Invoice Amount");
			
			//Marc: View Customer Invoice Panel and Components
			viewCustomerPanel = new JPanel();	
			existingInvoiceNums = new Vector<>();
			listOfInvoices = new DefaultComboBoxModel<>(existingInvoiceNums); //create the combo box
			existingCustomerId = new Vector<>();
			listOfCustomers = new DefaultComboBoxModel<>(existingCustomerId); //create the combo box
			empIdVector = new Vector<>();
			listOfEmpIds = new DefaultComboBoxModel<>(empIdVector); //create the combo box
			cusIdVector = new Vector<>();
			listOfCusIds = new DefaultComboBoxModel<>(cusIdVector); //create the combo box
			prodIdVector = new Vector<>();
			listOfProdIds = new DefaultComboBoxModel<>(prodIdVector); //create the combo box
			//Marc: Create a new Invoice Panel
			createNewInvoicePanel = new JPanel();
			addMoreArrayList = new ArrayList<InvoiceProduct>();
			textAreaMarc = new JTextArea();
			leftPanel = new JPanel();
			rightPanel = new JPanel();
			invIdLbl = new JLabel("Invoice Id: ");
			employLbl = new JLabel("Employee ID: ");
			custId = new JLabel("Customer ID: ");
			prodId = new JLabel("Product ID: ");
			quantitylbl = new JLabel("Quantity: ");
			addMoreProducts = new ArrayList<OrderProduct>();
			createNewOrderLeftPanel = new JPanel();
			createNewOrderRightPanel = new JPanel();
			createOrderOrderIdLabel = new JLabel("Order ID: ");
			createOrderSupplierIdLabel = new JLabel("Supplier ID: ");
			createOrderProductCodeLabel = new JLabel("Product ID: ");
			createOrderQuantityLabel = new JLabel("Quantity: ");
			//viewOrder Panel components
			viewSupplierPanel = new JPanel();
			existingOrderIds = new Vector<>();
			listOfOrders = new DefaultComboBoxModel<>(existingOrderIds); //create the combo box
			existingSupplierIds = new Vector<>();
			listOfSuppliers = new DefaultComboBoxModel<>(existingSupplierIds); //create the combo box
			existingTitles = new Vector<>();
			listOfTitles = new DefaultComboBoxModel<>(existingTitles); //create the combo box
			viewOrderOrderIdLabel = new JLabel("Order ID: ");
			viewOrderSupplierIdLabel = new JLabel("Supplier ID: ");
			viewOrderTitleLabel = new JLabel("Title: ");
			viewOrderAuthorLabel = new JLabel("Author: ");
			
			//Edit Order Components
			findOrderComponentsJPanel = new JPanel();
			editOrderComponentsJPanel = new JPanel();
			editSupplierOrderComponentsJPanel  = new JPanel();
			saveOrderComponentsJPanel  = new JPanel();
			editOrderProductsComponentsJPanel  = new JPanel();
			editOrderBySupplierComponentsJPanel = new JPanel();
			supplierOrderJTextArea = new JTextArea(10,20);
			productOrderJTextArea = new JTextArea(10,40);
			allOrdersTotalJTextField = new JTextField("Total Owed");
	
			editOrderId = new JTextField("Edit Order Id:");
			editOrderSupplier= new JTextField("Edit Order Customer");
			editOrderReceivedStatus = new JTextField("");
			
			//P&L JTable Tab
			pLComponentsJPanel = new JPanel();
			pLJTable = new JTable(tableModel);
			pLJScrollPane = new JScrollPane(pLJTable);
			pLTotal = new JTextField();
			months = new Vector<>();
			listOfMonths = new DefaultComboBoxModel<>(months); //create the combo box
			
		
		}
		public double calculateOrderValue(ArrayList<Order> orders, int month){
			double total = 0.00;
			for(Order order: orders){
				if(order.getOrderDate().getMonth() == month){
					ArrayList<OrderProduct> prods = order.getListOfOrderProducts();
					for(OrderProduct product: prods){
						 total = total + product.getProduct().getCostPrice() * product.getQuantity();
					}
				}
			}
			return total;
		}

}//End class
