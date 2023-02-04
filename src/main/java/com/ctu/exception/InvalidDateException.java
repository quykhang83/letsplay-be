package com.ctu.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.ctu.model.Message;

public class InvalidDateException extends WebApplicationException {
    public InvalidDateException(String dateString) {
        super(Response.status(400).entity(new Message("Can not parse date. " + dateString)).build());
    }
}
