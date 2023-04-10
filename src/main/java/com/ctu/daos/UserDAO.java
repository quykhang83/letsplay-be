package com.ctu.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.ExitedProductInLibraryException;
import com.ctu.exception.NotExitedProductInLibraryException;
import com.ctu.model.Product;
import com.ctu.model.User;

public class UserDAO {
    @PersistenceContext(unitName = "primary")
    EntityManager entityManager;

    public void createUser(String username, String email) {
        User user = new User(username, email);
        try {
            entityManager.persist(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = null;
        try {
            TypedQuery<User> query = entityManager.createQuery("FROM Users m ORDER by m.userId",
                    User.class);
            users = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public User getUserById(Long id) throws EmptyEntityException {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EmptyEntityException(id);
        } else {
            return user;
        }
    }

    public User getUserByName(String username) {
        User user = null;

        try {
            TypedQuery<User> query = entityManager.createQuery("FROM Users m WHERE m.username = :username",
                    User.class);
            user = query.setParameter("username", username).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public User getUserByEmail(String email) throws EmptyEntityException {
        User user = null;
        try {
            TypedQuery<User> query = entityManager
                    .createQuery("FROM Users m WHERE m.email = :email", User.class);
            user = query.setParameter("email", email).getSingleResult();
        } catch (NoResultException ex) {
            throw new EmptyEntityException(0L);
        }
        return user;
    }

    public void deleteUser(Long id) {
        try {
            entityManager.remove(entityManager.find(User.class, id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            entityManager.merge(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addProductToLibrary(Long userId, Product product) throws ExitedProductInLibraryException{
        try {
            User user = getUserById(userId);
            try {
                if (!user.setSingleProductToLibrary(product)) {
                    throw new ExitedProductInLibraryException(product.getProductName());
                }
                entityManager.merge(user);
            } catch (ExitedProductInLibraryException e) {
                throw new ExitedProductInLibraryException(product.getProductName());
            }
        } catch (EmptyEntityException e) {
            e.printStackTrace();
        }
    }

    public void removeProductFromLibrary(Long userId, Product product) throws NotExitedProductInLibraryException {
        try {
            User user = getUserById(userId);
            try {
                if (!user.unSetSingleProductToLibrary(product)) {
                    throw new NotExitedProductInLibraryException(product.getProductName());
                }
                entityManager.merge(user);
            } catch (NotExitedProductInLibraryException e) {
                throw new NotExitedProductInLibraryException(product.getProductName());
            }
        } catch (EmptyEntityException e) {
            e.printStackTrace();
        }
    }
}
