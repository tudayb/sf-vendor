/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.slantfree.dao;

import com.snapit.solutions.slantfree.entity.Vendor;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

/**
 *
 * @author sudheerparasker
 */
public interface VendorDAO extends DAO<Vendor, ObjectId>{
    public List<Vendor> findAll();
}
