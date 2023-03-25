package com.ctu.exception;

public class InvalidProductTypeNameException extends Exception {
    public InvalidProductTypeNameException(String typeName) {
        super("Can not find ProductType with name: " + typeName);
    }
}
