/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.services.crud.Impl;

import com.linda.restaurantsalesapplication.domain.CreditCards;
import com.linda.restaurantsalesapplication.repository.GenericDAO;
import com.linda.restaurantsalesapplication.services.crud.CreditCardCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author boniface
 */
@Service("creditCardsCrudService")
@Transactional
public class CreditCardCrudServiceImpl implements CreditCardCrudService {

    @Autowired
    private GenericDAO<CreditCards> dao;

    public final void setDao(final GenericDAO< CreditCards> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClazz(CreditCards.class);
    }

    public CreditCardCrudServiceImpl() {
    }
    @Override
    public CreditCards findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<CreditCards> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(CreditCards entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(CreditCards entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(CreditCards entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        CreditCards v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<CreditCards> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public CreditCards getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<CreditCards> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
