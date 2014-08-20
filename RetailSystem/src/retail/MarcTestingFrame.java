package retail;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MarcTestingFrame extends JFrame{
	
	//Variables
	private JPanel panel = new ViewCustomerInvoicePanel();
	//private JPanel invoicePanel = new CreateANewInvoicePanel();
	//private JPanel splitPanel = new ViewCustomerInvoicePanel2();
	private Container container;
	
	//Constructor
	public MarcTestingFrame(){
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();
		//container.add(panel);
		container.add(panel);
		setVisible(true);
	}
	
	public static void main(String [] args){
		//new MarcTestingFrame();
		new RetailGUI();
	}

	
}
