/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restApplication.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Linda
 */
@Embeddable
public class Contact implements Serializable {
    
    private String cellNumber;
    private String phoneNumber;

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
    
}
