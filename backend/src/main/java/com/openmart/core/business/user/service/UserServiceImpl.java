package com.openmart.core.business.user.service;

import com.openmart.core.business.order.model.Order;
import com.openmart.core.business.user.dao.UserDAO;
import com.openmart.core.business.user.model.*;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nawa on 7/11/2016.
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void deleteUser(String userName) {
        int id = userDAO.getIdFromUser(getUser(userName));
        userDAO.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public User getUser(String userName) {
        return userDAO.findUserFromName(userName);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<User> getAllUsers() {
        return userDAO.getAllUser();
    }

    @Override
    public User findUser(Login login) {
        String username = login.getUsername();
        String password = login.getPassword();
       return userDAO.findUser(username, password);
    }

    @Override
    public int getId(User user) {
        return userDAO.getIdFromUser(user);
    }

    @Override
    public User addUpdatesToUser(User user) {
        /*User existingUser = userDAO.findUserFromName(username);
        existingUser.setProfile(profile);
        userDAO.updateUser(existingUser);*/
        try {
            int id = userDAO.getIdFromUser(user);
            User aUser = userDAO.getUser(id);
            aUser.setProfile(user.getProfile());
            userDAO.updateUser(aUser);
            return aUser;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return  userDAO.findUserFromName(username);
    }

    @Override
    public User findByUserId(int userId) {
        return  userDAO.getUser(userId);
    }
    public User setDefaultRole(User user){
        //user.setRoles();
        return user;
    }

}
