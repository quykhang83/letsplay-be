package com.ctu.api;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

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

import com.ctu.dtos.ProductDTO;
import com.ctu.exception.InvalidSearchKeywordException;
import com.ctu.firebase.FirebaseMessagingSnippets;
import com.ctu.model.Message;
import com.ctu.model.Product;
import com.ctu.model.Request;
import com.ctu.services.ProductService;
import com.ctu.services.RequestService;
import com.google.firebase.messaging.FirebaseMessagingException;

@Path("/products")
public class ProductAPI {
    private static AtomicInteger eventID = new AtomicInteger(1);
    private static AtomicBoolean isUpdated = new AtomicBoolean(false);
    private static final Logger logger = LogManager.getLogger(RequestAPI.class);

    @Inject
    private ProductService productService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {
        logger.info("Get all products");
        return Response.ok(productService.getAllProducts()).build();

    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response seachRequestsByReason(@QueryParam("keywords") String keywords) {
        if (keywords == null) {
            throw new InvalidSearchKeywordException("Keyword must not be null");
        }
        return Response.ok(productService.seachProductsByKeywords(keywords)).build();
    }


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

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createLeaveRequest(ProductDTO productPayload) {
        if (productPayload.isMissingKeys()) {
            logger.error("Missing keys in product body");
            Message errMsg = new Message("Missing keys in product body");
            throw new WebApplicationException(Response.status(400).entity(errMsg).build());
        }
        productService.createProduct(productPayload);
        logger.info("Product was created successfully");
        Message message = new Message("Product was created successfully");
        isUpdated.set(true);

        return Response.ok(message).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLeaveRequestById(@PathParam("id") Long id) {
        System.out.println(productService.getProductById(id));
        return Response.ok(productService.getProductById(id)).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProduct(@PathParam("id") Long id, Product product) {
        if (product.isMissingKeys()) {
            logger.error("Product is missing keys");
            Message message = new Message("Product is missing keys");
            throw new WebApplicationException(Response.status(400).entity(message).build());
        }
        productService.updateProduct(id, product);
        logger.info("Product " + id + " was updated successfully");
        Message message = new Message("Product was updated successfully");
        isUpdated.set(true);
        return Response.ok(message).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProduct(@PathParam("id") Long id) {
        productService.deleteProduct(id);
        logger.info("Product " + id + " was deleted successfully");
        Message message = new Message("Product was deleted successfully");
        isUpdated.set(true);
        return Response.ok(message).build();
    }
}
