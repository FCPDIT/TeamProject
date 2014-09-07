package retail;

public class Supplier {
	
	private String name;
	private int id;
	private String address;
	private String email;
	private int phone;
	private int daysToDeliver;

	public Supplier(int id, String name, String address, String email, int phone) {
		
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.daysToDeliver = 28;
	}
	
	public Supplier(int id, String name, String address){
		
		this.id = id;
		this.name = name;
		this.address = address;
		this.daysToDeliver = 28;
	}
	
public Supplier(int id, String name, String address, String email){
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.daysToDeliver = 28;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getDaysToDeliver() {
		return daysToDeliver;
	}

	public void setDaysToDeliver(int daysToDeliver) {
		this.daysToDeliver = daysToDeliver;
	}

	
}

