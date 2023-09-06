package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Customer;

public class CustomerDAO {
    private Connection connection;

    public CustomerDAO(Connection connection) {
        this.connection = connection;
    }

    public void createCustomer(Customer customer) throws SQLException {
        String query = "INSERT INTO customer (Fname, Lname, MNumber, Email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, customer.getFname());
            statement.setString(2, customer.getLname());
            statement.setInt(3, customer.getMNumber());
            statement.setString(4, customer.getEmail());
            statement.executeUpdate();
        }
    }

    public Customer getCustomerById(int customerId) throws SQLException {
        String query = "SELECT * FROM customer WHERE CustomerId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, customerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return createCustomerFromResultSet(resultSet);
                }
                return null;
            }
        }
    }

    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customer";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                customers.add(createCustomerFromResultSet(resultSet));
            }
        }
        return customers;
    }
    
    public int getLastID() throws SQLException {
    	int id = -1;
    	 String query = "SELECT CustomerId FROM customer ORDER BY CustomerId DESC LIMIT 1";
    	 PreparedStatement statement = connection.prepareStatement(query);
    	 ResultSet resultSet = statement.executeQuery();
    	 if(resultSet.next()) {
    		id = resultSet.getInt("CustomerId");
    	 }
    	 return id;
    }

    public void updateCustomer(Customer customer) throws SQLException {
        String query = "UPDATE customer SET Fname = ?, Lname = ?, MNumber = ?, Email = ? WHERE CustomerId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, customer.getFname());
            statement.setString(2, customer.getLname());
            statement.setInt(3, customer.getMNumber());
            statement.setString(4, customer.getEmail());
            statement.setInt(5, customer.getCustomerId());
            statement.executeUpdate();
        }
    }

    public void deleteCustomer(int customerId) throws SQLException {
        String query = "DELETE FROM customer WHERE CustomerId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, customerId);
            statement.executeUpdate();
        }
    }

    private Customer createCustomerFromResultSet(ResultSet resultSet) throws SQLException {
        int customerId = resultSet.getInt("CustomerId");
        String fname = resultSet.getString("Fname");
        String lname = resultSet.getString("Lname");
        int mNumber = resultSet.getInt("MNumber");
        String email = resultSet.getString("Email");
        return new Customer(customerId, fname, lname, mNumber, email);
    }
}
