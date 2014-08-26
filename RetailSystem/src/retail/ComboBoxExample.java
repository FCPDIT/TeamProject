package retail;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ComboBoxExample extends JFrame{
	
	//variables
	private JPanel panel = new JPanel();
	private Container container = getContentPane();
	private JTextField input = new JTextField(10);
	private JButton button = new JButton("Add");
	private JButton displayBtn = new JButton("Display");
	//Components for the Combo Box
	private Vector<String> listOfLetters  = new Vector<>();
	private DefaultComboBoxModel<String> list = new DefaultComboBoxModel<>(listOfLetters); //create the combo box
	private JComboBox<String> comboBox = new JComboBox<String>(list);

	public ComboBoxExample() {
		//Frame
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Set ArrayList
		listOfLetters.add("Happy");
		listOfLetters.add("Sad");
		listOfLetters.add("Angry");
		listOfLetters.add("Tired");
		
		//Adding Components
		panel.add(comboBox);
		panel.add(input);
		panel.add(button);
		panel.add(displayBtn);
		container.add(panel);
		
		//Dropdown list
		list.setSelectedItem(listOfLetters.get(0));
		
		//button click
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputFromTestField = input.getText();
				list.addElement(inputFromTestField);
				input.setText("");
				
			}
		});
		
		displayBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = (String)comboBox.getSelectedItem(); //how to actually get the value from a Combo box
				JOptionPane.showMessageDialog(null, input);
				
			}
		});
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ComboBoxExample();

	}

}
