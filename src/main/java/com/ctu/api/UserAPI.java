package com.ctu.api;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ctu.exception.EmptyEntityException;
import com.ctu.model.Message;
import com.ctu.services.UserService;

@Path("/users")
@RequestScoped
@DenyAll
public class UserAPI {
    private static final Logger logger = LogManager.getLogger(UserAPI.class);

    @Inject
    private UserService userService;

    @GET
    @Path("/")
    @RolesAllowed("manager")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUser() {
        logger.info("Get all users");
        return Response.ok(userService.getAllUsers()).build();

    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("manager")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id") Long id) {
        userService.deleteUser(id);
        logger.info("User " + id + " was deleted successfully");
        Message message = new Message("Manager was deleted successfully");
        return Response.ok(message).build();

    }

    @POST
    @Path("/product/{id}/save")
    @PermitAll
    // @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProductToLibrary(@PathParam("id") Long idProduct) {
        try {
            userService.addProductToLibrary(idProduct);
        } catch (EmptyEntityException e) {
            throw new WebApplicationException(
                    Response.status(400).entity(new Message("Can not add product to library!")).build());
        }
        logger.info("Product " + idProduct + " was added to library");
        Message message = new Message("Product " + idProduct + " was added to library");
        return Response.ok(message).build();
    }

    @GET
    @Path("/library")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsInLibrary() {
        logger.info("Get library");
        return Response.ok(userService.getProductsInLibrary()).build();
    }
}
