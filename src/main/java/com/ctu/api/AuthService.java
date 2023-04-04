package com.ctu.api;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.jwt.Claim;

import com.ctu.daos.UserDAO;
import com.ctu.exception.EmptyEntityException;
import com.ctu.model.User;

@Path("/info")
@RequestScoped
public class AuthService {
    // @Inject
    // JsonWebToken jwt;

    @Inject
    @Claim("email")
    private String email;

    @Inject
    @Claim("given_name")
    private String givenName;

    @Inject
    @Claim("family_name")
    private String familyName;

    @Inject
    UserDAO userDAO;

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("manager")
    public Response getUserInfo() {
        String userName = givenName + " " + familyName;
        User user = new User(userName, email);
        return Response.ok(user).build();
    }

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("manager")
    public Response validateUser() {
        User user = null;
        try {
            user = userDAO.getUserByEmail(email);
        } catch (EmptyEntityException e) {
            System.out.println("CREATE NEW MANAGER IN DB WITH EMAIL " + email);
            userDAO.createUser(email, email);
            try {
                user = userDAO.getUserByEmail(email);
            } catch (EmptyEntityException e1) {
            }
        }
        return null;
    }
}
