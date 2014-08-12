package retail;

import java.util.ArrayList;
//import java.util.Date;


public class Order {
	
	//id of customer that Ordered
	private int orderUniqueId;
	//date of Order, format ok for now, may change later down the line
	//private Date dateOfOrder;
	//array list of Products, each Order may have one or many Products Ordered, but only one customer Ordering
	private ArrayList<Product> listOfProductsOrdered = new ArrayList<Product>();
	private int quantity;
	private boolean delivered = false;
	
	/* Products need to contain quantity of Order somehow. To be more OO, the quantity should be held within
	   an object, rather than be deducted from the original Product's quantity variable displaying how many are in stock.
	   I propose Product be a base class, invoiceProduct and OrderProduct both extend the base Product class and have
	   extra variables to show their individual Order quantity.
	*/
	
	 
	//single Order constructor
	public Order(int orderUniqueId, Product ProductOrdered, int quantity) {
		this.orderUniqueId = orderUniqueId;
		//this.dateOfOrder = new Date();
		this.addToProductList(ProductOrdered);
		this.quantity = quantity;
	}
	
	//multiple Order constructor
	//unused for now
	/* public Order (int orderUniqueId, ArrayList<Product> listOfProductsOrdered){
		this.orderUniqueId = orderUniqueId;
		//this.dateOfOrder = new Date();
		for(Product ProductOrdered: listOfProductsOrdered){
			this.addToProductList(ProductOrdered);
		}
	}
	*/
	
	public void addToProductList(Product ProductOrdered){
		this.listOfProductsOrdered.add(ProductOrdered);
	}
	
	public int getOrderUniqueId(){
		return this.orderUniqueId;
	}
	
	public ArrayList<Product> getListOfProducts(){
		return this.listOfProductsOrdered;
	}
	
	/*public Date getOrderDate(){
		return this.dateOfOrder;
	}
	*/
	
	public int getOrderQuantity(){
		return this.quantity;
	}
	
	public void setOrderQuantity(int quantity){
		this.quantity = quantity;
	}
	
	public boolean isDelivered(){
		return this.delivered;
	}
	
	public void setDelivered(){
		this.delivered = true;
		for(Product product1: this.listOfProductsOrdered){
			//set the quantity of this item in stock to be itself + the amount ordered
			product1.setCurrentStock(product1.getCurrentStock() + this.quantity);
		}
		
	}
	
	public double calculateOrderWorth(){
		double amount = 0.0;
		
		for(Product ProductOrdered: this.listOfProductsOrdered){
			amount += ProductOrdered.getRetailPrice() * this.quantity;
		}
		
		return amount;
	}
	
	public void printOrderDetails(){
		for(Product ProductOrdered: this.listOfProductsOrdered){
			System.out.println("----------------------------------------------");
			System.out.println("ID of Customer Ordering: " + getOrderUniqueId());
			//System.out.println("Date of Order: " + this.dateOfOrder.toGMTString());
			System.out.println("Products:");
			System.out.println("-----------------");
			for(Product ProductOrdered1: this.listOfProductsOrdered){
				System.out.println("Author: " + ProductOrdered1.getAuthor());
				System.out.println("Title: " + ProductOrdered1.getTitle());
				System.out.println("Value of Product: " + ProductOrdered1.getRetailPrice());
				System.out.println("Quantity: " + this.quantity);
			}
			System.out.println("-----------------");
			System.out.println("----------------------------------------------");
		}
	}

}
