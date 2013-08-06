/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.app.factories;

import com.linda.restaurantsalesapplication.domain.Customer;
import com.linda.restaurantsalesapplication.domain.CustomerInvoice;
import com.linda.restaurantsalesapplication.domain.FoodCategory;
import com.linda.restaurantsalesapplication.domain.FoodItem;
import com.linda.restaurantsalesapplication.domain.FoodItemContent;
import com.linda.restaurantsalesapplication.domain.OrderItem;
import com.linda.restaurantsalesapplication.domain.Orders;
import com.linda.restaurantsalesapplication.domain.StockItems;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author linda
 */
public class OrderFactory 
{
    public static Orders getOrders(int OrderNumber, Date orderDate, Customer cust, CustomerInvoice custInv, List<OrderItem> items)
    {
        Orders orders = new Orders();
        orders.setOderNumber(OrderNumber);
        orders.setOrderDate(orderDate);
        orders.setCustomer(cust);
        orders.setCustomerInvoice(custInv);
        orders.setItems(items);
        return orders;
    }
    
    public static CustomerInvoice getCustomerInvoice(Date invdate, BigDecimal amount, String status)
    {
        CustomerInvoice invoice = new CustomerInvoice();
        invoice.setInvoiceDate(invdate);
        invoice.setInvoiceAmount(amount);
        invoice.setInvoiceStatus(status);
        return invoice;
    }
    
    public static OrderItem getOrderItem(int quant)
    {
        OrderItem item = new OrderItem();
        item.setQuantity(quant);
        return item;
        
    }
    
    public static FoodItem getFoodItem(String name, int invent, int sales, BigDecimal price, List<FoodItemContent> contents)
    {
        FoodItem item = new FoodItem();
        item.setItemName(name);
        item.setInventory(invent);
        item.setSales(sales);
        item.setPrice(price);
        item.setContents(contents);
        return item;
        
    }
    
    public static FoodCategory getFoodCategory(String name)
    {
        FoodCategory category = new FoodCategory();
        category.setCategoryName(name);
        return category;
    }
    
    public static FoodItemContent getFoodItemContent(int quantity)
    {
        FoodItemContent content = new FoodItemContent();
        content.setQuantity(quantity);
        return content;
    }
    
    public static StockItems getStockItems(String number, BigDecimal invent, BigDecimal price)
    {
        StockItems items = new StockItems();
        items.setStockNumber(number);
        items.setInventory(invent);
        items.setCostPrice(price);
        return items;
    }
    
    
}
