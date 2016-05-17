/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.slantfree.oauth.server.security;

import com.snapit.solutions.slantfree.oauth.server.UserService;
import com.snapit.solutions.slantfree.oauth.server.model.User;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@Service
public class UserAuthConfigService {
@Autowired
    private UserService userService;

    public User getUser(String email) {
        return userService.findByEmail(email);
    }

    public List<GrantedAuthority> getRights(User user) {
        List<GrantedAuthority> grantedAuthority = new LinkedList<>();
        List<String> right = user.getRights();
        if (null != right && !right.isEmpty()) {
            right.stream().forEach(r -> {
                grantedAuthority.add(new SimpleGrantedAuthority(r));
            });
        }
        return grantedAuthority;
    }    
}
