package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import dao.AdminDAO;
import entity.Admin;
import service.AdminService;


@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService adminService;
       
  
    public AdminServlet() {
        super();
        adminService = new AdminService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
            	case "login":
	                // Handle create operation
	                login(request, response);
	                break;
                case "create":
                    // Handle create operation
                    createAdmin(request, response);
                    break;
                case "update":
                    // Handle update operation
                    updateAdmin(request, response);
                    break;
                case "delete":
                    // Handle delete operation
                    deleteAdmin(request, response);
                    break;
                case "list":
                    // Handle list operation
                    listAdmins(request, response);
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
            }
        }
	}
	
	private void listAdmins(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void deleteAdmin(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void updateAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int adminId = Integer.parseInt(request.getParameter("adminId"));
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        int mNumber = Integer.parseInt(request.getParameter("mNumber"));
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Admin updatedAdmin = new Admin(adminId, fname, lname, mNumber, email, username, password);

        AdminDAO adminDAO = new AdminDAO();
        boolean success = adminDAO.updateAdmin(updatedAdmin);

        if (success) {
            response.sendRedirect("admin_list.jsp"); // Redirect to admin list page
        } else {
            // Handle error
            response.getWriter().write("Failed to update admin.");
        }
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {
		String username = request.getParameter("Username");
        String password = request.getParameter("Password");

        Admin admin = adminService.login(username, password);
        //System.out.println(admin.getFname());
        if (admin != null) {
            // Successful login
            request.getSession().setAttribute("loggedInAdmin", admin);
            response.sendRedirect("dash.jsp");
        } else {
            // Failed login
        	
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
	}
	
	private void createAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        int mNumber = Integer.parseInt(request.getParameter("mNumber"));
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Create Admin object
        Admin newAdmin = new Admin(fname, lname, mNumber, email, username, password);

        // Insert into database
        AdminDAO adminDAO = new AdminDAO();
        boolean success = adminDAO.insertAdmin(newAdmin);

        if (success) {
            response.sendRedirect("admin_list.jsp"); // Redirect to admin list page
        } else {
            // Handle error
            response.getWriter().write("Failed to create admin.");
        }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
