/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restApplication.app.factories;

import com.linda.restApplication.domain.Contact;
import com.linda.restApplication.domain.CreditCard;
import com.linda.restApplication.domain.Customer;
import com.linda.restApplication.domain.CustomerInvoice;
import com.linda.restApplication.domain.Demographic;
import com.linda.restApplication.domain.FoodCategory;
import com.linda.restApplication.domain.FoodItem;
import com.linda.restApplication.domain.Name;
import com.linda.restApplication.domain.OrderItem;
import com.linda.restApplication.domain.Orders;
import com.linda.restApplication.domain.PersonAddress;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Linda
 */
public class AppFactory {
    
    public static CreditCard getCreditCard(Map<String, String> details, BigDecimal balance, Date expiryDate) {
         CreditCard creditCard = new CreditCard();
         creditCard.setCreditNumber(details.get("number"));
         creditCard.setNameOnCreditCard(details.get("name"));
         creditCard.setBalance(balance);
         creditCard.setExpiryDate(expiryDate);
        return creditCard;
    }
    
    public static Name getName(String first, String last)
    {
         Name name1 = new Name();
         name1.setFirstName(first);
         name1.setLastName(last);
         return name1; 
    }
    
    public static Demographic getDemographic(String gender, String race)
    {
         Demographic demo1 = new Demographic();
         demo1.setGender(gender);
         demo1.setRace(race);
         return demo1;
    }
    
    public static Contact getContact(String cell, String phone)
    {
         Contact cont1 = new Contact();
         cont1.setCellNumber(cell);
         cont1.setPhoneNumber(phone);
         return cont1;
    }
     
        public static Customer getCustomer(String custNo, Name name, Contact contact, Demographic demo) {
         Customer customer = new Customer();
         customer.setCustomerNumber(custNo);
         customer.setName(name);
         customer.setContact(contact);
         customer.setDemographic(demo);
         return customer;
    }
    
   public static PersonAddress getPersonAddress(String street, String postal) {
        PersonAddress personAddress = new PersonAddress();
         personAddress.setPostalAddress(postal);
         personAddress.setStreetAddress(street);
        return personAddress;
    }
     
   
    public static Orders getOrders(int orderNumber, Date orderDate) {
        Orders orders = new Orders();
         orders.setOrderNumber(orderNumber);
         orders.setOrderDate(orderDate);
        return orders ;
    }
    
    public static CustomerInvoice getCustomerInvoice(Date invoiceDate, BigDecimal orderAmount, String inStatus) {
        CustomerInvoice customerInvoice = new CustomerInvoice();
         customerInvoice.setInvoiceDate(invoiceDate);
         customerInvoice.setOrderAmount(orderAmount);
         customerInvoice.setInvoiceStatus(inStatus);
        return customerInvoice;
    }

     public static OrderItem getOrderItem(int quantity) {
        OrderItem orderItem = new OrderItem();
         orderItem.setQuantity(quantity);
        return orderItem;
    }
     
    public static FoodItem getFoodItem(String foodName, BigDecimal unitPrice, int invent, int sales) {
        FoodItem item = new FoodItem();
         item.setFoodItemName(foodName);
         item.setUnitPrice(unitPrice);
         item.setInventory(invent);
         item.setSales(sales);
        return item;
    }
     
      public static FoodCategory getFoodCategory(String name) {
        FoodCategory foodCategory = new FoodCategory();
         foodCategory.setCategoryName(name);
        return foodCategory;
    }
    
    
}
