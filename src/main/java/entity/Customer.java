package entity;

public class Customer {
	
	private int CustomerId;
	private String Fname;
	private String Lname;
	private int MNumber;
	private String Email;
	
	public Customer(int customerId, String fname, String lname, int mNumber, String email) {
		CustomerId = customerId;
		Fname = fname;
		Lname = lname;
		MNumber = mNumber;
		Email = email;
	}
	public Customer(String fname, String lname, int mNumber, String email) {
		Fname = fname;
		Lname = lname;
		MNumber = mNumber;
		Email = email;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public int getMNumber() {
		return MNumber;
	}
	public void setMNumber(int mNumber) {
		MNumber = mNumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
}
