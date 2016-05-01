/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.slantfree.beans;

import com.snapit.solutions.slantfree.dao.VendorDAO;
import com.snapit.solutions.slantfree.entity.Vendor;
import java.util.List;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

/**
 *
 * @author sudheerparasker
 */
@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
@Path("/vendor/")
public class VendorSessionBean implements VendorSessionBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
   @Autowired
    private VendorDAO vendorDao;
   // 
    /**
     *
     * @return
     */
    @GET
    @Path("all/")
    @Produces({"application/json"})
    @Override
    public List<Vendor> listAllVendors() {
        return vendorDao.findAll();
    }
}