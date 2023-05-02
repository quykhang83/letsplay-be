package com.ctu.api;

import javax.annotation.security.PermitAll;
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
import org.eclipse.microprofile.jwt.Claim;

import com.ctu.daos.UserDAO;
import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.InvalidUserCommentException;
import com.ctu.model.Message;
import com.ctu.services.ReceiptService;

@Path("/receipts")
@RequestScoped
public class ReceiptAPI {
    private static final Logger logger = LogManager.getLogger(ReceiptAPI.class);

    @Inject
    private ReceiptService receiptService;
    @Inject
    private UserDAO userDAO;
    @Inject
    @Claim("email")
    private String email;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllReceiptsByUser() {
        logger.info("Get all receipt of user: " + email);
        return Response.ok(receiptService.getReceiptByUser(email)).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createReceipt() {
        try {
            try {
                userDAO.getUserByEmail(email);
                receiptService.createReceipt(email);
            } catch (EmptyEntityException e1) {
                logger.error("User is invalid!");
                Message message = new Message("User is invalid!");
                throw new WebApplicationException(Response.status(400).entity(message).build());
            }
        } catch (Exception e) {
            logger.error("Receipt cannot be created!");
            Message message = new Message("Receipt cannot be created!");
            throw new WebApplicationException(Response.status(400).entity(message).build());
        }
        logger.info("Receipt was created successfully");
        Message message = new Message("Receipt was created successfully");

        return Response.ok(message).build();
    }

    @GET
    @Path("/{id}")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReceiptById(@PathParam("id") Long id) {
        logger.info("Get receipt with id: " + id);
        return Response.ok(receiptService.getReceiptById(id)).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteReceipt(@PathParam("id") Long id) {
        try {
            userDAO.getUserByEmail(email);
            try {
                receiptService.deleteReceipt(id, email);
            } catch (InvalidUserCommentException e) {
                throw new WebApplicationException(
                    Response.status(400).entity(new Message("User does not have permission to delete this receipt!")).build());
            }
        } catch (EmptyEntityException e1) {
            logger.error("User is invalid!");
            Message message = new Message("User is invalid!");
            throw new WebApplicationException(Response.status(400).entity(message).build());
        }

        logger.info("Receipt " + id + " was deleted successfully");
        Message message = new Message("Receipt was deleted successfully");
        return Response.ok(message).build();
    }
}
