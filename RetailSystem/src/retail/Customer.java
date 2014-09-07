package retail;
// Test Commit James
//Test Commit Marc


public class Customer {
	
	//Variables
	private int custId;
	private String custName;
	private String custAddress;
	private String custEmail;
	private int custTelephone;
	
	//Constructors
	public Customer(int custId, String custName, String custAddress,
			String custEmail, int custTelephone) {
		this.custId = custId;
		this.custName = custName;
		this.custAddress = custAddress;
		this.custEmail = custEmail;
		this.custTelephone = custTelephone;
	}

	public Customer(int custId, String custName, String custAddress) {
		this.custId = custId;
		this.custName = custName;
		this.custAddress = custAddress;
	}

	//Getter and setters
	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public int getCustTelephone() {
		return custTelephone;
	}

	public void setCustTelephone(int custTelephone) {
		this.custTelephone = custTelephone;
	}
	
	
	
	
	
	
	
	

}
