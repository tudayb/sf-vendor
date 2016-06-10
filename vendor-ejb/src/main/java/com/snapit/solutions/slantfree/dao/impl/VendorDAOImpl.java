/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.slantfree.dao.impl;

import com.snapit.solutions.slantfree.dao.VendorDAO;
import com.snapit.solutions.slantfree.db.DatabaseConnector;
import com.snapit.solutions.slantfree.entity.Vendor;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author sudheerparasker
 */
@Repository("vendorDAO")
public class VendorDAOImpl extends BasicDAO<Vendor, ObjectId> implements VendorDAO {
    
    @Autowired
    public VendorDAOImpl(Datastore ds) {
        super(ds);
        ds.ensureIndexes(); //creates all defined with @Indexed
        ds.ensureCaps(); //creates all collections for @Entity(cap=@CappedAt(...))
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Vendor> findAll() {
        return getDatastore().find( Vendor.class ).asList();
    }
}
