package com.ctu.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductReceiveDTO {
    private String productName;
    private Double productPrice;
    private String productDescription;
    private String productTypeName;
    private Double productCapacity;
    private String productDemoTitle;
    private String productDemoUrl;

    public ProductReceiveDTO() {
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
        if (this.productDemoTitle != null) {
            return true;
        }
        if (this.productDemoUrl != null) {
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

    public String getProductDemoTitle() {
        return productDemoTitle;
    }

    public void setProductDemoTitle(String productDemoTitle) {
        this.productDemoTitle = productDemoTitle;
    }

    public String getProductDemoUrl() {
        return productDemoUrl;
    }

    public void setProductDemoUrl(String productDemoUrl) {
        this.productDemoUrl = productDemoUrl;
    }

    
}
