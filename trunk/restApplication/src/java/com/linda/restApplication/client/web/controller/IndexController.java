/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restApplication.client.web.controller;

import com.linda.restApplication.client.web.model.Welcome;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author boniface
 */
@Controller
public class IndexController {
     @RequestMapping({"/"})
    public String home(Model model) {
         //DON'T CREATE OBJECTS LIKE THIS, USE FACTORIES
         Welcome message = new Welcome();
         message.setToday(new Date());
         message.setWelcome("Welcome to the Home Page");
         model.addAttribute("msg", message);
        return "index";
    }
    
}
