package com.ctu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "ProductDemos")
@Table(name = "ProductDemos", schema = "PUBLIC")
public class ProductDemo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productDemoId")
    private Long productDemoId;

    @Column(name = "productDemoTitle")
    private String productDemoTitle;

    @Column(name = "productDemoUrl")
    private String productDemoUrl;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    public ProductDemo() {}

    public ProductDemo(String productDemoTitle, String productDemoUrl) {
        this.productDemoTitle = productDemoTitle;
        this.productDemoUrl = productDemoUrl;
    }

    public Long getProductDemoId() {
        return productDemoId;
    }

    public void setProductDemoId(Long productDemoId) {
        this.productDemoId = productDemoId;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    
}
