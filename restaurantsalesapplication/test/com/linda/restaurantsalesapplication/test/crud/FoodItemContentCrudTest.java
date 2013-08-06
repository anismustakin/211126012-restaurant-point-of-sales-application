/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.test.crud;

import com.linda.restaurantsalesapplication.app.factories.OrderFactory;
import com.linda.restaurantsalesapplication.domain.Contact;
import com.linda.restaurantsalesapplication.domain.FoodItemContent;
import com.linda.restaurantsalesapplication.domain.Demographic;
import com.linda.restaurantsalesapplication.domain.Name;
import com.linda.restaurantsalesapplication.services.crud.FoodItemContentCrudService;
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
public class FoodItemContentCrudTest {

    private static ApplicationContext ctx;
    private FoodItemContentCrudService foodItemContentCrudService;
    private Long id;

    public FoodItemContentCrudTest() {
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
    private void createFoodItemContent() {
        // Create the Service Object
        foodItemContentCrudService = (FoodItemContentCrudService) ctx.getBean("foodItemContentCrudService");
       
        
        FoodItemContent foodItemContent = OrderFactory.getFoodItemContent(45);
        foodItemContentCrudService.persist(foodItemContent);
        //Collect the ID for use in later TESTS
        id = foodItemContent.getId();
        //Asssert if we have persisted the FoodItemContent
        Assert.assertNotNull(foodItemContent);

    }

    @Test(dependsOnMethods = "createFoodItemContent")
    private void readFoodItemContent() {
        foodItemContentCrudService = (FoodItemContentCrudService) ctx.getBean("foodItemContentCrudService");
        //Get Tax Table By ID 
        FoodItemContent foodItemContent = foodItemContentCrudService.findById(id);
        //Do assertions
        Assert.assertEquals(foodItemContent.getQuantity() , 45);
      
    }

    @Test(dependsOnMethods = "readFoodItemContent")
    private void updateFoodItemContent() {
        foodItemContentCrudService = (FoodItemContentCrudService) ctx.getBean("foodItemContentCrudService");

        FoodItemContent foodItemContent = foodItemContentCrudService.findById(id);
        
        foodItemContent.setQuantity(35);
        // Update the Record in the Database
        foodItemContentCrudService.merge(foodItemContent);
        //Retrive the UPdata Record 
        FoodItemContent updatedFoodItemContent = foodItemContentCrudService.findById(id);
        
        //Test if the Change Happened
        Assert.assertEquals(updatedFoodItemContent.getQuantity(), 35);
        
    }

    @Test(dependsOnMethods = "updateFoodItemContent")
    private void deleteFoodItemContent() {
        foodItemContentCrudService = (FoodItemContentCrudService) ctx.getBean("foodItemContentCrudService");
        FoodItemContent foodItemContent = foodItemContentCrudService.findById(id);
        //Delete Record
        foodItemContentCrudService.remove(foodItemContent);
        FoodItemContent deletedFoodItemContent = foodItemContentCrudService.findById(id);
        // Test to See if the Record was Deleted 
         Assert.assertNull(deletedFoodItemContent);
    }
}