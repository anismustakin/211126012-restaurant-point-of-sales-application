/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.test.repository;

import com.linda.restaurantsalesapplication.app.factories.PersonAddressFactory;
import com.linda.restaurantsalesapplication.domain.PersonAddress;
import com.linda.restaurantsalesapplication.services.model.PersonAddressCrudModelService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author 211126012
 */
public class PersonAddressTest {
    private PersonAddressCrudModelService personAddressCrudModelService;
    //also need the id
    private Long id;
    private static ClassPathXmlApplicationContext ctx;
    
    public PersonAddressTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

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
    //Want to do a bunch of tests
    public void createCustomerAddressTes()
    {
        //object needs to be created in a factory
        PersonAddress address = PersonAddressFactory.getPersonAddress("PO Box 10", "5th Street");
        
       personAddressCrudModelService = (PersonAddressCrudModelService)ctx.getBean("personAddressCrudModelService");
       personAddressCrudModelService.persist(address);  
      
       id = address.getId();
       
       Assert.assertNotNull(address);
    }
    
    @Test
    public void readCustomerAddress()
    {
        
        
    }
    
    @Test
    public void updateCustomerAddress()
    {
        
    }
    
    @Test
    public void deleteCustomerAddress()
    {
        
    }
}