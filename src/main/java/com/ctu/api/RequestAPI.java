package com.ctu.api;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.security.DenyAll;
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

@Path("/requests")
@RequestScoped
@DenyAll
public class RequestAPI {
    private static AtomicInteger eventID = new AtomicInteger(1);
    private static AtomicBoolean isUpdated = new AtomicBoolean(false);
    private static final Logger logger = LogManager.getLogger(RequestAPI.class);

    @Inject
    private RequestService requestService;

    @GET
    @Path("/")
    @RolesAllowed({ "manager", "USER" })
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLeaveRequest() {
        logger.info("Get leave request");
        return Response.ok(requestService.getAllLeaveRequests()).build();
    }

    @GET
    @Path("/search")
    @RolesAllowed({ "manager", "USER" })
    @Produces(MediaType.APPLICATION_JSON)
    public Response seachRequestsByReason(@QueryParam("keywords") String keywords) {
        if (keywords == null) {
            throw new InvalidSearchKeywordException("Keyword must not be null");
        }
        return Response.ok(requestService.seachRequestsByKeywords(keywords)).build();
    }

    @GET
    @Path("/push-subscription")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendPushNotification(@QueryParam("token") String token){
        logger.info("Recieved token: " + token);

        logger.info("Notification was pushed successfully");
        Message message = new Message("Notification was pushed successfully");
        return Response.ok(message).build();
    }


    @GET
    @Path("/ssevent")
    @Produces("text/event-stream")
    public void SSEvent(@Context SseEventSink sseEventSink, @Context Sse sse) throws InterruptedException {
        final OutboundSseEvent event = sse.newEventBuilder()
                .id(String.valueOf(eventID.getAndIncrement()))
                .mediaType(MediaType.TEXT_PLAIN_TYPE)
                .data(String.class, "new request")
                .reconnectDelay(1000)
                .build();
        int count = 0;
        while (true) {
            if (count == 940) {
                final OutboundSseEvent heartBeatEvent = sse.newEventBuilder()
                        .id(String.valueOf(eventID.getAndIncrement()))
                        .mediaType(MediaType.TEXT_PLAIN_TYPE)
                        .data(String.class, "keep alive")
                        .reconnectDelay(500)
                        .build();
                sseEventSink.send(heartBeatEvent);
                sseEventSink.close();
                count = 0;
            }
            count++;
            if (isUpdated.get()) {
                sseEventSink.send(event);
                sseEventSink.close();
                isUpdated.set(false);
                count = 0;
                break;
            }
            Thread.sleep(200);
        }
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createLeaveRequest(Request request) {
        if (request.isMissingKeys()) {
            logger.error("Missing keys in request body");
            Message errMsg = new Message("Missing keys in request body");
            throw new WebApplicationException(Response.status(400).entity(errMsg).build());
        }
        requestService.createLeaveRequest(request);
        logger.info("Request was created successfully");
        Message message = new Message("Request was created successfully");
        isUpdated.set(true);
        // try {
        //     FirebaseMessagingSnippets fbms = new FirebaseMessagingSnippets();
        //     fbms.sendToToken();
        // } catch (FirebaseMessagingException | IOException e) {
        //     e.printStackTrace();
        // }
        return Response.ok(message).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLeaveRequestById(@PathParam("id") Long id) {
        return Response.ok(requestService.getLeaveRequestById(id)).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateRequest(@PathParam("id") Long id, Request request) {
        if (request.isMissingKeys()) {
            logger.error("Request is missing keys");
            Message message = new Message("Request is missing keys");
            throw new WebApplicationException(Response.status(400).entity(message).build());
        }
        requestService.updateRequest(id, request);
        logger.info("Request " + id + " was updated successfully");
        Message message = new Message("Request was updated successfully");
        isUpdated.set(true);
        return Response.ok(message).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteRequest(@PathParam("id") Long id) {
        requestService.deleteRequest(id);
        logger.info("Request " + id + " was deleted successfully");
        Message message = new Message("Request was deleted successfully");
        isUpdated.set(true);
        return Response.ok(message).build();
    }
}
