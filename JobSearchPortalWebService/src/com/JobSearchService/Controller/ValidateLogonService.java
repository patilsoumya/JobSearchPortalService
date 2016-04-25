
package com.JobSearchService.Controller;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.jobSearch.VO.UserVO;

@Path("/ValidateLogonService")
public class ValidateLogonService {
	
	@Path("/validateUser")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
 
	public Response validateUser(MultivaluedMap<String, String> formParam) throws Exception {
		System.out.println("Inside web service");
		
		return Response.ok().entity("success").build();
		
	}

}
