/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.services.crud.Impl;

import com.linda.restaurantsalesapplication.domain.ComboMeal;
import com.linda.restaurantsalesapplication.repository.GenericDAO;
import com.linda.restaurantsalesapplication.services.crud.ComboMealCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author boniface
 */
@Service("comboMealCrudService")
@Transactional
public class ComboMealCrudServiceImpl implements ComboMealCrudService {

    @Autowired
    private GenericDAO<ComboMeal> dao;

    public final void setDao(final GenericDAO< ComboMeal> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(ComboMeal.class);
    }

    public ComboMealCrudServiceImpl() {
    }
    @Override
    public ComboMeal findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<ComboMeal> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(ComboMeal entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(ComboMeal entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(ComboMeal entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        ComboMeal v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<ComboMeal> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public ComboMeal getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<ComboMeal> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
