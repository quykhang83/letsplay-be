package com.ctu.exception;

public class NotExitedProductInCartException extends Exception {
    public NotExitedProductInCartException(String productName) {
        super("The product: " + productName + " is not existed in the cart!");
    }
}
