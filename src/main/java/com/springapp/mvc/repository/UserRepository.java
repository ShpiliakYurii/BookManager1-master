package com.springapp.mvc.repository;

import com.springapp.mvc.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yurii on 18.10.2015.
 */
@Repository
@Transactional
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<User> getAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    public void removeUser(Integer id){
        User user = (User)this.sessionFactory.getCurrentSession().load(User.class, id);
        if(user != null){
            this.sessionFactory.getCurrentSession().delete(user);
        }
    }

    public void addUser(User user){
        this.sessionFactory.getCurrentSession().save(user);
    }
}
