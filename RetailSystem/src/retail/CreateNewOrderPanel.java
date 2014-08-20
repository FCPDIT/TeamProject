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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreateNewOrderPanel extends JPanel{

	Order baseOrder;
	ArrayList<Order> orders = new ArrayList<Order>();
	ArrayList<Product> products = new ArrayList<Product>();
	ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	
	
	//variables
	//Panels
	private JPanel createNewOrderLeftPanel = new JPanel();
	private JPanel createNewOrderRightPanel = new JPanel();
	
	//Labels
	private JLabel orderIdLabel = new JLabel("Order ID: ");
	private JLabel supplierIdLabel = new JLabel("Supplier ID: ");
	private JLabel productCodeLabel = new JLabel("Product ID: ");
	private JLabel quantityLabel = new JLabel("Quantity: ");
	
	//JText Fields
	private JTextField orderIdTextField = new JTextField(10);
	private JTextField supplierIdTextField = new JTextField(10);
	private JTextField productCodeTextField = new JTextField(10);
	private JTextField quantityTextField = new JTextField(10);
	
	private JButton addProductButton =  new JButton("Add Product to Order");
	private JButton confirmOrderButton = new JButton("Confirm Order");
	
	//Text area
	private JTextArea textArea = new JTextArea();
	
	//Constructor
	public CreateNewOrderPanel(){
		// Setting the size of the main panel
		Dimension size = getPreferredSize();
		size.width = 500;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Invoice details"));
		
		//Left Panel Components
		createNewOrderLeftPanel.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.insets = new Insets(5,5,5,5);
		//=====
		gc.gridx = 0;
		gc.gridy = 0;
		createNewOrderLeftPanel.add(orderIdLabel,gc);
		gc.gridx = 1;
		gc.gridy = 0;
		createNewOrderLeftPanel.add(orderIdTextField,gc);
		//=====
		gc.gridx = 0;
		gc.gridy = 1;
		createNewOrderLeftPanel.add(supplierIdLabel,gc);
		gc.gridx = 1;
		gc.gridy = 1;
		createNewOrderLeftPanel.add(supplierIdTextField,gc);
		//=====
		gc.gridx = 0;
		gc.gridy = 2;
		createNewOrderLeftPanel.add(productCodeLabel,gc);
		gc.gridx = 1;
		gc.gridy = 2;
		createNewOrderLeftPanel.add(productCodeTextField,gc);
		//=====
		gc.gridx = 0;
		gc.gridy = 3;
		createNewOrderLeftPanel.add(quantityLabel,gc);
		gc.gridx = 1;
		gc.gridy = 3;
		createNewOrderLeftPanel.add(quantityTextField,gc);
		//=====
		gc.gridx = 0;
		gc.gridy = 4;
		createNewOrderLeftPanel.add(addProductButton,gc);
		gc.gridx = 1;
		gc.gridy = 4;
		gc.weighty = 10;
		createNewOrderLeftPanel.add(confirmOrderButton,gc);
		
		//TextPane
		textArea = new JTextArea(20,20); //height - width
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 1.0;
        gc.weighty = 1.0;
        gc.gridx = 3;
		
        createNewOrderRightPanel.add(scrollPane, gc);
		
		
		//Right Panel
		//Main Panel Add
		add(createNewOrderLeftPanel);
		add(createNewOrderRightPanel);
		
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
	}	
}
