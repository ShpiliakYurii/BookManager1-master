package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Revisiontype;
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
public class RevisionTypeRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Revisiontype> getAll(){
        return sessionFactory.getCurrentSession().createQuery("from Revisiontype ").list();
    }


}
