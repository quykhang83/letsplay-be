package com.ctu.api;

import java.security.Principal;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/info")
public class AuthService {
    @Inject
    JsonWebToken jwt;

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("manager")
    public String getUserInfo(@Context SecurityContext ctx) {
        Principal caller = ctx.getUserPrincipal();
        String name = caller == null ? "anonymous" : caller.getName();
        boolean hasJWT = jwt.getClaimNames() != null;
        String email = jwt.getClaim("email");
        String preferred_username = jwt.getClaim("preferred_username");
        String given_name = jwt.getClaim("given_name");
        String family_name = jwt.getClaim("family_name");
        String helloReply = String.format("hello + %s, hasJWT: %s, email: %s, pre_name: %s, given: %s, fami: %s", name,
                hasJWT, email, preferred_username, given_name, family_name);
        return helloReply;
    }
}
