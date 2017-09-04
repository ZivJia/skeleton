package controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NetIdController {


    @GET
    @Path("/netid")
    public String helloWorld() {
        return "zj74" ;
    }
}
