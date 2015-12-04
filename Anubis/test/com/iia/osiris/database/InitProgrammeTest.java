/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.database;

import com.iia.osiris.metier.Salarie;
import com.iia.osiris.metier.Salle;
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
public class InitProgrammeTest {
    
    public InitProgrammeTest() {
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
     * Test of initSalle method, of class InitProgramme.
     */
    @Test
    public void testInitSalle() {
        System.out.println("initSalle");
        Vector<Salle> vectorSalle = null;
        InitProgramme.initSalle(vectorSalle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initSalarie method, of class InitProgramme.
     */
    @Test
    public void testInitSalarie() {
        System.out.println("initSalarie");
        Vector<Salarie> vectorSalarie = null;
        InitProgramme.initSalarie(vectorSalarie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
