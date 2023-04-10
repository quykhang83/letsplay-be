package com.ctu.exception;

public class ExitedProductInLibraryException extends Exception {
    public ExitedProductInLibraryException(String productName) {
        super("The product: " + productName + " already exists in the library!");
    }
}
