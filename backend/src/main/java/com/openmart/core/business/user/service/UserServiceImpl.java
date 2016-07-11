package com.openmart.core.business.user.service;

import com.openmart.core.business.user.model.User;
import com.openmart.core.business.user.dao.UserDAO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nawa on 7/10/2016.
 */

@Service
public class UserServiceImpl implements UserService{
    private UserDAO userDAO;

    public void addUser(User user) {
        userDAO.addUser(user);
    }

    public void deleteUser(int userId) {

    }

    public void updateUser(int userId) {

    }

    public User getUser(int id) {
        return null;
    }

    public List<User> getAllUsers() {
        return null;
    }
}
