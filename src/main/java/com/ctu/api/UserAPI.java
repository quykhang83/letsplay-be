package com.ctu.api;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        logger.info("Get all managers");
        return Response.ok(userService.getAllUsers()).build();

    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("manager")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id") Long id) {
        userService.deleteUser(id);
        logger.info("Manager " + id + " was deleted successfully");
        Message message = new Message("Manager was deleted successfully");
        return Response.ok(message).build();

    }
}