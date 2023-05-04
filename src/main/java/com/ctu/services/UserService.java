package com.ctu.services;

import java.util.List;

import com.ctu.dtos.CartResponseDTO;
import com.ctu.dtos.ProductResponseFullDemosDTO;
import com.ctu.dtos.UserReceiveDTO;
import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.ExitedProductInCartException;
import com.ctu.exception.ExitedProductInLibraryException;
import com.ctu.exception.NotExitedProductInCartException;
import com.ctu.exception.NotExitedProductInLibraryException;
import com.ctu.model.User;

public interface UserService {
    public List<User> getAllUsers();

    public User getUserById(final Long id);

    public User getUserByEmail(String email) throws EmptyEntityException;

    public void createUser(User user);

    public void updateUser(UserReceiveDTO payload, String email) throws EmptyEntityException;

    public void deleteUser(Long id);

    public List<ProductResponseFullDemosDTO> getProductsInLibrary(String email);

    public List<ProductResponseFullDemosDTO> getProductsInLibraryByUserId(Long userId);

    public void addProductToLibrary(Long productId, String email) throws EmptyEntityException, ExitedProductInLibraryException;

    public void removeProductFromLibrary(Long productId, String email) throws EmptyEntityException, NotExitedProductInLibraryException;

    public CartResponseDTO getCartInfo(String email);

    public void addProductToCart(Long productId, String email) throws EmptyEntityException, ExitedProductInCartException;

    public void removeProductFromCart(Long productId, String email) throws EmptyEntityException, NotExitedProductInCartException;
}
