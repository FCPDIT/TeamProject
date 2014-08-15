package retail;

import java.util.ArrayList;
import java.util.Scanner;

public class RetailSystemDriver {
	
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public RetailSystemDriver() {
		// Array List created to test Methods as they are being developed.
	//	Product p1 = new Product("Game of Thrones", "George R.R Martin", "9780553386790", 9.99, 3.75,6,200,5,new Supplier(12345," Books Express "," 12 Main Street, Cork "," sales@bookexpress.com ", " 01685789 "));
	//	Product p2 = new Product("Not a Drill", "Lee Child", "9780553389521", 12.75, 4.95,5,200,10,new Supplier(12569," Book Warehouse "," 12 Whitehall industrial Park, Dublin "," sales@bookwarehouse.ie ", " 01488759 "));
		
	//	products.add(p1);
	//	products.add(p2);
		
		
		// Test Code to ensure Array has been populated.
		/*
		for(Product p : products){ 
			System.out.println(p.getAuthor());
		}
		*/
		// These methods were first tested using the Console window.
		//System.out.println(new Product().viewProductById("9780553386790", products));
		//System.out.println(new Product().viewAllProductDetails(products));
		//System.out.println(new Product().viewProductByTitle("game of thrones",products));
		//System.out.println(new Product().viewProductByAuthor("Lee",products));
		//System.out.println(new Product().viewProductByMinStock(products));
		
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//new RetailSystemDriver(); // This is been used to test view functions in Product Class (e.g ViewProductByTitle). 
		//new MarcTestingFrame();
		new RetailGUI();
	}

}
