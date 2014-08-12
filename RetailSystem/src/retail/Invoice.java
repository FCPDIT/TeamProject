package retail;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Invoice {
	private Employee employee; // or maybe just an employeeId ??
	private Customer customer;
	private Product product;
	private int quantity;
	private double invoiceTotal; // ?? quantity*retailPrice of product
	private Date invoiceDate;
	

	public Invoice(Employee employee, Customer customer, Product product, int quantity) {
		this.product = product;
		this.customer = customer;
		this.employee = employee;
		this.quantity = quantity;
		invoiceTotal = product.getRetailPrice() * this.quantity;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		invoiceDate = new Date();
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


	public double getInvoiceTotal() {
		return invoiceTotal;
	}


	public void setInvoiceTotal(double invoiceTotal) {
		this.invoiceTotal = invoiceTotal;
	}


	public Date getInvoiceDate() {
		return invoiceDate;
	}


	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

}

