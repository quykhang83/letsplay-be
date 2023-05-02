package com.ctu.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.ExitedProductInDiscountException;
import com.ctu.exception.NotExitedProductInDiscountException;
import com.ctu.model.Discount;
import com.ctu.model.Product;

public class DiscountDAO {
    @PersistenceContext(unitName = "primary")
    EntityManager entityManager;

    public void createDiscount(Discount discount) {
        try {
            entityManager.persist(discount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Discount> getAllDiscounts() {
        List<Discount> discounts = new ArrayList<Discount>();
        try {
            TypedQuery<Discount> query = entityManager.createQuery("FROM Discounts d ORDER by d.discountId",
                    Discount.class);
            discounts = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return discounts;
    }

    public Discount getDiscountById(Long id) throws EmptyEntityException {
        Discount discount = entityManager.find(Discount.class, id);
        if (discount == null) {
            throw new EmptyEntityException(id);
        } else {
            return discount;
        }
    }

    public void deleteDiscount(Long id) {
        try {
            entityManager.remove(entityManager.find(Discount.class, id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateDiscount(Discount discount) {
        try {
            entityManager.merge(discount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addProductToDiscount(Long discountId, Product product) throws ExitedProductInDiscountException {
        try {
            Discount discount = getDiscountById(discountId);
            try {
                if (!discount.addProductToDiscount(product)) {
                    throw new ExitedProductInDiscountException(product.getProductName());
                } else
                    entityManager.merge(discount);
            } catch (ExitedProductInDiscountException e) {
                throw new ExitedProductInDiscountException(product.getProductName());
            }
        } catch (EmptyEntityException e) {
            e.printStackTrace();
        }
    }

    public void removeProductFromDiscount(Long discountId, Product product) throws NotExitedProductInDiscountException {
        try {
            Discount discount = getDiscountById(discountId);
            try {
                if (!discount.removeProductFromDiscount(product)) {
                    throw new NotExitedProductInDiscountException(product.getProductName());
                } else
                    entityManager.merge(discount);
            } catch (NotExitedProductInDiscountException e) {
                throw new NotExitedProductInDiscountException(product.getProductName());
            }
        } catch (EmptyEntityException e) {
            e.printStackTrace();
        }
    }
}
