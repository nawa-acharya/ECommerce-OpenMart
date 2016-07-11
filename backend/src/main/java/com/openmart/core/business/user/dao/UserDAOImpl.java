package com.openmart.core.business.user.dao;

import com.openmart.core.business.user.model.User;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Nawa on 7/10/2016.
 */
@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext

    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public void deleteUser(int userId) {
        entityManager.remove(userId);
    }

    @Override
    public User getUser(int userId) {
        return entityManager.find(User.class, userId);
    }

    @Override
    public List<User> getAllUser() {
        Query query = entityManager.createQuery("SELECT user FROM User user");
        return query.getResultList();
    }
}

