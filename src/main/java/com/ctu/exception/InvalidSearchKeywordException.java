package com.ctu.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.ctu.model.Message;

public class InvalidSearchKeywordException extends WebApplicationException {
    public InvalidSearchKeywordException(String err) {
        super(Response.status(400).entity(new Message(err)).build());
    }
}
