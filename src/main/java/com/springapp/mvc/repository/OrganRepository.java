package com.springapp.mvc.repository;

import com.springapp.mvc.domain.OrganDictionary;
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
public class OrganRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<OrganDictionary> getById(int id){
        return this.sessionFactory.getCurrentSession().createQuery("from OrganDictionary where idRevisionType = "+id).list();
    }

}
