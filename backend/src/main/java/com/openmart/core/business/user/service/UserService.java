package com.openmart.core.business.user.service;

import com.openmart.core.business.user.model.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nawa on 7/10/2016.
 */
public interface UserService {
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addUser(User user);
    public void deleteUser(String userName);
    public void updateUser(int id);
    public User getUser(String userName);
    public List<User> getAllUsers();

}
