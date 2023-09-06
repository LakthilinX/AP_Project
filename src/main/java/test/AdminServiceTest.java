package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dao.AdminDAO;
import entity.Admin;
import service.AdminService;

public class AdminServiceTest {

    @Mock
    private AdminDAO adminDAO;

    @InjectMocks
    private AdminService adminService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateAdmin() {
        Admin newAdmin = new Admin("John", "Doe", 123456789, "john@example.com", "john_doe", "password");
        when(adminDAO.insertAdmin(newAdmin)).thenReturn(true);

        boolean result = adminService.createAdmin("John", "Doe", 123456789, "john@example.com", "john_doe", "password");

        assertTrue(result);
    }

    @Test
    public void testUpdateAdmin() {
        Admin updatedAdmin = new Admin(1, "John", "Doe", 123456789, "john@example.com", "john_doe", "new_password");
        when(adminDAO.updateAdmin(updatedAdmin)).thenReturn(true);

        boolean result = adminService.updateAdmin(1, "John", "Doe", 123456789, "john@example.com", "john_doe", "new_password");

        assertTrue(result);
    }

    @Test
    public void testLoginSuccessful() {
        when(adminDAO.login("john_doe", "password")).thenReturn(new Admin("John", "Doe", 123456789, "john@example.com", "john_doe", "password"));

        Admin loggedInAdmin = adminService.login("john_doe", "password");

        assertNotNull(loggedInAdmin);
        assertEquals("John", loggedInAdmin.getFname());
    }

    @Test
    public void testLoginFailed() {
        when(adminDAO.login("nonexistent_user", "wrong_password")).thenReturn(null);

        Admin loggedInAdmin = adminService.login("nonexistent_user", "wrong_password");

        assertNull(loggedInAdmin);
    }
    
    @Test
    public void testGetAllAdmins() {
        List<Admin> admins = new ArrayList<>();
        admins.add(new Admin("John", "Doe", 123456789, "john@example.com", "john_doe", "password"));
        when(adminDAO.getAllAdmins()).thenReturn(admins);

        List<Admin> result = adminService.getAllAdmin();

        assertNotNull(result);
        assertEquals(1, result.size());
    }
}
