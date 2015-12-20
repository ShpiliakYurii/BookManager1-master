package com.springapp.mvc.repository;

import com.springapp.mvc.domain.CharacteristicDictionary;
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
public class CharacteristicRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<CharacteristicDictionary> getAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from CharacteristicDictionary ").list();
    }
}
