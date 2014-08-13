package retail;

import java.util.ArrayList;


public class Product {
	private String title;
	private String author;
	private String productCode;
	private double retailPrice;
	private double costPrice;
	private int currentStock;
	private int maxStock;
	private int minStock;
	// hardback or paperback ??
	private Supplier supplier; // or just supplierId ??
	
	
	
	public Supplier getSupplier() {
		return supplier;
	}



	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	public Product(){
		
	}


	public Product(String title, String author, String productCode, double retailPrice, double costPrice, int currentStock, int maxStock, int minStock, Supplier supplier) {
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
	
	
	public String printProductDetails(Product p){
		if (p!= null) {
			
			return "Product Id: : " + p.getProductCode() + 
					"\n Title: " + p.getTitle() +
					"\n Author: " + p.getAuthor() +
					"\n Current Stock: " + p.getCurrentStock() +
					"\n Supplier: " + p.getSupplier().getName() +
					"\n Max Stock:" + p.getMaxStock() +
					"\n Min Stock: " + p.getMinStock() +
					"\n Cost Price: €" + p.getCostPrice() +
					"\n Retail Price: €" + p.getRetailPrice();
					
		}
		else{
			return " No Details to Print ";
		}
	}
	
	
	public String viewProductById(String search,ArrayList<Product> products){

	for(Product p: products){
		if(p.getProductCode().equals(search)){
			System.out.println("--- ID Search Results ---");
			return printProductDetails(p);
		}
		
	}
		return " No Product Found ";
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

