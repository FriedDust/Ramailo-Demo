package com.frieddust.ramailodemo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 
 * @author Kailash Bijayananda <fried.dust@gmail.com>
 *
 */
@Path("/test/")
public class Rs {

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public String test() {
		return "kld";
	}
}
