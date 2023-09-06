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

public class BookingService {
    private BookingDAO bookingDAO;
    private ConsultantDAO consultantDAO;
    private CustomerDAO customerDAO;

    public BookingService() {
    	Connection connection = databseConnection.DBUtil.getConnection();
        bookingDAO = new BookingDAO(connection);
        consultantDAO = new ConsultantDAO(connection);
        customerDAO = new CustomerDAO(connection);
    }
    
    public List<Customer> getAllCustomer() {
    	try {
            return customerDAO.getAllCustomers();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
	}
    
    public List<Consultant> getAllConsultant() {
    	try {
            return consultantDAO.getAllConsultants();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
	}

    public void createBooking(Booking booking) {
        try {
            bookingDAO.createBooking(booking);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Booking getBookingById(int bookingId) {
        try {
            return bookingDAO.getBookingById(bookingId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Booking> getAllBookings() {
        try {
            return bookingDAO.getAllBookings();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Booking> getAllBookingsWithname() {
        try {
            return bookingDAO.getAllBookingsWithName();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateBooking(Booking booking) {
        try {
            bookingDAO.updateBooking(booking);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBooking(int bookingId) {
        try {
            bookingDAO.deleteBooking(bookingId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
