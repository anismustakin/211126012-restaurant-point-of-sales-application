/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restApplication.test.services;

import com.linda.restApplication.app.factories.AppFactory;
import com.linda.restApplication.client.web.model.CustomerModel;
import com.linda.restApplication.domain.Contact;
import com.linda.restApplication.domain.Customer;
import com.linda.restApplication.domain.Demographic;
import com.linda.restApplication.domain.Name;
import com.linda.restApplication.services.CustomerService;
import com.linda.restApplication.services.crud.CustomerCrudService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author boniface
 */
public class CustomerTest {
    private CustomerCrudService customerCrudService;
    private CustomerService customerService;
    private Long id;
    private static ApplicationContext ctx;
    

    public CustomerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/linda/restApplication/app/conf/applicationContext-*.xml");
    
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createCustomer() {
        customerCrudService = (CustomerCrudService)ctx.getBean("customerCrudService");
        Customer customer = new Customer();// DON NOT DO THIS
        Name name = AppFactory.getName("Jan", "Piet");
        Contact contact = AppFactory.getContact("9998888", "8888888");
        Demographic demo = AppFactory.getDemographic("female", "white");
        customer.setCustomerNumber("67676876");
        customer.setName(name);
        customer.setContact(contact);
        customer.setDemographic(demo);
        customerCrudService.persist(customer);
        Assert.assertNotNull(customer);
           
    }

    @Test
    public void testCustomerService() {
        customerService = (CustomerService)ctx.getBean("customerService");
        CustomerModel customer = new CustomerModel();
       
        customerService.createCustomer(customer);
        Assert.assertNotNull(customer);
        
    }

    @Test
    public void updateCustomer() {
    }

    @Test
    public void readCustomers() {
    }

    @Test
    public void deletCustomer() {
    }
}