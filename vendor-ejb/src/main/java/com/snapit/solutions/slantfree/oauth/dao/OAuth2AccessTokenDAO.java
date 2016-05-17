/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.slantfree.oauth.dao;

import com.snapit.solutions.slantfree.oauth.server.model.OAuth2AuthenticationAccessToken;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

/**
 *
 * @author sudheerparasker
 */
public interface OAuth2AccessTokenDAO extends DAO<OAuth2AuthenticationAccessToken, ObjectId> {
    public OAuth2AuthenticationAccessToken findByTokenId(String tokenId);
    public OAuth2AuthenticationAccessToken findByRefreshToken(String refreshToken);

    public List<OAuth2AuthenticationAccessToken> findByClientId(String clientId);

    public List<OAuth2AuthenticationAccessToken> findByClientIdAndUserName(String clientId, String userName);

    public OAuth2AuthenticationAccessToken findByAuthenticationId(String authenticationId);
}
