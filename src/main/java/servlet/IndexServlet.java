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
import entity.Consultant;
import entity.Customer;
import service.indexService;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private indexService indexService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        indexService = new indexService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
            	case "loadConsalt":
            		loadConsalt(request, response);
	                break;
            	case "loadJob":
            		loadJob(request, response);
	                break;
            	case "createCustomerIndex":
            		createCustomer(request, response);
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
            }
        }
	}
	
	private void createCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fname = request.getParameter("inputFname");
        String lname = request.getParameter("inputLname");
        int mNumber = Integer.parseInt(request.getParameter("inputMnumber"));
        String email = request.getParameter("inputEmail");

        String dateStr = request.getParameter("date");
        Date date = Date.valueOf(dateStr); 
        String jtype = request.getParameter("jtype");

        Customer newCustomer = new Customer(fname, lname, mNumber, email);
        indexService.createCustomer(newCustomer);
        
        int cusid = indexService.getLastId();
        
        Booking booking = new Booking(cusid, date, jtype);
        indexService.createBooking(booking);
        
        response.sendRedirect("index.jsp");
    }

	private void loadJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Country = request.getParameter("country");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		request.setAttribute("Country", Country);
		request.setAttribute("ConsID", id);
		request.setAttribute("name", name);
		request.getRequestDispatcher("jobs.jsp").forward(request, response);
		
	}
	
	

	private void loadConsalt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Country = request.getParameter("country");
		
		List<Consultant> consultantsList = indexService.getConsultantByCountry(Country);
		request.setAttribute("consultants", consultantsList);
		request.getRequestDispatcher("cons.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
