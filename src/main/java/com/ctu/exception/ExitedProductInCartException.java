package com.ctu.exception;

public class ExitedProductInCartException extends Exception {
    public ExitedProductInCartException(String productName) {
        super("The product: " + productName + " already exists in the cart!");
    }
}
