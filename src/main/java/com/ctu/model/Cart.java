package com.ctu.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Carts")
@Table(name = "Carts", schema = "PUBLIC")
public class Cart {
    @Id
    @Column(name = "userId")
    private Long cartId;

    @Column(name = "cartTotal")
    private Long cartTotal;

    @Column(name = "cartPrice")
    private Double cartPrice;

    @OneToOne
    @MapsId
    @JoinColumn(name = "userId")
    private User user;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CartDetails", joinColumns = {
            @JoinColumn(name = "cartId", nullable = false, updatable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "productId", nullable = false, updatable = false) })
    private List<Product> cartDetails = new ArrayList<>();

    public Cart() {
    }

    public Cart(Long cartTotal, Double cartPrice, User user) {
        this.cartTotal = cartTotal;
        this.cartPrice = cartPrice;
        this.user = user;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(Long cartTotal) {
        this.cartTotal = cartTotal;
    }

    public Double getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(Double cartPrice) {
        this.cartPrice = cartPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<Product> cartDetails) {
        this.cartDetails = cartDetails;
    }

    public boolean addProductToCart(Product product) {
        boolean isAdded = !this.cartDetails.contains(product);
        if (isAdded) {
            this.cartDetails.add(product);
            this.cartTotal++;
            if (product.getDiscounts().isEmpty()) this.cartPrice += product.getProductPrice();
            else this.cartPrice += product.getProductPrice() * (1 - product.getDiscounts().get(0).getDiscountPercent());
        }
        return isAdded;
    }

    public boolean removeProductFromCart(Product product) {
        boolean isRemoved = this.cartDetails.remove(product);
        if (isRemoved) {
            this.cartTotal--;
            if (product.getDiscounts().isEmpty()) this.cartPrice -= product.getProductPrice();
            else this.cartPrice -= product.getProductPrice() * (1 - product.getDiscounts().get(0).getDiscountPercent());
        }
        return isRemoved;
    }
    
    public void clearCart() {
        this.cartPrice = 0.0;
        this.cartTotal = 0L;
        this.cartDetails = new ArrayList<>();
    }
}