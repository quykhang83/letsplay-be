package com.ctu.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.ctu.daos.DiscountDAO;
import com.ctu.daos.ProductDAO;
import com.ctu.dtos.DiscountReceiveDTO;
import com.ctu.dtos.DiscountResponseDTO;
import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.ExitedProductInDiscountException;
import com.ctu.exception.IdDiscountNotFoundException;
import com.ctu.exception.InternalServerError;
import com.ctu.exception.NotExitedProductInDiscountException;
import com.ctu.model.Discount;
import com.ctu.model.Product;

@Stateless
public class DiscountServiceImp implements DiscountService {
    @Inject
    DiscountDAO discountDAO;
    @Inject
    ProductDAO productDAO;

    @Override
    public List<Discount> getAllDiscounts() {
        return discountDAO.getAllDiscounts();
    }

    @Override
    public Discount getDiscountById(Long id) {
        if (id < 1) {
            throw new IdDiscountNotFoundException(id);
        }
        try {
            return discountDAO.getDiscountById(id);
        } catch (EmptyEntityException ex) {
            throw new IdDiscountNotFoundException(id);
        }
    }

    @Override
    public void createDiscount(DiscountReceiveDTO payload) {
        Discount discount = new Discount(payload);
        try {
            discountDAO.createDiscount(discount);

        } catch (Exception e) {
            throw new InternalServerError(e.getMessage());
        }
    }

    @Override
    public void updateDiscount(Long discountId, DiscountReceiveDTO payload) throws EmptyEntityException {
        Discount discount = discountDAO.getDiscountById(discountId);
        if (payload.getDiscountName() != null) {
            discount.setDiscountName(payload.getDiscountName());
        }
        if (payload.getDiscountDescription() != null) {
            discount.setDiscountDescription(payload.getDiscountDescription());
        }
        if (payload.getDiscountPercent() != null) {
            discount.setDiscountPercent(payload.getDiscountPercent());
        }
        if (payload.getFromDate() != null) {
            discount.setFromDate(payload.getFromDate());
        }
        if (payload.getToDate() != null) {
            discount.setToDate(payload.getToDate());
        }
        discountDAO.updateDiscount(discount);
    }

    @Override
    public void deleteDiscount(Long id) {
        getDiscountById(id);
        discountDAO.deleteDiscount(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public DiscountResponseDTO getDiscountInfo(Long discountId) {
        Discount discount = new Discount();
        try {
            discount = discountDAO.getDiscountById(discountId);
        } catch (EmptyEntityException e) {
            throw new IdDiscountNotFoundException(discountId);
        }
        DiscountResponseDTO result = new DiscountResponseDTO(discount);
        return result;
    }

    @Override
    public void addProductToDiscount(Long discountId, Long productId)
            throws EmptyEntityException, ExitedProductInDiscountException {
        Product product = productDAO.getProductById(productId);
        discountDAO.addProductToDiscount(discountId, product);
    }

    @Override
    public void removeProductFromDiscount(Long discountId, Long productId)
            throws EmptyEntityException, NotExitedProductInDiscountException {
        Product product = productDAO.getProductById(productId);
        discountDAO.removeProductFromDiscount(discountId, product);
    }

}
