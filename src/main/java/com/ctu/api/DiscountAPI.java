package com.ctu.api;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ctu.dtos.DiscountReceiveDTO;
import com.ctu.dtos.DiscountResponseDTO;
import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.ExitedProductInDiscountException;
import com.ctu.exception.NotExitedProductInDiscountException;
import com.ctu.model.Message;
import com.ctu.services.DiscountService;

@Path("/discounts")
public class DiscountAPI {
    private static final Logger logger = LogManager.getLogger(DiscountAPI.class);

    @Inject
    private DiscountService discountService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDiscounts() {
        logger.info("Get all discounts");
        return Response.ok(discountService.getAllDiscounts()).build();

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDiscountInfoById(@PathParam("id") Long idDiscount) {
        logger.info("Get sale products");
        return Response.ok(discountService.getDiscountInfo(idDiscount)).build();
    }

    @POST
    @Path("/")
    @RolesAllowed({ "manager" })
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDiscount(DiscountReceiveDTO discountPayload) {
        DiscountResponseDTO result = new DiscountResponseDTO();
        if (discountPayload.isMissingKeys()) {
            logger.error("Missing keys in discount body");
            Message errMsg = new Message("Missing keys in discount body");
            throw new WebApplicationException(Response.status(400).entity(errMsg).build());
        }
        try {
            result = discountService.createDiscount(discountPayload);
        } catch (Exception e) {
            logger.error("Discount cannot be created!");
            Message message = new Message("Discount cannot be created!");
            throw new WebApplicationException(Response.status(400).entity(message).build());
        }
        logger.info("Discount was created successfully");
        // Message message = new Message("Discount was created successfully");

        return Response.ok(result).build();
    }

    @PATCH
    @Path("/{id}")
    @RolesAllowed("manager")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDiscount(@PathParam("id") Long idDiscount, DiscountReceiveDTO discountPayload) {
        if (!discountPayload.isUpdatable()) {
            logger.error("Discount has no new key");
            Message message = new Message("Discount has no new key");
            throw new WebApplicationException(Response.status(400).entity(message).build());
        }
        try {
            discountService.updateDiscount(idDiscount, discountPayload);
        } catch (EmptyEntityException e) {
            throw new WebApplicationException(
                    Response.status(400).entity(new Message("Discount does not exit!")).build());
        }
        logger.info("Discount with id " + idDiscount + " was updated successfully");
        Message message = new Message("Discount was updated successfully");
        return Response.ok(message).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("manager")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDiscount(@PathParam("id") Long id) {
        discountService.deleteDiscount(id);
        logger.info("Discount " + id + " was deleted successfully");
        Message message = new Message("Discount was deleted successfully");
        return Response.ok(message).build();

    }

    @POST
    @Path("/{idDiscount}/save/product/{idProduct}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProductToDiscount(@PathParam("idDiscount") Long idDiscount,
            @PathParam("idProduct") Long idProduct) {
        try {
            discountService.addProductToDiscount(idDiscount, idProduct);
        } catch (EmptyEntityException e) {
            throw new WebApplicationException(
                    Response.status(400).entity(new Message("The product is not available!")).build());
        } catch (ExitedProductInDiscountException e) {
            throw new WebApplicationException(
                    Response.status(400).entity(new Message("The product already exists in the discount!")).build());
        }
        logger.info("Product " + idProduct + " was added to the discount " + idDiscount);
        Message message = new Message("Product " + idProduct + " was added to the discount " + idDiscount);
        return Response.ok(message).build();
    }

    @POST
    @Path("/{idDiscount}/remove/product/{idProduct}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeProductFromDiscount(@PathParam("idDiscount") Long idDiscount,
            @PathParam("idProduct") Long idProduct) {
        try {
            discountService.removeProductFromDiscount(idDiscount, idProduct);
        } catch (EmptyEntityException e) {
            throw new WebApplicationException(
                    Response.status(400).entity(new Message("The product is not available!")).build());
        } catch (NotExitedProductInDiscountException e) {
            throw new WebApplicationException(
                    Response.status(400).entity(new Message("The product is not existed in the discount!")).build());
        }
        logger.info("Product " + idProduct + " was removed from discount " + idDiscount);
        Message message = new Message("Product " + idProduct + " was removed from discount " + idDiscount);
        return Response.ok(message).build();
    }
}
