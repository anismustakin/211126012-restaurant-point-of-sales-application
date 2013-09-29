/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restApplication.services.crud.Impl;

import com.linda.restApplication.domain.Orders;
import com.linda.restApplication.repository.GenericDAO;
import com.linda.restApplication.services.crud.OrderCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author linda
 */
@Service("ordersCrudService")
@Transactional
public class OrdersCrudServiceImpl implements OrderCrudService {

    @Autowired
    private GenericDAO<Orders> dao;

    public final void setDao(final GenericDAO< Orders> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(Orders.class);
    }

    public OrdersCrudServiceImpl() {
    }
    @Override
    public Orders findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<Orders> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Orders entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Orders entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Orders entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        Orders v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Orders> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public Orders getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Orders> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
