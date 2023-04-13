package com.ctu.api;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ctu.model.Message;
import com.ctu.services.ProductDemoService;

@Path("/product-demos")
@RequestScoped
@DenyAll

public class ProductDemoAPI {
    private static final Logger logger = LogManager.getLogger(ProductDemoAPI.class);

    @Inject
    ProductDemoService productDemoService;

    // @GET
    // @Path("/")
    // @PermitAll
    // @Produces(MediaType.APPLICATION_JSON)
    // public Response getAllProductTypes() {
    //     logger.info("Get all product type");
    //     return Response.ok(productTypeService.getAllProductTypes()).build();
    // }

    // @PATCH
    // @Path("/{idProduct}")
    // @RolesAllowed({ "manager" })
    // @Consumes(MediaType.APPLICATION_JSON)
    // @Produces(MediaType.APPLICATION_JSON)
    // public Response updateProductType(@PathParam("idProduct") Long idProduct, ProductType type) {
    //     if (!type.isUpdatable()) {
    //         logger.error("Product type has no new key");
    //         Message message = new Message("Product type has no new key");
    //         throw new WebApplicationException(Response.status(400).entity(message).build());
    //     }
    //     productTypeService.updateProductType(id, type);
    //     logger.info("Product type id = " + id + " was updated successfully");
    //     Message message = new Message("Product type was updated successfully");

    //     return Response.ok(message).build();
    // }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({ "manager" })
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProductDemo(@PathParam("id") Long id) {
        productDemoService.deleteProductDemo(id);
        logger.info("ProductDemo " + id + " was deleted successfully");
        Message message = new Message("ProductDemo was deleted successfully");

        return Response.ok(message).build();
    }
}
