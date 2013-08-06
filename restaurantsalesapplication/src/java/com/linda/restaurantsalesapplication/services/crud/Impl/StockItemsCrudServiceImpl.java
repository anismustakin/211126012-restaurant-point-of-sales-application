/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.services.crud.Impl;

import com.linda.restaurantsalesapplication.domain.StockItems;
import com.linda.restaurantsalesapplication.repository.GenericDAO;
import com.linda.restaurantsalesapplication.services.crud.StockItemsCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author boniface
 */
@Service("stockItemsCrudService")
@Transactional
public class StockItemsCrudServiceImpl implements StockItemsCrudService {

    @Autowired
    private GenericDAO<StockItems> dao;

    public final void setDao(final GenericDAO< StockItems> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(StockItems.class);
    }

    public StockItemsCrudServiceImpl() {
    }
    @Override
    public StockItems findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<StockItems> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(StockItems entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(StockItems entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(StockItems entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        StockItems v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<StockItems> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public StockItems getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<StockItems> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
