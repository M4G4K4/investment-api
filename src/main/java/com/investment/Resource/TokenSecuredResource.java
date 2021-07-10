package com.investment.Resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/secured")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TokenSecuredResource {


    @GET()
    @Path("/nice")
    public String nice() {
        System.out.println("Helo");
        return "asd";
    }
/*

    @Inject
    JsonWebToken jwt;

    @GET()
    @Path("/cenas")
    public String asd(@Context SecurityContext ctx) {
        System.out.println(ctx);
        System.out.println(ctx.getAuthenticationScheme());
        System.out.println(ctx.getUserPrincipal());
        System.out.println(ctx.getUserPrincipal().getName());
        System.out.println(jwt.getGroups());
        System.out.println(jwt);
        System.out.println(jwt.getRawToken());
        System.out.println(jwt.getIssuer());
        return getResponseString(ctx);
    }

    @GET()
    @Path("permit-all")
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@Context SecurityContext ctx) {
        return getResponseString(ctx);
    }

    @GET
    @Path("roles-allowed")
    @RolesAllowed({ "stock:read", "stock:write" })
    @Produces(MediaType.TEXT_PLAIN)
    public String helloRolesAllowed(@Context SecurityContext ctx) {
        return getResponseString(ctx) + ", birthdate: " + jwt.getClaim("birthdate").toString();
    }

    private String getResponseString(SecurityContext ctx) {
        String name;
        if (ctx.getUserPrincipal() == null) {
            name = "anonymous";
        } else if (!ctx.getUserPrincipal().getName().equals(jwt.getName())) {
            throw new InternalServerErrorException("Principal and JsonWebToken names do not match");
        } else {
            name = ctx.getUserPrincipal().getName();
        }
        return String.format("hello + %s,"
                        + " isHttps: %s,"
                        + " authScheme: %s,"
                        + " hasJWT: %s",
                name, ctx.isSecure(), ctx.getAuthenticationScheme(), hasJwt());
    }


    private boolean hasJwt() {
        return jwt.getClaimNames() != null;
    }
    */
}
