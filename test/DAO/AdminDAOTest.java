/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import org.hamcrest.core.IsAnything;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.Admin;

/**
 *
 * @author hello
 */
public class AdminDAOTest {
    
    public AdminDAOTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of alogin method, of class AdminDAO.
     */
    @Test
    public void testAlogin() {
        System.out.println("alogin");
        String uName = "test";
        String uPass = "test";
        AdminDAO instance = new AdminDAO();
        List<Admin> result = instance.alogin(uName, uPass);       
        assertThat(result,IsAnything.anything());
        assertThat(result,is(notNullValue()));
        
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
