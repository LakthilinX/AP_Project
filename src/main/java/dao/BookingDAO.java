package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Booking;

public class BookingDAO {
    private Connection connection;

    public BookingDAO(Connection connection) {
        this.connection = connection;
    }

    public void createBooking(Booking booking) throws SQLException {
        String query = "INSERT INTO booking (CustomerId, DATE, Jtype) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, booking.getCustomerId());
            statement.setDate(2, booking.getDATE());
            statement.setString(3, booking.getJtype());
            statement.executeUpdate();
        }
    }

    public Booking getBookingById(int bookingId) throws SQLException {
        String query = "SELECT * FROM booking WHERE BookingId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, bookingId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return createBookingFromResultSet(resultSet);
                }
                return null;
            }
        }
    }

    public List<Booking> getAllBookings() throws SQLException {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM booking";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                bookings.add(createBookingFromResultSet(resultSet));
            }
        }
        return bookings;
    }

    public void updateBooking(Booking booking) throws SQLException {
        String query = "UPDATE booking SET CustomerId = ?, DATE = ?, Jtype = ? WHERE BookingId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, booking.getCustomerId());
            statement.setDate(2, booking.getDATE());
            statement.setString(3, booking.getJtype());
            statement.setInt(4, booking.getBookingId());
            statement.executeUpdate();
        }
    }

    public void deleteBooking(int bookingId) throws SQLException {
        String query = "DELETE FROM booking WHERE BookingId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, bookingId);
            statement.executeUpdate();
        }
    }

    private Booking createBookingFromResultSet(ResultSet resultSet) throws SQLException {
        int bookingId = resultSet.getInt("BookingId");
        int customerId = resultSet.getInt("CustomerId");
        Date date = resultSet.getDate("DATE");
        String jtype = resultSet.getString("Jtype");
        return new Booking(bookingId, customerId, date, jtype);
    }
}
