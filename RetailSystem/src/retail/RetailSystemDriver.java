package retail;

import java.util.ArrayList;

public class RetailSystemDriver {
	
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public RetailSystemDriver() {
		Product p1 = new Product(" Game of Thrones ", " George R.R Martin ", " 9780553386790 ", 9.99, 3.75,100,200,10,new Supplier(12345," Books Express "," 12 Main Street, Cork "," sales@bookexpress.com ", " 01685789 "));
		Product p2 = new Product(" Not a Drill ", " Lee Child ", " 9780553389521 ", 12.75, 4.95,50,200,10,new Supplier(12569," Book Warehouse "," 12 Whitehall industrial Park, Dublin "," sales@bookwarehouse.ie ", " 01488759 "));
	
		products.add(p1);
		products.add(p2);
		
		// Test Code to ensure Array has been populated.
		for(Product p : products){ 
			System.out.println(p.getAuthor());
		}
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//new RetailSystemDriver();
		new RetailGUI();
	}

}
