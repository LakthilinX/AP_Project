package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Booking;
import service.BookingService;

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookingService bookingService;

    public void init() {
      
        bookingService = new BookingService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action == null) {
            action = "list"; 
        }

        switch (action) {
            case "list":
                listBookings(request, response);
                break;
            case "view":
                viewBooking(request, response);
                break;
            case "edit":
                editBookingForm(request, response);
                break;
            case "delete":
                deleteBooking(request, response);
                break;
            case "create":
                createBooking(request, response);
                break;
            case "update":
                updateBooking(request, response);
                break;
            default:
                listBookings(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doGet(request, response);
    }

    private void listBookings(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Booking> bookings = bookingService.getAllBookings();
        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("list-bookings.jsp").forward(request, response);
    }

    private void viewBooking(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bookingId = Integer.parseInt(request.getParameter("bookingId"));
        Booking booking = bookingService.getBookingById(bookingId);
        request.setAttribute("booking", booking);
        request.getRequestDispatcher("view-booking.jsp").forward(request, response);
    }

    private void editBookingForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bookingId = Integer.parseInt(request.getParameter("bookingId"));
        Booking booking = bookingService.getBookingById(bookingId);
        request.setAttribute("booking", booking);
        request.getRequestDispatcher("edit-booking.jsp").forward(request, response);
    }

    private void createBooking(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String dateStr = request.getParameter("date");
        Date date = Date.valueOf(dateStr); 
        String jtype = request.getParameter("jtype");

        Booking newBooking = new Booking(customerId, date, jtype);
        bookingService.createBooking(newBooking);

        response.sendRedirect("BookingServlet?action=list");
    }

    private void updateBooking(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bookingId = Integer.parseInt(request.getParameter("bookingId"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String dateStr = request.getParameter("date");
        Date date = Date.valueOf(dateStr); 
        String jtype = request.getParameter("jtype");

        Booking updatedBooking = new Booking(bookingId, customerId, date, jtype);
        bookingService.updateBooking(updatedBooking);

        response.sendRedirect("BookingServlet?action=list");
    }

    private void deleteBooking(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bookingId = Integer.parseInt(request.getParameter("bookingId"));
        bookingService.deleteBooking(bookingId);

        response.sendRedirect("BookingServlet?action=list");
    }
}
