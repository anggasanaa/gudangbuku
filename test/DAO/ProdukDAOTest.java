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
import pojo.Produk;

/**
 *
 * @author hello
 */
public class ProdukDAOTest {
    
    public ProdukDAOTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAll method, of class ProdukDAO.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        ProdukDAO instance = new ProdukDAO();
        List<Produk> result = instance.getAll();
        assertThat(result,IsAnything.anything());
        assertThat(result,is(notNullValue()));
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class ProdukDAO.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        Integer id = null;
        ProdukDAO instance = new ProdukDAO();
        List<Produk> result = instance.getById(id);
        assertThat(result,IsAnything.anything());
        assertThat(result,is(notNullValue()));
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class ProdukDAO.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Produk produk = null;
        ProdukDAO instance = new ProdukDAO();
        instance.add(produk);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ProdukDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Integer id = 0;
        ProdukDAO instance = new ProdukDAO();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class ProdukDAO.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        Produk produk = null;
        ProdukDAO instance = new ProdukDAO();
        instance.edit(produk);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
