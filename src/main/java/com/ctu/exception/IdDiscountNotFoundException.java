package com.ctu.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.ctu.model.Message;

public class IdDiscountNotFoundException extends WebApplicationException {
    public IdDiscountNotFoundException(Long id) {
        super(Response.status(400).entity(new Message("Discount with id = " + id + " does not exist")).build());
    }
}
