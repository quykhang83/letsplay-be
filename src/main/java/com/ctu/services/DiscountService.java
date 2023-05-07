package com.ctu.services;

import java.util.List;

import com.ctu.dtos.DiscountReceiveDTO;
import com.ctu.dtos.DiscountResponseDTO;
import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.ExitedProductInDiscountException;
import com.ctu.exception.NotExitedProductInDiscountException;
import com.ctu.model.Discount;

public interface DiscountService {
    public List<Discount> getAllDiscounts();

    public Discount getDiscountById(final Long id);

    public DiscountResponseDTO createDiscount(DiscountReceiveDTO payload);

    public void updateDiscount(Long discountId, DiscountReceiveDTO payload) throws EmptyEntityException;

    public void deleteDiscount(Long id);

    public DiscountResponseDTO getDiscountInfo(Long discountId);

    public void addProductToDiscount(Long discountId, Long productId) throws EmptyEntityException, ExitedProductInDiscountException;

    public void removeProductFromDiscount(Long discountId, Long productId) throws EmptyEntityException, NotExitedProductInDiscountException;
}
