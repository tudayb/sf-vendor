/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.slantfree.dao.test;

import com.snapit.solutions.slantfree.dao.impl.VendorDAOImpl;
import com.snapit.solutions.slantfree.entity.Vendor;
import org.junit.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author sudheerparasker
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/snapit/solutions/slantfree/dao/test/MongoDBConnectionTest.xml")
public class VendorDaoTest implements ApplicationContextAware {
    
    //s@Autowired
    private VendorDAOImpl dao;
    
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
        Assert.assertNotNull(dao);
        Assert.assertEquals(dao.find().countAll(), 0);
    }

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        dao = new VendorDAOImpl(Vendor.class, (Datastore) ac.getBean("datastore"));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Assert.assertNotNull(dao);
   }
}
