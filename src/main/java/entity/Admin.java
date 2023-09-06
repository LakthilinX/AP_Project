package entity;

public class Admin {
	
	private int AdminId;
	private String Fname;
	private String Lname;
	private int MNumber; 
	private String Email;
	private String username;
	private String Password;
	public Admin(int adminId, String fname, String lname, int mNumber, String email, String username, String password) {
		AdminId = adminId;
		Fname = fname;
		Lname = lname;
		MNumber = mNumber;
		Email = email;
		this.username = username;
		Password = password;
	}
	public Admin(String fname, String lname, int mNumber, String email, String username, String password) {
		Fname = fname;
		Lname = lname;
		MNumber = mNumber;
		Email = email;
		this.username = username;
		Password = password;
	}
	public int getAdminId() {
		return AdminId;
	}
	public void setAdminId(int adminId) {
		AdminId = adminId;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	


}
