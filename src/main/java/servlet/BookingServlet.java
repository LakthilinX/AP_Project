package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Admin;
import entity.Booking;
import entity.Consultant;
import entity.Customer;
import service.BookingService;
import validator.Validate;

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
        	case "new":
            NewBookings(request, response);
            break;
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
            case "createVeiw":
            	createVeiw(request, response);
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
        List<Booking> bookings = bookingService.getAllBookingsWithname();
        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("Listbooking.jsp").forward(request, response);
    }
    
    private void NewBookings(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Customer> Customers = bookingService.getAllCustomer();
        List<Consultant> Consultants = bookingService.getAllConsultant();
        request.setAttribute("Customers", Customers);
        request.setAttribute("Consultants", Consultants);
        request.getRequestDispatcher("NewBooking.jsp").forward(request, response);
    }
    
    private void createVeiw(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Booking> bookings = bookingService.getAllBookingsWithname();
        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("Listbooking.jsp").forward(request, response);
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
        int customerId = Integer.parseInt(request.getParameter("Customer"));
        int Consultantid = Integer.parseInt(request.getParameter("Consultant"));
        String dateStr = request.getParameter("date");
        Date date = Date.valueOf(dateStr); 
        String jtype = request.getParameter("job");
        Booking newBooking = new Booking(customerId, date, jtype, Consultantid);
        
        Validate<Booking> validator = new Validate();
        List<String> errors = validator.validate(newBooking);
        
        if(!errors.isEmpty()) {
        	request.setAttribute("errors", errors);
            request.getRequestDispatcher("NewBooking.jsp").forward(request, response);
        }
        else {
        	bookingService.createBooking(newBooking);
            response.sendRedirect("BookingServlet?action=list");
        }

    }

    private void updateBooking(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bookingId = Integer.parseInt(request.getParameter("bookingId"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String dateStr = request.getParameter("date");
        Date date = Date.valueOf(dateStr); 
        String jtype = request.getParameter("jtype");
        Booking updatedBooking = new Booking(bookingId, customerId, date, jtype);
        
        Validate<Booking> validator = new Validate();
        List<String> errors = validator.validate(updatedBooking);
        
        if(!errors.isEmpty()) {
        	request.setAttribute("errors", errors);
            request.getRequestDispatcher("NewBooking.jsp").forward(request, response);
        }
        else {
        	 bookingService.updateBooking(updatedBooking);
             response.sendRedirect("BookingServlet?action=list");
        }
        
       
    }

    private void deleteBooking(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bookingId = Integer.parseInt(request.getParameter("bookingId"));
        bookingService.deleteBooking(bookingId);

        response.sendRedirect("BookingServlet?action=list");
    }
}
