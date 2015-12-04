/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.database;

import java.sql.Connection;
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
public class BDD_UtilTest {
    
    public BDD_UtilTest() {
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
     * Test of open method, of class BDD_Util.
     */
    @Test
    public void testOpen() throws Exception {
        System.out.println("open");
        String user = "";
        String password = "";
        String server = "";
        String database = "";
        Connection expResult = null;
        Connection result = BDD_Util.open(user, password, server, database);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class BDD_Util.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        Connection cnx = null;
        BDD_Util.close(cnx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
