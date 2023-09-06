package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import dao.ConsultantDAO;
import entity.Consultant;


public class ConsultantService {
    private ConsultantDAO consultantDAO;

    public ConsultantService() {
        Connection connection = databseConnection.DBUtil.getConnection();
        consultantDAO = new ConsultantDAO(connection);
    }

    public void createConsultant(Consultant consultant) {
        try {
            consultantDAO.createConsultant(consultant);
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }

    public Consultant getConsultantById(int consultantId) {
        try {
            return consultantDAO.getConsultantById(consultantId);
        } catch (SQLException e) {
            
            e.printStackTrace();
            return null;
        }
    }

    public List<Consultant> getConsultantByCountry(String country) {
        try {
            return consultantDAO.getConsultantByCountry(country);
        } catch (SQLException e) {
            
            e.printStackTrace();
            return null;
        }
    }

    public List<Consultant> getAllConsultants() {
        try {
            return consultantDAO.getAllConsultants();
        } catch (SQLException e) {
           
            e.printStackTrace();
            return null;
        }
    }

    public void updateConsultant(Consultant consultant) {
        try {
            consultantDAO.updateConsultant(consultant);
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
    }

    public void deleteConsultant(int consultantId) {
        try {
            consultantDAO.deleteConsultant(consultantId);
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }

	public void setConsultantDAO(ConsultantDAO consultantDAO2) {
		consultantDAO = consultantDAO2;
		
	}
}
