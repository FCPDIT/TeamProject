package retail;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class OrderTest {

	
	private ArrayList<Supplier> suppliers;
	private ArrayList<Product> products;
	private ArrayList<OrderProduct> orderProducts;
	private ArrayList<Order> orders;
	

	@Test
	public void testGetOrderUniqueId() {
		products.add(new Product("Game of Thrones", "George R.R Martin", "0001", 9.99, 3.75,100,200,15, suppliers.get(0)));
		products.add(new Product("Not a Drill", "Lee Child", "0002", 12.75, 4.95,221,200,10, suppliers.get(1)));
		products.add(new Product("Harry Potter", "j.k rowling", "0003", 11.99, 2.95,9,100,10,suppliers.get(2)));
		suppliers.add(new Supplier(1, "Smiths", "Dublin","sam@email.com",123456));
		suppliers.add(new Supplier(2, "Thompsons", "Cork","tom@email.com",234567));
		suppliers.add(new Supplier(3, "Randome", "Dublin", "randome@email.com", 789654));
		orderProducts.add(new OrderProduct(products.get(0), 5));
		orderProducts.add(new OrderProduct(products.get(1), 7));
		orderProducts.add(new OrderProduct(products.get(3), 14));
		orders.add(new Order(3, 1, orderProducts));
		orders.add(new Order(4, 2, orderProducts));
		orders.add(new Order(5, 3, orderProducts));
		assertNotEquals(orders.get(0).getOrderUniqueId(), null);
	}

	@Test
	public void testGetSupplierUniqueId() {
		products.add(new Product("Game of Thrones", "George R.R Martin", "0001", 9.99, 3.75,100,200,15, suppliers.get(0)));
		products.add(new Product("Not a Drill", "Lee Child", "0002", 12.75, 4.95,221,200,10, suppliers.get(1)));
		products.add(new Product("Harry Potter", "j.k rowling", "0003", 11.99, 2.95,9,100,10,suppliers.get(2)));
		suppliers.add(new Supplier(1, "Smiths", "Dublin","sam@email.com",123456));
		suppliers.add(new Supplier(2, "Thompsons", "Cork","tom@email.com",234567));
		suppliers.add(new Supplier(3, "Randome", "Dublin", "randome@email.com", 789654));
		orderProducts.add(new OrderProduct(products.get(0), 5));
		orderProducts.add(new OrderProduct(products.get(1), 7));
		orderProducts.add(new OrderProduct(products.get(3), 14));
		orders.add(new Order(3, 1, orderProducts));
		orders.add(new Order(4, 2, orderProducts));
		orders.add(new Order(5, 3, orderProducts));
		assertNotEquals(orders.get(1).getSupplierUniqueId(), null);
	}

	@Test
	public void testCalculateOrderWorth() {
		products.add(new Product("Game of Thrones", "George R.R Martin", "0001", 9.99, 3.75,100,200,15, suppliers.get(0)));
		products.add(new Product("Not a Drill", "Lee Child", "0002", 12.75, 4.95,221,200,10, suppliers.get(1)));
		products.add(new Product("Harry Potter", "j.k rowling", "0003", 11.99, 2.95,9,100,10,suppliers.get(2)));
		suppliers.add(new Supplier(1, "Smiths", "Dublin","sam@email.com",123456));
		suppliers.add(new Supplier(2, "Thompsons", "Cork","tom@email.com",234567));
		suppliers.add(new Supplier(3, "Randome", "Dublin", "randome@email.com", 789654));
		orderProducts.add(new OrderProduct(products.get(0), 5));
		orderProducts.add(new OrderProduct(products.get(1), 7));
		orderProducts.add(new OrderProduct(products.get(3), 14));
		orders.add(new Order(3, 1, orderProducts));
		orders.add(new Order(4, 2, orderProducts));
		orders.add(new Order(5, 3, orderProducts));
		assertTrue(orders.get(2).calculateOrderWorth() > 0);
	}

}
