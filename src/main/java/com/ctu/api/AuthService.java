package com.ctu.api;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.jwt.Claim;

import com.ctu.exception.EmptyEntityException;
import com.ctu.model.User;
import com.ctu.services.UserService;

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
    UserService userService;

    @GET
    @Path("/")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserInfo() {
        User user = null;
        try {
            user = userService.getUserByEmail(email);
        } catch (EmptyEntityException e) {
            System.out.println("CREATE NEW USER IN DB WITH EMAIL " + email);
            user = new User(givenName + " " + familyName, email);
            userService.createUser(user);

            try {
                user = userService.getUserByEmail(email);
            } catch (EmptyEntityException e1) {
                e1.printStackTrace();
            }
        }

        return Response.ok(user).build();
    }

}
