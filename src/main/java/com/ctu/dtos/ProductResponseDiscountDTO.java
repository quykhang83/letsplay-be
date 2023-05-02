package com.ctu.dtos;

import com.ctu.model.Product;

public class ProductResponseDiscountDTO {
    private Long productId;
    private Long productPrice;

    public ProductResponseDiscountDTO() {
    }

    public ProductResponseDiscountDTO(Product product, Float discountPercent) {
        this.productId = product.getProductId();
        this.productPrice = (long) (product.getProductPrice()*(1-discountPercent));
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }
}
