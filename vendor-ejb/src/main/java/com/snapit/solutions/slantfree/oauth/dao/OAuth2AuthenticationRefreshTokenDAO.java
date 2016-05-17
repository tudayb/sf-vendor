/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.slantfree.oauth.dao;

import com.snapit.solutions.slantfree.oauth.server.model.OAuth2AuthenticationRefreshToken;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

/**
 *
 * @author sudheerparasker
 */
public interface OAuth2AuthenticationRefreshTokenDAO extends DAO<OAuth2AuthenticationRefreshToken, ObjectId> {
 public OAuth2AuthenticationRefreshToken findByTokenId(String tokenId);   
}
