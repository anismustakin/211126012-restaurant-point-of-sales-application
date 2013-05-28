/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author linda
 */
@Entity
public class DeliveryPerson implements Serializable, Employee {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String empid;
    private Name name;
    @OneToOne
    private PersonAddress address;
    private Demographic demographic;
    private Contact contact;
    @OneToOne
    private Logins logins;
    private BigDecimal hourlyWage;
    private BigDecimal hours;
    private BigDecimal tips;

    public BigDecimal getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(BigDecimal hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

    public BigDecimal getTips() {
        return tips;
    }

    public void setTips(BigDecimal tips) {
        this.tips = tips;
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
        if (!(object instanceof DeliveryPerson)) {
            return false;
        }
        DeliveryPerson other = (DeliveryPerson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.linda.restaurantsalesapplication.domain.DeliveryPerson[ id=" + id + " ]";
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

    @Override
    public String getEmpID() {
        return empid;
    }

    
}
