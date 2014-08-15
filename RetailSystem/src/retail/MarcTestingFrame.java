package retail;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MarcTestingFrame extends JFrame{
	
	//Variables
	private JPanel panel = new ViewCustomerInvoicePanel();
	private JPanel invoicePanel = new CreateANewInoicePanel();
	private Container container;
	
	//Constructor
	public MarcTestingFrame(){
		setSize(450, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();
		//container.add(panel);
		container.add(invoicePanel);
		setVisible(true);
	}
	
	public static void main(String [] args){
		//new MarcTestingFrame();
		new RetailGUI();
	}

	
}
