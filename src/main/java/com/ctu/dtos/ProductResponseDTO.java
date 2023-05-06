package com.ctu.dtos;

import com.ctu.model.Product;
import com.ctu.model.ProductDemo;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductResponseDTO {
    private Long productId;
    private String productName;
    private Double productPrice;
    private Long productPriceDiscount;
    private String productDescription;
    private String productTypeName;
    private Double productCapacity;
    private Long productDownloads;
    // private List<ProductDemo> productDemos;
    private ProductDemo productDemo;

    public ProductResponseDTO() {
    }

    public ProductResponseDTO(Product product) {
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.productDescription = product.getProductDescription();
        this.productTypeName = product.getProductType().getProductTypeName();
        this.productCapacity = product.getProductCapacity();
        this.productDownloads = product.getProductDownloads();
        // this.productDemos = new ArrayList<ProductDemo>();
        this.productDemo = product.getProductDemos().stream().filter(e -> e.getProductDemoTitle().equals("header"))
                .findFirst().get();
        // this.productDemo = product.getProductDemos().get(0);
        if (product.getDiscounts().isEmpty())
            this.productPriceDiscount = null;
        else
            this.productPriceDiscount = (long) (Math.round(product.getProductPrice())
                    * (1 - product.getDiscounts().get(0).getDiscountPercent()));
    }

    @JsonIgnore
    public boolean isMissingKeys() {
        if (this.productName == null) {
            return true;
        }
        if (this.productPrice == null) {
            return true;
        }
        if (this.productDescription == null) {
            return true;
        }
        // if (this.productTypeName == null) {
        // return true;
        // }
        if (this.productCapacity == null) {
            return true;
        }
        return false;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductCapacity() {
        return productCapacity;
    }

    public void setProductCapacity(Double productCapacity) {
        this.productCapacity = productCapacity;
    }

    public Long getProductDownloads() {
        return productDownloads;
    }

    public void setProductDownloads(Long productDownloads) {
        this.productDownloads = productDownloads;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public ProductDemo getProductDemo() {
        return productDemo;
    }

    public void setProductDemo(ProductDemo productDemo) {
        this.productDemo = productDemo;
    }

    public Long getProductPriceDiscount() {
        return productPriceDiscount;
    }

    public void setProductPriceDiscount(Long productPriceDiscount) {
        this.productPriceDiscount = productPriceDiscount;
    }

}
