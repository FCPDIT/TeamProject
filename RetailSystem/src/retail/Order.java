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
	private int supplierUniqueId;
	private int quantity;
	private boolean delivered = false;
	
	/* Products need to contain quantity of Order somehow. To be more OO, the quantity should be held within
	   an object, rather than be deducted from the original Product's quantity variable displaying how many are in stock.
	   I propose Product be a base class, invoiceProduct and OrderProduct both extend the base Product class and have
	   extra variables to show their individual Order quantity.
	*/
	
	 
	//single Order constructor
	public Order(int orderUniqueId, int customerUniqueId, Product ProductOrdered, int quantity) {
		this.orderUniqueId = orderUniqueId;
		//this.dateOfOrder = new Date();
		this.supplierUniqueId = customerUniqueId;
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
	
	public void setSupplierUniqueId(int customerUniqueId){
		this.supplierUniqueId = customerUniqueId;
	}
	
	public int getSupplierUniqueId(){
		return this.supplierUniqueId;
	}
	
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
	
	//needs an actual arrayList of orders to process details for
	public String viewAllOrders(ArrayList<Order> listOfOrders){
		String result = "";
		String newLine = System.getProperty("line.seperator");
		for(Order order: listOfOrders){
			result = result + "----------------------------------------------" +  newLine + "Customer ID: " + order.getOrderUniqueId() + newLine
					+ "Products: " + "-----------------";
			for(Product product1: order.listOfProductsOrdered){
				result = result + "Author: " + product1.getAuthor() + newLine + "Title: " + product1.getTitle() + newLine + "Value of Product: €" + 
			product1.getRetailPrice() + newLine + "Quantity: " + order.quantity + newLine + "-----------------";
				
			}
		}
		return result;
	}
	
	public String viewByOrderId(ArrayList<Order> listOfOrders, int orderId){
		String result = "";
		for(Order order: listOfOrders){
			if(order.getOrderUniqueId() == orderId){
				result = result + "----------------------------------------------" +  "\n" + "Order ID: " + order.getOrderUniqueId() + "\n"
						+ "Customer ID: " + order.getSupplierUniqueId() + "Products: " + "-----------------";
				for(Product product: order.getListOfProducts()){
					result = result + 
					"\n Product Id: : " + product.getProductCode() + 
					"\n Title: " + product.getTitle() +
					"\n Author: " + product.getAuthor() +
					"\n Current Stock: " + product.getCurrentStock() +
					"\n Supplier: " + product.getSupplier().getName() +
					"\n Max Stock:" + product.getMaxStock() +
					"\n Min Stock: " + product.getMinStock() +
					"\n Cost Price: €" + product.getCostPrice() +
					"\n Retail Price: €" + product.getRetailPrice() +"------------";
				}
				break;
			}
			else if(listOfOrders.indexOf(order) == listOfOrders.size()-1){
				result = "Order not found. ";
			}
		}
		return result;
	}
	
	//needs arrayList of orders and the customer Id that we're looking for
	public String viewOrderBySupplierId(ArrayList<Order> listOfOrders, int customerUniqueId){
		String result = "";
		boolean first = false;
		for(Order order: listOfOrders){
			if(order.getSupplierUniqueId() == customerUniqueId){
				if(!first){
					//add this if this is the first order from this customer
					result = result + "----------------------------------------------" +  "\n" + "Supplier ID: " + order.getSupplierUniqueId() + "\n"
							+ "Products: " + "-----------------";
					first = true;
				}
				for(Product product: this.listOfProductsOrdered){
					result = result + 
							"\n Product Id: : " + product.getProductCode() + 
							"\n Title: " + product.getTitle() +
							"\n Author: " + product.getAuthor() +
							"\n Current Stock: " + product.getCurrentStock() +
							"\n Supplier: " + product.getSupplier().getName() +
							"\n Max Stock:" + product.getMaxStock() +
							"\n Min Stock: " + product.getMinStock() +
							"\n Cost Price: €" + product.getCostPrice() +
							"\n Retail Price: €" + product.getRetailPrice() +"------------";
				}
			}
		}
		if(result.equals("")){
			result = "No orders found for that customer";
		}
		return result;
	}
	
	public String viewOrderByAuthor(ArrayList<Order> listOfOrders, String author){
		String result = "";
		boolean first = false;
		for(Order order: listOfOrders){
			ArrayList<Product> listOfProducts = order.getListOfProducts();
			for(Product product: listOfProducts){
				if(product.getAuthor().equals(author)){
					if(!first){
						//add this if this is the first order with a product from this author
						result = result + "----------------------------------------------" +  "\n" + "Author: " + author + "\n"
								+ "Orders: " + "-----------------";
						first = true;
					}
					result = result + "Order details: " + "\n" + "Order ID: " + order.getOrderUniqueId() + "\n" + "Customer ID: " + order.getSupplierUniqueId() + 
							"Products: " + "\n" + 
							"\n Product Id: : " + product.getProductCode() + 
							"\n Title: " + product.getTitle() +
							"\n Author: " + product.getAuthor() +
							"\n Current Stock: " + product.getCurrentStock() +
							"\n Supplier: " + product.getSupplier().getName() +
							"\n Max Stock:" + product.getMaxStock() +
							"\n Min Stock: " + product.getMinStock() +
							"\n Cost Price: €" + product.getCostPrice() +
							"\n Retail Price: €" + product.getRetailPrice() +"------------";
					break;
				}
			}
			
		}
		return result;
	}
	
	public String viewOrderByTitle(ArrayList<Order> listOfOrders, String title){
		String result = "";
		boolean first = false;
		for(Order order: listOfOrders){
			ArrayList<Product> listOfProducts = order.getListOfProducts();
			for(Product product: listOfProducts){
				if(product.getTitle().equals(title)){
					if(!first){
						//add this if this is the first order with a product with this title
						result = result + "----------------------------------------------" +  "\n" + "Title: " + title + "\n"
								+ "Orders: " + "-----------------";
						first = true;
					}
					result = result + "Order details: " + "\n" + "Order ID: " + order.getOrderUniqueId() + "\n" + "Customer ID: " + order.getSupplierUniqueId() + 
							"Products: " + "\n" + 
							"\n Product Id: : " + product.getProductCode() + 
							"\n Title: " + product.getTitle() +
							"\n Author: " + product.getAuthor() +
							"\n Current Stock: " + product.getCurrentStock() +
							"\n Supplier: " + product.getSupplier().getName() +
							"\n Max Stock:" + product.getMaxStock() +
							"\n Min Stock: " + product.getMinStock() +
							"\n Cost Price: €" + product.getCostPrice() +
							"\n Retail Price: €" + product.getRetailPrice() +"------------";
					break;
				}
			}
		}
		return result;
	}
	
	public String viewOrderBySupplier(ArrayList<Order> listOfOrders, int supplierId){
		String result = "";
		boolean first = false;
		for(Order order: listOfOrders){
			ArrayList<Product> listOfProducts = order.getListOfProducts();
			for(Product product: listOfProducts){
				if(product.getSupplier().getId() == supplierId){
					if(!first){
						//add this if this is the first order with a product with this title
						result = result + "----------------------------------------------" +  "\n" + "Supplier: " + supplierId + "\n"
								+ "Orders: " + "-----------------";
						first = true;
					}
					result = result + "Order details: " + "\n" + "Order ID: " + order.getOrderUniqueId() + "\n" + "Customer ID: " + order.getSupplierUniqueId() + 
							"Products: " + "\n" + 
							"\n Product Id: : " + product.getProductCode() + 
							"\n Title: " + product.getTitle() +
							"\n Author: " + product.getAuthor() +
							"\n Current Stock: " + product.getCurrentStock() +
							"\n Supplier: " + product.getSupplier().getName() +
							"\n Max Stock:" + product.getMaxStock() +
							"\n Min Stock: " + product.getMinStock() +
							"\n Cost Price: €" + product.getCostPrice() +
							"\n Retail Price: €" + product.getRetailPrice() +"------------";
					break;
				}
			}
		}
		return result;
	}
	
	public String viewDeliveredOrders(ArrayList<Order> listOfOrders){
		String result = "";
		for(Order order: listOfOrders){
			result = "Delivered orders: \n";
			if(order.isDelivered()){
				for(Product product: order.getListOfProducts()){
					result = result + "Order details: " + "\n" + "Order ID: " + order.getOrderUniqueId() + "\n" + "Customer ID: " + order.getSupplierUniqueId() + 
							"Products: " + "\n" + 
							"\n Product Id: : " + product.getProductCode() + 
							"\n Title: " + product.getTitle() +
							"\n Author: " + product.getAuthor() +
							"\n Current Stock: " + product.getCurrentStock() +
							"\n Supplier: " + product.getSupplier().getName() +
							"\n Max Stock:" + product.getMaxStock() +
							"\n Min Stock: " + product.getMinStock() +
							"\n Cost Price: €" + product.getCostPrice() +
							"\n Retail Price: €" + product.getRetailPrice() +"------------";
				}
			}
		}
		return result;
	}
	
	public String viewUndeliveredOrders(ArrayList<Order> listOfOrders){
		String result = "";
		for(Order order: listOfOrders){
			result = "Delivered orders: \n";
			if(!order.isDelivered()){
				for(Product product: order.getListOfProducts()){
					result = result + "Order details: " + "\n" + "Order ID: " + order.getOrderUniqueId() + "\n" + "Customer ID: " + order.getSupplierUniqueId() + 
							"Products: " + "\n" + 
							"\n Product Id: : " + product.getProductCode() + 
							"\n Title: " + product.getTitle() +
							"\n Author: " + product.getAuthor() +
							"\n Current Stock: " + product.getCurrentStock() +
							"\n Supplier: " + product.getSupplier().getName() +
							"\n Max Stock:" + product.getMaxStock() +
							"\n Min Stock: " + product.getMinStock() +
							"\n Cost Price: €" + product.getCostPrice() +
							"\n Retail Price: €" + product.getRetailPrice() +"------------";
				}
			}
		}
		return result;
	}
	
	public void printOrderDetails(){
			System.out.println("----------------------------------------------");
			System.out.println("ID of Customer Ordering: " + getOrderUniqueId());
			//System.out.println("Date of Order: " + this.dateOfOrder.toGMTString());
			System.out.println("Products:");
			System.out.println("-----------------");
			for(Product product: this.listOfProductsOrdered){
				System.out.println(
							"\n Product Id: : " + product.getProductCode() + 
							"\n Title: " + product.getTitle() +
							"\n Author: " + product.getAuthor() +
							"\n Current Stock: " + product.getCurrentStock() +
							"\n Supplier: " + product.getSupplier().getName() +
							"\n Max Stock:" + product.getMaxStock() +
							"\n Min Stock: " + product.getMinStock() +
							"\n Cost Price: €" + product.getCostPrice() +
							"\n Retail Price: €" + product.getRetailPrice() +"------------");
			}
			System.out.println("----------------------------------------------");
		}
	

}
