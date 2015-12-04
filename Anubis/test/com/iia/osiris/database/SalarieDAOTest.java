/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.database;

import com.iia.osiris.metier.Salarie;
import java.sql.Connection;
import java.util.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Darkadok
 */
public class SalarieDAOTest {
    
    public SalarieDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllSalarie method, of class SalarieDAO.
     */
    @Test
    public void testGetAllSalarie() {
        System.out.println("getAllSalarie");
        Connection cnx = null;
        Vector<Salarie> vectorSalarie = null;
        SalarieDAO.getAllSalarie(cnx, vectorSalarie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
