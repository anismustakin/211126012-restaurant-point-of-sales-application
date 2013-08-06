/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.presentation.web.restaurant;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author 211126012
 */
@Controller
public class NewControllerClass {
    
    //Calculates total amounts
    Facade data = new Facade();
    //always return a string cause it represents the view
    @RequestMapping("/amount.html") 
    public String getTotalAmount(Model model)
    {
        //Chapter 8 in NOTES need web.xml file under public in WEB-INF
        //must also still add the facade
        //app config will have the servlet-context.xml - there is a line you need to change to reflect ur project
        //add.jsp shows the POST method and the University Controller shows how post works
        List<Payment> payments = data.getPaymentCrudService().findAll();
        BigDecimal amount = new BigDecimal("0.00");
        //now can iterate through and add the amounts
        for(Payment payment : payments)
        {
            amount = amount.add(payment.getAmount());
        }
        model.addAttributes("amount", amount);
        return "amount/amount";
    }
}
