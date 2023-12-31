package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Admin;
import entity.Customer;
import service.CustomerService;
import validator.Validate;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerService customerService;

    public void init() {
       
        customerService = new CustomerService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action == null) {
            action = "list";
        }

        switch (action) {
        case "list":
            listCustomers(request, response);
            break;
        case "create":
            createCustomer(request, response);
            break;
        case "createView":
            createCustomerView(request, response);
            break;
        
        case "view":
            viewCustomer(request, response);
            break;
        case "edit":
            editCustomerForm(request, response);
            break;
        case "delete":
            deleteCustomer(request, response);
            break;
        default:
            listCustomers(request, response);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doGet(request, response);
    }
    
    
    private void createCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String fname = request.getParameter("Fname");
        String lname = request.getParameter("Lname");
        int mNumber = Integer.parseInt(request.getParameter("MNumber"));
        String email = request.getParameter("email");

        Customer newCustomer = new Customer(fname, lname, mNumber, email);
        
        Validate<Customer> validator = new Validate();
        List<String> errors = validator.validate(newCustomer);
        
        if(!errors.isEmpty()) {
        	request.setAttribute("errors", errors);
            request.getRequestDispatcher("NewCustomer.jsp").forward(request, response);
        }
        else {
        	customerService.createCustomer(newCustomer);
            response.sendRedirect("CustomerServlet?action=list");
        }
    }
    
    private void listCustomers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Customer> customers = customerService.getAllCustomers();
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("ListCustomer.jsp").forward(request, response);
    }

    private void createCustomerView(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("NewCustomer.jsp").forward(request, response);
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        Customer customer = customerService.getCustomerById(customerId);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("view-customer.jsp").forward(request, response);
    }

    private void editCustomerForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        Customer customer = customerService.getCustomerById(customerId);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("edit-customer.jsp").forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        customerService.deleteCustomer(customerId);
        response.sendRedirect("CustomerServlet?action=list");
    }
}
