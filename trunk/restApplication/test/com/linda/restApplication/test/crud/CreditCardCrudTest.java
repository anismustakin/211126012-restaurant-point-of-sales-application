/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restApplication.test.crud;

import com.linda.restApplication.app.factories.AppFactory;

import com.linda.restApplication.domain.CreditCard;

import com.linda.restApplication.services.crud.CreditCardCrudService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
    private void createCreditCard() {
        // Create the Service Object
        creditCardCrudService = (CreditCardCrudService) ctx.getBean("creditCardsCrudService");
        Map<String, String> details = new HashMap<String, String>();
        details.put("name", "MR C.Phiri");
        details.put("number", "123456789");
        CreditCard creditCard = AppFactory.getCreditCard(details, new BigDecimal("20000.00"), new Date());
        
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
        CreditCard creditCard = creditCardCrudService.findById(id);
        //Do assertions
        Assert.assertEquals(creditCard.getBalance(), new BigDecimal("20000.00"));
      
    }

    @Test(dependsOnMethods = "readCreditCard")
    private void updateCreditCard() {
        creditCardCrudService = (CreditCardCrudService) ctx.getBean("creditCardsCrudService");

        CreditCard creditCard = creditCardCrudService.findById(id);
        
        creditCard.setBalance(new BigDecimal("30000.00"));
        // Update the Record in the Database
        creditCardCrudService.merge(creditCard);
        //Retrive the UPdata Record 
        CreditCard updatedCreditCard = creditCardCrudService.findById(id);
        
        //Test if the Change Happened
        Assert.assertEquals(updatedCreditCard.getBalance(), new BigDecimal("30000.00"));
        
    }

    @Test(dependsOnMethods = "updateCreditCard")
    private void deleteCreditCard() {
        creditCardCrudService = (CreditCardCrudService) ctx.getBean("creditCardsCrudService");
        CreditCard creditCard = creditCardCrudService.findById(id);
        //Delete Record
        creditCardCrudService.remove(creditCard);
        CreditCard deletedCreditCard = creditCardCrudService.findById(id);
        // Test to See if the Record was Deleted 
         Assert.assertNull(deletedCreditCard);
    }
}