package retail;


//an extension of the product class, used simply to keep track of the quantity of each product in multiple product orders

public class OrderProduct {
	
	private Product product;
	private int quantity;
	
	public OrderProduct(Product product, int quantity){
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct(){
		return this.product;
	}
	
	public int getQuantity(){
		return this.quantity;
	}
}
