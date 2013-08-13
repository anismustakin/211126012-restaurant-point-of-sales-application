/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.app.facade;

import com.linda.restaurantsalesapplication.app.conf.GetContext;
import com.linda.restaurantsalesapplication.services.crud.ComboMealCrudService;
import com.linda.restaurantsalesapplication.services.crud.CreditCardCrudService;
import com.linda.restaurantsalesapplication.services.crud.CustomerCrudService;
import com.linda.restaurantsalesapplication.services.crud.CustomerInvoiceCrudService;
import com.linda.restaurantsalesapplication.services.crud.FoodCategoryCrudService;
import com.linda.restaurantsalesapplication.services.crud.FoodItemContentCrudService;
import com.linda.restaurantsalesapplication.services.crud.FoodItemCrudService;
import com.linda.restaurantsalesapplication.services.crud.OrderItemCrudService;
import com.linda.restaurantsalesapplication.services.crud.OrdersCrudService;
import com.linda.restaurantsalesapplication.services.crud.StockItemsCrudService;
import java.io.Serializable;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author boniface
 */
public class Facade implements Serializable {

    private final static ApplicationContext ctx = GetContext.getApplicationContext();
    private ComboMealCrudService comboMealCrudService;
    private CreditCardCrudService  creditCardCrudService;
    private CustomerCrudService customerCrudService;
    private CustomerInvoiceCrudService customerInvoiceCrudService;
    private FoodCategoryCrudService foodCategoryCrudService;
    private FoodItemContentCrudService foodItemContentCrudService;
    private FoodItemCrudService foodItemCrudService; 
    private OrderItemCrudService orderItemCrudService;
    private OrdersCrudService ordersCrudService;
    private StockItemsCrudService stockItemsCrudService;

    public ComboMealCrudService getComboMealCrudService() {
        comboMealCrudService = (ComboMealCrudService) ctx.getBean("comboMealCrudService");
        return comboMealCrudService;
    }

    public CreditCardCrudService  getCreditCardCrudService () {
        creditCardCrudService  = (CreditCardCrudService ) ctx.getBean("creditCardCrudService");
        return creditCardCrudService;
    }

    public CustomerCrudService getCustomerCrudService() {
        customerCrudService = (CustomerCrudService) ctx.getBean("customerCrudService");
        return customerCrudService;
    }
    
    public CustomerInvoiceCrudService getCustomerInvoiceCrudService() {
        customerInvoiceCrudService = (CustomerInvoiceCrudService) ctx.getBean("customerInvoiceCrudService");
        return customerInvoiceCrudService;
    }
    
    public FoodCategoryCrudService getFoodCategoryCrudService() {
        foodCategoryCrudService = (FoodCategoryCrudService) ctx.getBean("foodCategoryCrudService");
        return foodCategoryCrudService;
    }
    
    public FoodItemContentCrudService getFoodItemContentCrudService() {
        foodItemContentCrudService = (FoodItemContentCrudService) ctx.getBean("foodItemContentCrudService");
        return foodItemContentCrudService;
    }
    
    public FoodItemCrudService getFoodItemCrudService() {
        foodItemCrudService = (FoodItemCrudService) ctx.getBean("foodItemCrudService");
        return foodItemCrudService;
    }
    
    public OrderItemCrudService getOrderItemCrudService(){
        orderItemCrudService = (OrderItemCrudService) ctx.getBean("orderItemCrudService");
        return orderItemCrudService;
    }
    
    public OrdersCrudService getOrdersCrudService(){
        ordersCrudService = (OrdersCrudService) ctx.getBean("ordersCrudService");
        return ordersCrudService;
    }
    
     public StockItemsCrudService getStockItemsCrudService(){
        stockItemsCrudService = (StockItemsCrudService) ctx.getBean("stockItemsCrudService");
        return stockItemsCrudService;
    }
}
