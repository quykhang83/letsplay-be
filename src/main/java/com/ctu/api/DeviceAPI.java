package com.ctu.api;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ctu.services.DeviceService;

@Path("/devices")
@RequestScoped
@DenyAll
public class DeviceAPI {
    private static final Logger logger = LogManager.getLogger(DeviceAPI.class);

    @Inject
    private DeviceService deviceService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("manager")
    public Response getAllDevices() {
        logger.info("Get all devices");
        return Response.ok(deviceService.getAllDevices()).build();
    }
}
