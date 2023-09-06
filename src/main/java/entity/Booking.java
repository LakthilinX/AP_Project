package entity;

import java.sql.Date;

public class Booking {
	
	private int BookingId;
	private int ConsultantId;
	private int CustomerId;
	private Date DATE;
	private String Jtype;
	private String Fname;
	private String Lname;
	private String ConFname;
	private String ConLname;

	

	public Booking(int bookingId, int consultantId, int customerId, Date dATE, String jtype, String fname, String lname,
			String conFname, String conLname) {
		BookingId = bookingId;
		ConsultantId = consultantId;
		CustomerId = customerId;
		DATE = dATE;
		Jtype = jtype;
		Fname = fname;
		Lname = lname;
		ConFname = conFname;
		ConLname = conLname;
	}



	public Booking(int bookingId, int customerId, Date dATE, String jtype) {
		BookingId = bookingId;
		CustomerId = customerId;
		DATE = dATE;
		Jtype = jtype;
	}
	
	
	
	public Booking(int bookingId, int consultantId, int customerId, Date dATE, String jtype, String fname,
			String lname) {
		BookingId = bookingId;
		ConsultantId = consultantId;
		CustomerId = customerId;
		DATE = dATE;
		Jtype = jtype;
		Fname = fname;
		Lname = lname;
	}
	
	

	public Booking( int customerId, Date dATE, String jtype,int consultantId) {
		ConsultantId = consultantId;
		CustomerId = customerId;
		DATE = dATE;
		Jtype = jtype;
	}

	public Booking(int customerId, Date dATE, String jtype) {
		CustomerId = customerId;
		DATE = dATE;
		Jtype = jtype;
	}
	public int getBookingId() {
		return BookingId;
	}
	public void setBookingId(int bookingId) {
		BookingId = bookingId;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public Date getDATE() {
		return DATE;
	}
	public void setDATE(Date dATE) {
		DATE = dATE;
	}
	public String getJtype() {
		return Jtype;
	}
	public void setJtype(String jtype) {
		Jtype = jtype;
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

	public int getConsultantId() {
		return ConsultantId;
	}

	public void setConsultantId(int consultantId) {
		ConsultantId = consultantId;
	}
	public String getConFname() {
		return ConFname;
	}
	public void setConFname(String conFname) {
		ConFname = conFname;
	}
	public String getConLname() {
		return ConLname;
	}

	public void setConLname(String conLname) {
		ConLname = conLname;
	}
	
	
	
}
