package com.ctu.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.ctu.daos.ProductDAO;
import com.ctu.daos.StatusDAO;
import com.ctu.daos.UserDAO;
import com.ctu.dtos.ProductResponseDTO;
import com.ctu.dtos.UserReceiveDTO;
import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.ExitedProductInLibraryException;
import com.ctu.exception.IdNotFoundException;
import com.ctu.exception.InternalServerError;
import com.ctu.exception.NotExitedProductInLibraryException;
import com.ctu.model.Product;
import com.ctu.model.User;

@Stateless
public class UserServiceImp implements UserService {
    @Inject
    UserDAO userDAO;
    @Inject
    StatusDAO statusDAO;
    @Inject
    ProductDAO productDAO;

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
    public User getUserByEmail(String email) throws EmptyEntityException {
        User user = null;

        user = userDAO.getUserByEmail(email);

        return user;
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
    public void updateUser(UserReceiveDTO payload, String email) throws EmptyEntityException {
        User user = userDAO.getUserByEmail(email);
        if (payload.getUserPhone() != null) {
            user.setUserPhone(payload.getUserPhone());
        }
        if (payload.getUserAvt() != null) {
            user.setUserAvt(payload.getUserAvt());
        }
        if (payload.getUserDisplayname() != null) {
            user.setUserDisplayname(payload.getUserDisplayname());
        }
        if (payload.getUserBio() != null) {
            user.setUserBio(payload.getUserBio());
        }
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        getUserById(id);
        userDAO.deleteUser(id);
    }

    @Override
    public void addProductToLibrary(Long productId, String email)
            throws EmptyEntityException, ExitedProductInLibraryException {
        User user = userDAO.getUserByEmail(email);
        Product product = productDAO.getProductById(productId);
        userDAO.addProductToLibrary(user.getUserId(), product);
    }

    @Override
    public void removeProductFromLibrary(Long productId, String email)
            throws EmptyEntityException, NotExitedProductInLibraryException {
        User user = userDAO.getUserByEmail(email);
        Product product = productDAO.getProductById(productId);
        userDAO.removeProductFromLibrary(user.getUserId(), product);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<ProductResponseDTO> getProductsInLibrary(String email) {
        Set<Product> products = new HashSet<Product>();
        List<ProductResponseDTO> results = new ArrayList<ProductResponseDTO>();
        try {
            User user = userDAO.getUserByEmail(email);
            products = user.getLibrary();
        } catch (EmptyEntityException e) {

        }
        products.forEach((e) -> results.add(new ProductResponseDTO(e)));
        return results;
    }

}
