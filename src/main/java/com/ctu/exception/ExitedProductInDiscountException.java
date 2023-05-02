package com.ctu.exception;

public class ExitedProductInDiscountException extends Exception {
    public ExitedProductInDiscountException(String productName) {
        super("The product: " + productName + " already exists in the discount!");
    }
}
