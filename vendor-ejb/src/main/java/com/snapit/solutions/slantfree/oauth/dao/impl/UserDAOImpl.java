/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.slantfree.oauth.dao.impl;

import com.snapit.solutions.slantfree.oauth.dao.UserDAO;
import com.snapit.solutions.slantfree.oauth.server.model.User;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends BasicDAO<User, ObjectId> implements UserDAO {

    @Autowired
    public UserDAOImpl(Datastore ds) {
        super(ds);
        ds.ensureIndexes(); //creates all defined with @Indexed
        ds.ensureCaps(); //creates all collections for @Entity(cap=@CappedAt(...))
    }
    
    @Override
    public User getUserById(String id) {
        return get(new ObjectId(id));
    }

    @Override
    public User saveUser(User aUser) {
        Key<User> user = save(aUser);
        return getUserById(user.getId().toString());
    }

    @Override
    public User findByEmail(String email) {
        Query q = createQuery().field("email").equal(email);
        return (User) q.get();
    }

    /**
     *
     */
    @Override
    public void deleteAll() {
        getDatastore().delete(getDatastore().createQuery(User.class));
    }    

}
