package com.ctu.exception;

public class NotExitedProductInDiscountException extends Exception {
    public NotExitedProductInDiscountException(String productName) {
        super("The product: " + productName + " is not existed in the discount!");
    }
}
