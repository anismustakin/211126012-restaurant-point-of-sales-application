/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restApplication.test.crud;

import com.linda.restApplication.app.factories.AppFactory;
import com.linda.restApplication.domain.FoodCategory;
import com.linda.restApplication.services.crud.FoodCategoryCrudService;
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
public class FoodCategoryCrudTest {

    private static ApplicationContext ctx;
    private FoodCategoryCrudService foodCategoryCrudService;
    private Long id;

    public FoodCategoryCrudTest() {
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
    private void createFoodCategory() {
        // Create the Service Object
        foodCategoryCrudService = (FoodCategoryCrudService) ctx.getBean("foodCategoryCrudService");
       
        FoodCategory foodCategory = AppFactory.getFoodCategory("mains");
        foodCategoryCrudService.persist(foodCategory);
        //Collect the ID for use in later TESTS
        id = foodCategory.getId();
        //Asssert if we have persisted the FoodCategory
        Assert.assertNotNull(foodCategory);

    }

    @Test(dependsOnMethods = "createFoodCategory")
    private void readFoodCategory() {
        foodCategoryCrudService = (FoodCategoryCrudService) ctx.getBean("foodCategoryCrudService");
        //Get Tax Table By ID 
        FoodCategory foodCategory = foodCategoryCrudService.findById(id);
        //Do assertions
        Assert.assertEquals(foodCategory.getCategoryName() , "mains");
      
    }

    @Test(dependsOnMethods = "readFoodCategory")
    private void updateFoodCategory() {
        foodCategoryCrudService = (FoodCategoryCrudService) ctx.getBean("foodCategoryCrudService");

        FoodCategory foodCategory = foodCategoryCrudService.findById(id);
        
        foodCategory.setCategoryName("dessert");
        // Update the Record in the Database
        foodCategoryCrudService.merge(foodCategory);
        //Retrive the UPdata Record 
        FoodCategory updatedFoodCategory = foodCategoryCrudService.findById(id);
        
        //Test if the Change Happened
        Assert.assertEquals(updatedFoodCategory.getCategoryName(), "dessert");
        
    }

    @Test(dependsOnMethods = "updateFoodCategory")
    private void deleteFoodCategory() {
        foodCategoryCrudService = (FoodCategoryCrudService) ctx.getBean("foodCategoryCrudService");
        FoodCategory foodCategory = foodCategoryCrudService.findById(id);
        //Delete Record
        foodCategoryCrudService.remove(foodCategory);
        FoodCategory deletedFoodCategory = foodCategoryCrudService.findById(id);
        // Test to See if the Record was Deleted 
         Assert.assertNull(deletedFoodCategory);
    }
}