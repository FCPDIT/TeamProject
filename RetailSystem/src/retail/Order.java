package retail;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


//the Order class holds an ArrayList of OrderProducts within each instance
//each OrderProduct holds one Product and the quantity of that Product ordered
//when creating a new Order, only one OrderProduct is originally added
//any other OrderProducts can then be added to that object
//this is to make it easier to make either a single Product Order or a multiple Product Order
public class Order implements Comparable<Order> {
	
	private int orderUniqueId;
	private ArrayList<OrderProduct> listOfProductsOrdered = new ArrayList<OrderProduct>();
	private int supplierUniqueId;
	private boolean received = false;
	private Date orderDate;
	private double totalOrderPrice;
	private int noOfDays;
	
	public Order(){
		
	}
	 
	public Order(int orderUniqueId, int supplierUniqueId, OrderProduct productOrdered) {
		this.orderUniqueId = orderUniqueId;
		this.supplierUniqueId = supplierUniqueId;
		this.addToProductList(productOrdered);
		orderDate = new Date();
		totalOrderPrice = calculateOrderTotal();
	}
	
	public Order(int orderUniqueId, int supplierUniqueId, ArrayList<OrderProduct> OrderProductList) {
		this.orderUniqueId = orderUniqueId;
		this.supplierUniqueId = supplierUniqueId;
		this.listOfProductsOrdered = OrderProductList;
		orderDate = new Date();
		totalOrderPrice = calculateOrderTotal();
	}
	
