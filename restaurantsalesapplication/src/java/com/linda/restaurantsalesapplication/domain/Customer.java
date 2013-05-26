/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author 211126012
 */
@Entity
public class Customer implements Serializable, Person{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String customerNo;
    private Name name;
    @OneToOne
    private PersonAddress address;
    private Demographic demographic;
    private Contact contact;
    @OneToOne
    private Logins logins;
    @OneToMany
    private List<CreditCards> cards;
    @OneToMany
    private List<Orders> orders;

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
    
    

    public List<CreditCards> getCards() {
        return cards;
    }

    public void setCards(List<CreditCards> cards) {
        this.cards = cards;
    }
    
    

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.linda.restaurantsalesapplication.domain.Customer[ id=" + id + " ]";
    }

    @Override
    public Name getName() {
        return name;
    }

    @Override
    public Contact getContact() {
       return contact;
    }

    @Override
    public PersonAddress getAddress() {
        return address;
    }

    @Override
    public Demographic getDemographic() {
       return demographic;
    }

    @Override
    public Logins getLogins() {
        return logins;
    }
    
}
