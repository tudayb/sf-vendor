/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.slantfree.oauth.dao.impl;

import com.snapit.solutions.slantfree.oauth.dao.OAuth2AuthenticationRefreshTokenDAO;
import com.snapit.solutions.slantfree.oauth.server.model.OAuth2AuthenticationRefreshToken;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OAuth2AuthenticationRefreshTokenDAOImpl extends BasicDAO<OAuth2AuthenticationRefreshToken, ObjectId> implements OAuth2AuthenticationRefreshTokenDAO {

    @Autowired
    public OAuth2AuthenticationRefreshTokenDAOImpl(Datastore ds) {
        super(ds);
        ds.ensureIndexes(); //creates all defined with @Indexed
        ds.ensureCaps(); //creates all collections for @Entity(cap=@CappedAt(...))
    }
    
    @Override
    public OAuth2AuthenticationRefreshToken findByTokenId(String tokenId) {
        Query q = createQuery().field("tokenId").equal(tokenId);
        return (OAuth2AuthenticationRefreshToken) q.get();
    }

}
