package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Avtorisation;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yurii on 14.10.2015.
 */

@Repository
@Transactional
public class AvtorisationRepository {

    @Autowired
    private SessionFactory sessionFactory;
    public List<Avtorisation> getAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from Avtorisation").list();
    }

    public void addUser(Avtorisation avtorisation){
        this.sessionFactory.getCurrentSession().save(avtorisation);
    }
}
