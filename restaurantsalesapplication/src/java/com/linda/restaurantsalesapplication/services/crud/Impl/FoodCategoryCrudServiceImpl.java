/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.services.crud.Impl;

import com.linda.restaurantsalesapplication.domain.FoodCategory;
import com.linda.restaurantsalesapplication.repository.GenericDAO;
import com.linda.restaurantsalesapplication.services.crud.FoodCategoryCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author boniface
 */
@Service("foodCategoryCrudService")
@Transactional
public class FoodCategoryCrudServiceImpl implements FoodCategoryCrudService {

    @Autowired
    private GenericDAO<FoodCategory> dao;

    public final void setDao(final GenericDAO< FoodCategory> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(FoodCategory.class);
    }

    public FoodCategoryCrudServiceImpl() {
    }
    @Override
    public FoodCategory findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<FoodCategory> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(FoodCategory entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(FoodCategory entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(FoodCategory entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        FoodCategory v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<FoodCategory> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public FoodCategory getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<FoodCategory> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
