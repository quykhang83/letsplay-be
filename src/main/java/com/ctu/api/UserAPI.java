package com.ctu.api;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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
import org.eclipse.microprofile.jwt.Claim;

import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.ExitedProductInLibraryException;
import com.ctu.exception.NotExitedProductInLibraryException;
import com.ctu.model.Message;
import com.ctu.services.UserService;

@Path("/users")
@RequestScoped
@DenyAll
public class UserAPI {
    private static final Logger logger = LogManager.getLogger(UserAPI.class);

    @Inject
    private UserService userService;
    @Inject
    @Claim("email")
    private String email;

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
    @Path("/library/product/{id}/save")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProductToLibrary(@PathParam("id") Long idProduct) {
        try {
            userService.addProductToLibrary(idProduct, email);
        } catch (EmptyEntityException e) {
            throw new WebApplicationException(
                    Response.status(400).entity(new Message("The product is not available!")).build());
        } catch (ExitedProductInLibraryException e) {
            throw new WebApplicationException(
                    Response.status(400).entity(new Message("The product already exists in the library!")).build());
        }
        logger.info("Product " + idProduct + " was added to library");
        Message message = new Message("Product " + idProduct + " was added to library");
        return Response.ok(message).build();
    }

    @POST
    @Path("/library/product/{id}/remove")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeProductFromLibrary(@PathParam("id") Long idProduct) {
        try {
            userService.removeProductFromLibrary(idProduct, email);
        } catch (EmptyEntityException e) {
            throw new WebApplicationException(
                    Response.status(400).entity(new Message("The product is not available!")).build());
        } catch (NotExitedProductInLibraryException e) {
            throw new WebApplicationException(
                    Response.status(400).entity(new Message("The product is not existed in the library!")).build());
        }
        logger.info("Product " + idProduct + " was removed from library");
        Message message = new Message("Product " + idProduct + " was removed from library");
        return Response.ok(message).build();
    }

    @GET
    @Path("/library")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsInLibrary() {
        logger.info("Get library");
        return Response.ok(userService.getProductsInLibrary(email)).build();
    }
}
