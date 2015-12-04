/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iia.osiris.database;

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
@Suite.SuiteClasses({com.iia.osiris.database.BDD_UtilTest.class, com.iia.osiris.database.SalarieDAOTest.class, com.iia.osiris.database.ManageDatabaseTest.class, com.iia.osiris.database.InitProgrammeTest.class})
public class DatabaseSuite {

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
