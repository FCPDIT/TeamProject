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

public class ViewOrderPanel extends JPanel{
	
	private Order order = new Order();
	private JTextArea textArea;
	private ArrayList<Order> orders = new ArrayList<Order>();
	private JTextField orderIdTextField;
	private JTextField supplierIdTextField;
	
	public ViewOrderPanel(){
		
		Order order1 = new Order(1, 1, new Product("a", "b", "d", 50.00, 20.00, 10, 20, 2, new Supplier(1,"f","g")), 1);
		Order order2 = new Order(2, 1, new Product("x", "x", "x", 55.00, 25.00, 20, 30, 3, new Supplier(2,"h","h")), 1);
		Order order3 = new Order(3, 1, new Product("y", "y", "y", 60.00, 30.00, 30, 40, 4, new Supplier(3,"m","m")), 1);
		
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		
		Dimension size = getPreferredSize();
		size.width = 200;
		setPreferredSize(size);
		setBorder(BorderFactory.createTitledBorder("Order details"));
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.insets = new Insets(5,5,5,5);
		
		textArea = new JTextArea(10,20); //height - width
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
		
		JLabel orderIdLabel = new JLabel("Order ID: "); 
		gc.gridx = 0;
		gc.gridy = 1;
		add(orderIdLabel, gc);
		orderIdTextField = new JTextField(10); 
		gc.gridx = 1;
		gc.gridy = 1;
		add(orderIdTextField, gc);
		JButton orderIdButton = new JButton("Find order with this ID");	
		gc.gridx = 2;
		gc.gridy = 1;
		add(orderIdButton, gc);
		
		orderIdButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = orderIdTextField.getText();
				if(input.trim().equals("") || input.matches(".*\\D.*")){
					textArea.setText("Please enter a valid number");
					orderIdTextField.setText("");
					supplierIdTextField.setText("");
				}else{
					int num = Integer.parseInt(input);
					textArea.setText(order.viewByOrderId(orders, num)); 
					orderIdTextField.setText("");
					supplierIdTextField.setText("");
				}
			}
		});
		
		JLabel supplierIdLabel = new JLabel("Supplier ID: ");
		gc.gridx = 0;
		gc.gridy = 2;
		add(supplierIdLabel,gc);
		supplierIdTextField = new JTextField(10);
		gc.gridx = 1;
		gc.gridy = 2;
		add(supplierIdTextField,gc);
		JButton supplierIdButton = new JButton("Find order with this Supplier");
		gc.gridx = 2;
		gc.gridy = 2;
		add(supplierIdButton,gc);
		supplierIdButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = supplierIdTextField.getText();
				if(input.trim().equals("") || input.matches(".*\\D.*")){ 
					textArea.setText("Please enter a valid number");
					supplierIdTextField.setText("");
					orderIdTextField.setText("");
				}else{
					int num = Integer.parseInt(input);
					textArea.setText(order.viewOrderBySupplier(orders, num));	
					supplierIdTextField.setText("");
					orderIdTextField.setText("");
				}
			}
		});
		
		JButton viewAllButton = new JButton("View All");
		gc.gridx = 0;
		gc.gridy = 3;
		add(viewAllButton, gc);
		viewAllButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText(order.viewAllOrders(orders));	
			}
		});
		
		JButton viewDeliveredButton = new JButton("View Delivered Orders");
		gc.gridx = 1;
		gc.gridy = 3;
		add(viewDeliveredButton, gc);
		viewDeliveredButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText(order.viewDeliveredOrders(orders));	
			}
		});
		
		JButton viewUndeliveredButton = new JButton("View Undelivered Order");
		viewUndeliveredButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText(order.viewUndeliveredOrders(orders));	
			}
		});
		gc.gridx = 2;
		gc.gridy = 3;
		add(viewUndeliveredButton, gc);
	}
}
