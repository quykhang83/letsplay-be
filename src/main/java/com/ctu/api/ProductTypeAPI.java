package com.ctu.api;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.sse.OutboundSseEvent;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseEventSink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ctu.exception.InvalidSearchKeywordException;
import com.ctu.firebase.FirebaseMessagingSnippets;
import com.ctu.model.Message;
import com.ctu.model.Request;
import com.ctu.services.RequestService;
import com.google.firebase.messaging.FirebaseMessagingException;

@Path("/requesttypes")
public class ProductTypeAPI {
    private static final Logger logger = LogManager.getLogger(ProductTypeAPI.class);


    // @GET
    // @Path("/")
    // @RolesAllowed({ "manager", "USER" })
    // @Produces(MediaType.APPLICATION_JSON)
    // public Response getLeaveRequest() {
    //     logger.info("Get leave request");
    //     return Response.ok(requestService.getAllLeaveRequests()).build();
    // }
}
