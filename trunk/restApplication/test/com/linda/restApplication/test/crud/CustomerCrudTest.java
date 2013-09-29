/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restApplication.test.crud;

import com.linda.restApplication.app.factories.AppFactory;
import com.linda.restApplication.domain.Contact;
import com.linda.restApplication.domain.Customer;
import com.linda.restApplication.domain.Demographic;
import com.linda.restApplication.domain.Name;
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
public class CustomerCrudTest {

    private static ApplicationContext ctx;
    private CustomerCrudService customerCrudService;
    private Long id;

    public CustomerCrudTest() {
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

    @Test
    private void createCustomer() {
        // Create the Service Object
        customerCrudService = (CustomerCrudService) ctx.getBean("customerCrudService");
       
        Name name = AppFactory.getName("Sannie", "Meyer");
        Demographic demo = AppFactory.getDemographic("female", "white");
        Contact contact = AppFactory.getContact("098877777", "878878987");
        Customer customer = AppFactory.getCustomer("TH66666", name, contact, demo);
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
        Assert.assertEquals(customer.getCustomerNumber() , "TH66666");
      
    }

    @Test(dependsOnMethods = "readCustomer")
    private void updateCustomer() {
        customerCrudService = (CustomerCrudService) ctx.getBean("customerCrudService");

        Customer customer = customerCrudService.findById(id);
        
        customer.setCustomerNumber("TY77777");
        // Update the Record in the Database
        customerCrudService.merge(customer);
        //Retrive the UPdata Record 
        Customer updatedCustomer = customerCrudService.findById(id);
        
        //Test if the Change Happened
        Assert.assertEquals(updatedCustomer.getCustomerNumber(), "TY77777");
        
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