package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import entity.Admin;
import service.AdminService;
import validator.Validate;


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
	                login(request, response);
	                break;
                case "create":
                    createAdmin(request, response);
                    break;
                case "createView":
                	createView(request, response);
                    break;
                case "update":
                    updateAdmin(request, response);
                    break;
                case "delete":
                    deleteAdmin(request, response);
                    break;
                case "list":
                    listAdmins(request, response);
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
            }
        }
	}
	
	private void createView(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("NewUser.jsp").forward(request, response);
	}
	
	private void listAdmins(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<Admin> admins = adminService.getAllAdmin();
		request.setAttribute("admins", admins);
        request.getRequestDispatcher("ListUser.jsp").forward(request, response);
	}

	private void deleteAdmin(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void updateAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int adminId = Integer.parseInt(request.getParameter("adminId"));
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        int mNumber = Integer.parseInt(request.getParameter("mNumber"));
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Admin updatedAdmin = new Admin(adminId, fname, lname, mNumber, email, username, password);
        
        Validate<Admin> validator = new Validate();
        List<String> errors = validator.validate(updatedAdmin);
        AdminDAO adminDAO = new AdminDAO();
        
        if(!errors.isEmpty()) {
        	request.setAttribute("errors", errors);
            request.getRequestDispatcher("NewUser.jsp").forward(request, response);
        }
        else {
        	boolean success = adminDAO.updateAdmin(updatedAdmin);
        	 response.sendRedirect("admin_list.jsp");
        }
            response.getWriter().write("Failed to update admin.");
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
        String fname = request.getParameter("Fname");
        String lname = request.getParameter("Lname");
        int mNumber = Integer.parseInt(request.getParameter("MNumber"));
        String email = request.getParameter("email");
        String username = request.getParameter("UserName");
        String password = request.getParameter("Password");

        Admin newAdmin = new Admin(fname, lname, mNumber, email, username, password);
        
        Validate<Admin> validator = new Validate();
        List<String> errors = validator.validate(newAdmin);
        
        AdminDAO adminDAO = new AdminDAO();
        
        if(!errors.isEmpty()) {
        	request.setAttribute("errors", errors);
            request.getRequestDispatcher("NewUser.jsp").forward(request, response);
        }
        else {
        	adminDAO.insertAdmin(newAdmin);
            response.sendRedirect("AdminServlet?action=list");
        }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
