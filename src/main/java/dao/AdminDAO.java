package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import databseConnection.DBUtil;
import entity.Admin;


public class AdminDAO {
    public boolean insertAdmin(Admin admin) {
        String sql = "INSERT INTO admin (Fname, Lname, MNumber, Email, username, Password) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, admin.getFname());
            preparedStatement.setString(2, admin.getLname());
            preparedStatement.setInt(3, admin.getMNumber());
            preparedStatement.setString(4, admin.getEmail());
            preparedStatement.setString(5, admin.getUsername());
            preparedStatement.setString(6, admin.getPassword());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean updateAdmin(Admin admin) {
        String sql = "UPDATE admin SET Fname = ?, Lname = ?, MNumber = ?, Email = ?, username = ?, Password = ? WHERE AdminId = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, admin.getFname());
            preparedStatement.setString(2, admin.getLname());
            preparedStatement.setInt(3, admin.getMNumber());
            preparedStatement.setString(4, admin.getEmail());
            preparedStatement.setString(5, admin.getUsername());
            preparedStatement.setString(6, admin.getPassword());
            preparedStatement.setInt(7, admin.getAdminId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean deleteAdmin(int adminId) {
        String sql = "DELETE FROM admin WHERE AdminId = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, adminId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public List<Admin> getAllAdmins() {
        List<Admin> adminList = new ArrayList<>();
        String sql = "SELECT * FROM admin";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Admin admin = new Admin(
                    resultSet.getInt("AdminId"),
                    resultSet.getString("Fname"),
                    resultSet.getString("Lname"),
                    resultSet.getInt("MNumber"),
                    resultSet.getString("Email"),
                    resultSet.getString("username"),
                    resultSet.getString("Password")
                );
                adminList.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminList;
    }


    public Admin getAdminById(int adminId) {
        String sql = "SELECT * FROM admin WHERE AdminId = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, adminId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Admin(
                        resultSet.getInt("AdminId"),
                        resultSet.getString("Fname"),
                        resultSet.getString("Lname"),
                        resultSet.getInt("MNumber"),
                        resultSet.getString("Email"),
                        resultSet.getString("username"),
                        resultSet.getString("Password")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Admin login(String Uname , String pass) {
    	System.out.println(Uname + pass);
        String sql = "SELECT * FROM admin WHERE username=? AND PASSWORD =?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, Uname);
            preparedStatement.setString(2, pass);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Admin(
                        resultSet.getInt("AdminId"),
                        resultSet.getString("Fname"),
                        resultSet.getString("Lname"),
                        resultSet.getInt("MNumber"),
                        resultSet.getString("Email"),
                        resultSet.getString("username"),
                        resultSet.getString("Password")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
