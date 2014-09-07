package retail;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Product {
	private String title;
	private String author;
	private String productCode;
	private double retailPrice;
	private double costPrice;
	private int currentStock;
	private int maxStock;
	private int minStock;
	
	private Supplier supplier;

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Product() {

	}

	public Product(String title, String author, String productCode,
			double retailPrice, double costPrice, int currentStock,
			int maxStock, int minStock, Supplier supplier) {
		this.title = title;
		this.author = author;
		this.productCode = productCode;
		this.retailPrice = retailPrice;
		this.costPrice = costPrice;
		this.currentStock = currentStock;
		this.maxStock = maxStock;
		this.minStock = minStock;
		this.supplier = supplier;
	}

	public String printProductDetails(Product p) {
		if (p != null) {
		return "\n PRODUCT ID:		" + (p.getProductCode()) + "\n TITLE:		"
		+ p.getTitle() + "\n AUTHOR:		" + p.getAuthor()
		+ "\n RETAIL PRICE:		" + p.getRetailPrice() 
		+"\n COST PRICE:		" + p.getCostPrice()
		+"\n CURRENT STOCK:	" + p.getCurrentStock()
		+ "\n MAX STOCK:		" + p.getMaxStock() 
		+ "\n MIN STOCK:		" + p.getMinStock() 
		+ "\n SUPPLIER:		" + p.getSupplier().getName()
		+  "\n";
		} else {
		return " No Details to Print ";
		}
		}

	public String viewAllProductDetails(ArrayList<Product> products) {
		String list = "";
		for (Product p : products) {
			list += printProductDetails(p);
		}
		if (list.equals(""))
			return "No Products on System";
		else
			return list;
	}

	public String viewProductById(String search, ArrayList<Product> products) {

		for (Product p : products) {
			if (p.getProductCode().equalsIgnoreCase(search)) {
				//System.out.println("--- ID Search Results ---");
				return printProductDetails(p);
			}

		}
		return " No Product Found ";
	}

	public String viewProductByTitle(String search, ArrayList<Product> products) {
		String list = "";
		for (Product p : products) {
			if (p.getTitle().equalsIgnoreCase(search)) { // Maybe this should be
															// changed to
															// ".contains" once
															// issue with case
															// sensitivity is
															// resolved.
				list += printProductDetails(p);
			}
		}
		if (list.equals("")) {
			return " No Product Found With That Title ";
		} else {
			return list;
		}
	}

	public String viewProductByAuthor(String searchAuthor, ArrayList<Product> products) {
		String list = "";

		for (Product p : products) {
			if (p.getAuthor().toLowerCase().equals(searchAuthor)) {	// Convert Author which is stored in Array into lower case while searching.
				list += printProductDetails(p);
				
			}
		}
		if (list.equals("")) {
			return " No Product With That Author ";
		} else {
			return list;
		}
	}
	// Search for all products which Current Stock level are below the Min reorder value.
	public String viewProductByMinStock(ArrayList<Product> products) {
		String list = "";
		
		for (Product p : products) {
			if (p.getCurrentStock() <= p.getMinStock()) {
				list +=printProductDetails(p);
			}
		}
		if (list.equals("")) {
			return " No Products with a Stock level below reorder level ";
		} else {
			return list;
		}
	}
	
	// Search for all products which Current Stock level are above Max Stock Level.
		public String viewProductByOverStock(ArrayList<Product> products) {
			String list = "";
			
			for (Product p : products) {
				if (p.getCurrentStock() >= p.getMaxStock()) {
					list +=printProductDetails(p);
				}
			}
			if (list.equals("")) {
				return " No Products are over stocked ";
			} else {
				return list;
			}
		}
	

	//search for products within a range ie between 5.99-10.99 euro, 10-20 etc. maybe use checkbox/radio buttons in the gui to select range
	public String viewProductbyRetailPrice(double minPrice,double maxPrice, ArrayList<Product> products) {
		String list = "";
		for (Product p : products) {
			if (p.getRetailPrice() >= minPrice & p.getRetailPrice() < maxPrice) {
				list += printProductDetails(p);
			}
		}
		
		if (list.equals("")) {
			return "No books in this price range"; 
			
		} else{
			return list;
		}
	}
	
	public int quantityByCost(double minPrice, double maxPrice, ArrayList<Product> products) {
		int amount = 0;
		for (Product p : products) {
			if (p.getCostPrice() >= minPrice & p.getCostPrice() < maxPrice){
			amount = amount += p.getCurrentStock();
			}
		}
				return amount;
			}
		

	
	//again to check stock levels in a range, under 50, over 100 etc
	public String viewProductbyQuantity(int minQuantity,int maxQuantity, ArrayList<Product> products) {
		String list = "";
		for (Product p : products) {
			if (p.getCurrentStock() >= minQuantity & p.getCurrentStock() < maxQuantity) {
				list += printProductDetails(p);
			}
		}
		
		if (list.equals("")) {
			return "No stock levels in this range"; 
			
		} else{
			return list;
		}
	}
	
	
	public Product removeStockById (String productCode, ArrayList<Product> products){
		for (Product p : products) {
			if (productCode.equals(p.getProductCode())) {

				products.remove(p);
				return p;
				              //not sure if this is the best way to remove a 
									//stockline but might be ok for this project..
			}/*else{
				JOptionPane.showMessageDialog(null, "Product not deleted.");
			}*/
		}
		return null;
	}
	

		


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public int getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}

	public int getMaxStock() {
		return maxStock;
	}

	public void setMaxStock(int maxStock) {
		this.maxStock = maxStock;
	}

	public int getMinStock() {
		return minStock;
	}

	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}

}
