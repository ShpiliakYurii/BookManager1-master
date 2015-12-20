package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Medicinecard;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yurii on 20.12.2015.
 */
@Repository
@Transactional
public class MedicinecardRepository {
    @Autowired
    SessionFactory sessionFactory;

    public List<Medicinecard> getAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from Medicinecard").list();
    }

}
