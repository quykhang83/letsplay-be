package com.ctu.dtos;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ctu.model.Discount;
import com.ctu.utils.TimestampSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class DiscountResponseDTO {
    private Long discountId;
    private String discountName;
    private Float discountPercent;
    private String discountDescription;
    private List<ProductResponseDiscountDTO> products;

    @JsonSerialize(using = TimestampSerializer.class)
    private Timestamp fromDate;

    @JsonSerialize(using = TimestampSerializer.class)
    private Timestamp toDate;

    public DiscountResponseDTO() {
    }

    public DiscountResponseDTO(Discount discount) {
        this.discountId = discount.getDiscountId();
        this.discountName = discount.getDiscountName();
        this.discountPercent = discount.getDiscountPercent();
        this.discountDescription = discount.getDiscountDescription();
        this.products = new ArrayList<ProductResponseDiscountDTO>();
        discount.getSaleProducts()
                .forEach((e) -> this.products.add(new ProductResponseDiscountDTO(e, discount.getDiscountPercent())));
        this.fromDate = discount.getFromDate();
        this.toDate = discount.getToDate();
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

    public List<ProductResponseDiscountDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponseDiscountDTO> products) {
        this.products = products;
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

    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

}
