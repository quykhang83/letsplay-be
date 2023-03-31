package com.ctu.api;

import java.io.IOException;
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
import com.ctu.model.ProductType;
import com.ctu.model.Request;
import com.ctu.services.ProductTypeService;
import com.ctu.services.RequestService;
import com.google.firebase.messaging.FirebaseMessagingException;

@Path("/product-types")
@RequestScoped
@DenyAll
public class ProductTypeAPI {
    private static final Logger logger = LogManager.getLogger(ProductTypeAPI.class);

    @Inject
    ProductTypeService productTypeService;

    @GET
    @Path("/")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProductTypes() {
        logger.info("Get all product type");
        return Response.ok(productTypeService.getAllProductTypes()).build();
    }

    @POST
    @Path("/")
    @RolesAllowed({ "manager" })
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProductType(ProductType productType) {
        if (productType.isMissingKeys()) {
            logger.error("Missing keys in product type body");
            Message errMsg = new Message("Missing keys in product type body");
            throw new WebApplicationException(Response.status(400).entity(errMsg).build());
        }
        productTypeService.createProductType(productType);
        logger.info("ProductType was created successfully");
        Message message = new Message("ProductType was created successfully");

        return Response.ok(message).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({ "manager" })
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProductType(@PathParam("id") Long id) {
        productTypeService.deleteProductType(id);
        logger.info("ProductType " + id + " was deleted successfully");
        Message message = new Message("ProductType was deleted successfully");

        return Response.ok(message).build();
    }
}
