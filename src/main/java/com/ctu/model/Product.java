package com.ctu.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FieldBridge;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.bridge.builtin.DoubleBridge;

import com.ctu.dtos.ProductReceiveDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Products")
@Table(name = "Products", schema = "PUBLIC")
@Indexed
public class Product {
    @Id
    @DocumentId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Long productId;

    @Column(name = "productName")
    @Field(index = Index.YES, store = Store.NO)
    private String productName;

    @Column(name = "productPrice")
    @FieldBridge(impl = DoubleBridge.class)
    @Field
    private Double productPrice;

    @Column(name = "productDescription")
    @Field
    private String productDescription;

    @Column(name = "productDownloads")
    private Long productDownloads;

    @IndexedEmbedded
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productTypeId", nullable = false)
    private ProductType productType;

    @Column(name = "productCapacity")
    @FieldBridge(impl = DoubleBridge.class)
    @Field
    private Double productCapacity;
    
    // @JsonIgnore
    @OneToMany(mappedBy = "product", targetEntity = ProductDemo.class, orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<ProductDemo> productDemos = new HashSet<ProductDemo>();

    @JsonIgnore
    @OneToMany(mappedBy = "product", targetEntity = Comment.class, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "library")
    private Set<User> users = new HashSet<>();


    public Product() {
    }

    public Product(String productName, Double productPrice, String productDescription, ProductType productType, Double productCapacity, Long productDownloads) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productType = productType;
        this.productCapacity = productCapacity;
        this.productDownloads = productDownloads;
    }

    public Product(ProductReceiveDTO payload) {
        this.productName = payload.getProductName();
        this.productPrice = payload.getProductPrice();
        this.productDescription = payload.getProductDescription();
        this.productCapacity = payload.getProductCapacity();
    }

    @JsonIgnore
    public boolean isMissingKeys() {
        if (this.productType == null) {
            return true;
        }
        if (this.productPrice == null) {
            return true;
        }
        if (this.productDescription == null) {
            return true;
        }
        if (this.productCapacity == null) {
            return true;
        }
        return false;

    }

    @JsonIgnore
    public boolean isEmpty() {
        if (this.productType != null) {
            return false;
        }
        if (this.productPrice != null) {
            return false;
        }
        if (this.productDescription != null) {
            return false;
        }
        if (this.productCapacity != null) {
            return false;
        }
        return true;
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

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Long getProductDownloads() {
        return productDownloads;
    }

    public void setProductDownloads(Long productDownloads) {
        this.productDownloads = productDownloads;
    }

    public Double getProductCapacity() {
        return productCapacity;
    }

    public void setProductCapacity(Double productCapacity) {
        this.productCapacity = productCapacity;
    }

    @Override
    public String toString() {
        return "Product [productName=" + productName + ", productPrice=" + productPrice
                + ", productDescription=" + productDescription + ", productDownloads=" + productDownloads
                + ", productType=" + productType + ", productCapacity=" + productCapacity + "]";
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<ProductDemo> getProductDemos() {
        return productDemos;
    }

    public void setProductDemos(Set<ProductDemo> productDemos) {
        this.productDemos = productDemos;
    }

    public void addSingleProductDemo(ProductDemo productDemo){
        this.productDemos.add(productDemo);
        productDemo.setProduct(this);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    
}
