package com.ctu.dtos;

import com.ctu.model.Product;

public class ProductResponseDiscountDTO {
    private Long productId;
    private Double productPrice;
    private Long productPriceDiscount;

    public ProductResponseDiscountDTO() {
    }

    public ProductResponseDiscountDTO(Product product, Float discountPercent) {
        this.productId = product.getProductId();
        this.productPrice = product.getProductPrice();
        this.productPriceDiscount = (long) (product.getProductPrice()*(1-discountPercent));
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Long getProductPriceDiscount() {
        return productPriceDiscount;
    }

    public void setProductPriceDiscount(Long productPriceDiscount) {
        this.productPriceDiscount = productPriceDiscount;
    }
    
}
