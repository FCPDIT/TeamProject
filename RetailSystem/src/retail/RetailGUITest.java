package retail;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class RetailGUITest {
	
	int inRange = 0;
	RetailGUI gui = new RetailGUI();
	JComboBox<String> combo = new JComboBox<String>();
	ArrayList<Customer> customers = new ArrayList<Customer>();
	ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	ArrayList<Employee> employees = new ArrayList<Employee>();
	ArrayList<Invoice> invoices = new ArrayList<Invoice>();
	ArrayList<Product> products = new ArrayList<Product>();
	ArrayList<InvoiceProduct> invoiceProducts = new ArrayList<InvoiceProduct>();
	
	@Before
	public void setUp() throws Exception {
		customers.add(new Customer(1, "John", "123 Fake Street"));
		customers.add(new Customer(2, "Jane", "123 Fake Street"));
		customers.add(new Customer(3, "Jim", "123 Fake Street"));
		suppliers.add(new Supplier(1, "John", "123 Fake Street"));
		suppliers.add(new Supplier(2, "Jane", "123 Fake Street"));
		suppliers.add(new Supplier(3, "Jim", "123 Fake Street"));
		employees.add(new Employee(1, "John", 1, 2.00, 1));
		employees.add(new Employee(2, "John", 1, 2.00, 1));
		employees.add(new Employee(3, "Jim", 1, 2.00, 1));
		products.add(new Product("The Curious Incident of the Dog in the Night-Time", "Mark Haddon", "0021", 7.99, 1.92,15,20,10,suppliers.get(0)));
		invoiceProducts.add(new InvoiceProduct(products.get(0), 1));
		invoices.add(new Invoice(1001, employees.get(0), customers.get(0), invoiceProducts, 1, true));
	}

	@After
	public void tearDown() throws Exception {
		customers.add(new Customer(1, "John", "123 Fake Street"));
		customers.add(new Customer(2, "Jane", "123 Fake Street"));
		customers.add(new Customer(3, "Jim", "123 Fake Street"));
		suppliers.add(new Supplier(1, "John", "123 Fake Street"));
		suppliers.add(new Supplier(2, "Jane", "123 Fake Street"));
		suppliers.add(new Supplier(3, "Jim", "123 Fake Street"));
		employees.add(new Employee(1, "John", 1, 2.00, 1));
		employees.add(new Employee(2, "John", 1, 2.00, 1));
		employees.add(new Employee(3, "Jim", 1, 2.00, 1));
	}
	

	@Test
	public void testCheckCustomerDuplicate() {
		assertTrue(gui.checkCustomerDuplicate(customers, inRange));
	}

	@Test
	public void testCheckSupplierDuplicate() {
		assertTrue(gui.checkSupplierDuplicate(suppliers, inRange));
	}

	@Test
	public void testCheckEmployeeDuplicate() {
		assertTrue(gui.checkEmployeeDuplicate(employees, inRange));
	}

	@Test
	public void testEmpIDPopulate() {
		gui.empIDPopulate(combo);
		combo.setSelectedIndex(0);
		assertNotNull(combo.getSelectedItem());
		combo.setSelectedIndex(0);
		assertEquals(combo.getSelectedItem(), "Select");
	}

	@Test
	public void testEmpNamePopulate() {
		gui.empNamePopulate(combo);
		combo.setSelectedIndex(0);
		assertNotNull(combo.getSelectedIndex());
		combo.setSelectedIndex(0);
		assertEquals(combo.getSelectedItem(), "John");
	}

	@Test
	public void testCustIdPopulate() {
		gui.empIDPopulate(combo);
		combo.setSelectedIndex(0);
		assertNotNull(combo.getSelectedItem());
		combo.setSelectedIndex(0);
		assertEquals(combo.getSelectedItem(), "Select");
	}

	@Test
	public void testCustNamePopulate() {
		gui.custNamePopulate(combo);
		combo.setSelectedIndex(0);
		assertNotNull(combo.getSelectedItem());
		combo.setSelectedIndex(0);
		assertEquals(combo.getSelectedItem(), "Select");
	}

	@Test
	public void testSuppIdPopulate() {
		gui.suppIdPopulate(combo);
		combo.setSelectedIndex(0);
		assertNotNull(combo.getSelectedItem());
		combo.setSelectedIndex(0);
		assertEquals(combo.getSelectedItem(), "Select");
	}

	@Test
	public void testSuppNamePopulate() {
		gui.suppNamePopulate(combo);
		combo.setSelectedIndex(0);
		assertNotNull(combo.getSelectedItem());
		combo.setSelectedIndex(0);
		assertEquals(combo.getSelectedItem(), "Select");
	}
	
	@Test
	public void testVerifyInvoiceID() {
		int a = gui.verifyInvoiceID(1001);
		int b = gui.verifyInvoiceID(1);
		assertEquals(a,1);
		assertEquals(b,2);
	}
}