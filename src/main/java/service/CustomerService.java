package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CustomerDAO;
import entity.Customer;


public class CustomerService {
    private CustomerDAO customerDAO;

    public CustomerService() {
    	Connection connection = databseConnection.DBUtil.getConnection();
    	customerDAO = new CustomerDAO(connection);
    }

    public void createCustomer(Customer customer) {
        try {
            customerDAO.createCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomerById(int customerId) {
        try {
            return customerDAO.getCustomerById(customerId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Customer> getAllCustomers() {
        try {
            return customerDAO.getAllCustomers();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateCustomer(Customer customer) {
        try {
            customerDAO.updateCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int customerId) {
        try {
            customerDAO.deleteCustomer(customerId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
