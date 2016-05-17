/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.slantfree.oauth.dao;

import com.snapit.solutions.slantfree.oauth.server.model.User;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

/**
 *
 * @author sudheerparasker
 */
public interface UserDAO extends DAO<User, ObjectId>{

    void deleteAll();

    User findByEmail(String email);

    User getUserById(String id);

    User saveUser(User aUser);
    
}
