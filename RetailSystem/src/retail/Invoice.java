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
	private ArrayList<InvoiceProduct> invoiceProducts = new ArrayList<InvoiceProduct>();

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
	
	//2nd Constructor
	public Invoice(int id, Employee employee, Customer customer, ArrayList<InvoiceProduct> invoiceProducts) {
		this.id = id;
		this.employee = employee;
		this.customer = customer;
		this.invoiceProducts = invoiceProducts;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy"); //may want to review the dates set up!!
		invoiceDate = sdf.format(new Date());
	}

	//Methods
	public double calculateInvoiceTotal(){
		
		double amount = 0.0;
		
		for(InvoiceProduct productOrdered: this.invoiceProducts){
			amount += productOrdered.getProduct().getRetailPrice() * productOrdered.getQuantity();
		}
		return amount;
	}
	
	//Getter and setters
	public double getTotalInvoicePrice() {
		return totalInvoicePrice;
	}

	public ArrayList<InvoiceProduct> getInvoiceProducts() {
		return invoiceProducts;
	}

	public void setInvoiceProducts(ArrayList<InvoiceProduct> invoiceProducts) {
		this.invoiceProducts = invoiceProducts;
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
		int count = 1;
		String list = "";
		if (v != null) {
			list += "Invoice ID: " + v.getId();
			list+="\n-------------------------------";
				for(InvoiceProduct pds : v.getInvoiceProducts() ){
					list+="\nItem number " + count+ " of this Invoice \n";
					list+="-------------------------------";
					count++;
					list+="\nProduct Id: " + pds.getProduct().getProductCode()
					+"\nProduct Title: " + pds.getProduct().getTitle()
					+ "\nProduct Price: " +  String.format("€%.2f", pds.getProduct().getRetailPrice())
					+ "\nQuantity of Order " + pds.getQuantity() 
					+ "\nTotal of " + pds.getProduct().getProductCode() +" : " + (pds.getQuantity()*pds.getProduct().getRetailPrice()) 
					+ "\n--------------";
				}
					list += "\nEmployee Name: " + v.getEmployee().getEmployeeName() 
					+ "\nEmployee Id: "   + v.getEmployee().getEmployeeId() 
					+ "\nCustomer Name: " + v.getCustomer().getCustName() 
					+ "\nCustomer Id: "   + v.getCustomer().getCustId() 
					+ "\nInvoice Total: " +  String.format("€%.2f", v.calculateInvoiceTotal()) 
					+ "\nDate: " + v.getInvoiceDate() + "\n\n";
					list+="-------------------------------\n";
				return list;
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
			return "All Invoices are currently Paid";
			}
			else{
				return unpaid;
			}
		}
		
		/**
		 * Methods required to create a new Invoice Object:
		 * 	1. Method to return an Employee from an ArrayList
		 * 	2. Method to return a Customer from an ArrayList
		 * 	3. Method to return a Product from an ArrayList
		 */
		
		//1. Method to return the Employee form an ArrayList
		public Employee returnEmployeeObject(int id, ArrayList<Employee>employees){
			for(Employee e : employees){
				if(e.getEmployeeId()==id){
					return e;
				}
			}
			return null;
		}
		
		//2. Method to return a Customer from an ArrayList
		public Customer returnCustomerObject(int id, ArrayList<Customer>customers){
			for(Customer c : customers){
				if(c.getCustId()==id){
					return c;
				}
			}
			return null;
		}
		
		//3. Method to return a Product from an ArrayList
		public Product returnProductObject(String prodcode, ArrayList<Product> products){
			for(Product p : products){
				if(p.getProductCode().equals(prodcode)){
					return p;
				}
			}
			return null;
		}

		//method to edit invoices by id
		public int verifyInvoiceID(ArrayList<Invoice> invoices, int id) {
	    	int count = 0;
	    	int validID = 0;
			for(Invoice invoice: invoices){
				if(id == invoice.getId()){
					count++;
					validID = 1;
				}
			}	
			if(count == 0){
				validID = 2;
			}
			return validID;
		}
		
		//method to pay invoices by customer
		public int verifyInvoiceByCustomerID(ArrayList<Customer> customers, int id) {
	    	int count = 0;
	    	int validID = 0;
			for(Customer customer: customers){
				if(id == customer.getCustId()){
					count++;
					validID = 1;
				}
			}	
			if(count == 0){
				validID = 2;
			}
			return validID;
		}
		
		//method to set fields on edit invoice
		public ArrayList<String> returnFields(ArrayList<Invoice> invoices, int id){
			
			ArrayList<String> fields = new ArrayList<String>();
			String invId = Integer.toString(id);
			fields.add(invId);
			String employee ="";
			String customer ="";
			String product ="";
			String quantity ="";
			String total ="";
			String paid = "Unpaid";
			for(Invoice invoice: invoices){
				if(id == invoice.getId()){
					employee = Integer.toString(invoice.getEmployee().getEmployeeId());
					customer = Integer.toString(invoice.getCustomer().getCustId());
					product = invoice.getProduct().getProductCode();
					quantity = Integer.toString(invoice.getQuantity());
					total = Double.toString(invoice.getTotalInvoicePrice());
					if(invoice.isPaid()){
						paid = "Paid";
					}
					fields.add(employee);
					fields.add(customer);
					fields.add(product);
					fields.add(quantity);
					fields.add(total);
					fields.add(paid);
				}
			}		
			return fields;
		}
		
		
		//method to update invoices
		public void updateInvoice(ArrayList<Invoice> invoices, ArrayList<Employee> employees, ArrayList<Product> products, ArrayList<Customer> customers, ArrayList<String> fields){
			int invId = Integer.parseInt(fields.get(0));
			int employeeId = Integer.parseInt(fields.get(1));
			int customerId = Integer.parseInt(fields.get(2));
			String productId =fields.get(3);
			int qty = Integer.parseInt(fields.get(4));
			int currentId = Integer.parseInt(fields.get(5));
			Employee emp = employees.get(0);
			Customer cust = customers.get(0);
			Product prod = products.get(0);
			
			for(Employee employee: employees){
				if(employeeId == employee.getEmployeeId()){
					emp = employee;
				}
			}
			
			for(Customer customer: customers){
				if(customerId == customer.getCustId()){
					cust = customer;
				}
			}
			
			for(Product product: products){
				if(productId.equals(product.getProductCode())){
					prod = product;
				}
			}
			
			for(Invoice invoice: invoices){
				if(currentId == invoice.getId()){
					invoice.setId(invId);
					invoice.setEmployee(emp);
					invoice.setCustomer(cust);
					invoice.setProduct(prod);
					invoice.setQuantity(qty);
				}
			}
		}
		
		//method to pay invoice
		public void payInvoice(ArrayList<Invoice> invoices, int id){
			for(Invoice invoice: invoices){
				if(id == invoice.getId()){
					invoice.setPaid(true);
				}
			}
			
		}
		
		//method to delete invoice
		public int deleteInvoice(ArrayList<Invoice> invoices, int id){
			int index = 0;
			for(Invoice invoice: invoices){
				if(id == invoice.getId()){
					index = invoices.indexOf(invoice);
				}
			}
			return index;
		}
		
}





















