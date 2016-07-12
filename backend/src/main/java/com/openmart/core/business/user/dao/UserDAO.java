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

    public void updateUser(User user);

    public void deleteUser(int userId);

    public User getUser(int userId);

    public List<User> getAllUser();

    public int getIdFromUser(User user);

    public User findUser(String username, String password);

    public User findUserFromName(String username);
}
