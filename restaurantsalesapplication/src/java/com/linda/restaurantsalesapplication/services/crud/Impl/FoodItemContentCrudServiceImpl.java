/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.services.crud.Impl;

import com.linda.restaurantsalesapplication.domain.FoodItemContent;
import com.linda.restaurantsalesapplication.repository.GenericDAO;
import com.linda.restaurantsalesapplication.services.crud.FoodItemContentCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author boniface
 */
@Service("foodItemContentCrudService")
@Transactional
public class FoodItemContentCrudServiceImpl implements FoodItemContentCrudService {

    @Autowired
    private GenericDAO<FoodItemContent> dao;

    public final void setDao(final GenericDAO< FoodItemContent> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(FoodItemContent.class);
    }

    public FoodItemContentCrudServiceImpl() {
    }
    @Override
    public FoodItemContent findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<FoodItemContent> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(FoodItemContent entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(FoodItemContent entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(FoodItemContent entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        FoodItemContent v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<FoodItemContent> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public FoodItemContent getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<FoodItemContent> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
