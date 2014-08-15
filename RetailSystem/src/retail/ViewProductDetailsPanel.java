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

public class ViewProductDetailsPanel extends JPanel{

	//Variables
	private Product product = new Product();
	private JTextArea textarea;
	private ArrayList<Product> products = new ArrayList<Product>();
	private JTextField invTextField;
	private JTextField productTitleTextField;
	private JTextField productAuthorTextField;
	
	//Constructor
	public ViewProductDetailsPanel() {
		//Create an arraylist of product objects to test the GUI
		Product p1 = new Product("Game of Thrones", "George R.R Martin", "1", 9.99, 3.75,100,200,15,new Supplier(12345," Books Express "," 12 Main Street, Cork "," sales@bookexpress.com ", " 01685789 "));
		Product p2 = new Product("Not a Drill", "Lee Child", "2", 12.75, 4.95,50,200,10,new Supplier(12569," Book Warehouse "," 12 Whitehall industrial Park, Dublin "," sales@bookwarehouse.ie ", " 01488759 "));
		Product p3 = new Product("Harry Potter", "J.K Rowling", "3", 11.99, 2.95,25,100,50,new Supplier(12745," Books Direct "," 25 Dublin Road, Cavan "," sales@booksdirect.ie ", " 016885698 "));
		products.add(p1);
		products.add(p2);
		products.add(p3);
		
		//Setting the size of the panel
		Dimension size = getPreferredSize();
		size.width = 200;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Product details"));
		
		// Tell Java that we are using GridBoxLayout in the Panel
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.insets = new Insets(5,5,5,5); //sets the padding around each component
		

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
		
		// First Label and controls:	View Product by ID 
		JLabel productIdlbl = new JLabel("Enter Product ID: "); //Label
		gc.gridx = 0;
		gc.gridy = 1;
		add(productIdlbl,gc);
		invTextField = new JTextField(10); //Text Field
		gc.gridx = 1;
		gc.gridy = 1;
		add(invTextField,gc);
		JButton productButton = new JButton("Search Product ID");	//button
		gc.gridx = 2;
		gc.gridy = 1;
		add(productButton,gc);
		//Action listener For Button to view Invoice by Id
		productButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = invTextField.getText();
				// This method could be enhanced by adding in a check 
				//to ensure 9 digits have been entered to match an ISBN number.
				if(input.trim().equals("")){ 
					textarea.setText("Please enter a valid ID");		
					invTextField.setText("");
					productTitleTextField.setText("");
				}else{
					textarea.setText(product.viewProductById(input, products)); //viewInvoiceById() is in the Invoice Class
					invTextField.setText("");
					productTitleTextField.setText("");
				}
			}
		});
		
		//Second Label and controls: 	View Product by Title
		JLabel productTitlelbl = new JLabel("Product Title: ");
		gc.gridx = 0;
		gc.gridy = 2;
		add(productTitlelbl,gc);
		productTitleTextField = new JTextField(10);
		gc.gridx = 1;
		gc.gridy = 2;
		add(productTitleTextField,gc);
		JButton productTitleButton = new JButton("Search Product Title");
		gc.gridx = 2;
		gc.gridy = 2;
		add(productTitleButton,gc);
		productTitleButton.addActionListener(new ActionListener() {
			//Action listener For Button to view product by Title
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = productTitleTextField.getText();
				if(input.trim().equals("")){ //regEx
					textarea.setText("Please enter a valid Title");
					productTitleTextField.setText("");
					invTextField.setText("");
				}else{
					
					textarea.setText(product.viewProductByTitle(input, products));	//viewInvoiceByCustomer() is in the Invoice class
					productTitleTextField.setText("");
					invTextField.setText("");
				}
			}
		});
		
		
		//Third Label and controls: 	View Product by Author
				JLabel productAuthorlbl = new JLabel("Product Author: ");
				gc.gridx = 0;
				gc.gridy = 3;
				add(productAuthorlbl,gc);
				productAuthorTextField = new JTextField(10);
				gc.gridx = 1;
				gc.gridy = 3;
				add(productAuthorTextField,gc);
				JButton productAuthorBtn = new JButton("Search Author");
				gc.gridx = 2;
				gc.gridy = 3;
				add(productAuthorBtn,gc);
				productAuthorBtn.addActionListener(new ActionListener() {
					//Action listener For Button to view product by Title
					@Override
					public void actionPerformed(ActionEvent e) {
						String input = productAuthorTextField.getText();
						if(input.trim().equals("")){ 	// If no text is entered
							textarea.setText("Please enter text in Author Field");
							productAuthorTextField.setText("");
							invTextField.setText("");
						}else{							// Take in String and Search for it.
							//int num = Integer.parseInt(input);
							textarea.setText(product.viewProductByAuthor(input, products));	
							productAuthorTextField.setText("");
							invTextField.setText("");
						}
					}
				});

		//Button 4: 	View All
		//1. View all Button
		JButton viewAllProductsBtn = new JButton("View All");
		gc.gridx = 0;
		gc.gridy = 4;
		add(viewAllProductsBtn,gc);
		viewAllProductsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textarea.setText(product.viewAllProductDetails(products));	//viewAllProducts() is in the Product Class
			}
		});
	}
}



