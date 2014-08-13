package retail;

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
	private JFrame mainJFrame = new JFrame();
	private GridLayout grid = new GridLayout(0, 2, 4, 4);
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
	private JPanel viewProductJPanel = new JPanel();
	private JPanel editProductJPanel = new JPanel();
	
	private JPanel createInvJPanel = new JPanel();
	private JPanel viewInvJPanel = new JPanel();
	private JPanel editInvJPanel = new JPanel();
	
	private JPanel viewStockJPanel = new JPanel();
	private JPanel editStockJPanel = new JPanel();
	
	private JPanel accessJPanel = new JPanel();
	
	private JPanel proflossJPanel = new JPanel();
	
	//login components
	private JTextField loginTF = new JTextField();
	private JTextField passwordTF = new JTextField();
	private JButton loginBut = new JButton();
	
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
	private JButton viewSupplyJButton = new JButton("View Supplier Details");
	private JButton allSupplyJButton = new JButton("View All Suppliers");
	
	private JTextField editSupplierJTextField = new JTextField("Supplier Id");
	private JButton editSupplierJButton = new JButton("Find Supplier");
	private JTextField editSupplierId = new JTextField("Edit Supplier Id:");
	private JTextField editSupplierName = new JTextField("Edit Supplier Name");
	private JTextField editSupplierAddress = new JTextField("Edit Supplier Address");
	private JTextField editSupplierEmail = new JTextField("Edit Supplier Email");
	private JTextField editSupplierPhone = new JTextField("Edit Supplier Phone");
	private JTextField editSupplierDelivery = new JTextField("Edit Supplier Delivery");
	private JButton saveSupplierJButton = new JButton("Update Supplier");
	private JButton deleteSupplierJButton = new JButton("Delete Supplier");
	
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
		viewSupplyJPanel.add(scrollPane.add(supplierJTextArea));
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
					}
				}
			}
		});
		
		deleteSupplierJButton.addActionListener(new ActionListener(){
			// function to delete supplier by getting id from the supplier id label
			public void actionPerformed(ActionEvent e){
				for(Supplier supplier: suppliers){
					if(supplier.getId() == Integer.parseInt(editSupplierJTextField.getText())){
						suppliers.remove(supplier);
					}
				}
			}
		});
		
		/*
		 *LOGIN LOCK TABS - COMMENTED OUT FOR DEVELOPMENT EASE - PUT BACK IN WHEN RUNNING
		 * 
		//lock the tabs until login successful
		mainJTabbedPane.setEnabledAt(1, false);
		mainJTabbedPane.setEnabledAt(2, false);
		mainJTabbedPane.setEnabledAt(3, false);
		mainJTabbedPane.setEnabledAt(4, false);
		mainJTabbedPane.setEnabledAt(5, false);
		mainJTabbedPane.setEnabledAt(6, false);
		mainJTabbedPane.setEnabledAt(7, false);
		
		*/
		
		//add login components
		JPanel loginComponentsJPanel = new JPanel();
		loginComponentsJPanel.setLayout(new GridLayout(4,4));
		loginComponentsJPanel.add(new JLabel("Enter Employee ID"));
		loginComponentsJPanel.add(loginTF = new JTextField("Employee ID", 10));
		loginComponentsJPanel.add(new JLabel("Enter Employee ID"));
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
		int login = emp.verifyLogin(id, password);
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

}
