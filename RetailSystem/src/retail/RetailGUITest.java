package retail;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class RetailGUITest {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	RetailGUI gui = new RetailGUI();
	int inRange = 1;
	int outRange = 3;
	String str =  "";
	ArrayList<Customer> customers = new ArrayList<Customer>();
	ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	ArrayList<Employee> employees = new ArrayList<Employee>();
	JComboBox<String> combo = new JComboBox<String>();
	
	@Test
	public void testCreateInvoices() {
		assertEquals(0, customers.size());
		customers.add(new Customer(1, "John", "123 Fake Street"));
		customers.add(new Customer(2, "Jane", "123 Fake Street"));
		assertEquals(2, customers.size());
		assertEquals(0, suppliers.size());
		suppliers.add(new Supplier(1, "John", "123 Fake Street"));
		suppliers.add(new Supplier(2, "Jane", "123 Fake Street"));
		assertEquals(2, suppliers.size());
		assertEquals(0, employees.size());
		employees.add(new Employee(1, "John", 1, 2.00, 1));
		employees.add(new Employee(2, "Jane", 1, 2.00, 1));
		assertEquals(2, employees.size());
	}

	@Test
	public void testCheckCustomerDuplicate() {
		gui.createInvoices();
		assertFalse(gui.checkCustomerDuplicate(customers, inRange));
		assertTrue(gui.checkCustomerDuplicate(customers, outRange));
	}

	@Test
	public void testCheckSupplierDuplicate() {
		gui.createInvoices();
		assertFalse(gui.checkSupplierDuplicate(suppliers, inRange));
		assertTrue(gui.checkSupplierDuplicate(suppliers, outRange));
	}

	@Test
	public void testCheckEmployeeDuplicate() {
		gui.createInvoices();
		assertFalse(gui.checkEmployeeDuplicate(employees, inRange));
		assertTrue(gui.checkEmployeeDuplicate(employees, outRange));
	}

	@Test
	public void testEmpIDPopulate() {
		gui.createInvoices();
		gui.empIDPopulate(combo);
		combo.setSelectedItem(1);
		assertNotNull(combo.getSelectedIndex());
		combo.addItem(null);
		combo.setSelectedItem(3);
		assertNotNull(combo.getSelectedItem());
		combo.setSelectedItem(1);
		assertEquals(combo.getSelectedItem(), customers.get(1));
	}

	@Test
	public void testEmpNamePopulate() {
		gui.createInvoices();
		gui.empNamePopulate();
		combo.setSelectedItem(1);
		assertNotNull(combo.getSelectedIndex());
		combo.addItem(null);
		combo.setSelectedItem(3);
		assertNotNull(combo.getSelectedItem());
		combo.setSelectedItem(01);
		assertEquals(combo.getSelectedItem(), employees.get(1));
	}

	@Test
	public void testCustIdPopulate() {
		gui.createInvoices();
		gui.empIDPopulate(combo);
		combo.setSelectedItem(1);
		assertNotNull(combo.getSelectedIndex());
		combo.setSelectedItem(3);
		assertNotNull(combo.getSelectedItem());
		combo.setSelectedItem(1);
		assertEquals(combo.getSelectedItem(), customers.get(1));
	}

	@Test
	public void testCustNamePopulate() {
		gui.createInvoices();
		gui.custNamePopulate(combo);
		combo.setSelectedItem(1);
		assertNotNull(combo.getSelectedIndex());
		combo.addItem(null);
		combo.setSelectedItem(3);
		assertNotNull(combo.getSelectedItem());
		combo.setSelectedItem(1);
		assertEquals(combo.getSelectedItem(), customers.get(1));
	}

	@Test
	public void testSuppIdPopulate() {
		gui.createInvoices();
		gui.suppIdPopulate(combo);
		combo.setSelectedItem(1);
		assertNotNull(combo.getSelectedIndex());
		combo.addItem(null);
		combo.setSelectedItem(3);
		assertNotNull(combo.getSelectedItem());
		combo.setSelectedItem(1);
		assertEquals(combo.getSelectedItem(), suppliers.get(1));
	}

	@Test
	public void testSuppNamePopulate() {
		gui.createInvoices();
		gui.suppNamePopulate(combo);
		combo.setSelectedItem(1);
		assertNotNull(combo.getSelectedIndex());
		combo.addItem(null);
		combo.setSelectedItem(3);
		assertNotNull(combo.getSelectedItem());
		combo.setSelectedItem(1);
		assertEquals(combo.getSelectedItem(), suppliers.get(1));
	}

}
