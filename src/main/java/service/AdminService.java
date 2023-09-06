package service;

import java.util.List;

import dao.AdminDAO;
import entity.Admin;

public class AdminService {

    private AdminDAO adminDAO;

    public AdminService() {
        adminDAO = new AdminDAO(); // Initialize the DAO in the service constructor
    }

    public boolean createAdmin(String fname, String lname, int mNumber, String email, String username, String password) {
        Admin newAdmin = new Admin(fname, lname, mNumber, email, username, password);
        return adminDAO.insertAdmin(newAdmin);
    }

    public boolean updateAdmin(int adminId, String fname, String lname, int mNumber, String email, String username, String password) {
        Admin updatedAdmin = new Admin(adminId, fname, lname, mNumber, email, username, password);
        return adminDAO.updateAdmin(updatedAdmin);
    }

    public Admin login(String username, String password) {
        return adminDAO.login(username, password);
    }
    
    public List<Admin> getAllAdmin() {
    	
		return adminDAO.getAllAdmins();
	}
}

    
