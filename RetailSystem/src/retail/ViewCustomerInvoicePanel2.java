package retail;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;


public class ViewCustomerInvoicePanel2 extends JPanel{
	
	//variables
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
	
	//Buttons for left Panel
	private JButton confirmBtn = new JButton("Confirm");
	private JButton addBtn = new JButton("Add");
	
	
	//Text area for right panel
	private JTextArea textarea = new JTextArea();
	
	//Constructor
	public ViewCustomerInvoicePanel2() {
		// Setting the size of the main panel
		Dimension size = getPreferredSize();
		size.width = 500;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Invoice details"));
		
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
		addBtn.setPreferredSize(new Dimension(115, 30)); //width/height
		leftPanel.add(addBtn,gc);
		//=====
		gc.gridx = 1;
		gc.gridy = 6;
		confirmBtn.setPreferredSize(new Dimension(115, 30));
		leftPanel.add(confirmBtn,gc);
		
		
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

}
