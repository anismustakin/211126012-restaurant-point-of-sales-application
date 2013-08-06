/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.services.crud.Impl;

import com.linda.restaurantsalesapplication.domain.FoodItem;
import com.linda.restaurantsalesapplication.repository.GenericDAO;
import com.linda.restaurantsalesapplication.services.crud.FoodItemCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author boniface
 */
@Service("foodItemCrudService")
@Transactional
public class FoodItemCrudServiceImpl implements FoodItemCrudService {

    @Autowired
    private GenericDAO<FoodItem> dao;

    public final void setDao(final GenericDAO< FoodItem> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(FoodItem.class);
    }

    public FoodItemCrudServiceImpl() {
    }
    @Override
    public FoodItem findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<FoodItem> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(FoodItem entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(FoodItem entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(FoodItem entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        FoodItem v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<FoodItem> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public FoodItem getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<FoodItem> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
