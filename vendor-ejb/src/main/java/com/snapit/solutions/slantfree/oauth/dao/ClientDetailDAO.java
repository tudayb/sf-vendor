/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.slantfree.oauth.dao;

import com.snapit.solutions.slantfree.oauth.server.model.ClientDetail;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

/**
 *
 * @author sudheerparasker
 */
public interface ClientDetailDAO extends DAO<ClientDetail, ObjectId> {
    public ClientDetail findByClientId(String id);
    public void deleteAll();
    public ClientDetail saveClientDetail(ClientDetail aClientDetail);
}
