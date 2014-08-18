package retail;

import java.util.ArrayList;

public class InvoiceArrayListForTesting {

	private ArrayList<Invoice> invoices = new ArrayList<Invoice>();
	private Customer c1 = new Customer(1,"Johnnys","Dublin"); //This object was created for Testing the viewInvoiceByCustomer() method
	
	//Hard-coded arraylist of Invoices
	public void createList(){
		Invoice inv1 = new Invoice(1, new Employee(1,"marc",1,100.00,1234), c1, new Product("a", "b", "d", 50.00, 20.00, 10, 20, 2, new Supplier(1,"f","g")),10);
		Invoice inv2 = new Invoice(2, new Employee(2,"john",2,110.00,4567), new Customer(2,"Rudds","Galway"), new Product("x", "x", "x", 55.00, 25.00, 20, 30, 3, new Supplier(2,"h","h")),12);
		Invoice inv3 = new Invoice(3, new Employee(3,"mary",3,130.00,3987), new Customer(3,"Dennys","Cork"), new Product("y", "y", "y", 60.00, 30.00, 30, 40, 4, new Supplier(3,"m","m")),14);
		invoices.add(inv1);
		invoices.add(inv2);
		invoices.add(inv3);
	}
	
	
	
	public InvoiceArrayListForTesting() {
		createList();
		Invoice invoice = new Invoice();
		System.out.println(invoice.viewAllInvoices(invoices)); //testing ViewAll Method: Working
		//System.out.println(invoice.viewInvoiceById(1, invoices));//viewInvoiceById Method: Working
		
		//System.out.println(invoice.viewInvoiceByCustomer(3, invoices)); //testing viewInvoiceByCustomer Method: working
		//System.out.println(invoice.viewInvoiceByCustomer(2, invoices)); //testing viewInvoiceByCustomer Method: working
	
		//System.out.println(invoice.viewPaidInvoice(invoices)); //testing viewPaidInvoice: Working
		//System.out.println(invoice.viewUnPaidInvoice(invoices)); //testing viewUnPaidInvoice: Working
	}

	public static void main(String[] args) {
		new InvoiceArrayListForTesting();
		//new RetailGUI();
	}

}
