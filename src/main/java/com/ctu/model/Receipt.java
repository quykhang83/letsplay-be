package com.ctu.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ctu.utils.TimestampDeserializer;
import com.ctu.utils.TimestampSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity(name = "Receipts")
@Table(name = "Receipts", schema = "PUBLIC")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receiptId")
    private Long receiptId;

    @Column(name = "receiptTax")
    private Float receiptTax;

    @Column(name = "receiptDate")
    @JsonDeserialize(using = TimestampDeserializer.class)
    @JsonSerialize(using = TimestampSerializer.class)
    private Timestamp receiptDate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ReceiptDetails", joinColumns = {
            @JoinColumn(name = "receiptId", nullable = false, updatable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "productId", nullable = false, updatable = false) })
    private List<Product> receiptDetails = new ArrayList<>();

    @Column(name = "receiptTotal")
    private Double receiptTotal;

    public Receipt() {}

    public Receipt(Float receiptTax, Timestamp receiptDate, Double receiptTotal) {
        this.receiptTax = receiptTax;
        this.receiptDate = receiptDate;
        this.receiptTotal = receiptTotal;
    }

    @JsonIgnore
    public boolean isMissingKeys() {
        if (this.receiptTax == null) {
            return true;
        }
        if (this.receiptTotal == null) {
            return true;
        }
        return false;
    }

    @JsonIgnore
    public boolean isUpdatable() {
        if (this.receiptTax != null) {
            return true;
        }
        if (this.receiptTotal != null) {
            return true;
        }
        return false;
    }

    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    public Float getReceiptTax() {
        return receiptTax;
    }

    public void setReceiptTax(Float receiptTax) {
        this.receiptTax = receiptTax;
    }

    public Timestamp getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Timestamp receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Double getReceiptTotal() {
        return receiptTotal;
    }

    public void setReceiptTotal(Double receiptTotal) {
        this.receiptTotal = receiptTotal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Receipt [receiptId=" + receiptId + ", receiptTax=" + receiptTax + ", receiptDate=" + receiptDate
                + ", user=" + user + ", receiptTotal=" + receiptTotal + "]";
    }

    public List<Product> getReceiptDetails() {
        return receiptDetails;
    }

    public void setReceiptDetails(List<Product> receiptDetails) {
        this.receiptDetails = receiptDetails;
    }
    
}
