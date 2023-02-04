package com.ctu.exception;

public class InvalidStatusNameException extends Exception {
    public InvalidStatusNameException(String statusName) {
        super("Can not find Status with name: " + statusName);
    }
}
