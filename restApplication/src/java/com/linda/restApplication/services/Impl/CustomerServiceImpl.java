/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restApplication.services.Impl;

import com.linda.restApplication.client.web.model.CustomerModel;
import com.linda.restApplication.domain.Customer;
import com.linda.restApplication.services.CustomerService;
import com.linda.restApplication.services.crud.CustomerCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author boniface
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerCrudService customerCrudService;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Customer> createCustomer(CustomerModel model) {
        Customer customer = new Customer(); // DONT DO THIS USE FACTORY
        model.setFirstName(customer.getName().getFirstName());
        model.setLastName(customer.getName().getLastName());
        model.setCell(customer.getContact().getCellNumber());
        model.setPhone(customer.getContact().getPhoneNumber());
        model.setGender(customer.getDemographic().getGender());
        model.setRace(customer.getDemographic().getRace());
        model.setCustomerNumber(customer.getCustomerNumber());
        customerCrudService.persist(customer);
        return customerCrudService.findAll();
    }

    @Override
    public List<Customer> deleteCustomer(Long id) {
        customerCrudService.removeById(id);
        return customerCrudService.findAll();
    }

    @Override
    public CustomerModel getCustomerToEdit(Long id) {
        CustomerModel model = new CustomerModel();
        Customer customer = customerCrudService.findById(id);
        model.setFirstName(customer.getName().getFirstName());
        model.setLastName(customer.getName().getLastName());
        model.setCell(customer.getContact().getCellNumber());
        model.setPhone(customer.getContact().getPhoneNumber());
        model.setGender(customer.getDemographic().getGender());
        model.setRace(customer.getDemographic().getRace());
        model.setCustomerNumber(customer.getCustomerNumber());
        model.setId(id);
        return model;
    }
    @Override
    public List<Customer> updateCustomer(CustomerModel model) {
        Customer customer = new Customer(); // DONT DO THIS USE FACTORY
        model.setCustomerNumber(customer.getCustomerNumber());
        model.setFirstName(customer.getName().getFirstName());
        model.setLastName(customer.getName().getLastName());
        model.setCell(customer.getContact().getCellNumber());
        model.setPhone(customer.getContact().getPhoneNumber());
        model.setGender(customer.getDemographic().getGender());
        model.setRace(customer.getDemographic().getRace());
        customer.setId(model.getId());
        customerCrudService.merge(customer);
        return customerCrudService.findAll();
    }

    @Override
    public List<Customer> getCustomers() {
        return customerCrudService.findAll();
        }
}
