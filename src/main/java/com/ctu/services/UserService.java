package com.ctu.services;

import java.util.List;

import com.ctu.dtos.ProductResponseDTO;
import com.ctu.exception.EmptyEntityException;
import com.ctu.model.User;

public interface UserService {
    public List<User> getAllUsers();

    public User getUserById(final Long id);

    public User getUserByEmail(String email) throws EmptyEntityException;

    public void createUser(User user);

    public void updateUser(Long id, User user);

    public void deleteUser(Long id);

    public void addProductToLibrary(Long productId) throws EmptyEntityException;

    public List<ProductResponseDTO> getProductsInLibrary();
}
