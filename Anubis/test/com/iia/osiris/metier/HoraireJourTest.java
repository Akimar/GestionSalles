/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.metier;

import java.sql.Time;
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
public class HoraireJourTest {
    
    public HoraireJourTest() {
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
     * Test of getHeureDebMatin method, of class HoraireJour.
     */
    @Test
    public void testGetHeureDebMatin() {
        System.out.println("getHeureDebMatin");
        HoraireJour instance = null;
        Time expResult = null;
        Time result = instance.getHeureDebMatin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeureDebMatin method, of class HoraireJour.
     */
    @Test
    public void testSetHeureDebMatin() {
        System.out.println("setHeureDebMatin");
        Time HeureDebMatin = null;
        HoraireJour instance = null;
        instance.setHeureDebMatin(HeureDebMatin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeureFinMatin method, of class HoraireJour.
     */
    @Test
    public void testGetHeureFinMatin() {
        System.out.println("getHeureFinMatin");
        HoraireJour instance = null;
        Time expResult = null;
        Time result = instance.getHeureFinMatin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeureFinMatin method, of class HoraireJour.
     */
    @Test
    public void testSetHeureFinMatin() {
        System.out.println("setHeureFinMatin");
        Time HeureFinMatin = null;
        HoraireJour instance = null;
        instance.setHeureFinMatin(HeureFinMatin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeureDebSoir method, of class HoraireJour.
     */
    @Test
    public void testGetHeureDebSoir() {
        System.out.println("getHeureDebSoir");
        HoraireJour instance = null;
        Time expResult = null;
        Time result = instance.getHeureDebSoir();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeureDebSoir method, of class HoraireJour.
     */
    @Test
    public void testSetHeureDebSoir() {
        System.out.println("setHeureDebSoir");
        Time HeureDebSoir = null;
        HoraireJour instance = null;
        instance.setHeureDebSoir(HeureDebSoir);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeureFinSoir method, of class HoraireJour.
     */
    @Test
    public void testGetHeureFinSoir() {
        System.out.println("getHeureFinSoir");
        HoraireJour instance = null;
        Time expResult = null;
        Time result = instance.getHeureFinSoir();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeureFinSoir method, of class HoraireJour.
     */
    @Test
    public void testSetHeureFinSoir() {
        System.out.println("setHeureFinSoir");
        Time HeureFinSoir = null;
        HoraireJour instance = null;
        instance.setHeureFinSoir(HeureFinSoir);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class HoraireJour.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        HoraireJour instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class HoraireJour.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        HoraireJour instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
