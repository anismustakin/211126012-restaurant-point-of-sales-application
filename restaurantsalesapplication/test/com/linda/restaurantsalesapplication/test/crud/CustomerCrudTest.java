/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.test.crud;

import com.linda.restaurantsalesapplication.app.factories.CustomerFactory;
import com.linda.restaurantsalesapplication.domain.Contact;
import com.linda.restaurantsalesapplication.domain.Customer;
import com.linda.restaurantsalesapplication.domain.Demographic;
import com.linda.restaurantsalesapplication.domain.Name;
import com.linda.restaurantsalesapplication.services.crud.CustomerCrudService;
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
public class CustomerCrudTest {

    private static ApplicationContext ctx;
    private CustomerCrudService customerCrudService;
    private Long id;

    public CustomerCrudTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/linda/restaurantsalesapplication/app/conf/applicationContext-*.xml");
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

    @Test
    private void createCustomer() {
        // Create the Service Object
        customerCrudService = (CustomerCrudService) ctx.getBean("customerCrudService");
       
        Name name = CustomerFactory.getName("Sannie", "Meyer");
        Demographic demo = CustomerFactory.getDemographic("female", "white");
        Contact contact = CustomerFactory.getContact("098877777", "878878987");
        Customer customer = CustomerFactory.getCustomer("TH66666", name, demo, contact);
        customerCrudService.persist(customer);
        //Collect the ID for use in later TESTS
        id = customer.getId();
        //Asssert if we have persisted the Customer
        Assert.assertNotNull(customer);

    }

    @Test(dependsOnMethods = "createCustomer")
    private void readCustomer() {
        customerCrudService = (CustomerCrudService) ctx.getBean("customerCrudService");
        //Get Tax Table By ID 
        Customer customer = customerCrudService.findById(id);
        //Do assertions
        Assert.assertEquals(customer.getCustomerNo() , "TH66666");
      
    }

    @Test(dependsOnMethods = "readCustomer")
    private void updateCustomer() {
        customerCrudService = (CustomerCrudService) ctx.getBean("customerCrudService");

        Customer customer = customerCrudService.findById(id);
        
        customer.setCustomerNo("TY77777");
        // Update the Record in the Database
        customerCrudService.merge(customer);
        //Retrive the UPdata Record 
        Customer updatedCustomer = customerCrudService.findById(id);
        
        //Test if the Change Happened
        Assert.assertEquals(updatedCustomer.getCustomerNo(), "TY77777");
        
    }

    @Test(dependsOnMethods = "updateCustomer")
    private void deleteCustomer() {
        customerCrudService = (CustomerCrudService) ctx.getBean("customerCrudService");
        Customer customer = customerCrudService.findById(id);
        //Delete Record
        customerCrudService.remove(customer);
        Customer deletedCustomer = customerCrudService.findById(id);
        // Test to See if the Record was Deleted 
         Assert.assertNull(deletedCustomer);
    }
}