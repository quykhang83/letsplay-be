package com.ctu.exception;

public class NotExitedProductInLibraryException extends Exception {
    public NotExitedProductInLibraryException(String productName) {
        super("The product: " + productName + " is not existed in the library!");
    }
}
