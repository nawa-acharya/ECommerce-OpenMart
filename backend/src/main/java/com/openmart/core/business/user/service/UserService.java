package com.openmart.core.business.user.service;

import com.openmart.core.business.user.model.*;
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

    public void updateUser(User user);

    public User getUser(String userName);
    public User findByUserId(int userId);

    public List<User> getAllUsers();

    public User findUser(Login login);

    public int getId(User user);

    public User addUpdatesToUser(User user);

      User findByUsername(String username);
}
