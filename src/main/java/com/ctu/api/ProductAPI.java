package com.ctu.api;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
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

import com.ctu.dtos.ProductReceiveDTO;
import com.ctu.exception.InvalidProductTypeNameException;
import com.ctu.exception.InvalidProductTypenameWebException;
import com.ctu.firebase.FirebaseMessagingSnippets;
import com.ctu.model.Message;
import com.ctu.services.ProductService;
import com.google.firebase.messaging.FirebaseMessagingException;

@Path("/products")
@RequestScoped
@DenyAll
public class ProductAPI {
    private static AtomicInteger eventID = new AtomicInteger(1);
    private static AtomicBoolean isUpdated = new AtomicBoolean(false);
    private static final Logger logger = LogManager.getLogger(ProductAPI.class);

    @Inject
    private ProductService productService;

    @GET
    @Path("/")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts(@QueryParam("type") String type) {
        if (type==null) {
            logger.info("Get all products");
            return Response.ok(productService.getAllProducts()).build();
        } else {
            logger.info("Get product with type: " + type);
            return Response.ok(productService.getProductByProductType(type)).build();
        }
    }

    // @GET
    // @Path("/search")
    // @PermitAll
    // @Produces(MediaType.APPLICATION_JSON)
    // public Response seachRequestsByReason(@QueryParam("keywords") String
    // keywords) {
    // if (keywords == null) {
    // throw new InvalidSearchKeywordException("Keyword must not be null");
    // }
    // return Response.ok(productService.seachProductsByKeywords(keywords)).build();
    // }

    @GET
    @Path("/ssevent")
    @Produces("text/event-stream")
    public void SSEvent(@Context SseEventSink sseEventSink, @Context Sse sse) throws InterruptedException {
        final OutboundSseEvent event = sse.newEventBuilder()
                .id(String.valueOf(eventID.getAndIncrement()))
                .mediaType(MediaType.TEXT_PLAIN_TYPE)
                .data(String.class, "new product")
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

    @POST
    @Path("/")
    @RolesAllowed({ "manager" })
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProduct(ProductReceiveDTO productPayload) {
        if (productPayload.isMissingKeys()) {
            logger.error("Missing keys in product body");
            Message errMsg = new Message("Missing keys in product body");
            throw new WebApplicationException(Response.status(400).entity(errMsg).build());
        }
        try {
            productService.createProduct(productPayload);
        } catch (InvalidProductTypeNameException e) {
            throw new InvalidProductTypenameWebException(productPayload.getProductTypeName());
        }
        logger.info("Product was created successfully");
        Message message = new Message("Product was created successfully");
        isUpdated.set(true);

        return Response.ok(message).build();
    }

    @GET
    @Path("/{id}")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductById(@PathParam("id") Long id) {
        logger.info("Get product with id: " + id);
        return Response.ok(productService.getProductById(id)).build();
    }

    // @GET
    // @Path("/")
    // @PermitAll
    // @Produces(MediaType.APPLICATION_JSON)
    // public Response getProductByType(@QueryParam("type") String type) {
    // logger.info("Get product with type: " + type);
    // return Response.ok(productService.getProductByProductType(type)).build();
    // }

    @PATCH
    @Path("/{id}")
    @RolesAllowed({ "manager" })
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProduct(@PathParam("id") Long id, ProductReceiveDTO productPayload) {
        if (!productPayload.isUpdatable()) {
            logger.error("Product has no new key");
            Message message = new Message("Product has no new key");
            throw new WebApplicationException(Response.status(400).entity(message).build());
        }
        productService.updateProduct(id, productPayload);
        logger.info("Product " + id + " was updated successfully");
        Message message = new Message("Product was updated successfully");
        isUpdated.set(true);
        return Response.ok(message).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({ "manager" })
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProduct(@PathParam("id") Long id) {
        productService.deleteProduct(id);
        logger.info("Product " + id + " was deleted successfully");
        Message message = new Message("Product was deleted successfully");
        isUpdated.set(true);
        return Response.ok(message).build();
    }
}
