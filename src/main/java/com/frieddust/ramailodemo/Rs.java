package com.frieddust.ramailodemo;

import com.frieddust.ramailodemo.pojo.TestObj;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Kailash Bijayananda <fried.dust@gmail.com>
 */
@Path("/test/")
public class Rs {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
        return "kld";
    }

    @GET
    @Path("temp")
    @Produces(MediaType.APPLICATION_JSON)
    public Response temp() {
        return Response.ok().entity(new TestObj("haku", "kale")).build();
    }
}
