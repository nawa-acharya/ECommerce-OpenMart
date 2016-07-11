package com.openmart.core.business.user.dao;

import com.openmart.core.business.user.model.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nawa on 7/10/2016.
 */
public interface UserDAO {
    @Transactional(propagation = Propagation.MANDATORY)
    public void addUser(User user);
    public void updateUser(int userId);
    public void deleteUser(int userId);
    public User getUser(int userId);
    public List<User> getAllUser();
    public int getIdFromUserName (String userName);
}
