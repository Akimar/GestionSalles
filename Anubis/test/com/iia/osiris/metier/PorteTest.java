/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.metier;

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
public class PorteTest {
    
    public PorteTest() {
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
     * Test of getNumero method, of class Porte.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        Porte instance = new Porte();
        int expResult = 0;
        int result = instance.getNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isVerrouille method, of class Porte.
     */
    @Test
    public void testIsVerrouille() {
        System.out.println("isVerrouille");
        Porte instance = new Porte();
        boolean expResult = false;
        boolean result = instance.isVerrouille();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVerrouille method, of class Porte.
     */
    @Test
    public void testSetVerrouille() {
        System.out.println("setVerrouille");
        boolean verrouille = false;
        Porte instance = new Porte();
        instance.setVerrouille(verrouille);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
