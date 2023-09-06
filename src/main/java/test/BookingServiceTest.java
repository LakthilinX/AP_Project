package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dao.BookingDAO;
import dao.ConsultantDAO;
import dao.CustomerDAO;
import entity.Booking;
import entity.Consultant;
import entity.Customer;
import service.BookingService;

public class BookingServiceTest {

    @Mock
    private BookingDAO bookingDAO;

    @Mock
    private ConsultantDAO consultantDAO;

    @Mock
    private CustomerDAO customerDAO;

    private BookingService bookingService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bookingService = new BookingService();
        bookingService.setBookingDAO(bookingDAO);
        bookingService.setConsultantDAO(consultantDAO);
        bookingService.setCustomerDAO(customerDAO);
    }

    @Test
    public void testCreateBooking() throws SQLException {
        Booking booking = new Booking(1,  Date.valueOf("2023-03-17"), "Dev", 1);

        bookingService.createBooking(booking);

        verify(bookingDAO).createBooking(booking);
    }

    @Test
    public void testGetBookingById() throws SQLException {
        int bookingId = 123;
        Booking expectedBooking = new Booking(123,  Date.valueOf("2023-03-17"), "Dev", 1);
        when(bookingDAO.getBookingById(bookingId)).thenReturn(expectedBooking);

        Booking actualBooking = bookingService.getBookingById(bookingId);

        assertEquals(expectedBooking, actualBooking);
    }

    @Test
    public void testGetAllBookings() throws SQLException {
        List<Booking> expectedBookings = new ArrayList<>();
        when(bookingDAO.getAllBookings()).thenReturn(expectedBookings);

        List<Booking> actualBookings = bookingService.getAllBookings();

        assertEquals(expectedBookings, actualBookings);
    }

    @Test
    public void testUpdateBooking() throws SQLException {
        Booking booking = new Booking(1,  Date.valueOf("2023-03-17"), "Dev", 1);

        bookingService.updateBooking(booking);

        verify(bookingDAO).updateBooking(booking);
    }

    @Test
    public void testDeleteBooking() throws SQLException {
        int bookingId = 123;

        bookingService.deleteBooking(bookingId);

        verify(bookingDAO).deleteBooking(bookingId);
    }

    @Test
    public void testGetAllCustomer() throws SQLException {
        List<Customer> expectedCustomers = new ArrayList<>();
        when(customerDAO.getAllCustomers()).thenReturn(expectedCustomers);

        List<Customer> actualCustomers = bookingService.getAllCustomer();

        assertEquals(expectedCustomers, actualCustomers);
    }

    @Test
    public void testGetAllConsultant() throws SQLException {
        List<Consultant> expectedConsultants = new ArrayList<>();
        when(consultantDAO.getAllConsultants()).thenReturn(expectedConsultants);

        List<Consultant> actualConsultants = bookingService.getAllConsultant();

        assertEquals(expectedConsultants, actualConsultants);
    }

}
