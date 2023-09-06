package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import dao.BookingDAO;
import entity.Booking;

public class BookingService {
    private BookingDAO bookingDAO;

    public BookingService() {
    	Connection connection = databseConnection.DBUtil.getConnection();
        bookingDAO = new BookingDAO(connection);
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
