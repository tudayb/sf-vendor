/*
 * Property of SnapIT Solutions.
 */
package com.snapit.solutions.slantfree.oauth.server.test;

import com.snapit.solutions.slantfree.oauth.server.UserService;
import com.snapit.solutions.slantfree.oauth.server.model.ClientDetail;
import com.snapit.solutions.slantfree.oauth.server.model.User;
import com.snapit.solutions.slantfree.oauth.server.security.ClientDetailService;
import java.util.Arrays;
import java.util.HashSet;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author Sudheer.Parasker@SnapIT.Solutions
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:service-applicationContext.xml", "classpath:com/snapit/solutions/slantfree/dao/test/MongoDBConnectionTest.xml" } )
@WebAppConfiguration
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private ClientDetailService clientDetailService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    User awesomeUser;
    ClientDetail authClient;
    @Value("${app.client.id}")
    private String authClientId;
    @Value("${app.client.secret}")
    private String authClientSecret;

    @Before
    public void setUp() {

        userService.deleteAll();
        clientDetailService.deleteAll();

        awesomeUser = new User();

        awesomeUser.setEmail("user@awesome.com");
        awesomeUser.setPassword(passwordEncoder.encode("cant_hack_this"));
        awesomeUser.setId(new ObjectId("507f1f77bcf86cd799439011"));
        userService.save(awesomeUser);

        authClient = new ClientDetail();
        authClient.setId(new ObjectId("507f1f77bcf86cd799439011"));
        authClient.setClientId(authClientId);
        authClient.setResourceIds(new HashSet<>(Arrays.asList("rest_api")));
        authClient.setClientSecret(passwordEncoder.encode(authClientSecret));
        authClient.setRefreshTokenValiditySeconds(4500);
        authClient.setAccessTokenValiditySeconds(4500);
        authClient.setAuthorities(new HashSet<>(Arrays.asList("trust", "read", "write")));
        authClient.setAuthorizedGrantTypes(new HashSet<>(Arrays.asList("client_credentials", "authorization_code", "implicit", "password", "refresh_token")));
        authClient.setScope(new HashSet<>(Arrays.asList("trust", "read", "write")));
        authClient.setSecretRequired(true);

        clientDetailService.save(authClient);

    }

    @Test
    public void checkingAWESOME() {
        assertNotEquals("awesome", "AWESOME");
    }
}
