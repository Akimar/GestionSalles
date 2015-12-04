/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.metier;

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
public class SalarieTableModelTest {
    
    public SalarieTableModelTest() {
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
     * Test of isCellEditable method, of class SalarieTableModel.
     */
    @Test
    public void testIsCellEditable() {
        System.out.println("isCellEditable");
        int row = 0;
        int column = 0;
        SalarieTableModel instance = new SalarieTableModel();
        boolean expResult = false;
        boolean result = instance.isCellEditable(row, column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnName method, of class SalarieTableModel.
     */
    @Test
    public void testGetColumnName() {
        System.out.println("getColumnName");
        int column = 0;
        SalarieTableModel instance = new SalarieTableModel();
        String expResult = "";
        String result = instance.getColumnName(column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnCount method, of class SalarieTableModel.
     */
    @Test
    public void testGetColumnCount() {
        System.out.println("getColumnCount");
        SalarieTableModel instance = new SalarieTableModel();
        int expResult = 0;
        int result = instance.getColumnCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnClass method, of class SalarieTableModel.
     */
    @Test
    public void testGetColumnClass() {
        System.out.println("getColumnClass");
        int columnIndex = 0;
        SalarieTableModel instance = new SalarieTableModel();
        Class expResult = null;
        Class result = instance.getColumnClass(columnIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fillTable method, of class SalarieTableModel.
     */
    @Test
    public void testFillTable() {
        System.out.println("fillTable");
        Vector<Salarie> vectorSalarie = null;
        SalarieTableModel instance = new SalarieTableModel();
        instance.fillTable(vectorSalarie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
