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

	// View All - Question what do we want to print for all Invoice Info
	public String viewAllInvoices(ArrayList<Invoice> invoices) {
		String list = "";
		for (Invoice v : invoices) {
			list += "Invoice ID: " + v.getId()
					+ "\nProduct Id: " + v.getProduct().getProductCode()
					+"\nProduct Price: " + v.getProduct().getRetailPrice()
					+ "\nEmployee Name: " + v.getEmployee().getEmployeeName()
					+ "\nEmployee Id: " + v.getEmployee().getEmployeeId()
					+ "\nCustomer Name: " + v.getCustomer().getCustName()
					+ "\nCustomer Id: " + v.getCustomer().getCustId()
					+ "\nInvoice Total: " + v.getTotalInvoicePrice() + "\nDate: "
					+ v.getInvoiceDate() + "\n\n";
		}
		if (list.equals(""))
			return "No invoices on record";
		else
			return list;
	}

}
