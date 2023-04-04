package com.ctu.services;

import java.util.List;

import com.ctu.model.User;

public interface UserService {
    public List<User> getAllUsers();

    public User getUserById(final Long id);

    public void createUser(User user);

    public void updateUser(Long id, User user);

    public void deleteUser(Long id);
}
