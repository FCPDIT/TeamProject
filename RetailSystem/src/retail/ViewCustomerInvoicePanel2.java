package retail;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class ViewCustomerInvoicePanel2 extends JPanel{
	//MUST BE DELETED
	private ArrayList<Employee> employees = new ArrayList<>();
	private ArrayList<Customer> customers = new ArrayList<>();
	private ArrayList<Product> products = new ArrayList<>();
	private ArrayList<Invoice> invoices = new ArrayList<>();
	//================
	
	//variables
	private Invoice invoice = new Invoice();
	private ArrayList<InvoiceProduct> addMoreArrayList = new ArrayList<InvoiceProduct>();
	private String message = "";
	private String outputMessage="";
	//Panels
	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel();
	
	//Labels for left panel
	private JLabel invIdLbl = new JLabel("Invoice Id: ");
	private JLabel employLbl = new JLabel("Employee ID: ");
	private JLabel custId = new JLabel("Customer ID: ");
	private JLabel prodId = new JLabel("Product ID: ");
	private JLabel quantity = new JLabel("Quantity: ");
	
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
	
	
	//Text area for right panel
	private JTextArea textarea = new JTextArea();
	
	//Constructor
	public ViewCustomerInvoicePanel2() {
		// Setting the size of the main panel
		Dimension size = getPreferredSize();
		size.width = 500;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Invoice details"));
		
		//============================================	
		//Below will be deleted
			employees.add(new Employee(1, "marc", 1, 50.00, 1234));
			customers.add(new Customer(2, "Paddy Power", "Dublin"));
			products.add(new Product("y", "y", "a", 60.00, 30.00, 30,40, 4, new Supplier(3, "m", "m")));
			products.add(new Product("y", "y", "s", 60.00, 30.00, 30,40, 4, new Supplier(3, "m", "m")));
			//Delete To here!!
		//============================================	

		//================================
		//Left Panel Components
		//================================
		leftPanel.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
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
		leftPanel.add(quantity,gc);
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
						message += "Product No: " + prod.getProduct().getProductCode() +"\nQuantity: " + prod.getQuantity() + "\n";
						}
						textarea.setText(message);
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
										textarea.setText(outputMessage);
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
				textarea.setText("");
				
			}
		});
	
		
		
		//================================
		//Right Panel : TextArea and Pane
		//================================
		textarea = new JTextArea(15,20); //height - width
		textarea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textarea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 1.0;
        gc.weighty = 1.0;
        gc.gridx = 3;
        rightPanel.add(scrollPane, gc);
		
		
		//Main Panel Add
		add(leftPanel);
		add(rightPanel);
	}
	
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

}
