/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.database;

import com.iia.osiris.metier.Salarie;
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
public class ManageDatabaseTest {
    
    public ManageDatabaseTest() {
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
     * Test of manageSalarie method, of class ManageDatabase.
     */
    @Test
    public void testManageSalarie() {
        System.out.println("manageSalarie");
        Salarie s = null;
        boolean is_update = false;
        String user = "";
        String password = "";
        String server = "";
        String database = "";
        ManageDatabase.manageSalarie(s, is_update, user, password, server, database);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of manageSalle method, of class ManageDatabase.
     */
    @Test
    public void testManageSalle() {
        System.out.println("manageSalle");
        Salarie s = null;
        boolean is_update = false;
        String user = "";
        String password = "";
        String server = "";
        String database = "";
        ManageDatabase.manageSalle(s, is_update, user, password, server, database);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
