/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.slantfree.dao.test;

import com.snapit.solutions.slantfree.dao.VendorDAO;
import com.snapit.solutions.slantfree.entity.Vendor;
import java.util.List;
import org.junit.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author sudheerparasker
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:service-applicationContext.xml", "classpath:com/snapit/solutions/slantfree/dao/test/MongoDBConnectionTest.xml" } )
public class VendorDaoTest {
    
    @Autowired
    private VendorDAO vendorDAO;
    
    public VendorDaoTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
        Assert.assertNotNull(vendorDAO);
        List<Vendor> vendorList = vendorDAO.findAll();
        Assert.assertEquals(1, vendorList.size());
    }

}
