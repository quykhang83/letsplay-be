package com.ctu.dtos;

import java.sql.Timestamp;

import com.ctu.utils.TimestampDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class DiscountReceiveDTO {
    private String discountName;
    private Float discountPercent;
    private String discountDescription;

    @JsonDeserialize(using = TimestampDeserializer.class)
    private Timestamp fromDate;

    @JsonDeserialize(using = TimestampDeserializer.class)
    private Timestamp toDate;

    public DiscountReceiveDTO() {
    }

    @JsonIgnore
    public boolean isMissingKeys() {
        if (this.discountName == null) {
            return true;
        }
        if (this.discountPercent == null) {
            return true;
        }
        if (this.discountDescription == null) {
            return true;
        }
        if (this.fromDate == null) {
            return true;
        }
        if (this.toDate == null) {
            return true;
        }
        return false;
    }
    
    @JsonIgnore
    public boolean isUpdatable(){
        if (this.discountName != null) {
            return true;
        }
        if (this.discountPercent != null) {
            return true;
        }
        if (this.discountDescription != null) {
            return true;
        }
        if (this.fromDate != null) {
            return true;
        }
        if (this.toDate != null) {
            return true;
        }
        return false;
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
    
}