	//3rd constructor for past dates
	public Order(int orderUniqueId, int supplierUniqueId, ArrayList<OrderProduct> OrderProductList, int noOfDays) {
		this.orderUniqueId = orderUniqueId;
		this.supplierUniqueId = supplierUniqueId;
		this.listOfProductsOrdered = OrderProductList;
		totalOrderPrice = calculateOrderTotal();
		this.noOfDays = noOfDays;
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, - noOfDays);
		orderDate = cal.getTime();
	}
	
	public double calculateOrderTotal(){
		
		double amount = 0.0;
		
		for(OrderProduct productOrdered: this.listOfProductsOrdered){
			amount += productOrdered.getProduct().getCostPrice() * productOrdered.getQuantity();
		}
		return amount;
	}
	
	  @Override
	  public int compareTo(Order o) {
	    return getOrderDate().compareTo(o.getOrderDate());
	 }
	  
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalOrderPrice() {
		return totalOrderPrice;
	}

	public void setTotalOrderPrice(double totalOrderPrice) {
		this.totalOrderPrice = totalOrderPrice;
	}

	public void addToProductList(OrderProduct ProductOrdered){
		this.listOfProductsOrdered.add(ProductOrdered);
	}
	
	public void setOrderUniqueId(int orderUniqueId){
		this.orderUniqueId = orderUniqueId;
	}
	
	public int getOrderUniqueId(){
		return this.orderUniqueId;
	}
	
	public ArrayList<OrderProduct> getListOfOrderProducts(){
		return this.listOfProductsOrdered;
	}
	
	public void setSupplierUniqueId(int supplierUniqueId){
		this.supplierUniqueId = supplierUniqueId;
	}
	
	public int getSupplierUniqueId(){
		return this.supplierUniqueId;
	}
	
	public boolean isReceived(){
		return this.received;
	}
	
	public void setReceived(){
		this.received = true;
		for(OrderProduct oProduct: this.listOfProductsOrdered){
			//set the quantity of this item in stock to be itself + the amount ordered
			oProduct.getProduct().setCurrentStock(oProduct.getProduct().getCurrentStock() + oProduct.getQuantity());
		}
	}
	
	public double calculateOrderWorth(){
		double amount = 0.0;
		
		for(OrderProduct productOrdered: this.listOfProductsOrdered){
			amount += productOrdered.getProduct().getRetailPrice() * productOrdered.getQuantity();
		}
		return amount;
	}
	
	//needs an actual arrayList of orders to process details for
	public static String viewAllOrders(ArrayList<Order> listOfOrders){
		String result = "";
		for(Order order: listOfOrders){
			result = result + "---------------------------------------------- \n"  + "ORDER ID: " + order.getOrderUniqueId() 
					+ "\n PRODUCTS: " + "-----------------";
			result += printOrderDetails(order);
		}
		if(result.equals("")){
			result = "No orders found. ";
		}
		return result;
	}
	
	public static String viewByOrderId(ArrayList<Order> listOfOrders, int orderId){
		String result = "";
		for(Order order: listOfOrders){
			if(order.getOrderUniqueId() == orderId){
				result = result + "----------------------------------------------" +  "\n" + "ORDER ID: " + 
						 order.getOrderUniqueId() + "\n" + "SUPPLIER: " + order.getSupplierUniqueId() +  "\n" + "PRODUCTS: " + "\n-----------------";
				result += printOrderDetails(order);
				break;
			}
		}
		if(result.equals("")){
			result = "Order not found. ";
		}
		return result;
	}
	
	public static String viewOrderByAuthor(ArrayList<Order> listOfOrders, String author){
		String result = "";
		boolean first = false;
		for(Order order: listOfOrders){
			ArrayList<OrderProduct> listOfOrderProducts = order.getListOfOrderProducts();
			for(OrderProduct oProduct: listOfOrderProducts){
				Product product = oProduct.getProduct();
				if(product.getAuthor().equalsIgnoreCase(author) ){
					if(!first){
						//add this if this is the first order with a product from this author
						result = result + "----------------------------------------------" +  "\n" + "AUTHOR: " + author + "\n"
								+ "\n - - - - - - - - - - - - - - - ";
						first = true;
					}
					result = result + "\nORDER DETAILS: " + "\n - - - - - - - - - - - - - - - \n" + "ORDER ID:		" + order.getOrderUniqueId() + 
							"\n" + "CUSTOMER ID:		" + order.getSupplierUniqueId() + 
							"\n PRODUCT ID :		" + product.getProductCode() + 
							"\n TITLE:		" + product.getTitle() +
							"\n AUTHOR:		" + product.getAuthor() +
							"\n QUANTITY ORDERED:	" + oProduct.getQuantity() + 
							"\n CURRENT STOCK:	" + product.getCurrentStock() +
							"\n SUPPLIER:		" + product.getSupplier().getName() +
							"\n MAX STOCK:		" + product.getMaxStock() +
							"\n MIN STOCK:		" + product.getMinStock() +
							"\n COST PRICE:		" + product.getCostPrice() +
							"\n RETAIL PRICE:		" + product.getRetailPrice() +"\n - - - - - - - - - - - - - - -";
					break;
				}
			}
		}
		if(result.equals("")){
			result = "No order containing a product by that author found. ";
		}
		return result;
	}
	
	public static String viewOrderByTitle(ArrayList<Order> listOfOrders, String title){
		String result = "";
		boolean first = false;
		for(Order order: listOfOrders){
			ArrayList<OrderProduct> listOfOrderProducts = order.getListOfOrderProducts();
			for(OrderProduct oProduct: listOfOrderProducts){
				Product product = oProduct.getProduct();
				if(product.getTitle().equalsIgnoreCase(title)){
					if(!first){
						//add this if this is the first order with a product with this title
						result = result + "----------------------------------------------" +  "\n" + "TITLE: " + title + "\n"
								+ "\n - - - - - - - - - - - - - - - ";
						first = true;
					}
					result = result + "\nORDER DETAILS: " + "\n - - - - - - - - - - - - - - - \n" + "ORDER ID:		" + order.getOrderUniqueId() + 
							"\n" + "CUSTOMER ID:		" + order.getSupplierUniqueId() + 
							"\n PRODUCT ID :		" + product.getProductCode() + 
							"\n TITLE:		" + product.getTitle() +
							"\n AUTHOR:		" + product.getAuthor() +
							"\n QUANTITY ORDERED:	" + oProduct.getQuantity() + 
							"\n CURRENT STOCK:	" + product.getCurrentStock() +
							"\n SUPPLIER:		" + product.getSupplier().getName() +
							"\n MAX STOCK:		" + product.getMaxStock() +
							"\n MIN STOCK:		" + product.getMinStock() +
							"\n COST PRICE:		" + product.getCostPrice() +
							"\n RETAIL PRICE:		" + product.getRetailPrice() +"\n - - - - - - - - - - - - - - -";
					break;
				}
			}
		}
		if(result.equals("")){
			result = "No order containing a product with that title found. ";
		}
		return result;
	}
	
	public static String viewOrderBySupplier(ArrayList<Order> listOfOrders, int supplierId){
		String result = "";
		boolean first = false;
		for(Order order: listOfOrders){
			ArrayList<OrderProduct> listOfOrderProducts = order.getListOfOrderProducts();
			for(OrderProduct oProduct: listOfOrderProducts){
				Product product = oProduct.getProduct();
				if(product.getSupplier().getId() == supplierId){
					if(!first){
						//add this if this is the first order with a product with this title
						result = result + "----------------------------------------------" +  "\n" + "SUPPLIER: " + supplierId + "\n"
								+ "\n - - - - - - - - - - - - - - - ";
						first = true;
					}
					result = result + "\nORDER DETAILS: " + "\n - - - - - - - - - - - - - - - \n" + "ORDER ID:		" + order.getOrderUniqueId() + 
							"\n" + "CUSTOMER ID:		" + order.getSupplierUniqueId() + 
							"\n PRODUCT ID :		" + product.getProductCode() + 
							"\n TITLE:		" + product.getTitle() +
							"\n AUTHOR:		" + product.getAuthor() +
							"\n QUANTITY ORDERED:	" + oProduct.getQuantity() + 
							"\n CURRENT STOCK:	" + product.getCurrentStock() +
							"\n SUPPLIER:		" + product.getSupplier().getName() +
							"\n MAX STOCK:		" + product.getMaxStock() +
							"\n MIN STOCK:		" + product.getMinStock() +
							"\n COST PRICE:		" + product.getCostPrice() +
							"\n RETAIL PRICE:		" + product.getRetailPrice() +"\n - - - - - - - - - - - - - - -";
					break;
				}
			}
		}
		if(result.equals("")){
			result = "No orders from that supplier found. ";
		}
		return result;
	}
	
	public static String viewReceivedOrders(ArrayList<Order> listOfOrders){
		String result = "";
		for(Order order: listOfOrders){
			if(order.isReceived() == true){
				if(result.equals("")){
					result = "Received orders: \n";
				}
				//System.out.println(order.orderUniqueId);
				result += "\n \n" + "Order ID: " + order.getOrderUniqueId() + "\n";
				result += printOrderDetails(order);
			}
		}
		if(result.equals("")){
			return "No received orders found. ";
		}
		else{
			return result;
		}
	}
	
	public static String viewUnreceivedOrders(ArrayList<Order> listOfOrders){
		String result = "";
		for(Order order: listOfOrders){
			if(!order.isReceived()){
				if(result.equals("")){
					result = "Unreceived orders: \n";
				}
				result += printOrderDetails(order);
			}
		}
		if(result.equals("")){
			return "No unreceived orders found.";
		}
		else{
			return result;
		}
	}
	
	public static String printOrderDetails(Order order){
		String result = "";
		for(OrderProduct oProduct: order.getListOfOrderProducts()){
			Product product = oProduct.getProduct();
			result = result + "\n" + 
					"\n PRODUCT ID :		" + product.getProductCode() + 
					"\n TITLE:		" + product.getTitle() +
					"\n AUTHOR:		" + product.getAuthor() +
					"\n QUANTITY ORDERED:	" + oProduct.getQuantity() + 
					"\n CURRENT STOCK:	" + product.getCurrentStock() +
					"\n SUPPLIER:		" + product.getSupplier().getName() +
					"\n MAX STOCK:		" + product.getMaxStock() +
					"\n MIN STOCK:		" + product.getMinStock() +
					"\n COST PRICE:		" + product.getCostPrice() +
					"\n RETAIL PRICE:		" + product.getRetailPrice() +"\n - - - - - - - - - - - - - - -";
		}
		return result;
	}
}