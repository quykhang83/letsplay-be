package com.ctu.api;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
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

import com.ctu.daos.UserDAO;
import com.ctu.dtos.CommentResponseDTO;
import com.ctu.exception.EmptyEntityException;
import com.ctu.exception.InvalidUserCommentException;
import com.ctu.model.Comment;
import com.ctu.model.Message;
import com.ctu.services.CommentService;

@Path("/comments")
@RequestScoped
public class CommentAPI {
    private static final Logger logger = LogManager.getLogger(CommentAPI.class);

    @Inject
    private CommentService commentService;
    @Inject
    private UserDAO userDAO;
    @Inject
    @Claim("email")
    private String email;

    @GET
    @Path("/product/{id}")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCommentsByProductId(@PathParam("id") Long productId) {
        logger.info("Get all comments of product id: " + productId);
        return Response.ok(commentService.getCommentByProductId(productId)).build();
    }

    @POST
    @Path("/product/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createComment(@PathParam("id") Long productId, Comment comment) {
        if (comment.isMissingKeys()) {
            logger.error("Missing keys in comment body");
            Message errMsg = new Message("Missing keys in comment body");
            throw new WebApplicationException(Response.status(400).entity(errMsg).build());
        }
        try {
            try {
                userDAO.getUserByEmail(email);
                commentService.createComment(productId, comment, email);
            } catch (EmptyEntityException e1) {
                logger.error("User is invalid!");
                Message message = new Message("User is invalid!");
                throw new WebApplicationException(Response.status(400).entity(message).build());
            }
        } catch (Exception e) {
            logger.error("Comment cannot be created!");
            Message message = new Message("Comment cannot be created!");
            throw new WebApplicationException(Response.status(400).entity(message).build());
        }
        logger.info("Comment was created successfully");
        Message message = new Message("Comment was created successfully");

        return Response.ok(message).build();
    }

    @GET
    @Path("/{id}")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCommentById(@PathParam("id") Long id) {
        logger.info("Get comment with id: " + id);
        return Response.ok(new CommentResponseDTO(commentService.getCommentById(id))).build();
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateComment(@PathParam("id") Long idComment, Comment comment) {
        if (!comment.isUpdatable()) {
            logger.error("Comment has no new key");
            Message message = new Message("Comment has no new key");
            throw new WebApplicationException(Response.status(400).entity(message).build());
        }
        try {
            userDAO.getUserByEmail(email);
            try {
                commentService.updateComment(idComment, comment, email);
            } catch (InvalidUserCommentException e) {
                throw new WebApplicationException(
                    Response.status(400).entity(new Message("User does not have permission to edit this comment!")).build());
            }
        } catch (EmptyEntityException e1) {
            logger.error("User is invalid!");
            Message message = new Message("User is invalid!");
            throw new WebApplicationException(Response.status(400).entity(message).build());
        }

        logger.info("Comment " + idComment + " was edited successfully");
        Message message = new Message("Comment was edited successfully");
        return Response.ok(message).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteComment(@PathParam("id") Long id) {
        try {
            userDAO.getUserByEmail(email);
            try {
                commentService.deleteComment(id, email);
            } catch (InvalidUserCommentException e) {
                throw new WebApplicationException(
                    Response.status(400).entity(new Message("User does not have permission to delete this comment!")).build());
            }
        } catch (EmptyEntityException e1) {
            logger.error("User is invalid!");
            Message message = new Message("User is invalid!");
            throw new WebApplicationException(Response.status(400).entity(message).build());
        }

        logger.info("Comment " + id + " was deleted successfully");
        Message message = new Message("Comment was deleted successfully");
        return Response.ok(message).build();
    }
}
