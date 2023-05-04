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
import com.ctu.daos.UserDAO;
import com.ctu.dtos.CartResponseDTO;
import com.ctu.dtos.ProductResponseFullDemosDTO;
import com.ctu.dtos.UserReceiveDTO;
import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.ExitedProductInCartException;
import com.ctu.exception.ExitedProductInLibraryException;
import com.ctu.exception.IdNotFoundException;
import com.ctu.exception.InternalServerError;
import com.ctu.exception.NotExitedProductInCartException;
import com.ctu.exception.NotExitedProductInLibraryException;
import com.ctu.model.Cart;
import com.ctu.model.Product;
import com.ctu.model.User;

@Stateless
public class UserServiceImp implements UserService {
    @Inject
    UserDAO userDAO;
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
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<ProductResponseFullDemosDTO> getProductsInLibrary(String email) {
        Set<Product> products = new HashSet<Product>();
        List<ProductResponseFullDemosDTO> results = new ArrayList<ProductResponseFullDemosDTO>();
        try {
            User user = userDAO.getUserByEmail(email);
            products = user.getLibrary();
        } catch (EmptyEntityException e) {

        }
        products.forEach((e) -> results.add(new ProductResponseFullDemosDTO(e)));
        return results;
    }

    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<ProductResponseFullDemosDTO> getProductsInLibraryByUserId(Long userId) {
        Set<Product> products = new HashSet<Product>();
        List<ProductResponseFullDemosDTO> results = new ArrayList<ProductResponseFullDemosDTO>();
        try {
            User user = userDAO.getUserById(userId);
            products = user.getLibrary();
        } catch (EmptyEntityException e) {

        }
        products.forEach((e) -> results.add(new ProductResponseFullDemosDTO(e)));
        return results;
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
    public CartResponseDTO getCartInfo(String email) {
        Cart cart = new Cart();
        try {
            User user = userDAO.getUserByEmail(email);
            cart = user.getCart();
        } catch (EmptyEntityException e) {

        }
        
        CartResponseDTO results = new CartResponseDTO(cart);
        return results;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addProductToCart(Long productId, String email)
            throws EmptyEntityException, ExitedProductInCartException {
        User user = userDAO.getUserByEmail(email);
        Product product = productDAO.getProductById(productId);
        userDAO.addProductToCart(user.getUserId(), product);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void removeProductFromCart(Long productId, String email)
            throws EmptyEntityException, NotExitedProductInCartException {
        User user = userDAO.getUserByEmail(email);
        Product product = productDAO.getProductById(productId);
        userDAO.removeProductFromCart(user.getUserId(), product);
    }

}
