/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restApplication.services.crud.Impl;

import com.linda.restApplication.domain.CustomerInvoice;
import com.linda.restApplication.repository.GenericDAO;
import com.linda.restApplication.services.crud.CustomerInvoiceCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author linda
 */
@Service("customerInvoiceCrudService")
@Transactional
public class CustomerInvoiceCrudServiceImpl implements CustomerInvoiceCrudService {

    @Autowired
    private GenericDAO<CustomerInvoice> dao;

    public final void setDao(final GenericDAO< CustomerInvoice> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(CustomerInvoice.class);
    }

    public CustomerInvoiceCrudServiceImpl() {
    }
    @Override
    public CustomerInvoice findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<CustomerInvoice> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(CustomerInvoice entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(CustomerInvoice entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(CustomerInvoice entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        CustomerInvoice v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<CustomerInvoice> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public CustomerInvoice getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<CustomerInvoice> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
