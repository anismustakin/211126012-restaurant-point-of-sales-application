/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.test.crud;

import com.linda.restaurantsalesapplication.app.factories.ComboMealFactory;
import com.linda.restaurantsalesapplication.domain.ComboMeal;
import com.linda.restaurantsalesapplication.services.crud.ComboMealCrudService;
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
public class ComboMealCrudTest {

    private static ApplicationContext ctx;
    private ComboMealCrudService comboMealCrudService;
    private Long id;

    public ComboMealCrudTest() {
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
    private void createComboMeal() {
        // Create the Service Object
        comboMealCrudService = (ComboMealCrudService) ctx.getBean("comboMealCrudService");
       
        ComboMeal comboMeal = ComboMealFactory.getComboMeal("Deluxe", new BigDecimal("15.00"));
        comboMealCrudService.persist(comboMeal);
        //Collect the ID for use in later TESTS
        id = comboMeal.getId();
        //Asssert if we have persisted the ComboMeal
        Assert.assertNotNull(comboMeal);

    }

    @Test(dependsOnMethods = "createComboMeal")
    private void readComboMeal() {
        comboMealCrudService = (ComboMealCrudService) ctx.getBean("comboMealCrudService");
        //Get Tax Table By ID 
        ComboMeal comboMeal = comboMealCrudService.findById(id);
        //Do assertions
        Assert.assertEquals(comboMeal.getComboName() , "Deluxe");
      
    }

    @Test(dependsOnMethods = "readComboMeal")
    private void updateComboMeal() {
        comboMealCrudService = (ComboMealCrudService) ctx.getBean("comboMealCrudService");

        ComboMeal comboMeal = comboMealCrudService.findById(id);
        
        comboMeal.setDiscAmount(new BigDecimal("7.50"));
        // Update the Record in the Database
        comboMealCrudService.merge(comboMeal);
        //Retrive the UPdata Record 
        ComboMeal updatedComboMeal = comboMealCrudService.findById(id);
        
        //Test if the Change Happened
        Assert.assertEquals(updatedComboMeal.getDiscAmount(), new BigDecimal("7.50"));
        
    }

    @Test(dependsOnMethods = "updateComboMeal")
    private void deleteComboMeal() {
        comboMealCrudService = (ComboMealCrudService) ctx.getBean("comboMealCrudService");
        ComboMeal comboMeal = comboMealCrudService.findById(id);
        //Delete Record
        comboMealCrudService.remove(comboMeal);
        ComboMeal deletedComboMeal = comboMealCrudService.findById(id);
        // Test to See if the Record was Deleted 
         Assert.assertNull(deletedComboMeal);
    }
}