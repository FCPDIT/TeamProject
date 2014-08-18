package retail;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class InvoiceTest {
	private Invoice inv = new Invoice();
	private ArrayList<Employee> employees = new ArrayList<>();
	private ArrayList<Customer> customers = new ArrayList<>();
	private ArrayList<Product> products = new ArrayList<>();
	

	//=====================
	@Test
	public void testReturnEmployeeObjectEquals() {
		Employee emp = new Employee(1, "marc", 1, 50, 1234);
		employees.add(emp);
		assertEquals(emp, inv.returnEmployeeObject(1, employees));
	}
	
	@Test
	public void testReturnEmployeeObjectNotEqual() {
		Employee emp = new Employee(1, "marc", 1, 50, 1234);
		employees.add(emp);
		assertNotEquals(emp, inv.returnEmployeeObject(2, employees));
	}

	//=====================
	@Test
	public void testReturnCustomerObjectEqual() {
		Customer cust = new Customer(1, "john", "dublin");
		customers.add(cust);
		assertEquals(cust, inv.returnCustomerObject(1, customers));
	}
	
	@Test
	public void testReturnCustomerObjectNotEqual() {
		Customer cust = new Customer(1, "john", "dublin");
		customers.add(cust);
		assertNotEquals(cust, inv.returnCustomerObject(5, customers));
	}

	//=====================
	@Test
	public void testReturnProductObjectEquals() {
		Product prod = new Product("abc","def","123456", 30.00, 10, 12, 20, 5, new Supplier(1, "johnsons", "Cork"));
		products.add(prod);
		assertEquals(prod, inv.returnProductObject("123456", products));
	}
	
	@Test
	public void testReturnProductObjectNotEquals() {
		Product prod = new Product("abc","def","123456", 30.00, 10, 12, 20, 5, new Supplier(1, "johnsons", "Cork"));
		products.add(prod);
		assertNotEquals(prod, inv.returnProductObject("9999999", products));
	}
		
}
