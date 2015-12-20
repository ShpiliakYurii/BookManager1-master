package com.springapp.mvc.repository;

import com.springapp.mvc.domain.RegionDictionary;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yurii on 12.12.2015.
 */
@Repository
@Transactional
public class RegionRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public List<RegionDictionary> getAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from RegionDictionary ").list();
    }

}
