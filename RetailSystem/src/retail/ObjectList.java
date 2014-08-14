package retail;

import java.util.ArrayList;

public class ObjectList {
	private ArrayList<Product> products = new ArrayList<Product>();
	private ArrayList<Employee> employees  = new ArrayList<Employee>();
	private ArrayList<Invoice> invoices = new ArrayList<Invoice>();
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	
public ObjectList(){
	Product p1 = new Product("Game of Thrones", "George R.R Martin", "9780553386790", 9.99, 3.75,100,200,15,new Supplier(12345," Books Express "," 12 Main Street, Cork "," sales@bookexpress.com ", " 01685789 "));
	Product p2 = new Product("Not a Drill", "Lee Child", "9780553389521", 12.75, 4.95,50,200,10,new Supplier(12569," Book Warehouse "," 12 Whitehall industrial Park, Dublin "," sales@bookwarehouse.ie ", " 01488759 "));
	
	products.add(p1);
	products.add(p2);
	
	//add some test employees to array list
	employees.add(new Employee(123, "John", 0, 2000.00, 1111));
	employees.add( new Employee(234, "Tim", 0, 1500.00, 3333));
	employees.add(new Employee(345, "Sam", 1, 3000.00, 2222));
	
	//add some test customers to array list
	customers.add(new Customer(1, "Sam", "Dublin"));
	customers.add(new Customer(2, "Tom", "Cork"));
	customers.add(new Customer(3, "John", "Galway"));

	//add some test invoices to array list 
	Invoice inv2 = new Invoice(2, new Employee(2,"john",2,110.00,4567), new Customer(2,"Rudds","Galway"), new Product("x", "x", "x", 55.00, 25.00, 20, 30, 3, new Supplier(2,"h","h")),12);
	Invoice inv3 = new Invoice(3, new Employee(3,"mary",3,130.00,3987), new Customer(3,"Dennys","Cork"), new Product("y", "y", "y", 60.00, 30.00, 30, 40, 4, new Supplier(3,"m","m")),14);
	invoices.add(inv2);
	invoices.add(inv3);
	
	// Test Code to ensure Array has been populated.
	/*
	for(Product p : products){ 
		System.out.println(p.getAuthor());
	}
	*/
	
	//System.out.println(new Product().viewProductById("9780553386790", products));
	//System.out.println(new Product().viewAllProductDetails(products));
	//System.out.println(new Product().viewProductByTitle("game of thrones",products));
	//System.out.println(new Product().viewProductByAuthor("Lee",products));
	//System.out.println(new Product().viewProductByMinStock(15,products));
	
	}
	//get method for employee array list
	public ArrayList<Employee> getEmployees(){
		return employees;
	}
	//set method for employee array list
	public void addEmployee(Employee employee){
		employees.add(employee);
	}

	//get method for product array list
	public ArrayList<Product> getProducts(){
		return products;
	}

	//get method for invoice array list
	public ArrayList<Invoice> getInvoices(){
		return invoices;
	}

	//get method for invoice array list
	public ArrayList<Customer> getCustomers(){
		return customers;
	}

}
	
