package com.ctu.services;

import java.util.List;

import com.ctu.dtos.ProductResponseDTO;
import com.ctu.dtos.UserReceiveDTO;
import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.ExitedProductInLibraryException;
import com.ctu.exception.NotExitedProductInLibraryException;
import com.ctu.model.User;

public interface UserService {
    public List<User> getAllUsers();

    public User getUserById(final Long id);

    public User getUserByEmail(String email) throws EmptyEntityException;

    public void createUser(User user);

    public void updateUser(UserReceiveDTO payload, String email) throws EmptyEntityException;

    public void deleteUser(Long id);

    public void addProductToLibrary(Long productId, String email) throws EmptyEntityException, ExitedProductInLibraryException;

    public void removeProductFromLibrary(Long productId, String email) throws EmptyEntityException, NotExitedProductInLibraryException;

    public List<ProductResponseDTO> getProductsInLibrary(String email);
}
