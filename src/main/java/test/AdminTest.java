package test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import entity.Admin;

public class AdminTest {
	
private Admin admin;
    
    @Before
    public void setUp() {
        // Create an instance of Admin to be used in test methods
        admin = new Admin(1, "John", "Doe", 123456789, "john@example.com", "johndoe", "password");
    }
    
    @Test
    public void testGetAdminId() {
        assertEquals(1, admin.getAdminId());
    }
    
    @Test
    public void testGetFname() {
        assertEquals("John", admin.getFname());
    }
    
    @Test
    public void testGetLname() {
        assertEquals("Doe", admin.getLname());
    }
    
    // Add more test methods for other getters and setters
    
    @Test
    public void testConstructorWithArguments() {
        assertEquals("John", admin.getFname());
        assertEquals("Doe", admin.getLname());
        assertEquals(123456789, admin.getMNumber());
        assertEquals("john@example.com", admin.getEmail());
        assertEquals("johndoe", admin.getUsername());
        assertEquals("password", admin.getPassword());
    }

}
