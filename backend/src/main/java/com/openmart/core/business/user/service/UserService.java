package com.openmart.core.business.user.service;

import com.openmart.core.business.user.model.User;

import java.util.List;

/**
 * Created by Nawa on 7/10/2016.
 */
public interface UserService {
    public void addUser(User user);
    public void deleteUser(int userId);
    public void updateUser(int userId);
    public User getUser(int id);
    public List<User> getAllUsers();

}
