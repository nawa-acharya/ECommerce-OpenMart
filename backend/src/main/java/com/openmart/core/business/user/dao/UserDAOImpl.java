package com.openmart.core.business.user.dao;

import com.openmart.core.business.user.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nawa on 7/10/2016.
 */
@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sf;
 @Transactional(propagation = Propagation.SUPPORTS)
    public void serSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void addUser(User user) {
        sf.getCurrentSession().persist(user);
    }

    @Override
    public void updateUser(User user) {
        sf.getCurrentSession().update(user);
    }

    @Override
    public void deleteUser(int userId) {
        sf.getCurrentSession().delete(userId);
    }

    @Override
    public User getUser(int userId) {
        return (User) sf.getCurrentSession().get(User.class, userId);
    }

    @Override
    public List<User> getAllUser() {
        org.hibernate.Query query = sf.getCurrentSession().createQuery("FROM User user");
        return query.list();
    }

    @Override
    public int getIdFromUserName(String userName) {
        Query query = sf.getCurrentSession().createQuery("FROM User user join Login login where login.userName='" + userName + "'");
        return query.getFirstResult();
    }

}

