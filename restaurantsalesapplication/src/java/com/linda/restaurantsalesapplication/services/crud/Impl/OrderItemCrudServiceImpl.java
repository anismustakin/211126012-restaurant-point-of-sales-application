/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.services.crud.Impl;

import com.linda.restaurantsalesapplication.domain.OrderItem;
import com.linda.restaurantsalesapplication.repository.GenericDAO;
import com.linda.restaurantsalesapplication.services.crud.OrderItemCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author boniface
 */
@Service("orderItemCrudService")
@Transactional
public class OrderItemCrudServiceImpl implements OrderItemCrudService {

    @Autowired
    private GenericDAO<OrderItem> dao;

    public final void setDao(final GenericDAO< OrderItem> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(OrderItem.class);
    }

    public OrderItemCrudServiceImpl() {
    }
    @Override
    public OrderItem findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<OrderItem> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(OrderItem entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(OrderItem entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(OrderItem entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        OrderItem v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<OrderItem> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public OrderItem getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<OrderItem> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
