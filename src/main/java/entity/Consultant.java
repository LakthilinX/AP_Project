package entity;

public class Consultant {
	
	private int ConsultantId;
	private String Fname;
	private String Lname;
	private int MNumber;
	private String Email;
	public Consultant(int consultantId, String fname, String lname, int mNumber, String email) {
		ConsultantId = consultantId;
		Fname = fname;
		Lname = lname;
		MNumber = mNumber;
		Email = email;
	}
	public Consultant(String fname, String lname, int mNumber, String email) {
		Fname = fname;
		Lname = lname;
		MNumber = mNumber;
		Email = email;
	}
	public int getConsultantId() {
		return ConsultantId;
	}
	public void setConsultantId(int consultantId) {
		ConsultantId = consultantId;
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
