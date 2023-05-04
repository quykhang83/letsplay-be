package com.ctu.api;

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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.microprofile.jwt.Claim;

import com.ctu.dtos.UserReceiveDTO;
import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.ExitedProductInCartException;
import com.ctu.exception.ExitedProductInLibraryException;
import com.ctu.exception.NotExitedProductInCartException;
import com.ctu.exception.NotExitedProductInLibraryException;
import com.ctu.model.Message;
import com.ctu.model.User;
import com.ctu.services.UserService;

@Path("/users")
@RequestScoped
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

    @GET
    @Path("/{id}")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserInfoByUserId(@PathParam("id") Long idUser) {
        User user = null;
        user = userService.getUserById(idUser);

        return Response.ok(user).build();
    }

    @PATCH
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(UserReceiveDTO userPayload) {
        if (!userPayload.isUpdatable()) {
            logger.error("User has no new key");
            Message message = new Message("User has no new key");
            throw new WebApplicationException(Response.status(400).entity(message).build());
        }
        try {
            userService.updateUser(userPayload, email);
        } catch (EmptyEntityException e) {
            throw new WebApplicationException(
                    Response.status(400).entity(new Message("User is not valid!")).build());
        }
        logger.info("User " + email + " was updated successfully");
        Message message = new Message("User was updated successfully");
        return Response.ok(message).build();
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

    @GET
    @Path("/library")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsInLibrary() {
        logger.info("Get library");
        return Response.ok(userService.getProductsInLibrary(email)).build();
    }

    @GET
    @Path("/library/{id}")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsInLibraryByUserId(@PathParam("id") Long idUser) {
        logger.info("Get library of user id: " + idUser);
        return Response.ok(userService.getProductsInLibraryByUserId(idUser)).build();
    }

    @POST
    @Path("/library/product/{id}/save")
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
    @Path("/cart")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCartInfo() {
        logger.info("Get cart info");
        return Response.ok(userService.getCartInfo(email)).build();
    }

    @POST
    @Path("/cart/product/{id}/save")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProductToCart(@PathParam("id") Long idProduct) {
        try {
            userService.addProductToCart(idProduct, email);
        } catch (EmptyEntityException e) {
            throw new WebApplicationException(
                    Response.status(400).entity(new Message("The product is not available!")).build());
        } catch (ExitedProductInCartException e) {
            throw new WebApplicationException(
                    Response.status(400).entity(new Message("The product already exists in the cart!")).build());
        }
        logger.info("Product " + idProduct + " was added to cart");
        Message message = new Message("Product " + idProduct + " was added to cart");
        return Response.ok(message).build();
    }

    @POST
    @Path("/cart/product/{id}/remove")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeProductFromCart(@PathParam("id") Long idProduct) {
        try {
            userService.removeProductFromCart(idProduct, email);
        } catch (EmptyEntityException e) {
            throw new WebApplicationException(
                    Response.status(400).entity(new Message("The product is not available!")).build());
        } catch (NotExitedProductInCartException e) {
            throw new WebApplicationException(
                    Response.status(400).entity(new Message("The product is not existed in the cart!")).build());
        }
        logger.info("Product " + idProduct + " was removed from cart");
        Message message = new Message("Product " + idProduct + " was removed from cart");
        return Response.ok(message).build();
    }
}
