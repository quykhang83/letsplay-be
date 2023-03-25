package com.ctu.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.ctu.model.Message;

public class InvalidProductTypenameWebException extends WebApplicationException {
    public InvalidProductTypenameWebException(String productType) {
        super(Response.status(400).entity(new Message("Can not find product type: " + productType)).build());
    }
}
