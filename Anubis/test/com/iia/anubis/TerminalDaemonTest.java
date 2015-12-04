/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.anubis;

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
public class TerminalDaemonTest {
    
    public TerminalDaemonTest() {
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
     * Test of getIdentifiantTerminal method, of class TerminalDaemon.
     */
    @Test
    public void testGetIdentifiantTerminal() {
        System.out.println("getIdentifiantTerminal");
        TerminalDaemon instance = null;
        String expResult = "";
        String result = instance.getIdentifiantTerminal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdentifiantTerminal method, of class TerminalDaemon.
     */
    @Test
    public void testSetIdentifiantTerminal() {
        System.out.println("setIdentifiantTerminal");
        String IdentifiantTerminal = "";
        TerminalDaemon instance = null;
        instance.setIdentifiantTerminal(IdentifiantTerminal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessage method, of class TerminalDaemon.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        TerminalDaemon instance = null;
        String expResult = "";
        String result = instance.getMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class TerminalDaemon.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        TerminalDaemon instance = null;
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reception method, of class TerminalDaemon.
     */
    @Test
    public void testReception() {
        System.out.println("reception");
        TerminalDaemon instance = null;
        instance.reception();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of envoyer method, of class TerminalDaemon.
     */
    @Test
    public void testEnvoyer() {
        System.out.println("envoyer");
        String message = "";
        TerminalDaemon instance = null;
        instance.envoyer(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transformerChaineMessage method, of class TerminalDaemon.
     */
    @Test
    public void testTransformerChaineMessage() {
        System.out.println("transformerChaineMessage");
        String input = "";
        TerminalDaemon instance = null;
        String expResult = "";
        String result = instance.transformerChaineMessage(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
