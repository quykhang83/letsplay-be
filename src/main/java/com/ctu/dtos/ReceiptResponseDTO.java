package com.ctu.dtos;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ctu.model.Receipt;
import com.ctu.utils.TimestampSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class ReceiptResponseDTO {
    private Long receiptId;
    private Float receiptTax;

    @JsonSerialize(using = TimestampSerializer.class)
    private Timestamp receiptDate;

    private Double receiptTotal;
    private List<ProductResponseReceiptDTO> products;

    public ReceiptResponseDTO() {
    }

    public ReceiptResponseDTO(Receipt receipt) {
        this.receiptId = receipt.getReceiptId();
        this.receiptTax = receipt.getReceiptTax();
        this.receiptDate = receipt.getReceiptDate();
        this.receiptTotal = receipt.getReceiptTotal();
        this.products = new ArrayList<ProductResponseReceiptDTO>();
        receipt.getReceiptDetails().forEach((e) -> products.add(new ProductResponseReceiptDTO(e)));
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

    public List<ProductResponseReceiptDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponseReceiptDTO> products) {
        this.products = products;
    }

}
