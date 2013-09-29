/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restApplication.test.crud;

import com.linda.restApplication.app.factories.AppFactory;
import com.linda.restApplication.domain.FoodItem;
import com.linda.restApplication.services.crud.FoodItemCrudService;
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
 * @author linda
 */
public class FoodItemCrudTest {

    private static ApplicationContext ctx;
    private FoodItemCrudService foodItemCrudService;
    private Long id;

    public FoodItemCrudTest() {
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
    private void createFoodItem() {
        // Create the Service Object
        foodItemCrudService = (FoodItemCrudService) ctx.getBean("foodItemCrudService");
   
        FoodItem foodItem = AppFactory.getFoodItem("Burger", new BigDecimal("12.00"), 5, 10);
        foodItemCrudService.persist(foodItem);
        //Collect the ID for use in later TESTS
        id = foodItem.getId();
        //Asssert if we have persisted the FoodItem
        Assert.assertNotNull(foodItem);

    }

    @Test(dependsOnMethods = "createFoodItem")
    private void readFoodItem() {
        foodItemCrudService = (FoodItemCrudService) ctx.getBean("foodItemCrudService");
        //Get Tax Table By ID 
        FoodItem foodItem = foodItemCrudService.findById(id);
        //Do assertions
        Assert.assertEquals(foodItem.getFoodItemName() , "Burger");
      
    }

    @Test(dependsOnMethods = "readFoodItem")
    private void updateFoodItem() {
        foodItemCrudService = (FoodItemCrudService) ctx.getBean("foodItemCrudService");

        FoodItem foodItem = foodItemCrudService.findById(id);
        
        foodItem.setFoodItemName("Steak");
        // Update the Record in the Database
        foodItemCrudService.merge(foodItem);
        //Retrive the UPdata Record 
        FoodItem updatedFoodItem = foodItemCrudService.findById(id);
        
        //Test if the Change Happened
        Assert.assertEquals(updatedFoodItem.getFoodItemName(), "Steak");
        
    }

    @Test(dependsOnMethods = "updateFoodItem")
    private void deleteFoodItem() {
        foodItemCrudService = (FoodItemCrudService) ctx.getBean("foodItemCrudService");
        FoodItem foodItem = foodItemCrudService.findById(id);
        //Delete Record
        foodItemCrudService.remove(foodItem);
        FoodItem deletedFoodItem = foodItemCrudService.findById(id);
        // Test to See if the Record was Deleted 
         Assert.assertNull(deletedFoodItem);
    }
}