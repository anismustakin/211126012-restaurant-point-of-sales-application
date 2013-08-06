/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.test.crud;

import com.linda.restaurantsalesapplication.app.factories.CustomerFactory;
import com.linda.restaurantsalesapplication.app.factories.OrderFactory;
import com.linda.restaurantsalesapplication.domain.Contact;
import com.linda.restaurantsalesapplication.domain.Customer;
import com.linda.restaurantsalesapplication.domain.CustomerInvoice;
import com.linda.restaurantsalesapplication.domain.Orders;
import com.linda.restaurantsalesapplication.domain.Demographic;
import com.linda.restaurantsalesapplication.domain.FoodItemContent;
import com.linda.restaurantsalesapplication.domain.Name;
import com.linda.restaurantsalesapplication.domain.OrderItem;
import com.linda.restaurantsalesapplication.services.crud.OrdersCrudService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class OrdersCrudTest {

    private static ApplicationContext ctx;
    private OrdersCrudService ordersCrudService;
    private Long id;

    public OrdersCrudTest() {
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
    private void createOrders() {
        // Create the Service Object
        ordersCrudService = (OrdersCrudService) ctx.getBean("ordersCrudService");
       
        Name name = CustomerFactory.getName("Sannie", "Meyer");
        Demographic demo = CustomerFactory.getDemographic("female", "white");
        Contact contact = CustomerFactory.getContact("787879", "87878789");
        Customer cust = CustomerFactory.getCustomer("yuw8787", name, demo, contact);
        CustomerInvoice invoice = OrderFactory.getCustomerInvoice(new Date(), new BigDecimal("889.9"), "paid");
        OrderItem item1 = OrderFactory.getOrderItem(3);
        OrderItem item2 = OrderFactory.getOrderItem(5);
        List<OrderItem> items = new ArrayList<OrderItem>();
        items.add(item2);
        items.add(item1);
        Orders orders = OrderFactory.getOrders(4444, new Date(), cust, invoice, items);
        ordersCrudService.persist(orders);
        //Collect the ID for use in later TESTS
        id = orders.getId();
        //Asssert if we have persisted the Orders
        Assert.assertNotNull(orders);

    }

    @Test(dependsOnMethods = "createOrders")
    private void readOrders() {
        ordersCrudService = (OrdersCrudService) ctx.getBean("ordersCrudService");
        //Get Tax Table By ID 
        Orders orders = ordersCrudService.findById(id);
        //Do assertions
        Assert.assertEquals(orders.getOderNumber() , 4444);
      
    }

    @Test(dependsOnMethods = "readOrders")
    private void updateOrders() {
        ordersCrudService = (OrdersCrudService) ctx.getBean("ordersCrudService");

        Orders orders = ordersCrudService.findById(id);
        
        orders.setOderNumber(55);
        // Update the Record in the Database
        ordersCrudService.merge(orders);
        //Retrive the UPdata Record 
        Orders updatedOrders = ordersCrudService.findById(id);
        
        //Test if the Change Happened
        Assert.assertEquals(updatedOrders.getOderNumber(), 55);
        
    }

    @Test(dependsOnMethods = "updateOrders")
    private void deleteOrders() {
        ordersCrudService = (OrdersCrudService) ctx.getBean("ordersCrudService");
        Orders orders = ordersCrudService.findById(id);
        //Delete Record
        ordersCrudService.remove(orders);
        Orders deletedOrders = ordersCrudService.findById(id);
        // Test to See if the Record was Deleted 
         Assert.assertNull(deletedOrders);
    }
}