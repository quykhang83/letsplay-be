package com.ctu.dtos;

import com.ctu.model.Product;
import com.ctu.model.ProductDemo;

public class ProductResponseReceiptDTO {
    private Long productId;
    private String productName;
    private Long productPriceDiscount;
    private ProductDemo productDemo;

    public ProductResponseReceiptDTO() {
    }

    public ProductResponseReceiptDTO(Product product) {
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.productDemo = product.getProductDemos().stream().filter(e -> e.getProductDemoTitle().equals("header"))
                .findFirst().get();
        if (product.getDiscounts().isEmpty())
            this.productPriceDiscount = (long) Math.round(product.getProductPrice());
        else
            this.productPriceDiscount = (long) (Math.round(product.getProductPrice())
                    * (1 - product.getDiscounts().get(0).getDiscountPercent()));
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductPriceDiscount() {
        return productPriceDiscount;
    }

    public void setProductPriceDiscount(Long productPriceDiscount) {
        this.productPriceDiscount = productPriceDiscount;
    }

    public ProductDemo getProductDemo() {
        return productDemo;
    }

    public void setProductDemo(ProductDemo productDemo) {
        this.productDemo = productDemo;
    }

}
