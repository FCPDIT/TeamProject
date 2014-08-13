package retail;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Invoice {
	private int id;
	private Employee employee; // or maybe just an employeeId ??
	private Customer customer;
	private Product product;
	private int quantity;
	private String invoiceDate;
	private boolean paid = false;
	private double totalInvoicePrice;

	public Invoice() {
	} // used for testing only

	public Invoice(int id, Employee employee, Customer customer, Product product, int quantity) {
		this.id = id;
		this.product = product;
		this.customer = customer;
		this.employee = employee;
		this.quantity = quantity;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy"); //may want to review the dates set up!!
		invoiceDate = sdf.format(new Date());  
		totalInvoicePrice = product.getRetailPrice() * quantity;
		product.setCurrentStock(product.getCurrentStock() - quantity); // Stock check must be added in the driver class
																		
	}

	public double getTotalInvoicePrice() {
		return totalInvoicePrice;
	}

	public void setTotalInvoicePrice(double totalInvoicePrice) {
		this.totalInvoicePrice = totalInvoicePrice;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

/*	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}*/

	public int getId() {
		return id;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	//Simple print
	String printDetails(Invoice v) {
		if (v != null) {
			return "Invoice ID: " + v.getId() + 
					"\nProduct Id: " + v.getProduct().getProductCode() 
					+ "\nProduct Price: " +  String.format( "€%.2f", v.getProduct().getRetailPrice())
					+ "\nQuantity of Order " + v.getQuantity()
					+ "\nEmployee Name: " + v.getEmployee().getEmployeeName() 
					+ "\nEmployee Id: "   + v.getEmployee().getEmployeeId() 
					+ "\nCustomer Name: " + v.getCustomer().getCustName() 
					+ "\nCustomer Id: "   + v.getCustomer().getCustId() 
					+ "\nInvoice Total: " +  String.format( "€%.2f", v.getTotalInvoicePrice()) 
					+ "\nDate: " + v.getInvoiceDate() + "\n\n";
		} else {
			return "No details to print";
		}

	}
	
	// View All - Question what do we want to print for all Invoice Info
	public String viewAllInvoices(ArrayList<Invoice> invoices) {
		String list = "";
		for (Invoice v : invoices) {
			list += printDetails(v); // A Call to the method abve to print details
		}
		if (list.equals(""))
			return "No invoices on record";
		else
			return list;
	}
	
	//Method to Veiw the i=Invoice by ID
	public String viewInvoiceById(int id, ArrayList<Invoice> invoices){
	
		for(Invoice v : invoices){
			if(v.getId() == id){
				return printDetails(v);
			}
		}
	
			return "No record of Invoice No: " + id + " has been found";
	
		
		
	}
	
	//Method to view invoices by customer
	public String viewInvoiceByCustomer(int id, ArrayList<Invoice> invoices){
		String list = "";
		for(Invoice v : invoices){
			if(v.getCustomer().getCustId() == id){
				list+= printDetails(v);
			}
		}
		if (list.equals(""))
			return "No record of that Customer with Id No: " + id + " has been found";
		else
			return list;

	}
	
	//Method to view PAID invoices
	public String viewPaidInvoice(ArrayList<Invoice> invoices){
		String paid = "";
		for(Invoice v : invoices){
			if(v.isPaid()){
				paid+= printDetails(v);
			}
		}
		if(paid.equals("")){
		return "All Invoices are currently unpaid";
		}
		else{
			return paid;
		}
	}

	//Method to view PAID invoices
		public String viewUnPaidInvoice(ArrayList<Invoice> invoices){
			String unpaid = "";
			for(Invoice v : invoices){
				if(v.isPaid() == false){
					unpaid+= printDetails(v);
				}
			}
			if(unpaid.equals("")){
			return "All Invoices are currently unpaid";
			}
			else{
				return unpaid;
			}
		}


}






















