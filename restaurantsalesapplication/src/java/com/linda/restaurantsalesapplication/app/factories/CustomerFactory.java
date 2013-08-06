/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.app.factories;

import com.linda.restaurantsalesapplication.domain.Contact;
import com.linda.restaurantsalesapplication.domain.CreditCards;
import com.linda.restaurantsalesapplication.domain.Customer;
import com.linda.restaurantsalesapplication.domain.Demographic;
import com.linda.restaurantsalesapplication.domain.Logins;
import com.linda.restaurantsalesapplication.domain.Name;
import com.linda.restaurantsalesapplication.domain.PersonAddress;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author linda
 */
public class CustomerFactory {
    
    
    public static Customer getCustomer(String custno, Name name, Demographic demo, Contact contact)
    {
        Customer customer = new Customer();
        customer.setContact(contact);
        customer.setCustomerNo(custno);
        customer.setName(name);
        customer.setDemographic(demo);
        return customer;
        
    }
    
    public static PersonAddress getAddress(String street, String postal)
    {
        PersonAddress address = new PersonAddress();
        address.setStreetAddress(street);
        address.setPostalAddress(postal);
        return address;
    }
    
    
    public static Demographic getDemographic(String gender, String race)
    {
        Demographic demo = new Demographic();
        demo.setGender(gender);
        demo.setRace(race);
        return demo;
    }
    
    public static Name getName(String first, String last)
    {
        Name name = new Name();
        name.setFirstName(first);
        name.setLastName(last);
        return name;
    }
    
    public static Contact getContact(String cell, String phone)
    {
        Contact contact = new Contact();
        contact.setCellNumber(cell);
        contact.setPhoneNumber(phone);
        return contact;
    }
    
    public static Logins getLogins(String username, String password)
    {
        Logins logins = new Logins();
        logins.setUsername(username);
        logins.setPassword(password);
        return logins;
    }
    
      public static CreditCards getCreditCard(String creditnumber, String creditname, Date expiry, BigDecimal balance) {
         CreditCards creditCard = new CreditCards();
         creditCard.setCreditCardNumber(creditnumber);
         creditCard.setNameOnCreditCard(creditname);
         creditCard.setExpiryDate(expiry);
         creditCard.setBalance(balance);
        return creditCard;
    }
    
    
}
