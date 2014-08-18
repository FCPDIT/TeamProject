package retail;

//NOT COMPLETE

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateNewOrderPanel extends JPanel{

	private JLabel orderIdLabel, supplierIdLabel, productCodeLabel, quantityLabel;
	
	private JTextField orderIdTextField, supplierIdTextField, productCodeTextField, quantityTextField;
	
	private JButton createOrderButton, addProductButton;
	
	ArrayList<Order> orders = new ArrayList<Order>();
	ArrayList<Product> productss = new ArrayList<Product>();
	ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	
	public CreateNewOrderPanel(){
		
		Dimension size = getPreferredSize();
		size.width = 200;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Create a new order"));
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.insets = new Insets(3, 3, 3, 3);
		
		orderIdLabel = new JLabel("Order ID: ");
		gc.gridx = 0;
		gc.gridy = 0;
		add(orderIdLabel, gc);
		orderIdTextField = new JTextField(10);
		gc.gridx = 1;
		gc.gridy = 0;
		add(orderIdTextField, gc);
		// ====
		supplierIdLabel = new JLabel("Supplier ID: ");
		gc.gridx = 0;
		gc.gridy = 1;
		add(supplierIdLabel, gc);
		supplierIdTextField = new JTextField(10);
		gc.gridx = 1;
		gc.gridy = 1;
		add(supplierIdTextField, gc);
		// ====
		productCodeLabel = new JLabel("Product Code: ");
		gc.gridx = 0;
		gc.gridy = 2;
		add(productCodeLabel, gc);
		productCodeTextField = new JTextField(10);
		gc.gridx = 1;
		gc.gridy = 2;
		add(productCodeTextField, gc);
		// ====
		quantityLabel = new JLabel("Quantity: ");
		gc.gridx = 0;
		gc.gridy = 3;
		add(quantityLabel, gc);
		quantityTextField = new JTextField(10);
		gc.gridx = 1;
		gc.gridy = 3;
		add(quantityTextField, gc);
		// ====
		createOrderButton = new JButton("Create Order");
		gc.gridx = 1;
		gc.gridy = 5;
		add(createOrderButton, gc);
		createOrderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String orderIdString = orderIdTextField.getText();
				String supplierIdString = supplierIdLabel.getText();
				String quantityString = quantityTextField.getText();
				
				if((orderIdString.trim().equals("") || (orderIdString.trim().equals(".*\\D.*")) || 
						(supplierIdString.trim().equals("") || (supplierIdString.trim().equals(".*\\D.*")) ||
								(quantityString.trim().equals("") || (quantityString.trim().equals(".*\\D.*"))))))
				{
					JOptionPane.showMessageDialog(null, "Please ensure all text fields have been filled!");
				}
				else{
					//check if the product exists, if it does, add it to the order, else
					//JOptionPane.showMessageDialog(null, "Product with that code does not exist!");
					//check if the supplier exists
					//if not, JOptionPane.showMessageDialog(null, "Supplier with that ID does not exist!");
					//if order already exists, JOptionPane.showMessageDialog(null, "Order already exists!");
					//create Order and add it to the arraylist, wherever that may be
				}
				
			}
		});
	}	
}
