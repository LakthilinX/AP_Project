package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BookingDAO;
import dao.ConsultantDAO;
import dao.CustomerDAO;
import entity.Booking;
import entity.Consultant;
import entity.Customer;


public class indexService {

	private ConsultantDAO consultantDAO;
	private CustomerDAO customerDAO;
	private BookingDAO bookingDAO;

    public indexService() {
        Connection connection = databseConnection.DBUtil.getConnection();
        consultantDAO = new ConsultantDAO(connection);
        customerDAO = new CustomerDAO(connection);
        bookingDAO = new BookingDAO(connection);
    }
    
    public void createCustomer(Customer customer) {
        try {
            customerDAO.createCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void createBooking(Booking booking) {
        try {
            bookingDAO.createBooking(booking);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Consultant> getConsultantByCountry(String country) {
        try {
            return consultantDAO.getConsultantByCountry(country);
        } catch (SQLException e) {
            
            e.printStackTrace();
            return null;
        }
    }
    
    public int getLastId() {
    	try {
            return customerDAO.getLastID();
        } catch (SQLException e) {
            
            e.printStackTrace();
            return -1;
        }
		
	}
}
