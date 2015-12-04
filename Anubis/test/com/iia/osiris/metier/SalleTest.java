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
public class SalleTest {
    
    public SalleTest() {
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
     * Test of getIdentifiant method, of class Salle.
     */
    @Test
    public void testGetIdentifiant() {
        System.out.println("getIdentifiant");
        Salle instance = null;
        int expResult = 0;
        int result = instance.getIdentifiant();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdentifiant method, of class Salle.
     */
    @Test
    public void testSetIdentifiant() {
        System.out.println("setIdentifiant");
        int Identifiant = 0;
        Salle instance = null;
        instance.setIdentifiant(Identifiant);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumeroTerminal method, of class Salle.
     */
    @Test
    public void testGetNumeroTerminal() {
        System.out.println("getNumeroTerminal");
        Salle instance = null;
        String expResult = "";
        String result = instance.getNumeroTerminal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumeroTerminal method, of class Salle.
     */
    @Test
    public void testSetNumeroTerminal() {
        System.out.println("setNumeroTerminal");
        String NumeroTerminal = "";
        Salle instance = null;
        instance.setNumeroTerminal(NumeroTerminal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNom method, of class Salle.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        Salle instance = null;
        String expResult = "";
        String result = instance.getNom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNom method, of class Salle.
     */
    @Test
    public void testSetNom() {
        System.out.println("setNom");
        String Nom = "";
        Salle instance = null;
        instance.setNom(Nom);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDisponibilite method, of class Salle.
     */
    @Test
    public void testGetDisponibilite() {
        System.out.println("getDisponibilite");
        Salle instance = null;
        HoraireJour[] expResult = null;
        HoraireJour[] result = instance.getDisponibilite();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDisponibilite method, of class Salle.
     */
    @Test
    public void testSetDisponibilite() {
        System.out.println("setDisponibilite");
        HoraireJour[] Disponibilite = null;
        Salle instance = null;
        instance.setDisponibilite(Disponibilite);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAcces method, of class Salle.
     */
    @Test
    public void testGetAcces() {
        System.out.println("getAcces");
        Salle instance = null;
        Porte[] expResult = null;
        Porte[] result = instance.getAcces();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAcces method, of class Salle.
     */
    @Test
    public void testSetAcces() {
        System.out.println("setAcces");
        Porte[] Acces = null;
        Salle instance = null;
        instance.setAcces(Acces);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Salle.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Salle instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Salle.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Salle instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Salle.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Salle instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
