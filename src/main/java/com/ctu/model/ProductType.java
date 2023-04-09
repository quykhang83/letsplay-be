package com.ctu.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.search.annotations.Indexed;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "ProductTypes")
@Table(name = "ProductTypes", schema = "PUBLIC")
@Indexed
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productTypeId")
    private Long productTypeId;

    @Column(name = "productTypeName")
    private String productTypeName;

    @Column(name = "productTypeDescription")
    private String productTypeDescription;

    @JsonIgnore
    @OneToMany(mappedBy = "productType", targetEntity = Product.class, fetch = FetchType.LAZY, orphanRemoval = false, cascade = CascadeType.DETACH)
    private Set<Product> product;

    public ProductType() {
    }

    public ProductType(String productTypeName, String productTypeDescription) {
        this.productTypeName = productTypeName;
        this.productTypeDescription = productTypeDescription;
    }

    @JsonIgnore
    public boolean isMissingKeys() {
        if (this.productTypeName == null) {
            return true;
        }
        if (this.productTypeDescription == null) {
            return true;
        }
        return false;

    }

    @JsonIgnore
    public boolean isEmpty() {
        if (this.productTypeName != null) {
            return false;
        }
        if (this.productTypeDescription != null) {
            return false;
        }
        return true;
    }

    @JsonIgnore
    public boolean isUpdatable() {
        if (this.productTypeName != null) {
            return true;
        }
        if (this.productTypeDescription != null) {
            return true;
        }
        return false;
    }

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getProductTypeDescription() {
        return productTypeDescription;
    }

    public void setProductTypeDescription(String productTypeDescription) {
        this.productTypeDescription = productTypeDescription;
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }
    
}
