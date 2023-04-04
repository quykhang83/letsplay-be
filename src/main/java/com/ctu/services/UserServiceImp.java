package com.ctu.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.ctu.daos.StatusDAO;
import com.ctu.daos.UserDAO;
import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.IdNotFoundException;
import com.ctu.exception.InternalServerError;
import com.ctu.model.User;

@Stateless
public class UserServiceImp implements UserService {
    @Inject
    UserDAO userDAO;
    @Inject
    StatusDAO statusDAO;

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUserById(Long id) {
        if (id < 1) {
            throw new IdNotFoundException(id);
        }
        try {
            return userDAO.getUserById(id);
        } catch (EmptyEntityException ex) {
            throw new IdNotFoundException(id);
        }
    }

    @Override
    public void createUser(User user) {
        try {
            userDAO.createUser(user.getUsername(), user.getEmail());
        } catch (Exception ex) {
            throw new InternalServerError(ex.getMessage());
        }
    }

    @Override
    public void updateUser(Long id, User user) {
        user.setUserId(id);
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        getUserById(id);
        userDAO.deleteUser(id);
    }

}
