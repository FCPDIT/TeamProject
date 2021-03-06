package retail;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Invoice  implements Comparable<Invoice>  {
	private int id;
	private Employee employee; // or maybe just an employeeId ??
	private Customer customer;
	private Product product;
	private int quantity;
	private Date invoiceDate;
	private boolean paid = false;
	private double totalInvoicePrice;
	private ArrayList<InvoiceProduct> invoiceProducts = new ArrayList<InvoiceProduct>();
	private int noOfDays;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");

	public Invoice() {
	} // used for testing only

	public Invoice(int id, Employee employee, Customer customer, Product product, int quantity) {
		this.id = id;
		this.product = product;
		this.customer = customer;
		this.employee = employee;
		this.quantity = quantity;
		invoiceDate = new Date();
		totalInvoicePrice = product.getRetailPrice() * quantity;
		product.setCurrentStock(product.getCurrentStock() - quantity); // Stock check must be added in the driver class
																		
	}
	
	//2nd Constructor
	public Invoice(int id, Employee employee, Customer customer, ArrayList<InvoiceProduct> invoiceProducts) {
		this.id = id;
		this.employee = employee;
		this.customer = customer;
		this.invoiceProducts = invoiceProducts;
		invoiceDate = new Date();
		totalInvoicePrice = calculateInvoiceTotal();
	}
	
	//3rd Constructor for test invoices with historical dates
	public Invoice(int id, Employee employee, Customer customer, ArrayList<InvoiceProduct> invoiceProducts, int noOfDays, boolean paid) {
		this.id = id;
		this.employee = employee;
		this.customer = customer;
		this.invoiceProducts = invoiceProducts;
		this.noOfDays = noOfDays;
		this.paid = paid;
		invoiceDate = new Date();
		totalInvoicePrice = calculateInvoiceTotal();
		this.noOfDays = noOfDays;
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, - noOfDays);
		invoiceDate = cal.getTime();
	}

	//Methods
	public double calculateInvoiceTotal(){
		
		double amount = 0.0;
		
		for(InvoiceProduct productOrdered: this.invoiceProducts){
			amount += productOrdered.getProduct().getRetailPrice() * productOrdered.getQuantity();
		}
		return amount;
	}
	
	  @Override
	  public int compareTo(Invoice i) {
	    return getInvoiceDate().compareTo(i.getInvoiceDate());
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

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
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
			list += "INVOICE ID: " + v.getId();
			list+="\n-------------------------------";
				for(InvoiceProduct pds : v.getInvoiceProducts() ){
					list+="\nITEM NUMBER " + count+ " OF THIS INVOICE \n";
					list+="-------------------------------";
					count++;
					list+="\nPRODUCT ID:		" + pds.getProduct().getProductCode()
					+"\nPRODUCT TITLE:	" + pds.getProduct().getTitle()
					+ "\nPRODUCT PRICE:	" +  String.format("%.2f", pds.getProduct().getRetailPrice())
					+ "\nQUANTITY OF ORDER	" + pds.getQuantity() 
					+ "\nTOTAL :		" + String.format("%.2f", pds.getQuantity()*pds.getProduct().getRetailPrice()) 
					+ "\n--------------";
				}
					list += "\nEMPLOYEE NAME:	" + v.getEmployee().getEmployeeName() 
					+ "\nEMPLOYEE ID:		"   + v.getEmployee().getEmployeeId() 
					+ "\nCUSTOMER NAME:	" + v.getCustomer().getCustName() 
					+ "\nCUSTOMER ID:		"   + v.getCustomer().getCustId() 
					+ "\nINVOICE TOTAL:	" +  String.format("%.2f", v.calculateInvoiceTotal()) 
					+ "\nDATE:		" + sdf.format(v.getInvoiceDate()) + "\n\n";
					list+="-------------------------------\n";
				return list;
		} else {
			return "No details to print";
		}

	}
	

	// calculate total sales value for a given month
	public double getMonthlySales(int currentMonth, ArrayList<Invoice> invoices ){
		double count = 0.00;
		for (Invoice invoice: invoices){
			Date date1 = invoice.getInvoiceDate();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
			int month = cal.get(Calendar.MONTH);
		 if(month == currentMonth) {
			 count += invoice.getTotalInvoicePrice();
			}
		}return count;
	}
	
	//provide graph with total sales for a given month or if no sales gives prediction based on average of previous 3 months
	public double graphSales( int monthToShow, ArrayList<Invoice>invoices ){
		double sales = getMonthlySales(monthToShow, invoices);
		int month1 = monthToShow - 1;
		int month2 = monthToShow - 2;
		int month3 = monthToShow - 3;
		int month4 = monthToShow - 4;
		int month5 = monthToShow - 5;
		
		
		if (sales == 0.00 && getMonthlySales(month1, invoices) != 0){
			double average = (getMonthlySales(month1, invoices) + getMonthlySales(month2, invoices) + getMonthlySales(month3, invoices)) /3;
			return average;
		}
		
		
		else if (sales == 0.00 && getMonthlySales(month1, invoices) == 0.00 && getMonthlySales(month2, invoices) != 0){
			double average2 = ( ((getMonthlySales(month2, invoices) + getMonthlySales(month3, invoices) + getMonthlySales(month4, invoices)) /3) + 
					(getMonthlySales(month2, invoices)+ getMonthlySales(month3, invoices)) )/3;
					return average2;
				} 
		
		
		else if (sales == 0.00 && getMonthlySales(month2, invoices) == 0.00){
			double average3 = (getMonthlySales(month3, invoices) +
					((getMonthlySales(month3, invoices) + getMonthlySales(month4, invoices) + getMonthlySales(month5, invoices))/3)+
					 ((((getMonthlySales(month3, invoices) + getMonthlySales(month4, invoices) + getMonthlySales(month5, invoices))/3) + getMonthlySales(month3, invoices) + getMonthlySales(month4, invoices))/3)
					) /3;
		
			return average3;
			
			}
		
		
		
	
		else 
			return sales;
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
		
		//============= Method to Count amount of Invoices which are paid ==============================
		public int countPaidInvoices(int count, ArrayList<Invoice> invoices) {
			
			for(Invoice v : invoices){
				if(v.isPaid()== true){
					count++;
					//System.out.println("Count num is" + count);		// Debug code to ensure count is working.
	
					//return count;
					
				}
				
			}
			return count;
			}
		
		//============================================================================================
		
		
		
		
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
		
}





















