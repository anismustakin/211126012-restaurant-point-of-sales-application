/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.test.crud;

import com.linda.restaurantsalesapplication.app.factories.CustomerFactory;

import com.linda.restaurantsalesapplication.domain.CreditCards;

import com.linda.restaurantsalesapplication.services.crud.CreditCardCrudService;
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
public class CreditCardCrudTest {

    private static ApplicationContext ctx;
    private CreditCardCrudService creditCardCrudService;
    private Long id;

    public CreditCardCrudTest() {
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
    private void createCreditCard() {
        // Create the Service Object
        creditCardCrudService = (CreditCardCrudService) ctx.getBean("creditCardsCrudService");
       
        CreditCards creditCard = CustomerFactory.getCreditCard("9939034903", "VISA", new Date(), new BigDecimal("8000.00"));
        creditCardCrudService.persist(creditCard);
        //Collect the ID for use in later TESTS
        id = creditCard.getId();
        //Asssert if we have persisted the CreditCard
        Assert.assertNotNull(creditCard);

    }

    @Test(dependsOnMethods = "createCreditCard")
    private void readCreditCard() {
        creditCardCrudService = (CreditCardCrudService) ctx.getBean("creditCardsCrudService");
        //Get Tax Table By ID 
        CreditCards creditCard = creditCardCrudService.findById(id);
        //Do assertions
        Assert.assertEquals(creditCard.getCreditCardNumber() , "9939034903");
      
    }

    @Test(dependsOnMethods = "readCreditCard")
    private void updateCreditCard() {
        creditCardCrudService = (CreditCardCrudService) ctx.getBean("creditCardsCrudService");

        CreditCards creditCard = creditCardCrudService.findById(id);
        
        creditCard.setNameOnCreditCard("MASTER");
        // Update the Record in the Database
        creditCardCrudService.merge(creditCard);
        //Retrive the UPdata Record 
        CreditCards updatedCreditCard = creditCardCrudService.findById(id);
        
        //Test if the Change Happened
        Assert.assertEquals(updatedCreditCard.getNameOnCreditCard(), "MASTER");
        
    }

    @Test(dependsOnMethods = "updateCreditCard")
    private void deleteCreditCard() {
        creditCardCrudService = (CreditCardCrudService) ctx.getBean("creditCardsCrudService");
        CreditCards creditCard = creditCardCrudService.findById(id);
        //Delete Record
        creditCardCrudService.remove(creditCard);
        CreditCards deletedCreditCard = creditCardCrudService.findById(id);
        // Test to See if the Record was Deleted 
         Assert.assertNull(deletedCreditCard);
    }
}