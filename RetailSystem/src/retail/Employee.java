package retail;

import java.util.ArrayList;
//Hannah
//Hi Hanna form marc

public class Employee {
    private int employeeId;
    private String employeeName;
    private int access;
    private double salary;
    private int password;
    
    public Employee(int employeeId, String employeeName, int access,
            double salary, int password) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.access = access;
        this.salary = salary;
        this.password=password;
    }
    public Employee(){
    	
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public int getAccess() {
        return access;
    }
    public void setAccess(int access) {
        this.access = access;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public int getPassword() {
        return password;
    }
    public void setPassword(int password) {
        this.password = password;
    }
    public double monthlySalary(ArrayList<Employee> employees){
    	double salaryPerMonth = 0.00;
    	double totalSalaries = 0.00;
    	for(Employee employee: employees){
    		salaryPerMonth = employee.getSalary() / 12;
    		totalSalaries = totalSalaries + salaryPerMonth;
    	}
    	return totalSalaries;
    }
	//method to verify login
	public int verifyLogin(ArrayList<Employee> employees, int id, int password) {
	int count = 0;
	int count1 = 0;
	int login = 0;

	for(Employee employee: employees){
		if(id == employee.getEmployeeId()){
			count++;
			if(employee.getAccess() == 0){
				login = 1;
			}
			if(employee.getAccess() == 1){
				login =2;
			}
			if(password == employee.getPassword()){
				count1++;
			}
			if(count1 == 0){
				login = 3;
			}
		}
	}
	if(count == 0){
		login = 4;
	}
	return login;
}
     
}
