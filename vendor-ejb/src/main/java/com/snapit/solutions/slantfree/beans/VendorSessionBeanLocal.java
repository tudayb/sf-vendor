/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snapit.solutions.slantfree.beans;

import com.snapit.solutions.slantfree.entity.Vendor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sudheerparasker
 */
@Local
public interface VendorSessionBeanLocal {
    public List<Vendor> listAllVendors();
}
