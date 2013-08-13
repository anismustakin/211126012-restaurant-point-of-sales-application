/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.presentation.web;

import com.linda.restaurantsalesapplication.app.facade.Facade;
import com.linda.restaurantsalesapplication.domain.Customer;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author 211126012
 */
public class HomeController 
{
    private final Facade data = new Facade();
     private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    @RequestMapping({"/"})
    public String home(Model model) {
        
        List<Customer> customers = data.getCustomerCrudService().findAll();
        
        model.addAttribute("customers", customers);

        return "index";
    }

    @RequestMapping(value = "/about.html", method = RequestMethod.GET)
    public String getAbout(Model model) {
        return "about/about";
    }
    
    @RequestMapping(value = "/contact.html", method = RequestMethod.GET)
    public String getContactPage(Model model) {
        return "public/contact";
    }
    
    @RequestMapping(value = "/menu.html", method = RequestMethod.GET)
    public String getMenu(Model model) {
        return "public/menu";
    }
    
    @RequestMapping(value = "/order.html", method = RequestMethod.GET)
    public String getOrder(Model model) {
        return "public/order";
    }
}
