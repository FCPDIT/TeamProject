package retail;

import java.util.ArrayList;

public class InvoiceArrayListForTesting {

	private ArrayList<Invoice> invoices = new ArrayList<Invoice>();
	private Customer c1 = new Customer(1,"Johnnys","Dublin"); //This object was created for Testing the viewInvoiceByCustomer() method
	private ArrayList<InvoiceProduct> listOfAllProducts = new ArrayList<InvoiceProduct>();
	//Hard-coded arraylist of Invoices
	public void createList(){
		Product p1 = new Product("x", "x", "x", 5.00, 25.00, 20, 30, 3, new Supplier(2,"h","h"));
		Product p2 = new Product("a", "b", "c", 5.00, 25.00, 20, 30, 3, new Supplier(2,"h","h"));
		InvoiceProduct inp = new InvoiceProduct(p1, 5);
		InvoiceProduct inp2 = new InvoiceProduct(p2, 5);
		listOfAllProducts.add(inp);
		listOfAllProducts.add(inp2);
		
		
		
		Invoice inv2 = new Invoice(2, new Employee(2,"john",2,110.00,4567), new Customer(2,"Rudds","Galway"),listOfAllProducts);
		Invoice inv3 = new Invoice(3, new Employee(3,"mary",3,130.00,3987), new Customer(3,"Dennys","Cork"), listOfAllProducts);
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
