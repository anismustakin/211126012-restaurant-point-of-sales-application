/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restApplication.client.web.controller;

import com.linda.restApplication.client.web.model.CustomerModel;
import com.linda.restApplication.domain.Customer;
import com.linda.restApplication.services.CustomerService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author boniface
 */
@Controller
@SessionAttributes
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customerform", method = RequestMethod.GET)
    public String getCustomerForm(Model model) {
        CustomerModel customerModel = new CustomerModel();
        model.addAttribute("customerModel", customerModel);
        return "customer/form";
    }

    @RequestMapping(value = "/createcustomer", method = RequestMethod.POST)
    public String createCustomers(@ModelAttribute("customerModel") @Valid CustomerModel customer,
            BindingResult result, Model model) {
        customerService.createCustomer(customer);

        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "customer/customers";
    }

    @RequestMapping(value = "/customereditform", method = RequestMethod.GET)
    public String getCustomerEditForm(Model model) {
        CustomerModel customerModel = new CustomerModel();
        model.addAttribute("customer", customerModel);
        return "customer/form";
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String getCustomers(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "customer/customers";
    }

    @RequestMapping(value = "/editcustomer", method = RequestMethod.GET)
    public String editCustomers(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "customer/customers";
    }

    @RequestMapping(value = "/deletecustomer", method = RequestMethod.GET,params = {"customercodeId"})
    public String deleteCustomers(@RequestParam("customercodeId") Long customercodeId,Model model) {
        customerService.deleteCustomer(customercodeId);
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "customer/customers";
    }

    @RequestMapping(value = "private/editCustomerForm.html", method = RequestMethod.GET, params = {"customercodeId"})
    public String editCustomerForm(@RequestParam("customercodeId") String customercodeId, Model model) {

        return "editIndividualCustomerForm";
    }
}
