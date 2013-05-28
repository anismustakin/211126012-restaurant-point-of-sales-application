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
public class ManagerAdmin implements Serializable, Employee {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Name name;
    @OneToOne
    private PersonAddress address;
    private Demographic demographic;
    private Contact contact;
    @OneToOne
    private Logins logins;
    
    private String empid;
    private BigDecimal salary;

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
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
        if (!(object instanceof ManagerAdmin)) {
            return false;
        }
        ManagerAdmin other = (ManagerAdmin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.linda.restaurantsalesapplication.domain.ManagerAdmin[ id=" + id + " ]";
    }

//    @Override
//    public DeliveryPerson getPerson() {
//        return null;
//    }
//    
//    @Override
//    public ManagerAdmin getManager() {
//        return new ManagerAdmin();
//    }

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
