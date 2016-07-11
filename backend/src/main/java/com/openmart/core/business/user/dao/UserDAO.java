package com.openmart.core.business.user.dao;

import com.openmart.core.business.user.model.User;

import java.util.List;

/**
 * Created by Nawa on 7/10/2016.
 */
public interface UserDAO {
    public void addUser(User user);
    public User updateUser(User user);
    public void deleteUser(int userId);
    public User getUser(int userId);
    public List<User> getAllUser();
}
