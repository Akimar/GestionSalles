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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Darkadok
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.iia.osiris.metier.SalarieTest.class, com.iia.osiris.metier.SalleTableModelTest.class, com.iia.osiris.metier.TerminalTableModelTest.class, com.iia.osiris.metier.HoraireJourTest.class, com.iia.osiris.metier.SalarieTableModelTest.class, com.iia.osiris.metier.SalleTest.class, com.iia.osiris.metier.PorteTest.class})
public class MetierSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
