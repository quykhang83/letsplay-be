package com.ctu.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.ctu.dtos.DiscountReceiveDTO;
import com.ctu.utils.TimestampDeserializer;
import com.ctu.utils.TimestampSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity(name = "Discounts")
@Table(name = "Discounts", schema = "PUBLIC")
// @Indexed
public class Discount {

    @Id
    // @DocumentId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discountId")
    private Long discountId;

    @Column(name = "discountName")
    private String discountName;

    @Column(name = "discountPercent")
    private Float discountPercent;

    @Column(name = "discountDescription")
    private String discountDescription;

    @Column(name = "fromDate")
    @JsonDeserialize(using = TimestampDeserializer.class)
    @JsonSerialize(using = TimestampSerializer.class)
    private Timestamp fromDate;

    @Column(name = "toDate")
    @JsonDeserialize(using = TimestampDeserializer.class)
    @JsonSerialize(using = TimestampSerializer.class)
    private Timestamp toDate;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "DiscountDetails", joinColumns = {
            @JoinColumn(name = "discountId", nullable = false, updatable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "productId", nullable = false, updatable = false) })
    private Set<Product> saleProducts = new HashSet<>();

    public Discount() {
    }

    public Discount(String discountName, Float discountPercent, String discountDescription,
            Timestamp fromDate, Timestamp toDate) {
        this.discountName = discountName;
        this.discountPercent = discountPercent;
        this.discountDescription = discountDescription;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public Discount(DiscountReceiveDTO payload) {
        this.discountName = payload.getDiscountName();
        this.discountPercent = payload.getDiscountPercent();
        this.discountDescription = payload.getDiscountDescription();
        this.fromDate = payload.getFromDate();
        this.toDate = payload.getToDate();
    }

    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public Float getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Float discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getDiscountDescription() {
        return discountDescription;
    }

    public void setDiscountDescription(String discountDescription) {
        this.discountDescription = discountDescription;
    }

    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    public Timestamp getToDate() {
        return toDate;
    }

    public void setToDate(Timestamp toDate) {
        this.toDate = toDate;
    }

    public Set<Product> getSaleProducts() {
        return saleProducts;
    }

    public void setSaleProducts(Set<Product> saleProducts) {
        this.saleProducts = saleProducts;
    }

    public boolean addProductToDiscount(Product product) {
        return this.saleProducts.add(product);
    }

    public boolean removeProductFromDiscount(Product product) {
        return this.saleProducts.remove(product);
    } 
}
