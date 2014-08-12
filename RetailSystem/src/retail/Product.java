package retail;

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

