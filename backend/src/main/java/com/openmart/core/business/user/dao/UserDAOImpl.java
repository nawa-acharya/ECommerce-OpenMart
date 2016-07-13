package com.openmart.core.business.user.dao;

import com.openmart.core.business.user.model.User;
import com.openmart.core.utils.Crypto;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nawa on 7/10/2016.
 */
//dao repository
@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
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
        User user =  (User) sf.getCurrentSession().get(User.class, userId);
        user.setPassword(getEncryptedPassword(user.getPassword()));
        return user;
    }

    @Override
    public List<User> getAllUser() {
        Query query = sf.getCurrentSession().createQuery("from User user");
        List<User> encryptedUsers = new ArrayList<User>();
        List<User> users = query.list();
        for(User user: users) {
            user.setPassword(getEncryptedPassword(user.getPassword()));
            encryptedUsers.add(user);
        }
        return encryptedUsers;
    }

    @Override
    public int getIdFromUser(User user) {
        String username = user.getUsername();
        Query query = sf.getCurrentSession().createQuery("select userId from User user where username= :username");
        return query.getFirstResult();
//        Query query = sf.getCurrentSession().createQuery("from User user join Login login where login.userName='" + userName + "'");
//        return query.getFirstResult();
    }

    @Override
    public User findUser(String username, String password) {
        Query query;
        query = sf.getCurrentSession().createQuery("From User user where username= :username and password= :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        User user = (User) query.uniqueResult();
        user.setPassword(getEncryptedPassword(user.getPassword()));
        return user;
    }

    @Override
    public User findUserFromName(String username) {
        Query query = sf.getCurrentSession().createQuery("from User where username= :username");
        query.setParameter("username", username);
        User user = (User) query.uniqueResult();
        user.setPassword(getEncryptedPassword(user.getPassword()));
        return user;
    }

    public String getEncryptedPassword(String password) {
        try {
            return Crypto.encrypt(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

