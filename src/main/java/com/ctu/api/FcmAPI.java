package com.ctu.api;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ctu.model.Message;
import com.ctu.services.DeviceService;

@RequestScoped
@Path("/fcm")
public class FcmAPI {
    private static final Logger logger = LogManager.getLogger(FcmAPI.class);
   
    @Inject
    private DeviceService deviceService;

    @GET
    @Path("/push-subscription")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendPushNotification(@QueryParam("username") String username, @QueryParam("token") String token) {
        logger.info("Recieved token: " + token + " from " + username);

        deviceService.createDevice(username, token);

        logger.info("Token of FCM was pushed successfully");
        Message message = new Message("Token of FCM was pushed successfully");
        return Response.ok(message).build();
    }
}
