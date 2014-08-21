package retail;

public class InvoiceProduct {

	private Product product;
	private int quantity;
	
	public InvoiceProduct(Product product, int quantity) {
		// TODO Auto-generated constructor stub
		this.product = product;
		this.quantity = quantity;
		product.setCurrentStock(product.getCurrentStock()-quantity);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
