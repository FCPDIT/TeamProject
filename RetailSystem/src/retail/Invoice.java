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
	private Date invoiceDate;
	private boolean paid = false;
	private double totalInvoicePrice;
	

	public Invoice(int id, Employee employee, Customer customer, Product product, int quantity) {
		this.id= id;
		this.product = product;
		this.customer = customer;
		this.employee = employee;
		this.quantity = quantity;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		invoiceDate = new Date();
		totalInvoicePrice = product.getRetailPrice()*quantity;
		product.setCurrentStock(product.getCurrentStock()-quantity); 	// Stock check must be added in driver class
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


	public Date getInvoiceDate() {
		return invoiceDate;
	}


	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}


	public int getId() {
		return id;
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
	
	//View All
	public String viewAllInvoices(ArrayList<Invoice> invoices){
		String list = "";
		for(Invoice v : invoices){
			list+="Employee Name: " + employee.getEmployeeName() +
					"\nCustomer Name: " + customer.getCustName() +
					"\nProduct Code: " + product.getProductCode()+
					"\nInvoice Total: " + totalInvoicePrice + 
					"\nDate: " + invoiceDate + "\n\n";
		}
		
		return list;
	}

}

