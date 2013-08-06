/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.test.crud;

import com.linda.restaurantsalesapplication.app.factories.OrderFactory;
import com.linda.restaurantsalesapplication.domain.Contact;
import com.linda.restaurantsalesapplication.domain.StockItems;
import com.linda.restaurantsalesapplication.domain.Demographic;
import com.linda.restaurantsalesapplication.domain.Name;
import com.linda.restaurantsalesapplication.services.crud.StockItemsCrudService;
import java.math.BigDecimal;
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
public class StockItemsCrudTest {

    private static ApplicationContext ctx;
    private StockItemsCrudService stockItemsCrudService;
    private Long id;

    public StockItemsCrudTest() {
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
    private void createStockItems() {
        // Create the Service Object
        stockItemsCrudService = (StockItemsCrudService) ctx.getBean("stockItemsCrudService");
       
        
        StockItems stockItems = OrderFactory.getStockItems("787897", new BigDecimal("87.00"), new BigDecimal("900.00"));
        stockItemsCrudService.persist(stockItems);
        //Collect the ID for use in later TESTS
        id = stockItems.getId();
        //Asssert if we have persisted the StockItems
        Assert.assertNotNull(stockItems);

    }

    @Test(dependsOnMethods = "createStockItems")
    private void readStockItems() {
        stockItemsCrudService = (StockItemsCrudService) ctx.getBean("stockItemsCrudService");
        //Get Tax Table By ID 
        StockItems stockItems = stockItemsCrudService.findById(id);
        //Do assertions
        Assert.assertEquals(stockItems.getStockNumber() , "787897");
      
    }

    @Test(dependsOnMethods = "readStockItems")
    private void updateStockItems() {
        stockItemsCrudService = (StockItemsCrudService) ctx.getBean("stockItemsCrudService");

        StockItems stockItems = stockItemsCrudService.findById(id);
        
        stockItems.setStockNumber("99");
        // Update the Record in the Database
        stockItemsCrudService.merge(stockItems);
        //Retrive the UPdata Record 
        StockItems updatedStockItems = stockItemsCrudService.findById(id);
        
        //Test if the Change Happened
        Assert.assertEquals(updatedStockItems.getStockNumber(), "99");
        
    }

    @Test(dependsOnMethods = "updateStockItems")
    private void deleteStockItems() {
        stockItemsCrudService = (StockItemsCrudService) ctx.getBean("stockItemsCrudService");
        StockItems stockItems = stockItemsCrudService.findById(id);
        //Delete Record
        stockItemsCrudService.remove(stockItems);
        StockItems deletedStockItems = stockItemsCrudService.findById(id);
        // Test to See if the Record was Deleted 
         Assert.assertNull(deletedStockItems);
    }
}