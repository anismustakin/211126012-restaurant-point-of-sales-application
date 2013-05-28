/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.services.model.Impl;

import com.linda.restaurantsalesapplication.domain.PersonAddress;
import com.linda.restaurantsalesapplication.repository.GenericDAO;
import com.linda.restaurantsalesapplication.services.model.PersonAddressCrudModelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 211126012
 */
@Service("personAddressCrudModelService")
public class PersonAddressCrudModelServiceImpl implements PersonAddressCrudModelService{

   @Autowired
    private GenericDAO<PersonAddress> dao;

    public final void setDao(final GenericDAO< PersonAddress> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(PersonAddress.class);
    }

    public PersonAddressCrudModelServiceImpl() {
    }
    @Override
    public PersonAddress findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<PersonAddress> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(PersonAddress entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(PersonAddress entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(PersonAddress entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        PersonAddress v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<PersonAddress> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public PersonAddress getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<PersonAddress> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
    
}
