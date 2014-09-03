package retail;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class RetailGUITest {
	
	RetailGUI gui = new RetailGUI();
	int inRange = 1;
	int outRange = 3;
	String str =  "";
	ArrayList<Customer> customers = new ArrayList<Customer>();
	ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	ArrayList<Employee> employees = new ArrayList<Employee>();
	JComboBox<String> combo = new JComboBox<String>();
	
	
	Customer cust = new Customer(1, "John", "123 Fake Street");
	Customer cust1 = new Customer(2, "Jane", "123 Fake Street");
	
	Supplier supp = new Supplier(1, "John", "123 Fake Street");
	Supplier supp1 = new Supplier(2, "Jane", "123 Fake Street");
	
	Employee emp = new Employee(1, "John", 1, 2.00, 1);
	Employee emp1 = new Employee(2, "Jane", 1, 2.00, 1);

	@Test
	public void testCheckCustomerDuplicate() {
		customers.add(cust);
		customers.add(cust1);
		assertFalse(gui.checkCustomerDuplicate(customers, inRange));
		assertTrue(gui.checkCustomerDuplicate(customers, outRange));
	}

	@Test
	public void testCheckSupplierDuplicate() {
		suppliers.add(supp);
		suppliers.add(supp1);
		assertFalse(gui.checkSupplierDuplicate(suppliers, inRange));
		assertTrue(gui.checkSupplierDuplicate(suppliers, outRange));
	}

	@Test
	public void testCheckEmployeeDuplicate() {
		employees.add(emp);
		employees.add(emp1);
		assertFalse(gui.checkEmployeeDuplicate(employees, inRange));
		assertTrue(gui.checkEmployeeDuplicate(employees, outRange));
	}

	@Test
	public void testEmpIDPopulate() {
		gui.empIDPopulate(combo);
		combo.setSelectedItem(1);
		assertNotNull(combo.getSelectedIndex());
		combo.addItem(null);
		combo.setSelectedItem(3);
		assertNotNull(combo.getSelectedItem());
		combo.setSelectedItem(0);
		assertEquals(combo.getSelectedItem(), customers.get(1));
	}

	@Test
	public void testEmpNamePopulate() {
		gui.empNamePopulate();
		combo.setSelectedItem(1);
		assertNotNull(combo.getSelectedIndex());
		combo.addItem(null);
		combo.setSelectedItem(3);
		assertNotNull(combo.getSelectedItem());
		combo.setSelectedItem(0);
		assertEquals(combo.getSelectedItem(), employees.get(1));
	}

	@Test
	public void testCustIdPopulate() {
		gui.empIDPopulate(combo);
		combo.setSelectedItem(1);
		assertNotNull(combo.getSelectedIndex());
		combo.setSelectedItem(3);
		assertNotNull(combo.getSelectedItem());
		combo.setSelectedItem(0);
		assertEquals(combo.getSelectedItem(), customers.get(1));
	}

	@Test
	public void testCustNamePopulate() {
		gui.custNamePopulate(combo);
		combo.setSelectedItem(1);
		assertNotNull(combo.getSelectedIndex());
		combo.addItem(null);
		combo.setSelectedItem(3);
		assertNotNull(combo.getSelectedItem());
		combo.setSelectedItem(0);
		assertEquals(combo.getSelectedItem(), customers.get(1));
	}

	@Test
	public void testSuppIdPopulate() {
		gui.suppIdPopulate(combo);
		combo.setSelectedItem(1);
		assertNotNull(combo.getSelectedIndex());
		combo.addItem(null);
		combo.setSelectedItem(3);
		assertNotNull(combo.getSelectedItem());
		combo.setSelectedItem(0);
		assertEquals(combo.getSelectedItem(), suppliers.get(1));
	}

	@Test
	public void testSuppNamePopulate() {
		gui.suppNamePopulate(combo);
		combo.setSelectedItem(1);
		assertNotNull(combo.getSelectedIndex());
		combo.addItem(null);
		combo.setSelectedItem(3);
		assertNotNull(combo.getSelectedItem());
		combo.setSelectedItem(0);
		assertEquals(combo.getSelectedItem(), suppliers.get(1));
	}

}
