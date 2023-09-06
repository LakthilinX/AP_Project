package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Consultant;

public class ConsultantDAO {
    private Connection connection;

    public ConsultantDAO(Connection connection) {
        this.connection = connection;
    }

    public void createConsultant(Consultant consultant) throws SQLException {
        String query = "INSERT INTO consultant (Fname, Lname, MNumber, Email, Country) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, consultant.getFname());
            statement.setString(2, consultant.getLname());
            statement.setInt(3, consultant.getMNumber());
            statement.setString(4, consultant.getEmail());
            statement.setString(5, consultant.getCountry());
            statement.executeUpdate();
        }
    }

    public Consultant getConsultantById(int consultantId) throws SQLException {
        String query = "SELECT * FROM consultant WHERE ConsultantId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, consultantId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return createConsultantFromResultSet(resultSet);
                }
                return null;
            }
        }
    }
    
    public List<Consultant> getConsultantByCountry(String Country) throws SQLException {
    	
    	List<Consultant> consultants = new ArrayList<>();
        String query = "SELECT * FROM consultant WHERE Country = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, Country);
        ResultSet resultSet = statement.executeQuery() ;
        while (resultSet.next()) {
              consultants.add(createConsultantFromResultSet(resultSet));
        }
           return consultants;
    }

    public List<Consultant> getAllConsultants() throws SQLException {
        List<Consultant> consultants = new ArrayList<>();
        String query = "SELECT * FROM consultant";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                consultants.add(createConsultantFromResultSet(resultSet));
            }
        }
        return consultants;
    }

    public void updateConsultant(Consultant consultant) throws SQLException {
        String query = "UPDATE consultant SET Fname = ?, Lname = ?, MNumber = ?, Email = ?, Country = ? WHERE ConsultantId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, consultant.getFname());
            statement.setString(2, consultant.getLname());
            statement.setInt(3, consultant.getMNumber());
            statement.setString(4, consultant.getEmail());
            statement.setString(5, consultant.getCountry());
            statement.setInt(6, consultant.getConsultantId());
            statement.executeUpdate();
        }
    }

    public void deleteConsultant(int consultantId) throws SQLException {
        String query = "DELETE FROM consultant WHERE ConsultantId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, consultantId);
            statement.executeUpdate();
        }
    }

    private Consultant createConsultantFromResultSet(ResultSet resultSet) throws SQLException {
        int consultantId = resultSet.getInt("ConsultantId");
        String fname = resultSet.getString("Fname");
        String lname = resultSet.getString("Lname");
        int mNumber = resultSet.getInt("MNumber");
        String email = resultSet.getString("Email");
        String country = resultSet.getString("Country");
        return new Consultant(consultantId, fname, lname, mNumber, email, country);
    }
}
