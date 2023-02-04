package com.ctu.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.ctu.model.Message;

public class RequestInadequateException extends WebApplicationException {
    public RequestInadequateException() {
        super(Response.status(400).entity(new Message("Missing keys in request body")).build());
    }
}
