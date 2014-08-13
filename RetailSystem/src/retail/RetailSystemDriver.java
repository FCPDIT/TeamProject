package retail;

import java.util.ArrayList;
import java.util.Scanner;

public class RetailSystemDriver {
	
	private ArrayList<Product> products = new ArrayList<Product>();
	private ArrayList<Employee> employees  = new ArrayList<Employee>();
	
	public RetailSystemDriver() {
		Product p1 = new Product("Game of Thrones", "George R.R Martin", "9780553386790", 9.99, 3.75,100,200,10,new Supplier(12345," Books Express "," 12 Main Street, Cork "," sales@bookexpress.com ", " 01685789 "));
		Product p2 = new Product("Not a Drill", "Lee Child", "9780553389521", 12.75, 4.95,50,200,10,new Supplier(12569," Book Warehouse "," 12 Whitehall industrial Park, Dublin "," sales@bookwarehouse.ie ", " 01488759 "));
		
		products.add(p1);
		products.add(p2);
		
		//add some test employees to array list
		employees.add(new Employee(123, "John", 0, 2000.00, 1111));
		employees.add( new Employee(234, "Tim", 0, 1500.00, 3333));
		employees.add(new Employee(345, "Sam", 1, 3000.00, 2222));
		
		// Test Code to ensure Array has been populated.
		/*
		for(Product p : products){ 
			System.out.println(p.getAuthor());
		}
		*/
		
		//System.out.println(new Product().viewProductById("9780553386790", products));
		System.out.println(new Product().viewAllProductDetails(products));
	}
	
	//get method for employee array list
	public ArrayList<Employee> getEmployees(){
		return employees;
	}
	//set method for employee array list
	public void addEmployee(Employee employee){
		employees.add(employee);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new RetailSystemDriver(); // This has been used to test viewProductById. 
		//new RetailGUI();
	}

}
