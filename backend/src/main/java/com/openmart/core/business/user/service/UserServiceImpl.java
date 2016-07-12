package com.openmart.core.business.user.service;

import com.openmart.core.business.order.model.Order;
import com.openmart.core.business.user.dao.UserDAO;
import com.openmart.core.business.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nawa on 7/11/2016.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addUser(User user) {
        System.out.println("Got here" + user.toString());
        userDAO.addUser(user);
    }

    @Override
    public void deleteUser(String userName) {
        int id = userDAO.getIdFromUserName(userName);
        userDAO.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public User getUser(String userName) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<User> getAllUsers() {
        return userDAO.getAllUser();
    }

}
