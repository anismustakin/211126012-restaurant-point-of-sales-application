/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.test.crud;

import com.linda.restaurantsalesapplication.app.factories.OrderFactory;
import com.linda.restaurantsalesapplication.domain.Contact;
import com.linda.restaurantsalesapplication.domain.OrderItem;
import com.linda.restaurantsalesapplication.domain.Demographic;
import com.linda.restaurantsalesapplication.domain.Name;
import com.linda.restaurantsalesapplication.services.crud.OrderItemCrudService;
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
public class OrderItemCrudTest {

    private static ApplicationContext ctx;
    private OrderItemCrudService orderItemCrudService;
    private Long id;

    public OrderItemCrudTest() {
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
    private void createOrderItem() {
        // Create the Service Object
        orderItemCrudService = (OrderItemCrudService) ctx.getBean("orderItemCrudService");
       
        
        OrderItem orderItem = OrderFactory.getOrderItem(12);
        orderItemCrudService.persist(orderItem);
        //Collect the ID for use in later TESTS
        id = orderItem.getId();
        //Asssert if we have persisted the OrderItem
        Assert.assertNotNull(orderItem);

    }

    @Test(dependsOnMethods = "createOrderItem")
    private void readOrderItem() {
        orderItemCrudService = (OrderItemCrudService) ctx.getBean("orderItemCrudService");
        //Get Tax Table By ID 
        OrderItem orderItem = orderItemCrudService.findById(id);
        //Do assertions
        Assert.assertEquals(orderItem.getQuantity() , 12);
      
    }

    @Test(dependsOnMethods = "readOrderItem")
    private void updateOrderItem() {
        orderItemCrudService = (OrderItemCrudService) ctx.getBean("orderItemCrudService");

        OrderItem orderItem = orderItemCrudService.findById(id);
        
        orderItem.setQuantity(13);
        // Update the Record in the Database
        orderItemCrudService.merge(orderItem);
        //Retrive the UPdata Record 
        OrderItem updatedOrderItem = orderItemCrudService.findById(id);
        
        //Test if the Change Happened
        Assert.assertEquals(updatedOrderItem.getQuantity(), 13);
        
    }

    @Test(dependsOnMethods = "updateOrderItem")
    private void deleteOrderItem() {
        orderItemCrudService = (OrderItemCrudService) ctx.getBean("orderItemCrudService");
        OrderItem orderItem = orderItemCrudService.findById(id);
        //Delete Record
        orderItemCrudService.remove(orderItem);
        OrderItem deletedOrderItem = orderItemCrudService.findById(id);
        // Test to See if the Record was Deleted 
         Assert.assertNull(deletedOrderItem);
    }
}