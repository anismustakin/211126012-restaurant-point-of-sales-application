/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restApplication.test.crud;

import com.linda.restApplication.app.factories.AppFactory;
import com.linda.restApplication.domain.CustomerInvoice;
import com.linda.restApplication.services.crud.CustomerInvoiceCrudService;
import java.math.BigDecimal;
import java.util.Date;
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
public class CustomerInvoiceCrudTest {

    private static ApplicationContext ctx;
    private CustomerInvoiceCrudService customerInvoiceCrudService;
    private Long id;

    public CustomerInvoiceCrudTest() {
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
    private void createCustomerInvoice() {
        // Create the Service Object
        customerInvoiceCrudService = (CustomerInvoiceCrudService) ctx.getBean("customerInvoiceCrudService");
       
        
        CustomerInvoice customerInvoice = AppFactory.getCustomerInvoice(new Date(), new BigDecimal("670.00"), "paid");
        customerInvoiceCrudService.persist(customerInvoice);
        //Collect the ID for use in later TESTS
        id = customerInvoice.getId();
        //Asssert if we have persisted the CustomerInvoice
        Assert.assertNotNull(customerInvoice);

    }

    @Test(dependsOnMethods = "createCustomerInvoice")
    private void readCustomerInvoice() {
        customerInvoiceCrudService = (CustomerInvoiceCrudService) ctx.getBean("customerInvoiceCrudService");
        //Get Tax Table By ID 
        CustomerInvoice customerInvoice = customerInvoiceCrudService.findById(id);
        //Do assertions
        Assert.assertEquals(customerInvoice.getInvoiceStatus(), "paid");
      
    }

    @Test(dependsOnMethods = "readCustomerInvoice")
    private void updateCustomerInvoice() {
        customerInvoiceCrudService = (CustomerInvoiceCrudService) ctx.getBean("customerInvoiceCrudService");

        CustomerInvoice customerInvoice = customerInvoiceCrudService.findById(id);
        
        customerInvoice.setInvoiceStatus("unpaid");
        // Update the Record in the Database
        customerInvoiceCrudService.merge(customerInvoice);
        //Retrive the UPdata Record 
        CustomerInvoice updatedCustomerInvoice = customerInvoiceCrudService.findById(id);
        
        //Test if the Change Happened
        Assert.assertEquals(updatedCustomerInvoice.getInvoiceStatus(), "unpaid");
        
    }

    @Test(dependsOnMethods = "updateCustomerInvoice")
    private void deleteCustomerInvoice() {
        customerInvoiceCrudService = (CustomerInvoiceCrudService) ctx.getBean("customerInvoiceCrudService");
        CustomerInvoice customerInvoice = customerInvoiceCrudService.findById(id);
        //Delete Record
        customerInvoiceCrudService.remove(customerInvoice);
        CustomerInvoice deletedCustomerInvoice = customerInvoiceCrudService.findById(id);
        // Test to See if the Record was Deleted 
         Assert.assertNull(deletedCustomerInvoice);
    }
}