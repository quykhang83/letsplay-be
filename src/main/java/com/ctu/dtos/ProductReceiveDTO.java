package com.ctu.dtos;

import com.ctu.model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductReceiveDTO {
    private String productName;
    private Double productPrice;
    private String productDescription;
    private String productTypeName;
    private Double productCapacity;

    public ProductReceiveDTO() {
    }

    public ProductReceiveDTO(Product product) {
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.productDescription = product.getProductDescription();
        this.productTypeName = product.getProductType().getProductTypeName();
        this.productCapacity = product.getProductCapacity();
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
        //     return true;
        // }
        if (this.productCapacity == null) {
            return true;
        }
        return false;
    }
    
    @JsonIgnore
    public boolean isUpdatable(){
        if (this.productName != null) {
            return true;
        }
        if (this.productPrice != null) {
            return true;
        }
        if (this.productDescription != null) {
            return true;
        }
        if (this.productTypeName != null) {
            return true;
        }
        if (this.productCapacity != null) {
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

    
}
