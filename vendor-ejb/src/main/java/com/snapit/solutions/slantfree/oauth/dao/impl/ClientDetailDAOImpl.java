/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.slantfree.oauth.dao.impl;

import com.snapit.solutions.slantfree.oauth.dao.ClientDetailDAO;
import com.snapit.solutions.slantfree.oauth.server.model.ClientDetail;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDetailDAOImpl extends BasicDAO<ClientDetail, ObjectId> implements ClientDetailDAO {

    @Autowired
    public ClientDetailDAOImpl(Datastore ds) {
        super(ds);
        ds.ensureIndexes(); //creates all defined with @Indexed
        ds.ensureCaps(); //creates all collections for @Entity(cap=@CappedAt(...))
    }
    
    @Override
    public ClientDetail findByClientId(String id) {
        return get(new ObjectId(id));
    }
    
    @Override
    public ClientDetail saveClientDetail(ClientDetail aClientDetail) {
        Key<ClientDetail> clientDetail = save(aClientDetail);
        return findByClientId(clientDetail.getId().toString());
    }

    
    @Override
    public void deleteAll() {
        getDatastore().delete(getDatastore().createQuery(ClientDetail.class));
    } 
}
