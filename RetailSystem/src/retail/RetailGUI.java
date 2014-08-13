package retail;

import java.awt.GridLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class RetailGUI extends JFrame{
	
	
	private JFrame mainJFrame = new JFrame();
	private GridLayout grid = new GridLayout(0, 2, 4, 4);
	private JTabbedPane mainJTabbedPane = new JTabbedPane();
	
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
	private JPanel viewProductJPanel = new JPanel();
	private JPanel editProductJPanel = new JPanel();
	
	private JPanel createInvJPanel = new JPanel();
	private JPanel viewInvJPanel = new JPanel();
	private JPanel editInvJPanel = new JPanel();
	
	private JPanel viewStockJPanel = new JPanel();
	private JPanel editStockJPanel = new JPanel();
	
	private JPanel accessJPanel = new JPanel();
	
	private JPanel proflossJPanel = new JPanel();
	
	private JLabel supplierIdJLabel = new JLabel("Customer ID: ");
	private JTextField supplierIdJTextField = new JTextField("Required Field");
	private JLabel supplierNameJLabel = new JLabel("Customer Name: ");
	private JTextField supplierNameJTextField = new JTextField("Required Field");
	private JLabel supplierAddressJLabel = new JLabel("Customer Address: ");
	private JTextField supplierAddressJTextField = new JTextField("Required Field");
	private JLabel supplierEmailJLabel= new JLabel("Customer Email: ");
	private JTextField supplierEmailJTextField = new JTextField("Optional");
	private JLabel supplierPhoneJLabel = new JLabel("Customer Phone Number: ");
	private JTextField supplierPhoneJTextField = new JTextField("Optional");
	private JButton supplierJButton = new JButton("Create New Supplier");
	
	private JLabel viewSupplyJLabel = new JLabel("Search by Supplier ID: ");
	private JTextField viewSupplyJTextField = new JTextField("Supplier Id");
	private JLabel viewSupplyNameJLabel = new JLabel("Search by Supplier Name: ");
	private JTextField viewSupplyNameJTextField = new JTextField("Supplier Name");
	private JTextArea supplierJTextArea = new JTextArea(20, 20);
	private JButton viewsupplyJButton = new JButton("View Supplier Details");
	private JButton allSupplyJButton = new JButton("View All Suppliers");
	
	
	public RetailGUI() {
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
		mainJTabbedPane.add("Stock Management", stockJTabbedPane);
		mainJTabbedPane.add("Manage Employee Access", accessJTabbedPane);
		mainJTabbedPane.add("Profit and Loss", proflossJTabbedPane);
		
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
		
		addSupplyJPanel.setLayout(grid);
		viewSupplyJPanel.setLayout(grid);
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
		viewSupplyJPanel.add(viewsupplyJButton);
		viewSupplyJPanel.add(allSupplyJButton);
		viewSupplyJPanel.add(supplierJTextArea);
		
	}

}
