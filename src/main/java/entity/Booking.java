package entity;

import java.sql.Date;

public class Booking {
	
	private int BookingId;
	private int CustomerId;
	private Date DATE;
	private String Jtype;
	
	public Booking(int bookingId, int customerId, Date dATE, String jtype) {
		BookingId = bookingId;
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
}
