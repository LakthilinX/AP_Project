package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Admin;
import entity.Consultant;
import service.ConsultantService;
import validator.Validate;

@WebServlet("/ConsultantServlet")
public class ConsultantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ConsultantService consultantService;

    public void init() {
        // Initialize the ConsultantService
        consultantService = new ConsultantService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action == null) {
            action = "list"; // Default action to list consultants
        }

        switch (action) {
            case "list":
                listConsultants(request, response);
                break;
            case "CtrateView":
            	CtrateView(request, response);
                break;
            case "Ctrate":
            	Ctrate(request, response);
                break;
            case "view":
                viewConsultant(request, response);
                break;
            case "edit":
                editConsultantForm(request, response);
                break;
            case "delete":
                deleteConsultant(request, response);
                break;
            case "update":
                updateConsultant(request, response);
                break;
            default:
                listConsultants(request, response);
        }
    }

    private void Ctrate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	
        String fname = request.getParameter("Fname");
        String lname = request.getParameter("Lname");
        int mNumber = Integer.parseInt(request.getParameter("MNumber"));
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        Consultant Consultant = new Consultant( fname, lname, mNumber, email, country);
        
        Validate<Consultant> validator = new Validate();
        List<String> errors = validator.validate(Consultant);
        
        if(!errors.isEmpty()) {
        	request.setAttribute("errors", errors);
            request.getRequestDispatcher("NewConsultent.jsp").forward(request, response);
        }
        else {
        	 consultantService.createConsultant(Consultant);
             response.sendRedirect("ConsultantServlet?action=list");
        }
        
       
		
	}

	private void CtrateView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        request.getRequestDispatcher("NewConsultent.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void listConsultants(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Consultant> consultants = consultantService.getAllConsultants();
        request.setAttribute("consultants", consultants);
        request.getRequestDispatcher("ListConsultant.jsp").forward(request, response);
    }

    private void viewConsultant(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int consultantId = Integer.parseInt(request.getParameter("consultantId"));
        Consultant consultant = consultantService.getConsultantById(consultantId);
        request.setAttribute("consultant", consultant);
        request.getRequestDispatcher("view-consultant.jsp").forward(request, response);
    }

    private void editConsultantForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int consultantId = Integer.parseInt(request.getParameter("consultantId"));
        Consultant consultant = consultantService.getConsultantById(consultantId);
        request.setAttribute("consultant", consultant);
        request.getRequestDispatcher("edit-consultant.jsp").forward(request, response);
    }

    private void updateConsultant(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int consultantId = Integer.parseInt(request.getParameter("consultantId"));
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        int mNumber = Integer.parseInt(request.getParameter("mNumber"));
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        Consultant updatedConsultant = new Consultant(consultantId, fname, lname, mNumber, email, country);
        
        Validate<Consultant> validator = new Validate();
        List<String> errors = validator.validate(updatedConsultant);
        
        if(!errors.isEmpty()) {
        	request.setAttribute("errors", errors);
            request.getRequestDispatcher("NewConsultent.jsp").forward(request, response);
        }
        else {
        	consultantService.updateConsultant(updatedConsultant);
            response.sendRedirect("ConsultantServlet?action=list");
        }
        
        
    }

    private void deleteConsultant(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int consultantId = Integer.parseInt(request.getParameter("consultantId"));
        consultantService.deleteConsultant(consultantId);

        response.sendRedirect("ConsultantServlet?action=list");
    }
}
