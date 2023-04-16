package com.ctu.exception;

public class InvalidUserCommentException extends Exception {
    public InvalidUserCommentException() {
        super("User does not have permission!");
    }
}
