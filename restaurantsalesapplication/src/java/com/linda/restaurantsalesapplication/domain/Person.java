/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.domain;

/**
 *
 * @author 211126012
 */
public interface Person {
    public Name getName();
    public Contact getContact();
    public PersonAddress getAddress();
    public Demographic getDemographic();
    public Logins getLogins();
    
}
