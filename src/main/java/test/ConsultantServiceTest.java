package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dao.ConsultantDAO;
import entity.Consultant;
import service.ConsultantService;


public class ConsultantServiceTest {

    @Mock
    private ConsultantDAO consultantDAO;

    private ConsultantService consultantService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        consultantService = new ConsultantService();
        consultantService.setConsultantDAO(consultantDAO);
    }

    @Test
    public void testCreateConsultant() throws SQLException {
        Consultant consultant = new Consultant("Roshan", "Wijenayaka", 711234567, "roshan@gmail.com", "Sri Lanka");

        consultantService.createConsultant(consultant);

        verify(consultantDAO).createConsultant(consultant);
    }

    @Test
    public void testGetConsultantById() throws SQLException {
        int consultantId = 123;
        Consultant expectedConsultant = new Consultant(123,"Roshan", "Wijenayaka", 711234567, "roshan@gmail.com", "Sri Lanka");
        when(consultantDAO.getConsultantById(consultantId)).thenReturn(expectedConsultant);

        Consultant actualConsultant = consultantService.getConsultantById(consultantId);

        assertEquals(expectedConsultant, actualConsultant);
    }

    @Test
    public void testGetConsultantByCountry() throws SQLException {
        String country = "USA";
        List<Consultant> expectedConsultants = new ArrayList<>();
        when(consultantDAO.getConsultantByCountry(country)).thenReturn(expectedConsultants);

        List<Consultant> actualConsultants = consultantService.getConsultantByCountry(country);

        assertEquals(expectedConsultants, actualConsultants);
    }

    @Test
    public void testGetAllConsultants() throws SQLException {
        List<Consultant> expectedConsultants = new ArrayList<>();
        when(consultantDAO.getAllConsultants()).thenReturn(expectedConsultants);

        List<Consultant> actualConsultants = consultantService.getAllConsultants();

        assertEquals(expectedConsultants, actualConsultants);
    }

    @Test
    public void testUpdateConsultant() throws SQLException {
        Consultant consultant = new Consultant(1,"Roshan", "Wijenayaka", 711234567, "roshan@gmail.com", "Sri Lanka");

        consultantService.updateConsultant(consultant);

        verify(consultantDAO).updateConsultant(consultant);
    }

    @Test
    public void testDeleteConsultant() throws SQLException {
        int consultantId = 123;

        consultantService.deleteConsultant(consultantId);

        verify(consultantDAO).deleteConsultant(consultantId);
    }

}
