package retail;

import java.util.ArrayList;


//the Order class holds an ArrayList of OrderProducts within each instance
//each OrderProduct holds one Product and the quantity of that Product ordered
//when creating a new Order, only one OrderProduct is originally added
//any other OrderProducts can then be added to that object
//this is to make it easier to make either a single Product Order or a multiple Product Order
public class Order {
	
	private int orderUniqueId;
	private ArrayList<OrderProduct> listOfProductsOrdered = new ArrayList<OrderProduct>();
	private int supplierUniqueId;
	private boolean delivered = false;
	
	public Order(){
		
	}
	 
	public Order(int orderUniqueId, int supplierUniqueId, OrderProduct productOrdered) {
		this.orderUniqueId = orderUniqueId;
		this.supplierUniqueId = supplierUniqueId;
		this.addToProductList(productOrdered);
	}
	
	public Order(int orderUniqueId, int supplierUniqueId, ArrayList<OrderProduct> OrderProductList) {
		this.orderUniqueId = orderUniqueId;
		this.supplierUniqueId = supplierUniqueId;
		this.listOfProductsOrdered = OrderProductList;
	}
	
	public void addToProductList(OrderProduct ProductOrdered){
		this.listOfProductsOrdered.add(ProductOrdered);
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
	
	public boolean isDelivered(){
		return this.delivered;
	}
	
	public void setDelivered(){
		this.delivered = true;
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
			result = result + "---------------------------------------------- \n"  + "Order ID: " + order.getOrderUniqueId() 
					+ "\n Products: " + "-----------------";
			result += printOrderDetails(order);
			if(result.equals("")){
				result = "No orders found. ";
			}
		}
		return result;
	}
	
	public static String viewByOrderId(ArrayList<Order> listOfOrders, int orderId){
		String result = "";
		for(Order order: listOfOrders){
			if(order.getOrderUniqueId() == orderId){
				result = result + "----------------------------------------------" +  "\n" + "Order ID: " + 
						 order.getOrderUniqueId() + "\n"	+ "Products: " + "\n-----------------";
				result += printOrderDetails(order);
				break;
			}
			else if(listOfOrders.indexOf(order) == listOfOrders.size()-1){
				result = "Order not found. ";
			}
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
						result = result + "----------------------------------------------" +  "\n" + "Author: " + author + "\n"
								+ "Orders: " + "\n-----------------";
						first = true;
					}
					result = result + "\nOrder details: " + "\n" + "Order ID: " + order.getOrderUniqueId() + "\n" + "Customer ID: " + order.getSupplierUniqueId() + 
							"\nProducts: " + "\n" + 
							"\n Product Id: : " + product.getProductCode() + 
							"\n Title: " + product.getTitle() +
							"\n Author: " + product.getAuthor() +
							"\n Current Stock: " + product.getCurrentStock() +
							"\n Quantity Ordered: " + oProduct.getQuantity() + 
							"\n Supplier: " + product.getSupplier().getName() +
							"\n Max Stock: " + product.getMaxStock() +
							"\n Min Stock: " + product.getMinStock() +
							"\n Cost Price: �" + product.getCostPrice() +
							"\n Retail Price: �" + product.getRetailPrice() +"\n------------";
					break;
				}
				else if(result.equals("") && listOfOrders.indexOf(order) == listOfOrders.size()-1){
					result = "No order with a product by that author found. ";
				}
			}
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
						result = result + "----------------------------------------------" +  "\n" + "Title: " + title + "\n"
								+ "Orders: " + "\n-----------------";
						first = true;
					}
					result = result + "\nOrder details: " + "\n" + "Order ID: " + order.getOrderUniqueId() + "\n" + "Customer ID: " + order.getSupplierUniqueId() + 
							"\nProducts: " + "\n" + 
							"\n Product Id: : " + product.getProductCode() + 
							"\n Title: " + product.getTitle() +
							"\n Author: " + product.getAuthor() +
							"\n Quantity Ordered: " + oProduct.getQuantity() + 
							"\n Current Stock: " + product.getCurrentStock() +
							"\n Supplier: " + product.getSupplier().getName() +
							"\n Max Stock: " + product.getMaxStock() +
							"\n Min Stock: " + product.getMinStock() +
							"\n Cost Price: �" + product.getCostPrice() +
							"\n Retail Price: �" + product.getRetailPrice() +"\n------------";
					break;
				}
				else if(result.equals("") && listOfOrders.indexOf(order) == listOfOrders.size()-1){
					result = "No order with a product of that title found. ";
				}
			}
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
						result = result + "----------------------------------------------" +  "\n" + "Supplier: " + supplierId + "\n"
								+ "Orders: " + "\n-----------------";
						first = true;
					}
					result = result + "\n" + "Order details: " + "\n" + "Order ID: " + order.getOrderUniqueId() + "\n" + "Supplier ID: " + order.getSupplierUniqueId() + "\n" + 
							"Products: " + "\n" + 
							"\n Product Id: : " + product.getProductCode() + 
							"\n Title: " + product.getTitle() +
							"\n Author: " + product.getAuthor() +
							"\n Quantity Ordered: " + oProduct.getQuantity() + 
							"\n Current Stock: " + product.getCurrentStock() +
							"\n Supplier: " + product.getSupplier().getName() +
							"\n Max Stock:" + product.getMaxStock() +
							"\n Min Stock: " + product.getMinStock() +
							"\n Cost Price: �" + product.getCostPrice() +
							"\n Retail Price: �" + product.getRetailPrice() +"\n------------";
					break;
				}
				else if(result.equals("") && listOfOrders.indexOf(order) == listOfOrders.size()-1){
					result = "No order from that supplier found. ";
				}
			}
		}
		return result;
	}
	
	public static String viewDeliveredOrders(ArrayList<Order> listOfOrders){
		String result = "";
		for(Order order: listOfOrders){
			result = "Delivered orders: \n";
			if(order.isDelivered()){
				result += printOrderDetails(order);
			}
			else if(listOfOrders.indexOf(order) == listOfOrders.size()-1){
				result = "No delivered orders found. ";
			}
		}
		return result;
	}
	
	public static String viewUndeliveredOrders(ArrayList<Order> listOfOrders){
		String result = "Undelivered orders: \n";
		for(Order order: listOfOrders){
			if(!order.isDelivered()){
				result += printOrderDetails(order);
			}
			else if(listOfOrders.indexOf(order) == listOfOrders.size()-1){
				result = "No undelivered orders found. ";
			}
		}
		return result;
	}
	
	public static String printOrderDetails(Order order){
		String result = "";
		for(OrderProduct oProduct: order.getListOfOrderProducts()){
			Product product = oProduct.getProduct();
			result = result + "\n" + "Order details: " + "\n" + "Order ID: " + order.getOrderUniqueId() + "\n" + "Customer ID: " + order.getSupplierUniqueId() + "\n" +
					"Products: " + "\n" + 
					"\n Product Id: : " + product.getProductCode() + 
					"\n Title: " + product.getTitle() +
					"\n Author: " + product.getAuthor() +
					"\n Quantity Ordered: " + oProduct.getQuantity() + 
					"\n Current Stock: " + product.getCurrentStock() +
					"\n Supplier: " + product.getSupplier().getName() +
					"\n Max Stock:" + product.getMaxStock() +
					"\n Min Stock: " + product.getMinStock() +
					"\n Cost Price: �" + product.getCostPrice() +
					"\n Retail Price: �" + product.getRetailPrice() +"\n" + "\n------------";
		}
		return result;
	}
}
