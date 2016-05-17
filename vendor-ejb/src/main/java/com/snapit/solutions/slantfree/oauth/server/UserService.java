/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.slantfree.oauth.server;

import com.snapit.solutions.slantfree.oauth.dao.UserDAO;
import com.snapit.solutions.slantfree.oauth.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sudheerparasker
 */
@Service
public class UserService {
 @Autowired
    private UserDAO userRepository;

    public User getUserById(String id) {
        return userRepository.getUserById(id);
    }

    public User save(User user) {
        return userRepository.saveUser(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }    
}
