/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.app.factories;

import com.linda.restaurantsalesapplication.domain.PersonAddress;

/**
 *
 * @author 211126012
 */
public class PersonAddressFactory {
    
    public static PersonAddress getPersonAddress(String postal, String street)
    {
        PersonAddress address = new PersonAddress();
        address.setPostalAddress(postal);
        address.setStreetAddress(street);
        return address;
    }
    
}
