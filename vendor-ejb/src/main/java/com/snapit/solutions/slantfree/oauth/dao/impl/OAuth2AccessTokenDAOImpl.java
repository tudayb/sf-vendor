/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.slantfree.oauth.dao.impl;

import com.snapit.solutions.slantfree.oauth.dao.OAuth2AccessTokenDAO;
import com.snapit.solutions.slantfree.oauth.server.model.OAuth2AuthenticationAccessToken;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Criteria;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OAuth2AccessTokenDAOImpl extends BasicDAO<OAuth2AuthenticationAccessToken, ObjectId> implements OAuth2AccessTokenDAO {

    @Autowired
    public OAuth2AccessTokenDAOImpl(Datastore ds) {
        super(ds);
        ds.ensureIndexes(); //creates all defined with @Indexed
        ds.ensureCaps(); //creates all collections for @Entity(cap=@CappedAt(...))
    }

    @Override
    public OAuth2AuthenticationAccessToken findByTokenId(String tokenId) {
        Query q = createQuery().field("tokenId").equal(tokenId);
        return (OAuth2AuthenticationAccessToken) q.get();
    }

    @Override
    public OAuth2AuthenticationAccessToken findByRefreshToken(String refreshToken) {
        Query q = createQuery().field("refreshToken").equal(refreshToken);
        return (OAuth2AuthenticationAccessToken) q.get();
    }

    @Override
    public OAuth2AuthenticationAccessToken findByAuthenticationId(String authenticationId) {
        Query q = createQuery().field("authenticationId").equal(authenticationId);
        return (OAuth2AuthenticationAccessToken) q.get();
    }

    @Override
    public List<OAuth2AuthenticationAccessToken> findByClientId(String clientId) {
        Query q = createQuery().field("clientId").equal(clientId);
        return q.asList();
    }

    @Override
    public List<OAuth2AuthenticationAccessToken> findByClientIdAndUserName(String clientId, String userName) {
        Query q = createQuery();
        q.and(
                (Criteria) q.criteria("clientId").equal(clientId),
                (Criteria) q.criteria("userName").equal(userName)
        );
        return q.asList();
    }

}
