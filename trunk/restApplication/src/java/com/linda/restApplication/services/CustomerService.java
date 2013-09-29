/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restApplication.services;

import com.linda.restApplication.client.web.model.CustomerModel;
import com.linda.restApplication.domain.Customer;
import java.util.List;

/**
 *
 * @author linda
 */
public interface CustomerService {
    public List<Customer> createCustomer(CustomerModel model);
    public List<Customer> deleteCustomer(Long id);
    public CustomerModel getCustomerToEdit(Long id);
    public List<Customer> updateCustomer(CustomerModel model);
    public List<Customer> getCustomers();
    
    
}
