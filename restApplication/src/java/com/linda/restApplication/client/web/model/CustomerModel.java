/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restApplication.client.web.model;

import com.linda.restApplication.domain.Contact;
import com.linda.restApplication.domain.Demographic;
import com.linda.restApplication.domain.Name;
import com.linda.restApplication.domain.PersonAddress;
import java.io.Serializable;

/**
 *
 * @author boniface
 */
public class CustomerModel implements Serializable{

    private Long id;
    private String firstName;
    private String lastName;
    private String cell;
    private String phone;
    private String race;
    private String gender;
    private String customerNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    
    

    
    
    
}
